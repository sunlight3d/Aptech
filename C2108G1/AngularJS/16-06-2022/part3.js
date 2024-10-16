const app = angular.module('myApp', [
    //list of modules  
                  
])             
app.controller('AppController', function($scope){                                
    //angular code here...         
    $scope.typedText = ""
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
   $scope.filterCategory = function() {
    refreshList()
   }           
})            