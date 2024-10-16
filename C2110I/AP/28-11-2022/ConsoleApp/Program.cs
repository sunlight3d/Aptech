namespace ConsoleApp
{
    public class Program { 
        public static void Main(string[] args) {
            Rectangle rectangle = new Rectangle();
            Console.WriteLine($"width: {rectangle.Width}, height: {rectangle.Height}");
            Rectangle rectangle2 = new Rectangle() { 
                Width = -1,
                Height = 5
            };
            Console.WriteLine($"rec2 = {rectangle2.ToString()}");
            Rectangle rectangle3 = new Rectangle()
            {
                Width = 5,
                Height = 6
            };
            Console.WriteLine($"rec3 = {rectangle3.ToString()}");
            SavingsAccount.AnnualInterestRate = 0.3f;
            SavingsAccount saver1 = new SavingsAccount() { 
                SavingsBalance = 2000.0f
            };
            
            SavingsAccount saver2 = new SavingsAccount()
            {
                SavingsBalance = 3000.0f
            };
            //saver1.MonthlyInterest 
            Date date1 = new Date(28, 12, 2022);
            Date date2 = new Date(28, "December", 2022);


        }
    }
}
