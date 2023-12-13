package entity;

import java.util.Date;
import java.util.Objects;
/**
 * @author Nguyễn Hồng Quân
 */
public class BangChamCongCongNhan {
	private BangPhanCong phanCong;
	private Date ngayCham;
	private int soLuongLam;
	
	public BangChamCongCongNhan(BangPhanCong phanCong, Date ngayCham, int soLuongLam) {
		this.phanCong = phanCong;
		this.ngayCham = ngayCham;
		this.soLuongLam = soLuongLam;
	}
	
	public BangChamCongCongNhan() {
		
	}
	
	public BangChamCongCongNhan(BangPhanCong phanCong, Date ngayCham) {
		this.phanCong = phanCong;
		this.ngayCham = ngayCham;
	}

	public BangPhanCong getPhanCong() {
		return phanCong;
	}

	public void setPhanCong(BangPhanCong phanCong) {
		this.phanCong = phanCong;
	}

	public Date getNgayCham() {
		return ngayCham;
	}

	public void setNgayCham(Date ngayCham) {
		this.ngayCham = ngayCham;
	}

	public int getSoLuongLam() {
		return soLuongLam;
	}

	public void setSoLuongLam(int soLuongLam) {
		this.soLuongLam = soLuongLam;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ngayCham, phanCong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangChamCongCongNhan other = (BangChamCongCongNhan) obj;
		return Objects.equals(ngayCham, other.ngayCham) && Objects.equals(phanCong, other.phanCong);
	}

	@Override
	public String toString() {
		return phanCong.getCongNhan().getMaCN();
	}
	
	
}
