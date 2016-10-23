package HealingHz.rest;

import HealingHz.db.TestPlanRepository;
import HealingHz.model.HealingHzResponseEntity;
import HealingHz.model.TestPlan;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Component
@Path("testPlan")
public class TestPlanResource
{
    private TestPlanRepository repository;

    public TestPlanResource(TestPlanRepository repo)
    {
        this.repository = repo;
    }

    @GET
    @Path("/{testPlanId}")
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

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTestPlan()
    {
        HealingHzResponseEntity hhre =
                new HealingHzResponseEntity(Response.Status.OK, null, "ERROR");


        Optional<List<TestPlan>> testPlans = Optional.ofNullable(repository.findAll());

        if(testPlans.isPresent())
        {
            hhre = new HealingHzResponseEntity(Response.Status.OK,
                    testPlans.get(), String.format("%s test plans found.", testPlans.get().size()));
        }

        return Response.status(hhre.getStatus()).entity(hhre).build();
    }

    @POST
    @Path("/new")
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveNewTestPlan(TestPlan testPlan)
    {
        HealingHzResponseEntity hhre =
                    new HealingHzResponseEntity(Response.Status.ACCEPTED, null, "Test plan accepted.");

        testPlan = repository.save(testPlan);

        hhre.setEntity(testPlan);

        return Response.status(Response.Status.ACCEPTED).entity(hhre).build();
    }
}
