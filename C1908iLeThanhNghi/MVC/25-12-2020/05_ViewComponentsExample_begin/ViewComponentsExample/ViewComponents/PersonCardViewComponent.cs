using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ViewComponentsExample.ViewComponents
{
    public class PersonCardViewComponent : ViewComponent
    {
        public Task<IViewComponentResult> InvokeAsync(int id)
        {
            return Task.FromResult<IViewComponentResult>(View("CardDesign", id));
        }
    }

}
