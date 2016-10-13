package HealingHz.db;

import HealingHz.model.TestPlan;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TestPlanRepository extends MongoRepository<TestPlan, String>
{
    TestPlan findById(String id);
}
