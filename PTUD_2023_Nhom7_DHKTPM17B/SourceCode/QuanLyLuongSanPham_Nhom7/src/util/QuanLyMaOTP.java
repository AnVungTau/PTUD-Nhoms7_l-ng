package util;

import java.security.SecureRandom;
import dao.OTP_DAO;
/**
 * @author Nguyễn Hồng Quân
 */
public class QuanLyMaOTP {
	
	private static String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
	
	public static String generateUniqueOTP() {
		OTP_DAO otp_dao = new OTP_DAO();
        String otp = null;
        try {
			do {
				otp = generateOTP();
			} while (otp_dao.kiemTraSuTonTaiMaOTP(otp));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return otp;
    }

}
