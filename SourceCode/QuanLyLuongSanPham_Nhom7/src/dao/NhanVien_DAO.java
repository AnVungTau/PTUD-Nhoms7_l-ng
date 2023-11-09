package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhongBan;

/**
 * @author Nguyễn Hồng Quân
 */
public class NhanVien_DAO {
	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from nhanvien";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString("manv");
				String hoTen = rs.getString("hoten");
				Date ngaySinh = rs.getDate("ngaysinh");
				int gioiTinh = rs.getInt("gioiTinh");
				String cmnd = rs.getString("cmnd");
				String soDienThoai = rs.getString("sodt");
				String email = rs.getString("email");
				String diaChi = rs.getString("diachi");
				String trinhDo = rs.getString("trinhdo");
				String chucVu = rs.getString("chucvu");
				Date ngayVaoLam = rs.getDate("ngayvaolam");
				int trangThaiTaiKhoan = rs.getInt("trangthaitaikhoan");
				String ghiChu = rs.getString("ghichu");
				String maPhong = rs.getString("mapb");
				String tenPhong = rs.getString("tenpb");
				String toaNha = rs.getString("toanha");
				int tang = rs.getInt("tang");
				float dienTich = rs.getFloat("dienTich");
				String ghiChuPB = rs.getString("ghichu");
				PhongBan phongBan = new PhongBan(maPhong, tenPhong, toaNha, tang, dienTich, ghiChuPB);
				float heSoLuong = rs.getFloat("hesoluong");
				float phuCap = rs.getFloat("phucap");

				NhanVien nv = new NhanVien(maNV, hoTen, null, gioiTinh, cmnd, soDienThoai, email, diaChi, trinhDo,
						chucVu, null, trangThaiTaiKhoan, ghiChuPB, phongBan, heSoLuong, phuCap);

				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}

	public boolean KiemTraSuTonTaiCuaCMND(String cmnd) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from nhanvien where cmnd = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, cmnd);
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

	public boolean KiemTraSuTonTaiCuaSoDienThoai(String soDT) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from nhanvien where soDT = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, soDT);
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

	public boolean KiemTraSuTonTaiCuaEmail(String email) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from nhanvien where email = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, email);
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

	public boolean themNV(NhanVien nv) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into NhanVien values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			sta = con.prepareStatement(sql);

			sta.setString(1, nv.getMaNV());
			sta.setString(2, nv.getHoTen());
			Date sqlDateNgaySinh = new Date(nv.getNgaySinh().getTime());
			sta.setDate(3, sqlDateNgaySinh);
			sta.setInt(4, nv.getGioiTinh());
			sta.setString(5, nv.getCmnd());
			sta.setString(6, nv.getSoDienThoai());
			sta.setString(7, nv.getEmail());
			sta.setString(8, nv.getDiaChi());
			sta.setString(9, nv.getTrinhDo());
			sta.setString(10, nv.getChucVu());
			Date sqlDateVaoLam = new Date(nv.getNgayVaoLam().getTime());
			sta.setDate(11, sqlDateVaoLam);
			sta.setInt(12, nv.getTrangThaiTaiKhoan());
			sta.setString(13, nv.getGhiChu());
			sta.setString(14, nv.getPhongBan().getMaPhong());
			sta.setFloat(15, nv.getHeSoLuong());
			sta.setFloat(16, nv.getPhuCap());
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

}
