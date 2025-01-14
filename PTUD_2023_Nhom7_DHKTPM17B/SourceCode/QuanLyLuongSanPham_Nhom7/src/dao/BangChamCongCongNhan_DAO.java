package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entity.BangChamCongCongNhan;
import entity.BangPhanCong;
import entity.CongDoan;
import entity.CongNhan;
import entity.HopDong;
import entity.SanPham;
import entity.ToNhom;

/**
 * @author Nguyễn Hồng Quân
 */
public class BangChamCongCongNhan_DAO {
	public ArrayList<BangChamCongCongNhan> getDanhSachChamCongTheoNgay(java.util.Date ngay) {
		PreparedStatement sta = null;
		ArrayList<BangChamCongCongNhan> dsCC = new ArrayList<BangChamCongCongNhan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  "
					+ "    cn.maCN, cn.hoTen, cd.maCD, cd.tenCD, sp.maSP, sp.tenSP, pc.ngayPhanCong,  "
					+ "	pc.soLuongPhanCong, pc.trangThai, cc.ngayChamCong, cc.soLuongLam "
					+ "FROM  "
					+ "    BangPhanCong pc "
					+ "LEFT JOIN  "
					+ "    BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD AND cc.ngayChamCong = ? "
					+ "JOIN  "
					+ "    CongNhan cn ON pc.maCN = cn.maCN "
					+ "JOIN "
					+ "	CongDoan cd ON cd.maCD = pc.maCD "
					+ "JOIN SanPham sp ON sp.maSP = cd.maSP "
					+ "WHERE  "
					+ "    cc.maCN IS NULL "
					+ "    AND cc.maCD IS NULL;";
			sta = con.prepareStatement(sql);
			Date sqlDate = new Date(ngay.getTime());
			sta.setDate(1, sqlDate);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {

				SanPham sp = new SanPham();
				sp.setMaSP(rs.getString("maSP"));
				sp.setTenSP(rs.getString("tenSP"));
				sp.setHopDong(new HopDong());

				CongDoan cd = new CongDoan();
				cd.setMaCD(rs.getString("maCD"));
				cd.setTenCD(rs.getString("tenCD"));
				cd.setSp(sp);

				CongNhan cn = new CongNhan();
				cn.setMaCN(rs.getString("maCN"));
				cn.setHoTen(rs.getString("hoTen"));

				BangPhanCong pc = new BangPhanCong();
				pc.setCongNhan(cn);
				pc.setCongDoan(cd);
				pc.setNgayPhanCong(rs.getDate("ngayPhanCong"));
				pc.setSoLuongPC(rs.getInt("soLuongPhanCong"));
				pc.setTrangThai(rs.getInt("trangThai"));

				int soLuongLam = rs.getInt("soLuongLam");
				Date ngayCham = rs.getDate("ngayChamCong");
				BangChamCongCongNhan bcccn = new BangChamCongCongNhan(pc, ngayCham, soLuongLam);

				dsCC.add(bcccn);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCC;
	}
	
	public ArrayList<BangChamCongCongNhan> getDanhSachChamCongTheoDieuKien(java.util.Date ngay, Object obj) {
		PreparedStatement sta = null;
		ArrayList<BangChamCongCongNhan> dsCC = new ArrayList<BangChamCongCongNhan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  "
					+ "    cn.maCN, cn.hoTen, cd.maCD, cd.tenCD, sp.maSP, sp.tenSP, pc.ngayPhanCong,  "
					+ "	pc.soLuongPhanCong, pc.trangThai, cc.ngayChamCong, cc.soLuongLam "
					+ "FROM  "
					+ "    BangPhanCong pc "
					+ "LEFT JOIN  "
					+ "    BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD AND cc.ngayChamCong = ? "
					+ "JOIN  "
					+ "    CongNhan cn ON pc.maCN = cn.maCN "
					+ "JOIN "
					+ "	CongDoan cd ON cd.maCD = pc.maCD "
					+ "JOIN "
					+ "	SanPham sp ON sp.maSP = cd.maSP "
					+ "WHERE  "
					+ "    cc.maCN IS NULL "
					+ "    AND cc.maCD IS NULL "
					+ "    AND ";
			int flag = 0;
			if(obj instanceof ToNhom) {
				sql += "cn.maTo = ?";
				flag = 1;
			}
			
			if(obj instanceof CongDoan) {
				sql += "pc.maCD = ?";
				flag = 2;
			}
			sta = con.prepareStatement(sql);
			Date sqlDate = new Date(ngay.getTime());
			sta.setDate(1, sqlDate);
			if(flag == 1) {
				sta.setInt(2, ((ToNhom) obj).getMaTo());
			}
			if(flag == 2) {
				sta.setString(2, ((CongDoan) obj).getMaCD());
			}
			

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {

				SanPham sp = new SanPham();
				sp.setMaSP(rs.getString("maSP"));
				sp.setTenSP(rs.getString("tenSP"));
				sp.setHopDong(new HopDong());

				CongDoan cd = new CongDoan();
				cd.setMaCD(rs.getString("maCD"));
				cd.setTenCD(rs.getString("tenCD"));
				cd.setSp(sp);

				CongNhan cn = new CongNhan();
				cn.setMaCN(rs.getString("maCN"));
				cn.setHoTen(rs.getString("hoTen"));

				BangPhanCong pc = new BangPhanCong();
				pc.setCongNhan(cn);
				pc.setCongDoan(cd);
				pc.setNgayPhanCong(rs.getDate("ngayPhanCong"));
				pc.setSoLuongPC(rs.getInt("soLuongPhanCong"));
				pc.setTrangThai(rs.getInt("trangThai"));

				int soLuongLam = rs.getInt("soLuongLam");
				Date ngayCham = rs.getDate("ngayChamCong");
				BangChamCongCongNhan bcccn = new BangChamCongCongNhan(pc, ngayCham, soLuongLam);

				dsCC.add(bcccn);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCC;
	}
	
	public ArrayList<BangChamCongCongNhan> getDanhSachChamCongTheoNgay_CongDoan_To(java.util.Date ngay, ToNhom to, CongDoan CD) {
		PreparedStatement sta = null;
		ArrayList<BangChamCongCongNhan> dsCC = new ArrayList<BangChamCongCongNhan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  "
					+ "    cn.maCN, cn.hoTen, cd.maCD, cd.tenCD, sp.maSP, sp.tenSP, pc.ngayPhanCong,  "
					+ "	pc.soLuongPhanCong, pc.trangThai, cc.ngayChamCong, cc.soLuongLam "
					+ "FROM  "
					+ "    BangPhanCong pc "
					+ "LEFT JOIN  "
					+ "    BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD AND cc.ngayChamCong = ? "
					+ "JOIN  "
					+ "    CongNhan cn ON pc.maCN = cn.maCN "
					+ "JOIN "
					+ "	CongDoan cd ON cd.maCD = pc.maCD "
					+ "JOIN "
					+ "	SanPham sp ON sp.maSP = cd.maSP "
					+ "WHERE  "
					+ "    cc.maCN IS NULL "
					+ "    AND cc.maCD IS NULL "
					+ "    AND cn.maTo = ? "
					+ "    AND pc.maCD = ?";
			sta = con.prepareStatement(sql);
			Date sqlDate = new Date(ngay.getTime());
			sta.setDate(1, sqlDate);
			sta.setInt(2, to.getMaTo());
			sta.setString(3, CD.getMaCD());

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {

				SanPham sp = new SanPham();
				sp.setMaSP(rs.getString("maSP"));
				sp.setTenSP(rs.getString("tenSP"));
				sp.setHopDong(new HopDong());

				CongDoan cd = new CongDoan();
				cd.setMaCD(rs.getString("maCD"));
				cd.setTenCD(rs.getString("tenCD"));
				cd.setSp(sp);

				CongNhan cn = new CongNhan();
				cn.setMaCN(rs.getString("maCN"));
				cn.setHoTen(rs.getString("hoTen"));

				BangPhanCong pc = new BangPhanCong();
				pc.setCongNhan(cn);
				pc.setCongDoan(cd);
				pc.setNgayPhanCong(rs.getDate("ngayPhanCong"));
				pc.setSoLuongPC(rs.getInt("soLuongPhanCong"));
				pc.setTrangThai(rs.getInt("trangThai"));

				int soLuongLam = rs.getInt("soLuongLam");
				Date ngayCham = rs.getDate("ngayChamCong");
				BangChamCongCongNhan bcccn = new BangChamCongCongNhan(pc, ngayCham, soLuongLam);

				dsCC.add(bcccn);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCC;
	}
	
	public ArrayList<BangChamCongCongNhan> getDanhSachDaChamCongTheoNgay(java.util.Date ngay) {
		PreparedStatement sta = null;
		ArrayList<BangChamCongCongNhan> dsCC = new ArrayList<BangChamCongCongNhan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT  "
					+ "    cn.maCN, cn.hoTen, cd.maCD, cd.tenCD, sp.maSP, sp.tenSP, pc.ngayPhanCong,  "
					+ "	pc.soLuongPhanCong, pc.trangThai, cc.ngayChamCong, cc.soLuongLam "
					+ "FROM  "
					+ "    BangPhanCong pc "
					+ "JOIN  "
					+ "    BangChamCongCongNhan cc ON pc.maCN = cc.maCN AND pc.maCD = cc.maCD "
					+ "JOIN  "
					+ "    CongNhan cn ON pc.maCN = cn.maCN "
					+ "JOIN "
					+ "	CongDoan cd ON cd.maCD = pc.maCD "
					+ "JOIN "
					+ "	SanPham sp ON sp.maSP = cd.maSP "
					+ "WHERE  "
					+ "    cc.ngayChamCong = ?";
			sta = con.prepareStatement(sql);
			Date sqlDate = new Date(ngay.getTime());
			sta.setDate(1, sqlDate);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {

				SanPham sp = new SanPham();
				sp.setMaSP(rs.getString("maSP"));
				sp.setTenSP(rs.getString("tenSP"));
				sp.setHopDong(new HopDong());

				CongDoan cd = new CongDoan();
				cd.setMaCD(rs.getString("maCD"));
				cd.setTenCD(rs.getString("tenCD"));
				cd.setSp(sp);

				CongNhan cn = new CongNhan();
				cn.setMaCN(rs.getString("maCN"));
				cn.setHoTen(rs.getString("hoTen"));

				BangPhanCong pc = new BangPhanCong();
				pc.setCongNhan(cn);
				pc.setCongDoan(cd);
				pc.setNgayPhanCong(rs.getDate("ngayPhanCong"));
				pc.setSoLuongPC(rs.getInt("soLuongPhanCong"));
				pc.setTrangThai(rs.getInt("trangThai"));

				int soLuongLam = rs.getInt("soLuongLam");
				Date ngayCham = rs.getDate("ngayChamCong");
				BangChamCongCongNhan bcccn = new BangChamCongCongNhan(pc, ngayCham, soLuongLam);

				dsCC.add(bcccn);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCC;
	}

	public boolean them(BangChamCongCongNhan bchamcong) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into BangChamCongCongNhan values(?,?,?,?)";
			sta = con.prepareStatement(sql);

			sta.setString(1, bchamcong.getPhanCong().getCongNhan().getMaCN());
			sta.setString(2, bchamcong.getPhanCong().getCongDoan().getMaCD());
			Date date = new Date(bchamcong.getNgayCham().getTime());
			sta.setDate(3, date);
			sta.setInt(4, bchamcong.getSoLuongLam());

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

	public boolean capNhat(BangChamCongCongNhan bchamcong) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update BangChamCongCongNhan set soLuongLam = ? where maCN = ? and maCD = ? and ngayChamCong = ?";
			sta = con.prepareStatement(sql);

			sta.setInt(1, bchamcong.getSoLuongLam());
			sta.setString(2, bchamcong.getPhanCong().getCongNhan().getMaCN());
			sta.setString(3, bchamcong.getPhanCong().getCongDoan().getMaCD());
			Date sqlDateNgayCham = new Date(bchamcong.getNgayCham().getTime());
			sta.setDate(4, sqlDateNgayCham);

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
	public BangChamCongCongNhan timTheoMaCNVaNgay(String ngay) {
		BangChamCongCongNhan bcccn = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from BangChamCongCongNhan where and ngayChamCong = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, ngay);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maCN = rs.getString("macn");
				CongNhan cn1 = new CongNhan(maCN);
				String maCD = rs.getString("maCD");
				CongDoan cd = new CongDoan(maCD);
				Date ngayChamCong = rs.getDate("ngayChamCong");
				int soLuongLam = rs.getInt("soLuongLam");
				BangPhanCong bpc = new BangPhanCong(cn1,cd);

				bcccn = new BangChamCongCongNhan(bpc,ngayChamCong,soLuongLam);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bcccn;
	}
	//Nguyễn Tuấn Hùng
	public ArrayList<CongNhan> getDanhSachTinhLuongTheoThangNam(int thang, int nam) {
		PreparedStatement sta = null;
		ArrayList<CongNhan> dscn = new ArrayList<CongNhan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT "
					+ "    bcc.maCN, "
					+ "    cn.hoTen, "
					+ "    cn.phuCap, "
					+ "    SUM(cd.gia * bcc.soLuongLam) + cn.phuCap AS TongLuong   "
					+ "FROM "
					+ "    BangChamCongCongNhan bcc "
					+ "JOIN "
					+ "    CongDoan cd ON bcc.maCD = cd.maCD "
					+ "JOIN "
					+ "    CongNhan cn ON bcc.maCN = cn.maCN "
					+ "WHERE "
					+ "    MONTH(bcc.ngayChamCong) = ? AND YEAR(bcc.ngayChamCong) = ? "
					+ "GROUP BY "
					+ "    bcc.maCN, cn.hoTen, cn.phuCap;";
			sta = con.prepareStatement(sql);
			sta.setInt(1, thang);
			sta.setInt(2, nam);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				CongNhan cn = new CongNhan();
				cn.setMaCN(rs.getString("maCN"));
				cn.setHoTen(rs.getString("hoTen"));
				cn.setPhuCap(rs.getFloat("phuCap"));
				cn.setGhiChu(rs.getString("TongLuong"));
				dscn.add(cn);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscn;
	}
	public ArrayList<CongNhan> getDanhSachTinhLuongTheoNgayVaMa(String ma, int thang, int nam) {
		PreparedStatement sta = null;
		ArrayList<CongNhan> dscn = new ArrayList<CongNhan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select bcc.maCN, cn.hoTen, sum(cd.gia*bcc.soLuongLam) + cn.phuCap as TongLuong from BangChamCongCongNhan bcc join CongDoan cd on bcc.maCD = cd.maCD"
					+" join CongNhan cn on bcc.maCN = cn.maCN"
					+" where bcc.maCN like ? and MONTH(bcc.ngayChamCong) = ? and YEAR(bcc.ngayChamCong) = ?"
					+" group by bcc.maCN, cn.hoTen, cn.phuCap";
			sta = con.prepareStatement(sql);
			sta.setInt(2, thang);
			sta.setInt(3, nam);
			String maTim = "%" + ma +"%";
			sta.setString(1, maTim);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {


				CongNhan cn = new CongNhan();
				cn.setMaCN(rs.getString("maCN"));
				cn.setHoTen(rs.getString("hoTen"));
				cn.setGhiChu(rs.getString("TongLuong"));
				dscn.add(cn);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscn;
	}
}
