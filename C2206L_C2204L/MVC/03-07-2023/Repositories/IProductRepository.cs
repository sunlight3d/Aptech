using _03_07_2023.Models;

namespace _03_07_2023.Repositories
{
    public interface IProductRepository
    {
        IEnumerable<Product> GetAll(int page, int limit);
        Product? GetById(int id);
        void Add(Product product);
        void Update(Product product);
        void Delete(int id);
    }
}
