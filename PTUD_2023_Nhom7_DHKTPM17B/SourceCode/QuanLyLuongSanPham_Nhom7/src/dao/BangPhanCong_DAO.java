package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entity.BangPhanCong;
import entity.CongDoan;
import entity.CongNhan;
import entity.SanPham;
import entity.ToNhom;

/**
 * @author Nguyễn Hồng Quân
 */
public class BangPhanCong_DAO {

	public ArrayList<BangPhanCong> getDanhSachPhanCong() {
		ArrayList<BangPhanCong> dsPC = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from BangPhanCong pc join CongNhan cn on cn.maCN = pc.maCN join CongDoan cd on cd.maCD = pc.maCD join SanPham sp on sp.maSP = cd.maSP";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String maCN = rs.getString("macn");
				CongNhan cn = new CongNhan(maCN);
				cn.setHoTen(rs.getString("hoTen"));
				String maCD = rs.getString("macd");
				SanPham sp = new SanPham();
				sp.setMaSP(rs.getString("maSP"));
				sp.setTenSP(rs.getString("tenSP"));
				CongDoan cd = new CongDoan(maCD);
				cd.setTenCD(rs.getString("tenCD"));
				cd.setSp(sp);
				int soLuongPC = rs.getInt("soLuongPhanCong");
				Date ngayPC = rs.getDate("ngayPhanCong");
				int tt = rs.getInt("trangThai");

				BangPhanCong bpc = new BangPhanCong(cn, cd, soLuongPC, ngayPC, tt);
				dsPC.add(bpc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPC;
	}
	
	public ArrayList<BangPhanCong> getDanhSachPhanCongTheoDieuKienTim(String luaChon, String timKiem) {
		ArrayList<BangPhanCong> dsPC = new ArrayList<>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from BangPhanCong pc join CongNhan cn on cn.maCN = pc.maCN join CongDoan cd on cd.maCD = pc.maCD  "
					+ "join SanPham sp on sp.maSP = cd.maSP "
					+ "where ";
			if(luaChon.equalsIgnoreCase("Mã công nhân")) {
				sql += "cn.maCN LIKE ?";
			}
			
			if(luaChon.equalsIgnoreCase("Tên công nhân")) {
				sql += "cn.hoTen LIKE ?";
			}
			
			if(luaChon.equalsIgnoreCase("Mã sản phẩm")) {
				sql += "sp.maSP LIKE ?";
			}
			
			if(luaChon.equalsIgnoreCase("Tên sản phẩm")) {
				sql += "sp.tenSP LIKE ?";
			}
			
			if(luaChon.equalsIgnoreCase("Mã công đoạn")) {
				sql += "cd.maCD LIKE ?";
			}
			
			if(luaChon.equalsIgnoreCase("Tên công đoạn")) {
				sql += "cd.tenCD LIKE ?";
			}
			sta = con.prepareStatement(sql);
			
			sta.setString(1, "%" + timKiem + "%");

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maCN = rs.getString("macn");
				CongNhan cn = new CongNhan(maCN);
				cn.setHoTen(rs.getString("hoTen"));
				String maCD = rs.getString("macd");
				SanPham sp = new SanPham();
				sp.setMaSP(rs.getString("maSP"));
				sp.setTenSP(rs.getString("tenSP"));
				CongDoan cd = new CongDoan(maCD);
				cd.setTenCD(rs.getString("tenCD"));
				cd.setSp(sp);
				int soLuongPC = rs.getInt("soLuongPhanCong");
				Date ngayPC = rs.getDate("ngayPhanCong");
				int tt = rs.getInt("trangThai");

				BangPhanCong bpc = new BangPhanCong(cn, cd, soLuongPC, ngayPC, tt);
				dsPC.add(bpc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPC;
	}
	
	public ArrayList<BangPhanCong> getDanhSachPhanCongTheoNgay(java.util.Date ngay) {
		ArrayList<BangPhanCong> dsPC = new ArrayList<>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from BangPhanCong pc join CongNhan cn on cn.maCN = pc.maCN join CongDoan cd on cd.maCD = pc.maCD  "
					+ "join SanPham sp on sp.maSP = cd.maSP "
					+ "where pc.ngayPhanCong = ?";
			sta = con.prepareStatement(sql);

			Date date = new Date(ngay.getTime());
			sta.setDate(1, date);
			
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maCN = rs.getString("macn");
				CongNhan cn = new CongNhan(maCN);
				cn.setHoTen(rs.getString("hoTen"));
				String maCD = rs.getString("macd");
				SanPham sp = new SanPham();
				sp.setMaSP(rs.getString("maSP"));
				sp.setTenSP(rs.getString("tenSP"));
				CongDoan cd = new CongDoan(maCD);
				cd.setTenCD(rs.getString("tenCD"));
				cd.setSp(sp);
				int soLuongPC = rs.getInt("soLuongPhanCong");
				Date ngayPC = rs.getDate("ngayPhanCong");
				int tt = rs.getInt("trangThai");

				BangPhanCong bpc = new BangPhanCong(cn, cd, soLuongPC, ngayPC, tt);
				dsPC.add(bpc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPC;
	}
	
	public boolean capNhatSoLuongPhanCong(BangPhanCong pc) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update BangPhanCong set soLuongPhanCong = ? where maCN = ? and maCD = ? ";
			sta = con.prepareStatement(sql);

			sta.setInt(1, pc.getSoLuongPC());
			sta.setString(2, pc.getCongNhan().getMaCN());
			sta.setString(3, pc.getCongDoan().getMaCD());

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

	public boolean capNhatTrangThaiHoanThanh(String maCN, String maCD, int trangThai) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update BangPhanCong set trangThai = ? where maCN = ? and maCD = ? ";
			sta = con.prepareStatement(sql);

			sta.setInt(1, trangThai);
			sta.setString(2, maCN);
			sta.setString(3, maCD);

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
	
	public void capNhatTrangThaiTuDong() {
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "UPDATE pc "
					+ "SET pc.trangThai =  "
					+ "    CASE  "
					+ "        WHEN result.TongSoLuongLam >= pc.soLuongPhanCong THEN 1 "
					+ "        ELSE 0 "
					+ "    END "
					+ "FROM BangPhanCong pc "
					+ "INNER JOIN ( "
					+ "    SELECT  "
					+ "        pc.maCN, "
					+ "        pc.maCD, "
					+ "        SUM(cc.soLuongLam) AS TongSoLuongLam "
					+ "    FROM  "
					+ "        BangPhanCong pc "
					+ "    INNER JOIN  "
					+ "        BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD "
					+ "    GROUP BY  "
					+ "        pc.maCN, pc.maCD "
					+ ") AS result ON pc.maCN = result.maCN AND pc.maCD = result.maCD;";
			sta = con.prepareStatement(sql);

			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean them(BangPhanCong phanCong) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "INSERT INTO BangPhanCong (maCN, maCD, soLuongPhanCong, ngayPhanCong, trangThai) VALUES (?, ?, ?, ?, ?)";
			sta = con.prepareStatement(sql);

			sta.setString(1, phanCong.getCongNhan().getMaCN());
			sta.setString(2, phanCong.getCongDoan().getMaCD());
			sta.setInt(3, phanCong.getSoLuongPC());
			Date sqlNgayPC = new Date(phanCong.getNgayPhanCong().getTime());
			sta.setDate(4, sqlNgayPC);
			sta.setInt(5, phanCong.getTrangThai());

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
	
	public boolean xoa(BangPhanCong phanCong) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from BangPhanCong where maCN = ? and maCD = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, phanCong.getCongNhan().getMaCN());
			sta.setString(2, phanCong.getCongDoan().getMaCD());

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

	public boolean kiemTraTonTaiCuaBangPhanCong(String maCN, String maCD) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from BangPhanCong where maCN = ? and maCD = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, maCN);
			sta.setString(2, maCD);

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
	
	public ArrayList<CongNhan> getDSCongNhanChuaDuocPhanCongVaoCongDoan(int maTo, String maCD) {
		ArrayList<CongNhan> dsCN = new ArrayList<CongNhan>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * "
					+ "FROM CongNhan "
					+ "JOIN ToNhom ON CongNhan.maTo = ToNhom.maTo "
					+ "WHERE ToNhom.maTo = ? "
					+ "  AND CongNhan.maCN NOT IN ( "
					+ "    SELECT maCN "
					+ "    FROM BangPhanCong "
					+ "    WHERE maCD = ? "
					+ "  )";
			sta = con.prepareStatement(sql);
			sta.setInt(1, maTo);
			sta.setString(2, maCD);

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
				int mato = rs.getInt("mato");
				String tenTo = rs.getString("tento");
				ToNhom to = new ToNhom(mato, tenTo);
				float phuCap = rs.getFloat("phucap");
				
				CongNhan cn = new CongNhan(maCN, hoTen, ngaySinh, gioiTinh, cmnd, soDienThoai, diaChi, ngayVaoLam, ghiChu, to, phuCap);

				dsCN.add(cn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCN;
	}

	public int demSoLuongLamDuoc(String maCN, String maCD) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  "
					+ "    pc.maCN, "
					+ "    pc.maCD, "
					+ "    pc.soLuongPhanCong, "
					+ "    SUM(cc.soLuongLam) AS TongSoLuongLam "
					+ "FROM  "
					+ "    BangPhanCong pc "
					+ "INNER JOIN  "
					+ "    BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD "
					+ "WHERE "
					+ "    pc.maCN = ? "
					+ "    AND pc.maCD = ? "
					+ "GROUP BY  "
					+ "    pc.maCN, pc.maCD, pc.soLuongPhanCong;";
			sta = con.prepareStatement(sql);

			sta.setString(1, maCN);
			sta.setString(2, maCD);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				n = rs.getInt("TongSoLuongLam");
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
