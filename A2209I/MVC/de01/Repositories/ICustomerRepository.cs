using de01.Models;

namespace de01.Repositories
{
    public interface ICustomerRepository
    {
        public IQueryable<Customer> GetAllCustomers(int page, int pageSize);
        Task<Customer> GetCustomerById(int id);
        Task AddCustomer(Customer customer);
        Task UpdateCustomer(Customer customer);
        Task DeleteCustomer(int id);
        bool CustomerExists(int id);
    }

}
