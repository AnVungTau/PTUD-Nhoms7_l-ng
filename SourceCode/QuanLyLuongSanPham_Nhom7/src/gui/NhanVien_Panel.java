package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatter;

import com.toedter.calendar.JDateChooser;

import dao.DiaChi_DAO;
import dao.PhongBan_DAO;
import entity.DiaChi;
import entity.NhanVien;
import entity.PhongBan;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.Locale;
import javax.swing.ImageIcon;
import com.toedter.components.JSpinField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import javax.swing.SwingConstants;

/**
 * @author Nguyễn Hồng Quân
 */
public class NhanVien_Panel extends JPanel implements ItemListener, ActionListener {

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
	private PhongBan_DAO phongBan_dao = new PhongBan_DAO();
	private DiaChi_DAO diaChi_dao = new DiaChi_DAO();
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
	private JTable tblTable;
	private DefaultTableModel model;

	public NhanVien_Panel() {
		setSize(new Dimension(1000, 600));
		setBackground(new Color(240, 240, 240));
		setLayout(new BorderLayout());

		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(new Color(255, 255, 255));
		pnlTop.setPreferredSize(new Dimension(1000, 270));
		pnlTop.setSize(new Dimension(1000, 270));
		pnlTop.setMinimumSize(new Dimension(1000, 200));
		add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(null);

		JLabel lblMa = new JLabel("Mã nhân viên");
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMa.setBounds(30, 20, 81, 20);
		pnlTop.add(lblMa);

		txtMa = new JTextField();
		txtMa.setEnabled(false);
		txtMa.setText("");
		txtMa.setBounds(130, 20, 96, 20);
		pnlTop.add(txtMa);
		txtMa.setColumns(10);

		JLabel lblTen = new JLabel("Họ tên");
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTen.setBounds(30, 50, 45, 20);
		pnlTop.add(lblTen);

		txtDienThoai = new JTextField();
		txtDienThoai.setBounds(468, 22, 130, 20);
		pnlTop.add(txtDienThoai);
		txtDienThoai.setColumns(10);

		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgaySinh.setBounds(30, 80, 68, 20);
		pnlTop.add(lblNgaySinh);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setBounds(30, 110, 68, 20);
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnlTop.add(lblGioiTinh);

		chkGioiTinh = new JCheckBox("Nam");
		chkGioiTinh.setBackground(new Color(255, 255, 255));
		chkGioiTinh.setSelected(true);
		chkGioiTinh.setBounds(130, 110, 93, 20);
		pnlTop.add(chkGioiTinh);

		JLabel lblCMND = new JLabel("CMND");
		lblCMND.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCMND.setBounds(30, 140, 45, 20);
		pnlTop.add(lblCMND);

		txtCMND = new JTextField();
		txtCMND.setBounds(130, 141, 130, 20);
		pnlTop.add(txtCMND);
		txtCMND.setColumns(10);

		JLabel lblDienThoai = new JLabel("Điện thoại");
		lblDienThoai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDienThoai.setBounds(383, 20, 65, 20);
		pnlTop.add(lblDienThoai);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(383, 50, 45, 20);
		pnlTop.add(lblEmail);

		JLabel lblTinh = new JLabel("Tỉnh/TP");
		lblTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTinh.setBounds(383, 80, 75, 20);
		pnlTop.add(lblTinh);

		JLabel lblQuan = new JLabel("Quận/Huyện");
		lblQuan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuan.setBounds(383, 110, 106, 20);
		pnlTop.add(lblQuan);

		JLabel lblXa = new JLabel("Phường/Xã");
		lblXa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblXa.setBounds(383, 140, 106, 20);
		pnlTop.add(lblXa);

		cmbTinh = new JComboBox<DiaChi>();
		cmbTinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTinh.setBounds(468, 80, 165, 25);
		pnlTop.add(cmbTinh);
		LoadDiaChi(cmbTinh, diaChi_dao.getDiaChiTheoCap(1)); // Lấy 63 tỉnh thành từ database

		cmbQuan = new JComboBox<DiaChi>();
		cmbQuan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbQuan.setBounds(468, 110, 165, 25);
		DiaChi tinhSelected = (DiaChi) cmbTinh.getSelectedItem();
		if (tinhSelected != null) {
			int tinhID = (int) tinhSelected.getId();
			LoadDiaChi(cmbQuan, diaChi_dao.getDiaChiTheoParentID(tinhID));
		}
		pnlTop.add(cmbQuan);

		cmbPhuong = new JComboBox<DiaChi>();
		cmbPhuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbPhuong.setBounds(468, 140, 165, 25);
		DiaChi xaSelected = (DiaChi) cmbQuan.getSelectedItem();
		if (xaSelected != null) {
			int xaID = (int) xaSelected.getId();
			LoadDiaChi(cmbPhuong, diaChi_dao.getDiaChiTheoParentID(xaID));
		}
		pnlTop.add(cmbPhuong);

		txtTen = new JTextField();
		txtTen.setBounds(130, 50, 179, 20);
		pnlTop.add(txtTen);
		txtTen.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(468, 50, 130, 20);
		pnlTop.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblTrinhDo = new JLabel("Trình độ");
		lblTrinhDo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTrinhDo.setBounds(704, 20, 75, 20);
		pnlTop.add(lblTrinhDo);

		JLabel lblHSL = new JLabel("Hệ số lương");
		lblHSL.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHSL.setBounds(704, 50, 75, 20);
		pnlTop.add(lblHSL);

		JLabel lblNgayVao = new JLabel("Ngày vào làm");
		lblNgayVao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayVao.setBounds(704, 80, 117, 20);
		pnlTop.add(lblNgayVao);

		JLabel lblPhongBan = new JLabel("Phòng ban");
		lblPhongBan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhongBan.setBounds(704, 110, 75, 20);
		pnlTop.add(lblPhongBan);

		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChucVu.setBounds(704, 140, 75, 20);
		pnlTop.add(lblChucVu);

		JLabel lblGhiChu = new JLabel("Ghi chú");
		lblGhiChu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGhiChu.setBounds(704, 170, 45, 20);
		pnlTop.add(lblGhiChu);

		txtGhiChu = new JTextArea();
		txtGhiChu.setRows(5);
		txtGhiChu.setColumns(10);
		txtGhiChu.setBounds(819, 170, 130, 85);
		txtGhiChu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlTop.add(txtGhiChu);

		txtHSL = new JTextField();
		txtHSL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHSL.setText(1.65 + "");
		txtHSL.setEnabled(false);
		txtHSL.setDisabledTextColor(new Color(0, 0, 0));
		txtHSL.setHorizontalAlignment(SwingConstants.CENTER);
		txtHSL.setBounds(819, 50, 130, 20);
		pnlTop.add(txtHSL);
		txtHSL.setColumns(10);

		cmbPhongBan = new JComboBox<PhongBan>();
		cmbPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbPhongBan.setBounds(819, 110, 130, 25);
		LoadPhongBan(phongBan_dao.getAllPhongBan());
		pnlTop.add(cmbPhongBan);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(130, 230, 85, 25);
		pnlTop.add(btnThem);

		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("img\\Oxygen-Icons.org-Oxygen-Actions-document-save.24.png"));
		btnLuu.setBounds(268, 230, 85, 25);
		pnlTop.add(btnLuu);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(425, 230, 85, 25);
		pnlTop.add(btnLamMoi);

		dateNgaySinh = new JDateChooser();
		dateNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 10));
		dateNgaySinh.setLocale(new Locale("vi", "VN"));
		dateNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateNgaySinh.setBounds(130, 80, 130, 20);
		pnlTop.add(dateNgaySinh);

		dateNgayVao = new JDateChooser();
		dateNgayVao.setDateFormatString("dd/MM/yyyy");
		dateNgayVao.setFont(new Font("Tahoma", Font.PLAIN, 10));
		dateNgayVao.setLocale(new Locale("vi", "VN"));
		dateNgayVao.setBounds(819, 80, 130, 20);
		pnlTop.add(dateNgayVao);

		cmbChucVu = new JComboBox<String>();
		cmbChucVu.addItem("Kế toán");
		cmbChucVu.addItem("Quản lý nhân sự");
		cmbChucVu.setBounds(819, 140, 130, 25);
		pnlTop.add(cmbChucVu);

		JLabel lblPhuCap = new JLabel("Phụ cấp (VND)");
		lblPhuCap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhuCap.setBounds(383, 170, 127, 20);
		pnlTop.add(lblPhuCap);

		spnPhuCap = new JSpinner();
		spnPhuCap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnPhuCap.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), Float.valueOf(1000000),
				Float.valueOf(50000)));
		spnPhuCap.setBounds(530, 170, 100, 20);
		customJSpiner(spnPhuCap);
		pnlTop.add(spnPhuCap);

		cmbTrinhDo = new JComboBox<String>();
		cmbTrinhDo.setModel(new DefaultComboBoxModel(new String[] { "12/12", "Cao đẳng/Đại học" }));
		cmbTrinhDo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTrinhDo.setBounds(819, 20, 130, 20);
		pnlTop.add(cmbTrinhDo);

		JPanel pnlDanhSach = new JPanel();
		pnlDanhSach.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlDanhSach.setBackground(new Color(255, 255, 255));
		add(pnlDanhSach, BorderLayout.CENTER);
		pnlDanhSach.setLayout(new BorderLayout(0, 0));

		JPanel pnlTim = new JPanel();
		pnlTim.setBackground(new Color(255, 255, 255));
		pnlTim.setPreferredSize(new Dimension(10, 33));
		pnlTim.setSize(new Dimension(0, 100));
		pnlDanhSach.add(pnlTim, BorderLayout.NORTH);
		pnlTim.setLayout(null);

		btnTim = new JButton("Tìm");
		btnTim.setBounds(577, 7, 85, 20);
		pnlTim.add(btnTim);

		txtTim = new JTextField();
		txtTim.setColumns(10);
		txtTim.setBounds(341, 8, 226, 20);
		pnlTim.add(txtTim);

		JComboBox<String> cmbLoc = new JComboBox<String>();
		cmbLoc.setModel(new DefaultComboBoxModel<String>(new String[] { "Tất cả", "Tên", "Ngày vào làm" }));
		cmbLoc.setBounds(80, 7, 116, 20);
		pnlTim.add(cmbLoc);

		JLabel lblLoc = new JLabel("Lọc");
		lblLoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoc.setBounds(10, 7, 60, 20);
		pnlTim.add(lblLoc);

		JPanel pnlTable = new JPanel();
		pnlTable.setBackground(new Color(255, 255, 255));
		pnlDanhSach.add(pnlTable, BorderLayout.CENTER);

		String header[] = { "Mã NV", "Họ tên", "Ngày vào làm", "Phòng ban", "Chức vụ", "HSL" };
		model = new DefaultTableModel(header, 0);
		pnlTable.setLayout(new BorderLayout(0, 0));

		tblTable = new JTable(model);
		tblTable.setFillsViewportHeight(true);
		tblTable.setPreferredScrollableViewportSize(new Dimension(800, 260));
		tblTable.setSelectionBackground(new Color(0, 128, 192));
		tblTable.setSelectionForeground(new Color(255, 255, 255));
		tblTable.setGridColor(new Color(0, 0, 0));
		tblTable.setBackground(new Color(255, 255, 255));

		JScrollPane scrollPane = new JScrollPane(tblTable);
		scrollPane.setPreferredSize(new Dimension(950, 200));
		scrollPane.setBackground(new Color(255, 255, 255));
		pnlTable.add(scrollPane);

		cmbTinh.addItemListener(this);
		cmbQuan.addItemListener(this);
		cmbTrinhDo.addItemListener(this);
		btnTim.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnLuu.addActionListener(this);
		btnThem.addActionListener(this);

		txtTen.requestFocus();

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

	public NhanVien revertNhanVienFromFields() {
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

	public void updateTableData(ArrayList<NhanVien> ds) {
		DefaultTableModel dm = (DefaultTableModel) tblTable.getModel();
		dm.getDataVector().removeAllElements();
		for (NhanVien nv : ds) {
			model.addRow(new Object[] { nv.getMaNV(), nv.getHoTen(), nv.getNgayVaoLam(), nv.getPhongBan().getTenPhong(),
					nv.getChucVu(), nv.getHeSoLuong() });
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			Object o = e.getSource();
			if (o.equals(cmbTinh)) {
				DiaChi tinhSelected = (DiaChi) cmbTinh.getSelectedItem();
				if (tinhSelected != null) {
					int tinhID = (int) tinhSelected.getId();
					LoadDiaChi(cmbQuan, diaChi_dao.getDiaChiTheoParentID(tinhID));
				}
			}

			if (o.equals(cmbQuan)) {
				DiaChi xaSelected = (DiaChi) cmbQuan.getSelectedItem();
				if (xaSelected != null) {
					int xaID = (int) xaSelected.getId();
					LoadDiaChi(cmbPhuong, diaChi_dao.getDiaChiTheoParentID(xaID));
				}
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
			txtDienThoai.requestFocus();
		}

		if (o.equals(btnThem)) {
			NhanVien nv = revertNhanVienFromFields();
			System.out.println(nv.getMaNV() + nv.getHoTen() + nv.getNgaySinh() + nv.getGioiTinh() + nv.getCmnd()
					+ nv.getSoDienThoai() + nv.getEmail() + nv.getChucVu() + nv.getDiaChi() + nv.getPhuCap()
					+ nv.getTrinhDo() +nv.getHeSoLuong() + nv.getNgayVaoLam() +nv.getPhongBan().getTenPhong()+nv.getChucVu()+ nv.getGhiChu() );
			model.addRow(new Object[] { nv.getMaNV(), nv.getHoTen(), nv.getNgayVaoLam(), nv.getPhongBan().getTenPhong(),
					nv.getChucVu(), nv.getHeSoLuong() });
		}

		if (o.equals(btnLuu)) {

		}

		if (o.equals(btnTim)) {
			System.out.println("ok3");
		}

	}
}
