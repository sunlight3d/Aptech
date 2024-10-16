using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using DipplomaApp.Models;

namespace DipplomaApp.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TrainingProgramsController : ControllerBase
    {
        private readonly DlmmsContext _context;

        public TrainingProgramsController(DlmmsContext context)
        {
            _context = context;
        }

        // GET: api/TrainingPrograms
        [HttpGet]
        public async Task<ActionResult<IEnumerable<TrainingProgram>>> GetTrainingPrograms()
        {
          if (_context.TrainingPrograms == null)
          {
              return NotFound();
          }
            return await _context.TrainingPrograms.ToListAsync();
        }

        // GET: api/TrainingPrograms/5
        [HttpGet("{id}")]
        public async Task<ActionResult<TrainingProgram>> GetTrainingProgram(int id)
        {
          if (_context.TrainingPrograms == null)
          {
              return NotFound();
          }
            var trainingProgram = await _context.TrainingPrograms.FindAsync(id);

            if (trainingProgram == null)
            {
                return NotFound();
            }

            return trainingProgram;
        }

        // PUT: api/TrainingPrograms/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutTrainingProgram(int id, TrainingProgram trainingProgram)
        {
            if (id != trainingProgram.TrainingProgramId)
            {
                return BadRequest();
            }

            _context.Entry(trainingProgram).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TrainingProgramExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/TrainingPrograms
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<TrainingProgram>> PostTrainingProgram(TrainingProgram trainingProgram)
        {
          if (_context.TrainingPrograms == null)
          {
              return Problem("Entity set 'DlmmsContext.TrainingPrograms'  is null.");
          }
            _context.TrainingPrograms.Add(trainingProgram);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetTrainingProgram", new { id = trainingProgram.TrainingProgramId }, trainingProgram);
        }

        // DELETE: api/TrainingPrograms/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteTrainingProgram(int id)
        {
            if (_context.TrainingPrograms == null)
            {
                return NotFound();
            }
            var trainingProgram = await _context.TrainingPrograms.FindAsync(id);
            if (trainingProgram == null)
            {
                return NotFound();
            }

            _context.TrainingPrograms.Remove(trainingProgram);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool TrainingProgramExists(int id)
        {
            return (_context.TrainingPrograms?.Any(e => e.TrainingProgramId == id)).GetValueOrDefault();
        }
    }
}
