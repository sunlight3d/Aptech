using System;
namespace exam1.models
{
    public class Person
    {
        private String _IDCard;
        private String _name;
        private int _age;
        //read-only => ko khoi tao kieu Builder Pattern duoc
        public String IDCard { get; }
        public String Name { get; }
        public String Age { get; }
        public Person(String IDCard, String name, int age) {
            _IDCard = IDCard;
            _name = name;
            _age = age;

        }
        public override string ToString()
        {
            return $"id's card : {_IDCard}\n" +
                    $"name : {_name}\n" +
                    $"age: {_age}\n";
        }
    }
}
