package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import track.individual.read4share.model.Advertisement;

import java.util.List;

@Repository
public interface AdvRepo extends JpaRepository<Advertisement, Long> {

    /**
     * Most recently posted advertisements
     * @return List of Advertisements
     */
    //@Query("select adv from ")
    //@Query("select adv from Advertisement adv ")
    //@EntityGraph("adv-book-category")
    //@Query("select adv from Advertisement adv")
    List<Advertisement> findAll();


}
