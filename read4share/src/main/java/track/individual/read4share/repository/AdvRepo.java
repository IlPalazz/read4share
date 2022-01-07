package track.individual.read4share.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import track.individual.read4share.model.Adv;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvRepo extends JpaRepository<Adv, Long> {

    /**
     * Overview of the most recently posted advertisements
     * @param page Page and number of records to return
     * @return List of Adv
     */
    @EntityGraph(value = "graph.AdvUserCityBookCategoryCondition")
    @Query("select adv from Adv adv where adv.saleDate is null " +
            "order by adv.publDate desc")
    List<Adv> findLatest(Pageable page);

    /**
     * Advertisements with the best rated books
     * @param page Page and number of records to return
     * @return List of Adv
     */
    @EntityGraph(value = "graph.AdvUserCityBookCategoryCondition")
    @Query("select adv from Adv adv where adv.saleDate is null " +
            "order by adv.book.avgRating desc, adv.publDate desc")
    List<Adv> findBestRating(Pageable page);

    /**
     * Latest free advertisements
     * @param page Page and number of records to return
     * @return List of Adv
     */
    @EntityGraph(value = "graph.AdvUserCityBookCategoryCondition")
    @Query("select adv from Adv adv where adv.saleDate is null " +
            "and adv.price = 0.0 " +
            "order by adv.publDate desc")
    List<Adv> findFree(Pageable page);

    /**
     * Latest advertisements with no delivery fees
     * @param page Page and number of records to return
     * @return List of Adv
     */
    @EntityGraph(value = "graph.AdvUserCityBookCategoryCondition")
    @Query("select adv from Adv adv where adv.saleDate is null " +
            "and adv.shipCost = 0.0 " +
            "order by adv.publDate desc")
    List<Adv> findFreeDel(Pageable page);

    /**
     * Advertisements with books marked as new
     * @param page Page and number of records to return
     * @return List of Adv
     */
    @EntityGraph(value = "graph.AdvUserCityBookCategoryCondition")
    @Query("select adv from Adv adv where adv.saleDate is null " +
            "and adv.condition.code = 'AN' " +
            "order by adv.publDate desc")
    List<Adv> findAsNew(Pageable page);

    /**
     * Advertisements with books that belong to a particular category
     * @param catId Category id
     * @param page Page and number of records to return
     * @return List of Adv
     */
    @EntityGraph(value = "graph.AdvUserCityBookCategoryCondition")
    @Query("select adv from Adv adv where adv.saleDate is null and adv.book.category.id = ?1" +
            "order by adv.publDate desc")
    List<Adv> findByCatId(Long catId, Pageable page);

    @EntityGraph(value = "graph.AdvUserCityBookCategoryCondition")
    Optional<Adv> findById(Long advId);

}
