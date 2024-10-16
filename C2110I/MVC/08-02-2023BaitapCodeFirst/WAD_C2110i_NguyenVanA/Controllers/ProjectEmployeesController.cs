using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using WAD_C2110i_NguyenVanA.Models;

namespace WAD_C2110i_NguyenVanA.Controllers
{
    public class ProjectEmployeesController : Controller
    {
        private DataContext db = new DataContext();

        // GET: ProjectEmployees
        public ActionResult Index()
        {
            var projectEmployees = db.ProjectEmployees.Include(p => p.Employee).Include(p => p.Project);
            return View(projectEmployees.ToList());
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
        public ActionResult Create([Bind(Include = "ProjectId,EmployeeId")] ProjectEmployee projectEmployee)
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
        public ActionResult Edit([Bind(Include = "ProjectId,EmployeeId")] ProjectEmployee projectEmployee)
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
