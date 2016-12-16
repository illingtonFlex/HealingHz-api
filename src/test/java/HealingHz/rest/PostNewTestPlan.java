package HealingHz.rest;

import HealingHz.db.TestPlanRepository;
import HealingHz.model.Chord;
import HealingHz.model.HealingHzResponseEntity;
import HealingHz.model.Note;
import HealingHz.model.TestPlan;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostNewTestPlan
{
    private static final String URL = "/testPlan/new";

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean(name="testPlanRepository")
    private TestPlanRepository mockRepo;

    @Before
    public void setup()
    {
        TestPlan myPlan = new TestPlan();
        myPlan.setId("1234");

    }

    @Test
    public void testPostingNewTestPlanInvokesRepositoryAsExpected()
    {
        Chord chord = new Chord("My Chord", new Note[]{new Note("A", 0), new Note("B", 1), new Note("C", 2)});

        TestPlan planToPost = new TestPlan();
        planToPost.setName("MyPlan");
        planToPost.setChords(Arrays.asList(chord));

        HealingHzResponseEntity createdEntity =
                this.restTemplate.postForObject(URL, planToPost, HealingHzResponseEntity.class, Collections.EMPTY_MAP);

        verify(mockRepo, times(1)).save(planToPost);
        assertNotNull(createdEntity);
        assertEquals(Response.Status.ACCEPTED, createdEntity.getStatus());
    }


    @Test(expected=RestClientException.class)
    public void testPostingNullEntityCausesError()
    {
        HealingHzResponseEntity createdEntity =
            this.restTemplate.postForObject(URL, null, HealingHzResponseEntity.class, Collections.EMPTY_MAP);

        verifyZeroInteractions(mockRepo);
    }

    @Test
    public void getJson()
    {
        Chord chord = new Chord("My Chord", new Note[]{new Note("A", 0), new Note("B", 1), new Note("C", 2)});

        TestPlan planToPost = new TestPlan();
        planToPost.setName("MyPlan");
        planToPost.setChords(Arrays.asList(chord));


        Gson gson = new Gson();
        String str = gson.toJson(planToPost);

        System.out.println("###########################    "+str);

    }
}
