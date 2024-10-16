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
    public class SexsController : ApiController
    {
        private DLMMSEntities db = new DLMMSEntities();

        // GET: api/Sexs
        public IQueryable<SEX> GetSEXes()
        {
            return db.SEXes;
        }

        // GET: api/Sexs/5
        [ResponseType(typeof(SEX))]
        public IHttpActionResult GetSEX(int id)
        {
            SEX sEX = db.SEXes.Find(id);
            if (sEX == null)
            {
                return NotFound();
            }

            return Ok(sEX);
        }

        // PUT: api/Sexs/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutSEX(int id, SEX sEX)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != sEX.SexID)
            {
                return BadRequest();
            }

            db.Entry(sEX).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!SEXExists(id))
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

        // POST: api/Sexs
        [ResponseType(typeof(SEX))]
        public IHttpActionResult PostSEX(SEX sEX)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.SEXes.Add(sEX);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (SEXExists(sEX.SexID))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = sEX.SexID }, sEX);
        }

        // DELETE: api/Sexs/5
        [ResponseType(typeof(SEX))]
        public IHttpActionResult DeleteSEX(int id)
        {
            SEX sEX = db.SEXes.Find(id);
            if (sEX == null)
            {
                return NotFound();
            }

            db.SEXes.Remove(sEX);
            db.SaveChanges();

            return Ok(sEX);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool SEXExists(int id)
        {
            return db.SEXes.Count(e => e.SexID == id) > 0;
        }
    }
}