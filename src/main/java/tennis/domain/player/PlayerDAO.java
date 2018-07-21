package tennis.domain.player;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PlayerDAO {

    @PersistenceContext
    private EntityManager em;

    void add(Player player)
    {
        em.persist(player);
    }

    void remove(Player player)
    {
        em.remove(player);
    }

    List<Player> listAll()
    {
        CriteriaQuery<Player> criteriaQuery = em.getCriteriaBuilder().createQuery(Player.class);
        Root<Player> root = criteriaQuery.from(Player.class);

        return em.createQuery(criteriaQuery).getResultList();
    }


}

