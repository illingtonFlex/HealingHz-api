package HealingHz.db;

import HealingHz.model.Curriculum;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurriculumRepository extends MongoRepository<Curriculum, String>
{
    Curriculum findById(String id);
}
