package com.itheima.domain;

import java.io.Serializable;

public class QuestionItem implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question_item.id
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question_item.question_id
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    private Integer questionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question_item.content
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table question_item
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question_item.id
     *
     * @return the value of question_item.id
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question_item.id
     *
     * @param id the value for question_item.id
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question_item.question_id
     *
     * @return the value of question_item.question_id
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question_item.question_id
     *
     * @param questionId the value for question_item.question_id
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question_item.content
     *
     * @return the value of question_item.content
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question_item.content
     *
     * @param content the value for question_item.content
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_item
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        QuestionItem other = (QuestionItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getQuestionId() == null ? other.getQuestionId() == null : this.getQuestionId().equals(other.getQuestionId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_item
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getQuestionId() == null) ? 0 : getQuestionId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}