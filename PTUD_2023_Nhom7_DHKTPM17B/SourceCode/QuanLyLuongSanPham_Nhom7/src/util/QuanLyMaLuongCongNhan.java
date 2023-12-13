package util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class QuanLyMaLuongCongNhan {
	 public String generateMaLuong(String maCongNhan, Date ngayChamCong) {
	        try {
	            // Chuyển định dạng ngày thành chuỗi có dạng "yyyyMMdd"
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	            String formattedNgayChamCong = dateFormat.format(ngayChamCong);

	            // Tạo mã lương từ mã công nhân và ngày chấm công
	            String maLuong = maCongNhan + "D" + formattedNgayChamCong;
	            return maLuong;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}
