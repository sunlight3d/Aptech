db.createCollection("roles");
db.roles.createIndex({ name: 1 }, { unique: true });
db.createCollection("users", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["id", "phone_number", "password"],
      properties: {        
        fullname: {
          bsonType: "string",
          maxLength: 100
        },
        phone_number: {
          bsonType: "string",
          minLength: 1,
          maxLength: 20
        },
        address: {
          bsonType: "string",
          maxLength: 200
        },
        password: {
          bsonType: "string",
          minLength: 1,
          maxLength: 32
        },
        role_id: {
          bsonType: "objectId"
        },
        created_at: {
          bsonType: "date"
        },
        updated_at: {
          bsonType: "date"
        },
        deleted: {
          bsonType: "int"
        }
      }
    }
  }
});


db.users.insertMany([
  {
    id: 1,
    phone_number: "123456789",
    password: "password1",
    fullname: "John Doe",
    address: "123 Street, City",
    role_id: db.roles.findOne({name: 'admin'})._id,
    created_at: new Date(),
    updated_at: new Date(),
    deleted: 0
  },
  {
    id: 2,
    phone_number: "987654321",
    password: "password2",
    fullname: "Jane Smith",
    address: "456 Road, Town",
    role_id: db.roles.findOne({name: 'user'})._id,
    created_at: new Date(),
    updated_at: new Date(),
    deleted: 0
  },
  {
    id: 3,
    phone_number: "555555555",
    password: "password3",
    fullname: "Bob Johnson",
    address: "789 Avenue, Village",
    role_id: db.roles.findOne({name: 'user'})._id,
    created_at: new Date(),
    updated_at: new Date(),
    deleted: 0
  }
]);

db.createCollection("categories", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["name"],
      properties: {        
        name: {
          bsonType: "string",
          maxLength: 100
        }
      }
    }
  }
});

// Tạo chỉ mục duy nhất trên trường "name"
db.categories.createIndex({ name: 1 }, { unique: true });


db.createCollection("products", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["category_id", "thumbnail"],
      properties: {        
        category_id: {
          bsonType: "objectId"
        },
        title: {
          bsonType: "string",
          maxLength: 350
        },
        price: {
          bsonType: "int"
        },
        discount: {
          bsonType: "int"
        },
        thumbnail: {
          bsonType: "string",
          maxLength: 500
        },
        description: {
          bsonType: "string",
          maxLength: 2147483647
        },
        created_at: {
          bsonType: "date"
        },
        updated_at: {
          bsonType: "date"
        }
      }
    }
  }
});

db.products.insertMany([
  {

    id: 1,
    category_id: db.categories.findOne({name: 'Đồ điện tử'})?._id,
    title: "Product 1",
    price: 100,
    discount: 10,
    thumbnail: "thumbnail1.jpg",
    description: "Description for Product 1",
    created_at: new Date(),
    updated_at: new Date()
  },
  {
    id: 2,
    category_id: db.categories.findOne({name: 'Bánh kẹo'})?._id,
    title: "Product 2",
    price: 200,
    discount: 20,
    thumbnail: "thumbnail2.jpg",
    description: "Description for Product 2",
    created_at: new Date(),
    updated_at: new Date()
  },
  // Các sản phẩm khác...
  {
    id: 10,
    category_id: db.categories.findOne({name: 'Bánh kẹo'})?._id,
    title: "Product 10",
    price: 1000,
    discount: 100,
    thumbnail: "thumbnail10.jpg",
    description: "Description for Product 10",
    created_at: new Date(),
    updated_at: new Date()
  }
]);

//kiểu tree
db.categories.aggregate([
  {
    $lookup: {
      from: "products",
      localField: "_id",
      foreignField: "category_id",
      as: "products"
    }
  }
]);

//kiểu flat, unwind
db.categories.aggregate([
  {
    $lookup: {
      from: "products",
      localField: "_id",
      foreignField: "category_id",
      as: "products"
    }
  },
  {
    $unwind: "$products"
  }
]);

db.createCollection("orders", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["id", "user_id", "email", "address", "status"],
      properties: {        
        user_id: {
          bsonType: "objectId"
        },
        fullname: {
          bsonType: "string",
          maxLength: 100
        },
        email: {
          bsonType: "string",
          maxLength: 150,
          description: "Must be a valid email address",
          pattern: "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
        },
        phone_number: {
          bsonType: "string",
          maxLength: 20
        },
        address: {
          bsonType: "string",
          maxLength: 200
        },
        note: {
          bsonType: "string",
          maxLength: 200
        },
        order_date: {
          bsonType: "date"
        },
        status: {
          bsonType: "string",
          enum: ["pending", "processing", "completed", "cancelled"],
          description: "Must be one of the following values: pending, processing, completed, cancelled"
        },
        total_money: {
          bsonType: "int"
        }
      }
    }
  }
});


db.createCollection("orders", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["id", "user_id", "email", "address", "status"],
      properties: {
        id: {
          bsonType: "int"
        },
        user_id: {
          bsonType: "objectId"
        },
        fullname: {
          bsonType: "string",
          maxLength: 100
        },
        email: {
          bsonType: "string",
          maxLength: 150,
          description: "Must be a valid email address",
          pattern: "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
        },
        phone_number: {
          bsonType: "string",
          maxLength: 20
        },
        address: {
          bsonType: "string",
          maxLength: 200
        },
        note: {
          bsonType: "string",
          maxLength: 200
        },
        order_date: {
          bsonType: "date"
        },
        status: {
          bsonType: "string",
          enum: ["pending", "processing", "completed", "cancelled"],
          description: "Must be one of the following values: pending, processing, completed, cancelled"
        },
        total_money: {
          bsonType: "int"
        }
      }
    }
  }
});





