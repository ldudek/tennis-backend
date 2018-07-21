package tennis.domain.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @RequestMapping("/players")
    public List<Player> listAllPlayers() {
        return playerService.listAll();
    }

}
