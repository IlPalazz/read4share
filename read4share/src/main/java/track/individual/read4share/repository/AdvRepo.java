package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import track.individual.read4share.model.Advertisement;
import track.individual.read4share.model.response.AdvOverview;

import java.util.List;

@Repository
public interface AdvRepo extends JpaRepository<Advertisement, Long> {

    /**
     * Overview of the most recently posted advertisements
     * @return List of Advertisements
     */
    //@EntityGraph("adv-book-category")
    @Query("select adv.book.title, adv.book.author, adv.seller.username, " +
            "adv.city.name, adv.price from Advertisement adv order by adv.publDate desc")
    List<Object[]> findLatest();


}
