package com.itheima.web.controller.front;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.domain.Member;
import com.itheima.service.front.MemberService;
import com.itheima.web.controller.BaseController;
import com.itheima.web.controller.Code;
import com.itheima.web.controller.Result;


@Controller
@RequestMapping("/member/*")
public class MemberController extends BaseController {
	
	@Autowired
	MemberService memberService;
    
	@RequestMapping(value="register",method = RequestMethod.POST)
	@ResponseBody
    public Result register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Member member = getData(request, Member.class);
        boolean flag = memberService.register(member);
        return new Result("注册成功！", null);
    }
	@RequestMapping(value="find",method = RequestMethod.GET)
	@ResponseBody
	 public Result find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	       List<Member> mems=memberService.find();
	        return new Result("注册成功！", mems);
	    }
	

    public Result login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Member member = getData(request,Member.class);
        member = memberService.login(member.getEmail(),member.getPassword());

        if(member != null){
            return new Result("登录成功！", member);
        }else{
            return new Result("用户名密码错误，请重试！", false, null, Code.LOGIN_FAIL);
        }
    }

    public Result checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Member member = getData(request,Member.class);
        //根据获取到的id去redis中查找，是否存在
        String nickName = memberService.getLoginInfo(member.getId());
        return new Result("", nickName);
    }

    public Result logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Member member = getData(request,Member.class);
        boolean flag = memberService.logout(member.getId());
        if(flag){
            return new Result("退出成功!", flag);
        }else{
            return new Result("", false, flag, Code.LOGOUT_FAIL);
        }
    }

}


