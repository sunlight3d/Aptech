using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebApplication.Services
{
    public interface IPollResultsService
    {
        void AddVote(SelectedGame game);
        SortedDictionary<SelectedGame, int> GetVoteResult();
    }
}
