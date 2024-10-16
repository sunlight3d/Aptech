const express = require('express')
const app = express()
const router = app.router
const options = {
    dotfiles: 'ignore',
    etag: false,
    extensions: ['htm', 'html'],
    index: false,
    maxAge: '1d',
    redirect: false,
    setHeaders (res, path, stat) {
      res.set('x-timestamp', Date.now())
    }
  }
let products = [
    {
        category: 'Food222',
        description: 'This is test',
        price: 12.3,
        quantity: 5,
    },
    {
        category: 'Electronics',
        description: 'This is m,fdkjfttest',
        price: 22.3,
        quantity: 21,
    },
    {
        category: 'Abcdd',
        description: 'Thfdfdis is test',
        price: 33.3,
        quantity: 34,
    }
]  
  router.get('/categories', (req, res) => {
    
    // const {x, y} = req.query
    // console.log(`x = ${x}, y = ${y}`)
    debugger
    res.json({
        "categories": products
    })
  })
  app.use(express.static('public', options))
  const PORT = 9001
  app.listen(PORT, ()=> {
    console.log(`Server is listening on ${PORT}`)
  })