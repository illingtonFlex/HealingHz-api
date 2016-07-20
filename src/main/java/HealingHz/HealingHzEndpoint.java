package HealingHz;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Component
@Path("/submitSolution")
public class HealingHzEndpoint
{
    @GET
    @Produces("application/json")
    public String getMessage()
    {
        return new String("Jersey: Up and Running!");
    }
}
