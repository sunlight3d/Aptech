using System;
using de01.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace de01.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class DiplomaController : ControllerBase
    {
        private readonly DiplomaDbContext _context;

        public DiplomaController(DiplomaDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<Diploma>>> GetDiplomas()
        {
            return await _context.Diplomas.ToListAsync();
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<Diploma>> GetDiploma(int id)
        {
            var diploma = await _context.Diplomas.FindAsync(id);

            if (diploma == null)
            {
                return NotFound();
            }

            return diploma;
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> PutDiploma(int id, Diploma diploma)
        {
            if (id != diploma.DiplomaID)
            {
                return BadRequest();
            }

            _context.Entry(diploma).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DiplomaExists(id))
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
        public async Task<ActionResult<Diploma>> PostDiploma(Diploma diploma)
        {
            _context.Diplomas.Add(diploma);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetDiploma", new { id = diploma.DiplomaID }, diploma);
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteDiploma(int id)
        {
            var diploma = await _context.Diplomas.FindAsync(id);
            if (diploma == null)
            {
                return NotFound();
            }

            _context.Diplomas.Remove(diploma);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        [HttpGet("Search")]
        public async Task<ActionResult<IEnumerable<Diploma>>> Search(string strsearch)
        {
            if (string.IsNullOrEmpty(strsearch))
            {
                return BadRequest();
            }

            var diplomas = await _context.Diplomas
                .Where(d => d.FullName.Contains(strsearch) ||
                    d.BirthPlace.Contains(strsearch)).ToListAsync();

            if (diplomas == null || diplomas.Count == 0)
            {
                return NotFound();
            }

            return diplomas;
        }

        private bool DiplomaExists(int id)
        {
            return _context.Diplomas.Any(e => e.DiplomaID == id);
        }
    }

}

