package HealingHz;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/submitSolution")
public class HealingHzEndpoint
{
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consumeSubmission(String inJson)
    {
        return Response.status(200).entity(inJson).build();
    }
}
