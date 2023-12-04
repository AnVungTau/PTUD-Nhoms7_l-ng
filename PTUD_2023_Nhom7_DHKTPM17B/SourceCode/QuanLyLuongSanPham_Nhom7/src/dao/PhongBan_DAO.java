package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongBan;
/**
 * @author Nguyễn Tuấn Hùng
 */
public class PhongBan_DAO {
	public ArrayList<PhongBan> getAllPhongBan() {
		ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from phongban";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String maPhong = rs.getString("mapb");
				String tenPhong = rs.getString("tenpb");
				String toaNha = rs.getString("toanha");
				int tang = rs.getInt("tang");
				float dienTich = rs.getFloat("dienTich");
				String ghiChu = rs.getString("ghichu");
				
				PhongBan pb = new PhongBan(maPhong, tenPhong, toaNha, tang, dienTich, ghiChu);
				dsPB.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return dsPB;
	}
	public boolean themPB(PhongBan pb) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into PhongBan values(?,?,?,?,?,?)";
			sta = con.prepareStatement(sql);

			sta.setString(1, pb.getMaPhong());
			sta.setString(2, pb.getTenPhong());
			sta.setString(3, pb.getToaNha());
			sta.setInt(4,pb.getTang());
			sta.setFloat(5, pb.getDienTich());
			sta.setString(6, pb.getGhiChu());
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
	public ArrayList<PhongBan> timPhongBan(int chon, String timKiem) {
		ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhongBan where ";
			
			if (chon == 0) {
	            sql += "maPB LIKE ?";
	        } else if (chon == 1) {
	            sql += "tenPB LIKE ?";
	        } else if (chon == 2) {
	            sql += "toaNha LIKE ?";
	        }
	        else if (chon == 3) {
	        	sql += "tang = ?";
	        }
	        else if (chon == 4){
	        	sql += "dienTich = ?";
	        }
			sta = con.prepareStatement(sql);
			if (chon == 4) {
	            float dienTich = Float.parseFloat(timKiem);
	            sta.setFloat(1, dienTich);
	        } else if(chon == 3){
	            int tang = Integer.parseInt(timKiem);
	            sta.setInt(1, tang);
	        }
	        else {
	        	sta.setString(1, "%" + timKiem + "%");
	        }

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maPB = rs.getString("maPB");
				String tenPB = rs.getString("tenPB");
				String toaNha = rs.getString("toaNha");
				int tang = rs.getInt("tang");
				float dienTich = rs.getFloat("dienTich");
				String ghiChu = rs.getString("ghiChu");
				PhongBan pb = new PhongBan(maPB,tenPB,toaNha,tang,dienTich,ghiChu);
				dsPB.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPB;
	}
	
	public ArrayList<String> getDanhSachMaPhongBan() {
		ArrayList<String> dsMaPB = new ArrayList<String>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT maPB FROM PhongBan";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				dsMaPB.add(rs.getString("maPB"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsMaPB;
	}
	public boolean suaPhongBan(PhongBan phongBan) {
	    PreparedStatement sta = null;
	    int n = 0;
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "UPDATE PhongBan SET tenPB=?, toaNha=?, tang=?, dienTich=?, ghiChu=? WHERE maPB=?";
	        sta = con.prepareStatement(sql);

	        sta.setString(1, phongBan.getTenPhong());
	        sta.setString(2, phongBan.getToaNha());
	        sta.setInt(3, phongBan.getTang());
	        sta.setFloat(4, phongBan.getDienTich());
	        sta.setString(5, phongBan.getGhiChu());
	        sta.setString(6, phongBan.getMaPhong());

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
}