import React  from "react"
export function ProductList(props) {
    const fakeData = [
        {
            id: 1,
            name: "iphone 14",
            year: 2022,
            price: 1100
        },
        {
            id: 2,
            name: "iphone 3",
            year: 2008,
            price: 580
        },
        {
            id: 3,
            name: "iphone 4",
            year: 2012,
            price: 120
        },
    ]
    return <div>
         <table>
            <thead>
                <tr >
                    <th>ID</th>
                    <th>Name</th>
                    <th>Year of production</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
            {fakeData.map(eachProduct => {
                //destructuring an object(js)
                const {id, name, year, price} = eachProduct
                // const id = eachProduct.id
                // const name = eachProduct.name
                // const year = eachProduct.year
                // const price = eachProduct.price
                return (<tr key={id}>
                    <td>{id}</td>
                    <td>{name}</td>
                    <td>{year}</td>
                    <td>{price}</td>
                </tr>)
            })}    
            </tbody>
            
        </table>
           
    </div>
}
