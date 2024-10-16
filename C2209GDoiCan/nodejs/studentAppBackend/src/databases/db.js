// db.js
const mongoose = require('mongoose');

const connectDB = async () => {
  try {
    // Attempt to connect to the database    
    //const uri = 'mongodb://root:Abc123456789@localhost:27019/c2209gdoican';
    const uri = 'mongodb://root:Abc123456789@localhost:27019/c2209gdoican?authSource=admin';
    const conn = await mongoose.connect(uri, {
        socketTimeoutMS: 1000
    });
    //debugger
    console.log(`MongoDB Connected: ${conn.connection.host}`);
  } catch (err) {
    console.error(`Error connecting to MongoDB: ${err.message}`);
  }
};

// Periodically check the connection status and attempt reconnection if needed
const checkAndReconnect = () => {
  console.log('Checking mongodb connection...');
  if (mongoose.connection?.readyState === 0) { // 0: disconnected, 1: connected, 2: connecting, 3: disconnecting
    console.log('Attempting to reconnect to MongoDB...');
    connectDB();
  } else {
    console.log('Connection still ok');
  }
};

// Check connection status and attempt reconnection every 5 seconds
setInterval(checkAndReconnect, 5000);

// Export the connectDB function
module.exports = connectDB;
