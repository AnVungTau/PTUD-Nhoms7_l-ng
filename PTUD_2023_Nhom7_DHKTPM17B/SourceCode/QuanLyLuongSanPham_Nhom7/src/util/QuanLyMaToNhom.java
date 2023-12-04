package util;

import dao.ToNhom_DAO;
/**
 * @author Trần Vũ Minh Nhật
 */
public class QuanLyMaToNhom {
    public int generateMaToNhom() {
        try {
            ToNhom_DAO to_dao = new ToNhom_DAO();
            int maxCode = 0;
            for (int code : to_dao.getDanhSachMaToNhom()) {
                if (code > maxCode) {
                    maxCode = code;
                }
            }

            // Tạo mã mới
            int newCodeNumber = maxCode + 1;
            return newCodeNumber;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
