package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import connectDB.ConnectDB;
import entity.ToNhom;
import entity.CongNhan;

/**
 * @author Nguyễn Thanh An
 */
public class CongNhan_DAO {
	public ArrayList<CongNhan> getAllCongNhans() {
		ArrayList<CongNhan> dsCN = new ArrayList<CongNhan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from CongNhan cn join ToNhom tn on cn.maTo = tn.maTo";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String maCN = rs.getString("macn");
				String hoTen = rs.getString("hoten");
				Date ngaySinh = rs.getDate("ngaysinh");
				int gioiTinh = rs.getInt("gioiTinh");
				String cmnd = rs.getString("cmnd");
				String soDienThoai = rs.getString("sodt");
				String diaChi = rs.getString("diachi");
				Date ngayVaoLam = rs.getDate("ngayvaolam");
				String ghiChu = rs.getString("ghichu");
				int maTo = rs.getInt("mato");
				String tenTo = rs.getString("tento");
				ToNhom to = new ToNhom(maTo, tenTo);
				float phuCap = rs.getFloat("phucap");
				
				CongNhan cn = new CongNhan(maCN, hoTen, ngaySinh, gioiTinh, cmnd, soDienThoai, diaChi, ngayVaoLam, ghiChu, to, phuCap);

				dsCN.add(cn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCN;
	}
	
	public ArrayList<CongNhan> getAllCongNhanTheoDieuKien(String luaChon, String timKiem) {
		ArrayList<CongNhan> dsCN = new ArrayList<CongNhan>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from CongNhan cn join ToNhom tn on cn.maTo = tn.maTo where ";
			
			if(luaChon.equalsIgnoreCase("Mã công nhân")) {
				sql += "cn.maCN LIKE ?";
			}
			if(luaChon.equalsIgnoreCase("Tên công nhân")) {
				sql += "cn.hoTen LIKE ?";
			}
			if(luaChon.equalsIgnoreCase("Tổ")) {
				sql += "cn.maTo = ?";
			}
			
			if(luaChon.equalsIgnoreCase("Tổ")) {
				sta = con.prepareStatement(sql);
				sta.setString(1, timKiem);
			}else {
				sta = con.prepareStatement(sql);
				sta.setString(1, "%" + timKiem + "%");
			}

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maCN = rs.getString("macn");
				String hoTen = rs.getString("hoten");
				Date ngaySinh = rs.getDate("ngaysinh");
				int gioiTinh = rs.getInt("gioiTinh");
				String cmnd = rs.getString("cmnd");
				String soDienThoai = rs.getString("sodt");
				String diaChi = rs.getString("diachi");
				Date ngayVaoLam = rs.getDate("ngayvaolam");
				String ghiChu = rs.getString("ghichu");
				int maTo = rs.getInt("mato");
				String tenTo = rs.getString("tento");
				ToNhom to = new ToNhom(maTo, tenTo);
				float phuCap = rs.getFloat("phucap");
				
				CongNhan cn = new CongNhan(maCN, hoTen, ngaySinh, gioiTinh, cmnd, soDienThoai, diaChi, ngayVaoLam, ghiChu, to, phuCap);

				dsCN.add(cn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCN;
	}
	

	public CongNhan timMaCongNhan(CongNhan nhanVien) {
		CongNhan cn = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from CongNhan cn join ToNhom tn on cn.maTo = tn.maTo where macn = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, nhanVien.getMaCN());

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maCN = rs.getString("macn");
				String hoTen = rs.getString("hoten");
				Date ngaySinh = rs.getDate("ngaysinh");
				int gioiTinh = rs.getInt("gioiTinh");
				String cmnd = rs.getString("cmnd");
				String soDienThoai = rs.getString("sodt");
				String diaChi = rs.getString("diachi");
				Date ngayVaoLam = rs.getDate("ngayvaolam");
				String ghiChu = rs.getString("ghichu");
				int maTo = rs.getInt("mato");
				String tenTo = rs.getString("tento");
				ToNhom to = new ToNhom(maTo, tenTo);
				float phuCap = rs.getFloat("phucap");

				cn = new CongNhan(maCN, hoTen, ngaySinh, gioiTinh, cmnd, soDienThoai, diaChi, ngayVaoLam, ghiChu, to, phuCap);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	
	public boolean kiemTraSuTonTaiDuyNhatCuaCMND(String cmnd) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from CongNhan where cmnd = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, cmnd);

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
		return n > 0;
	}

	public boolean demSoLuongCMND(String cmnd) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select (count(*) - 1) from CongNhan where cmnd = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, cmnd);

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
		return n > 0;
	}

	public boolean kiemTraSuTonTaiDuyNhatCuaSoDienThoai(String soDT) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from CongNhan where soDT = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, soDT);
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
		return n > 0;
	}

	public boolean demSoLuongSoDienThoai(String soDT) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select (count(*) - 1) from CongNhan where soDT = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, soDT);
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
		return n > 0;
	}

	
	
	

	public boolean themCN(CongNhan cn) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into CongNhan values(?,?,?,?,?,?,?,?,?,?,?)";
			sta = con.prepareStatement(sql);

			sta.setString(1, cn.getMaCN());
			sta.setString(2, cn.getHoTen());
			Date sqlDateNgaySinh = new Date(cn.getNgaySinh().getTime());
			sta.setDate(3, sqlDateNgaySinh);
			sta.setInt(4, cn.getGioiTinh());
			sta.setString(5, cn.getCmnd());
			sta.setString(6, cn.getSoDienThoai());
			sta.setString(7, cn.getDiaChi());
			Date sqlDateVaoLam = new Date(cn.getNgayVaoLam().getTime());
			sta.setDate(8, sqlDateVaoLam);
			sta.setString(9, cn.getGhiChu());
			sta.setInt(10, cn.getTo().getMaTo());
			sta.setFloat(11, cn.getPhuCap());
			n = sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	
	

	public boolean suaCN(CongNhan cn) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update CongNhan set hoTen = ?, ngaySinh = ?, gioiTinh = ?, cmnd = ?, soDT = ?, diaChi = ?, phuCap = ?, ngayVaoLam = ?, maTo = ?, ghiChu = ? where maCN = ? ";
			sta = con.prepareStatement(sql);

			sta.setString(1, cn.getHoTen());
			Date sqlDateNgaySinh = new Date(cn.getNgaySinh().getTime());
			sta.setDate(2, sqlDateNgaySinh);
			sta.setInt(3, cn.getGioiTinh());
			sta.setString(4, cn.getCmnd());
			sta.setString(5, cn.getSoDienThoai());
			sta.setString(6, cn.getDiaChi());
			sta.setFloat(7, cn.getPhuCap());
			Date sqlDateVaoLam = new Date(cn.getNgayVaoLam().getTime());
			sta.setDate(8, sqlDateVaoLam);
			sta.setInt(9, cn.getTo().getMaTo());
			sta.setString(10, cn.getGhiChu());
			sta.setString(11, cn.getMaCN());

			n = sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public ArrayList<String> getDanhSachMaCongNhan() {
		ArrayList<String> dsMaCN = new ArrayList<String>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select maCN from CongNhan";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				dsMaCN.add(rs.getString("maCN"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsMaCN;
	}
	
	public int demSoLuongCongNhan(int thangbd, int nambd, int thangkt, int namkt) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "DECLARE @ThangBatDau INT = ?;  " + "DECLARE @NamBatDau INT = ?;  " + " "
					+ "DECLARE @ThangKetThuc INT = ?;  " + "DECLARE @NamKetThuc INT = ?;  " + " "
					+ "DECLARE @NgayBatDau DATETIME = DATEFROMPARTS(@NamBatDau, @ThangBatDau, 1); "
					+ "DECLARE @NgayKetThuc DATETIME = EOMONTH(DATEFROMPARTS(@NamKetThuc, @ThangKetThuc, 1)); " + " "
					+ "SELECT COUNT(*) AS SoLuongCongNhan "
					+ "FROM CongNhan "
					+ "WHERE ngayVaoLam >= @NgayBatDau AND ngayVaoLam <= @NgayKetThuc;";
			sta = con.prepareStatement(sql);

			sta.setInt(1, thangbd);
			sta.setInt(2, nambd);
			sta.setInt(3, thangkt);
			sta.setInt(4, namkt);
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

}
