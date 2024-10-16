import jwt from 'jsonwebtoken'
import { ObjectId, Schema } from "mongoose"
import { User } from "../models/index.js"
const checkToken = async (req, res, next) => {    
    //bypass login, register
    const isLoginOrRegisterRouter = req.url.toLowerCase() == '/users/login' ||
                        req.url.toLowerCase() == '/users/register'
    debugger
    if(isLoginOrRegisterRouter) {
        next()
        return
    }
    //validate token
    let token = req.headers.authorization?.split(" ")[1]
    try {
        let jwtObject = jwt.verify(token, process.env.JWT_SECRET);    
        const {data, iat, exp} = jwtObject
        req.user = data
        next()
    }catch(error) {
        res.json({            
            message: error.message,            
        })        
    }
}
export default checkToken