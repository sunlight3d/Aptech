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

let divFruitList = document.getElementById('fruitList')
let categories = ['All']
for(let fruit of fruits) { 
    debugger
    if(!categories.includes(fruit.category)) {
        categories.push(fruit.category)
    }
}
let selectedCategory = categories[0]
let filteredFruits = selectedCategory == 'All' ? fruits : fruits.filter(item => item.category == selectedCategory)
let selectCategoryTag = document.getElementById("selectCategory");
function reloadCategories(){
    selectCategoryTag.innerText = null;
    for(let i = 0; i < categories.length; i++) {
        let option = document.createElement("option");
        option.text = categories[i];
        option.value = categories[i]; 
        selectCategoryTag.add(option);
    }
}
reloadCategories()
selectCategoryTag.addEventListener('change',function(){
    selectedCategory = selectCategoryTag.options[selectCategoryTag.selectedIndex].text
    filteredFruits = selectedCategory == 'All' ? fruits : fruits.filter(item => item.category == selectedCategory)
    //alert(selectedCategory)
    reloadFruitList();
});
debugger
function editFruit(name) {
    alert(name)
}
function deleteFruit(name) {
    for(let item of divFruitList.children) {
        if(item.id == name) {
            divFruitList.removeChild(item)
        }
    }

}

function reloadFruitList() {
    divFruitList.innerHTML = null;
    for(let fruit of filteredFruits) {
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
}
reloadFruitList();
