package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class MemberController {
	@Autowired
	private MemberRepository memberRepository;

	@GetMapping("/members")
	public Object get() {
		return memberRepository.selectAll();
	}
	
	@GetMapping("/members/{email:.+}")
	public Object getEmail(@PathVariable String email) {
		System.out.println("getEmail() # email="+email);
		return memberRepository.selectEmail(email);
	}

	@PostMapping(value = { "/members" }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String post(@RequestBody Member member) {
		try {
			memberRepository.insert(member);
			return "1";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "0";
	}

	@DeleteMapping("/members/{email}")
	public void delete(@PathVariable String email) {
		System.out.println(email);
		memberRepository.delete(email);
	}

	
	@PostMapping(value = { "/members/{email}"}, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Object post2(@RequestBody Member member) {
			System.out.println("member =" + member);
			
			memberRepository.update(member);
			System.out.println(memberRepository.selectEmail(member.getEmail()));
			
			return memberRepository.selectEmail(member.getEmail());
//			return null;
	}
	
	
	@RequestMapping(value = { "/members/login" }, method = RequestMethod.POST)
	public Object login1(@RequestBody Member member, HttpSession session) {
		System.out.println(memberRepository.isValidUser(member));
		if (memberRepository.isValidUser(member)) {
			session.setAttribute("a", member.getEmail());
			System.out.println(session.getAttribute("a"));
			return session.getAttribute("a");
		}
		return "fail";
	}

}
