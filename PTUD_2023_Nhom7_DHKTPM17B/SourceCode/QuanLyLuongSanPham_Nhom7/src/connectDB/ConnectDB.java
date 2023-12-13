package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/**
 * @author Nguyễn Hồng Quân
 */
public class ConnectDB {
	public static Connection con = null;
	private static ConnectDB instance = new ConnectDB();
	public static ConnectDB getInstance() throws SQLException {
		instance.connect();
		return instance;
	}
	public void connect(){
		try {
			String url = "jdbc:sqlserver://localhost:1433;databasename=PTUD_2023_Nhom7_DHKTPM17B_SALAR";
			String user = "sa";
			String password = "sapassword";
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi kết nối database");
			e.printStackTrace();
		}
	}
	public void disconnect() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection() {
		return con;
	}
}