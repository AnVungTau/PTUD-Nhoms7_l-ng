package util;

import entity.TaiKhoan;

public class Keycode {
	private static TaiKhoan taiKhoan;

	public static TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public static void setTaiKhoan(TaiKhoan taiKhoan) {
		Keycode.taiKhoan = taiKhoan;
	}

}
