var router = require('express').Router()
//http://localhost:3000/customers/register
router.post('/register', async (req, res) => {
    const { name, email, password} = req.body
    i18n.setLocale(req.headers.locale)   
    res.json({
        result: "ok",
        data: {},
        message: "Register Customer successfully",
        time: Date.now()
    })
  })
  module.exports = router