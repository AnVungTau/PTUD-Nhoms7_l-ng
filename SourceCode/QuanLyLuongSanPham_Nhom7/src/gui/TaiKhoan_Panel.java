package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
/**
 * @author	Nguyễn Hồng Quân
 */
public class TaiKhoan_Panel extends JPanel {
	private JTextField textField;
	private JTable tblNhanVien;
	private JTextField txtMaTaiKhoan;
	private JTextField txtTenTaiKhoan;
	private JPasswordField txtMatKhau;
	private JTable table;

	
	public TaiKhoan_Panel() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setPreferredSize(new Dimension(10, 310));
		pnlNorth.setSize(new Dimension(0, 300));
		add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(new Color(255, 255, 255));
		pnlNorth.add(pnlTitle, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("THÔNG TIN TÀI KHOẢN");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnlTitle.add(lblTitle);
		
		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setBackground(new Color(255, 255, 255));
		pnlNorth.add(pnlThongTin, BorderLayout.CENTER);
		pnlThongTin.setLayout(null);
		
		JPanel pnlDanhSachNhanVien = new JPanel();
		pnlDanhSachNhanVien.setBackground(new Color(255, 255, 255));
		pnlDanhSachNhanVien.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachNhanVien.setBounds(45, 0, 408, 236);
		pnlThongTin.add(pnlDanhSachNhanVien);
		pnlDanhSachNhanVien.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTim = new JPanel();
		pnlTim.setBackground(new Color(255, 255, 255));
		pnlTim.setPreferredSize(new Dimension(10, 33));
		pnlDanhSachNhanVien.add(pnlTim, BorderLayout.NORTH);
		pnlTim.setLayout(null);
		
		JLabel lblLoc = new JLabel("Lọc");
		lblLoc.setBounds(10, 5, 31, 20);
		pnlTim.add(lblLoc);
		
		JComboBox cmbLoc = new JComboBox();
		cmbLoc.setBounds(51, 5, 69, 20);
		pnlTim.add(cmbLoc);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(160, 6, 123, 20);
		pnlTim.add(textField);
		
		JButton btnTimNhanVien = new JButton("Tìm");
		btnTimNhanVien.setBounds(293, 5, 85, 21);
		pnlTim.add(btnTimNhanVien);
		
		JPanel pnlTableNhanVien = new JPanel();
		pnlTableNhanVien.setBackground(new Color(255, 255, 255));
		pnlDanhSachNhanVien.add(pnlTableNhanVien, BorderLayout.CENTER);
		pnlTableNhanVien.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		pnlTableNhanVien.add(scrollPane);
		
		String header[] = {"Mã NV", "Họ tên", "Có tài khoản(checked)"};
		DefaultTableModel model = new DefaultTableModel(header, 0);		
		tblNhanVien = new JTable(model);
		tblNhanVien.setFillsViewportHeight(true);
		tblNhanVien.setGridColor(new Color(128, 128, 128));
		tblNhanVien.setSelectionBackground(new Color(128, 255, 255));
		scrollPane.setViewportView(tblNhanVien);
		
		JPanel pnlThongTinTaiKhoan = new JPanel();
		pnlThongTinTaiKhoan.setBackground(new Color(255, 255, 255));
		pnlThongTinTaiKhoan.setBorder(new TitledBorder(null, "Th\u00F4ng tin t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinTaiKhoan.setBounds(540, 0, 396, 236);
		pnlThongTin.add(pnlThongTinTaiKhoan);
		pnlThongTinTaiKhoan.setLayout(null);
		
		JLabel lblMaTaiKhoan = new JLabel("Mã tài khoản");
		lblMaTaiKhoan.setBounds(45, 40, 81, 20);
		pnlThongTinTaiKhoan.add(lblMaTaiKhoan);
		
		JLabel lblTenTaiKhoan = new JLabel("Tên tài khoản");
		lblTenTaiKhoan.setBounds(45, 80, 81, 20);
		pnlThongTinTaiKhoan.add(lblTenTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setBounds(45, 120, 81, 20);
		pnlThongTinTaiKhoan.add(lblMatKhau);
		
		JLabel lblQuyen = new JLabel("Quyền");
		lblQuyen.setBounds(45, 160, 81, 20);
		pnlThongTinTaiKhoan.add(lblQuyen);
		
		txtMaTaiKhoan = new JTextField();
		txtMaTaiKhoan.setEnabled(false);
		txtMaTaiKhoan.setBounds(160, 40, 96, 20);
		pnlThongTinTaiKhoan.add(txtMaTaiKhoan);
		txtMaTaiKhoan.setColumns(10);
		
		txtTenTaiKhoan = new JTextField();
		txtTenTaiKhoan.setBounds(160, 80, 170, 20);
		pnlThongTinTaiKhoan.add(txtTenTaiKhoan);
		txtTenTaiKhoan.setColumns(10);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setEchoChar('*');
		txtMatKhau.setBounds(160, 120, 130, 20);
		pnlThongTinTaiKhoan.add(txtMatKhau);
		
		JComboBox cmbQuyen = new JComboBox();
		cmbQuyen.setBounds(160, 160, 96, 20);
		pnlThongTinTaiKhoan.add(cmbQuyen);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(322, 246, 85, 25);
		pnlThongTin.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(460, 246, 85, 25);
		pnlThongTin.add(btnSua);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(617, 246, 85, 25);
		pnlThongTin.add(btnLamMoi);
		
		JPanel pnlDanhSachTaiKhoan = new JPanel();
		pnlDanhSachTaiKhoan.setBorder(new TitledBorder(null, "Danh s\u00E1ch t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachTaiKhoan.setBackground(new Color(255, 255, 255));
		add(pnlDanhSachTaiKhoan, BorderLayout.CENTER);
		pnlDanhSachTaiKhoan.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(255, 255, 255));
		pnlDanhSachTaiKhoan.add(scrollPane_1);
		
		String headerTaiKhoan[] = {"Mã NV (Mã TK)", "Tên TK", "Mật khẩu", "Quyền"};
		DefaultTableModel modelTaiKhoan = new DefaultTableModel(headerTaiKhoan, 0);		
		table = new JTable(modelTaiKhoan);
		table.setGridColor(new Color(128, 128, 128));
		table.setFillsViewportHeight(true);
		table.setSelectionBackground(new Color(128, 255, 255));
		scrollPane_1.setViewportView(table);

	}
}
