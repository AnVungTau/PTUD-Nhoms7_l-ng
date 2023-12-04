package entity;

import java.util.Objects;
/**
 * @author Nguyễn Hồng Quân
 */
public class TaiKhoan {
	private String maTK;
	private String tenTK;
	private String matKhau;
	private int giaTri;
	private NhanVien nhanVien;
	public TaiKhoan() {
		
	}
	
	public TaiKhoan(String maTK) {
		this.maTK = maTK;
	}

	public TaiKhoan(String maTK, String tenTK, String matKhau, int giaTri, NhanVien nhanVien) {
		super();
		this.maTK = maTK;
		this.tenTK = tenTK;
		this.matKhau = matKhau;
		this.giaTri = giaTri;
		this.nhanVien = nhanVien;
	}

	public String getMaTK() {
		return maTK;
	}

	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(int giaTri) {
		this.giaTri = giaTri;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTK);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return maTK == other.maTK;
	}

	@Override
	public String toString() {
		return tenTK + giaTri + maTK + matKhau;
	}

	
	
	
}
