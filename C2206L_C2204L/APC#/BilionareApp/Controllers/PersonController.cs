using BilionareApp.Models;
using System;
using System.Collections.Generic;
using System.IO.Enumeration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BilionareApp.Controllers
{
    public class PersonController
    {
        private string fileName = "output.txt";
        private List<Person> persons = new List<Person>();
        public void InputPersons() {
            Console.WriteLine("How many persons ?");
            int numberOfPersons = int.Parse(Console.ReadLine() ?? "0");
            for(int i = 0; i < numberOfPersons; i++)
            {
                Person person = new Person();
                Console.WriteLine($"Please input Person[{i+1}]: ");
                Console.WriteLine("Name: ");
                person.Name = Console.ReadLine();
                Console.WriteLine("Nationality: ");
                person.Nationality = Console.ReadLine();

                int age = 0;
                while (age <= 30) {
                    Console.WriteLine("Birth year: ");
                    person.BirthYear = int.Parse(Console.ReadLine() ?? "0");
                    // Calculate age
                    age = DateTime.Now.Year - person.BirthYear;
                }

                float netWorth = 0;
                while (netWorth < 1 || netWorth > 100)
                {
                    Console.WriteLine("NetWorth: ");
                    person.NetWorth = float.Parse(Console.ReadLine() ?? "0");                    
                }



                persons.Add(person);
            }
        }
        public void SortPersons() { 
            this.persons
                .Sort((person1, person2) => (int)(person2.NetWorth - person1.NetWorth));
            this.DisplayPersons();
        }
        private void DisplayPersons()
        {
            //cach truyen thong
            /*
            for(int i = 0; i < this.persons.Count; i++)
            {
                Person person = this.persons[i];
                Console.WriteLine(person);
            }
            */
            this.persons.ForEach(person => {
                Console.WriteLine(person);
            });
        }
        public void AnalyzePersons()
        {
            Dictionary<string, int> result = new Dictionary<string, int>();
            foreach(Person person in this.persons)
            {
                string nationality = person.Nationality ?? "";
                result[nationality] = !result.ContainsKey(nationality) ? 0
                                                : result[nationality]+1;
            }
            foreach (string nationality in result.Keys) {
                int numberOfPersons = result[nationality];
                string sPostfix = numberOfPersons > 1 ? "s" : "";
                Console.WriteLine($"There are {numberOfPersons} person{sPostfix} from {nationality}");
            }
        }
        public void FindPersons() {
            Console.WriteLine("Enter nationality: ");
            string nationality = Console.ReadLine() ?? "";
            float min = float.Parse(Console.ReadLine() ?? "0");
            List<Person> filteredList = this.persons.Where(
                person => (person.Nationality ?? "").ToLower().Equals(nationality.ToLower())
                && person.NetWorth > min
            ).ToList();

        }
        public void SaveToFile() {
            // Write the list to a file
            using (StreamWriter writer = new StreamWriter(this.fileName))
            {
                foreach (Person person in persons)
                {
                    writer.WriteLine($"{person.Name},{person.Nationality},{person.BirthYear},{person.NetWorth}");
                }
            }
        }
        public void ReadFromFile() {
            using (StreamReader reader = new StreamReader(this.fileName))
            {
                string line;
                persons.RemoveAll(person => true);
                while ((line = reader.ReadLine()) != null)
                {
                    string[] fields = line.Split(',');
                    persons.Add(new Person
                    {
                        Name = fields[0],
                        Nationality = fields[1],
                        BirthYear = int.Parse(fields[2]),
                        NetWorth = float.Parse(fields[3])
                    });
                }
            }
            this.DisplayPersons();
        }
    }
}
