import React from 'react'
//fake, will remove
import { getProducts } from "../../repositories/productRepository";
export class ProductList extends React.Component {

    _mapProctListToUI(products) {
        //lang nghe event tu Redux
        return products.map(product => <tr>
            <td>{product.productName}</td>
            <td>{product.year}</td>
            <td>
            <img 
                src={product.url} alt="new"/>
                </td>
        </tr>)
    }
    
    render(){
        return <div>
            <h1>Day la product list</h1>
            <table>
                {this._mapProctListToUI(getProducts(this.props.filteredText))}                
            </table>
        </div>
    }
}