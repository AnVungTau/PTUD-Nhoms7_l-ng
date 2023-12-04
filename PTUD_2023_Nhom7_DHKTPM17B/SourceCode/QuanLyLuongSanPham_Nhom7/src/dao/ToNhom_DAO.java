package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entity.ToNhom;


/**
 * @author Nguyễn Thành An
 */

public class ToNhom_DAO {
	public ArrayList<ToNhom> getAllTo() {
		ArrayList<ToNhom> dsTo = new ArrayList<ToNhom>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from ToNhom";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				int maTo = rs.getInt("mato");
				String tenTo = rs.getString("tenTo");

				ToNhom to = new ToNhom(maTo, tenTo);
				dsTo.add(to);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return dsTo;
	}
	
	public int demSoLuongCongNhan(int maTo) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from ToNhom t join CongNhan cn on t.maTo = cn.maTo where cn.maTo = ?";
			sta = con.prepareStatement(sql);

			sta.setInt(1, maTo);
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
	
	public boolean them(ToNhom to) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into ToNhom values(?,?)";
			sta = con.prepareStatement(sql);

			sta.setInt(1, to.getMaTo());
			sta.setString(2, to.getTenTo());
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
	
	public boolean sua(ToNhom to) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update ToNhom set tenTo = ? where maTo = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, to.getTenTo());
			sta.setInt(2, to.getMaTo());
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
	
	public ArrayList<Integer> getDanhSachMaToNhom() {
        ArrayList<Integer> dsMa = new ArrayList<Integer>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT maTo FROM ToNhom";
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
            	dsMa.add(rs.getInt("maTo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsMa;
    }

}
