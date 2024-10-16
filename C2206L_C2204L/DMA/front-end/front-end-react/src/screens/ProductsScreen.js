import React, { useState, useEffect, Component } from 'react'

export default function ProductsScreen(props) {   
    //immutable states
    const [products, setProducts] = useState([]);

    useEffect(() => {
        fetchProducts();
    }, []); 
    const fetchProducts = async () => {
        try {
            debugger
            const response = await fetch("https://localhost:7020/Product");
            debugger
            const data = await response.json();
            setProducts(data);
        } catch (error) {
            debugger
            console.error("Error fetching data:", error);
        }
    };
    return <div>
        <h1>This is products</h1>
        <table>
            <thead>
                <td>
                    ID
                </td>
                <td>
                    Name
                </td>
                <td>
                    Description
                </td>
                <td>
                    Price
                </td>
                <td>
                    Count
                </td>
            </thead>
            <tbody>
            {products.map(product => (
                        <tr key={product.id}>
                            <td>{product.id}</td>
                            <td>{product.name}</td>
                            <td>{product.description}</td>
                            <td>{product.price}</td>
                            <td>{product.count}</td>
                        </tr>
                    ))}
            </tbody>
        </table>
    </div>
}
