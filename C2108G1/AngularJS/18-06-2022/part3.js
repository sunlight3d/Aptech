const app = angular.module('myApp', [
    //list of modules  
                  
])   


app.controller('AppController', function($scope){                                
    //angular code here...         
    $scope.typedText = ""
    $scope.totalOnCart = 0.0
    $scope.cart = {
        ///this is a blank object        
    }
    function getTotalOnCart() {
        let result = 0.0
        
        for(key in $scope.cart) {
            let category = $scope.getCategoryFromName(key)            
            let price = category.price
            let numberOfItem = $scope.cart[key]
            result += numberOfItem * price
        }
        return result.toFixed(2)
    }
    $scope.getCategoryFromName = function(name) {
        return $scope.categories.filter(item => item.name == name)[0]            
    }
    
    var allCategories = [
        {
            name: 'iphone 4',
            description: 'this is steess',
            price: 12.3,
            quantity: 2,
            //getter ?            
        },
        {
            name: 'macbook pro',
            description: 'thi mac book s is steess',
            price: 11.3,
            quantity: 1,
            //getter ?
        },
        {
            name: 'dell laptop ',
            description: 'this is steess',
            price: 16.55,
            quantity: 10,
            //getter ?
        }        
    ]
    const refreshList = function() {             
        //use filter        
        let filteredCategories = allCategories
                                .filter(category => category.name.toLowerCase()
                                        .includes($scope.typedText.toLowerCase()) ||
                                        category.description.toLowerCase()
                                        .includes($scope.typedText.toLowerCase()) )
            
       //filter manually
       /*
       let filteredCategories = []
       for(let i = 0 ; i < allCategories.length; i++) {
        let category = allCategories[i]
        if(category.name.toLowerCase().includes($scope.typedText.toLowerCase())) {
            filteredCategories.push(category)
           }
       }*/
        //debugger                                    
        $scope.categories = $scope.typedText.trim().length == 0 ? 
                                allCategories : filteredCategories                                    
    } 
    $scope.getTotal = (price, quantity) => price * quantity        
    refreshList()
    /*
    $scope.getTotal = function(price, quantity) {
        return price * quantity
    }
    */
   $scope.filterCategory = refreshList     
   $scope.btnAddToCart = function(selectedCategory) {    
    let name = selectedCategory.name
    $scope.cart[name] = $scope.cart[name] == undefined ? 1 : $scope.cart[name] + 1
    $scope.totalOnCart = getTotalOnCart()
   }
   $scope.btnClearCart = function() {    
    $scope.cart = {}
    $scope.totalOnCart = getTotalOnCart()
   }
   $scope.btnRemoveItem = function(categoryName) {    
    delete $scope.cart[categoryName]
    /*
    if($scope.cart[categoryName]) {
        $scope.cart[categoryName] = $scope.cart[categoryName] - 1
        if($scope.cart[categoryName] <= 0) {
            delete $scope.cart[categoryName]
        }                
    }
    */
    $scope.totalOnCart = getTotalOnCart()
   }      
})            