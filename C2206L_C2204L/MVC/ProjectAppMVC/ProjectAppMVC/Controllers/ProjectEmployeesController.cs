using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using PagedList;
using ProjectAppMVC.Models;

namespace ProjectAppMVC.Controllers
{
    public class ProjectEmployeesController : Controller
    {
        private DataContext db = new DataContext();

        // GET: ProjectEmployees
        public ActionResult Index(
            string sortOrder,
            string currentFilter,
            string searchString,
            int? pageNumber
            )
        {
            /*
            var projectEmployees = db.ProjectEmployees.Include(p => p.Employee).Include(p => p.Project);
            return View(projectEmployees.ToList());
            */
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
            var projectEmployees = (from pe in db.ProjectEmployees
                                    join emp in db.Employees on pe.EmployeeId equals emp.EmployeeId
                                    join proj in db.Projects on pe.ProjectId equals proj.ProjectId
                                    select new ProjectEmployee // Kiểu dữ liệu là List<ProjectEmployee>
                                    {
                                        Id = pe.Id,
                                        EmployeeId = pe.EmployeeId,
                                        ProjectId = pe.ProjectId,
                                        Tasks = pe.Tasks,
                                        Employee = emp,
                                        Project = proj
                                    });
            */
            var projectEmployees = (from pe in db.ProjectEmployees
                                    join emp in db.Employees on pe.EmployeeId equals emp.EmployeeId
                                    join proj in db.Projects on pe.ProjectId equals proj.ProjectId
                                    select new
                                    {
                                        Id = pe.Id,
                                        EmployeeId = pe.EmployeeId,
                                        ProjectId = pe.ProjectId,
                                        Tasks = pe.Tasks,
                                        Employee = emp,
                                        Project = proj
                                    })
                        .ToList() // Chuyển hướng từ LINQ to Entities sang LINQ to Objects
                        .Select(pe => new ProjectEmployee
                        {
                            Id = pe.Id,
                            EmployeeId = pe.EmployeeId,
                            ProjectId = pe.ProjectId,
                            Tasks = pe.Tasks,
                            Employee = pe.Employee,
                            Project = pe.Project
                        });
            //kieu du lieu cua projectEmployees la gi ?
            if (!String.IsNullOrEmpty(searchString))
            {

                projectEmployees = projectEmployees
                                    .Where(item => item.Employee.EmployeeName.Contains(searchString)
                                    || item.Project.ProjectName.Contains(searchString)
                                    || item.Tasks.Contains(searchString));
            }
            int totalTasks = projectEmployees.Sum(item => item.NumberOfTasks);
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
            ViewBag.totalTasks = totalTasks;
            return View(projectEmployees.ToPagedList(pageNumber ?? 1, pageSize));
        }

        // GET: ProjectEmployees/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ProjectEmployee projectEmployee = db.ProjectEmployees.Find(id);
            if (projectEmployee == null)
            {
                return HttpNotFound();
            }
            return View(projectEmployee);
        }

        // GET: ProjectEmployees/Create
        public ActionResult Create()
        {
            ViewBag.EmployeeId = new SelectList(db.Employees, "EmployeeId", "EmployeeName");
            ViewBag.ProjectId = new SelectList(db.Projects, "ProjectId", "ProjectName");
            return View();
        }

        // POST: ProjectEmployees/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,EmployeeId,ProjectId,Tasks")] ProjectEmployee projectEmployee)
        {
            if (ModelState.IsValid)
            {
                db.ProjectEmployees.Add(projectEmployee);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.EmployeeId = new SelectList(db.Employees, "EmployeeId", "EmployeeName", projectEmployee.EmployeeId);
            ViewBag.ProjectId = new SelectList(db.Projects, "ProjectId", "ProjectName", projectEmployee.ProjectId);
            return View(projectEmployee);
        }

        // GET: ProjectEmployees/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ProjectEmployee projectEmployee = db.ProjectEmployees.Find(id);
            if (projectEmployee == null)
            {
                return HttpNotFound();
            }
            ViewBag.EmployeeId = new SelectList(db.Employees, "EmployeeId", "EmployeeName", projectEmployee.EmployeeId);
            ViewBag.ProjectId = new SelectList(db.Projects, "ProjectId", "ProjectName", projectEmployee.ProjectId);
            return View(projectEmployee);
        }

        // POST: ProjectEmployees/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,EmployeeId,ProjectId,Tasks")] ProjectEmployee projectEmployee)
        {
            if (ModelState.IsValid)
            {
                db.Entry(projectEmployee).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.EmployeeId = new SelectList(db.Employees, "EmployeeId", "EmployeeName", projectEmployee.EmployeeId);
            ViewBag.ProjectId = new SelectList(db.Projects, "ProjectId", "ProjectName", projectEmployee.ProjectId);
            return View(projectEmployee);
        }

        // GET: ProjectEmployees/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ProjectEmployee projectEmployee = db.ProjectEmployees.Find(id);
            if (projectEmployee == null)
            {
                return HttpNotFound();
            }
            return View(projectEmployee);
        }

        // POST: ProjectEmployees/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            ProjectEmployee projectEmployee = db.ProjectEmployees.Find(id);
            db.ProjectEmployees.Remove(projectEmployee);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
