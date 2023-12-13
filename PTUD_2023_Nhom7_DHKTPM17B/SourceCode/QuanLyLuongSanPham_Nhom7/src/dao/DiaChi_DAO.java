package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DiaChi;
/**
 * @author Nguyễn Hồng Quân
 */
public class DiaChi_DAO {
	public ArrayList<DiaChi> getDiaChiTheoCap(float Level) {
		PreparedStatement sta = null;
		ArrayList<DiaChi> dsDC = new ArrayList<DiaChi>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from diachi where cap = ?";
			sta = con.prepareStatement(sql);
			sta.setFloat(1, Level);
			
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				float id = rs.getFloat("ID");
				String tenDC = rs.getString("tenDC");
				float cap = rs.getFloat("cap");
				float parentID = rs.getFloat("parentID");
				
				DiaChi dc = new DiaChi(id, tenDC, cap, parentID);
				dsDC.add(dc);
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
		return dsDC;
	}
	
	public ArrayList<DiaChi> getDiaChiTheoParentID(float parentID) {
		PreparedStatement sta = null;
		ArrayList<DiaChi> dsDC = new ArrayList<DiaChi>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from diachi where parentID = ?";
			sta = con.prepareStatement(sql);
			sta.setFloat(1, parentID);
			
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				float id = rs.getFloat("ID");
				String tenDC = rs.getString("tenDC");
				float cap = rs.getFloat("cap");
				float parent_id = rs.getFloat("parentID");
				
				DiaChi dc = new DiaChi(id, tenDC, cap, parent_id);
				dsDC.add(dc);
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
		return dsDC;
	}
}
