package com.itheima.dao;

import com.itheima.domain.Member;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberDao {
	 @Insert({
	        "insert into tr_member (id, nick_name, ",
	        "password, gender, ",
	        "birthday, email, ",
	        "state, telephone, ",
	        "address, register_date)",
	        "values (#{id,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
	        "#{password,jdbcType=VARCHAR}, #{gender,jdbcType=VARCHAR}, ",
	        "#{birthday,jdbcType=TIMESTAMP}, #{email,jdbcType=VARCHAR}, ",
	        "#{state,jdbcType=VARCHAR}, #{telephone,jdbcType=VARCHAR}, ",
	        "#{address,jdbcType=VARCHAR}, #{registerDate,jdbcType=TIMESTAMP})"
	    })
    int save(Member member);
	 @Select({ "<script>"
		    + "select id, nick_name as nickName, password, gender, birthday, email, state, telephone, address, "
	        +"register_date as registerDate"
	        +" from tr_member where 1=1 "	        
			  +"<if test='email != null'> AND email=#{email} </if> "
			  +"<if test='password != null'> AND password=#{password} </if>"
			  +"</script>" 
			  }) 
    List<Member> findAll(@Param("email") String email, @Param("password") String password);
	 @Select({ "<script>"
			    + "select id, nick_name as nickName, password, gender, birthday, email, state, telephone, address, "
		        +"register_date as registerDate"
		        +" from tr_member where 1=1 "	        
				  +"<if test='email != null'> AND email=#{email} </if> "
				  +"<if test='password != null'> AND password=#{password} </if>"
				  +"</script>" 
				  }) 
	 Member findByEmailAndPwd(@Param("email") String email, @Param("password") String password);
}
