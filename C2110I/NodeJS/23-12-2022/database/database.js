import mongoose from 'mongoose'
import { OutputType, print } from '../helper/print.js'
mongoose.set('strictQuery', true)
let errorMessage = ''
const connect = async () => {  
    try {        
        let connection = await mongoose.connect(process.env.MONGODB_URL)                     
        print('connect DB successfully', OutputType.SUCCESS)        
        print(process.env.MONGODB_URL, OutputType.INFORMATION)
        return connection
    } catch (error) {        
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
