package HealingHz.model;

import java.util.Arrays;

public class Chord
{
    private String name;
    private Note[] notes;

    private Chord()
    {
        //hidden
    }

    public Chord(String name, Note[] notes)
    {
        this.name = name;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Note[] getNotes() {
        return notes;
    }

    public void setNotes(Note[] notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chord chord = (Chord) o;

        if (!name.equals(chord.name)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(notes, chord.notes);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Arrays.hashCode(notes);
        return result;
    }

    @Override
    public String toString() {
        return "Chord{" +
                "name='" + name + '\'' +
                ", notes=" + Arrays.toString(notes) +
                '}';
    }
}
