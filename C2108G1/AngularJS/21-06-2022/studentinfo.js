const app = angular.module('myApp', [
    //list of modules                    
])   
app.controller('StudentController', function($scope){                                
    $scope.languages = [
        {
            name: "English",
            checked: false
        }, 
        {
            name: "Vietnamese",
            checked: true
        }, 
        {
            name: "French",
            checked: false
        }, 
        {
            name: "Japanese", //field 
            checked: false,            
        }, 
        {
            name: "German",
            checked: true
        }]
    $scope.genders = [
        {name: "Male", checked: false},
        {name: "Female", checked: false},
        {name: "Undefined", checked: true},
    ]
    $scope.students = []

    $scope.studentClasses = ["C1908G", "C2012A", "C1105"]
    $scope.changeLanguage = function(index) {
        console.log(`index = ${index}`)     
        $scope.languages[index].checked = !$scope.languages[index].checked                             
    }
    $scope.changeGender = function(index) {        
        for(let i = 0; i < $scope.genders.length; i++) {            
            $scope.genders[i].checked = (i == index);            
        }        
    }
    $scope.btnAddStudent = function() {
        //alert(JSON.stringify($scope.languages))
        //alert(JSON.stringify($scope.selectedClass))
        //alert(JSON.stringify($scope.genders))
        debugger
        const selectedGender = $scope.genders.filter(item => item.checked == true)[0]
        const selectedLanguages = $scope.languages.filter(item => item.checked == true)
        console.log(`name: ${$scope.studentName}, dob = ${$scope.dateOfBirth}, 
                gender: ${JSON.stringify(selectedGender)},
                selected languages: ${JSON.stringify(selectedLanguages)})}
                selectedClass = ${JSON.stringify($scope.selectedClass)}`)
        let student = {
            name: $scope.studentName,
            class: $scope.selectedClass,
            dob: $scope.dateOfBirth,
            language: selectedLanguages.split(","),
            gender: selectedGender
        }                
        $scope.students.push(student)
    }
    $scope.btnAddClass = function() {
        
    }
    $scope.btnDeleteStudent = function() {
        
    }
})