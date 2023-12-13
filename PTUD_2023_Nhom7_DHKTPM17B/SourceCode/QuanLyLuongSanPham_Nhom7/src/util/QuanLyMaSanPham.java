package util;

import dao.SanPham_DAO;
/**
 * @author Trần Vũ Minh Nhật
 */
public class QuanLyMaSanPham {
    public String generateMaSanPham() {
        try {
            SanPham_DAO sanPhamDAO = new SanPham_DAO();
            int maxCode = 0;
            for (String code : sanPhamDAO.getDanhSachMaSanPham()) {
                int codeNumber = Integer.parseInt(code.substring(2));
                if (codeNumber > maxCode) {
                    maxCode = codeNumber;
                }
            }

            // Tạo mã mới
            int newCodeNumber = maxCode + 1;
            return "SP" + String.format("%06d", newCodeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
