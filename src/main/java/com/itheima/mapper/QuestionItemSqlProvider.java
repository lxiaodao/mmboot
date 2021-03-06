package com.itheima.mapper;

import com.itheima.domain.QuestionItem;
import org.apache.ibatis.jdbc.SQL;

public class QuestionItemSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_item
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    public String insertSelective(QuestionItem record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("question_item");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getQuestionId() != null) {
            sql.VALUES("question_id", "#{questionId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_item
     *
     * @mbg.generated Thu Dec 09 14:38:49 CST 2021
     */
    public String updateByPrimaryKeySelective(QuestionItem record) {
        SQL sql = new SQL();
        sql.UPDATE("question_item");
        
        if (record.getQuestionId() != null) {
            sql.SET("question_id = #{questionId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}