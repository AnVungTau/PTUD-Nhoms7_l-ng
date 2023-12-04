package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhongBan;
import entity.TaiKhoan;
/**
 * @author Nguyễn Hồng Quân
 */
public class TaiKhoan_DAO {
	public ArrayList<TaiKhoan> getAllTaiKhoan() {
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien nv join TaiKhoan tk on nv.maNV = tk.maNV join PhongBan pb on pb.maPB = nv.maPB";
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

				NhanVien nv = new NhanVien(maNV, hoTen, ngaySinh, gioiTinh, cmnd, soDienThoai, email, diaChi, trinhDo,
						chucVu, ngayVaoLam, trangThaiTaiKhoan, ghiChu, phongBan, heSoLuong, phuCap);
				
				 String maTK = rs.getString("matk");
				 String tenTK = rs.getString("tentk");
				 String matKhau = rs.getString("matkhau");
				 int giaTri = rs.getInt("giatri");
				 
				 TaiKhoan tk = new TaiKhoan(maTK, tenTK, matKhau, giaTri, nv);
				 dsTK.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTK;
	}
	
	public TaiKhoan getTaiKhoanTheoMa(String maTK) {
		TaiKhoan tk = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien nv join TaiKhoan tk on nv.maNV = tk.maNV join PhongBan pb on pb.maPB = nv.maPB where maTK = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maTK);

			ResultSet rs = sta.executeQuery();
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

				NhanVien nv = new NhanVien(maNV, hoTen, ngaySinh, gioiTinh, cmnd, soDienThoai, email, diaChi, trinhDo,
						chucVu, ngayVaoLam, trangThaiTaiKhoan, ghiChu, phongBan, heSoLuong, phuCap);
				
				 String tenTK = rs.getString("tentk");
				 String matKhau = rs.getString("matkhau");
				 int giaTri = rs.getInt("giatri");
				 
				 tk = new TaiKhoan(maTK, tenTK, matKhau, giaTri, nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}
	
	public boolean themTK(TaiKhoan tk) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into TaiKhoan values(?,?,?,?,?)";
			sta = con.prepareStatement(sql);

			sta.setString(1, tk.getMaTK());
			sta.setString(2, tk.getTenTK());
			sta.setString(3, tk.getMatKhau());
			sta.setInt(4, tk.getGiaTri());
			sta.setString(5, tk.getNhanVien().getMaNV());
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
	
	public boolean kiemTraTonTaiCuaMaTaiKhoan(String maTK) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from TaiKhoan where maTK = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, maTK);
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
	
	public boolean kiemTraDangNhap(String maTK, String matKhau) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from TaiKhoan where maTK = ? and matKhau = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, maTK);
			sta.setString(2, matKhau);
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
	
	public boolean xoaTK(TaiKhoan tk) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from TaiKhoan where maTK = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, tk.getMaTK());
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
	
	public boolean capNhatTK(TaiKhoan tk) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update TaiKhoan set matKhau = ?, giatri = ? where maTK = ?";
			sta = con.prepareStatement(sql);
			
			sta.setString(1, tk.getMatKhau());
			sta.setInt(2, tk.getGiaTri());
			sta.setString(3, tk.getMaTK());
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
	
	public boolean datLaiMatKhau(String email, String matKhauMoi) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "UPDATE TaiKhoan SET matKhau = ? FROM TaiKhoan tk JOIN NhanVien nv ON tk.maNV = nv.maNV WHERE nv.email = ?";
			sta = con.prepareStatement(sql);
			
			sta.setString(1, matKhauMoi);
			sta.setString(2, email);
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
