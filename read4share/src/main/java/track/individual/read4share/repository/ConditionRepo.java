package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import track.individual.read4share.model.Condition;
import track.individual.read4share.model.Conditions;

public interface ConditionRepo extends JpaRepository<Condition, Conditions> {
}
