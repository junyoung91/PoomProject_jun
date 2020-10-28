<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어드민 페이지</title>
<jsp:include page="../include/inHead.jsp"></jsp:include>
<style type="text/css">
/*-- POPUP common style S ======================================================================================================================== --*/
#mask {
   position: absolute;
   left: 0;
   top: 0;
   z-index: 999;
   background-color: #000000;
   display: none;
}

.layerpop {
   display: none;
   z-index: 1000;
   border: 2px solid #ccc;
   background: #fff;
   /*    cursor: move; */
}

.layerpop_area .title {
   padding: 10px 10px 10px 10px;
   border: 0px solid #aaaaaa;
   background: #f1f1f1;
   color: #3eb0ce;
   font-size: 1.3em;
   font-weight: bold;
   line-height: 24px;
}

.layerpop_area .layerpop_close {
   width: 25px;
   height: 25px;
   display: block;
   position: absolute;
   top: 10px;
   right: 10px;
   background: transparent url('btn_exit_off.png') no-repeat;
}

.layerpop_area .layerpop_close:hover {
   background: transparent url('btn_exit_on.png') no-repeat;
   cursor: pointer;
}

.layerpop_area .content {
   width: 96%;
   margin: 2%;
   color: #828282;
}

#target1 {
   color: #2C952C;
   text-align: center;
   padding: 15px;
}

.star_rating {
   font-size: 0;
   letter-spacing: -4px;
}

.star_rating a {
   font-size: 22px;
   letter-spacing: 0;
   display: inline-block;
   margin-left: 5px;
   color: #ccc;
   text-decoration: none;
}

.starRev span:first-child {
   margin-left: 0;
}

.starRev span.on {
   color: red;
}
/*-- POPUP common style E --*/
</style>

<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<!-- 다음 주소찾기 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- 레이어 팝업 -->
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>

<script>
   function wrapWindowByMask() {
      //화면의 높이와 너비를 구한다.
      var maskHeight = $(document).height();
      var maskWidth = $(window).width();
      //문서영역의 크기 
      //console.log("document 사이즈:" + $(document).width() + "*" + $(document).height());
      //브라우저에서 문서가 보여지는 영역의 크기
      //console.log("window 사이즈:" + $(window).width() + "*" + $(window).height());
      //마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
      $('#mask').css({
         'width' : maskWidth,
         'height' : maskHeight
      });
      //애니메이션 효과
      //$('#mask').fadeIn(1000);      
      $('#mask').fadeTo("slow", 0.5);
   }
   function popupOpen() {
      $('.layerpop').css("position", "absolute");
      //영역 가운에데 레이어를 뛰우기 위해 위치 계산 
      $('.layerpop').css(
            "top",
            (($(window).height() - $('.layerpop').outerHeight()) / 2)
                  + $(window).scrollTop());
      $('.layerpop').css(
            "left",
            (($(window).width() - $('.layerpop').outerWidth()) / 2)
                  + $(window).scrollLeft());
      $('.layerpop').draggable();
      $('#layerbox').show();
   }
   function popupClose() {
      $('#layerboxc').hide();
      $('#mask').hide();
   }
   function goDetail() {
      /*팝업 오픈전 별도의 작업이 있을경우 구현*/
      popupOpen(); //레이어 팝업창 오픈 
      wrapWindowByMask(); //화면 마스크 효과 
   }
   $(document).ready(function() {
      var formObj = $("form[name='memberDelete']");
      $(".write_btn").on("click", function() {
         if (fn_valiChk()) {
            return false;
         }
         alert("회원 탈퇴가 완료되었습니다.");
         formObj.attr("action", "/poom/delete");
         formObj.attr("method", "post");
         formObj.submit();
      });
   })
</script>

</head>
<jsp:include page="../include/header.jsp"></jsp:include>

  <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">MEMBER</h1>
          <p class="mb-4">사용자 리스트
          &nbsp;&nbsp;&nbsp;<a href="register">등록</a>
          &nbsp;&nbsp;&nbsp; 로그인 사용자 정보 :  <c:out value="${loginMember.name }" />
          &nbsp;&nbsp;&nbsp;<a href="/poom/logout">로그아웃</a>
          </p>





<!-- DataTales Example -->
          <div class="card shadow mb-4">

            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>#번호</th>
                      <th>회원타입</th>
                      <th>아이디</th>
                      <th>이메일</th>
                      <th>주소</th>
                      <th>회원가입일</th>
                      <th>회원 상세보기</th>
<!--                       <th>업체 승인버튼</th> -->
                      
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${members}" var="member">
                    <tr>
                      <td><c:out value="${member.mno }" /></td>
                      <td><a href='update?mno=<c:out value="${member.mno }" />' ><c:out value="${member.type_m }" /></a></td>
                      <td><c:out value="${member.id }" /></td>
                      <td><c:out value="${member.email }" /></td>
                      <td><c:out value="${member.firstAddr }" /></td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${member.cre_date_m }" /></td>
                      <td><button type="button" id="emailBtn" onclick="location.href='/poom/eachpage?mno=<c:out value="${member.mno }" />&mtp=<c:out value="${member.type_m }" />' ">회원 상세보기</button>
<!--              			     레이어 팝업 배경 시작 -->
<!--        						  <div id="mask"></div> -->
<!--        						  <div id="layerbox" class="layerpop" style="width: 700px; height: 350px;"> -->
<!--            						 <article class="layerpop_area"> -->
<!--             					   <div class="title2">탈퇴하기</div> -->
<!--              					  <a href="javascript:popupClose();" class="layerpop_close" id="layerbox_close"></a> <br> -->
<!--               					 <form method="post" action="/poom/delete" name="memberDelete"> -->
<!--                						<img style="border-radius:20px" onerror="this.src='/resources/img/testImg.jpg'" src="/resources/img/delete.jpg" width="140px" height="200px"> -->
<%-- 									${member.name}님, 정말 탈퇴하시겠습니까ㅠ? --%>
<!-- 									<div style="display: none;"> -->
<%-- 										<input type="hidden" name="mno" value="${member.mno}"> --%>
<%-- 										<input type="hidden" name="type_m" value="${member.type_m}"></div> --%>
<!-- 									<button type="submit" class="write_btn">탈퇴하기</button> -->
<%-- 									<button type="button" onclick="location.href='/poom/mypage?mno=${member.mno}'">취소</button> --%>
<!--                					</form> -->
<!--            					 </article> -->
<!--         				 </div> -->
<!--         				 레이어 팝업 배경 끝 -->
                      </td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          
<!--           DataTales Example -->
          <div class="card shadow mb-4">

            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>#회원번호</th>
                      <th>게시글 번호</th>
                      <th>분양글 번호</th>
                      <th>제목</th>
                      <th>가격</th>
<!--                       <th>글작성 </th> -->
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${rehomes}" var="rehome">
                    <tr>
                      <td><c:out value="${rehome.mno }" /></td>
                      <td><a href='update?mno=<c:out value="${rehome.mno }" />' ><c:out value="${rehome.bno }" /></a></td>
                      <td><c:out value="${rehome.rno }" /></td>
                      <td><c:out value="${rehome.title }" /></td>
                      <td><c:out value="${rehome.cost }" /></td>
<%--                       <td><fmt:formatDate pattern="yyyy-MM-dd" value="${rehome.cre_date_m }" /></td> --%>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
<jsp:include page="../include/footer.jsp"></jsp:include>