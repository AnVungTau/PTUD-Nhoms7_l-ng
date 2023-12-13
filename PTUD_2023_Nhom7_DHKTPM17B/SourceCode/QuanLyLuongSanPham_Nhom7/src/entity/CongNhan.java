package entity;

import java.util.Date;
import java.util.Objects;

/**
 * @author Nguyễn Thành An
 */
public class CongNhan {
	private String maCN;
	private String hoTen;
	private Date ngaySinh;
	private int gioiTinh;
	private String cmnd;
	private String soDienThoai;
	private String diaChi;
	private Date ngayVaoLam;
	private String ghiChu;
	private ToNhom to;
	private float phuCap;
	
	
	public CongNhan() {
		
	}


	public CongNhan(String maCN, String hoTen, Date ngaySinh, int gioiTinh, String cmnd, String soDienThoai,
			String diaChi, Date ngayVaoLam, String ghiChu, ToNhom to, float phuCap) {
		this.maCN = maCN;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.ngayVaoLam = ngayVaoLam;
		this.ghiChu = ghiChu;
		this.to = to;
		this.phuCap = phuCap;
	}


	


	public CongNhan(String maCN) {
		this.maCN = maCN;
	}


	public String getMaCN() {
		return maCN;
	}


	public void setMaCN(String maCN) {
		this.maCN = maCN;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public Date getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	public int getGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public String getCmnd() {
		return cmnd;
	}


	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}


	public String getSoDienThoai() {
		return soDienThoai;
	}


	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}


	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}


	public String getGhiChu() {
		return ghiChu;
	}


	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}


	public ToNhom getTo() {
		return to;
	}


	public void setTo(ToNhom to) {
		this.to = to;
	}


	public float getPhuCap() {
		return phuCap;
	}


	public void setPhuCap(float phuCap) {
		this.phuCap = phuCap;
	}


	@Override
	public int hashCode() {
		return Objects.hash(maCN);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongNhan other = (CongNhan) obj;
		return Objects.equals(maCN, other.maCN);
	}


	@Override
	public String toString() {
		return hoTen;
	}
	
	
	
}
