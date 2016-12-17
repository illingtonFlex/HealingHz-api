package HealingHz.rest;

import HealingHz.db.CurriculumRepository;
import HealingHz.model.HealingHzResponseEntity;
import HealingHz.model.Curriculum;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Component
@Path("curriculum")
public class CurriculumResource
{
    private CurriculumRepository repository;

    public CurriculumResource(CurriculumRepository repo)
    {
        this.repository = repo;
    }

    @GET
    @Path("/{curriculumId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTestPlan(@PathParam("curriculumId") String id)
    {
        HealingHzResponseEntity responseEntity =
                new HealingHzResponseEntity(Response.Status.NOT_FOUND, null,
                        String.format("TestPlan id %s not found", id));

        Optional<Curriculum> testPlan = Optional.ofNullable(repository.findById(id));

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


        Optional<List<Curriculum>> curriculums = Optional.ofNullable(repository.findAll());

        if(curriculums.isPresent())
        {
            responseEntity = new HealingHzResponseEntity(Response.Status.OK,
                    curriculums.get(), String.format("%s test plans found.", curriculums.get().size()));
        }

        return Response.status(responseEntity.getStatus()).entity(responseEntity).build();
    }

    @POST
    @Path("/new")
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveNewTestPlan(@Valid Curriculum curriculum)
    {
        HealingHzResponseEntity responseEntity =
                    new HealingHzResponseEntity(Response.Status.ACCEPTED, null, "Test plan accepted.");

        curriculum = repository.save(curriculum);

        responseEntity.setEntity(curriculum);

        return Response.status(Response.Status.ACCEPTED).entity(responseEntity).build();
    }
}
