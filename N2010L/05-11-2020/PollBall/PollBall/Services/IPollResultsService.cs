using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using PollBall.Services;

namespace PollBall
{
    public interface IPollResultsService
    {
        void AddVote(SelectedGame game);
        SortedDictionary<SelectedGame, int> GetVoteResult();
    }
}
