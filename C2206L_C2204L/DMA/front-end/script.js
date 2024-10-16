document.addEventListener("DOMContentLoaded", () => {
    debugger
    const productList = document.getElementById("product-list");

    // Function to create and append a product item to the list
    function appendProduct(product) {
        const listItem = document.createElement("li");
        listItem.innerHTML = `
            <strong>ID:</strong> ${product.id}<br>
            <strong>Name:</strong> ${product.name}<br>
            <strong>Description:</strong> ${product.description}<br>
            <strong>Price:</strong> ${product.price}<br>
            <strong>Count:</strong> ${product.count}<br><br>
        `;
        productList.appendChild(listItem);
    }

    // Function to make the API request and handle the response
    /*
    function fetchProducts() {
        //thay cho ajax
        debugger
        fetch("https://localhost:7020/Product")
            .then(response => {
                debugger
                return response.json();
            })
            .then(data => {
                debugger
                data.forEach(product => {
                    appendProduct(product);
                });
            })
            .catch(error => {
                debugger
                console.error("Error fetching data:", error);
            });
        debugger
    }
*/
    async function fetchProducts() {
        try {
            const response = await fetch("https://localhost:7020/Product");
            debugger
            const products = await response.json();
            for(let i= 0; i < products.length; i++) {
                const product = products[i];
                appendProduct(product);
            }
            /*
            data.forEach(product => {
                appendProduct(product);
            });
            */
            debugger
        }catch(exception) {
            debugger
            console.log('errro')
        }

    }
    // Call the function to fetch and display products
    fetchProducts();
});
