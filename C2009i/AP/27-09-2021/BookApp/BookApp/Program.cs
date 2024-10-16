using System.Linq;
namespace BookApp
{
    public class Program
    {
        public static void Main(string[] args)
        {
            SchoolBook b1 = new SchoolBook()
            {
                Code = "b11",
                Price = 11,
                Count = 1,
                Publisher = "p111",
                BookState = BookState.Old
            };
            SchoolBook b2 = new SchoolBook()
            {
                Code = "b22",
                Price = 22,
                Count = 2,
                Publisher = "p222",
                BookState = BookState.New
            };
            SchoolBook b3 = new SchoolBook()
            {
                Code = "b33",
                Price = 33,
                Publisher = "p333",
                Count = 3,
                BookState = BookState.Old
            };
            ReferenceBook b4 = new ReferenceBook()
            {
                Code = "b11",
                Price = 11,
                Count = 4,
                Publisher = "p111",
                Tax = 0.15f
            };
            ReferenceBook b5 = new ReferenceBook()
            {
                Code = "b55",
                Price = 55,
                Count = 5,
                Publisher = "p555",
                Tax = 0.1f
            };
            ReferenceBook b6 = new ReferenceBook()
            {
                Code = "b66",
                Price = 66,
                Count = 6,
                Publisher = "p66",
                Tax = 0.16f
            };
            double totalPriceOfRererenceBooks = 0.0;
            double totalPriceOfSchoolBooks = 0.0;
            int numberOfReferenceBooks = 0;
            int numberOfSchoolBooks = 0;
            List<Book> books = new List<Book>()
            {
                b1, b2, b3, b4, b5, b6
            };
            foreach(Book eachBook in books)
            {
                if(eachBook is ReferenceBook)
                {
                    totalPriceOfRererenceBooks += eachBook.TotalPrice;
                    numberOfReferenceBooks += eachBook.Count;
                } else if(eachBook is SchoolBook)
                {
                    totalPriceOfSchoolBooks += eachBook.TotalPrice;
                    numberOfSchoolBooks += eachBook.Count;
                }
            }
            
            Console.WriteLine($"totalPriceOfRererenceBooks: {Math.Round(totalPriceOfRererenceBooks, 1)},\n" +
                $"average : {Math.Round(totalPriceOfRererenceBooks / numberOfReferenceBooks,1)} \n" +
                $"totalPriceOfSchoolBooks: {Math.Round(totalPriceOfSchoolBooks,1)}\n"+
                $"average : {Math.Round(totalPriceOfSchoolBooks / numberOfSchoolBooks,1)}"
                );

        }
    }
}