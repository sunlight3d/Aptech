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
    public class TrainingTypesController : ApiController
    {
        private DLMMSEntities db = new DLMMSEntities();

        // GET: api/TrainingTypes
        public IQueryable<TRAINING_TYPE> GetTRAINING_TYPE()
        {
            return db.TRAINING_TYPE;
        }

        // GET: api/TrainingTypes/5
        [ResponseType(typeof(TRAINING_TYPE))]
        public IHttpActionResult GetTRAINING_TYPE(int id)
        {
            TRAINING_TYPE tRAINING_TYPE = db.TRAINING_TYPE.Find(id);
            if (tRAINING_TYPE == null)
            {
                return NotFound();
            }

            return Ok(tRAINING_TYPE);
        }

        // PUT: api/TrainingTypes/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutTRAINING_TYPE(int id, TRAINING_TYPE tRAINING_TYPE)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != tRAINING_TYPE.TrainingTypeID)
            {
                return BadRequest();
            }

            db.Entry(tRAINING_TYPE).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TRAINING_TYPEExists(id))
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

        // POST: api/TrainingTypes
        [ResponseType(typeof(TRAINING_TYPE))]
        public IHttpActionResult PostTRAINING_TYPE(TRAINING_TYPE tRAINING_TYPE)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.TRAINING_TYPE.Add(tRAINING_TYPE);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = tRAINING_TYPE.TrainingTypeID }, tRAINING_TYPE);
        }

        // DELETE: api/TrainingTypes/5
        [ResponseType(typeof(TRAINING_TYPE))]
        public IHttpActionResult DeleteTRAINING_TYPE(int id)
        {
            TRAINING_TYPE tRAINING_TYPE = db.TRAINING_TYPE.Find(id);
            if (tRAINING_TYPE == null)
            {
                return NotFound();
            }

            db.TRAINING_TYPE.Remove(tRAINING_TYPE);
            db.SaveChanges();

            return Ok(tRAINING_TYPE);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool TRAINING_TYPEExists(int id)
        {
            return db.TRAINING_TYPE.Count(e => e.TrainingTypeID == id) > 0;
        }
    }
}