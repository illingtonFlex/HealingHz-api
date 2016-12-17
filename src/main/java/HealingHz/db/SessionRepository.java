package HealingHz.db;

import HealingHz.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionRepository extends MongoRepository<Session, String>
{
    Session findById(String id);
}
