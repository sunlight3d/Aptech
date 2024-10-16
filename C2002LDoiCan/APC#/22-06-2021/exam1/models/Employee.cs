using System;
namespace exam1.models
{
    public class Employee : IEmployee
    {
        private string _empName;//field
        private int _yearOfService;
        //property
        public string EmpName //Field
        {
            get
            {
                return _empName;
            }
            set
            {
                //ap dung setter de validate 
                //truoc khi thay doi
                if (value.Length >= 6 && value.Length <= 40) {
                    _empName = value;
                }
                //sau khi thay doi
            }
        }
        public int YearOfService {
            get {
                return _yearOfService;
            }
            set {
                if (value >= 0 && value <= 60) {
                    _yearOfService = value;
                }
            }
        }
        public string Desination { get; set; }
        public double Salary { get; set; }
        //khac voi java, ko co override
        public virtual double CalculateBonus(string designation, int tenure, double salary) {            
            if (designation == "Manager")
            {
                return tenure <= 5 ? salary * 0.5 : salary * 2;
            }
            else if(designation == "Engineer"){
                return tenure <= 5 ? salary : salary * 2;
            }
            else if (designation == "Technician")
            {
                return tenure <= 3 ? salary * 0.25 :
                        (tenure > 3 && tenure <= 5 ? salary * 0.5 : salary * 2);
            }
            return 0.0;
        }
        public virtual void DisplayDetails() { //virtual = can be overrided
            Console.WriteLine(
                $"name = {_empName},\n" +
                $"year of service : {YearOfService},\n" +
                $"designation: {Desination},\n" +
                $"salary: {Salary}" +
                $"bonus: {this.CalculateBonus(Desination, _yearOfService, Salary)}");

        }

    }
}
