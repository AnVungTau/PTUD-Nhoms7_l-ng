package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongBan;
/**
 * @author Nguyễn Hồng Quân
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

}
