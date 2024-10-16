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
    public class DiplomaTypesController : ApiController
    {
        private DLMMSEntities db = new DLMMSEntities();

        // GET: api/DiplomaTypes
        public IQueryable<DIPLOMA_TYPE> GetDIPLOMA_TYPE()
        {
            return db.DIPLOMA_TYPE;
        }

        // GET: api/DiplomaTypes/5
        [ResponseType(typeof(DIPLOMA_TYPE))]
        public IHttpActionResult GetDIPLOMA_TYPE(int id)
        {
            DIPLOMA_TYPE dIPLOMA_TYPE = db.DIPLOMA_TYPE.Find(id);
            if (dIPLOMA_TYPE == null)
            {
                return NotFound();
            }

            return Ok(dIPLOMA_TYPE);
        }

        // PUT: api/DiplomaTypes/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutDIPLOMA_TYPE(int id, DIPLOMA_TYPE dIPLOMA_TYPE)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != dIPLOMA_TYPE.DiplomaTypeID)
            {
                return BadRequest();
            }

            db.Entry(dIPLOMA_TYPE).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DIPLOMA_TYPEExists(id))
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

        // POST: api/DiplomaTypes
        [ResponseType(typeof(DIPLOMA_TYPE))]
        public IHttpActionResult PostDIPLOMA_TYPE(DIPLOMA_TYPE dIPLOMA_TYPE)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.DIPLOMA_TYPE.Add(dIPLOMA_TYPE);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = dIPLOMA_TYPE.DiplomaTypeID }, dIPLOMA_TYPE);
        }

        // DELETE: api/DiplomaTypes/5
        [ResponseType(typeof(DIPLOMA_TYPE))]
        public IHttpActionResult DeleteDIPLOMA_TYPE(int id)
        {
            DIPLOMA_TYPE dIPLOMA_TYPE = db.DIPLOMA_TYPE.Find(id);
            if (dIPLOMA_TYPE == null)
            {
                return NotFound();
            }

            db.DIPLOMA_TYPE.Remove(dIPLOMA_TYPE);
            db.SaveChanges();

            return Ok(dIPLOMA_TYPE);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool DIPLOMA_TYPEExists(int id)
        {
            return db.DIPLOMA_TYPE.Count(e => e.DiplomaTypeID == id) > 0;
        }
    }
}