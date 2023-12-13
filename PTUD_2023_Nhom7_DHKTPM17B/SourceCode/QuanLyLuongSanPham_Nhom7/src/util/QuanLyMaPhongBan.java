package util;

import dao.PhongBan_DAO;

public class QuanLyMaPhongBan {
	
    public String generateMaPhongBan() {
        try {
            PhongBan_DAO PhongBanDAO = new PhongBan_DAO();
            int maxCode = 0;
            for (String code : PhongBanDAO.getDanhSachMaPhongBan()) {
                int codeNumber = Integer.parseInt(code.substring(2));
                if (codeNumber > maxCode) {
                    maxCode = codeNumber;
                }
            }
            
            // Tạo mã mới
            int newCodeNumber = maxCode + 1;
            return "PB" + String.format("%03d", newCodeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}