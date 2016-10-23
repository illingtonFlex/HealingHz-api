package HealingHz.model;

import java.util.List;

public class TestPlan
{
    private String id;
    private String name;
    private List<Chord> chords;

    public TestPlan()
    {

    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setChords(List<Chord> chords)
    {
        this.chords = chords;
    }

    public List<Chord> getChords()
    {
        return this.chords;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestPlan testPlan = (TestPlan) o;

        if (!getId().equals(testPlan.getId())) return false;
        if (!getName().equals(testPlan.getName())) return false;
        return getChords().equals(testPlan.getChords());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getChords().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TestPlan{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", chords=" + chords +
                '}';
    }
}
