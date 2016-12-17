package HealingHz.rest;

import HealingHz.db.CurriculumRepository;
import HealingHz.model.HealingHzResponseEntity;
import HealingHz.model.Curriculum;
import com.sun.xml.internal.xsom.impl.WildcardImpl;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Optional;

@Component
@Path("testPlan")
public class SessionResource
{
    private CurriculumRepository repository;

    public SessionResource(CurriculumRepository repo)
    {
        this.repository = repo;
    }

    @POST
    @Path("/new/{curriculumId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewSessionForTestPlan(@PathParam("curriculumId") String id)
    {
        HealingHzResponseEntity responseEntity =
                new HealingHzResponseEntity(Response.Status.NOT_FOUND, null,
                        String.format("TestPlan id %s not found", id));

        Optional<Curriculum> curriculum = Optional.ofNullable(repository.findById(id));

        if(curriculum.isPresent())
        {
            //DoMoreStuff
            responseEntity = new HealingHzResponseEntity(Response.Status.OK, curriculum.get(), "Success");
        }

        return Response.status(responseEntity.getStatus()).entity(responseEntity).build();
    }
}
