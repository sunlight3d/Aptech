using de01.Models;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;

namespace de01.Repositories
{
    public class KlassRepository : IKlassRepository
    {
        private readonly DataContext _context;

        public KlassRepository(DataContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<SelectListItem>> GetKlassesAsSelectListItems()
        {
            return await _context.Klasses
                                 .Select(k => new SelectListItem
                                 {
                                     Value = k.Id.ToString(),
                                     Text = k.ClassName
                                 }).ToListAsync();
        }
    }

}
