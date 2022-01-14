package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import track.individual.read4share.model.Condition;
import track.individual.read4share.model.Conditions;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface ConditionRepo extends JpaRepository<Condition, Conditions> {
    Optional<Condition> findByCode(@NotNull @NotBlank Conditions code);
}
