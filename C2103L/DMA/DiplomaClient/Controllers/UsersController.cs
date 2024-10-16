using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Net.Http;
using System.IO;
using System.Net;
using System.Text;
using Newtonsoft.Json;
using DiplomaClient.Repositories;
using DiplomaClient.Models;

namespace DiplomaClient.Controllers
{
    public class UsersController : Controller
    {
        private UsersRepository usersRepository = new UsersRepository();//old pattern
        // GET: Users
        public ActionResult Index()
        {
            //trang login
            return View();
        }
        [HttpPost]
        //nguoi dung bam login
        public ActionResult Login(FormCollection collection)
        {
            string username = collection["username"];
            string password = collection["password"];
            User loggedInUser = usersRepository.Login(username, password);

            if (loggedInUser != null)
            {
                List<User> users = usersRepository.GetUsers();
                return RedirectToAction("ListOfUsers");
            }
            else
            {
                //call api get all users
                return RedirectToAction("Index");
            }
            //return RedirectToAction("Index");
        }

        // GET: Users/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Users/Create
        public ActionResult Create()
        {
            return View();
        }
                

        [HttpGet]
        public ActionResult ListOfUsers() {
            return View();
        }
        // POST: Users/Create
        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Users/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Users/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Users/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Users/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
