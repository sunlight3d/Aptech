import React, {Component} from 'react'
import Header from '../../components/Header'
import AddProduct from '../AddProduct/AddProduct';
import { ProductList } from "./ProductList";
export default class Home extends Component {    
    state = {
        filteredText: ''
    }
    render(){
        //destructuring
        const {name, age } = this.props
        return <div>
            <h1>ten: {name}, tuoi = {age}</h1>
            <label>
                Enter something to search:
                <input type="text" name="productName" 
                    value={this.state.filteredText}
                    onChange={(event) => {
                        debugger
                        this.setState({filteredText: event.target.value})
                    }}/>
            </label>       
            <AddProduct />
            <p>{this.state.filteredText}</p>     
            <Header {...this.props}/>
            <ProductList {...this.state}/>
        </div>
    }
}