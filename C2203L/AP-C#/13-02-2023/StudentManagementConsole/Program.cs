namespace StudentManagementConsole
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StudentRepository studentRepository = new StudentRepository();
            int choice;
            //db.Database.EnsureCreated();                                
            do
            {
                Console.WriteLine("CRUD Menu");
                Console.WriteLine("1. Add Student");
                Console.WriteLine("2. View Students");
                Console.WriteLine("3. Update Student");
                Console.WriteLine("4. Delete Student");
                Console.WriteLine("5. Exit");
                Console.Write("Enter your choice: ");
                choice = int.Parse(Console.ReadLine());

                switch (choice)
                {
                    case 1:
                        studentRepository.InsertStudent();
                        break;
                    case 2:
                        studentRepository.ViewStudents();   
                        break;
                    case 3:
                        studentRepository.UpdateStudent();
                        break;
                    case 4:
                        studentRepository.DeleteStudent();
                        break;
                    case 5:
                        break;
                    default:
                        Console.WriteLine("Invalid choice");
                        break;
                }
            } while (choice != 5);
        }
    }
}