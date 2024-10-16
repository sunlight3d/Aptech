using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using DiplomaDotNetApi.Models;

namespace DiplomaDotNetApi.Controllers
{
    //[Route("api/Users")]
    [RoutePrefix("api/Users")]
    public class UsersController : ApiController
    {
        private DLMMSEntities db = new DLMMSEntities();

        // GET: api/Users
        public IQueryable<USER> GetUSERS()
        {
            return db.USERS;
        }

        // GET: api/Users/5
        [ResponseType(typeof(USER))]
        public IHttpActionResult GetUSER(int id)
        {
            USER uSER = db.USERS.Find(id);
            if (uSER == null)
            {
                return NotFound();
            }

            return Ok(uSER);
        }
        [ResponseType(typeof(USER))]
        [HttpPost]
        [Route("CheckLogin")]
        public IHttpActionResult CheckLogin(string UserName, string Password)
        {
            
            int xx = 11;
            USER loggedInUser = db.USERS
                .Where(user => user.UserName.Equals(UserName)
                    && user.Password.Equals(Password))
                .FirstOrDefault(); //LinQ
            if (loggedInUser == null)
            {
                return NotFound();
            }

            return Ok(loggedInUser);
          
        }


        // PUT: api/Users/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutUSER(int id, USER uSER)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != uSER.UsersID)
            {
                return BadRequest();
            }

            db.Entry(uSER).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!USERExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Users
        /*
        [ResponseType(typeof(USER))]
        public IHttpActionResult PostUSER(USER uSER)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.USERS.Add(uSER);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (USERExists(uSER.UsersID))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = uSER.UsersID }, uSER);
        }
        */
        // DELETE: api/Users/5
        [ResponseType(typeof(USER))]
        public IHttpActionResult DeleteUSER(int id)
        {
            USER uSER = db.USERS.Find(id);
            if (uSER == null)
            {
                return NotFound();
            }

            db.USERS.Remove(uSER);
            db.SaveChanges();

            return Ok(uSER);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool USERExists(int id)
        {
            return db.USERS.Count(e => e.UsersID == id) > 0;
        }
    }
}