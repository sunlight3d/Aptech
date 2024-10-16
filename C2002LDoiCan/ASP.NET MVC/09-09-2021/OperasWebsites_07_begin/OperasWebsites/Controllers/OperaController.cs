using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data.Entity;
using OperasWebsites.Models;
//Admin => Area
namespace OperasWebSite.Controllers
{
    public class OperaController : Controller
    {
        private OperasDB contextDB = new OperasDB();

        //
        // GET: /Opera/

        public ActionResult Index()
        {
            return View("Index", contextDB.Operas.ToList());
        }

        public ActionResult Details(int id)
        {
            Opera opera = contextDB.Operas.Find(id);
            if (opera != null)
            {
                //Views/Opera/Details.cshtml
                return View("Details", opera);
            }
            else
            {
                return HttpNotFound();
            }
        }
        
        public ActionResult DetailsByTitle(string title)
        {            
            //LINQ = Language Integrated Query 
            //trong Java => stream (>= jdk 8)
            //ko nen for loop
            Opera opera = (Opera)contextDB
                .Operas.Where(eachOpera => eachOpera.Title.Contains(title)).FirstOrDefault();
            
            //select top 1 from Operas where title = title;
            //pagination 
            //select top 10 from xxx where offset 3 * 10
            if (opera == null)
            {
                return HttpNotFound();
            }
            return View("Details", opera);

        }
        public ActionResult Create()
        {
            Opera newOpera = new Opera();
            return View("Create", newOpera);
        }

        [HttpPost]
        public ActionResult Create(Opera newOpera)
        {
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
