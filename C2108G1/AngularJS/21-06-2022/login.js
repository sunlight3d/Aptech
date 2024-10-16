const app = angular.module('myApp', [
    //list of modules                    
])   
app.controller('LoginController', function($scope){                                
    $scope.btnLogin = function() {
        /*
        let username = $scope.username
        let password = $scope.password
        */
        const {username, password} = $scope //destructuring an object
        //alert(`You pressed username:  ${username}, and password: ${password}`);
        if(username.toLowerCase() == "admin" && password == "123456") {
            alert("Login successful")
        } else {
            alert("Login failed.Incorect username and password")
        }
    }
})