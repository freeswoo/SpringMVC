package com.biz.app;

public class ScoreVO {
	
	private int kor;
	private int eng;
	private int mat;
	private int sc;
	private int mu;
	
	private int total;
	private int avg;
	
	
	public ScoreVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScoreVO(int kor, int eng, int mat, int sc, int mu, int total, int avg) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sc = sc;
		this.mu = mu;
		this.total = total;
		this.avg = avg;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getSc() {
		return sc;
	}
	public void setSc(int sc) {
		this.sc = sc;
	}
	public int getMu() {
		return mu;
	}
	public void setMu(int mu) {
		this.mu = mu;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	@Override
	public String toString() {
		return "ScoreVO [kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", sc=" + sc + ", mu=" + mu + ", total="
				+ total + ", avg=" + avg + "]";
	}

	
}
