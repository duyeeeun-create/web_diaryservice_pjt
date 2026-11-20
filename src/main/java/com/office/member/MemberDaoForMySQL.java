
package com.office.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoForMySQL implements IMemberDao {
	
	final private String DRIVER = "com.mysql.cj.jdbc.Driver";
	final private String URL = "jdbc:mysql://127.0.0.1:3306/db_diary";
	final private String USERNAME = "root";
	final private String PASSWORD = "1234";
	
	@Override
	public boolean isMember(String memId) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		
		
		try {
			//JDBC방식--> JDBC 템플릿--> MyBatis (프레임웍)-->JPL
			
			//1. 드라이버로드 in 메모리
			Class.forName(DRIVER); //DRIVER 로드
			
			//2. 다리 건설 : Connection 생성 by 인증(Authentication)
			 conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//3. SQL 작성(작업지시서)
			String sql = "select count(*) cnt from tbl_member where memId = ?";			
			//? 스테이트? -> memId-> 5번에서 값을 넣어준다
			
			//4. 일꾼 선택 (생성)
			pstmt = conn.prepareStatement(sql);
						
			//5. 데이터 주입
			pstmt.setString(1, memId);
		
			
			//6. 작업지시
			 rs =	pstmt.executeQuery();
			//ResultSet이 작업된 결과를 가져옴 rs.next() bool타입 하나씩 읽고 false면 끝
			
			/*
			 * executeQuery: select,반환형(ResultSet) -> While문으로 사용하자
			 * executeUpdate() : insert(새로생긴행의수),update(업데이트된 행의수), delete(삭제된 행의수) ,  반환형(int) -> 영향을 받은 행의 수
			 * 
			 * */
			 //7. 가져온 데이터 분석
			 
			 while (rs.next()) {
				result = rs.getInt("cnt");
				
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
		return result == 0 ? false : true;
	}

	

	@Override
	public int insertNerMember(MemberDto memberDto) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;		
		
		try {
			
			//1. 드라이버로드 in 메모리
			Class.forName(DRIVER); //DRIVER 로드
			
			//2. 다리 건설 : Connection 생성 by 인증(Authentication)
			 conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//3. SQL 작성(작업지시서)
			String sql = "insert into "
							+ "tbl_member("
								+ "memId, "
								+ "memPw,"
								+ "memMail, "
								+ "memPhone) " 
						+ "values(?, ?, ?, ?)";			
			
			//4. 일꾼 선택 (생성)
			pstmt = conn.prepareStatement(sql);
						
			//5. 데이터 주입
			pstmt.setString(1, memberDto.getMemId());
			pstmt.setString(2, memberDto.getMemPw());
			pstmt.setString(3, memberDto.getMemMail());
			pstmt.setString(4, memberDto.getMemPhone());
			
			//6. 작업지시
			 result =	pstmt.executeUpdate();
			//ResultSet이 작업된 결과를 가져옴 rs.next() bool타입 하나씩 읽고 false면 끝
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}	finally {
			
			//8. 외부자원 해제
			try {
				
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				//역순으로 자원 해제
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
		return result;
		
	}

	@Override
	public MemberDto selectmemberByMemId(String id) {
		
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		List<MemberDto> memberDtos = new ArrayList<MemberDto>();
		
		try {
			
			//1. 드라이버로드 in 메모리
			Class.forName(DRIVER); //DRIVER 로드
			
			//2. 다리 건설 : Connection 생성 by 인증(Authentication)
			 conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//3. SQL 작성(작업지시서)
			String sql = "select"
					+ 	"*"
					+ "from "
					+ 	"tbl_member "
					+ "where "
					+ 	"memId = ?";			
			
			//4. 일꾼 선택 (생성)
			pstmt = conn.prepareStatement(sql);
						
			//5. 데이터 주입
			pstmt.setString(1,id);
		
			//6. 작업지시
			 rs = pstmt.executeQuery();
			
			 while (rs.next()) {
				 int memNo = rs.getInt("memNo");
				 String memId = rs.getString("memId");
				 String memPw = rs.getString("memPw");
				 String memMail = rs.getString("memMail");
				 String memPhone = rs.getString("memPhone");
				 String memRegDate = rs.getString("memRegDate");
				 String memModDate= rs.getString("memModDate");
				
				MemberDto dto = new MemberDto(memNo, memId, memPw, memMail, memPhone, memRegDate, memModDate);
				memberDtos.add(dto);
				
			}
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}	finally {
			
			//8. 외부자원 해제
			try {
				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				//역순으로 자원 해제
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
	
		return memberDtos.size() > 0 ? memberDtos.get(0) : null;
	}


	
}
