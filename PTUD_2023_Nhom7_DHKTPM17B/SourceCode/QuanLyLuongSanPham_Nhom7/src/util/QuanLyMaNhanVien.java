package util;

import dao.NhanVien_DAO;
/**
 * @author Nguyễn Hồng Quân
 */
public class QuanLyMaNhanVien {
	
	 public String generateMaNhanVien() {
		try {
			NhanVien_DAO nhanvien_dao = new NhanVien_DAO();
			int maxCode = 0;
			for (String code : nhanvien_dao.getDanhSachMaNhanVien()) {
				int codeNumber = Integer.parseInt(code.substring(2));
	            if (codeNumber > maxCode) {
	                maxCode = codeNumber;
	            }
			}
			
			// Tạo mã mới
	        int newCodeNumber = maxCode + 1;
	        return "NV" + String.format("%06d", newCodeNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
