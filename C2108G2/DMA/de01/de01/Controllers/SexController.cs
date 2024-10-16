using System;
using de01.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace de01.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class SexController : ControllerBase
    {
        private readonly DiplomaDbContext _context;

        public SexController(DiplomaDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<Sex>>> GetSexes()
        {
            return await _context.Sexes.ToListAsync();
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<Sex>> GetSex(int id)
        {
            var sex = await _context.Sexes.FindAsync(id);

            if (sex == null)
            {
                return NotFound();
            }

            return sex;
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> PutSex(int id, Sex sex)
        {
            if (id != sex.SexID)
            {
                return BadRequest();
            }

            _context.Entry(sex).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!SexExists(id))
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
        public async Task<ActionResult<Sex>> PostSex(Sex sex)
        {
            _context.Sexes.Add(sex);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetSex", new { id = sex.SexID }, sex);
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteSex(int id)
        {
            var sex = await _context.Sexes.FindAsync(id);
            if (sex == null)
            {
                return NotFound();
            }
            _context.Sexes.Remove(sex);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool SexExists(int id)
        {
            return _context.Sexes.Any(e => e.SexID == id);
        }
    }
}
