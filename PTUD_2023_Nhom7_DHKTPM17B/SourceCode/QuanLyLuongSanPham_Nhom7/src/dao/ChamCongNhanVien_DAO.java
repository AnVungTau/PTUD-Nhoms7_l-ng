package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entity.BangChamCongNhanVien;
import entity.NhanVien;
import entity.PhongBan;


public class ChamCongNhanVien_DAO {
	public ArrayList<BangChamCongNhanVien> getDanhSachChamCongTheoNgay(java.util.Date ngay) {
	    PreparedStatement sta = null;
	    ArrayList<BangChamCongNhanVien> dsCC = new ArrayList<BangChamCongNhanVien>();
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT "
	                + "    nv.maNV, nv.hoTen, cc.ngayChamCong, cc.trangThaiDiLam, cc.soGioTangCa, cc.ghiChu "
	                + "FROM "
	                + "    NhanVien nv "
	                + "LEFT JOIN "
	                + "    BangChamCongNhanVien cc ON nv.maNV = cc.maNV AND cc.ngayChamCong = ? "
	                + "WHERE "
	                + "    cc.maNV IS NULL";

	        sta = con.prepareStatement(sql);
	        
	        Date sqlDate = new Date(ngay.getTime());
	        sta.setDate(1, sqlDate);

	        ResultSet rs = sta.executeQuery();
	        while (rs.next()) {

	        	NhanVien nv = new NhanVien();
	            nv.setMaNV(rs.getString("maNV"));
	            nv.setHoTen(rs.getString("hoTen"));
	            
	            Date ngayCham = rs.getDate("ngayChamCong");
	            int trangThaiDiLam = rs.getInt("trangThaiDiLam");
	            int soGioTangCa = rs.getInt("soGioTangCa");
	            String ghiChu = rs.getString("ghiChu");

	            BangChamCongNhanVien bcccn = new BangChamCongNhanVien(nv, ngayCham, trangThaiDiLam, soGioTangCa, ghiChu);
	            dsCC.add(bcccn);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dsCC;
	}
	
	public ArrayList<BangChamCongNhanVien> getDanhSachChamCongTheoDieuKien(java.util.Date ngay, Object obj) {
	    PreparedStatement sta = null;
	    ArrayList<BangChamCongNhanVien> dsCC = new ArrayList<BangChamCongNhanVien>();
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT "
	        		+ "    nv.maNV, nv.hoTen, cc.ngayChamCong, cc.trangThaiDiLam, cc.soGioTangCa, cc.ghiChu "
	        		+ "FROM "
	        		+ "    NhanVien nv "
	        		+ "LEFT JOIN "
	        		+ "    BangChamCongNhanVien cc ON nv.maNV = cc.maNV AND cc.ngayChamCong = ? "
	        		+ "WHERE "
	        		+ "    cc.maNV IS NULL "
	        		+ "	AND ";
	        int flag = 0;
	        if(obj instanceof PhongBan) {
	        	sql += "nv.maPB = ?";
	        	flag = 1;
	        }
	        
	        if(obj instanceof String) {
	        	sql += "nv.hoTen LIKE ?";
	        	flag = 2;
	        }
	        sta = con.prepareStatement(sql);
	        Date sqlDate = new Date(ngay.getTime());
	        sta.setDate(1, sqlDate);
	        
	        if(flag == 1) {
	        	sta.setString(2, ((PhongBan) obj).getMaPhong());
	        }
	        
	        if(flag == 2) {
	        	sta.setString(2, "%" + obj + "%");
	        }

	        ResultSet rs = sta.executeQuery();
	        while (rs.next()) {

	        	NhanVien nv = new NhanVien();
	            nv.setMaNV(rs.getString("maNV"));
	            nv.setHoTen(rs.getString("hoTen"));
	            
	            Date ngayCham = rs.getDate("ngayChamCong");
	            int trangThaiDiLam = rs.getInt("trangThaiDiLam");
	            int soGioTangCa = rs.getInt("soGioTangCa");
	            String ghiChu = rs.getString("ghiChu");

	            BangChamCongNhanVien bcccn = new BangChamCongNhanVien(nv, ngayCham, trangThaiDiLam, soGioTangCa, ghiChu);
	            dsCC.add(bcccn);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dsCC;
	}
	
	public ArrayList<BangChamCongNhanVien> getDanhSachDaChamCongTheoNgay(java.util.Date ngay) {
	    PreparedStatement sta = null;
	    ArrayList<BangChamCongNhanVien> dsCC = new ArrayList<BangChamCongNhanVien>();
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT "
	        		+ "    nv.maNV, nv.hoTen, cc.ngayChamCong, cc.trangThaiDiLam, cc.soGioTangCa, cc.ghiChu "
	        		+ "FROM "
	        		+ "    NhanVien nv "
	        		+ "INNER JOIN "
	        		+ "    BangChamCongNhanVien cc ON nv.maNV = cc.maNV "
	        		+ "WHERE "
	        		+ "    cc.ngayChamCong = ?";

	        sta = con.prepareStatement(sql);
	        
	        Date sqlDate = new Date(ngay.getTime());
	        sta.setDate(1, sqlDate);

	        ResultSet rs = sta.executeQuery();
	        while (rs.next()) {

	        	NhanVien nv = new NhanVien();
	            nv.setMaNV(rs.getString("maNV"));
	            nv.setHoTen(rs.getString("hoTen"));
	            
	            Date ngayCham = rs.getDate("ngayChamCong");
	            int trangThaiDiLam = rs.getInt("trangThaiDiLam");
	            int soGioTangCa = rs.getInt("soGioTangCa");
	            String ghiChu = rs.getString("ghiChu");

	            BangChamCongNhanVien bcccn = new BangChamCongNhanVien(nv, ngayCham, trangThaiDiLam, soGioTangCa, ghiChu);
	            dsCC.add(bcccn);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dsCC;
	}

	
	public boolean them(BangChamCongNhanVien bchamcong) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into BangChamCongNhanVien values(?,?,?,?,?)";
			sta = con.prepareStatement(sql);

			sta.setString(1, bchamcong.getNhanVien().getMaNV());
			Date date = new Date(bchamcong.getNgayCham().getTime());
			sta.setDate(2, date);
			sta.setInt(3, bchamcong.getTrangThaiDiLam());
			sta.setInt(4, bchamcong.getSoGIoTangCa());
			sta.setString(5, bchamcong.getGhiChu());

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
	public boolean capNhat(BangChamCongNhanVien bchamcong) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "UPDATE BangChamCongNhanVien SET trangThaiDiLam = ?, soGioTangCa = ?, ghiChu = ? WHERE maNV = ? AND ngayChamCong = ?";
			sta = con.prepareStatement(sql);

			sta.setInt(1, bchamcong.getTrangThaiDiLam());
			sta.setInt(2, bchamcong.getSoGIoTangCa());
			sta.setString(3, bchamcong.getGhiChu());
			sta.setString(4, bchamcong.getNhanVien().getMaNV());
			Date sqlDateNgayCham = new Date(bchamcong.getNgayCham().getTime());
			sta.setDate(5, sqlDateNgayCham);

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