package com.itheima.service.front;

import java.util.List;

import com.itheima.domain.Member;

public interface MemberService {
    /**
     * 注册新用户
     * @param member
     * @return
     */
    boolean register(Member member);
    
    List<Member> find();

    /**
     * 根据email和密码登录
     * @param email
     * @param password
     * @return
     */
    Member login(String email, String password);

    /**
     * 根据登录人id获取对应的昵称，从redis中获取
     * @param id
     * @return
     */
    String getLoginInfo(String id);

    boolean logout(String id);

	Member query(String id);

	boolean edit(Member member);
}
