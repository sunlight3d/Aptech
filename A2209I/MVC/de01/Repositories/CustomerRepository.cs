using de01.Models;
using Microsoft.EntityFrameworkCore;

namespace de01.Repositories
{
    public class CustomerRepository : ICustomerRepository
{
    private readonly DataContext _context;

    public CustomerRepository(DataContext context)
    {
        _context = context;
    }

        public IQueryable<Customer> GetAllCustomers(int page, int pageSize)
        {
            return _context.Customers
                           .Include(c => c.Klass)
                           .Skip((page - 1) * pageSize)
                           .Take(pageSize)
                           .AsNoTracking();
        }


        public async Task<Customer> GetCustomerById(int id)
    {
        return await _context.Customers
                             .Include(c => c.Klass)
                             .FirstOrDefaultAsync(c => c.Id == id);
    }

    public async Task AddCustomer(Customer customer)
    {
        _context.Add(customer);
        await _context.SaveChangesAsync();
    }

    public async Task UpdateCustomer(Customer customer)
    {
        _context.Update(customer);
        await _context.SaveChangesAsync();
    }

    public async Task DeleteCustomer(int id)
    {
        var customer = await _context.Customers.FindAsync(id);
        if (customer != null)
        {
            _context.Customers.Remove(customer);
            await _context.SaveChangesAsync();
        }
    }

    public bool CustomerExists(int id)
    {
        return _context.Customers.Any(e => e.Id == id);
    }
}

}
