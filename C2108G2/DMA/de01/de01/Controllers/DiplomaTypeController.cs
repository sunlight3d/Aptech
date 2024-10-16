using System;
using de01.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace de01.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class DiplomaTypeController : ControllerBase
    {
        private readonly DiplomaDbContext _context;

        public DiplomaTypeController(DiplomaDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<DiplomaType>>> GetDiplomaTypes()
        {
            return await _context.DiplomaTypes.ToListAsync();
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<DiplomaType>> GetDiplomaType(int id)
        {
            var diplomaType = await _context.DiplomaTypes.FindAsync(id);

            if (diplomaType == null)
            {
                return NotFound();
            }

            return diplomaType;
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> PutDiplomaType(int id, DiplomaType diplomaType)
        {
            if (id != diplomaType.DiplomaTypeID)
            {
                return BadRequest();
            }

            _context.Entry(diplomaType).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DiplomaTypeExists(id))
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
        public async Task<ActionResult<DiplomaType>>
            PostDiplomaType(DiplomaType diplomaType)
        {
            _context.DiplomaTypes.Add(diplomaType);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetDiplomaType",
                new { id = diplomaType.DiplomaTypeID }, diplomaType);
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteDiplomaType(int id)
        {
            var diplomaType = await _context.DiplomaTypes.FindAsync(id);
            if (diplomaType == null)
            {
                return NotFound();
            }

            _context.DiplomaTypes.Remove(diplomaType);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool DiplomaTypeExists(int id)
        {
            return _context.DiplomaTypes.Any(e => e.DiplomaTypeID == id);
        }
    }

}

