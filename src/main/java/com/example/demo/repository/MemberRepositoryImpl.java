package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public int insert(Member member) {
		return memberRepository.insert(member);
	}

	@Override
	public int delete(String email) {
		memberRepository.delete(email);
		return 0;
	}

	@Override
	public List<Member> selectAll() {
		return memberRepository.selectAll();
	}
	
	@Override
	public int selectMaxId() {
		return memberRepository.selectMaxId();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isValidUser(Member member) {
		return memberRepository.isValidUser(member);
	}

	@Override
	public Member selectEmail(String email) {
		return memberRepository.selectEmail(email);
	}

	@Override
	public int update(Member member) {
		System.out.println(member);
		return memberRepository.update(member);
	}

}
