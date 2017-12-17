package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="QUESTION_POINTS")
public class QuestionPoints implements Serializable{
	private static final long serialVersionUID = -2384622168604669536L;

	@EmbeddedId
	private TypeDiffcultyPair id;

    @Column(name="QUESTION_POINTS")
	private Long points;

	public QuestionPoints(QuestionType type, QuestionDifficulty difficulty) {
		this.id.type = type;
		this.id.difficulty = difficulty;
		this.points = points;
	}

	public QuestionPoints() {
	}

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

    public TypeDiffcultyPair getId() {
        return id;
    }

    public void setId(TypeDiffcultyPair id) {
        this.id = id;
    }


	@Embeddable
    public static class TypeDiffcultyPair implements Serializable {

	    @ManyToOne
        @JoinColumn(name="QUESTION_TYPE_ID")
		private QuestionType type;

	    @ManyToOne
        @JoinColumn(name="DIFFICULTY_ID")
        private QuestionDifficulty difficulty;

        public TypeDiffcultyPair(QuestionType type, QuestionDifficulty difficulty) {
            this.type = type;
            this.difficulty = difficulty;
        }

        public TypeDiffcultyPair() {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TypeDiffcultyPair)) return false;

            TypeDiffcultyPair that = (TypeDiffcultyPair) o;
            if (type != null ? !type.equals(that.type) : that.type != null) return false;
            return difficulty != null ? difficulty.equals(that.difficulty) : that.difficulty == null;
        }

        @Override
        public int hashCode() {
            int result = type != null ? type.hashCode() : 0;
            result = 31 * result + (difficulty != null ? difficulty.hashCode() : 0);
            return result;
        }
    }
	
}
