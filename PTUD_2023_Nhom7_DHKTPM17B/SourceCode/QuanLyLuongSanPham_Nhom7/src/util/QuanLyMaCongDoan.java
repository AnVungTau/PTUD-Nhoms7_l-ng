package util;

import dao.CongDoan_DAO;

public class QuanLyMaCongDoan {
	
    public String generateMaCongDoan() {
        try {
            CongDoan_DAO congDoanDAO = new CongDoan_DAO();
            int maxCode = 0;
            for (String code : congDoanDAO.getDanhSachMaCongDoan()) {
                int codeNumber = Integer.parseInt(code.substring(2));
                if (codeNumber > maxCode) {
                    maxCode = codeNumber;
                }
            }
            
            // Tạo mã mới
            int newCodeNumber = maxCode + 1;
            return "CD" + String.format("%06d", newCodeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
