package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entity.HopDong;
import connectDB.ConnectDB;
/**
 * @author Trần Vũ Minh Nhật
 */
public class HopDong_DAO { 
	public boolean themHopDong(HopDong hopDong) {
	    PreparedStatement sta = null;
	    int n = 0;
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "insert into HopDong values(?,?,?,?,?,?,?,?)";
	        sta = con.prepareStatement(sql);

	        sta.setString(1, hopDong.getMaHD());
	        sta.setString(2, hopDong.getTenHD());
	        sta.setString(3, hopDong.getTenKH());
	        sta.setDouble(4, hopDong.getSoTienCoc());
	        sta.setDouble(5, hopDong.getTongTienHD());
	        Date sqlDateNgayBatDau = new Date(hopDong.getNgayBatDau().getTime());
	        sta.setDate(6, sqlDateNgayBatDau);
	        Date sqlDateNgayKetThuc = new Date(hopDong.getNgayKetThuc().getTime());
	        sta.setDate(7, sqlDateNgayKetThuc);
	        sta.setString(8, hopDong.getGhiChu());

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

    public boolean suaHD(HopDong hd) {
        PreparedStatement sta = null;
        int n = 0;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection(); 
            String sql = "update HopDong set maHD = ?, tenHD = ?, tenKH = ?, soTienCoc = ?, tongTienHD = ?, ngayBatDau = ?, ngayKetThuc = ?, ghiChu = ? where maHD = ?";;
            sta = con.prepareStatement(sql);
            sta.setString(1, hd.getMaHD());
            sta.setString(2, hd.getTenHD());
            sta.setString(3, hd.getTenKH());
            sta.setDouble(4, hd.getSoTienCoc());
            sta.setDouble(5, hd.getTongTienHD()); 
            sta.setString(8, hd.getGhiChu());
            Date sqlDateNgaySinh = new Date(hd.getNgayBatDau().getTime());
            sta.setDate(6, sqlDateNgaySinh); 
            Date sqlDateVaoLam = new Date(hd.getNgayKetThuc().getTime());
            sta.setDate(7, sqlDateVaoLam); 

            sta.setString(9, hd.getMaHD());
             
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

    public ArrayList<HopDong> getHopDongByMa(String maHopDong) {
        ArrayList<HopDong> dsHD = new ArrayList<HopDong>();
        PreparedStatement sta = null;
        try {
        	ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM HopDong WHERE maHD = ?";
            sta = con.prepareStatement(sql);
            sta.setString(1, maHopDong);
            
            ResultSet rs = sta.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu từ ResultSet và tạo đối tượng HopDong
                String maHD = rs.getString("maHD");
                String tenHD = rs.getString("tenHD");
                String tenKH = rs.getString("tenKH");
                double soTienCoc = rs.getDouble("soTienCoc");
                double tongTienHD = rs.getDouble("tongTienHD");
                Date ngayBatDau = rs.getDate("ngayBatDau");
                Date ngayKetThuc = rs.getDate("ngayKetThuc");
                String ghiChu = rs.getString("ghiChu");

                HopDong hopDong = new HopDong(maHD, tenHD, tenKH, soTienCoc, tongTienHD, ngayBatDau, ngayKetThuc, ghiChu);
                dsHD.add(hopDong);
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

        return dsHD;
    }
    
    public ArrayList<HopDong> getAllHopDong() {
		ArrayList<HopDong> dsHD = new ArrayList<HopDong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HopDong";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString("maHD");
                String tenHD = rs.getString("tenHD");
                String tenKH = rs.getString("tenKH");
                double soTienCoc = rs.getDouble("soTienCoc");
                double tongTienHD = rs.getDouble("tongTienHD");
                Date ngayBatDau = rs.getDate("ngayBatDau");
                Date ngayKetThuc = rs.getDate("ngayKetThuc");
                String ghiChu = rs.getString("ghiChu");

                HopDong hopDong = new HopDong(maHD, tenHD, tenKH, soTienCoc, tongTienHD, ngayBatDau, ngayKetThuc, ghiChu);
                dsHD.add(hopDong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}
 
    public ArrayList<HopDong> getHopDongByTongTien(double tongTienValue) {
        ArrayList<HopDong> hopDongList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM HopDong WHERE tongTienHD = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, tongTienValue);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Lấy dữ liệu từ ResultSet và tạo đối tượng HopDong
                String maHD = resultSet.getString("maHD");
                String tenHD = resultSet.getString("tenHD");
                String tenKH = resultSet.getString("tenKH");
                double soTienCoc = resultSet.getDouble("soTienCoc");
                double tongTienHD = resultSet.getDouble("tongTienHD");
                Date ngayBatDau = resultSet.getDate("ngayBatDau");
                Date ngayKetThuc = resultSet.getDate("ngayKetThuc");
                String ghiChu = resultSet.getString("ghiChu");

                HopDong hopDong = new HopDong(maHD, tenHD, tenKH, soTienCoc, tongTienHD, ngayBatDau, ngayKetThuc, ghiChu);
                hopDongList.add(hopDong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return hopDongList;
    }

    public ArrayList<HopDong> getHopDongByTenKhachHang(String tenKhachHang) {
        ArrayList<HopDong> hopDongList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM HopDong WHERE tenKH = N?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenKhachHang);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Lấy dữ liệu từ ResultSet và tạo đối tượng HopDong
                String maHD = resultSet.getString("maHD");
                String tenHD = resultSet.getString("tenHD");
                String tenKH = resultSet.getString("tenKH");
                double soTienCoc = resultSet.getDouble("soTienCoc");
                double tongTienHD = resultSet.getDouble("tongTienHD");
                Date ngayBatDau = resultSet.getDate("ngayBatDau");
                Date ngayKetThuc = resultSet.getDate("ngayKetThuc");
                String ghiChu = resultSet.getString("ghiChu");

                HopDong hopDong = new HopDong(maHD, tenHD, tenKH, soTienCoc, tongTienHD, ngayBatDau, ngayKetThuc, ghiChu);
                hopDongList.add(hopDong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return hopDongList;
    } 
    public static ArrayList<HopDong> timKiemHopDongTheoTen(String tenHD) {
    	ArrayList<HopDong> danhSachHopDong = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM HopDong WHERE tenHD LIKE ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + tenHD + "%");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String maHD = resultSet.getString("maHD");
                String tenHopDong = resultSet.getString("tenHD");
                String tenKH = resultSet.getString("tenKH");
                double soTienCoc = resultSet.getDouble("soTienCoc");
                double tongTienHD = resultSet.getDouble("tongTienHD");
                Date ngayBatDau = resultSet.getDate("ngayBatDau");
                Date ngayKetThuc = resultSet.getDate("ngayKetThuc");
                String ghiChu = resultSet.getString("ghiChu");

                HopDong hopDong = new HopDong(maHD, tenHopDong, tenKH, soTienCoc, tongTienHD, ngayBatDau, ngayKetThuc, ghiChu);
                danhSachHopDong.add(hopDong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return danhSachHopDong;
    }
//Nguyễn Tuấn Hùng
    public ArrayList<String> getDanhSachMaHopDong() {
        ArrayList<String> dsMaHopDong = new ArrayList<String>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT maHD FROM HopDong"; // Thay đổi tên bảng và cột tương ứng
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                dsMaHopDong.add(rs.getString("maHD")); // Thay đổi tên cột tương ứng
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsMaHopDong;
    }


} 
