package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultFormatter;
import com.toedter.calendar.JDateChooser;
import dao.ToNhom_DAO;
import dao.CongNhan_DAO;
import dao.DiaChi_DAO;
import entity.ToNhom;
import entity.CongNhan;
import entity.DiaChi;
import util.QuanLyMaCongNhan;
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
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import java.awt.Insets;

/**
 * @author Nguyễn Thành An
 */
public class CongNhan_Panel extends JPanel implements ItemListener, ActionListener, PropertyChangeListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtCMND;
	private JTextField txtDienThoai;
	private JTextField txtTim;
	private JComboBox<DiaChi> cmbQuan;
	private JComboBox<DiaChi> cmbPhuong;
	private JComboBox<DiaChi> cmbTinh;
	private JComboBox<ToNhom> cmbTo;
	private JLabel lblTBNgaySinh;
	private JLabel lblTBNgayVao;
	private JLabel lblTBTen;
	private JLabel lblTBCMND;
	private JLabel lblTBDienThoai;
	private DiaChi_DAO diaChi_dao = new DiaChi_DAO();
	private CongNhan_DAO congNhan_DAO = new CongNhan_DAO();
	private ToNhom_DAO to_dao = new ToNhom_DAO();
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnLamMoi;
	private JTextArea txtGhiChu;
	private JTable tblCongNhan;
	private JDateChooser dateNgaySinh;
	private JDateChooser dateNgayVao;
	private JCheckBox chkGioiTinh;
	private JSpinner spnPhuCap;
	private DefaultTableModel model;
	private JButton btnTim;
	private JButton btnReLoad;
	private JComboBox<String> cmbTim;
	private JTextArea txtDiaChi;
	private URL urlTim = CongNhan_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
	private URL urlThem = CongNhan_Panel.class.getResource("/img/Custom-Icon-Design-Flatastic-1-Add-1.24.png");
	private URL urlLamMoi = CongNhan_Panel.class.getResource("/img/Hopstarter-Button-Button-Reload.24.png");
	private URL urlLuu = CongNhan_Panel.class.getResource("/img/Oxygen-Icons.org-Oxygen-Actions-document-save.24.png");
	private URL urlTBFail = CongNhan_Panel.class.getResource("/img/Saki-NuoveXT-Actions-button-cancel.16.png");
	private URL urlTBSuccess = CongNhan_Panel.class.getResource("/img/Custom-Icon-Design-Pretty-Office-8-Accept.16.png");
	
	public CongNhan_Panel() {
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
		lblTBNgaySinh.setBounds(352, 80, 25, 25);
		pnlTop.add(lblTBNgaySinh);
		
		lblTBNgayVao = new JLabel("");
		lblTBNgayVao.setIcon(new ImageIcon(urlTBFail));
		lblTBNgayVao.setBackground(Color.WHITE);
		lblTBNgayVao.setBounds(1225, 20, 25, 25);
		pnlTop.add(lblTBNgayVao);

		lblTBTen = new JLabel("");
		lblTBTen.setIcon(new ImageIcon(urlTBFail));
		lblTBTen.setBackground(Color.WHITE);
		lblTBTen.setBounds(352, 50, 25, 25);
		pnlTop.add(lblTBTen);

		lblTBCMND = new JLabel("");
		lblTBCMND.setIcon(new ImageIcon(urlTBFail));
		lblTBCMND.setBackground(Color.WHITE);
		lblTBCMND.setBounds(352, 140, 25, 25);
		pnlTop.add(lblTBCMND);

		lblTBDienThoai = new JLabel("");
		lblTBDienThoai.setIcon(new ImageIcon(urlTBFail));
		lblTBDienThoai.setBackground(Color.WHITE);
		lblTBDienThoai.setBounds(790, 20, 25, 25);
		pnlTop.add(lblTBDienThoai);
		
		JLabel lblMa = new JLabel("Mã công nhân");
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMa.setBounds(65, 20, 106, 25);
		pnlTop.add(lblMa);

		txtMa = new JTextField();
		txtMa.setEnabled(false);
		txtMa.setText("");
		txtMa.setBounds(160, 20, 150, 25);
		pnlTop.add(txtMa);
		txtMa.setColumns(10);

		JLabel lblTen = new JLabel("Họ tên");
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTen.setBounds(65, 50, 45, 25);
		pnlTop.add(lblTen);

		txtTen = new JTextField();
		txtTen.setBounds(160, 50, 180, 25);
		pnlTop.add(txtTen);
		txtTen.setColumns(10);

		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgaySinh.setBounds(65, 80, 68, 25);
		pnlTop.add(lblNgaySinh);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setBounds(65, 110, 68, 25);
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnlTop.add(lblGioiTinh);

		chkGioiTinh = new JCheckBox("Nam");
		chkGioiTinh.setBackground(new Color(255, 255, 255));
		chkGioiTinh.setSelected(true);
		chkGioiTinh.setBounds(160, 110, 93, 25);
		pnlTop.add(chkGioiTinh);

		JLabel lblCMND = new JLabel("CMND");
		lblCMND.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCMND.setBounds(65, 140, 45, 25);
		pnlTop.add(lblCMND);

		txtCMND = new JTextField();
		txtCMND.setBounds(160, 140, 150, 25);
		pnlTop.add(txtCMND);
		txtCMND.setColumns(10);

		JLabel lblDienThoai = new JLabel("Điện thoại");
		lblDienThoai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDienThoai.setBounds(512, 20, 65, 25);
		pnlTop.add(lblDienThoai);

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
		cmbTinh.setBounds(630, 50, 150, 25);
		pnlTop.add(cmbTinh);
		LoadDiaChi(cmbTinh, diaChi_dao.getDiaChiTheoCap(1)); // Lấy 63 tỉnh thành từ database

		cmbQuan = new JComboBox<DiaChi>();
		cmbQuan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbQuan.setBounds(630, 80, 150, 25);
		DiaChi tinhSelected = (DiaChi) cmbTinh.getSelectedItem();
		if (tinhSelected != null) {
			int tinhID = (int) tinhSelected.getId();
			LoadDiaChi(cmbQuan, diaChi_dao.getDiaChiTheoParentID(tinhID));
		}
		pnlTop.add(cmbQuan);

		cmbPhuong = new JComboBox<DiaChi>();
		cmbPhuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbPhuong.setBounds(630, 110, 150, 25);
		DiaChi xaSelected = (DiaChi) cmbQuan.getSelectedItem();
		if (xaSelected != null) {
			int xaID = (int) xaSelected.getId();
			LoadDiaChi(cmbPhuong, diaChi_dao.getDiaChiTheoParentID(xaID));
		}
		pnlTop.add(cmbPhuong);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaChi.setBounds(512, 140, 87, 25);
		pnlTop.add(lblDiaChi);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setBounds(630, 20, 150, 25);
		pnlTop.add(txtDienThoai);
		txtDienThoai.setColumns(10);

		JLabel lblNgayVao = new JLabel("Ngày vào làm");
		lblNgayVao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayVao.setBounds(949, 20, 117, 25);
		pnlTop.add(lblNgayVao);

		JLabel lblGhiChu = new JLabel("Ghi chú");
		lblGhiChu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGhiChu.setBounds(949, 50, 45, 25);
		pnlTop.add(lblGhiChu);

		txtGhiChu = new JTextArea();
		txtGhiChu.setRows(5);
		txtGhiChu.setColumns(10);
		txtGhiChu.setBounds(1065, 50, 150, 85);
		txtGhiChu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlTop.add(txtGhiChu);


		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBackground(new Color(255, 255, 255));
		btnThem.setBounds(469, 230, 120, 30);
		btnThem.setIcon(new ImageIcon(urlThem));
		pnlTop.add(btnThem);

		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBackground(new Color(255, 255, 255));
		btnLuu.setEnabled(false);
		btnLuu.setBounds(599, 230, 120, 30);
		btnLuu.setIcon(new ImageIcon(urlLuu));
		pnlTop.add(btnLuu);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setBackground(new Color(255, 255, 255));
		btnLamMoi.setBounds(729, 230, 120, 30);
		btnLamMoi.setIcon(new ImageIcon(urlLamMoi));
		pnlTop.add(btnLamMoi);
		
		
		
		dateNgaySinh = new JDateChooser();
		dateNgaySinh.setLocale(new Locale("vi", "VN"));
		dateNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateNgaySinh.setBounds(160, 80, 150, 25);
		pnlTop.add(dateNgaySinh);

		dateNgayVao = new JDateChooser();
		dateNgayVao.setLocale(new Locale("vi", "VN"));
		dateNgayVao.setDateFormatString("dd/MM/yyyy");
		dateNgayVao.setBounds(1065, 20, 150, 25);
		pnlTop.add(dateNgayVao);
		
		spnPhuCap = new JSpinner();
		spnPhuCap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnPhuCap.setBounds(630, 180, 150, 25);
		spnPhuCap.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), Float.valueOf(1000000),
				Float.valueOf(50000)));
		customJSpiner(spnPhuCap);
		pnlTop.add(spnPhuCap);
		
		JLabel lblPhuCap = new JLabel("Phụ cấp (VND)");
		lblPhuCap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhuCap.setBounds(512, 180, 127, 25);
		pnlTop.add(lblPhuCap);
		
		JLabel lblTo = new JLabel("Tổ");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTo.setBounds(953, 141, 117, 25);
		pnlTop.add(lblTo);
		
		cmbTo = new JComboBox<ToNhom>();
		cmbTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTo.setBounds(1065, 140, 150, 25);
		LoadTo(to_dao.getAllTo());
		pnlTop.add(cmbTo);
		
		txtDiaChi = new JTextArea();
		txtDiaChi.setWrapStyleWord(true);
		txtDiaChi.setMargin(new Insets(2, 5, 2, 2));
		txtDiaChi.setLineWrap(true);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiaChi.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtDiaChi.setBounds(630, 140, 150, 35);
		pnlTop.add(txtDiaChi);
		
		JPanel pnlDanhSach = new JPanel();
		pnlDanhSach.setBorder(new TitledBorder(null, "DANH SÁCH CÔNG NHÂN", TitledBorder.LEADING,
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
		btnTim.setIcon(new ImageIcon(urlTim));
		btnTim.setBounds(498, 5, 25, 25);
		pnlTim.add(btnTim);

		txtTim = new JTextField();
		txtTim.setColumns(10);
		txtTim.setBounds(262, 5, 226, 25);
		pnlTim.add(txtTim);

		cmbTim = new JComboBox<String>();
		cmbTim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTim.setModel(new DefaultComboBoxModel<String>(new String[] {"Mã công nhân", "Tên công nhân", "Tổ"}));
		cmbTim.setBounds(80, 5, 116, 25);
		pnlTim.add(cmbTim);

		JLabel lblTim = new JLabel("Tìm theo");
		lblTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTim.setBounds(10, 5, 60, 25);
		pnlTim.add(lblTim);

		JPanel pnlTable = new JPanel();
		pnlTable.setBackground(new Color(255, 255, 255));
		pnlDanhSach.add(pnlTable, BorderLayout.CENTER);

		String header[] = { "Mã công nhân", "Họ tên", "CMND", "Điện thoại", "Ngày vào làm" };
		model = new DefaultTableModel(header, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		pnlTable.setLayout(new BorderLayout(0, 0));

		tblCongNhan = new JTable(model);
		tblCongNhan.setRowHeight(20);
		tblCongNhan.setFillsViewportHeight(true);
		tblCongNhan.setPreferredScrollableViewportSize(new Dimension(800, 260));
		tblCongNhan.setSelectionBackground(new Color(0, 128, 255));
		tblCongNhan.setSelectionForeground(new Color(255, 255, 255));
		tblCongNhan.setGridColor(new Color(0, 0, 0));
		tblCongNhan.setBackground(new Color(255, 255, 255));

		JScrollPane scrollPane = new JScrollPane(tblCongNhan);
		scrollPane.setPreferredSize(new Dimension(950, 200));
		scrollPane.setBackground(new Color(255, 255, 255));
		pnlTable.add(scrollPane);
		
		
		btnReLoad = new JButton("");
		btnReLoad.setBorderPainted(false);
		btnReLoad.setIcon(new ImageIcon(urlLamMoi));
		btnReLoad.setBackground(new Color(255, 255, 255));
		btnReLoad.setBounds(207, 6, 25, 25);
		pnlTim.add(btnReLoad);

		cmbTinh.addItemListener(this);
		cmbQuan.addItemListener(this);
		cmbPhuong.addItemListener(this);
		btnTim.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnLuu.addActionListener(this);
		btnThem.addActionListener(this);
		cmbTim.addItemListener(this);
		btnReLoad.addActionListener(this);
		
		dateNgaySinh.addPropertyChangeListener(this);
		dateNgayVao.addPropertyChangeListener(this);
		tblCongNhan.addMouseListener(this);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		tblCongNhan.setRowSorter(sorter);
		
		showDiaChi();
		LoadDanhSachCongNhan(congNhan_DAO.getAllCongNhans());
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
	}
	
	
	
	private void LoadDiaChi(JComboBox<DiaChi> cmb, ArrayList<DiaChi> ar) {
		cmb.removeAllItems();
		for (DiaChi diaChi : ar) {
			cmb.addItem(diaChi);
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
				DiaChi xaSelected = (DiaChi) cmbQuan.getSelectedItem();
				if (xaSelected != null) {
					int xaID = (int) xaSelected.getId();
					LoadDiaChi(cmbPhuong, diaChi_dao.getDiaChiTheoParentID(xaID));
				}
			}
			if (o.equals(cmbPhuong)) {
				showDiaChi();
			}
			
		}

	}
	
	public boolean validData() {
		if (valiDataHoTen() && validDataNgaySinh() && validDataCMND() && validDataDienThoai() && validDataNgayVaoLam()) {
			return true;
		}
		return false;
	}
	public boolean valiDataHoTen() {
		String hoten = txtTen.getText().trim();
		if (hoten.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean validDataNgaySinh() {
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

	public boolean validDataCMND() {
		String cmnd = txtCMND.getText().trim();
		if (!cmnd.matches("\\d{12}")) {
			return false;
		}
		return true;
	}

	public boolean validDataDienThoai() {
		String dt = txtDienThoai.getText().trim();
		if (!dt.matches(
				"^(083|084|085|081|082|032|033|034|035|036|037|038|039|070|079|077|076|078|056|058|059)\\d{7}$")) {
			return false;
		}
		return true;
	}

	

	public boolean validDataNgayVaoLam() {
		if (dateNgayVao.getDate() == null) {
			return false;
		}
		Calendar currentDate = Calendar.getInstance();
		Calendar ngayVaoLam = Calendar.getInstance();
		ngayVaoLam.setTime(dateNgayVao.getDate());

		// So sánh ngày được chọn với ngày hiện tại
		return ngayVaoLam.before(currentDate);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Object o = evt.getSource();
		if (o.equals(dateNgaySinh)) {
			btnThem.setEnabled(validData());
			if (validDataNgaySinh()) {
				lblTBNgaySinh.setIcon(new ImageIcon(urlTBSuccess));
			} else {
				lblTBNgaySinh.setIcon(new ImageIcon(urlTBFail));
			}
		}

		if (o.equals(dateNgayVao)) {
			btnThem.setEnabled(validData());
			if (validDataNgayVaoLam()) {
				lblTBNgayVao.setIcon(new ImageIcon(urlTBSuccess));
			} else {
				lblTBNgayVao.setIcon(new ImageIcon(urlTBFail));
			}
		}

	}
	private void LoadTo(ArrayList<ToNhom> ar) {
		cmbTo.removeAllItems();
		for (ToNhom to : ar) {
			cmbTo.addItem(to);
		}
	}
	
	public void fillForm() {
		int r = tblCongNhan.getSelectedRow();
		if(r < 0) {
			return;
		}
		String maCN = tblCongNhan.getValueAt(r, 0).toString();
		CongNhan cn = new CongNhan(maCN);
		cn = congNhan_DAO.timMaCongNhan(cn);
		
		if(cn != null) {
			txtTen.setText(cn.getHoTen());
			dateNgaySinh.setDate(cn.getNgaySinh());
			Boolean  gioiTinh = true;
			if(cn.getGioiTinh() == 0) {
				gioiTinh = false;
			}
			chkGioiTinh.setSelected(gioiTinh);
			txtCMND.setText(cn.getCmnd());
			txtDienThoai.setText(cn.getSoDienThoai());
			txtDiaChi.setText(cn.getDiaChi());
			spnPhuCap.setValue(cn.getPhuCap());
			dateNgayVao.setDate(cn.getNgayVaoLam());
			cmbTo.setSelectedItem(cn.getTo());
			String caSang = new String("Sáng");
			String caChieu = new String("Chiều");
			String caToi = new String("Tối");
			if(cn.getTo().equals(caSang)) {
				cmbTo.setSelectedItem(caSang);
			}
			if(cn.getTo().equals(caChieu)) {
				cmbTo.setSelectedItem(caChieu);
			}
			if(cn.getTo().equals(caToi)) {
				cmbTo.setSelectedItem(caToi);
			}
			txtGhiChu.setText(cn.getGhiChu());
			}
		}
	
	public void showDiaChi() {
		DiaChi tinhSelected = (DiaChi) cmbTinh.getSelectedItem();
		DiaChi quanSelected = (DiaChi) cmbQuan.getSelectedItem();
		DiaChi phuongSelected = (DiaChi) cmbPhuong.getSelectedItem();
		String diachi = "";
		diachi += phuongSelected.getTenDC();
		diachi += ", " + quanSelected.getTenDC();
		diachi += ", " + tinhSelected.getTenDC();
		txtDiaChi.setText(diachi);
	}
	
	private void clearTable() {
		int r = tblCongNhan.getRowCount();
		while(r > 0) {
			model.removeRow(r-1);
			r--;
		}
	}
	
	private void LoadDanhSachCongNhan(ArrayList<CongNhan> dsCN) {
		clearTable();
		for (CongNhan cn : dsCN) {
			model.addRow(new Object[] { cn.getMaCN(),cn.getHoTen(),cn.getCmnd(),cn.getSoDienThoai(),cn.getNgayVaoLam() });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o.equals(btnLamMoi)) {
			txtMa.setText("");
			txtTen.setText("");
			txtCMND.setText("");
			txtDienThoai.setText("");
			txtGhiChu.setText("");
			txtTen.requestFocus();
			LoadTo(to_dao.getAllTo());
			LoadDanhSachCongNhan(congNhan_DAO.getAllCongNhans());
		}
		if (o.equals(btnThem)) {
			themCN();
		}

		if (o.equals(btnLuu)) {
			if(JOptionPane.showConfirmDialog(this, "Bạn muốn lưu thay đổi", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				suaCN();
			}
		}

		if (o.equals(btnTim)) {
			String timKiem = txtTim.getText().trim();
	        String chon = cmbTim.getSelectedItem().toString();
	        if (timKiem.isEmpty()) 
	        	return;
	        else {
	        	LoadDanhSachCongNhan(congNhan_DAO.getAllCongNhanTheoDieuKien(chon, timKiem));
	        }
		}
		
		if(o.equals(btnReLoad)) {
			LoadDanhSachCongNhan(congNhan_DAO.getAllCongNhans());
		}
		
	}
	
	public CongNhan revertCongNhanFromFields() {
		CongNhan cn = null;
		try {
			String maCN = txtMa.getText().trim();
			String hoTen = txtTen.getText().trim();
			Date ngaySinh = (Date) dateNgaySinh.getDate();
			int gioiTinh = 1; // Nam
			if (chkGioiTinh.isSelected() == false) {
				gioiTinh = 0; // Nữ
			}
			String cmnd = txtCMND.getText().trim();
			String soDienThoai = txtDienThoai.getText().trim();
			String diaChi = cmbPhuong.getSelectedItem().toString() + ", " + cmbQuan.getSelectedItem().toString() + ", "
					+ cmbTinh.getSelectedItem().toString();
			Date ngayVaoLam = (Date) dateNgayVao.getDate();
			String ghiChu = txtGhiChu.getText().trim();
			ToNhom caLam = (ToNhom) cmbTo.getSelectedItem();
			float phuCap = (float) spnPhuCap.getValue();
			cn = new CongNhan(maCN, hoTen, ngaySinh, gioiTinh, cmnd, soDienThoai, diaChi, ngayVaoLam, ghiChu, caLam, phuCap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	public void themCN() {
		CongNhan cn = revertCongNhanFromFields();
		QuanLyMaCongNhan randomCongNhan = new QuanLyMaCongNhan();
		cn.setMaCN(randomCongNhan.generateMaNhanVien());
		
		String err = "";
		boolean checkCMND = congNhan_DAO.kiemTraSuTonTaiDuyNhatCuaCMND(cn.getCmnd());
		if (checkCMND) {
			err += "CMND đã tồn tại!\n";
		}
		boolean checkSoDienThoai = congNhan_DAO.kiemTraSuTonTaiDuyNhatCuaSoDienThoai(cn.getSoDienThoai());
		if (checkSoDienThoai) {
			err += "Số điện thoại đã tồn tại!\n";
		}
		

		if (checkCMND == false && checkSoDienThoai == false) {
			if (congNhan_DAO.themCN(cn)) {
				LoadDanhSachCongNhan(congNhan_DAO.getAllCongNhans());
				JOptionPane.showMessageDialog(this, "Thêm thành công");
			} else {
				JOptionPane.showMessageDialog(this, "Trùng mã");
			}
		} else {
			JOptionPane.showMessageDialog(this, err);
		}
	}
	
	public void suaCN() {
		CongNhan cn = revertCongNhanFromFields();
		int r = tblCongNhan.getSelectedRow();
		cn.setMaCN(tblCongNhan.getValueAt(r, 0).toString());
		String err = "";
		boolean checkCMND = congNhan_DAO.demSoLuongCMND(cn.getCmnd());
		if (checkCMND) {
			err += "CMND đã tồn tại!\n";
		}
		boolean checkSoDienThoai = congNhan_DAO.demSoLuongSoDienThoai(cn.getSoDienThoai());
		if (checkSoDienThoai) {
			err += "Số điện thoại đã tồn tại!\n";
		}
		if (checkCMND == false && checkSoDienThoai == false) {
				if (congNhan_DAO.suaCN(cn)) {
					LoadDanhSachCongNhan(congNhan_DAO.getAllCongNhans());
				} else {
					JOptionPane.showMessageDialog(this, "Không thể chỉnh sửa");
				}
			
		} else {
			JOptionPane.showMessageDialog(this, err);
		}
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
	
	@Override
	public void mouseClicked(MouseEvent e) {
		fillForm();
		btnLuu.setEnabled(validData());
		btnThem.setEnabled(false);
		
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
