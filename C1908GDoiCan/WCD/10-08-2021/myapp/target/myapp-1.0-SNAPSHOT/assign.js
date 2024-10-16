function changeCategory(){
    debugger
    const categoryName = document.getElementById("categories").value;
    document.getElementById("title").innerHTML = `Do you really want to assign to ${categoryName} ?`
}