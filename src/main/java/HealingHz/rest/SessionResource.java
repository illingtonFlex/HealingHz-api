package HealingHz.rest;

import HealingHz.db.CurriculumRepository;
import HealingHz.db.SessionRepository;
import HealingHz.model.HealingHzResponseEntity;
import HealingHz.model.Curriculum;
import HealingHz.model.Session;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Component
@Path("session")
public class SessionResource
{
    private static final String BASE_FWD_URL = "http://healinghz.us?s=%s";

    private CurriculumRepository crepository;
    private SessionRepository srepository;

    public SessionResource(CurriculumRepository crepo, SessionRepository srepo)
    {
        this.crepository = crepo;
        this.srepository = srepo;
    }

    @POST
    @Path("/new/{curriculumId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewSessionForTestPlan(@PathParam("curriculumId") String id)
    {
        URI fwdUri;
        HealingHzResponseEntity responseEntity =
                new HealingHzResponseEntity(Response.Status.NOT_FOUND, null,
                        String.format("TestPlan id %s not found", id));

        Optional<Curriculum> curriculum = Optional.ofNullable(crepository.findById(id));

        if(curriculum.isPresent())
        {
            Session session = new Session(curriculum.get());
            session = srepository.save(session);

            try
            {
                fwdUri = new URI(String.format(BASE_FWD_URL, session.getId()));
            }
            catch(URISyntaxException e)
            {
                responseEntity.setMessage(String.format("Unable to parse URI: %s",
                        String.format(BASE_FWD_URL, session.getId())));

                return Response.status(responseEntity.getStatus()).entity(responseEntity).build();
            }

            return Response.seeOther(fwdUri).build();
        }

        return Response.status(responseEntity.getStatus()).entity(responseEntity).build();
    }
}
