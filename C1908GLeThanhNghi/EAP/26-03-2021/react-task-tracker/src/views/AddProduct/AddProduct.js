import React, {Component} from 'react'
import { connect } from 'react-redux'

import {ProductActions} from '../../redux/actions/index'
const {addProduct} = ProductActions

class AddProduct extends Component {
    state = {
        productName: '',
        year: ''
    }
    render(){
        return <div>
             <input type="text" name="productName" 
                    //value={this.state.productName}
                    value={""}
                    placeholder = {"Enter product name:"}
                    onChange={(event) => {         
                        debugger               
                        //this.setState({productName: event.target.value})
                    }}/>
            <input type="text" name="year" 
                    value={this.state.year}
                    placeholder = {"Enter year"}
                    onChange={(event) => {                        
                        this.setState({year: event.target.value})
                    }}/>
            <button
                value = {"Add Product"} 
                onClick={()=> {
                    debugger
                    //send event
                    //const {productName, year} = this.state
                    //this.props.product
                    //this.props.addProduct({productName, year})
                }}>

            </button>
        </div>
    }
}
const mapStateToProps = (state) => {
    debugger
    return state
}
const mapDispatchToProps = (dispatch) => {    
    debugger
    return {
      // dispatching plain actions      
      addProduct: () => dispatch(addProduct()),      
      //addProduct
    }
  }
const container = connect(
    mapStateToProps,
    mapDispatchToProps,
    )(AddProduct);  
debugger
export default container
