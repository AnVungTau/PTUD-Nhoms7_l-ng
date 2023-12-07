package util;

public class QuanLyMaLuongNhanVien {

    public String generateMaLuong(String maNhanVien, int thang, int nam) {
        try {
            // Tạo mã lương từ mã nhân viên, tháng và năm
            String formattedThang = String.format("%02d", thang);
            String maLuong = maNhanVien + "T" + formattedThang + "N" + nam;
            return maLuong;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}