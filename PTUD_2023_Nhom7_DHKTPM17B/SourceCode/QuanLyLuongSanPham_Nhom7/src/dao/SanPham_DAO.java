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
import entity.SanPham;

/**
 * Trần Vũ Minh Nhật
 */
public class SanPham_DAO {
	public boolean themSanPham(SanPham sanpham) {
		PreparedStatement sta = null;
	    int n = 0;
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "INSERT INTO SanPham (maSP, tenSP, soLuong, donViTinh, ghiChu, maHD) VALUES (?, ?, ?, ?, ?, ?)";
	        sta = con.prepareStatement(sql);

	        sta.setString(1, sanpham.getMaSP());
	        sta.setString(2, sanpham.getTenSP());
	        sta.setInt(3, sanpham.getSoLuong());
	        sta.setString(4, sanpham.getDonViTinh());
	        sta.setString(5, sanpham.getGhiChu());
	        sta.setString(6, sanpham.getHopDong().getMaHD());

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

	public ArrayList<SanPham> timKiemSanPhamTheoTenSanPham(String tenSP) {
		ArrayList<SanPham> dsSP = new ArrayList<>();
		Connection conn = ConnectDB.getConnection();
		String query = "SELECT *, hd.ghiChu as ghiChuHD, sp.ghiChu as ghiChuSP from SanPham sp join HopDong hd on sp.maHD = hd.maHD WHERE sp.tenSP LIKE ?";

		try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setString(1, "%" + tenSP + "%");

			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					String maSP = rs.getString("maSP");
					String tenSanPham = rs.getString("tenSP");
					int soLuong = rs.getInt("soLuong");
					String donViTinh = rs.getString("donViTinh");
					String ghiChuSP = rs.getString("ghiChuSP");

					String maHD = rs.getString("maHD");
					String tenHD = rs.getString("tenHD");
					String tenKH = rs.getString("tenKH");
					double soTienCoc = rs.getDouble("soTienCoc");
					double tongTienHD = rs.getDouble("tongTienHD");
					Date ngayBatDau = rs.getDate("ngayBatDau");
					Date ngayKetThuc = rs.getDate("ngayKetThuc");
					String ghiChuHD = rs.getString("ghiChuHD");

					HopDong hd = new HopDong(maHD, tenHD, tenKH, soTienCoc, tongTienHD, ngayBatDau, ngayKetThuc, ghiChuHD);
					SanPham sp = new SanPham(maSP, tenSanPham, soLuong, donViTinh, ghiChuSP, hd);

					dsSP.add(sp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsSP;
	}

	public ArrayList<SanPham> getAllSanPham() {
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select *, hd.ghiChu as ghiChuHD, sp.ghiChu as ghiChuSP from SanPham sp join HopDong hd on sp.maHD = hd.maHD";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String maSP = rs.getString("maSP");
				String tenSanPham = rs.getString("tenSP");
				int soLuong = rs.getInt("soLuong");
				String donViTinh = rs.getString("donViTinh");
				String ghiChuSP = rs.getString("ghiChuSP");

				String maHD = rs.getString("maHD");
				String tenHD = rs.getString("tenHD");
				String tenKH = rs.getString("tenKH");
				double soTienCoc = rs.getDouble("soTienCoc");
				double tongTienHD = rs.getDouble("tongTienHD");
				Date ngayBatDau = rs.getDate("ngayBatDau");
				Date ngayKetThuc = rs.getDate("ngayKetThuc");
				String ghiChuHD = rs.getString("ghiChuHD");

				HopDong hd = new HopDong(maHD, tenHD, tenKH, soTienCoc, tongTienHD, ngayBatDau, ngayKetThuc, ghiChuHD);
				SanPham sp = new SanPham(maSP, tenSanPham, soLuong, donViTinh, ghiChuSP, hd);

				dsSP.add(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsSP;
	}

	public ArrayList<SanPham> timSanPhamTheoMaHopDong(String maHD) {
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select *, hd.ghiChu as ghiChuHD, sp.ghiChu as ghiChuSP from SanPham sp join HopDong hd on sp.maHD = hd.maHD where hd.maHD = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maHD);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maSP = rs.getString("maSP");
				String tenSanPham = rs.getString("tenSP");
				int soLuong = rs.getInt("soLuong");
				String donViTinh = rs.getString("donViTinh");
				String ghiChuSP = rs.getString("ghiChuSP");

				String mahd = rs.getString("maHD");
				String tenHD = rs.getString("tenHD");
				String tenKH = rs.getString("tenKH");
				double soTienCoc = rs.getDouble("soTienCoc");
				double tongTienHD = rs.getDouble("tongTienHD");
				Date ngayBatDau = rs.getDate("ngayBatDau");
				Date ngayKetThuc = rs.getDate("ngayKetThuc");
				String ghiChuHD = rs.getString("ghiChuHD");

				HopDong hd = new HopDong(mahd, tenHD, tenKH, soTienCoc, tongTienHD, ngayBatDau, ngayKetThuc, ghiChuHD);
				SanPham sp = new SanPham(maSP, tenSanPham, soLuong, donViTinh, ghiChuSP, hd);

				dsSP.add(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsSP;
	}

	public boolean capNhatSanPham(SanPham sp) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection(); 
            String sql = "UPDATE SanPham SET tenSP = ?, soLuong = ?, donViTinh = ?, ghiChu = ?, maHD = ? WHERE maSP = ?";
            sta = con.prepareStatement(sql);
            
            sta.setString(1, sp.getTenSP());
            sta.setInt(2, sp.getSoLuong());
            sta.setString(3, sp.getDonViTinh());
            sta.setString(4, sp.getGhiChu());
            sta.setString(5, sp.getHopDong().getMaHD());
            sta.setString(6, sp.getMaSP());
            
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

	// Nguyễn Tuấn Hùng
	public ArrayList<SanPham> timKiemSanPhamTheoMaSanPham(String maSPCT) {
		ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
		Connection conn = ConnectDB.getConnection();
		String query = "SELECT * FROM SanPham WHERE maSP LIKE ?";

		try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setString(1, "%" + maSPCT + "%");

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String maSP = resultSet.getString("maSP");
					String tenSanPham = resultSet.getString("tenSP");
					int soLuong = resultSet.getInt("soLuong");
					String donViTinh = resultSet.getString("donViTinh");
					String ghiChu = resultSet.getString("ghiChu");
					String maHD = resultSet.getString("maHD");

					// Tạo đối tượng HopDong (chưa có phương thức tạo)
					HopDong hopDong = new HopDong();
					hopDong.setMaHD(maHD);

					// Tạo đối tượng SanPham
					SanPham sanPham = new SanPham(maSP, tenSanPham, soLuong, donViTinh, ghiChu, hopDong);

					// Thêm sản phẩm vào danh sách
					danhSachSanPham.add(sanPham);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return danhSachSanPham;
	}

	public ArrayList<String> getDanhSachMaSanPham() {
		ArrayList<String> dsMaSanPham = new ArrayList<String>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT maSP FROM SanPham"; // Thay đổi tên bảng và cột tương ứng
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				dsMaSanPham.add(rs.getString("maSP")); // Thay đổi tên cột tương ứng
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsMaSanPham;
	}

}
