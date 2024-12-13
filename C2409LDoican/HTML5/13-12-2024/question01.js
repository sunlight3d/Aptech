let fruits = [
    {
        category: "Citrus",
        name: "Orange",
        description: "A juicy citrus fruit known for its vibrant color and tangy flavor.",
        price: 0.5,
        inStock: true
    },
    {
        category: "Berry",
        name: "Strawberry",
        description: "A sweet, red fruit with tiny seeds on its surface.",
        price: 0.25,
        inStock: true
    },
    {
        category: "Tropical",
        name: "Mango",
        description: "A tropical stone fruit with sweet, yellow flesh.",
        price: 1.5,
        inStock: true
    },
    {
        category: "Stone Fruit",
        name: "Peach",
        description: "A soft, fuzzy fruit with juicy, sweet flesh.",
        price: 0.8,
        inStock: false
    },
    {
        category: "Melon",
        name: "Watermelon",
        description: "A large, refreshing fruit with a green rind and sweet, red flesh.",
        price: 3.0,
        inStock: true
    },
    {
        category: "Pome",
        name: "Apple",
        description: "A crunchy fruit that comes in a variety of colors and flavors.",
        price: 0.6,
        inStock: true
    },
    {
        category: "Citrus",
        name: "Lemon",
        description: "A tart, yellow citrus fruit commonly used in beverages and cooking.",
        price: 0.4,
        inStock: true
    },
    {
        category: "Berry",
        name: "Blueberry",
        description: "A small, sweet blue fruit often used in desserts.",
        price: 0.3,
        inStock: true
    },
    {
        category: "Tropical",
        name: "Pineapple",
        description: "A spiky tropical fruit with sweet and tangy yellow flesh.",
        price: 2.5,
        inStock: false
    },
    {
        category: "Stone Fruit",
        name: "Cherry",
        description: "A small, round fruit with a pit, known for its juicy sweetness.",
        price: 0.2,
        inStock: true
    }
];
let categories = []
for(let fruit of fruits) { 
    debugger
    if(!categories.includes(fruit.category)) {
        categories.push(fruit.category)
    }
}
debugger
function editFruit(name) {
    alert('editFruit')
}
function deleteFruit(name) {
    alert('deleteFruit')
}
let divFruitList = document.getElementById('fruitList')
for(let fruit of fruits) {
    divFruitList.innerHTML += `
            <div id='${fruit.name}'>
                <p>-${fruit.name} Category: ${fruit.category}</p>
                <p>Description: ${fruit.description}</p>
                <div>
                    <button class="btnEdit" onClick=editFruit('${fruit.name}')>Edit</button>
                    <button class="btnDelete" onClick=deleteFruit('${fruit.name}')>Delete</button>
                </div>
                <hr>
            </div>
`
}
