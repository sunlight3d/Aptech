using Owin_TenSinhVien.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;

namespace Owin_TenSinhVien.Controllers
{
    public class CompanyController: ApiController
    {
        private List<Company> companies;
        CompanyController() {
            companies = new List<Company>()
            {
                new Company(){ 
                    Id = 1,
                    Name = "Apple",
                    Nation = "US",
                    YearFounded = 1977
                },
                new Company(){
                    Id = 2,
                    Name = "Nokia",
                    Nation = "Finland",
                    YearFounded = 1865
                },
                new Company(){
                    Id = 3,
                    Name = "Samsung",
                    Nation = "Korea",
                    YearFounded = 1938
                }
            };
        }
        [HttpGet]
        public IHttpActionResult Get() {
            return (IHttpActionResult)companies.ToList();
        }
        public Company Get(int id)
        {
            return companies.FirstOrDefault(company => company.Id == id);
        }
        public void Post(Company item) {
            companies.Add(item);
        }
        public void Put(int id, Company item) {
            Company selectedCompany = companies.FirstOrDefault(company => company.Id == id);
            if (selectedCompany != null) {
                selectedCompany.Name = item.Name;
                selectedCompany.Nation = item.Nation;
                selectedCompany.YearFounded = item.YearFounded;
            }
        }
    }
}
