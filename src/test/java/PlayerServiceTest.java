import tennis.TennisConfig;
import tennis.domain.player.Player;
import tennis.domain.player.PlayerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { TennisConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class PlayerServiceTest {

    @Resource
    private PlayerService playerService;

    @Test
    public void givenStudent_whenSave_thenGetOk() {

        Player player = new Player("Jim", "Courier");

        playerService.add(player);

        assertEquals(1, playerService.listAll().size());
    }
}
