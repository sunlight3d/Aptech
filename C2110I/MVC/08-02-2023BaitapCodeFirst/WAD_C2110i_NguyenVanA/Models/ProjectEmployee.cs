using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WAD_C2110i_NguyenVanA.Models
{
    public class ProjectEmployee
    {
        public int ProjectId { get; set; }
        public int EmployeeId { get; set; }

        public virtual Project Project { get; set; }
        public virtual Employee Employee { get; set; }
    }
}