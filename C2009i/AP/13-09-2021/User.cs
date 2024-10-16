using System;
namespace _13_09_2021
{
    public class User
    {
        //C# style - recommend
        //private String fullName; //field = variable
        //private String email;
        //private String phoneNumber;
        //private DateTime dateOfBirth;
        //private int age;//NO, not neccessary !

        //getter like "calculated property"
        public int Age {
            get {
                Console.WriteLine("haha");
                return DateTime.Now.Year - DateOfBirth.Year;
            }
        }
        public DateTime DateOfBirth { get; set; }

        //getter, setter is Function!
        //property = function
        public String FullName { get; set;}
        public String Email { get; set; }
        public String PhoneNumber { get; set; }
        //NO need constructor
        public override string ToString() =>
            $"name = {this.FullName}," +
            $", email = {Email}, " +
            $", phoneNumber = {PhoneNumber}";
    }
}
