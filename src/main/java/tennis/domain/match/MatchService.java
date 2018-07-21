package tennis.domain.match;

import tennis.domain.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchDAO matchDAO;


    @Transactional
    public List<Match> listAllMatches()
    {
        return matchDAO.listAllMatches();
    }

    @Transactional
    public void add(Match match)
    {
        matchDAO.add(match);
    }

    public List<Match> listPlayerMatches(Player player)
    {
        return matchDAO.listMatchesByPlayer(player);
    }

}
