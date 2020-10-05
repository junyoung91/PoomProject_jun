package com.hk.poom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.poom.dto.RehomeAddDTO;
import com.hk.poom.dto.RehomeListDTO;
import com.hk.poom.dto.RehomeReadDTO;
import com.hk.poom.dto.RehomeUpdateDTO;
import com.hk.poom.mapper.RehomeMapper;

@Service
public class RehomeService {

	@Autowired
	RehomeMapper rehomeMapper;

	public List<RehomeListDTO> rehomeList( ) {
		return rehomeMapper.rehomeList( );
	}
   
	public int rehomeAdd( RehomeAddDTO rehomeAddDTO ) {
		return rehomeMapper.rehomeAdd( rehomeAddDTO );
	}

	public RehomeUpdateDTO rehomeGetOne( int bno ) {
		return rehomeMapper.rehomeGetOne( bno );
	}
   
	public int rehomeUpdate( RehomeUpdateDTO rehomeUpdateDTO ) {
		return rehomeMapper.rehomeUpdate( rehomeUpdateDTO );
	}
   
	public int rehomeDelete( int bno ) {
		return rehomeMapper.rehomeDelete( bno );
   	}

	public RehomeReadDTO rehomeRead( int bno ) {
		return rehomeMapper.rehomeRead( bno );
	}

}
