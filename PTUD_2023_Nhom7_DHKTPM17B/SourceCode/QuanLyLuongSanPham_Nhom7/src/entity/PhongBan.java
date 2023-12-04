package entity;

import java.util.Objects;
/**
 * @author Nguyễn Tuấn Hùng
 */
public class PhongBan {
	private String maPhong;
	private String tenPhong;
	private String toaNha;
	private int tang;
	private float dienTich;
	private String ghiChu;
	
	public PhongBan() {
		
	}
	
	public PhongBan(String maPhong) {
		this.maPhong = maPhong;
	}
	public PhongBan(String maPhong, String tenPhong, String toaNha, int tang, float dienTich, String ghiChu) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.toaNha = toaNha;
		this.tang = tang;
		this.dienTich = dienTich;
		this.ghiChu = ghiChu;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getToaNha() {
		return toaNha;
	}

	public void setToaNha(String toaNha) {
		this.toaNha = toaNha;
	}

	public int getTang() {
		return tang;
	}

	public void setTang(int tang) {
		this.tang = tang;
	}

	public float getDienTich() {
		return dienTich;
	}

	public void setDienTich(float dienTich) {
		this.dienTich = dienTich;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongBan other = (PhongBan) obj;
		return Objects.equals(maPhong, other.maPhong);
	}

	@Override
	public String toString() {
		return tenPhong;
	}
	
	
	
}
