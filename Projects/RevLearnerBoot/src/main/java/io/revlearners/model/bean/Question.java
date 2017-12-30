package io.revlearners.model.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;
import io.revlearners.model.jsonview.Views;
import io.revlearners.util.commons.configs.Constants;

@NamedNativeQueries({
        @NamedNativeQuery(
                /*
                 *   prepending 'Question.' to the name is important
                 *   to be accessible from Spring Data;
                 *   See IQuestionRepository.java
                 */
                name = "Question.generateQuestions",

                query = "SELECT * FROM " +
                        "(SELECT quest.* " +
                        "FROM QUESTION quest INNER JOIN TOPIC tpc " +
                        "ON quest.TOPIC_ID = tpc.TOPIC_ID AND tpc.TOPIC_ID = :topicId " +
                        "ORDER BY dbms_random.value)" +
                        "WHERE ROWNUM <= :numQuestions",
                resultClass = Question.class
        )
})
@Entity
@Table(name = Constants.TABLE_QUESTION)
public class Question implements Serializable {
    private static final long serialVersionUID = 3506791910251447189L;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @Id
    @Column(name = Constants.COLUMN_QUESTION_ID)
    @SequenceGenerator(sequenceName = "QUESTION_SEQ", name = "QUESTION_SEQ")
    @GeneratedValue(generator = "QUESTION_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = Constants.COLUMN_TOPIC_ID)
    private Topic topic;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = Constants.COLUMN_QUESTION_TYPE_ID)
    private QuestionType type;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = Constants.COLUMN_DIFFICULTY_ID)
    private QuestionDifficulty difficulty;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question", fetch = FetchType.EAGER)
    private Set<QuestionOption> options;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @Column(name = Constants.COLUMN_QTEXT)
    private String text;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @Column(name = Constants.COLUMN_QUESTION_EXPLANATION) // todo constants file
    private String explanation;

    public Question(Topic topic, QuestionType type, QuestionDifficulty difficulty, String text, String explanation) {
        this.topic = topic;
        this.type = type;
        this.difficulty = difficulty;
        this.text = text;
        this.explanation = explanation;
    }

    public Question(Long id) {
        this.id = id;
    }

    public Set<QuestionOption> getOptions() {
        return options;
    }

    public void setOptions(Set<QuestionOption> options) {
        this.options = options;
    }

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long questionId) {
        this.id = questionId;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public QuestionDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(QuestionDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", topic=" + topic + ", type=" + type
                + ", difficulty=" + difficulty + ", text=" + text + "]";
    }

}
