namespace de13
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Rectangle rectangle = new Rectangle();
            rectangle.Width = 12.0;
            rectangle.Height = 13.0;
            
            Console.ReadLine();

            SavingsAccount accountA = new SavingsAccount();
            SavingsAccount accountB = new SavingsAccount();
            accountA.SavingBalance = 2000.0;
            accountB.SavingBalance = 3000.0;
            SavingsAccount.ModifyInterestRate(0.04);
            Console.WriteLine(accountA);
            SavingsAccount.ModifyInterestRate(0.05);
            Console.WriteLine(accountB);

        }
    }
}
