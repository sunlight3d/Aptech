using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using ProjectAppDotNetCore.Models;

namespace ProjectAppDotNetCore.Controllers
{
    public class ProjectEmployeesController : Controller
    {
        private readonly DataContext _context;

        public ProjectEmployeesController(DataContext context)
        {
            _context = context;
        }

        // GET: ProjectEmployees
        /*
        public async Task<IActionResult> Index1()
        {
            var dataContext = _context.ProjectEmployees.Include(p => p.Employee).Include(p => p.Project);
            return View(await dataContext.ToListAsync());
        }
        */
        public async Task<IActionResult> Index(
            string sortOrder,
            string currentFilter,
            string searchString,
            int? pageNumber)
        {
            ViewData["CurrentSort"] = sortOrder;
            ViewData["NameSortParm"] = String.IsNullOrEmpty(sortOrder) ? "name_desc" : "";
            ViewData["DateSortParm"] = sortOrder == "Date" ? "date_desc" : "Date";

            if (searchString != null)
            {
                pageNumber = 1;
            }
            else
            {
                searchString = currentFilter;
            }

            ViewData["CurrentFilter"] = searchString;
            /*
            var projectEmployees = from s in _context.ProjectEmployees
                           select s;
            */
            /*
            var projectEmployees = (IQueryable)_context.ProjectEmployees
                                        .Include(p => p.Employee)
                                        .Include(p => p.Project);
            */

            var projectEmployees = (from pe in _context.ProjectEmployees
                                    join emp in _context.Employees on pe.EmployeeId equals emp.EmployeeId
                                    join proj in _context.Projects on pe.ProjectId equals proj.ProjectId
                                    select new ProjectEmployee // Kiểu dữ liệu là List<ProjectEmployee>
                                    {
                                        Id = pe.Id,
                                        EmployeeId = pe.EmployeeId,
                                        ProjectId = pe.ProjectId,
                                        Tasks = pe.Tasks,
                                        Employee = emp,
                                        Project = proj
                                    });

            //kieu du lieu cua projectEmployees la gi ?
            if (!String.IsNullOrEmpty(searchString))
            {
                
                projectEmployees = projectEmployees
                                    .Where(item => item.Employee.EmployeeName.Contains(searchString)
                                    || item.Project.ProjectName.Contains(searchString)
                                    || item.Tasks.Contains(searchString));
            }
            switch (sortOrder)
            {
                case "name_desc":
                    projectEmployees = projectEmployees
                                .OrderByDescending(item => item.Project.ProjectName);
                    break;
                case "Date":
                    projectEmployees = projectEmployees
                                .OrderBy(item => item.Project.ProjectStartDate);
                    break;
                case "date_desc":
                    projectEmployees = projectEmployees
                                .OrderByDescending(item => item.Project.ProjectStartDate);
                    break;
                default:
                    projectEmployees = projectEmployees
                                .OrderBy(item => item.Project.ProjectStartDate);
                    break;
            }

            int pageSize = 3;
            //ViewData["pageNumber"] = pageNumber ?? 1;
            return View(await PaginatedList<ProjectEmployee>
                .CreateAsync(projectEmployees.AsNoTracking(), pageNumber ?? 1, pageSize));
            
        }
        

        // GET: ProjectEmployees/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null || _context.ProjectEmployees == null)
            {
                return NotFound();
            }

            var projectEmployee = await _context.ProjectEmployees
                .Include(p => p.Employee)
                .Include(p => p.Project)
                .FirstOrDefaultAsync(m => m.Id == id);
            if (projectEmployee == null)
            {
                return NotFound();
            }

            return View(projectEmployee);
        }

        // GET: ProjectEmployees/Create
        public IActionResult Create()
        {
            ViewData["EmployeeId"] = new SelectList(_context.Employees, "EmployeeId", "EmployeeId");
            ViewData["ProjectId"] = new SelectList(_context.Projects, "ProjectId", "ProjectId");
            return View();
        }

        // POST: ProjectEmployees/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,EmployeeId,ProjectId,Tasks")] ProjectEmployee projectEmployee)
        {
            if (ModelState.IsValid)
            {
                _context.Add(projectEmployee);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            ViewData["EmployeeId"] = new SelectList(_context.Employees, "EmployeeId", "EmployeeId", projectEmployee.EmployeeId);
            ViewData["ProjectId"] = new SelectList(_context.Projects, "ProjectId", "ProjectId", projectEmployee.ProjectId);
            return View(projectEmployee);
        }

        // GET: ProjectEmployees/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null || _context.ProjectEmployees == null)
            {
                return NotFound();
            }

            var projectEmployee = await _context.ProjectEmployees.FindAsync(id);
            if (projectEmployee == null)
            {
                return NotFound();
            }
            ViewData["EmployeeId"] = new SelectList(_context.Employees, "EmployeeId", "EmployeeId", projectEmployee.EmployeeId);
            ViewData["ProjectId"] = new SelectList(_context.Projects, "ProjectId", "ProjectId", projectEmployee.ProjectId);
            return View(projectEmployee);
        }

        // POST: ProjectEmployees/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,EmployeeId,ProjectId,Tasks")] ProjectEmployee projectEmployee)
        {
            if (id != projectEmployee.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(projectEmployee);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!ProjectEmployeeExists(projectEmployee.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            ViewData["EmployeeId"] = new SelectList(_context.Employees, "EmployeeId", "EmployeeId", projectEmployee.EmployeeId);
            ViewData["ProjectId"] = new SelectList(_context.Projects, "ProjectId", "ProjectId", projectEmployee.ProjectId);
            return View(projectEmployee);
        }

        // GET: ProjectEmployees/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null || _context.ProjectEmployees == null)
            {
                return NotFound();
            }

            var projectEmployee = await _context.ProjectEmployees
                .Include(p => p.Employee)
                .Include(p => p.Project)
                .FirstOrDefaultAsync(m => m.Id == id);
            if (projectEmployee == null)
            {
                return NotFound();
            }

            return View(projectEmployee);
        }

        // POST: ProjectEmployees/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            if (_context.ProjectEmployees == null)
            {
                return Problem("Entity set 'DataContext.ProjectEmployees'  is null.");
            }
            var projectEmployee = await _context.ProjectEmployees.FindAsync(id);
            if (projectEmployee != null)
            {
                _context.ProjectEmployees.Remove(projectEmployee);
            }
            
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool ProjectEmployeeExists(int id)
        {
          return (_context.ProjectEmployees?.Any(e => e.Id == id)).GetValueOrDefault();
        }
    }
}
