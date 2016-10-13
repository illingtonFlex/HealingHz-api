package HealingHz.rest;

import HealingHz.db.TestPlanRepository;
import HealingHz.model.HealingHzResponseEntity;
import HealingHz.model.TestPlan;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Component
@Path("/testPlan/{testPlanId}")
public class TestPlanResource
{
    private TestPlanRepository repository;

    public TestPlanResource(TestPlanRepository repo)
    {
        this.repository = repo;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTestPlan(@PathParam("testPlanId") String id)
    {
        HealingHzResponseEntity hhre =
                new HealingHzResponseEntity(Response.Status.NOT_FOUND, null, String.format("TestPlan id %s not found", id));

        Optional<TestPlan> testPlan = Optional.ofNullable(repository.findById(id));

        if(testPlan.isPresent())
        {
            hhre = new HealingHzResponseEntity(Response.Status.OK, testPlan.get(), "Success");
        }

        return Response.status(hhre.getStatus()).entity(hhre).build();
    }
}
