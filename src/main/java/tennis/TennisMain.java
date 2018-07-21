package tennis;

import tennis.domain.match.Match;
import tennis.domain.match.MatchService;
import tennis.domain.player.Player;
import tennis.domain.player.PlayerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class TennisMain {

    public static void main(String[] args) {



        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TennisConfig.class);


        PlayerService playerService = context.getBean(PlayerService.class);


        Player pete = new Player("Pete", "Sampras");
        Player andre = new Player("Andre", "Agassi");


        playerService.add(pete);
        playerService.add(andre);
        playerService.add(new Player("Jim", "Courier"));
        playerService.add(new Player("Michael", "Chang"));




        List<Player> players = playerService.listAll();

        players.forEach(System.out::println);

        MatchService matchService = context.getBean(MatchService.class);


        matchService.add(new Match(pete, andre, LocalDate.now()));
        List<Match> matches = matchService.listAllMatches();

        matches.forEach(System.out::println);

        context.close();
    }

}
