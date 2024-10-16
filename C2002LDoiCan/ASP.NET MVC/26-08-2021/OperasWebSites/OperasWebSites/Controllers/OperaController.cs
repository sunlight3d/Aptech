using OperasWebSites.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace OperasWebSites.Controllers
{
    public class OperaController : Controller
    {
        private OperasDB contextDB = new OperasDB();
        // GET: Opera
        public ActionResult Index()
        {
            //truyen tham so vao View: Opera/Index.cshtml, params:contextDB.Operas.ToList()
            return View("Index", contextDB.Operas.ToList());
        }
        public ActionResult Details(int id)
        {
            //Opera/Details.cshtml
            Opera opera = contextDB.Operas.Find(id);
            if (opera != null)
            {
                return View("Details", opera);
            }
            else
            {
                return HttpNotFound();
            }
        }
        public ActionResult Create()
        {
            //Views/Opera/Create.cshtml
            Opera newOpera = new Opera();            
            if (ModelState.IsValid)
            {
                contextDB.Operas.Add(newOpera);
                contextDB.SaveChanges();
                return RedirectToAction("Index");
            }
            else
            {
                return View("Create", newOpera);
            }
        }
    }
}