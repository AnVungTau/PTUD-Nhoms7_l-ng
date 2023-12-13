package entity;

import java.util.Date;
import java.util.Objects;

import dao.BangPhanCong_DAO;
/**
 * @author Nguyễn Hồng Quân
 */
public class BangPhanCong {
	private CongNhan congNhan;
	private CongDoan congDoan;
	private int soLuongPC;
	private Date ngayPhanCong;
	private int trangThai;
	public BangPhanCong(CongNhan congNhan, CongDoan congDoan, int soLuongPC, Date ngayPhanCong, int trangThai) {
		super();
		this.congNhan = congNhan;
		this.congDoan = congDoan;
		this.soLuongPC = soLuongPC;
		this.ngayPhanCong = ngayPhanCong;
		this.trangThai = trangThai;
	}
	public BangPhanCong() {
		
	}
	
	public BangPhanCong(CongNhan congNhan, CongDoan congDoan) {
		this.congNhan = congNhan;
		this.congDoan = congDoan;
	}
	
	public BangPhanCong(CongNhan congNhan, CongDoan congDoan, int soLuongPC) {
		this.congNhan = congNhan;
		this.congDoan = congDoan;
		this.soLuongPC = soLuongPC;
	}
	
	public CongNhan getCongNhan() {
		return congNhan;
	}
	public void setCongNhan(CongNhan congNhan) {
		this.congNhan = congNhan;
	}
	public CongDoan getCongDoan() {
		return congDoan;
	}
	public void setCongDoan(CongDoan congDoan) {
		this.congDoan = congDoan;
	}
	public int getSoLuongPC() {
		return soLuongPC;
	}
	public void setSoLuongPC(int soLuongPC) {
		this.soLuongPC = soLuongPC;
	}
	public Date getNgayPhanCong() {
		return ngayPhanCong;
	}
	public void setNgayPhanCong(Date ngayPhanCong) {
		this.ngayPhanCong = ngayPhanCong;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(congDoan, congNhan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangPhanCong other = (BangPhanCong) obj;
		return Objects.equals(congDoan, other.congDoan) && Objects.equals(congNhan, other.congNhan);
	}
	@Override
	public String toString() {
		return congNhan.getMaCN();
	}
	
	public int demSoLuongLamDuoc() {
		BangPhanCong_DAO bangPhanCong_dao = new BangPhanCong_DAO();
		return bangPhanCong_dao.demSoLuongLamDuoc(congNhan.getMaCN(), congDoan.getMaCD());
	}
	
	
}
