package org.fetch;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Question {
    @Id
    private int question_id;
    private String question;
    @OneToMany     // uni-directional
   // @JoinColumn(name="a_id")
    private List<Answer> answers;

    public Question() {
    }

    public Question(int question_id, String question, List<Answer> answers) {
        this.question_id = question_id;
        this.question = question;
        this.answers = answers;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
