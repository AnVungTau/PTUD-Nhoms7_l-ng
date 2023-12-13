package entity;

import java.util.Objects;
 
/**
 * @author Trần Vũ Minh Nhật
 */
public class SanPham {
    private String maSP;
    private String tenSP;
    private int soLuong;
    private String donViTinh; 
    private String ghiChu;
    private HopDong hopDong;

    
    public SanPham(String maSP, String tenSP) {
    	this.maSP = maSP;
    	this.tenSP = tenSP;
    }
    
    public SanPham() {
        // Default constructor
    }

    public SanPham(String maSP, String tenSP, int soLuong, String donViTinh, String ghiChu, HopDong hopDong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donViTinh = donViTinh; 
        this.ghiChu = ghiChu;
        this.hopDong = hopDong;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
 
 
    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public HopDong getHopDong() {
        return hopDong;
    }

    public void setHopDong(HopDong hopDong) {
        this.hopDong = hopDong;
    }
    
	@Override
	public int hashCode() {
		return Objects.hash(maSP);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSP, other.maSP);
	}

	@Override
	public String toString() {
		return tenSP;
	}


    
} 
