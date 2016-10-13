package HealingHz;

import HealingHz.rest.SubmitSolution;
import HealingHz.rest.TestPlanResource;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        packages("HealingHz");
        register(SubmitSolution.class);
        register(TestPlanResource.class);
        register(CORSResponseFilter.class);

        //logging
        register(new LoggingFilter(Logger.getLogger(JerseyConfig.class.getName()), true));

        //JSON parsing/conversion
        register(JacksonObjectMapperProvider.class);
        register(JacksonFeature.class);

    }
}
