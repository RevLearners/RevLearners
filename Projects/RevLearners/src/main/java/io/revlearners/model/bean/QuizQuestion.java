package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name = Constants.TABLE_QUIZ_QUESTION)
@AssociationOverrides({
        @AssociationOverride(name = Constants.PK_QUIZ, joinColumns = @JoinColumn(name = Constants.COLUMN_QUIZ_ID)),
        @AssociationOverride(name = Constants.PK_QUESTION, joinColumns = @JoinColumn(name = Constants.COLUMN_QUESTION_ID))})
public class QuizQuestion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 80998647750330213L;
	
	   @EmbeddedId
	    private QuizQuestionPair pk = new QuizQuestionPair();

	    public QuizQuestion() {
	    }

	    public QuizQuestion(Quiz quiz, Question question) {
	        setQuiz(quiz);
	        setQuestion(question);
	    }

	    public QuizQuestionPair getId() {
	        return pk;
	    }

	    public void setId(QuizQuestionPair userCertKey) {
	        this.pk = userCertKey;
	    }

	    @Transient
	    public Quiz getQuiz() {
	        return pk.quiz;
	    }

	    public void setQuiz(Quiz quiz) {
	        pk.quiz = quiz;
	    }

	    @Transient
	    public Question getQuestion() {
	        return pk.question;
	    }

	    public void setQuestion(Question question) {
	        pk.question = question;
	    }

	    public QuizQuestionPair getPk() {
	        return pk;
	    }

	    public void setPk(QuizQuestionPair pk) {
	        this.pk = pk;
	    }

	    @Embeddable
	    private static class QuizQuestionPair implements Serializable {

	        private static final long serialVersionUID = 4724550790684214251L;

	        @ManyToOne
	        @JoinColumn(name = Constants.COLUMN_QUIZ_ID)
	        private Quiz quiz;

	        @ManyToOne
	        @JoinColumn(name = Constants.COLUMN_QUESTION_ID)
	        private Question question;

	        public QuizQuestionPair() {
	        }

	        @Override
	        public boolean equals(Object o) {
	            if (this == o)
	                return true;
	            if (!(o instanceof QuizQuestionPair))
	                return false;

	            QuizQuestionPair that = (QuizQuestionPair) o;

	            return this.quiz.getId().equals(that.quiz.getId())
	                    && this.question.getId().equals(that.question.getId());
	        }

	        @Override
	        public int hashCode() {
	            int result = quiz != null ? quiz.hashCode() : 0;
	            result = 31 * result + (question != null ? question.hashCode() : 0);
	            return result;
	        }
	    }

}
