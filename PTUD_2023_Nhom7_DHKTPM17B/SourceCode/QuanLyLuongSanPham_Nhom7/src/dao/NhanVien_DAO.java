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
			String sql = "Select * from NhanVien nv join PhongBan pb on nv.maPB = pb.maPB";
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

				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	
	public ArrayList<NhanVien> getAllNhanVienTheoDieuKien(String luaChon, String timKiem) {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien nv join PhongBan pb on nv.maPB = pb.maPB where ";
			
			if(luaChon.equalsIgnoreCase("Mã nhân viên")) {
				sql += "nv.maNV LIKE ?";
			}
			if(luaChon.equalsIgnoreCase("Tên nhân viên")) {
				sql += "nv.hoTen LIKE ?";
			}
			if(luaChon.equalsIgnoreCase("Tên phòng ban")) {
				sql += "pb.tenpb LIKE ?";
			}
			sta = con.prepareStatement(sql);
			sta.setString(1, "%" + timKiem + "%");

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

				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	
	public ArrayList<NhanVien> getDanhSachNhanVienTheoTrangThaiTaiKhoan(int flag) {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien nv join PhongBan pb on nv.maPB = pb.maPB where trangThaiTaiKhoan = ?";
			sta = con.prepareStatement(sql);
			sta.setInt(1, flag);

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

				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	
	public NhanVien TimMaNhanVien(NhanVien nhanVien) {
		NhanVien nv = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien nv join PhongBan pb on nv.maPB = pb.maPB where manv = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, nhanVien.getMaNV());

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

				nv = new NhanVien(maNV, hoTen, ngaySinh, gioiTinh, cmnd, soDienThoai, email, diaChi, trinhDo, chucVu,
						ngayVaoLam, trangThaiTaiKhoan, ghiChu, phongBan, heSoLuong, phuCap);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}
	
	public ArrayList<NhanVien> TimMaNhanVienTheoTrangThaiTaiKhoan(String ma, int flag) {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien nv join PhongBan pb on nv.maPB = pb.maPB where manv = ? and trangThaiTaiKhoan = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, ma);
			sta.setInt(2, flag);

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

				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	
	public boolean kiemTraSuTonTaiDuyNhatCuaCMND(String cmnd) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from nhanvien where cmnd = ?";
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
			String sql = "select (count(*) - 1) from nhanvien where cmnd = ?";
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
			String sql = "select count(*) from nhanvien where soDT = ?";
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
			String sql = "select (count(*) - 1) from nhanvien where soDT = ?";
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

	public boolean kiemTraSuTonTaiDuyNhatCuaEmail(String email) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from nhanvien where email = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, email);
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
	
	public boolean demSoLuongEmail(String email) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select (count(*) - 1) from nhanvien where email = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, email);
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
	
	public boolean capNhatTrangThaiTaiKhoan(String maNV, int flag) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update NhanVien set trangThaiTaiKhoan = ? where maNV = ? ";
			sta = con.prepareStatement(sql);
			
			sta.setInt(1, flag);
			sta.setString(2, maNV);

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

	public boolean suaNV(NhanVien nv) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update NhanVien set hoTen = ?, ngaySinh = ?, gioiTinh = ?, cmnd = ?, soDT = ?, email = ?, diaChi = ?, phuCap = ?, trinhDo = ?, heSoLuong = ?, ngayVaoLam = ?, maPB = ?, chucVu = ?, ghiChu = ? where maNV = ? ";
			sta = con.prepareStatement(sql);

			sta.setString(1, nv.getHoTen());
			Date sqlDateNgaySinh = new Date(nv.getNgaySinh().getTime());
			sta.setDate(2, sqlDateNgaySinh);
			sta.setInt(3, nv.getGioiTinh());
			sta.setString(4, nv.getCmnd());
			sta.setString(5, nv.getSoDienThoai());
			sta.setString(6, nv.getEmail());
			sta.setString(7, nv.getDiaChi());
			sta.setFloat(8, nv.getPhuCap());
			sta.setString(9, nv.getTrinhDo());
			sta.setFloat(10, nv.getHeSoLuong());
			Date sqlDateVaoLam = new Date(nv.getNgayVaoLam().getTime());
			sta.setDate(11, sqlDateVaoLam);
			sta.setString(12, nv.getPhongBan().getMaPhong());
			sta.setString(13, nv.getChucVu());
			sta.setString(14, nv.getGhiChu());
			sta.setString(15, nv.getMaNV());

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

	public ArrayList<String> getDanhSachMaNhanVien() {
		ArrayList<String> dsMaNV = new ArrayList<String>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select manv from nhanvien";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				dsMaNV.add(rs.getString("manv"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsMaNV;
	}
	
	//Nguyễn Tuấn Hùng
		public ArrayList<NhanVien> getDanhSachNhanVienTheoThangNamChamCong(int thang, int nam){
		    PreparedStatement sta = null;
		    ArrayList<NhanVien> dsCCNV = new ArrayList<NhanVien>();
		    try {
		        ConnectDB.getInstance();
		        Connection con = ConnectDB.getConnection();
		        String sql = "SELECT nv.maNV, nv.hoTen, nv.phuCap, nv.heSoLuong " +
	                    "FROM NhanVien nv " +
	                    "JOIN BangChamCongNhanVien bccnv ON nv.maNV = bccnv.maNV " +
	                    "WHERE MONTH(bccnv.ngayChamCong) = ? AND YEAR(bccnv.ngayChamCong) = ? " +
	                    "GROUP BY nv.maNV, nv.hoTen, nv.phuCap, nv.heSoLuong";
		        sta = con.prepareStatement(sql);
		        sta.setInt(1, thang);
		        sta.setInt(2, nam);
		        ResultSet rs = sta.executeQuery();
		        while(rs.next()) {
		        	NhanVien nv = new NhanVien();
		            nv.setMaNV(rs.getString("maNV"));
		            nv.setHoTen(rs.getString("hoTen"));
		            nv.setPhuCap(rs.getInt("phuCap"));
		            nv.setHeSoLuong(rs.getFloat("heSoLuong"));
		            dsCCNV.add(nv);
		            
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return dsCCNV;
		}
		public ArrayList<NhanVien> getDanhSachNhanVienTheoThangNamChamCongVaMa(int thang, int nam, String ma){
		    PreparedStatement sta = null;
		    ArrayList<NhanVien> dsCCNV = new ArrayList<NhanVien>();
		    try {
		        ConnectDB.getInstance();
		        Connection con = ConnectDB.getConnection();
		        String sql = "SELECT nv.maNV, nv.hoTen, nv.phuCap, nv.heSoLuong " +
	                    "FROM NhanVien nv " +
	                    "JOIN BangChamCongNhanVien bccnv ON nv.maNV = bccnv.maNV " +
	                    "WHERE MONTH(bccnv.ngayChamCong) = ? AND YEAR(bccnv.ngayChamCong) = ? and nv.maNV like ? " +
	                    "GROUP BY nv.maNV, nv.hoTen, nv.phuCap, nv.heSoLuong";
		        sta = con.prepareStatement(sql);
		        sta.setInt(1, thang);
		        sta.setInt(2, nam);
		        ma = "%"+ma+"%";
		        sta.setString(3, ma);
		        ResultSet rs = sta.executeQuery();
		        while(rs.next()) {
		        	NhanVien nv = new NhanVien();
		            nv.setMaNV(rs.getString("maNV"));
		            nv.setHoTen(rs.getString("hoTen"));
		            nv.setPhuCap(rs.getInt("phuCap"));
		            nv.setHeSoLuong(rs.getFloat("heSoLuong"));
		            dsCCNV.add(nv);
		            
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return dsCCNV;
		}
		
		public int demSoLuongNhanVien(int thangbd, int nambd, int thangkt, int namkt) {
			PreparedStatement sta = null;
			int n = 0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "DECLARE @ThangBatDau INT = ?;  " + "DECLARE @NamBatDau INT = ?;  " + " "
						+ "DECLARE @ThangKetThuc INT = ?;  " + "DECLARE @NamKetThuc INT = ?;  " + " "
						+ "DECLARE @NgayBatDau DATETIME = DATEFROMPARTS(@NamBatDau, @ThangBatDau, 1); "
						+ "DECLARE @NgayKetThuc DATETIME = EOMONTH(DATEFROMPARTS(@NamKetThuc, @ThangKetThuc, 1)); " + " "
						+ "SELECT COUNT(*) AS SoLuongNhanVien "
						+ "FROM NhanVien "
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
