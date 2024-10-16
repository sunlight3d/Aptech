using DipplomaApp.Repositories;
using DipplomaAppClient.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace DiplomaAppClient.Controllers
{
    public class UsersController : Controller
    {
        private readonly IUserRepository _repository;
        // GET: UsersController
        
        public UsersController(IUserRepository repository)
        {
            _repository = repository;
        }
        // GET: UsersController
        public async Task <ActionResult> Index()
        {
            return View();
        }

        // GET: UsersController/Details/5
        public async Task<ActionResult> Details(int id)
        {
            return View();
        }

        // GET: UsersController/Create
        public async Task<ActionResult> Create()
        {
            return View();
        }

        // POST: UsersController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create(IFormCollection collection)
        {
            string userName = collection["username"];
            string password = collection["password"];
            try
            {
                
                Console.WriteLine("aaaa");
                
                    User user = await _repository.Login(userName, password);
                    if (user == null)
                    {
                        ViewBag.Error = "Name or password incorrect";
                        return View();
                    }
                    return RedirectToAction(nameof(Index));
                                
            }
            catch
            {
                return View();
            }
        }

        // GET: UsersController/Edit/5
        public async Task<ActionResult> Edit(int id)
        {
            return View();
        }

        // POST: UsersController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: UsersController/Delete/5
        public async Task<ActionResult> Delete(int id)
        {
            return View();
        }

        // POST: UsersController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
