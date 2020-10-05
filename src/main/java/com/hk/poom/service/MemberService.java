package com.hk.poom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.poom.dto.FindIdDTO;
import com.hk.poom.dto.FindPwdDTO;
import com.hk.poom.dto.LoginDTO;
import com.hk.poom.dto.RegisterComDTO;
import com.hk.poom.dto.RegisterPerDTO;
import com.hk.poom.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired 
	MemberMapper memberMapper;

	public LoginDTO memberLogin( LoginDTO loginDTO ) {
		return memberMapper.memberLogin( loginDTO );
	}

	public int memberRegisterCom( RegisterComDTO registerComDTO ) {
		int retVal = memberMapper.memberRegisterCom( registerComDTO );
		return retVal;
	}

	public int memberRegisterPer( RegisterPerDTO registerPerDTO ) {
		int retVal = memberMapper.memberRegisterPer( registerPerDTO );
		return retVal;
	}

	public FindIdDTO memberFindId( FindIdDTO findIdDTO ) {
		return memberMapper.memberFindId( findIdDTO );
	}

	public FindPwdDTO memberFindPwd( FindPwdDTO findPwdDTO ) {
		return memberMapper.memberFindPwd( findPwdDTO );
	}

}
