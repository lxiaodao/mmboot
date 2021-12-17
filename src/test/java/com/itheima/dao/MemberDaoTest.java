/**
 * 
 */
package com.itheima.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.itheima.domain.Member;



/**
 * @author yangliu
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberDaoTest {
	
	@Autowired
	MemberDao  memberDao;
	
	@Test
	public void test_insert() {
		  String id = UUID.randomUUID().toString();
		Member member=new Member();
		member.setId(id);
		member.setNickName("hua");
		member.setPassword("123456");
				int number=memberDao.save(member);
		Assert.assertEquals(1, number);
	}
	
	@Test
	public void test_findAll() {
		List<Member> membs=memberDao.findAll(null, null);
		boolean hasyang=false;
		for(Member m:membs) {
			System.out.println("===nick name==="+m.getNickName());
			if(m.getNickName().equals("yang")) {
				hasyang=true;
			}
		}
		Assert.assertTrue(hasyang);
	}
	

}
