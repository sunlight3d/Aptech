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
    [RoutePrefix("api/Diplomas")]
    public class DiplomasController : ApiController
    {
        private DLMMSEntities db = new DLMMSEntities();

        // GET: api/Diplomas
        [HttpGet]
        public IQueryable<DIPLOMA> GetDiplomata()
        {
            return db.Diplomata;
        }
        [HttpGet]
        [Route("Search")]
        public IQueryable<DIPLOMA> Search(string strSearch)
        {
            var filteredDiplomas = db.Diplomata.Where(diploma =>
                                diploma.FullName.ToLower().Contains(strSearch.ToLower()));
            return filteredDiplomas;
        }

        // GET: api/Diplomas/5
        [ResponseType(typeof(DIPLOMA))]
        public IHttpActionResult GetDIPLOMA(int id)
        {
            DIPLOMA dIPLOMA = db.Diplomata.Find(id);
            if (dIPLOMA == null)
            {
                return NotFound();
            }

            return Ok(dIPLOMA);
        }

        // PUT: api/Diplomas/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutDIPLOMA(int id, DIPLOMA dIPLOMA)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != dIPLOMA.DiplomaID)
            {
                return BadRequest();
            }

            db.Entry(dIPLOMA).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DIPLOMAExists(id))
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

        // POST: api/Diplomas
        [ResponseType(typeof(DIPLOMA))]
        public IHttpActionResult PostDIPLOMA(DIPLOMA dIPLOMA)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Diplomata.Add(dIPLOMA);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = dIPLOMA.DiplomaID }, dIPLOMA);
        }

        // DELETE: api/Diplomas/5
        [ResponseType(typeof(DIPLOMA))]
        public IHttpActionResult DeleteDIPLOMA(int id)
        {
            DIPLOMA dIPLOMA = db.Diplomata.Find(id);
            if (dIPLOMA == null)
            {
                return NotFound();
            }

            db.Diplomata.Remove(dIPLOMA);
            db.SaveChanges();

            return Ok(dIPLOMA);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool DIPLOMAExists(int id)
        {
            return db.Diplomata.Count(e => e.DiplomaID == id) > 0;
        }
    }
}