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
    public class DiplomaTypesController : ControllerBase
    {
        private readonly DlmmsContext _context;

        public DiplomaTypesController(DlmmsContext context)
        {
            _context = context;
        }

        // GET: api/DiplomaTypes
        [HttpGet]
        public async Task<ActionResult<IEnumerable<DiplomaType>>> GetDiplomaTypes()
        {
          if (_context.DiplomaTypes == null)
          {
              return NotFound();
          }
            return await _context.DiplomaTypes.ToListAsync();
        }

        // GET: api/DiplomaTypes/5
        [HttpGet("{id}")]
        public async Task<ActionResult<DiplomaType>> GetDiplomaType(int id)
        {
          if (_context.DiplomaTypes == null)
          {
              return NotFound();
          }
            var diplomaType = await _context.DiplomaTypes.FindAsync(id);

            if (diplomaType == null)
            {
                return NotFound();
            }

            return diplomaType;
        }

        // PUT: api/DiplomaTypes/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutDiplomaType(int id, DiplomaType diplomaType)
        {
            if (id != diplomaType.DiplomaTypeId)
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

        // POST: api/DiplomaTypes
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<DiplomaType>> PostDiplomaType(DiplomaType diplomaType)
        {
          if (_context.DiplomaTypes == null)
          {
              return Problem("Entity set 'DlmmsContext.DiplomaTypes'  is null.");
          }
            _context.DiplomaTypes.Add(diplomaType);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetDiplomaType", new { id = diplomaType.DiplomaTypeId }, diplomaType);
        }

        // DELETE: api/DiplomaTypes/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteDiplomaType(int id)
        {
            if (_context.DiplomaTypes == null)
            {
                return NotFound();
            }
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
            return (_context.DiplomaTypes?.Any(e => e.DiplomaTypeId == id)).GetValueOrDefault();
        }
    }
}
