namespace De07
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int choice = 0;

            while (choice != 4)
            {
                Console.WriteLine("Please select an option:");
                Console.WriteLine("1. Input Cat information");
                Console.WriteLine("2. Display all Cat from list");
                Console.WriteLine("3. Find Cat by index");
                Console.WriteLine("4. Exit program");
                Console.Write("Enter your choice: ");
                
                using (MyDbContext context = new MyDbContext()) {
                    try
                    {
                        CatManagement catManagement = new CatManagement(context);
                        choice = Convert.ToInt32(Console.ReadLine());

                        switch (choice)
                        {
                            case 1:
                                // Call function to input Cat information
                                Cat cat = new Cat();
                                cat.InputData();
                                catManagement.AddToList(cat);
                                break;
                            case 2:
                                // Call function to display all Cat from list
                                catManagement.Display();
                                break;
                            case 3:
                                // Call function to find Cat by index
                                Console.WriteLine("Enter index: ");
                                int index = Convert.ToInt32(Console.ReadLine());
                                break;
                            case 4:
                                Console.WriteLine("Exiting program...");
                                break;
                            default:
                                Console.WriteLine("Invalid choice. Please try again.");
                                break;
                        }
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine($"Error: {ex.Message}");
                    }
                }                                    
            }
        }
        
    }
}