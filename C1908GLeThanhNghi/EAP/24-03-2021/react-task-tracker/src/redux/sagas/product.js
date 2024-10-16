import { take, put, call, fork, select, all } from 'redux-saga/effects'
import * as productActions from '../actions/product'
function* watchAddProduct(){
    debugger
    yield fork(productActions.addProduct)
}
export default function* root() {
    yield all([
      fork(watchAddProduct),      
    ])
}