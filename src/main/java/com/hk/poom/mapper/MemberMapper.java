package com.hk.poom.mapper;

import org.springframework.stereotype.Repository;

import com.hk.poom.dto.FindIdDTO;
import com.hk.poom.dto.FindPwdDTO;
import com.hk.poom.dto.LoginDTO;
import com.hk.poom.dto.RegisterComDTO;
import com.hk.poom.dto.RegisterPerDTO;

@Repository
public interface MemberMapper {

	public LoginDTO memberLogin( LoginDTO loginDTO );
	public int memberRegisterCom( RegisterComDTO registerComDTO );  
	public int memberRegisterPer( RegisterPerDTO registerPerDTO );  
	public FindIdDTO memberFindId( FindIdDTO findIdDTO );
	public FindPwdDTO memberFindPwd( FindPwdDTO findPwdDTO );
	
}
