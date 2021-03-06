package com.hk.poom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hk.poom.dto.AdminPayDTO;
import com.hk.poom.dto.CategoryDTO;
import com.hk.poom.dto.RehomeAddDTO;
import com.hk.poom.dto.RehomeListDTO;
import com.hk.poom.dto.RehomeReadDTO;
import com.hk.poom.dto.RehomeReportDTO;
import com.hk.poom.dto.RehomeUpdateDTO;
import com.hk.poom.mapper.RehomeMapper;

@Service
public class RehomeService {

	@Autowired
	RehomeMapper rehomeMapper;
	
	@Autowired
	DataSourceTransactionManager transactionManager;
	

	public List<RehomeAddDTO> rehomeList( ) {
		return rehomeMapper.rehomeList( );
	}

	public RehomeUpdateDTO rehomeGetOne( int bno ) {
		return rehomeMapper.rehomeGetOne( bno );
	}
   
	public int rehomeUpdate( RehomeUpdateDTO rehomeUpdateDTO ) {
		return rehomeMapper.rehomeUpdate( rehomeUpdateDTO );				
	}
	public int rehomeUpdate1( RehomeUpdateDTO rehomeUpdateDTO ) {
		return rehomeMapper.rehomeUpdate1( rehomeUpdateDTO );				
	}
	public int rehomeDelete( int bno ) {
		return rehomeMapper.rehomeDelete( bno );
   	}

	public RehomeReadDTO rehomeRead( int bno ) {
		return rehomeMapper.rehomeRead( bno );
	}
	public List<CategoryDTO> category(){
		return rehomeMapper.category();
	}

	@Transactional
	public int rehomeAddPost(RehomeAddDTO rehomeAddDTO) {
		 TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
	      // Transaction Test
	      try { 
	         rehomeMapper.rehomeAddPost(rehomeAddDTO);
	         rehomeMapper.rehomeAddPost1(rehomeAddDTO);
	         rehomeMapper.rehomeAddPost2(rehomeAddDTO);
	      } catch (Exception e) { 
	         System.out.println("Service ------------------- End");
	         // 비정상일때는 rollback
	         transactionManager.rollback(txStatus);
	         return 0;
	      }
	      // 정상일때는 commit (빼먹으면 안됨)
	      transactionManager.commit(txStatus);
	      return 1;      
		
	
	      //return rehomeMapper.rehomeAddPost(rehomeAddDTO);
		
		// TODO Auto-generated method stub
		
	}
	
	public String rehomeCateName( String cateCode ) {
		return rehomeMapper.rehomeCateName( cateCode );				
	}
	
	public int rehomeCateUpdate(RehomeAddDTO rehomeAddDTO ) {
		return rehomeMapper.rehomeCateUpdate(rehomeAddDTO);				
	}
	public RehomeReportDTO rehomeGetOne1( int bno ) {
		return rehomeMapper.rehomeGetOne1( bno );
	}
	public int report( RehomeReportDTO report ) {
		return rehomeMapper.report(report);			
	}
	public int rehomePay( ) {
		return rehomeMapper.rehomePay();
	}
	public int rehomePayPost( AdminPayDTO adminPayDTO ) {
		return rehomeMapper.rehomePayPost(adminPayDTO);
	}
	
}
