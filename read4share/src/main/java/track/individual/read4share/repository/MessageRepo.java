package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import track.individual.read4share.model.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
