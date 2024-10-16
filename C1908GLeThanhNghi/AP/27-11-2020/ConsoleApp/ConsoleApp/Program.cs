using System;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {

            HiredProgrammers myemployee = new HiredProgrammers(3);
            for(int i = 0; i < 3; i++)
            {
                try
                {
                    //id, name, DBB
                    Console.WriteLine("Enter id: ");
                    int id = Convert.ToInt32(Console.ReadLine());

                    Console.WriteLine("Enter name: ");
                    string name = Console.ReadLine();

                    Console.WriteLine("Enter DOB(dd/mm/yyyy): ");
                    String[] inputStrings = Console.ReadLine().Trim().Split("/");

                    Console.WriteLine("Enter skills(eg: c#, html, js, swift)");
                    string skills = Console.ReadLine().Trim();
                    //(int year, int month, int day);

                    DateTime dateOfBirth = new DateTime(
                        Convert.ToInt32(inputStrings[2]),
                        Convert.ToInt32(inputStrings[1]),
                        Convert.ToInt32(inputStrings[0])
                    );
                    myemployee.AddNew(new Programmer(id, name)
                    {
                        DateOfBirth = dateOfBirth,                        
                        Skills = skills
                    });                    
                }
                catch (Exception ex) {
                    Console.Error.WriteLine($"Cannot insert new Programmer, Error : {ex.ToString()}");
                }
                Console.WriteLine("Enter an age to filter: ");
                int underAge = Convert.ToInt32(Console.ReadLine());
                myemployee.ShowFilterInfo(underAge);
            }
        }
    }
}
