package com.example.demo.repository2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Member;

@Repository
public class MemberRepositoryImpl2 implements MemberRepository2 {
	List<Member> members = new ArrayList<Member>();
	{
		members.add(new Member("a@naver.com", "a", "a", "/img/profile_default.png"));
		members.add(new Member("b@naver.com", "b", "b", "/img/character_01.png"));
		members.add(new Member("c@naver.com", "c", "c", "/img/character_02.png"));
		members.add(new Member("d@naver.com", "d", "d", "/img/character_03.png"));
	}
	
	
	@Override
	public void insert(Member member) {
		members.add(member);
	}

	@Override
	public void delete(String email) {
		members.remove(0);
	}

	@Override
	public List<Member> selectAll() {
		return members; 
	}
	
	@Override
	public int selectMaxId() {
		///????????????????
		return members.size()+1;
	}

	@Override
	public int count() {
		return members.size()+1;
	}

	@Override
	public boolean isValidUser(Member member) {
		return true;
	}

	@Override
	public Member selectEmail(String email) {
		return members.get(0);
	}

	@Override
	public void update(Member member) {
		System.out.println(member);
	}

}
