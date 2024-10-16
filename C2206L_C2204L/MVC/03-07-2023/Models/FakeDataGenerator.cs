using Bogus;
namespace _03_07_2023.Models
{
    public class FakeDataGenerator
    {
        private readonly MyDBContext _dbContext;

        public FakeDataGenerator(MyDBContext dbContext)
        {
            _dbContext = dbContext;
        }

        public void GenerateFakeProducts(int count)
        {
            var faker = new Faker();
            if (_dbContext.Products.Any()) {
                return;
            }
            for (int i = 0; i < count; i++)
            {
                var product = new Product
                {
                    Name = faker.Commerce.ProductName(),
                    Price = faker.Random.Float(0, 100000000),
                    Count = faker.Random.Int(0, 100),
                    Description = faker.Lorem.Sentence()
                };

                _dbContext.Products.Add(product);
            }

            _dbContext.SaveChanges();
        }
    }


}
