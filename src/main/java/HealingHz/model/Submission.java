package HealingHz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "HealingHzSubmissions")
public class Submission
{
    @Id
    private String id;
    private boolean correctAnswer;
    private String chordName;
    private List<Note> notesPresented;
    private List<Note> solutionNotes;

    public Submission() {}

    public Submission(boolean correctAnswer, String chordName, List<Note> notesPresented, List<Note> solutionNotes)
    {
        this.correctAnswer = correctAnswer;
        this.chordName  = chordName;
        this.notesPresented = notesPresented;
        this.solutionNotes = solutionNotes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getChordName() {
        return chordName;
    }

    public void setChordName(String chordName) {
        this.chordName = chordName;
    }

    public List<Note> getNotesPresented() {
        return notesPresented;
    }

    public void setNotesPresented(List<Note> notesPresented) {
        this.notesPresented = notesPresented ;
    }

    public List<Note> getSolutionNotes() {
        return solutionNotes;
    }

    public void setSolutionNotes(List<Note> solutionNotes) {
        this.solutionNotes = solutionNotes;
    }

    public static class Note
    {
        String name;
        int index;

        public Note() {}

        public Note(String name, int index)
        {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}