using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using DipplomaApp.Models;
using com.sun.org.apache.xpath.@internal.operations;
using static com.sun.tools.@internal.xjc.reader.xmlschema.bindinfo.BIConversion;

namespace DipplomaApp.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class DiplomasController : ControllerBase
    {
        private readonly DlmmsContext _context;

        public DiplomasController(DlmmsContext context)
        {
            _context = context;
        }
        // GET: api/Diplomas
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Diploma>>> GetDiplomas(string strSearch)
        {
          if (_context.Diplomas == null)
          {
              return NotFound();
          }
            if (string.IsNullOrEmpty(strSearch))
            {
                return await _context.Diplomas.ToListAsync();
            }
            var diplomas = await _context.Diplomas               
               .ToListAsync();

            return await _context.Diplomas
                .Where(diploma =>
                    (diploma.FullName ?? "").ToLower().Contains(strSearch.ToLower())
                    || (diploma.BirthPlace ?? "").ToLower().Contains(strSearch.ToLower()))
                .ToListAsync();

            /*
            return diplomas
                   .Where(item 
                    => Utilities.CheckContain(item.FullName, strSearch) ||
                           Utilities.CheckContain(item.BirthPlace, strSearch))
               .ToList();            
            */            
        }
        
        // GET: api/Diplomas/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Diploma>> GetDiploma(int id)
        {
          if (_context.Diplomas == null)
          {
              return NotFound();
          }
            var diploma = await _context.Diplomas.FindAsync(id);

            if (diploma == null)
            {
                return NotFound();
            }

            return diploma;
        }

        // PUT: api/Diplomas/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutDiploma(int id, Diploma diploma)
        {
            if (id != diploma.DiplomaId)
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

        // POST: api/Diplomas
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Diploma>> PostDiploma(Diploma diploma)
        {
          if (_context.Diplomas == null)
          {
              return Problem("Entity set 'DlmmsContext.Diplomas'  is null.");
          }
            _context.Diplomas.Add(diploma);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetDiploma", new { id = diploma.DiplomaId }, diploma);
        }

        // DELETE: api/Diplomas/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteDiploma(int id)
        {
            if (_context.Diplomas == null)
            {
                return NotFound();
            }
            var diploma = await _context.Diplomas.FindAsync(id);
            if (diploma == null)
            {
                return NotFound();
            }

            _context.Diplomas.Remove(diploma);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool DiplomaExists(int id)
        {
            return (_context.Diplomas?.Any(e => e.DiplomaId == id)).GetValueOrDefault();
        }
    }
}
