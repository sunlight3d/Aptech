using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebApplication.Services
{
    public class PollResultsService : IPollResultsService
    {
        private Dictionary<SelectedGame, int> _selectionVotes;
        public PollResultsService()
        {
            _selectionVotes = new Dictionary<SelectedGame, int>();
        }
        void IPollResultsService.AddVote(SelectedGame game)
        {
            if (_selectionVotes.ContainsKey(game))
            {
                _selectionVotes[game]++;
            }
            else
            {
                _selectionVotes.Add(game, 1);
            }
        }

        SortedDictionary<SelectedGame, int> IPollResultsService.GetVoteResult()
        {
            return new SortedDictionary<SelectedGame, int>(_selectionVotes);
        }
    }
}
