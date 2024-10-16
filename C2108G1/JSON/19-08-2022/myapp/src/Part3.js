import { Button } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import './Part3.css'
import { useState } from 'react'
function Part3(props) {
    //useState is called "Hook"
    const [typedText, setTypedText] = useState("")
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
    return <div>        
        <p>Filtering input: </p>
        <input onChange={(event) => {

        }}/>
        <table>
            <tr>
                <th>Category</th>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
                <th></th>
            </tr>
            {
                products.map(product => {
                    return <tr>
                        <td>{product.category}</td>
                        <td>{product.description}</td>
                        <td>${product.price}</td>
                        <td>{product.quantity}</td>
                        <td>{product.price * product.quantity}</td>
                        <td><Button variant="primary">Add to card</Button></td>
                    </tr>            
                })
            }
            
        </table>
    </div>
}
export default Part3