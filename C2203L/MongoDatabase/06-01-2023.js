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

db.students.insertOne({
    studentName: 'Nguyen Van A',
    email: 'nguyenan@gmail.com',    
    dob: new Date('1993-12-23')
})
db.students.insertOne({
    studentName: 'Alab',
    email: 'nkak@gmail.com',    
    dob: new Date('2000-12-11')
})

db.enrolllents.insertMany([
    {
        studentID: ObjectId('63b8092d9cd63f4fa75d1de6'),
        courseID: ObjectId('63b580a062dd1fda779fca20'),
        grade: 'A',
        remarks: 'This is good'
    },
    {
        studentID: ObjectId('63b809559cd63f4fa75d1de7'),
        courseID: ObjectId('63b80a129cd63f4fa75d1de8'),
        grade: 'A',
        remarks: 'This is good'
    }
])

db.enrolllents.find({
    $and: [
        {
            studentID: ObjectId('63b809559cd63f4fa75d1de7'),
        },
        {
            courseID: ObjectId('63b80a129cd63f4fa75d1de8'),
        }        
    ]
})
db.enrolllents.find({
    studentID: ObjectId('63b809559cd63f4fa75d1de7'),
    courseID: ObjectId('63b80a129cd63f4fa75d1de8'),
})
db.enrolllents.updateMany({
    studentID: ObjectId('63b809559cd63f4fa75d1de7'),
    courseID: ObjectId('63b80a129cd63f4fa75d1de8'),
},{
    $set: {
        remarks: 'This is ok',
        grade: 'C'
    }
})

db.enrolllents.find()
db.enrolllents.aggregate([
    {
        $lookup: {
            from: "students",
            localField: "studentID",
            foreignField: "_id",
            as: "studentDetails",
        },        
    },
    {
        $unwind: {
          path: "$studentDetails",
          preserveNullAndEmptyArrays: false
        }
    },
    {
        $lookup: {
            from: "courses",
            localField: "courseID",
            foreignField: "_id",
            as: "courseDetails",
        },
    },
    {
        $unwind: {
          path: "$courseDetails",
          preserveNullAndEmptyArrays: false
        }
    },
])
db.students.insertOne({
    studentName: 'Binh An',
    email: 'binhan@gmail.com',
    dob: new Date('1996-12-11')
})
db.students.aggregate([
    {
        $sort: {
            studentName: 1
        }
    }
])
db.students.aggregate([
    {
        $match: {
            email: 'nkak@gmail.com'
        }
    },
    {
        $project: {
            _id: 0,
            email: 1,
            studentName: 1
        }
    },
    {
        $limit: 1
    }
])

