package HealingHz;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/submitSolution")
public class HealingHzEndpoint
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMessage()
    {
        return new String("Jersey: Up and Running!");
    }
}
