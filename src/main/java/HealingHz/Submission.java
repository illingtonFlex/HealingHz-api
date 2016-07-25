package HealingHz;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "HealingHzSubmissions")
public class Submission
{
    @Id
    private String id;
    private String chordName;
    private String outcome;

    public Submission() {}

    public Submission(String inChordName, String inOutcome)
    {
        this.chordName = inChordName;
        this.outcome = inOutcome;
    }

    public String getChordName()
    {
        return chordName;
    }

    public void setChordName(String chordName)
    {
        this.chordName = chordName;
    }

    public String getOutcome()
    {
        return outcome;
    }

    public void setOutcome(String outcome)
    {
        this.outcome = outcome;
    }

    @Override
    public String toString()
    {
        return String.format(
                "Submission[id=%s, chordName='%s', outcome='%s']",
                id, chordName, outcome);
    }
}
