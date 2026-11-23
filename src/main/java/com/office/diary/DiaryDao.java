package com.office.diary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DiaryDao {
	
	final private String DRIVER = "com.mysql.cj.jdbc.Driver";
	final private String URL = "jdbc:mysql://127.0.0.1:3306/db_diary";
	final private String USERNAME = "root";
	final private String PASSWORD = "1234";
	

	public int insertNewDiary(DiaryDto diaryDto) {
	

		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			//JDBC방식--> JDBC 템플릿--> MyBatis (프레임웍)-->JPL
			
			//1. 드라이버로드 in 메모리
			Class.forName(DRIVER); //DRIVER 로드
			
			//2. 다리 건설 : Connection 생성 by 인증(Authentication)
			 conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//3. SQL 작성(작업지시서)
			String sql = "insert into tbl_diary(diaryWord,memId) values(?, ?)";		
			//? 스테이트? -> memId-> 5번에서 값을 넣어준다
			
			//4. 일꾼 선택 (생성)
			pstmt = conn.prepareStatement(sql);
						
			//5. 데이터 주입
			pstmt.setString(1, diaryDto.getDiaryWord());
			pstmt.setString(2, diaryDto.getMemId());
			
			//6. 작업지시
			 result = pstmt.executeUpdate();
			//ResultSet이 작업된 결과를 가져옴 rs.next() bool타입 하나씩 읽고 false면 끝
			
			/*
			 * executeQuery: select,반환형(ResultSet) -> While문으로 사용하자
			 * executeUpdate() : insert(새로생긴행의수),update(업데이트된 행의수), delete(삭제된 행의수) ,  반환형(int) -> 영향을 받은 행의 수
			 * 
			 * */
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}	finally {
			
			//8                          . 외부자원 해제
			try {
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				//역순으로 자원 해제
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
		return result ;
			

	}


	public List<DiaryDto> selectDiariesByMemId(String signInedMemberId) {
		

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<DiaryDto> diaryDtos = new ArrayList<DiaryDto>();
		
		try {
			//JDBC방식--> JDBC 템플릿--> MyBatis (프레임웍)-->JPL
			
			//1. 드라이버로드 in 메모리
			Class.forName(DRIVER); //DRIVER 로드
			
			//2. 다리 건설 : Connection 생성 by 인증(Authentication)
			 conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//3. SQL 작성(작업지시서)
			String sql =  "select * from tbl_diary td "
						+ "join tbl_member tm "
						+ "on td.memId = tm.memId "
						+ "where td.memId = ?";
			//? 스테이트? -> memId-> 5번에서 값을 넣어준다
			
			//4. 일꾼 선택 (생성)
			pstmt = conn.prepareStatement(sql);
						
			//5. 데이터 주입
			pstmt.setString(1, signInedMemberId);
			
			//6. 작업지시
			 rs = pstmt.executeQuery();
			//ResultSet이 작업된 결과를 가져옴 rs.next() bool타입 하나씩 읽고 false면 끝
			
			/*
			 * executeQuery: select,반환형(ResultSet) -> While문으로 사용하자
			 * executeUpdate() : insert(새로생긴행의수),update(업데이트된 행의수), delete(삭제된 행의수) ,  반환형(int) -> 영향을 받은 행의 수
			 * 
			 * */
		
			while (rs.next()) {
				
				int diaryNo  =	rs.getInt("diaryNo");
				String diaryWord =	rs.getString("diaryWord");
				String memId = rs.getString("memId");
				String diaryRegDate = rs.getString("diaryRegDate");
				String diaryModDate = rs.getString("diaryModDate");
				int memNo =	rs.getInt("memNo");
				String memPw =	rs.getString("memPw");
				String memMail = rs.getString("memMail");
				String memPhone = rs.getString("memPhone");
				String memRegDate =	rs.getString("memRegDate");
				String memModDate = rs.getString("memModDate");
				
				DiaryDto diaryDto = new DiaryDto();
				
				diaryDto.setDiaryNo(diaryNo);
				diaryDto.setDiaryWord(diaryWord);
				diaryDto.setDiaryRegDate(diaryRegDate);
				diaryDto.setDiaryModDate(diaryModDate);
				
				diaryDto.setMemNo(memNo);
				diaryDto.setMemId(memId);
				diaryDto.setMemPw(memPw);
				diaryDto.setMemMail(memMail);
				diaryDto.setMemPhone(memPhone);
				diaryDto.setMemRegData(memRegDate);
				diaryDto.setMemModDate(diaryModDate);
				
				diaryDtos.add(diaryDto);
		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}	finally {
			
			//8                          . 외부자원 해제
			try {
				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				//역순으로 자원 해제
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
		
		return diaryDtos;
		
	
	}

}


