package io.revlearners.model.bo;

public class QuestionOptionBo2 {
	private Long id;
	private Long questionId;

    public QuestionOptionBo2(Long id, String text, Long questionId, boolean isCorrect) {
        this.id = id;
        this.questionId = questionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
