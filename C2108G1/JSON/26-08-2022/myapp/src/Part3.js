import { Button } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import './Part3.css'
import { useState } from 'react'
function Part3(props) {
    //useState is called "Hook"
    const [typedText, setTypedText] = useState("")
    const [filteredProducts, setFilteredProducts] = useState([])
    const [products, setProducts] = useState([
        {
            category: 'Food',
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
    ])
    const [cart, setCart] = useState({})
    //calculated value
    function getTotal() {
        let total = 0
        for(let key in cart) {
            debugger
            const categoryName = key
            const quantity = parseInt(cart[categoryName])
            //get categoryObject from category Name
            const product = products
                            .filter(item => item.category == categoryName)[0]                        
            total += (product?.price ?? 0) * quantity
        }
        return total.toFixed(2)
    }
    return <div>        
        <p>Filtering input: </p>
        <input onChange={(event) => {            
            let typedText = event.target.value ?? ""
            setTypedText(typedText)            
            setFilteredProducts(products.filter(product => product.category.toLowerCase().includes(typedText.toLowerCase()) 
                || product.description.toLowerCase().includes(typedText.toLowerCase())))            
        }}/>
        <table>   
            <thead>
                <tr>
                    <th>Category</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th></th>
                </tr>
            </thead>         
            
            <tbody>
            {
                (typedText.trim().length > 0 ? filteredProducts : products).map(product => {
                    return <tr key={product.category}>
                        <td>{product.category}</td>
                        <td>{product.description}</td>
                        <td>${product.price}</td>
                        <td>{product.quantity}</td>
                        <td>{product.price * product.quantity}</td>
                        <td><Button 
                        onClick={()=>{
                            //cart[`${product.category}`] = cart[`${product.category}`] + 1 //not work !
                            let clonedCart = {...cart}
                            clonedCart[`${product.category}`] = 
                                            (clonedCart[`${product.category}`] ?? 0) + 1
                            debugger
                            setCart(clonedCart)

                        }}
                        variant="primary">Add to card</Button></td>
                    </tr>            
                })
            }
            </tbody>
            
        </table>
        <h2>Your cart</h2>
        <h2>Total = ${getTotal()}</h2>
        <Button 
        onClick={()=>{
            debugger
            //cart = {}//not work
            setCart({})
        }}
        variant="danger">Clear cart</Button>
    </div>
}
export default Part3