<%@page import="com.office.diary.DiaryDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/title.jsp"/>

<link href = "./res/css/member/signup_form.css" rel = "stylesheet" type= "text/css"> 

<jsp:include page="../include/diary/diary.jsp"/>

</head>
<body>

	
	<jsp:include page="../include/header.jsp"/>
	
	<jsp:include page="../include/nav.jsp"/>
	

	
	<article>
		<div class = "articel_wrap">
		
			<h3>THIS PAGE IS MY DIARIES.</h3>
		
		
			<%
				List<DiaryDto> myDiaries = (List<DiaryDto>)request.getAttribute("myDiaries");
				for (int i = 0; i < myDiaries.size(); i++){
					
				}
			%>
			<table border = "1">
			 <thead>
				<tr>
					<td>diaryNo</td>
					<td>diaryWord</td>
					<td>diaryRegDate</td>
					<td>diaryModDate</td>
					<td>memNo</td>
					<td>memId</td>
					<td>memPw</td>
					<td>memMail</td>
					<td>memPhone</td>
					<td>memRegData</td>
					<td>memModDate</td>		
				</tr>
				</thead>
				<tbody>
					<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>		
					</tr>
				</tbody>
			</table>
			
		
			
			
		</div>
	</article>
	
	<jsp:include page="../include/footer.jsp"/>
	
</body>
</html>