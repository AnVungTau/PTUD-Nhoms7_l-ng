package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultFormatter;
import dao.CongDoan_DAO;
import dao.SanPham_DAO;
import entity.CongDoan;
import entity.SanPham;
import util.QuanLyMaCongDoan;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;

public class CongDoan_Panel extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaCD;
	private JTextField txtTenCD;
	private JTextField txtTimSP;
	private JTable tblSanPham;
	private JTextField txtGhiChu;
	private CongDoan_DAO congDoan_DAO = new CongDoan_DAO();
	private SanPham_DAO sanPham_DAO = new SanPham_DAO();
	private SanPham selectedSanPham;
	private JSpinner spnSoThuTu;
	private JSpinner spnSoLuongCan;
	private JSpinner spnGia;
	private JButton btnLamMoi, btnThem, btnXoa, btnLuu;
	private JTextField txtTimCD;
	private JTable tblCD;
	private DefaultTableModel model;
	private JButton btnTimSP;
	private JButton btnTimCD;
	private JComboBox<String> cmbTimCD;
	private JTextField txtTrangThai;

	private void customJSpiner(JSpinner X) {
		JComponent editor = X.getEditor();
		if (editor instanceof JSpinner.DefaultEditor) {
			JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
			DefaultFormatter formatter = (DefaultFormatter) textField.getFormatter();
			formatter.setOverwriteMode(true);
			textField.setHorizontalAlignment(JTextField.CENTER);
		}
	}

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CongDoan_Panel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));

		JPanel pnlTop = new JPanel();
		pnlTop.setPreferredSize(new Dimension(10, 320));
		pnlTop.setBackground(Color.WHITE);
		add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(null);

		JLabel lblTitle = new JLabel("QUẢN LÝ CÔNG ĐOẠN");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setBounds(10, 0, 1280, 29);
		pnlTop.add(lblTitle);

		JLabel lblMaCD = new JLabel("Mã công đoạn");
		lblMaCD.setPreferredSize(new Dimension(64, 14));
		lblMaCD.setMinimumSize(new Dimension(64, 14));
		lblMaCD.setMaximumSize(new Dimension(64, 14));
		lblMaCD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaCD.setBounds(605, 40, 100, 25);
		pnlTop.add(lblMaCD);

		txtMaCD = new JTextField();
		txtMaCD.setDisabledTextColor(new Color(0, 0, 0));
		txtMaCD.setText("");
		txtMaCD.setEnabled(false);
		txtMaCD.setColumns(10);
		txtMaCD.setBounds(715, 40, 150, 25);
		pnlTop.add(txtMaCD);

		txtTenCD = new JTextField();
		txtTenCD.setColumns(10);
		txtTenCD.setBounds(715, 75, 180, 25);
		pnlTop.add(txtTenCD);

		JLabel lblTenCD = new JLabel("Tên công đoạn");
		lblTenCD.setPreferredSize(new Dimension(64, 14));
		lblTenCD.setMinimumSize(new Dimension(64, 14));
		lblTenCD.setMaximumSize(new Dimension(64, 14));
		lblTenCD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenCD.setBounds(605, 75, 100, 25);
		pnlTop.add(lblTenCD);

		JLabel lblSTT = new JLabel("Số thứ tự");
		lblSTT.setPreferredSize(new Dimension(64, 14));
		lblSTT.setMinimumSize(new Dimension(64, 14));
		lblSTT.setMaximumSize(new Dimension(64, 14));
		lblSTT.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSTT.setBounds(605, 110, 100, 25);
		pnlTop.add(lblSTT);

		JPanel pnlDanhSachSanPham = new JPanel();
		pnlDanhSachSanPham.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDanhSachSanPham.setBackground(Color.WHITE);
		pnlDanhSachSanPham.setBounds(150, 33, 337, 265);
		pnlTop.add(pnlDanhSachSanPham);
		pnlDanhSachSanPham.setLayout(null);

		JPanel pnlTimSP = new JPanel();
		pnlTimSP.setBackground(Color.WHITE);
		pnlTimSP.setBounds(6, 15, 325, 35);
		pnlDanhSachSanPham.add(pnlTimSP);
		pnlTimSP.setLayout(null);

		JLabel lblMaSP = new JLabel("Mã SP");
		lblMaSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaSP.setBounds(10, 5, 46, 25);
		pnlTimSP.add(lblMaSP);

		txtTimSP = new JTextField();
		txtTimSP.setBounds(66, 5, 188, 25);
		pnlTimSP.add(txtTimSP);
		txtTimSP.setColumns(10);

		btnTimSP = new JButton("");
		btnTimSP.setBorderPainted(false);
		URL urlBtnTimSP = CongDoan_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
		btnTimSP.setIcon(new ImageIcon(urlBtnTimSP));
		btnTimSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimSP.setBounds(261, 5, 25, 25);
		pnlTimSP.add(btnTimSP);

		JScrollPane scrollPaneSP = new JScrollPane();
		scrollPaneSP.setBounds(6, 50, 321, 205);
		pnlDanhSachSanPham.add(scrollPaneSP);

		tblSanPham = new JTable();
		tblSanPham.setRowHeight(20);
		tblSanPham.setSelectionForeground(new Color(255, 255, 255));
		tblSanPham.setSelectionBackground(new Color(0, 128, 255));
		tblSanPham.setFillsViewportHeight(true);
		tblSanPham.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 SP", "T\u00EAn s\u1EA3n ph\u1EA9m" }));
		tblSanPham.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPaneSP.setViewportView(tblSanPham);

		JLabel lblSoLuongCan = new JLabel("Số lượng cần");
		lblSoLuongCan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoLuongCan.setBounds(936, 75, 100, 25);
		pnlTop.add(lblSoLuongCan);

		JLabel lblGia = new JLabel("Giá");
		lblGia.setPreferredSize(new Dimension(64, 14));
		lblGia.setMinimumSize(new Dimension(64, 14));
		lblGia.setMaximumSize(new Dimension(64, 14));
		lblGia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGia.setBounds(936, 110, 100, 25);
		pnlTop.add(lblGia);

		JLabel lblGhiChu = new JLabel("Ghi chú");
		lblGhiChu.setPreferredSize(new Dimension(64, 14));
		lblGhiChu.setMinimumSize(new Dimension(64, 14));
		lblGhiChu.setMaximumSize(new Dimension(64, 14));
		lblGhiChu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGhiChu.setBounds(605, 145, 100, 25);
		pnlTop.add(lblGhiChu);

		txtGhiChu = new JTextField();
		txtGhiChu.setColumns(10);
		txtGhiChu.setBounds(715, 145, 130, 68);
		pnlTop.add(txtGhiChu);

		btnThem = new JButton("Thêm");
		URL urlBtnThem = CongDoan_Panel.class.getResource("/img/Custom-Icon-Design-Flatastic-1-Add-1.24.png");
		btnThem.setIcon(new ImageIcon(urlBtnThem));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBackground(Color.WHITE);
		btnThem.setBounds(543, 268, 120, 30);
		pnlTop.add(btnThem);

		btnLamMoi = new JButton("Làm mới");
		URL urlBtnLamMoi = CongDoan_Panel.class.getResource("/img/Hopstarter-Button-Button-Reload.24.png");
		btnLamMoi.setIcon(new ImageIcon(urlBtnLamMoi));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setBackground(Color.WHITE);
		btnLamMoi.setBounds(936, 268, 120, 30);
		pnlTop.add(btnLamMoi);

		btnLuu = new JButton("Lưu");
		URL urlBtnLuu = CongDoan_Panel.class.getResource("/img/Oxygen-Icons.org-Oxygen-Actions-document-save.24.png");
		btnLuu.setIcon(new ImageIcon(urlBtnLuu));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBackground(Color.WHITE);
		btnLuu.setBounds(673, 268, 120, 30);
		pnlTop.add(btnLuu);

		btnXoa = new JButton("Xóa");
		URL urlXoa = CongDoan_Panel.class.getResource("/img/Pictogrammers-Material-Delete-forever.24.png");
		btnXoa.setIcon(new ImageIcon(urlXoa));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(803, 268, 120, 30);
		pnlTop.add(btnXoa);

		spnSoThuTu = new JSpinner();
		spnSoThuTu.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spnSoThuTu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnSoThuTu.setBounds(715, 110, 100, 25);
		customJSpiner(spnSoThuTu);
		pnlTop.add(spnSoThuTu);

		spnSoLuongCan = new JSpinner();
		spnSoLuongCan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnSoLuongCan.setBounds(1046, 75, 130, 25);
		customJSpiner(spnSoLuongCan);
		pnlTop.add(spnSoLuongCan);

		spnGia = new JSpinner();
		spnGia.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), null, Float.valueOf(2000)));
		spnGia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnGia.setBounds(1046, 110, 130, 25);
		customJSpiner(spnGia);
		pnlTop.add(spnGia);

		txtTrangThai = new JTextField();
		txtTrangThai.setDisabledTextColor(new Color(0, 0, 0));
		txtTrangThai.setText("");
		txtTrangThai.setEnabled(false);
		txtTrangThai.setColumns(10);
		txtTrangThai.setBounds(1046, 40, 130, 25);
		pnlTop.add(txtTrangThai);

		JLabel lblTrangThai = new JLabel("Tình trạng");
		lblTrangThai.setPreferredSize(new Dimension(64, 14));
		lblTrangThai.setMinimumSize(new Dimension(64, 14));
		lblTrangThai.setMaximumSize(new Dimension(64, 14));
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTrangThai.setBounds(936, 40, 100, 25);
		pnlTop.add(lblTrangThai);

		JPanel pnlDanhSachCongDoan = new JPanel();
		pnlDanhSachCongDoan.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch c\u00F4ng \u0111o\u1EA1n", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pnlDanhSachCongDoan.setBackground(Color.WHITE);
		add(pnlDanhSachCongDoan);
		pnlDanhSachCongDoan.setLayout(new BorderLayout(0, 0));

		JPanel pnlTimCD = new JPanel();
		pnlTimCD.setPreferredSize(new Dimension(10, 35));
		pnlTimCD.setBackground(Color.WHITE);
		pnlDanhSachCongDoan.add(pnlTimCD, BorderLayout.NORTH);
		pnlTimCD.setLayout(null);

		JLabel lblMaSP_1 = new JLabel("Tìm kiếm theo");
		lblMaSP_1.setBounds(10, 5, 88, 25);
		lblMaSP_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnlTimCD.add(lblMaSP_1);

		txtTimCD = new JTextField();
		txtTimCD.setBounds(386, 5, 188, 25);
		txtTimCD.setColumns(10);
		pnlTimCD.add(txtTimCD);

		btnTimCD = new JButton("");
		btnTimCD.setBackground(new Color(255, 255, 255));
		btnTimCD.setBorderPainted(false);
		URL urlTimCD = CongDoan_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
		btnTimCD.setIcon(new ImageIcon(urlTimCD));
		btnTimCD.setBounds(584, 5, 25, 25);
		btnTimCD.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnlTimCD.add(btnTimCD);

		cmbTimCD = new JComboBox();
		cmbTimCD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTimCD.setModel(
				new DefaultComboBoxModel(new String[] { "Mã công đoạn", "Tên công đoạn", "Số lượng cần", "Giá" }));
		cmbTimCD.setBounds(129, 5, 140, 25);
		pnlTimCD.add(cmbTimCD);

		JScrollPane scrollPaneDSCD = new JScrollPane();
		pnlDanhSachCongDoan.add(scrollPaneDSCD);

		String header[] = { "Mã CĐ", "Tên công đoạn", "Tên sản phẩm", "STT", "Số lượng cần", "Tình trạng", "Giá",
				"Ghi chú " };
		model = new DefaultTableModel(header, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblCD = new JTable(model);
		tblCD.setSelectionForeground(new Color(255, 255, 255));
		tblCD.setSelectionBackground(new Color(0, 128, 255));
		tblCD.setRowHeight(20);
		tblCD.setFillsViewportHeight(true);
		tblCD.setBackground(new Color(255, 255, 255));
		scrollPaneDSCD.setViewportView(tblCD);

		LoadDanhSachSanPham(sanPham_DAO.getAllSanPham());
		LoadDanhSachCongDoan(congDoan_DAO.getAllCongDoan());
		btnLamMoi.addActionListener(this);
		btnLuu.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTimCD.addActionListener(this);
		btnTimSP.addActionListener(this);
		tblSanPham.addMouseListener(this);
		tblCD.addMouseListener(this);
		tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				tableSanPhamMouseClicked(evt);
			}
		});
		addTableSelectionListener(tblCD);
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
		tblCD.setRowSorter(sorter);
	}

	private void clearTable() {
		model.setRowCount(0);

	}

	public void clearSanPhamTable() {
		DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
		model.setRowCount(0); // Xóa tất cả các hàng trong mô hình
	}

	private void LoadDanhSachCongDoan(ArrayList<CongDoan> dsCD) {
		congDoan_DAO.capNhatTrangThaiTuDong();
		clearTable();
		DecimalFormat format = new DecimalFormat("#,##0 VND");
		for (CongDoan cd : dsCD) {
			String tinhTrangText = (cd.getTinhTrang() == 0) ? "Chưa hoàn thành" : "Hoàn thành";
			model.addRow(new Object[] { cd.getMaCD(), cd, cd.getSp().getTenSP(), cd.getsoThuTu(), cd.getsoLuongCan(),
					tinhTrangText, format.format(cd.getGia()), cd.getGhiChu() });
		}
	}

	private void LoadDanhSachSanPham(ArrayList<SanPham> dsSanPham) {
		clearSanPhamTable();
		DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
		for (SanPham sp : dsSanPham) {
			model.addRow(new Object[] { sp.getMaSP(), sp.getTenSP() });
		}
	}

	private void tableSanPhamMouseClicked(MouseEvent evt) {
		int row = tblSanPham.getSelectedRow();
		if (row >= 0) {
			// Lấy thông tin của sản phẩm được chọn từ mô hình bảng
			DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
			String maSP = (String) model.getValueAt(row, 0);
			String tenSP = (String) model.getValueAt(row, 1);
			selectedSanPham = new SanPham(maSP, tenSP);
			LoadDanhSachCongDoan(congDoan_DAO.getAllCongDoanTheoMaSanPham(selectedSanPham));
		}
	}

	public CongDoan revertCongDoanFromFields() {
		CongDoan cd = null;
		try {
			String maCD = txtMaCD.getText().trim();
			String tenCD = txtTenCD.getText().trim();
			int soThuTu = (int) spnSoThuTu.getValue(); // Lấy giá trị từ JSpinner
			int soLuongCan = (int) spnSoLuongCan.getValue(); // Lấy giá trị từ JSpinner
			int tinhTrang = 0; // Mặc định trạng thái là 0
			float gia = (float) spnGia.getValue(); // Lấy giá trị từ JSpinner
			String ghiChu = txtGhiChu.getText().trim();
			SanPham sp = selectedSanPham;

			cd = new CongDoan(maCD, tenCD, soThuTu, soLuongCan, tinhTrang, gia, ghiChu, sp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cd;
	}

	public void themCD() {
		CongDoan cd = revertCongDoanFromFields();
		QuanLyMaCongDoan quanLyMaCongDoan = new QuanLyMaCongDoan();
		cd.setMaCD(quanLyMaCongDoan.generateMaCongDoan());
		cd.setTinhTrang(0); // Mặc định trạng thái là 0

		if (congDoan_DAO.themCongDoan(cd)) {
			// Load lại danh sách công đoạn sau khi thêm
			LoadDanhSachCongDoan(congDoan_DAO.getAllCongDoan());
			JOptionPane.showMessageDialog(this, "Thêm công đoạn thành công!");
		} else {
			JOptionPane.showMessageDialog(this, "Lỗi khi thêm công đoạn!");
		}
	}

	public void suaCD() {
		int r = tblCD.getSelectedRow();
		if(r < 0) {
			JOptionPane.showMessageDialog(this, "Chọn công đoạn muốn sửa !");
			return;
		}
		CongDoan cdcu = revertCongDoanFromFields();
		CongDoan cdmoi = (CongDoan) tblCD.getValueAt(r, 1);
		cdmoi.setTenCD(cdcu.getTenCD());
		cdmoi.setsoThuTu(cdcu.getsoThuTu());
		cdmoi.setsoLuongCan(cdcu.getsoLuongCan());
		cdmoi.setTinhTrang(cdcu.getTinhTrang());
		cdmoi.setGhiChu(cdcu.getGhiChu());
		cdmoi.setGia(cdcu.getGia());
		if(JOptionPane.showConfirmDialog(this, "Bạn muốn lưu thay đổi", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if (congDoan_DAO.suaCongDoan(cdmoi)) {
				// Load lại danh sách công đoạn sau khi thêm
				LoadDanhSachCongDoan(congDoan_DAO.getAllCongDoan());
				JOptionPane.showMessageDialog(this, "Sửa công đoạn thành công!");
			} else {
				JOptionPane.showMessageDialog(this, "Lỗi khi sửa công đoạn!");
			}
		}
	}

	public void xoaCD() {
		String maCDXoa = txtMaCD.getText();
		if (congDoan_DAO.xoaCongDoan(maCDXoa)) {
			// Load lại danh sách công đoạn sau khi thêm
			LoadDanhSachCongDoan(congDoan_DAO.getAllCongDoan());
			JOptionPane.showMessageDialog(this, "Xóa công đoạn thành công!");

		} else {
			JOptionPane.showMessageDialog(this, "Lỗi khi xóa công đoạn!");
		}
	}

	// Phương thức để xóa các trường của Công Đoạn
	private void clearCongDoanFields() {
		txtMaCD.setText("");
		txtTenCD.setText("");
		spnSoThuTu.setValue(1);
		spnSoLuongCan.setValue(0);
		spnGia.setValue(0.0f);
		txtGhiChu.setText("");
		txtTimCD.setText("");
		txtTimSP.setText("");
		cmbTimCD.setSelectedIndex(0);
		txtMaCD.requestFocus(); // Đặt con trỏ tới trường mã Công Đoạn
	}

	private void reloadCongDoanPanel() {
		clearCongDoanFields();
		tblCD.clearSelection();
		tblSanPham.clearSelection();
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnLamMoi)) {
			reloadCongDoanPanel();
			LoadDanhSachCongDoan(congDoan_DAO.getAllCongDoan());
		}

		if (o.equals(btnThem)) {
			int r = tblSanPham.getSelectedRow();
			if (r < 0) {
				JOptionPane.showMessageDialog(this, "Chọn sản phẩm trước !");
				return;
			}
			themCD();
			reloadCongDoanPanel();
		}
		if (o.equals(btnLuu)) {
				suaCD();
				reloadCongDoanPanel();
		}
		if (o.equals(btnXoa)) {
			if(JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				xoaCD();
				reloadCongDoanPanel();
			}
		}
		if (o.equals(btnTimCD)) {
			String timKiem = txtTimCD.getText();
			int chon = cmbTimCD.getSelectedIndex();
			if (timKiem.trim().isEmpty())
				JOptionPane.showMessageDialog(this, "Chưa nhập thông tin!");
			else {
				ArrayList<CongDoan> ds = congDoan_DAO.timCongDoan(chon, timKiem);
				LoadDanhSachCongDoan(ds);
			}
		}
		if (o.equals(btnTimSP)) {
			String timMaSP = txtTimSP.getText();
			if (timMaSP.trim().isEmpty())
				JOptionPane.showMessageDialog(this, "Chưa nhập mã sản phẩm!");
			else {
				ArrayList<SanPham> ds = sanPham_DAO.timKiemSanPhamTheoMaSanPham(timMaSP);
				LoadDanhSachSanPham(ds);
			}
		}
		if (o.equals(btnLamMoi)) {
			clearCongDoanFields();
			LoadDanhSachSanPham(sanPham_DAO.getAllSanPham());
			LoadDanhSachCongDoan(congDoan_DAO.getAllCongDoan());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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

	private void addTableSelectionListener(JTable table) {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) {
						CongDoan cd = (CongDoan) tblCD.getValueAt(selectedRow, 1);
						txtMaCD.setText(cd.getMaCD());
						txtTenCD.setText(cd.getTenCD());
						spnSoThuTu.setValue(cd.getsoThuTu());
						spnSoLuongCan.setValue(cd.getsoLuongCan());
						spnGia.setValue(cd.getGia());
						txtTrangThai.setText(table.getValueAt(selectedRow, 5).toString());
						String ghiChu_tam = "";
						if (table.getValueAt(selectedRow, 7) != null) {
							ghiChu_tam = table.getValueAt(selectedRow, 7).toString();
						}
						txtGhiChu.setText(ghiChu_tam);
					}
				}
			}
		});
	}
}
