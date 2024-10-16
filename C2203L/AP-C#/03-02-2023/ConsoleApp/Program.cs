namespace ConsoleApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StudentTest studentTest= new StudentTest();
            studentTest.InputSomeStudents();
            studentTest.WriteDataToFile();
            studentTest.readDataFromFile();
        }
    }
}