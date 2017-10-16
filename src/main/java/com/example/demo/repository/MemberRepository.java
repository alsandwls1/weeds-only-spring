package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Member;

@Mapper
public interface MemberRepository {
	
	public int insert(Member member);
	public int delete(String email);
	
	public int update(Member member);
	
	public List<Member> selectAll();
	public int selectMaxId();
	public int count();
	
	
	public boolean isValidUser(Member member);
	
	public Member selectEmail(String email);
}
