package util;

import dao.HopDong_DAO;
/**
 * @author Nguyễn Tuấn Hùng
 */
public class QuanLyMaHopDong {
    public String generateMaHopDong() {
        try {
            HopDong_DAO hopDongDAO = new HopDong_DAO();
            int maxCode = 0;
            for (String code : hopDongDAO.getDanhSachMaHopDong()) {
                int codeNumber = Integer.parseInt(code.substring(2));
                if (codeNumber > maxCode) {
                    maxCode = codeNumber;
                }
            }

            // Tạo mã mới
            int newCodeNumber = maxCode + 1;
            return "HD" + String.format("%06d", newCodeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
