import {action} from './common'
const ADD_PRODUCT = 'ADD_PRODUCT'
export const addProduct = ({productName, year}) => action(ADD_PRODUCT, {productName, year})