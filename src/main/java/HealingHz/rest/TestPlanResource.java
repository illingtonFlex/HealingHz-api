package HealingHz.rest;

import HealingHz.db.TestPlanRepository;
import HealingHz.model.HealingHzResponseEntity;
import HealingHz.model.TestPlan;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
        HealingHzResponseEntity responseEntity =
                new HealingHzResponseEntity(Response.Status.NOT_FOUND, null,
                        String.format("TestPlan id %s not found", id));

        Optional<TestPlan> testPlan = Optional.ofNullable(repository.findById(id));

        if(testPlan.isPresent())
        {
            responseEntity = new HealingHzResponseEntity(Response.Status.OK, testPlan.get(), "Success");
        }

        return Response.status(responseEntity.getStatus()).entity(responseEntity).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTestPlans()
    {
        HealingHzResponseEntity responseEntity =
                new HealingHzResponseEntity(Response.Status.OK, null, "ERROR");


        Optional<List<TestPlan>> testPlans = Optional.ofNullable(repository.findAll());

        if(testPlans.isPresent())
        {
            responseEntity = new HealingHzResponseEntity(Response.Status.OK,
                    testPlans.get(), String.format("%s test plans found.", testPlans.get().size()));
        }

        return Response.status(responseEntity.getStatus()).entity(responseEntity).build();
    }

    @POST
    @Path("/new")
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveNewTestPlan(@Valid TestPlan testPlan)
    {
        HealingHzResponseEntity responseEntity =
                    new HealingHzResponseEntity(Response.Status.ACCEPTED, null, "Test plan accepted.");

        testPlan = repository.save(testPlan);

        responseEntity.setEntity(testPlan);

        return Response.status(Response.Status.ACCEPTED).entity(responseEntity).build();
    }
}
