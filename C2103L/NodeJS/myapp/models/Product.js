const { DataTypes } = require('sequelize');
//ALTER TABLE product ADD description TEXT;
//ALTER TABLE product ADD id INT PRIMARY KEY AUTO_INCREMENT;
module.exports = (sequelize) => {
  const Product = sequelize.define('Product', {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true
    },
    name: {
      type: DataTypes.STRING(100),
      allowNull: false,
      validate: {
        len: [4, 100]
      }    
    },
    price: {
      type: DataTypes.FLOAT,
      allowNull: false,
      validate: {
        min: 0
      }
    },
    amount: {
      type: DataTypes.INTEGER,
      allowNull: false,
      defaultValue: 1,
      validate: {
        min: 1
      }
    },
    description: {
      type: DataTypes.TEXT,
      allowNull: false,      
    },
  }, {
    tableName: 'product',
    timestamps: false
  });
  return Product;
};