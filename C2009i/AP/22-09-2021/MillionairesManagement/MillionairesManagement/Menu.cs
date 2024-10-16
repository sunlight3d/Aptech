using System;
using System.Collections.Generic;
using MillionairesManagement.Models;
using System.Linq;//Language Integrated Query (like Stream in Java)
using System.IO;

namespace MillionairesManagement
{
    public class Menu : IMenu
    {
        private List<Person> persons = new List<Person>();//variable = field
        public void Analyze()
        {
            Dictionary<string, int> result = new Dictionary<string, int>();
            foreach (Person person in this.persons)
            {
                string nationality = person.Nationality;                
                result[nationality] = (result.ContainsKey(nationality) ? result[nationality] : 0) + 1;
            }
            Console.WriteLine("Statistics result: ");
            foreach(string nationality in result.Keys)
            {
                int count = result[nationality];
                Console.WriteLine($"+ There are {count} person(s) from ‘{nationality}’.");
            }
            
        }

        public void Find()
        {
            Console.WriteLine("Enter nationality to search: ");
            string nationality = Console.ReadLine().Trim().ToLower();
            Console.WriteLine("Enter min: ");
            double min = Convert.ToDouble(Console.ReadLine());
            //duyet danh sach, tim thay thi cho vao array khac ? True, donot this !
            List<Person> filteredPersons = this.persons.Where(
                person => person.Nationality.ToLower().Equals(nationality)
                    && person.NetWorth >= min).ToList();
            if(filteredPersons.Count == 0)
            {
                Console.WriteLine("Cannot find person");                
                return;
            }
            foreach(Person person in filteredPersons)
            {
                Console.WriteLine(person.ToString());
            }
        }

        public void Input()
        {
            Console.WriteLine("Enter number of Persons:");
            int numberOfPersons = Convert.ToInt32(Console.ReadLine());
            for(int i = 0; i < numberOfPersons; i++)
            {
                Person person = new Person();
                person.Input();
                persons.Add(person);
            }            
        }

        public void Open()
        {
            try {
                Console.WriteLine("Enter file name:");
                string fileName = Console.ReadLine();                                
                //@"I have a dream", @ goi la "raw"                
                string[] lines = File.ReadAllLines(fileName);
                this.persons.Clear();
                int lineNumber = 0;
                foreach (String line in lines)
                {
                    string[] arrayOfFields = line.Split(",");
                    if (lineNumber == 0) {
                        lineNumber ++;
                        continue;
                    }
                   
                    string personName = arrayOfFields[0];
                    string nationality = arrayOfFields[1];
                    int birthYear  = Convert.ToInt32(arrayOfFields[2]);
                    float netWorth  = (float)Convert.ToDouble(arrayOfFields[3]);
                    Person person = new Person() {
                        Name = personName,
                        Nationality = nationality,
                        BirthYear = birthYear,
                        NetWorth = netWorth
                    };
                    this.persons.Add(person);
                    lineNumber++;
                }
                Console.WriteLine("haha");
                
            } catch (Exception exception)
            {
                Console.WriteLine($"Error: {exception.Message}");
            }
        }

        public void Save()
        {
            try
            {
                Console.WriteLine("Enter file name:");
                string fileName = Console.ReadLine().Trim();

                /*
                VD: co file ten nhu sau: abc.com.Idoit.vls
                fileName.Split(".") => ["abc", "com", "Idoit", "vls"]
                fileName.Split(".").Last() => "vls"                
                */
                string fileExtension = fileName.Split(".").Length < 2 ? "" : (fileName.Split(".").Last().Trim().ToLower());
                //neu ten file la csv thi sao ?
                fileName = fileExtension.Equals("csv") ? fileName : $"{fileName}.csv";
                using StreamWriter file = new(fileName);
                file.WriteLine("person's name, Nationality, Birth year, Networth");
                foreach (Person person in this.persons)
                {
                    string line = $"{person.Name},{person.Nationality},{person.BirthYear},{person.NetWorth}";
                    file.WriteLine(line);
                }
                file.Close();
            } catch(Exception exception)
            {
                Console.WriteLine($"Error: {exception.Message}");
            }
            
        }

        public void Sort()
        {
            //2 vong for + bubble => not neccessary !
            this.persons.Sort((person1, person2) => (int)(person1.NetWorth - person2.NetWorth));            
        }
        private void Display()
        {            
            Console.WriteLine("+------------------------------------------------------------------+");
            Console.WriteLine("| Person Name | Nationality | Birth Year | Net Worth(billion $) |");
            Console.WriteLine("+ ------------------------------------------------------------------+");
            foreach (Person person in this.persons)
            {
                Console.WriteLine(person.ToString());
            }
        }
        private void GeneratePersons()
        {
            this.persons = new List<Person>()
            {
                new Person()
                {
                    Name = "a",
                    Nationality = "aa",
                    NetWorth = 12,
                    BirthYear = 1980,
                },
                new Person()
                {
                    Name = "a",
                    Nationality = "bb",
                    NetWorth = 51,
                    BirthYear = 1981,
                },
                new Person()
                {
                    Name = "c",
                    Nationality = "bb",
                    NetWorth = 10,
                    BirthYear = 1983,
                },
                new Person()
                {
                    Name = "c",
                    Nationality = "cc",
                    NetWorth = 50,
                    BirthYear = 1982,
                },
            };
        }
        public void ShowMenu()
        {
            this.GeneratePersons();
            string choice = "";
            while (choice != "7")
            {
                Console.WriteLine("+------------------------------------------------------------------+");
                Console.WriteLine("| BILLIONAIRES PROFILE MANAGEMENT PROGRAM |");
                Console.WriteLine("+ ------------------------------------------------------------------+");
                Console.WriteLine("| 1.Input | 2.Sort | 3.Analyze | 4.Find | 5.Save | 6.Open | 7.Exit |");
                Console.WriteLine("+ ------------------------------------------------------------------+");
                Console.WriteLine("Enter your choice : ");
                choice = (Console.ReadLine() ?? "").Trim();
                Console.WriteLine($"Your choice: {choice}");
                if (choice.Equals("1"))
                {
                    this.Input();
                    this.Display();
                }
                
                else if (choice.Equals("2"))
                {
                    this.Sort();
                    this.Display();
                }
                else if (choice.Equals("3"))
                {
                    this.Analyze();
                }
                else if (choice.Equals("4"))
                {
                    this.Find();
                }
                else if (choice.Equals("5"))
                {
                    this.Save();
                }
                else if (choice.Equals("6"))
                {
                    this.Open();
                }
                else if (choice.Equals("7"))
                {
                    break;
                }
                Console.WriteLine("Do you want to continue ?");
                Console.WriteLine("- Yes, I do. (press ‘y’, ‘Y’)");
                Console.WriteLine("- No, I don’t. (press ‘n’, ‘N’)");
                Console.WriteLine("- Please clear the screen!(press ‘c’, ‘C’)");
                Console.WriteLine("Enter your choice : ");
                //?? = elvis(C#, js, Kotlin, Dart)
                //Console.ReadLine()?.Trim(); //(C#, js, Kotlin, Dart, Swift)
                choice = (Console.ReadLine() ?? "").Trim();
                /*
                if (choice.ToLower().Equals("n"))
                {
                    choice = "7"; 
                }
                */
                choice = choice.ToLower().Equals("n") ? "7" : choice;
                if (choice.ToLower().Equals("c"))
                {
                    Console.Clear();
                }

            }
            Console.WriteLine("End program");
            
        }
    }
}
