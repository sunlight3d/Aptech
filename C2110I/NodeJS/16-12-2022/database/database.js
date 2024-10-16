import mongoose from 'mongoose'
import { OutputType, print } from '../helper/print.js'

mongoose.set('strictQuery', true)
const connectionString = 'mongodb+srv://hoangnd:Abc123456789@cluster0.ktfzfqy.mongodb.net/c2110i?retryWrites=true&w=majority'
let errorMessage = ''
const connect = async () => {  
    try {
        let connection = await mongoose.connect(connectionString)                     
        print('connect DB successfully', OutputType.SUCCESS)
        return connection
    } catch (error) {
        debugger
        /*
        if(error.code == 8000) {
            errorMessage = 'Wrong username or password when connect to DB'            
        } else if(error.code == 'ENOTFOUND') {
            errorMessage = 'Invalid hostname'
        }else {
            errorMessage = "Cannot connect DB:"+error
        } 
        */  
        //shorter
        errorMessage = error.code == 8000 ? 'Wrong username or password when connect to DB' : 
                                        (error.code == 'ENOTFOUND' ? 'Invalid hostname' : 
                                            "Cannot connect DB:"+error)
        print(errorMessage, OutputType.ERROR)
        throw new Error(errorMessage)             
        
    }
}
//connect()
export default connect
