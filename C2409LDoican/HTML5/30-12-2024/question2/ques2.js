let products = [

]
debugger
function reloadlist(){
    let producttable = document.getElementById('listproducts')
    producttable.innerText = null;
    for (let i = 0; i < products.length; i++){
        let product = products[i];
        let row = producttable.insertRow()

        let tdname = row.insertCell(0)
        tdname.style.width = '20%'
        tdname.innerHTML = product.name

        let tdprice = row.insertCell(1)
        tdprice.innerHTML = product.price

        let tdcategory = row.insertCell(2)
        tdcategory.innerHTML = product.category

        let tdbuttons = row.insertCell(3)
        tdbuttons.innerHTML = `<a href="#" onclick="">Edit</a> <a href="#" onclick="deleteProduct('${product.name}')">Delete</a>`
    }
}
function deleteProduct(productName) {
    //alert(productName)
    products = products.filter(item => item.name != productName)
    reloadlist()
}
function addproduct(){
    let name = document.getElementById('productname').value
    let price = document.getElementById('price').value
    let category = document.getElementById('category').value
    //validate
    debugger
    if(products.find(item => item.name.trim().toLowerCase() == name.trim().toLowerCase())) {
        alert('Sản phẩm bị trùng tên rồi ')
        return
    }
    let product = {
        name: name,
        price: price,
        category: category
    }
    products.push(product)
    reloadlist()
}