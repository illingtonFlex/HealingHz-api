package HealingHz.rest;

import HealingHz.model.Submission;
import HealingHz.db.SubmissionRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/submitSolution")
public class SubmitSolution
{
    @Autowired
    private SubmissionRepository repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consumeSubmission(Submission submission)
    {
        submission = repository.save(submission);

        return Response.status(200).entity(new Gson().toJson(submission)).build();
    }
}
