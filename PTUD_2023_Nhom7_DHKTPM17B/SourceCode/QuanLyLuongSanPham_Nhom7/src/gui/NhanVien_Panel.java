package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultFormatter;
import com.toedter.calendar.JDateChooser;
import dao.DiaChi_DAO;
import dao.NhanVien_DAO;
import dao.PhongBan_DAO;
import entity.DiaChi;
import entity.NhanVien;
import entity.PhongBan;
import util.QuanLyMaNhanVien;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.Calendar;
import javax.swing.SwingConstants;
import java.awt.Insets;

/**
 * @author Nguyễn Hồng Quân
 */
public class NhanVien_Panel extends JPanel
		implements ItemListener, ActionListener, PropertyChangeListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtDienThoai;
	private JTextField txtCMND;
	private JTextField txtTen;
	private JTextField txtEmail;
	private JTextField txtHSL;
	private JTextField txtTim;
	private JComboBox<DiaChi> cmbQuan;
	private JComboBox<DiaChi> cmbPhuong;
	private JComboBox<DiaChi> cmbTinh;
	private JComboBox<PhongBan> cmbPhongBan;
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnLamMoi;
	private JTextArea txtGhiChu;
	private JButton btnTim;
	private JDateChooser dateNgaySinh;
	private JDateChooser dateNgayVao;
	private JCheckBox chkGioiTinh;
	private JComboBox<String> cmbChucVu;
	private JSpinner spnPhuCap;
	private JComboBox<String> cmbTrinhDo;
	private JTable tblNhanVien;
	private DefaultTableModel model;
	private JLabel lblTBNgaySinh;
	private JLabel lblTBNgayVao;
	private JLabel lblTBTen;
	private JLabel lblTBCMND;
	private JLabel lblTBDienThoai;
	private JLabel lblTBEmail;
	private PhongBan_DAO phongBan_dao = new PhongBan_DAO();
	private DiaChi_DAO diaChi_dao = new DiaChi_DAO();
	private NhanVien_DAO nhanVien_dao = new NhanVien_DAO();
	private JComboBox<String> cmbTim;
	private JButton btnReLoad;
	private JTextArea txtDiaChi;
	private URL urlTim = NhanVien_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
	private URL urlThem = NhanVien_Panel.class.getResource("/img/Custom-Icon-Design-Flatastic-1-Add-1.24.png");
	private URL urlLamMoi = NhanVien_Panel.class.getResource("/img/Hopstarter-Button-Button-Reload.24.png");
	private URL urlLuu = NhanVien_Panel.class.getResource("/img/Oxygen-Icons.org-Oxygen-Actions-document-save.24.png");
	private URL urlTBFail = NhanVien_Panel.class.getResource("/img/Saki-NuoveXT-Actions-button-cancel.16.png");
	private URL urlTBSuccess = NhanVien_Panel.class.getResource("/img/Custom-Icon-Design-Pretty-Office-8-Accept.16.png");
	
	public NhanVien_Panel() {
		setSize(new Dimension(1300, 750));
		setBackground(new Color(240, 240, 240));
		setLayout(new BorderLayout());

		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(new Color(255, 255, 255));
		pnlTop.setPreferredSize(new Dimension(1000, 270));
		pnlTop.setSize(new Dimension(1000, 270));
		pnlTop.setMinimumSize(new Dimension(1000, 200));
		add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(null);

		lblTBNgaySinh = new JLabel("");
		lblTBNgaySinh.setIcon(new ImageIcon(urlTBFail));
		lblTBNgaySinh.setBackground(new Color(255, 255, 255));
		lblTBNgaySinh.setBounds(346, 80, 25, 25);
		pnlTop.add(lblTBNgaySinh);

		JLabel lblMa = new JLabel("Mã nhân viên");
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMa.setBounds(65, 20, 81, 25);
		pnlTop.add(lblMa);

		JLabel lblTen = new JLabel("Họ tên");
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTen.setBounds(65, 50, 45, 25);
		pnlTop.add(lblTen);

		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMa.setEnabled(false);
		txtMa.setText("");
		txtMa.setBounds(156, 20, 150, 25);
		pnlTop.add(txtMa);
		txtMa.setColumns(10);

		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgaySinh.setBounds(65, 80, 68, 25);
		pnlTop.add(lblNgaySinh);

		txtDienThoai = new JTextField();
		txtDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDienThoai.setBounds(156, 170, 150, 25);
		pnlTop.add(txtDienThoai);
		txtDienThoai.setColumns(10);
		txtDienThoai.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				btnThem.setEnabled(validData());
				btnLuu.setEnabled(validData());
				if (validDataDienThoai()) {
					lblTBDienThoai.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBDienThoai.setIcon(new ImageIcon(urlTBFail));
				}

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				btnThem.setEnabled(validData());
				btnLuu.setEnabled(validData());
				if (validDataDienThoai()) {
					lblTBDienThoai.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBDienThoai.setIcon(new ImageIcon(urlTBFail));
				}

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setBounds(65, 110, 68, 25);
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnlTop.add(lblGioiTinh);

		chkGioiTinh = new JCheckBox("Nam");
		chkGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chkGioiTinh.setBackground(new Color(255, 255, 255));
		chkGioiTinh.setSelected(true);
		chkGioiTinh.setBounds(156, 110, 93, 25);
		pnlTop.add(chkGioiTinh);

		JLabel lblCMND = new JLabel("CMND");
		lblCMND.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCMND.setBounds(65, 140, 45, 25);
		pnlTop.add(lblCMND);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCMND.setBounds(156, 140, 150, 25);
		pnlTop.add(txtCMND);
		txtCMND.setColumns(10);

		JLabel lblDienThoai = new JLabel("Điện thoại");
		lblDienThoai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDienThoai.setBounds(65, 170, 65, 25);
		pnlTop.add(lblDienThoai);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(512, 20, 45, 25);
		pnlTop.add(lblEmail);

		JLabel lblTinh = new JLabel("Tỉnh/TP");
		lblTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTinh.setBounds(512, 50, 75, 25);
		pnlTop.add(lblTinh);

		JLabel lblQuan = new JLabel("Quận/Huyện");
		lblQuan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuan.setBounds(512, 80, 106, 25);
		pnlTop.add(lblQuan);

		JLabel lblXa = new JLabel("Phường/Xã");
		lblXa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblXa.setBounds(512, 110, 106, 25);
		pnlTop.add(lblXa);

		cmbTinh = new JComboBox<DiaChi>();
		cmbTinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTinh.setBounds(628, 50, 150, 25);
		pnlTop.add(cmbTinh);
		LoadDiaChi(cmbTinh, diaChi_dao.getDiaChiTheoCap(1)); // Lấy 63 tỉnh thành từ database

		cmbQuan = new JComboBox<DiaChi>();
		cmbQuan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbQuan.setBounds(628, 80, 150, 25);
		DiaChi tinhSelected = (DiaChi) cmbTinh.getSelectedItem();
		if (tinhSelected != null) {
			int tinhID = (int) tinhSelected.getId();
			LoadDiaChi(cmbQuan, diaChi_dao.getDiaChiTheoParentID(tinhID));
		}
		pnlTop.add(cmbQuan);

		cmbPhuong = new JComboBox<DiaChi>();
		cmbPhuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbPhuong.setBounds(628, 110, 150, 25);
		DiaChi xaSelected = (DiaChi) cmbQuan.getSelectedItem();
		if (xaSelected != null) {
			int xaID = (int) xaSelected.getId();
			LoadDiaChi(cmbPhuong, diaChi_dao.getDiaChiTheoParentID(xaID));
		}
		pnlTop.add(cmbPhuong);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTen.setBounds(156, 50, 180, 25);
		pnlTop.add(txtTen);
		txtTen.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setBounds(628, 20, 150, 25);
		pnlTop.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblTrinhDo = new JLabel("Trình độ");
		lblTrinhDo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTrinhDo.setBounds(949, 20, 75, 25);
		pnlTop.add(lblTrinhDo);

		JLabel lblHSL = new JLabel("Hệ số lương");
		lblHSL.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHSL.setBounds(949, 50, 75, 25);
		pnlTop.add(lblHSL);

		JLabel lblNgayVao = new JLabel("Ngày vào làm");
		lblNgayVao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayVao.setBounds(949, 80, 106, 25);
		pnlTop.add(lblNgayVao);

		JLabel lblPhongBan = new JLabel("Phòng ban");
		lblPhongBan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhongBan.setBounds(949, 110, 75, 25);
		pnlTop.add(lblPhongBan);

		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChucVu.setBounds(949, 140, 75, 25);
		pnlTop.add(lblChucVu);

		JLabel lblGhiChu = new JLabel("Ghi chú");
		lblGhiChu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGhiChu.setBounds(949, 170, 45, 25);
		pnlTop.add(lblGhiChu);

		txtGhiChu = new JTextArea();
		txtGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtGhiChu.setRows(5);
		txtGhiChu.setColumns(10);
		txtGhiChu.setBounds(1065, 170, 150, 70);
		txtGhiChu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlTop.add(txtGhiChu);

		txtHSL = new JTextField();
		txtHSL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHSL.setText(1.65 + "");
		txtHSL.setEnabled(false);
		txtHSL.setDisabledTextColor(new Color(0, 0, 0));
		txtHSL.setHorizontalAlignment(SwingConstants.CENTER);
		txtHSL.setBounds(1065, 50, 150, 25);
		pnlTop.add(txtHSL);
		txtHSL.setColumns(10);

		cmbPhongBan = new JComboBox<PhongBan>();
		cmbPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbPhongBan.setBounds(1065, 110, 150, 25);
		LoadPhongBan(phongBan_dao.getAllPhongBan());
		pnlTop.add(cmbPhongBan);

		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(255, 255, 255));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setIcon(new ImageIcon(urlThem));
		btnThem.setBounds(437, 230, 120, 30);
		pnlTop.add(btnThem);

		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setBackground(new Color(255, 255, 255));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setIcon(new ImageIcon(urlLuu));
		btnLuu.setBounds(572, 230, 120, 30);
		pnlTop.add(btnLuu);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(new Color(255, 255, 255));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setIcon(new ImageIcon(urlLamMoi));
		btnLamMoi.setBounds(702, 230, 120, 30);
		pnlTop.add(btnLamMoi);

		dateNgaySinh = new JDateChooser();
		dateNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateNgaySinh.setLocale(new Locale("vi", "VN"));
		dateNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateNgaySinh.setBounds(156, 80, 150, 25);
		pnlTop.add(dateNgaySinh);

		dateNgayVao = new JDateChooser();
		dateNgayVao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateNgayVao.setLocale(new Locale("vi", "VN"));
		dateNgayVao.setDateFormatString("dd/MM/yyyy");
		dateNgayVao.setBounds(1065, 80, 150, 25);
		pnlTop.add(dateNgayVao);

		cmbChucVu = new JComboBox<String>();
		cmbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbChucVu.addItem("Kế toán");
		cmbChucVu.addItem("Quản lý nhân sự");
		cmbChucVu.addItem("Quản lý dự án");
		cmbChucVu.addItem("Tổ trưởng");
		cmbChucVu.setBounds(1065, 140, 150, 25);
		pnlTop.add(cmbChucVu);

		JLabel lblPhuCap = new JLabel("Phụ cấp (VND)");
		lblPhuCap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhuCap.setBounds(512, 180, 106, 25);
		pnlTop.add(lblPhuCap);

		spnPhuCap = new JSpinner();
		spnPhuCap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnPhuCap.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), Float.valueOf(1000000),
				Float.valueOf(50000)));
		spnPhuCap.setBounds(628, 180, 150, 25);
		customJSpiner(spnPhuCap);
		pnlTop.add(spnPhuCap);

		cmbTrinhDo = new JComboBox<String>();
		cmbTrinhDo.setModel(new DefaultComboBoxModel<String>(new String[] { "12/12", "Cao đẳng/Đại học" }));
		cmbTrinhDo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTrinhDo.setBounds(1065, 20, 150, 25);
		pnlTop.add(cmbTrinhDo);

		lblTBNgayVao = new JLabel("");
		lblTBNgayVao.setIcon(new ImageIcon(urlTBFail));
		lblTBNgayVao.setBackground(Color.WHITE);
		lblTBNgayVao.setBounds(1225, 80, 25, 25);
		pnlTop.add(lblTBNgayVao);

		lblTBTen = new JLabel("");
		lblTBTen.setIcon(new ImageIcon(urlTBFail));
		lblTBTen.setBackground(Color.WHITE);
		lblTBTen.setBounds(346, 50, 25, 25);
		pnlTop.add(lblTBTen);

		lblTBCMND = new JLabel("");
		lblTBCMND.setIcon(new ImageIcon(urlTBFail));
		lblTBCMND.setBackground(Color.WHITE);
		lblTBCMND.setBounds(346, 140, 25, 25);
		pnlTop.add(lblTBCMND);

		lblTBDienThoai = new JLabel("");
		lblTBDienThoai.setIcon(new ImageIcon(urlTBFail));
		lblTBDienThoai.setBackground(Color.WHITE);
		lblTBDienThoai.setBounds(346, 170, 25, 25);
		pnlTop.add(lblTBDienThoai);

		lblTBEmail = new JLabel("");
		lblTBEmail.setIcon(new ImageIcon(urlTBFail));
		lblTBEmail.setBackground(Color.WHITE);
		lblTBEmail.setBounds(788, 20, 25, 25);
		pnlTop.add(lblTBEmail);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaChi.setBounds(512, 140, 90, 25);
		pnlTop.add(lblDiaChi);

		txtDiaChi = new JTextArea();
		txtDiaChi.setMargin(new Insets(2, 5, 2, 2));
		txtDiaChi.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtDiaChi.setWrapStyleWord(true);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiaChi.setLineWrap(true);
		txtDiaChi.setBounds(628, 140, 150, 35);
		pnlTop.add(txtDiaChi);

		JPanel pnlDanhSach = new JPanel();
		pnlDanhSach.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlDanhSach.setBackground(new Color(255, 255, 255));
		add(pnlDanhSach, BorderLayout.CENTER);
		pnlDanhSach.setLayout(new BorderLayout(0, 0));

		JPanel pnlTim = new JPanel();
		pnlTim.setBackground(new Color(255, 255, 255));
		pnlTim.setPreferredSize(new Dimension(10, 35));
		pnlTim.setSize(new Dimension(0, 100));
		pnlDanhSach.add(pnlTim, BorderLayout.NORTH);
		pnlTim.setLayout(null);

		btnTim = new JButton("");
		btnTim.setBackground(new Color(255, 255, 255));
		btnTim.setBorderPainted(false);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTim.setIcon(new ImageIcon(urlTim));
		btnTim.setBounds(509, 5, 25, 25);
		pnlTim.add(btnTim);

		txtTim = new JTextField();
		txtTim.setColumns(10);
		txtTim.setBounds(279, 5, 220, 25);
		pnlTim.add(txtTim);

		cmbTim = new JComboBox<String>();
		cmbTim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTim.setModel(new DefaultComboBoxModel<String>(new String[] {"Mã nhân viên", "Tên nhân viên", "Tên phòng ban"}));
		cmbTim.setBounds(80, 5, 150, 25);
		pnlTim.add(cmbTim);

		JLabel lblTim = new JLabel("Tìm theo");
		lblTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTim.setBounds(10, 5, 60, 25);
		pnlTim.add(lblTim);

		btnReLoad = new JButton("");
		btnReLoad.setBorderPainted(false);
		btnReLoad.setIcon(new ImageIcon(urlLamMoi));
		btnReLoad.setBackground(new Color(255, 255, 255));
		btnReLoad.setBounds(240, 5, 25, 25);
		pnlTim.add(btnReLoad);

		JPanel pnlTable = new JPanel();
		pnlTable.setBackground(new Color(255, 255, 255));
		pnlDanhSach.add(pnlTable, BorderLayout.CENTER);

		String header[] = { "Mã NV", "Họ tên", "Ngày vào làm", "Phòng ban", "Chức vụ", "HSL" };
		model = new DefaultTableModel(header, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		pnlTable.setLayout(new BorderLayout(0, 0));

		tblNhanVien = new JTable(model);
		tblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblNhanVien.setRowHeight(20);
		tblNhanVien.setFillsViewportHeight(true);
		tblNhanVien.setPreferredScrollableViewportSize(new Dimension(800, 260));
		tblNhanVien.setSelectionBackground(new Color(0, 128, 255));
		tblNhanVien.setSelectionForeground(new Color(255, 255, 255));
		tblNhanVien.setGridColor(new Color(0, 0, 0));
		tblNhanVien.setBackground(new Color(255, 255, 255));

		JScrollPane scrollPane = new JScrollPane(tblNhanVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(950, 200));
		scrollPane.setBackground(new Color(255, 255, 255));
		pnlTable.add(scrollPane);

		txtTen.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				btnThem.setEnabled(validData());
				btnLuu.setEnabled(validData());
				if (valiDataHoTen()) {
					lblTBTen.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBTen.setIcon(new ImageIcon(urlTBFail));
				}

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				btnThem.setEnabled(validData());
				btnLuu.setEnabled(validData());
				if (valiDataHoTen()) {
					lblTBTen.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBTen.setIcon(new ImageIcon(urlTBFail));
				}

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		txtCMND.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				btnThem.setEnabled(validData());
				btnLuu.setEnabled(validData());
				if (validDataCMND()) {
					lblTBCMND.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBCMND.setIcon(new ImageIcon(urlTBFail));
				}

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				btnThem.setEnabled(validData());
				btnLuu.setEnabled(validData());
				if (validDataCMND()) {
					lblTBCMND.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBCMND.setIcon(new ImageIcon(urlTBFail));
				}

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		txtEmail.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				btnThem.setEnabled(validData());
				btnLuu.setEnabled(validData());
				if (validDataEmail()) {
					lblTBEmail.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBEmail.setIcon(new ImageIcon(urlTBFail));
				}

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				btnThem.setEnabled(validData());
				btnLuu.setEnabled(validData());
				if (validDataEmail()) {
					lblTBEmail.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBEmail.setIcon(new ImageIcon(urlTBFail));
				}

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		LoadDanhSachNhanVien(nhanVien_dao.getAllNhanVien());
		showDiaChi();

		cmbTinh.addItemListener(this);
		cmbQuan.addItemListener(this);
		cmbPhuong.addItemListener(this);
		cmbTrinhDo.addItemListener(this);
		cmbTim.addItemListener(this);

		btnTim.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnReLoad.addActionListener(this);
		btnLuu.addActionListener(this);
		btnThem.addActionListener(this);

		dateNgaySinh.addPropertyChangeListener(this);
		dateNgayVao.addPropertyChangeListener(this);

		tblNhanVien.addMouseListener(this);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		tblNhanVien.setRowSorter(sorter);

	}

	private void customJSpiner(JSpinner X) {
		JComponent editor = X.getEditor();
		if (editor instanceof JSpinner.DefaultEditor) {
			JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
			DefaultFormatter formatter = (DefaultFormatter) textField.getFormatter();
			formatter.setOverwriteMode(true);
			textField.setHorizontalAlignment(JTextField.CENTER);
		}
	}

	private void LoadDiaChi(JComboBox<DiaChi> cmb, ArrayList<DiaChi> ar) {
		cmb.removeAllItems();
		for (DiaChi diaChi : ar) {
			cmb.addItem(diaChi);
		}
	}

	private void LoadPhongBan(ArrayList<PhongBan> ar) {
		cmbPhongBan.removeAllItems();
		for (PhongBan phongBan : ar) {
			cmbPhongBan.addItem(phongBan);
		}
	}

	private void clearTable() {
		int r = tblNhanVien.getRowCount();
		while (r > 0) {
			model.removeRow(r - 1);
			r--;
		}
	}

	private void LoadDanhSachNhanVien(ArrayList<NhanVien> dsNV) {
		clearTable();
		for (NhanVien nv : dsNV) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			model.addRow(new Object[] { nv.getMaNV(), nv.getHoTen(), sdf.format(nv.getNgayVaoLam()),
					nv.getPhongBan().getTenPhong(), nv.getChucVu(), nv.getHeSoLuong() });
		}
	}

	private boolean valiDataHoTen() {
		String hoten = txtTen.getText().trim();
		if (hoten.isEmpty()) {
			return false;
		}
		return true;
	}

	private boolean validDataNgaySinh() {
		if (dateNgaySinh.getDate() == null) {
			return false;
		}
		Date ngaySinh = (Date) dateNgaySinh.getDate();
		Calendar currentDate = Calendar.getInstance();
		// Tạo một Calendar từ ngày sinh
		Calendar birthCalendar = Calendar.getInstance();
		birthCalendar.setTime(ngaySinh);

		int age = currentDate.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
		// Kiểm tra xem ngày sinh đã qua sinh nhật chưa
		if (currentDate.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
			age--;
		}
		// Kiểm tra xem tuổi có lớn hơn hoặc bằng 18 hay không
		return age >= 18;
	}

	private boolean validDataCMND() {
		String cmnd = txtCMND.getText().trim();
		if (!cmnd.matches("\\d{12}")) {
			return false;
		}
		return true;
	}

	private boolean validDataDienThoai() {
		String dt = txtDienThoai.getText().trim();
		if (!dt.matches(
				"^(083|084|085|081|082|032|033|034|035|036|037|038|039|070|079|077|076|078|056|058|059)\\d{7}$")) {
			return false;
		}
		return true;
	}

	private boolean validDataEmail() {
		String email = txtEmail.getText().trim();
		if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			return false;
		}
		return true;
	}

	private boolean validDataNgayVaoLam() {
		if (dateNgayVao.getDate() == null) {
			return false;
		}
		Calendar currentDate = Calendar.getInstance();
		Calendar ngayVaoLam = Calendar.getInstance();
		ngayVaoLam.setTime(dateNgayVao.getDate());

		// So sánh ngày được chọn với ngày hiện tại
		return ngayVaoLam.before(currentDate);
	}

	private boolean validData() {
		if (valiDataHoTen() && validDataNgaySinh() && validDataCMND() && validDataDienThoai() && validDataEmail()
				&& validDataNgayVaoLam()) {
			return true;
		}
		return false;
	}

	private void showDiaChi() {
		DiaChi tinhSelected = (DiaChi) cmbTinh.getSelectedItem();
		DiaChi quanSelected = (DiaChi) cmbQuan.getSelectedItem();
		DiaChi phuongSelected = (DiaChi) cmbPhuong.getSelectedItem();
		String diachi = "";
		diachi += phuongSelected.getTenDC();
		diachi += ", " + quanSelected.getTenDC();
		diachi += ", " + tinhSelected.getTenDC();
		txtDiaChi.setText(diachi);
	}

	private NhanVien revertNhanVienFromFields() {
		NhanVien nv = null;
		try {
			String maNV = txtMa.getText().trim();
			String hoTen = txtTen.getText().trim();
			Date ngaySinh = (Date) dateNgaySinh.getDate();
			int gioiTinh = 1; // Nam
			if (chkGioiTinh.isSelected() == false) {
				gioiTinh = 0; // Nữ
			}
			String cmnd = txtCMND.getText().trim();
			String soDienThoai = txtDienThoai.getText().trim();
			String email = txtEmail.getText().trim();
			String diaChi = cmbPhuong.getSelectedItem().toString() + ", " + cmbQuan.getSelectedItem().toString() + ", "
					+ cmbTinh.getSelectedItem().toString();
			String trinhDo = cmbTrinhDo.getSelectedItem().toString();
			String chucVu = cmbChucVu.getSelectedItem().toString();
			Date ngayVaoLam = (Date) dateNgayVao.getDate();
			int trangThaiTaiKhoan = 0; // mặc định = 0 tương ứng chưa có tài khoản
			String ghiChu = txtGhiChu.getText().trim();
			PhongBan phongBan = (PhongBan) cmbPhongBan.getSelectedItem();
			float heSoLuong = Float.parseFloat(txtHSL.getText().trim());
			float phuCap = (float) spnPhuCap.getValue();
			nv = new NhanVien(maNV, hoTen, ngaySinh, gioiTinh, cmnd, soDienThoai, email, diaChi, trinhDo, chucVu,
					ngayVaoLam, trangThaiTaiKhoan, ghiChu, phongBan, heSoLuong, phuCap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}

	private void themNV() {
		NhanVien nv = revertNhanVienFromFields();
		QuanLyMaNhanVien radomMaNhanVien = new QuanLyMaNhanVien();
		nv.setMaNV(radomMaNhanVien.generateMaNhanVien());

		String err = "";
		boolean checkCMND = nhanVien_dao.kiemTraSuTonTaiDuyNhatCuaCMND(nv.getCmnd());
		if (checkCMND) {
			err += "CMND đã tồn tại!\n";
		}
		boolean checkSoDienThoai = nhanVien_dao.kiemTraSuTonTaiDuyNhatCuaSoDienThoai(nv.getSoDienThoai());
		if (checkSoDienThoai) {
			err += "Số điện thoại đã tồn tại!\n";
		}
		boolean checkEmail = nhanVien_dao.kiemTraSuTonTaiDuyNhatCuaEmail(nv.getEmail());
		if (checkEmail) {
			err += "Email đã tồn tại!";
		}

		if (checkCMND == false && checkSoDienThoai == false && checkEmail == false) {
			if (nhanVien_dao.themNV(nv)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				LoadDanhSachNhanVien(nhanVien_dao.getAllNhanVien());
			} else {
				JOptionPane.showMessageDialog(this, "Trùng mã");
			}
		} else {
			JOptionPane.showMessageDialog(this, err);
		}
	}

	private void suaNV() {
		NhanVien nv = revertNhanVienFromFields();
		int r = tblNhanVien.getSelectedRow();
		if (r < 0) {
			JOptionPane.showMessageDialog(this, "Chọn dòng muốn sửa");
			return;
		}
		nv.setMaNV(tblNhanVien.getValueAt(r, 0).toString());
		String err = "";
		boolean checkCMND = nhanVien_dao.demSoLuongCMND(nv.getCmnd());
		if (checkCMND) {
			err += "CMND đã tồn tại!\n";
		}
		boolean checkSoDienThoai = nhanVien_dao.demSoLuongSoDienThoai(nv.getSoDienThoai());
		if (checkSoDienThoai) {
			err += "Số điện thoại đã tồn tại!\n";
		}
		boolean checkEmail = nhanVien_dao.demSoLuongEmail(nv.getEmail());
		if (checkEmail) {
			err += "Email đã tồn tại!";
		}
		if (checkCMND == false && checkSoDienThoai == false && checkEmail == false) {
			if (nhanVien_dao.suaNV(nv)) {
				LoadDanhSachNhanVien(nhanVien_dao.getAllNhanVien());
			} else {
				JOptionPane.showMessageDialog(this, "Không thể chỉnh sửa");
			}

		} else {
			JOptionPane.showMessageDialog(this, err);
		}
	}

	private void fillForm() {
		int r = tblNhanVien.getSelectedRow();
		if (r < 0) {
			return;
		}
		String maNV = tblNhanVien.getValueAt(r, 0).toString();
		NhanVien nv = new NhanVien(maNV);
		nv = nhanVien_dao.TimMaNhanVien(nv);

		if (nv != null) {
			txtTen.setText(nv.getHoTen());
			dateNgaySinh.setDate(nv.getNgaySinh());
			Boolean gioiTinh = true;
			if (nv.getGioiTinh() == 0) {
				gioiTinh = false;
			}
			chkGioiTinh.setSelected(gioiTinh);
			txtCMND.setText(nv.getCmnd());
			txtDienThoai.setText(nv.getSoDienThoai());
			txtEmail.setText(nv.getEmail());
			txtDiaChi.setText(nv.getDiaChi());
			spnPhuCap.setValue(nv.getPhuCap());
			String td12 = new String("12/12");
			String tdCDDH = new String("Cao đẳng/Đại học");
			if (nv.getTrinhDo().equals(td12)) {
				cmbTrinhDo.setSelectedItem(td12);
			}

			if (nv.getTrinhDo().equals(tdCDDH)) {
				cmbTrinhDo.setSelectedItem(tdCDDH);
			}
			dateNgayVao.setDate(nv.getNgayVaoLam());
			cmbPhongBan.setSelectedItem(nv.getPhongBan());
			String cvQLNS = new String("Quản lý nhân sự");
			String cvKeToan = new String("Kế toán");
			String cvQLDA = new String("Quản lý dự án");
			String cvTT = new String("Tổ trưởng");
			if (nv.getChucVu().equals(cvKeToan)) {
				cmbChucVu.setSelectedItem(cvKeToan);
			}
			if (nv.getChucVu().equals(cvQLNS)) {
				cmbChucVu.setSelectedItem(cvQLNS);
			}
			if (nv.getChucVu().equals(cvQLDA)) {
				cmbChucVu.setSelectedItem(cvQLDA);
			}
			if (nv.getChucVu().equals(cvTT)) {
				cmbChucVu.setSelectedItem(cvTT);
			}
			txtGhiChu.setText(nv.getGhiChu());

		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			Object o = e.getSource();
			if (o.equals(cmbTinh)) {
				showDiaChi();
				DiaChi tinhSelected = (DiaChi) cmbTinh.getSelectedItem();
				if (tinhSelected != null) {
					int tinhID = (int) tinhSelected.getId();
					LoadDiaChi(cmbQuan, diaChi_dao.getDiaChiTheoParentID(tinhID));
				}
			}

			if (o.equals(cmbQuan)) {
				showDiaChi();
				DiaChi quanSelected = (DiaChi) cmbQuan.getSelectedItem();
				if (quanSelected != null) {
					int quanID = (int) quanSelected.getId();
					LoadDiaChi(cmbPhuong, diaChi_dao.getDiaChiTheoParentID(quanID));
				}
			}

			if (o.equals(cmbPhuong)) {
				showDiaChi();
			}

			if (o.equals(cmbTrinhDo)) {
				String trinhDo = cmbTrinhDo.getSelectedItem().toString();
				if (trinhDo.equals("12/12")) {
					txtHSL.setText(1.65 + "");
				}
				if (trinhDo.equals("Cao đẳng/Đại học")) {
					txtHSL.setText(1.83 + "");
				}

			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnLamMoi)) {
			txtMa.setText("");
			txtDienThoai.setText("");
			txtCMND.setText("");
			txtTen.setText("");
			txtEmail.setText("");
			txtGhiChu.setText("");
			txtTen.requestFocus();
			tblNhanVien.clearSelection();
		}

		if (o.equals(btnThem)) {
			themNV();
		}

		if (o.equals(btnLuu)) {
			if(JOptionPane.showConfirmDialog(this, "Bạn muốn lưu thay đổi", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				suaNV();
			}
		}

		if (o.equals(btnTim)) {
			String timKiem = txtTim.getText().trim();
	        String chon = cmbTim.getSelectedItem().toString();
	        if (timKiem.isEmpty()) 
	        	return;
	        else {
	        	LoadDanhSachNhanVien(nhanVien_dao.getAllNhanVienTheoDieuKien(chon, timKiem));
	        }
		}

		if (o.equals(btnReLoad)) {
			LoadDanhSachNhanVien(nhanVien_dao.getAllNhanVien());
		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Object o = evt.getSource();
		if (o.equals(dateNgaySinh)) {
			btnThem.setEnabled(validData());
			btnLuu.setEnabled(validData());
			if (validDataNgaySinh()) {
				lblTBNgaySinh.setIcon(new ImageIcon(urlTBSuccess));
			} else {
				lblTBNgaySinh.setIcon(new ImageIcon(urlTBFail));
			}
		}

		if (o.equals(dateNgayVao)) {
			btnThem.setEnabled(validData());
			btnLuu.setEnabled(validData());
			if (validDataNgayVaoLam()) {
				lblTBNgayVao.setIcon(new ImageIcon(urlTBSuccess));
			} else {
				lblTBNgayVao.setIcon(new ImageIcon(urlTBFail));
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		fillForm();
		btnLuu.setEnabled(validData());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
