package tennis.domain.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService {


    @Autowired
    private PlayerDAO playerDAO;

    @Transactional
    public Player add(Player player)
    {
        playerDAO.add(player);
        return player;
    }

    @Transactional
    public void remove(Player player)
    {
        playerDAO.remove(player);
    }

    @Transactional
    public List<Player> listAll()
    {
        return playerDAO.listAll();
    }

}
