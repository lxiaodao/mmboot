package com.itheima.service.front.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.MemberDao;
import com.itheima.domain.Member;
import com.itheima.mapper.MemberMapper;
import com.itheima.service.front.MemberService;
import com.itheima.utils.JedisUtils;
import com.itheima.utils.MD5Util;

import redis.clients.jedis.Jedis;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	@Autowired
	MemberMapper memberMapper;
	
    @Override
    @Transactional
    public boolean register(Member member) {      
      
          
            //id使用UUID的生成策略来获取
            String id = UUID.randomUUID().toString();
            member.setId(id);
            member.setRegisterDate(new Date());
            member.setState("1");
            member.setPassword(MD5Util.md5(member.getPassword()));
            //3.调用Dao层操作
            int row = memberDao.save(member);
            //4.提交事务
            return row>0;
    }

    @Override
    public Member login(String email, String password) {
       
            password = MD5Util.md5(password);
            Member member = memberDao.findByEmailAndPwd(email,password);

            System.out.println(member.getNickName());

            //3.将登录人的信息保存到redis中
            Jedis jedis = JedisUtils.getResource();
            //使用登录人的id作为key，设定3600秒的过期时间，value值待定
            jedis.setex(member.getId(),3600,member.getNickName());
            jedis.close();

            return member;
     
    }

    @Override
    public String getLoginInfo(String id) {
        //使用给定的id去查找redis中是否存在当前数据
        Jedis jedis = JedisUtils.getResource();
        String nickName = jedis.get(id);
        jedis.close();
        return nickName;
    }

    @Override
    public boolean logout(String id) {
        Jedis jedis = JedisUtils.getResource();
        Long row = jedis.del(id);
        jedis.close();
        return row > 0 ;
    }

	@Override
	public List<Member> find() {
		
		return this.memberDao.findAll(null, null);
	}

	@Override
	public Member query(String id) {
		
		return memberMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean edit(Member member) {
      
        //调用Dao层操作
        int row = memberDao.update(member);
        //提交事务
        return row>0;
	}
}
