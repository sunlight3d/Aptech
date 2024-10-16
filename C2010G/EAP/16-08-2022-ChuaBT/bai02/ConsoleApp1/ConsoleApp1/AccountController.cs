using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;

namespace ConsoleApp1
{
    class AccountController: ApiController
    {
        private List<Account> list;
        public AccountController() {
            list = new List<Account>();
        }
        [HttpGet]
        public IEnumerable Get() {
            return list;
        }
        public Account Get(int i) {
            return list.Count() > 0 ? list[0] : null;
        }
        [HttpGet]
        public void Post(Account item) {
            list.Add(item);
        }


        public void Put(int id, Account item)
        {
            Account foundItem = list.Where(it => it.AccNo == id).FirstOrDefault();
            if (foundItem != null) {
                foundItem.AccNo = item.AccNo;
                foundItem.Email = item.Email ?? foundItem.Email;
                foundItem.Name = item.Name ?? foundItem.Name;
            }
        }

        public void Delete(int id)
        {
            Account foundItem = list.Where(it => it.AccNo == id).FirstOrDefault();
            if (foundItem != null) {
                list.Remove(foundItem);
            }
        }
    }
}
