<?php
//echo "This is point class";
class Employee {
    public $employeeNo;
    public $employeeName;
    public $post;
    public $salary;
    public function __construct(
        $employeeNo,
        $employeeName = "",
        $post = "",
        $salary = 0
    ) {
        $this->employeeNo = $employeeNo;
        $this->employeeName = $employeeName;
        $this->post = $post;
        $this->salary = $salary;
    }       
    //factory method
    public static function fromDictionary($dictionary) {        
        return $dictionary == null ? 
                new Employee() :
                new Employee($dictionary['empno'],
                        $dictionary['ename'],
                        $dictionary['post'],
                        $dictionary['salary']
        );
    }
    
}
?>