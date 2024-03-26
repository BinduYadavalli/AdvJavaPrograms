package com.sathya.productservlet;


import java.sql.Date;


public class Product {
	private int proId;
	private String proName;
	private Double proPrice;
	private String proBrand;
	private String promadeIn;
	private Date promfgDate;
	private Date proexpDate;
	private byte[] proImage;
	private byte[] proAudio;
	private byte[] proVideo;
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Double getProPrice() {
		return proPrice;
	}
	public void setProPrice(Double proPrice) {
		this.proPrice = proPrice;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public String getPromadeIn() {
		return promadeIn;
	}
	public void setPromadeIn(String promadeIn) {
		this.promadeIn = promadeIn;
	}
	public Date getPromfgDate() {
		return promfgDate;
	}
	public void setPromfgDate(Date promfgDate) {
		this.promfgDate = promfgDate;
	}
	public Date getProexpDate() {
		return proexpDate;
	}
	public void setProexpDate(Date proexpDate) {
		this.proexpDate = proexpDate;
	}
	public byte[] getProImage() {
		return proImage;
	}
	public void setProImage(byte[] proImage) {
		this.proImage = proImage;
	}
	public byte[] getProAudio() {
		return proAudio;
	}
	public void setProAudio(byte[] proAudio) {
		this.proAudio = proAudio;
	}
	public byte[] getProVideo() {
		return proVideo;
	}
	public void setProVideo(byte[] proVideo) {
		this.proVideo = proVideo;
	}
}