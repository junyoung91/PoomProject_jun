package com.hk.poom.controller;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hk.poom.HomeController;
import com.hk.poom.dto.CategoryDTO;
import com.hk.poom.dto.RehomeAddDTO;
import com.hk.poom.dto.RehomeReportDTO;
import com.hk.poom.dto.RehomeUpdateDTO;
import com.hk.poom.service.RehomeService;

import net.sf.json.JSONArray;

@Controller
public class RehomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
   @Autowired
   RehomeService rehomeService;
   
   @Autowired
	ServletContext sc;
   
   @GetMapping("/poom/rehome/list")
   public String rehomeList(Model model ) {
      model.addAttribute("rehomeList",rehomeService.rehomeList());
      
      return "rehome/rehomeList";
   }

   
//   @GetMapping("/poom/rehome/add")
//   public String rehomeAdd(Model model ) {
//	   logger.info("카테고리불러오기");
//	   List<CategoryDTO> category = null;
//	    category = rehomeService.category();
//	    System.out.println(category);
//	    model.addAttribute("category", JSONArray.fromObject(category));
//	    logger.info("카테고리"+model);
//      return "rehome/rehomeAdd";
//   }
   
 @GetMapping("/poom/rehome/add")
 public String rehomeAdd(Model model, RehomeAddDTO rehomeAddDTO) throws Exception{
    logger.info("카테고리불러와야해");
    
    List<CategoryDTO> category =null;
    category = rehomeService.category();
    model.addAttribute("category",JSONArray.fromObject(category));
 
    logger.info("category" + model);
    
    
    return "rehome/rehomeAdd";
 }
   
//   @PostMapping("/poom/rehome/add")
//   public String rehomeAddPost(Model model, RehomeAddDTO rehomeAddDTO ) {
//	   List<CategoryDTO> category = null;
//	    category = rehomeService.category();
//	    model.addAttribute("category", JSONArray.fromObject(category));
//      
//      rehomeService.rehomeAdd(rehomeAddDTO);
//      
//      model.addAttribute("rehomeadd",rehomeAddDTO);
//            
//      return "rehome/rehomeAddPost";
//   }
   

   @PostMapping("/poom/rehome/add")
   public String rehomeAddPost(@RequestParam("file") MultipartFile[] file, Model model,RehomeAddDTO rehomeAddDTO, @RequestParam("cateCode") String cateCode) {
    //logger.info("form 전송");
    //System.out.println(rehomeAddDTO.toString());
	   for(int i=0; i<file.length; i++) {
//           System.out.println("================== file start ==================");
//           System.out.println("파일 이름: "+file[i].getName());
//           System.out.println("파일 실제 이름: "+file[i].getOriginalFilename());
//           System.out.println("파일 크기: "+file[i].getSize());
//           System.out.println("content type: "+file[i].getContentType());
//           System.out.println("================== file   END ==================");
           
           String realPath = sc.getRealPath("/resources/img/rehome/");
           String genID = UUID.randomUUID().toString();
           String oriName = file[i].getOriginalFilename();
           String img_r = genID+"."+FilenameUtils.getExtension(oriName);
           
           if (i==0) { rehomeAddDTO.setImg_r2(""); rehomeAddDTO.setImg_r3(""); rehomeAddDTO.setImg_r4(""); rehomeAddDTO.setImg_r5("");} 
           else if (i==1) { rehomeAddDTO.setImg_r3(""); rehomeAddDTO.setImg_r4(""); rehomeAddDTO.setImg_r5(""); }
           else if (i==2) { rehomeAddDTO.setImg_r4(""); rehomeAddDTO.setImg_r5(""); }
           else if (i==3) { rehomeAddDTO.setImg_r5(""); }
           
           if (i==0) { rehomeAddDTO.setImg_r1(img_r); } 
           else if (i==1) { rehomeAddDTO.setImg_r2(img_r); }
           else if (i==2) { rehomeAddDTO.setImg_r3(img_r); }
           else if (i==3) { rehomeAddDTO.setImg_r4(img_r); }
           else if (i==4) { rehomeAddDTO.setImg_r5(img_r); }
           
           File oldProfFile = new File(realPath + file[i].getOriginalFilename());	// 업로드한 파일이 실제로 저장되는 위치  + 파일명 (확장자 포함) => 실행 디렉토리
   	    File newProfFile = new File(realPath + img_r);
   	    oldProfFile.renameTo(newProfFile);	// 파일명 변경
   	  
//   	  System.out.println("-----------완성 파일명 : "+ img_r);
   	  try {
   			// 소스 디렉토리에 저장된 파일을 실행 디렉토리에 복사하라는 명령?
   			InputStream fileStream = file[i].getInputStream();
   			FileUtils.copyInputStreamToFile(fileStream, newProfFile);
   		} catch (Exception e) {
   			FileUtils.deleteQuietly(newProfFile);
   			e.printStackTrace();
   		}
       }

      model.addAttribute("rehomeAddPost",rehomeAddDTO);   
	   rehomeService.rehomeAddPost(rehomeAddDTO);
    
    String cateName = rehomeService.rehomeCateName(cateCode);
    //System.out.println("cateName=" + cateName);
    rehomeAddDTO.setCateName(cateName);
    //RehomeAddDTO catNameSet = rehomeAddDTO;
    rehomeService.rehomeCateUpdate(rehomeAddDTO);
    
   return "rehome/rehomeAddPost";  
   }
   
   
   
   
   @GetMapping("/poom/rehome/update")
   public String rehomeGetOne(@RequestParam("bno") int bno, Model model) {
      model.addAttribute("rehomeGetOne",rehomeService.rehomeGetOne(bno));
      return "rehome/rehomeUpdate";
   }
   
   
   @PostMapping("/poom/rehome/update")
	public String rehomeUpdate(@RequestParam("file1")MultipartFile mf1,@RequestParam("file2")MultipartFile mf2,
			@RequestParam("file3")MultipartFile mf3,@RequestParam("file4")MultipartFile mf4,
			@RequestParam("file5")MultipartFile mf5,Model model, RehomeUpdateDTO rehomeUpdateDTO) {

		String oldfile1=rehomeUpdateDTO.getImg_r1();
		String oldfile2=rehomeUpdateDTO.getImg_r2();
		String oldfile3=rehomeUpdateDTO.getImg_r3();
		String oldfile4=rehomeUpdateDTO.getImg_r4();
		String oldfile5=rehomeUpdateDTO.getImg_r5();

		System.out.println("--------------------------------------------------------");
		System.out.println("set1 = " + oldfile1);
		System.out.println("set2 = " + oldfile2);
		System.out.println("set3 = " + oldfile3);
		System.out.println("set4 = " + oldfile4);
		System.out.println("set5 = " + oldfile5);

		String realPath = sc.getRealPath("/resources/img/rehome/");
		String genID1 = UUID.randomUUID().toString();
		String genID2 = UUID.randomUUID().toString();
		String genID3 = UUID.randomUUID().toString();
		String genID4 = UUID.randomUUID().toString();
		String genID5 = UUID.randomUUID().toString();

		String oriName1 = mf1.getOriginalFilename();
		String img_r1 = genID1+"."+FilenameUtils.getExtension(oriName1);
		String oriName2 = mf2.getOriginalFilename();
		String img_r2 = genID2+"."+FilenameUtils.getExtension(oriName2);
		String oriName3 = mf3.getOriginalFilename();
		String img_r3 = genID3+"."+FilenameUtils.getExtension(oriName3);
		String oriName4 = mf4.getOriginalFilename();
		String img_r4 = genID4+"."+FilenameUtils.getExtension(oriName4);
		String oriName5 = mf5.getOriginalFilename();
		String img_r5 = genID5+"."+FilenameUtils.getExtension(oriName5);

		if (mf1.isEmpty()) {rehomeUpdateDTO.setImg_r1(oldfile1);}
		else {rehomeUpdateDTO.setImg_r1(img_r1);
		System.out.println("img_r1 = "+img_r1);}
		if (mf2.isEmpty()) {rehomeUpdateDTO.setImg_r2(oldfile2);}
		else {rehomeUpdateDTO.setImg_r2(img_r2);
		System.out.println("img_r2 = "+img_r2);}
		if (mf3.isEmpty()) {rehomeUpdateDTO.setImg_r3(oldfile3);}
		else {rehomeUpdateDTO.setImg_r3(img_r3);
		System.out.println("img_r3 = "+img_r3);}
		if (mf4.isEmpty()) {rehomeUpdateDTO.setImg_r4(oldfile4);}
		else {rehomeUpdateDTO.setImg_r4(img_r4);
		System.out.println("img_r4 = "+img_r4);}
		if (mf5.isEmpty()) {rehomeUpdateDTO.setImg_r5(oldfile5);}
		else {rehomeUpdateDTO.setImg_r5(img_r5);
		System.out.println("img_r5 = "+img_r5);}

		File oldProfFile1 = new File(realPath + mf1.getOriginalFilename());	// 업로드한 파일이 실제로 저장되는 위치  + 파일명 (확장자 포함) => 실행 디렉토리
		File newProfFile1 = new File(realPath + img_r1);
		oldProfFile1.renameTo(newProfFile1);	// 파일명 변경

		File oldProfFile2 = new File(realPath + mf2.getOriginalFilename());	// 업로드한 파일이 실제로 저장되는 위치  + 파일명 (확장자 포함) => 실행 디렉토리
		File newProfFile2 = new File(realPath + img_r2);
		oldProfFile2.renameTo(newProfFile2);	// 파일명 변경

		File oldProfFile3 = new File(realPath + mf3.getOriginalFilename());	// 업로드한 파일이 실제로 저장되는 위치  + 파일명 (확장자 포함) => 실행 디렉토리
		File newProfFile3 = new File(realPath + img_r3);
		oldProfFile3.renameTo(newProfFile3);	// 파일명 변경

		File oldProfFile4 = new File(realPath + mf4.getOriginalFilename());	// 업로드한 파일이 실제로 저장되는 위치  + 파일명 (확장자 포함) => 실행 디렉토리
		File newProfFile4 = new File(realPath + img_r4);
		oldProfFile4.renameTo(newProfFile4);	// 파일명 변경

		File oldProfFile5 = new File(realPath + mf5.getOriginalFilename());	// 업로드한 파일이 실제로 저장되는 위치  + 파일명 (확장자 포함) => 실행 디렉토리
		File newProfFile5 = new File(realPath + img_r5);
		oldProfFile5.renameTo(newProfFile5);	// 파일명 변경

		//   	  System.out.println("-----------완성 파일명 : "+ img_r);
		try {
			// 소스 디렉토리에 저장된 파일을 실행 디렉토리에 복사하라는 명령?
			InputStream fileStream1 = mf1.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream1, newProfFile1);
		} catch (Exception e) {
			FileUtils.deleteQuietly(newProfFile1);
			e.printStackTrace();
		}

		try {
			// 소스 디렉토리에 저장된 파일을 실행 디렉토리에 복사하라는 명령?
			InputStream fileStream2 = mf2.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream2, newProfFile2);
		} catch (Exception e) {
			FileUtils.deleteQuietly(newProfFile2);
			e.printStackTrace();
		}

		try {
			// 소스 디렉토리에 저장된 파일을 실행 디렉토리에 복사하라는 명령?
			InputStream fileStream3 = mf3.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream3, newProfFile3);
		} catch (Exception e) {
			FileUtils.deleteQuietly(newProfFile3);
			e.printStackTrace();
		}
		try {
			// 소스 디렉토리에 저장된 파일을 실행 디렉토리에 복사하라는 명령?
			InputStream fileStream4 = mf4.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream4, newProfFile4);
		} catch (Exception e) {
			FileUtils.deleteQuietly(newProfFile4);
			e.printStackTrace();
		}

		try {
			// 소스 디렉토리에 저장된 파일을 실행 디렉토리에 복사하라는 명령?
			InputStream fileStream5 = mf5.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream5, newProfFile5);
		} catch (Exception e) {
			FileUtils.deleteQuietly(newProfFile5);
			e.printStackTrace();
		}


		model.addAttribute("rehomeUpdate",rehomeService.rehomeUpdate(rehomeUpdateDTO));
		model.addAttribute("rehomeUpdate1",rehomeService.rehomeUpdate1(rehomeUpdateDTO));


		return "rehome/rehomeUpdatePost";
	}
   
 
   
   @GetMapping("/poom/rehome/delete")
   public String rehomeDelete(@RequestParam("bno")int bno,Model model) {

      model.addAttribute("bno",bno);
      
      return "rehome/rehomeDelete";
   }
   
   @PostMapping("/poom/rehome/delete")
   public String rehomeDeletePost(@RequestParam("bno")int bno) throws Exception{
      rehomeService.rehomeDelete(bno);
        
      return "redirect:/poom/rehome/list";
   }

   @GetMapping("/poom/rehome/read")
   public String rehomeRead(@RequestParam("bno") int bno, @RequestParam("mno") int mno, Model model, HttpSession session) {
      logger.info("bno=" + bno);
      // 글쓴이 정보 -> MyInterceptor에서 사용
      session.setAttribute("writerMno", mno);
      model.addAttribute("rehomeRead",rehomeService.rehomeRead(bno));
      return "rehome/rehomeRead";
   }
 
   @GetMapping("/poom/rehome/pay")
   public String rehomePay(@RequestParam("bno") int bno, @RequestParam("id_writer") String id_saler, @RequestParam("id_reader") String id_buyer, @RequestParam("cost") int cost, Model model) {
	   //logger.info("id_saler=" + id_saler + "id_buyer=" + id_buyer + "cost=" + cost);
	   model.addAttribute("bno",bno);
	   model.addAttribute("id_saler",id_saler);
	   model.addAttribute("id_buyer",id_buyer);
	   model.addAttribute("cost",cost);
	    
	   return "rehome/pay";
   }
   @GetMapping("/poom/rehome/paySuccess")
   public String rehomePaySuccess() {
	   return "rehome/paySuccess";
   }
   
   @GetMapping("/poom/rehome/payFail")
   public String rehomePayFail() {
	   return "rehome/payFail";
   }
   
 
   
   
   
   
   @GetMapping("/poom/rehome/report")
   public String rehomeGetOne1(@RequestParam("bno") int bno, Model model) {
	   model.addAttribute("rehomeGetOne1",rehomeService.rehomeGetOne(bno));
	   return "rehome/report";
   }
   @PostMapping("/poom/rehome/report")
   public String report(Model model, RehomeReportDTO report) {
	   model.addAttribute("report",rehomeService.report(report));
	       
      return "rehome/reportDone";
   }
   
   
   
   
}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

