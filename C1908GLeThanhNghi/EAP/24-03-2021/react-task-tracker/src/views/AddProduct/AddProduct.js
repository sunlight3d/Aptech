import React, {Component} from 'react'
import { connect } from 'react-redux'
import {ADD_PRODUCT} from '../../redux/sagas/product/actions'
import {addProduct} from '../../redux/actions/index'
class AddProduct extends Component {
    state = {
        productName: '',
        year: ''
    }
    render(){
        return <div>
             <input type="text" name="productName" 
                    value={this.state.productName}
                    placeholder = {"Enter product name:"}
                    onChange={(event) => {                        
                        this.setState({productName: event.target.value})
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
                    const {productName, year} = this.state
                    this.props.addProduct({productName, year})
                }}>

            </button>
        </div>
    }
}
const mapStateToProps = (state) => {
    debugger
    return {
        xx: state
    }
}
export default connect(
mapStateToProps,
  {
    addProduct,    
  },
)(AddProduct) //container
