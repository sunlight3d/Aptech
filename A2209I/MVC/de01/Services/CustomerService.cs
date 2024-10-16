using de01.Models;
using de01.Repositories;
using de01.Utilities;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.CodeAnalysis.Diagnostics;
using Microsoft.EntityFrameworkCore;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace de01.Services
{
    public class CustomerService : ICustomerService
    {
        private readonly ICustomerRepository _customerRepository;
        private readonly IKlassRepository _klassRepository;

        public CustomerService(ICustomerRepository customerRepository, IKlassRepository klassRepository)
        {
            _customerRepository = customerRepository;
            _klassRepository = klassRepository;
        }

        public async Task<PaginatedList<Customer>> GetCustomers(int page, int pageSize)
        {
            var query = _customerRepository.GetAllCustomers(page, pageSize);
            var list = await query.ToListAsync();
            return new PaginatedList<Customer>(list, list.Count, page, pageSize);
        }



        public async Task<Customer> GetCustomerDetails(int id)
        {
            return await _customerRepository.GetCustomerById(id);
        }

        public async Task CreateCustomer(Customer customer)
        {
            await _customerRepository.AddCustomer(customer);
        }

        public async Task UpdateCustomer(Customer customer)
        {
            await _customerRepository.UpdateCustomer(customer);
        }

        public async Task DeleteCustomer(int id)
        {
            await _customerRepository.DeleteCustomer(id);
        }

        public bool CustomerExists(int id)
        {
            return _customerRepository.CustomerExists(id);
        }
        public async Task<IEnumerable<SelectListItem>> GetKlassSelectList()
        {
            return await _klassRepository.GetKlassesAsSelectListItems();
        }
    }

}
