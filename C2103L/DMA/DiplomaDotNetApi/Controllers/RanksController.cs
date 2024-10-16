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
    public class RanksController : ApiController
    {
        private DLMMSEntities db = new DLMMSEntities();

        // GET: api/Ranks
        public IQueryable<RANK> GetRANKs()
        {
            return db.RANKs;
        }

        // GET: api/Ranks/5
        [ResponseType(typeof(RANK))]
        public IHttpActionResult GetRANK(int id)
        {
            RANK rANK = db.RANKs.Find(id);
            if (rANK == null)
            {
                return NotFound();
            }

            return Ok(rANK);
        }

        // PUT: api/Ranks/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutRANK(int id, RANK rANK)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != rANK.RankID)
            {
                return BadRequest();
            }

            db.Entry(rANK).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!RANKExists(id))
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

        // POST: api/Ranks
        [ResponseType(typeof(RANK))]
        public IHttpActionResult PostRANK(RANK rANK)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.RANKs.Add(rANK);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = rANK.RankID }, rANK);
        }

        // DELETE: api/Ranks/5
        [ResponseType(typeof(RANK))]
        public IHttpActionResult DeleteRANK(int id)
        {
            RANK rANK = db.RANKs.Find(id);
            if (rANK == null)
            {
                return NotFound();
            }

            db.RANKs.Remove(rANK);
            db.SaveChanges();

            return Ok(rANK);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool RANKExists(int id)
        {
            return db.RANKs.Count(e => e.RankID == id) > 0;
        }
    }
}