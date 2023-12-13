package entity;

import java.util.Date;
import java.util.Objects;

/**
 * @author Nguyễn Thanh An
 */

public class BangChamCongNhanVien {
	private NhanVien nhanVien;
	private Date ngayCham;
	private int trangThaiDiLam;
	private int soGIoTangCa;
	private String ghiChu;
	public BangChamCongNhanVien(NhanVien nhanVien, Date ngayCham, int trangThaiDiLam, int soGIoTangCa, String ghiChu) {
		super();
		this.nhanVien = nhanVien;
		this.ngayCham = ngayCham;
		this.trangThaiDiLam = trangThaiDiLam;
		this.soGIoTangCa = soGIoTangCa;
		this.ghiChu = ghiChu;
	}
	public BangChamCongNhanVien() {
		
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public Date getNgayCham() {
		return ngayCham;
	}
	public void setNgayCham(Date ngayCham) {
		this.ngayCham = ngayCham;
	}
	public int getTrangThaiDiLam() {
		return trangThaiDiLam;
	}
	public void setTrangThaiDiLam(int trangThaiDiLam) {
		this.trangThaiDiLam = trangThaiDiLam;
	}
	public int getSoGIoTangCa() {
		return soGIoTangCa;
	}
	public void setSoGIoTangCa(int soGIoTangCa) {
		this.soGIoTangCa = soGIoTangCa;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ngayCham, nhanVien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangChamCongNhanVien other = (BangChamCongNhanVien) obj;
		return Objects.equals(ngayCham, other.ngayCham) && Objects.equals(nhanVien, other.nhanVien);
	}
	@Override
	public String toString() {
		return nhanVien.getMaNV();
	}
	
	
}