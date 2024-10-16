using de01.Models;
using de01.Utilities;
using Microsoft.AspNetCore.Mvc.Rendering;

namespace de01.Services
{
    public interface ICustomerService
    {
        Task<PaginatedList<Customer>> GetCustomers(int page, int pageSize);
        Task<Customer> GetCustomerDetails(int id);
        Task CreateCustomer(Customer customer);
        Task UpdateCustomer(Customer customer);
        Task DeleteCustomer(int id);
        bool CustomerExists(int id);
        Task<IEnumerable<SelectListItem>> GetKlassSelectList();
    }

}
