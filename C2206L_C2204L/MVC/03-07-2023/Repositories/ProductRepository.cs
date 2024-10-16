using _03_07_2023.Models;

namespace _03_07_2023.Repositories
{
    public class ProductRepository : IProductRepository
    {
        private readonly MyDBContext _dbContext;

        public ProductRepository(MyDBContext dbContext)
        {
            _dbContext = dbContext;
        }

        public IEnumerable<Product> GetAll(int page = 1, int limit = 10)
        {
            // Kiểm tra và điều chỉnh giá trị mặc định của page và limit
            page = Math.Max(1, page);
            limit = Math.Max(1, limit);

            // Tính toán số lượng bản ghi cần bỏ qua
            int skip = (page - 1) * limit;

            // Lấy danh sách sản phẩm theo phân trang
            var products = _dbContext.Products
                .Skip(skip)
                .Take(limit)
                .ToList();

            return products;
        }



        public Product? GetById(int id)
        {
            return _dbContext.Products
                            .Where(product => product.Id == id)
                            .FirstOrDefault();
        }

        public void Add(Product product)
        {
            _dbContext.Products.Add(product);
            _dbContext.SaveChanges();
        }

        public void Update(Product product)
        {
            //chỉ update những trường != null
            //những trường = null => ko thay đổi giá trị
            _dbContext.Products.Update(product);
            _dbContext.SaveChanges();
        }

        public void Delete(int id)
        {
            //Nếu xóa mềm thì sao ?
            var product = _dbContext.Products.Find(id);
            if (product != null)
            {
                _dbContext.Products.Remove(product);
                _dbContext.SaveChanges();
            }
        }
    }

}
