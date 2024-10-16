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
    public class TrainingProgramsController : ApiController
    {
        private DLMMSEntities db = new DLMMSEntities();

        // GET: api/TrainingPrograms
        public IQueryable<TRAINING_PROGRAM> GetTRAINING_PROGRAM()
        {
            return db.TRAINING_PROGRAM;
        }

        // GET: api/TrainingPrograms/5
        [ResponseType(typeof(TRAINING_PROGRAM))]
        public IHttpActionResult GetTRAINING_PROGRAM(int id)
        {
            TRAINING_PROGRAM tRAINING_PROGRAM = db.TRAINING_PROGRAM.Find(id);
            if (tRAINING_PROGRAM == null)
            {
                return NotFound();
            }

            return Ok(tRAINING_PROGRAM);
        }

        // PUT: api/TrainingPrograms/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutTRAINING_PROGRAM(int id, TRAINING_PROGRAM tRAINING_PROGRAM)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != tRAINING_PROGRAM.TrainingProgramID)
            {
                return BadRequest();
            }

            db.Entry(tRAINING_PROGRAM).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TRAINING_PROGRAMExists(id))
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

        // POST: api/TrainingPrograms
        [ResponseType(typeof(TRAINING_PROGRAM))]
        public IHttpActionResult PostTRAINING_PROGRAM(TRAINING_PROGRAM tRAINING_PROGRAM)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.TRAINING_PROGRAM.Add(tRAINING_PROGRAM);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = tRAINING_PROGRAM.TrainingProgramID }, tRAINING_PROGRAM);
        }

        // DELETE: api/TrainingPrograms/5
        [ResponseType(typeof(TRAINING_PROGRAM))]
        public IHttpActionResult DeleteTRAINING_PROGRAM(int id)
        {
            TRAINING_PROGRAM tRAINING_PROGRAM = db.TRAINING_PROGRAM.Find(id);
            if (tRAINING_PROGRAM == null)
            {
                return NotFound();
            }

            db.TRAINING_PROGRAM.Remove(tRAINING_PROGRAM);
            db.SaveChanges();

            return Ok(tRAINING_PROGRAM);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool TRAINING_PROGRAMExists(int id)
        {
            return db.TRAINING_PROGRAM.Count(e => e.TrainingProgramID == id) > 0;
        }
    }
}