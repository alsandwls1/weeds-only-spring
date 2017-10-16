package com.example.demo.repository2;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Member;

//@Mapper
public interface MemberRepository2 {
	
	public void insert(Member member);
	public void delete(String email);
	
	public void update(Member member);
	
	public List<Member> selectAll();
	public int selectMaxId();
	public int count();
	
	
	public boolean isValidUser(Member member);
	
	public Member selectEmail(String email);
}
