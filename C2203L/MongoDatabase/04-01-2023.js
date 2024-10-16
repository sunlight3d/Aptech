//use testdb
db.courses.insertOne({
    title: 'Java programming language',
    credits: 15,
    startDate: new Date("2023-01-15") 
})

db.courses.insertOne({
    title: 'C# programming with winform',
    credits: 20
})
db.courses.insertMany([
    {
        title: 'Python 3 for ML',
        credits: 25
    },
    {
        title: 'Html5',
        credits: 21
    }  
])

db.courses.find()
db.courses.find({_id: ObjectId("63b5722762dd1fda779fca1c")})
db.courses.find().size()

db.courses.updateOne(
    {_id: ObjectId("63b5722762dd1fda779fca1c")},
    {
        $set: {
            credits: 17
        }
    },   
    {
        upsert: true //insert new if not found
    } 
)
db.courses.deleteOne({
    _id: ObjectId("63b5722762dd1fda779fca1b")
})
db.courses.find({}, {
    _id: 0,
    title: 1,    
    credits: 1
})
//constraint & create table => Schema Validation
db.createCollection("courses", {
    validator: {
       $jsonSchema: {
          bsonType: "object",
          title: "Course Object Validation",
          required: [ "title", "credits"],
          properties: {
             title: {
                bsonType: "string",
                description: "'title' must be a string and is required"
             },
             credits: {
                bsonType: "int",
                minimum: 3,
                maximum: 50,
                description: "'credits' must be an integer in [ 3, 50 ] and is required"
             },
             startDate: {
                bsonType: [ "date" ],
                description: "'startDate' must be Date if the field exists"
             },
             price: {
                bsonType: [ "double" ],
                description: "'price' must be double if the field exists"
             }
          }
       }
    }
 } 
)
db.courses.drop()
//Get detail schema
db.getCollectionInfos( { name: "courses" } )
//Get detail validator of a schema
db.getCollectionInfos( { name: "courses" } )[0].options.validator
//Describe more detail:
db.getCollectionInfos( { name: "courses" } )[0].options.validator['$jsonSchema'] 

db.courses.insertOne({
    title: 'Java2 programming language',
    credits: 60,
    startDate: new Date("2023-01-15") 
})
//create constraints => update schema validation
db.runCommand( { collMod: "courses",
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: [ "credits" ],
         properties: {
            credits: {
                bsonType: "int",
                minimum: 3,
                maximum: 100,
                description: "'credits' must be an integer in [ 3, 100 ] and is required"
             },
         }
      }
   }
} )