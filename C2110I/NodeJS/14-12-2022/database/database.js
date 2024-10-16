import mongoose from 'mongoose'
import { OutputType, print } from '../helper/print.js'
mongoose.set('strictQuery', true)
const connectionString = "mongodb+srv://hoangnd:Abc123456789@cluster0.ktfzfqy.mongodb.net/?retryWrites=true&w=majority"
const connect = async () => {  
    try {
        await mongoose.connect(connectionString)  
        debugger      
        print('connect DB successfully', OutputType.SUCCESS)
    } catch (error) {
        print("Cannot connect DB:"+error, OutputType.ERROR)
        throw new Exception("Cannot connect DB:"+error)
    }
}
connect()
export default connect
