import { User } from "../models/index.js"
import bcrypt from 'bcrypt'
import jwt from 'jsonwebtoken'

const login = async ({email, password}) => {
    try {
        // let students = await Student.find().exec()
        // return students
        debugger
        let existingUser = await User.findOne({email}).exec()
        if(existingUser) {
             let isMatch = await bcrypt.compare(password, existingUser.password)   
             if(!!isMatch) {
                debugger
                //generate Java Web Token
                let token = jwt.sign({                    
                    data: existingUser
                  }, 
                  process.env.JWT_SECRET, 
                  {
                    //expiresIn: '60',
                    expiresIn: '2 days',
                  })                  
                  return {...existingUser, token: token} //clone an object
             } else {
                throw new Error('Wrong email or password')    
             }
        } else {
            throw new Error('Wrong email or password')
        }
    }catch(error) {
        print('Cannot students from DB'+error)        
        throw new Error('Cannot students from DB'+error)
    }
}

const register = async ({
    name, 
    email, 
    password, 
    phoneNumber,
    address
}) => {
    try {        
        let existingUser = await User.findOne({email}).exec()
        if(existingUser) {
            throw new Error("User exists, cannot register")
        }         
        let hashedPassword = await bcrypt.hash(password, parseInt(process.env.SALT_ROUNDS));
        let newUser = await User
                        .create({name, email, password: hashedPassword, phoneNumber,address})                
        //send email confirm: tao them request GET de active                
        return newUser        
    }catch(error) {
        debugger        
        if(!!error.errors) {
            //loi do validation
            throw new Error(error.errors)
        } else {
            //loi do db
            print('Cannot register new user'+error)        
            throw new Error('Cannot register new user'+error)
        }
    }
}

export default {
    login,
    register    
}