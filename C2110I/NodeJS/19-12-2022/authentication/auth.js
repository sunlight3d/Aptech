const checkToken = (req, res, next) => {
    debugger
    //bypass login, register
    const isLoginOrRegisterRouter = req.url.toLowerCase() == '/users/login' ||
                        req.url.toLowerCase() == '/users/register'
    if(isLoginOrRegisterRouter) {
        next()
        return
    }
    //validate token
    let token = req.headers
    next()
}
export default checkToken