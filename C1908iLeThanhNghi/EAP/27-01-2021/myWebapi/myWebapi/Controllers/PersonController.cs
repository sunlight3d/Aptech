using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using myWebapi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace myWebapi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PersonController : ControllerBase
    {
        [HttpGet("{id}")]
        public async Task<ActionResult<Person>> Get(int id) {
            /*
            Person mrHoang = new Person()
            {
                Id = 1,
                Name = "Hoang",
                Email = "hoang@gmail.com"
            };
            */
            Dictionary<String, Object> dictionary = new Dictionary<string, object>();
            List<Dictionary<String, Object>> listA = new List<Dictionary<String, Object>>();
            listA.Add(
                new Dictionary<string, object>() {
                    { "name", "Hoang" },
                    { "email", "dd@ff.com" },
                    { "age", 18 } 
                }                    
            );
            listA.Add(
                new Dictionary<string, object>() {
                    { "name", "JHohnh" },
                    { "email", "dddd@ff.com" },
                    { "age", 20 }
                }
            );
            dictionary["result"] = "ok";
            dictionary["data"] = listA;
            //return Ok(dictionary);
            return NotFound();
        }
        [HttpPost]
        public async Task<ActionResult> Post([FromBody] Person newPerson)
        {
            if (!ModelState.IsValid) return BadRequest(ModelState);
            Person mrHoang = new Person()
            {
                Id = 1,
                Name = "Hoang",
                Email = "hoang@gmail.com"
            };
            return Ok(mrHoang);
            //return StatusCode(500);                            
        }
        [HttpPut("{id}")]
        public async Task<ActionResult<Person>> Put(int id, [FromBody] Person person)
        {
            if (!ModelState.IsValid) return BadRequest(ModelState);

            Person mrHoang = new Person()
            {
                Id = 1,
                Name = "Hoang",
                Email = "hoang@gmail.com"
            };
            return Ok(mrHoang);
        }
    }
}
