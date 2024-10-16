using Microsoft.AspNetCore.Mvc.Rendering;

namespace de01.Repositories
{
    public interface IKlassRepository
    {
        Task<IEnumerable<SelectListItem>> GetKlassesAsSelectListItems();
    }

}
