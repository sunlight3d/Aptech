using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using de01.Models;
using de01.Utilities;
using de01.Services;

namespace de01.Controllers
{
    public class CustomerController : Controller
    {
        private readonly ICustomerService _customerService;

        public CustomerController(ICustomerService customerService)
        {
            _customerService = customerService;
        }

        // GET: Customer        

        public async Task<IActionResult> Index(int page = 1, int pageSize = 10)
        {
            var pagedData = await _customerService.GetCustomers(page, pageSize);
            return View(pagedData);
        }

        // GET: Customer/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var customer = await _customerService.GetCustomerDetails(id.Value);
            if (customer == null)
            {
                return NotFound();
            }

            return View(customer);
        }

        // GET: Customer/Create
        public async Task<IActionResult> Create()
        {
            var klassSelectList = await _customerService.GetKlassSelectList();
            ViewBag.ClassId = new SelectList(klassSelectList, "Id", "ClassName");            
            return View();
        }

        // POST: Customer/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,Fullname,Birthday,Address,Email,Username,Password,ConfirmPassword,ClassId")] Customer customer)
        {
            
            if (ModelState.IsValid)
            {
                await _customerService.CreateCustomer(customer);
                return RedirectToAction(nameof(Index));
            }
            var klassSelectList = await _customerService.GetKlassSelectList();
            ViewBag.ClassId = new SelectList(klassSelectList, "Id", "ClassName", customer.ClassId);
            
            return View(customer);
        }

        // GET: Customer/Edit/5
        [HttpGet]
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var customer = await _customerService.GetCustomerDetails(id.Value);
            if (customer == null)
            {
                return NotFound();
            }
            var klassSelectList = await _customerService.GetKlassSelectList();
            ViewBag.ClassId = new SelectList(klassSelectList, "Id", "ClassName", customer.ClassId);            
            return View(customer);
        }

        // POST: Customer/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Fullname,Birthday,Address,Email,Username,Password,ConfirmPassword,ClassId")] Customer customer)
        {
            if (id != customer.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    await _customerService.UpdateCustomer(customer);
                    return RedirectToAction(nameof(Index));
                }
                catch (DbUpdateConcurrencyException)
                {
                    var selectedCustomer = await _customerService.GetCustomerDetails(id);

                    if (selectedCustomer == null)
                    {
                        return NotFound();
                    }                    
                    else
                    {
                        throw;
                    }
                }                
            }
            var klassSelectList = await _customerService.GetKlassSelectList();
            ViewBag.ClassId = new SelectList(klassSelectList, "Id", "ClassName", customer.ClassId);            

            return View(customer);
        }

        // GET: Customer/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }
            var customer = await _customerService.GetCustomerDetails(id.Value);
            
            if (customer == null)
            {
                return NotFound();
            }

            return View(customer);
        }

        // POST: Customer/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            await _customerService.DeleteCustomer(id);
            return RedirectToAction(nameof(Index));
        }        
    }
}
