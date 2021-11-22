package track.individual.read4share.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import track.individual.read4share.model.Advertisement;

import java.util.List;

@Repository
public interface AdvRepo extends JpaRepository<Advertisement, Long> {

    /**
     * Overview of the most recently posted advertisements
     * @param page Number of records to return to the client
     * @return List of AdvOverview Objects
     */
    @Query("select adv.book.title, adv.book.author, adv.seller.username, " +
            "adv.city.name, adv.price from Advertisement adv where adv.saleDate is null " +
            "order by adv.publDate desc")
    List<Object[]> findLatest(Pageable page);

    /**
     * Advertisements with the best rated books
     * @param page Number of records to return to the client
     * @return List of AdvOverview Objects
     */
    @Query("select adv.book.title, adv.book.author, adv.seller.username, " +
            "adv.city.name, adv.price from Advertisement adv where adv.saleDate is null " +
            "order by adv.book.avgRating, adv.publDate desc")
    List<Object[]> findBestRating(Pageable page);

    /**
     * Latest free advertisements
     * @param page Number of records to return to the client
     * @return List of AdvOverview Objects
     */
    @Query("select adv.book.title, adv.book.author, adv.seller.username, " +
            "adv.city.name, adv.price from Advertisement adv where adv.price = 0.0 " +
            "order by adv.publDate desc")
    List<Object[]> findFree(Pageable page);

    /**
     * Latest advertisements with no delivery fees
     * @param page Number of records to return to the client
     * @return List of AdvOverview Objects
     */
    @Query("select adv.book.title, adv.book.author, adv.seller.username, " +
            "adv.city.name, adv.price from Advertisement adv where adv.shipCost = 0.0 " +
            "order by adv.publDate desc")
    List<Object[]> findFreeDel(Pageable page);

    /**
     * Advertisements with books marked as new
     * @param page Number of records to return to the client
     * @return List of AdvOverview Objects
     */
    @Query("select adv.book.title, adv.book.author, adv.seller.username, " +
            "adv.city.name, adv.price from Advertisement adv where adv.condition.code = 'AN' " +
            "order by adv.publDate desc")
    List<Object[]> findAsNew(Pageable page);

    /**
     * Advertisements with books that belong to a particular category
     * @param catId Category id
     * @param page Requested page and size
     * @return List of AdvOverview Objects
     */
    //List<Object[]> findByCatId(Long catId, Pageable page)
}
