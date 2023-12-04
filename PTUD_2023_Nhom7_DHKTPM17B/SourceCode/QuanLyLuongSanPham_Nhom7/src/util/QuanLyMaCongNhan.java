package util;

import dao.CongNhan_DAO;

/**
 * @author Nguyễn Thành An
 */

public class QuanLyMaCongNhan {
	public String generateMaNhanVien() {
		try {
			CongNhan_DAO congNhan_DAO = new CongNhan_DAO();
			int maxCode = 0;
			for (String code : congNhan_DAO.getDanhSachMaCongNhan()) {
				int codeNumber = Integer.parseInt(code.substring(2));
	            if (codeNumber > maxCode) {
	                maxCode = codeNumber;
	            }
			}
			
			// Tạo mã mới
	        int newCodeNumber = maxCode + 1;
	        return "CN" + String.format("%06d", newCodeNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
