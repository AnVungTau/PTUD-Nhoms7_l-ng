package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HopDong;
import entity.LuongNhanVien;
import entity.NhanVien;
import entity.PhongBan;
import entity.SanPham;
import util.QuanLyMaLuongNhanVien;

public class LuongNhanVien_DAO {
	public int soNgayLam(String maNV, int thang, int nam) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select count(trangThaiDiLam) as soNgayLam from BangChamCongNhanVien where maNV = ? and MONTH(ngayChamCong) =? and YEAR(ngayChamCong) = ? and trangThaiDiLam = 1";
			sta = con.prepareStatement(sql);

			sta.setString(1, maNV);
			sta.setInt(2, thang);
			sta.setInt(3, nam);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return	n ;
	}
	public int soGioTangCa(String maNV, int thang, int nam) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select sum(soGioTangCa) as tongSoGioTangCa from BangChamCongNhanVien where MONTH(ngayChamCong) = ? and YEAR(ngayChamCong) = ? and maNV = ?";
			sta = con.prepareStatement(sql);

			sta.setString(3, maNV);
			sta.setInt(1, thang);
			sta.setInt(2, nam);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return	n ;
	}
	public boolean luuLuongNhanVien(LuongNhanVien lnv) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
            String sql = "INSERT INTO BangLuongNhanVien (maLuong, maNV, tienTroCap, tienLuong, ngayTinh, ghiChu) VALUES (?, ?, ?, ?, ?, ?)";
			sta = con.prepareStatement(sql);

			sta.setString(1, lnv.getMaLuongNV());
			sta.setString(2, lnv.getNv().getMaNV());
			sta.setInt(3, lnv.getTienTroCap());
			sta.setInt(4, lnv.getTienLuong());
			Date sqlDateNgayTinh = new Date(lnv.getNgayTinh().getTime());
			sta.setDate(5, sqlDateNgayTinh);
			sta.setString(6, lnv.getGhiChu());


			n = sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sta != null) {
					sta.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public int kiemTraDaTinhLuong(String maLuong) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select count(maLuong) from BangLuongNhanVien where maLuong = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maLuong);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}
	public ArrayList<LuongNhanVien> getAllBangLuongTheoThangNam(int thang, int nam) {
		ArrayList<LuongNhanVien> dsLNV = new ArrayList<LuongNhanVien>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String chuoi = "%T" + thang + "N" + nam +"%";
			String sql = "select * from BangLuongNhanVien where maLuong Like ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, chuoi);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maLuong = rs.getString("maLuong");
				String maNV = rs.getString("maNV");
				int tienTroCap = rs.getInt("tienTroCap");
				int tienLuong = rs.getInt("tienLuong");
				Date ngayTinh = rs.getDate("ngayTinh");
				String ghiChu = rs.getString("ghiChu");

				NhanVien nv = new NhanVien(maNV);
				LuongNhanVien lnv = new LuongNhanVien(maLuong, nv, tienTroCap,tienLuong, ngayTinh, ghiChu);

				dsLNV.add(lnv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLNV;
	}
	public ArrayList<LuongNhanVien> getAllBangLuong() {
		ArrayList<LuongNhanVien> dsLNV = new ArrayList<LuongNhanVien>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from BangLuongNhanVien";
			sta = con.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maLuong = rs.getString("maLuong");
				String maNV = rs.getString("maNV");
				int tienTroCap = rs.getInt("tienTroCap");
				int tienLuong = rs.getInt("tienLuong");
				Date ngayTinh = rs.getDate("ngayTinh");
				String ghiChu = rs.getString("ghiChu");

				NhanVien nv = new NhanVien(maNV);
				LuongNhanVien lnv = new LuongNhanVien(maLuong, nv, tienTroCap,tienLuong, ngayTinh, ghiChu);

				dsLNV.add(lnv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLNV;
	}
	public ArrayList<LuongNhanVien> getDanhSachTinhLuongTheoDieuKien(String tim){
	    PreparedStatement sta = null;
	    ArrayList<LuongNhanVien> dslnv = new ArrayList<LuongNhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from BangLuongNhanVien where ";
			sql += "maLuong LIKE ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, "%" + tim+ "%");

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maLuong = rs.getString("maLuong");
				String maNV = rs.getString("maNV");
				int tienTroCap = rs.getInt("tienTroCap");
				int tienLuong = rs.getInt("tienLuong");
				Date ngayTinh = rs.getDate("ngayTinh");
				String ghiChu = rs.getString("ghiChu");

				NhanVien nv = new NhanVien(maNV);
				LuongNhanVien lnv = new LuongNhanVien(maLuong, nv, tienTroCap,tienLuong, ngayTinh, ghiChu);

				dslnv.add(lnv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dslnv;
	}
}
