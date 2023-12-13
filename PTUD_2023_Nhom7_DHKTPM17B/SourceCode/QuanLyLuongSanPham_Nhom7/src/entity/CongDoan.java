package entity;

import java.util.Objects;

/**
 * @author Nguyễn Tuấn Hùng
 */
public class CongDoan{
	private String maCD;
	private String tenCD;
	private int soThuTu;
	private int soLuongCan;
	private int tinhTrang;
	private float gia;
	private String ghiChu;
	private SanPham sp;
	
	public String getMaCD() {
		return maCD;
	}
	public void setMaCD(String maCD) {
		this.maCD = maCD;
	}
	public String getTenCD() {
		return tenCD;
	}
	public void setTenCD(String tenCD) {
		this.tenCD = tenCD;
	}
	public int getsoThuTu() {
		return soThuTu;
	}
	public void setsoThuTu(int soThuTu) {
		this.soThuTu = soThuTu;
	}
	public int getsoLuongCan() {
		return soLuongCan;
	}
	public void setsoLuongCan(int soLuongCan) {
		this.soLuongCan = soLuongCan;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public SanPham getSp() {
		return sp;
	}
	public void setSp(SanPham sp) {
		this.sp = sp;
	}
	
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	

	@Override
	public String toString() {
		return tenCD;
	}
	public CongDoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CongDoan(String maCD, String tenCD, int soThuTu, int soLuongCan,int tinhTrang, float gia, String ghiChu, SanPham sp) {
		super();
		this.maCD = maCD;
		this.tenCD = tenCD;
		this.soThuTu = soThuTu;
		this.soLuongCan = soLuongCan;
		this.tinhTrang = tinhTrang;
		this.gia = gia;
		this.ghiChu = ghiChu;
		this.sp = sp;
	}
	public CongDoan(String maCD) {
		this.maCD = maCD;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maCD);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongDoan other = (CongDoan) obj;
		return Objects.equals(maCD, other.maCD);
	}
	
//	public int demSoLuongDaLamXong() {
//		
//	}
	
}