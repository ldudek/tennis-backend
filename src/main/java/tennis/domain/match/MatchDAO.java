package tennis.domain.match;

import tennis.domain.player.Player;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MatchDAO {


    @PersistenceContext
    private EntityManager em;

    List<Match> listAllMatches()
    {
        CriteriaQuery<Match> criteriaQuery = em.getCriteriaBuilder().createQuery(Match.class);
        Root<Match> root = criteriaQuery.from(Match.class);

        return em.createQuery(criteriaQuery).getResultList();
    }

    void add(Match match)
    {
        em.persist(match);
    }

    List<Match> listMatchesByPlayer(Player player)
    {
        return em.createQuery("SELECT m from Match m where m.player1 = :player or m.player2 = :player ")
                .setParameter("player", player)
                .getResultList();
    }



}
