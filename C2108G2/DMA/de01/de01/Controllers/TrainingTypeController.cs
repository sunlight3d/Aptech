using System;
using de01.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace de01.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class TrainingTypeController : ControllerBase
    {
        private readonly DiplomaDbContext _context;

        public TrainingTypeController(DiplomaDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<TrainingType>>> GetTrainingTypes()
        {
            return await _context.TrainingTypes.ToListAsync();
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<TrainingType>> GetTrainingType(int id)
        {
            var trainingType = await _context.TrainingTypes.FindAsync(id);

            if (trainingType == null)
            {
                return NotFound();
            }

            return trainingType;
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> PutTrainingType(int id, TrainingType trainingType)
        {
            if (id != trainingType.TrainingTypeID)
            {
                return BadRequest();
            }

            _context.Entry(trainingType).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TrainingTypeExists(id))
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

        [HttpPost]
        public async Task<ActionResult<TrainingType>> PostTrainingType(TrainingType trainingType)
        {
            _context.TrainingTypes.Add(trainingType);
            await _context.SaveChangesAsync();
            return CreatedAtAction("GetTrainingType", new { id = trainingType.TrainingTypeID }, trainingType);
        }
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteTrainingType(int id)
        {
            var trainingType = await _context.TrainingTypes.FindAsync(id);
            if (trainingType == null)
            {
                return NotFound();
            }

            _context.TrainingTypes.Remove(trainingType);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool TrainingTypeExists(int id)
        {
            return _context.TrainingTypes.Any(e => e.TrainingTypeID == id);
        }
    }
}

