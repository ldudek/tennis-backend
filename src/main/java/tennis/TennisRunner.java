package tennis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tennis.domain.player.Player;
import tennis.domain.player.PlayerService;

@Component
public class TennisRunner implements CommandLineRunner {

    @Autowired
    PlayerService playerService;

    @Override
    public void run(String... args) throws Exception {
        playerService.add(new Player("Pete", "Sampras"));
        playerService.add(new Player("Jim", "Courier"));
    }
}
