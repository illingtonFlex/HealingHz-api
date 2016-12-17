package HealingHz.model;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotNull;

public class Session
{
    @Id
    private String id;

    @NotNull
    private Curriculum curriculum;

    public Session()
    {
        id = "";
    }

    public Session(Curriculum curriculum)
    {
        this();
        this.curriculum = curriculum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Session)) return false;

        Session session = (Session) o;

        if (!id.equals(session.id)) return false;
        return curriculum.equals(session.curriculum);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + curriculum.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", curriculum=" + curriculum +
                '}';
    }
}
