package entity;

import java.util.Date;
import java.util.Objects;

/**
 * @author Trần Vũ Minh Nhật
 */

public class HopDong {
    private String maHD;
    private String tenHD;
    private String tenKH;
    private double soTienCoc;
    private double tongTienHD;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String ghiChu;

    // Constructors
    public HopDong() {
        // Default constructor
    }

    public HopDong(String maHD, String tenHD, String tenKH, double soTienCoc, double tongTienHD,
                   Date ngayBatDau, Date ngayKetThuc, String ghiChu) {
        this.maHD = maHD;
        this.tenHD = tenHD;
        this.tenKH = tenKH;
        this.soTienCoc = soTienCoc;
        this.tongTienHD = tongTienHD;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.ghiChu = ghiChu;
    }

    // Getters and Setters
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenHD() {
        return tenHD;
    }

    public void setTenHD(String tenHD) {
        this.tenHD = tenHD;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public double getSoTienCoc() {
        return soTienCoc;
    }

    public void setSoTienCoc(double soTienCoc) {
        this.soTienCoc = soTienCoc;
    }

    public double getTongTienHD() {
        return tongTienHD;
    }

    public void setTongTienHD(double tongTienHD) {
        this.tongTienHD = tongTienHD;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
	 
	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HopDong other = (HopDong) obj;
		return Objects.equals(maHD, other.maHD);
	}

	@Override
	public String toString() {
		return tenHD;
	}

	public HopDong(String maHD, String tenHD) {
		super();
		this.maHD = maHD;
		this.tenHD = tenHD;
	}
    
}
