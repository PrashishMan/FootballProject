package com.footballproject.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.footballproject.dao.MemberDao;
import com.footballproject.model.Member;
import com.footballproject.services.MemberService;

@Service("memberServiceImpl")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberDao;
	
	@Override
	@Transactional(readOnly = false)
	public void addMember(Member member) {
		memberDao.addMember(member);
		
	}

	@Override
	public Member getMember(String memberId) {
		return memberDao.getMember(memberId);
	}

	@Override
	public List<Member> getMember() {
		return memberDao.getMember();
	}
	
	@Override
	public int getMemberCount() {
		return memberDao.getMemberCount();
	}

	@Override
	public List<Member> getNewMember() {
		return memberDao.getNewMember();
	}

	@Override
	public List<Member> getPaymentDueMember() {
		// TODO Auto-generated method stub
		return  memberDao.getPaymentDueMember();
	}

}
