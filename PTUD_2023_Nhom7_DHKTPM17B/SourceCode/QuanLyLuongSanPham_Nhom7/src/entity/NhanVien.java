package entity;


import java.util.Date;
import java.util.Objects;
/**
 * @author Nguyễn Hồng Quân
 */
public class NhanVien {
	private String maNV;
	private String hoTen;
	private Date ngaySinh;
	private int gioiTinh;
	private String cmnd;
	private String soDienThoai;
	private String email;
	private String diaChi;
	private String trinhDo;
	private String chucVu;
	private Date ngayVaoLam;
	private int trangThaiTaiKhoan;
	private String ghiChu;
	private PhongBan phongBan;
	private float heSoLuong;
	private float phuCap;
	
	public NhanVien() {
		
	}
	
	public NhanVien(String maNV) {
		this.maNV = maNV;
	}

	public NhanVien(String maNV, String hoTen, Date ngaySinh, int gioiTinh, String cmnd, String soDienThoai,
			String email, String diaChi, String trinhDo, String chucVu, Date ngayVaoLam, int trangThaiTaiKhoan,
			String ghiChu, PhongBan phongBan, float heSoLuong, float phuCap) {
		
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.trinhDo = trinhDo;
		this.chucVu = chucVu;
		this.ngayVaoLam = ngayVaoLam;
		this.trangThaiTaiKhoan = trangThaiTaiKhoan;
		this.ghiChu = ghiChu;
		this.phongBan = phongBan;
		this.heSoLuong = heSoLuong;
		this.phuCap = phuCap;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public int getTrangThaiTaiKhoan() {
		return trangThaiTaiKhoan;
	}

	public void setTrangThaiTaiKhoan(int trangThaiTaiKhoan) {
		this.trangThaiTaiKhoan = trangThaiTaiKhoan;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public float getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public float getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(float phuCap) {
		this.phuCap = phuCap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}

	@Override
	public String toString() {
		return hoTen;
	}


	
	
	
	
}
