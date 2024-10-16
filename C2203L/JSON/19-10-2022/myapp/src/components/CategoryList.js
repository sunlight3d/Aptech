import React, {Component, useState} from "react"
import '../css/CategoryList.css'
export function CategoryList(props) {
    const [categories, setCategories] = useState([
        {         
            id: 1,   
            categoryName : "flash light",
            description: "This is haha",
            price: 112.2,
            quantity: 3,            
        },
        {         
            id: 2,   
            categoryName : "electronics",
            description: "This is electronic",
            price: 200.2,
            quantity: 5,            
        },        
        {
            id: 3,
            categoryName : "electric",
            description: "laptop Acer swift",
            price: 25.2,
            quantity: 10,            
        },
        {
            id: 4,
            categoryName : "dell",
            description: "fmd jgfdfg dhgfh",
            price: 25.2,
            quantity: 10,            
        },
        {
            id: 5,
            categoryName : "haha",
            description: "Laptop dell xps",
            price: 25.2,
            quantity: 10,            
        }
    ])
    const [filteredCategories, setFilteredCategories] = useState([])
    const [searchText, setSearchText] = useState('')
    const [cart, setCart] = useState({})
    function getTotalFromCart(){        
        let total = 0.0
        for (let key of Object.keys(cart)) {
            let quantityInCart = cart[key]
            let price = categories.find(category => category.categoryName==key)?.price
            total += quantityInCart * price            
        }
        return total
        
    }
    return <div>
        <h1>Welcome to the Gamming Store</h1>
        <span>Filtering input:</span>
        <input 
            placeholder={"Enter text to search"}
            onChange={(event)=> {
                setSearchText(event.target.value) 
                setFilteredCategories(categories
                    .filter(category => {
                        return category.categoryName.toLowerCase().includes(searchText.toLowerCase())
                            || category.description.toLowerCase().includes(searchText.toLowerCase())
                    }))
            }}
            value={searchText}
            />
        <p>{searchText}</p>
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
                    (searchText.trim().length > 0 ? filteredCategories : categories)
                        .map(category => {
                            const { id, categoryName, description, price, quantity } = category
                            return <tr key={id}>
                                <td>{categoryName}</td>
                                <td>{description}</td>
                                <td>{price}</td>
                                <td>{quantity}</td>
                                <td>{price * quantity} $</td>
                                <td><button onClick={() => {
                                    if (quantity > 0) {       
                                        let cloneCart = {...cart}
                                        cloneCart[categoryName] = cart[categoryName] == undefined ?
                                                                    1 : cart[categoryName] + 1                                                                                                               
                                        setCart(cloneCart)                                        
                                        //quantity -= 1//FAILED !
                                    }
                                }}>Add to cart</button></td>
                            </tr>
                        })
                }
            </tbody>
                     
        </table>
        <h2>Your cart: </h2>
        <p>Total: {Math.floor(getTotalFromCart()).toFixed(2)}</p>
        <p>cart details: {JSON.stringify(cart)}</p>
        <button onClick={(event)=> {
            setCart({})
        }}>Clear Cart</button>
    </div>
}