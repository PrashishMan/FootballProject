package com.footballproject.services;

import java.util.List;

import com.footballproject.model.Member;

public interface MemberService {
	public void addMember(Member member);
	public Member getMember(String memberId);
	public List<Member> getMember();
	public int getMemberCount();
	public List<Member> getNewMember();
	public List<Member> getPaymentDueMember();
}
