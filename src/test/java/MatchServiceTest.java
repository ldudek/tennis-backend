import tennis.TennisConfig;
import tennis.domain.match.Match;
import tennis.domain.match.MatchService;
import tennis.domain.player.Player;
import tennis.domain.player.PlayerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { TennisConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class MatchServiceTest {

    @Resource
    private MatchService matchService;

    @Resource
    private PlayerService playerService;


    @Test
    public void listPlayerMatchesTest() {

        Player jim = new Player("Jim", "Courier");
        Player tim = new Player("Tim", "Hennman");

        playerService.add(jim);
        playerService.add(tim);

        matchService.add(new Match(jim, tim, LocalDate.now()));

        assertEquals(1, matchService.listAllMatches().size());
        assertEquals(1, matchService.listPlayerMatches(jim).size());
        assertEquals(1, matchService.listPlayerMatches(tim).size());
    }
}
