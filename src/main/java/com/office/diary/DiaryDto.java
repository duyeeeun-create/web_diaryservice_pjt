package com.office.diary;

public class DiaryDto {

	
	private int	diaryNo;
	private String diaryWord;
	private String memId;
	private String diaryRegDate;
	private String diaryModDate;
	
	
	public DiaryDto() {}


	public DiaryDto(String diaryWord, String memId) {
		super();
		this.diaryWord = diaryWord;
		this.memId = memId;
	}


	public int getDiaryNo() {
		return diaryNo;
	}


	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}


	public String getDiaryWord() {
		return diaryWord;
	}


	public void setDiaryWord(String diaryWord) {
		this.diaryWord = diaryWord;
	}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	public String getDiaryRegDate() {
		return diaryRegDate;
	}


	public void setDiaryRegDate(String diaryRegDate) {
		this.diaryRegDate = diaryRegDate;
	}


	public String getDiaryModDate() {
		return diaryModDate;
	}


	public void setDiaryModDate(String diaryModDate) {
		this.diaryModDate = diaryModDate;
	}
	
	
}
