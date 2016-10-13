package HealingHz.db;

import HealingHz.model.Submission;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SubmissionRepository extends MongoRepository<Submission, String>
{}