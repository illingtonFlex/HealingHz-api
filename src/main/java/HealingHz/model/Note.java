package HealingHz.model;

import javax.validation.constraints.NotNull;

public class Note
{
    @NotNull
    private String name;
    private int pitchIndex;

    private Note()
    {
        //Hidden
    }

    public Note(String name, int pitchIndex)
    {
        this.name = name;
        this.pitchIndex = pitchIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPitchIndex() {
        return pitchIndex;
    }

    public void setPitchIndex(int pitchIndex) {
        this.pitchIndex = pitchIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        return getPitchIndex()==note.getPitchIndex() && getName().equals(note.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getPitchIndex();
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "name='" + name + '\'' +
                ", pitchIndex=" + pitchIndex +
                '}';
    }
}
