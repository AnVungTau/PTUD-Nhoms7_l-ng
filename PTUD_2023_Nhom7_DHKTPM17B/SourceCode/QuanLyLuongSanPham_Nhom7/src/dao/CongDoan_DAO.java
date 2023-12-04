package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entity.CongDoan;
import entity.SanPham;

/**
 * @author Nguyễn Tuấn Hùng
 */
public class CongDoan_DAO {
	public ArrayList<CongDoan> getAllCongDoan() {
	    ArrayList<CongDoan> dsCongDoan = new ArrayList<CongDoan>();
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT cd.maCD, cd.tenCD, cd.soThuTu, cd.soLuongCan, cd.tinhTrang, cd.gia, cd.ghiChu, cd.maSP, sp.tenSP FROM CongDoan cd JOIN SanPham sp ON cd.maSP = sp.maSP";
	        Statement sta = con.createStatement();

	        ResultSet rs = sta.executeQuery(sql);
	        while (rs.next()) {
	        	String maCD = rs.getString("maCD");
	            String tenCD = rs.getString("tenCD");
	            int soThuTu = rs.getInt("soThuTu");
	            int soLuongCan = rs.getInt("soLuongCan");
	            int tinhTrang = rs.getInt("tinhTrang");
	            float gia = rs.getFloat("gia");
	            String ghiChu = rs.getString("ghiChu");
	            String maSp = rs.getString("maSP");
	            String tenSP = rs.getString("tenSP");

	            SanPham sp = new SanPham(maSp, tenSP);
	            CongDoan congDoan = new CongDoan(maCD, tenCD, soThuTu, soLuongCan, tinhTrang, gia, ghiChu, sp);
	            dsCongDoan.add(congDoan);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return dsCongDoan;
	}

	public boolean themCongDoan(CongDoan cd) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "INSERT INTO CongDoan (maCD, tenCD, soThuTu, soLuongCan, tinhTrang, gia, ghiChu, maSP) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			sta = con.prepareStatement(sql);

			sta.setString(1, cd.getMaCD());
			sta.setString(2, cd.getTenCD());
			sta.setInt(3, cd.getsoThuTu());
			sta.setInt(4, cd.getsoLuongCan());
			sta.setInt(5, cd.getTinhTrang());
			sta.setFloat(6, cd.getGia());
			sta.setString(7, cd.getGhiChu());
			sta.setString(8, cd.getSp().getMaSP());

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

	public boolean suaCongDoan(CongDoan cd) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "UPDATE CongDoan SET tenCD=?, soThuTu=?, soLuongCan=?, tinhTrang=?, gia=?, ghiChu=?, maSP=? WHERE maCD=?";
			sta = con.prepareStatement(sql);

			sta.setString(1, cd.getTenCD());
			sta.setInt(2, cd.getsoThuTu());
			sta.setInt(3, cd.getsoLuongCan());
			sta.setInt(4, cd.getTinhTrang());
			sta.setFloat(5, cd.getGia());
			sta.setString(6, cd.getGhiChu());
			sta.setString(7, cd.getSp().getMaSP());
			sta.setString(8, cd.getMaCD());

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

	public boolean xoaCongDoan(String maCD) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "DELETE FROM CongDoan WHERE maCD=?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maCD);

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
	
	public void capNhatTrangThaiTuDong() {
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "WITH CongDoanCTE AS ( "
					+ "    SELECT  "
					+ "        cd.maCD, "
					+ "        cd.tinhTrang AS TinhTrangCongDoan, "
					+ "        CASE  "
					+ "            WHEN COUNT(pc.maCN) = SUM(pc.trangThai) AND COUNT(pc.maCN) > 0 THEN 1 "
					+ "            ELSE 0 "
					+ "        END AS CongDoanHoanThanh "
					+ "    FROM  "
					+ "        CongDoan cd "
					+ "    LEFT JOIN  "
					+ "        BangPhanCong pc ON cd.maCD = pc.maCD "
					+ "    GROUP BY  "
					+ "        cd.maCD, cd.tinhTrang "
					+ ") "
					+ " "
					+ "UPDATE CongDoan "
					+ "SET TinhTrang = CongDoanCTE.CongDoanHoanThanh "
					+ "FROM CongDoan "
					+ "INNER JOIN CongDoanCTE ON CongDoan.maCD = CongDoanCTE.maCD;";
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

	public ArrayList<String> getDanhSachMaCongDoan() {
		ArrayList<String> dsMaCD = new ArrayList<String>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT maCD FROM CongDoan";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				dsMaCD.add(rs.getString("maCD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsMaCD;
	}
	

	/**
	 * 
	 * @author Nguyễn Hồng Quân
	 */
	public ArrayList<CongDoan> getAllCongDoanTheoMaSanPham(SanPham sanPham) {
		PreparedStatement sta = null;
	    ArrayList<CongDoan> dsCongDoan = new ArrayList<CongDoan>();
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT * from CongDoan cd join SanPham sp on cd.maSP = sp.maSP where sp.maSP = ?";
	        sta = con.prepareStatement(sql);
	        sta.setString(1, sanPham.getMaSP());
	        
	        ResultSet rs = sta.executeQuery();
	        while (rs.next()) {
	        	String maCD = rs.getString("maCD");
	            String tenCD = rs.getString("tenCD");
	            int soThuTu = rs.getInt("soThuTu");
	            int soLuongCan = rs.getInt("soLuongCan");
	            int tinhTrang = rs.getInt("tinhTrang");
	            float gia = rs.getFloat("gia");
	            String ghiChu = rs.getString("ghiChu");
	            String maSp = rs.getString("maSP");
	            String tenSP = rs.getString("tenSP");

	            SanPham sp = new SanPham(maSp, tenSP);
	            CongDoan congDoan = new CongDoan(maCD, tenCD, soThuTu, soLuongCan, tinhTrang, gia, ghiChu, sp);
	            dsCongDoan.add(congDoan);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return dsCongDoan;
	}
	
	public ArrayList<CongDoan> timCongDoan(int chon, String timKiem) {
		ArrayList<CongDoan> dsCD = new ArrayList<CongDoan>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from CongDoan cd join SanPham sp on cd.maSP = sp.maSP where ";
			
			if (chon == 0) {
	            sql += "maCD LIKE ?";
	        } else if (chon == 1) {
	            sql += "tenCD LIKE ?";
	        } else if (chon == 3) {
	            sql += "gia = ?";
	        }
	        else if (chon == 2) {
	        	sql += "soLuongCan = ?";
	        }
			sta = con.prepareStatement(sql);
			if (chon == 3) {
	            float gia = Float.parseFloat(timKiem);
	            sta.setFloat(1, gia);
	        } else if(chon == 2){
	            int sLCan = Integer.parseInt(timKiem);
	            sta.setInt(1, sLCan);
	        }
	        else {
	        	sta.setString(1, "%" + timKiem + "%");
	        }

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maCD = rs.getString("maCD");
	            String tenCD = rs.getString("tenCD");
	            int soThuTu = rs.getInt("soThuTu");
	            int soLuongCan = rs.getInt("soLuongCan");
	            int tinhTrang = rs.getInt("tinhTrang");
	            float gia = rs.getFloat("gia");
	            String ghiChu = rs.getString("ghiChu");
	            String maSp = rs.getString("maSP");
	            String tenSP = rs.getString("tenSP");

	            SanPham sp = new SanPham(maSp, tenSP);
	            CongDoan congDoan = new CongDoan(maCD, tenCD, soThuTu, soLuongCan, tinhTrang, gia, ghiChu, sp);
	            dsCD.add(congDoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCD;
	}
}
