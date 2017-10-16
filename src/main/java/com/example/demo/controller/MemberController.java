package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

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

@RestController
public class MemberController {
	@Autowired
	private MemberRepository memberRepository;

	
	List<Member> memberList = new ArrayList<>();
	
	@GetMapping("/members")
	public Object get() {

	//		return memberRepository.selectAll();
		System.out.println(memberList);
		return memberList;
	}
	
	@GetMapping("/members/{email:.+}")
	public Object getEmail(@PathVariable String email) {
		System.out.println("getEmail() # email="+email);
//		return memberRepository.selectEmail(email);
		
		for (Member member : memberList) {
			if(member.getEmail().equals(email)){
				return member;
			}
		}
		return null;
	}

	@PostMapping(value = { "/members" }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String post(@RequestBody Member member) {
		try {
//			memberRepository.insert(member);
			memberList.add(member);
			System.out.println(memberList);
			return "1";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "0";
	}

	@DeleteMapping("/members/{email}")
	public void delete(@PathVariable String email) {
		System.out.println(email);
		for (Member member : memberList) {
			if(member.getEmail() == email){
				memberList.remove(member);
			}
		}
//		memberRepository.delete(email);
	}

	
	@PostMapping(value = { "/members/{email}"}, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Object post2(@RequestBody Member member) {
			System.out.println("member =" + member);
			
			for (Member member2 : memberList) {
				if(member2.getEmail() == member.getEmail()){
					memberList.remove(member2);
					memberList.add(member);
				}
			}
			
//			memberRepository.update(member);
//			System.out.println(memberRepository.selectEmail(member.getEmail()));
			
//			return memberRepository.selectEmail(member.getEmail());
			return member;
	}
	
	
	@RequestMapping(value = { "/members/login" }, method = RequestMethod.POST)
	public Object login1(@RequestBody Member member, HttpSession session) {
//		System.out.println(memberRepository.isValidUser(member));
//		if (memberRepository.isValidUser(member)) {
//			session.setAttribute("a", member.getEmail());
//			System.out.println(session.getAttribute("a"));
//			return session.getAttribute("a");
//		}
//		return "fail";
		
		System.out.println("member= " + member.getEmail()+" " +  member.getPassword());
		for (Member member2 : memberList) {
			System.out.println("member2 = " + member2.getEmail() +" " +  member2.getPassword());
			if(member2.getEmail().equals(member.getEmail()) && member2.getPassword().equals(member.getPassword())){
				session.setAttribute("a", member.getEmail());
				return session.getAttribute("a");
			}
		}
		return "fail";
		
		
	}

}
