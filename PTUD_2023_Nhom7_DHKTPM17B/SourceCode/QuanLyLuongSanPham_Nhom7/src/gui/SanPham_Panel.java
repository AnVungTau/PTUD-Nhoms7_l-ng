package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultFormatter;
import dao.HopDong_DAO;
import dao.SanPham_DAO;
import entity.HopDong;
import entity.SanPham;
import util.QuanLyMaSanPham;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.BorderFactory;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 * @author Trần Vũ Minh Nhật && Nguyễn Hồng Quân
 */
public class SanPham_Panel extends JPanel implements ActionListener, MouseListener, TableModelListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtTimHopDong;
	private JTable tblHopDong;
	private JTextField txtMaSanPham;
	private JTextField txtTenSanPham;
	private JTable tblSanPham;
	private DefaultTableModel modelHD;
	private JButton btnTimHopDong;
	private JButton btnLamMoi;
	private JSpinner spnSoLuong;
	private JComboBox<String> cmbDonViTinh;
	private JButton btnThem;
	private JButton btnLuu;
	private JPanel pnlDanhSachSanPham;
	private JTextField txtTimSanPham;
	private SanPham_DAO sanPham_dao = new SanPham_DAO();
	private HopDong_DAO hopDong_dao = new HopDong_DAO();
	private JTextArea txtGhiChu;
	private JLabel lblTBTenSP;
	private JButton btnLamMoiHD;
	private DefaultTableModel modelSP;
	private JButton btnTimSP;
	private JComboBox<String> cmbLoc;
	private URL urlTim = SanPham_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
	private URL urlThem = SanPham_Panel.class.getResource("/img/Custom-Icon-Design-Flatastic-1-Add-1.24.png");
	private URL urlLamMoi = SanPham_Panel.class.getResource("/img/Hopstarter-Button-Button-Reload.24.png");
	private URL urlLuu = SanPham_Panel.class.getResource("/img/Oxygen-Icons.org-Oxygen-Actions-document-save.24.png");
	private URL urlTBFail = SanPham_Panel.class.getResource("/img/Saki-NuoveXT-Actions-button-cancel.16.png");
	private URL urlTBSuccess = SanPham_Panel.class.getResource("/img/Custom-Icon-Design-Pretty-Office-8-Accept.16.png");
	public SanPham_Panel() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));

		JPanel pnlNorth = new JPanel();
		pnlNorth.setPreferredSize(new Dimension(10, 330));
		pnlNorth.setSize(new Dimension(0, 300));
		add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setLayout(new BorderLayout(0, 0));

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(new Color(255, 255, 255));
		pnlNorth.add(pnlTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("THÔNG TIN SẢN PHẨM ");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnlTitle.add(lblTitle);

		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setBackground(new Color(255, 255, 255));
		pnlNorth.add(pnlThongTin, BorderLayout.CENTER);
		pnlThongTin.setLayout(null);

		JPanel pnlDanhSachHopDong = new JPanel();
		pnlDanhSachHopDong.setBackground(new Color(255, 255, 255));
		pnlDanhSachHopDong.setBorder(
				new TitledBorder(null, "Danh s\u00E1ch hợp đồng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachHopDong.setBounds(300, 10, 380, 230);
		pnlThongTin.add(pnlDanhSachHopDong);
		pnlDanhSachHopDong.setLayout(new BorderLayout(0, 0));

		JPanel pnlTim = new JPanel();
		pnlTim.setBackground(new Color(255, 255, 255));
		pnlTim.setPreferredSize(new Dimension(10, 35));
		pnlDanhSachHopDong.add(pnlTim, BorderLayout.NORTH);
		pnlTim.setLayout(null);

		txtTimHopDong = new JTextField();
		txtTimHopDong.setColumns(10);
		txtTimHopDong.setBounds(167, 5, 120, 25);
		pnlTim.add(txtTimHopDong);

		btnTimHopDong = new JButton("");
		btnTimHopDong.setBorderPainted(false);
		btnTimHopDong.setBackground(new Color(255, 255, 255));
		btnTimHopDong.setBorderPainted(false);
		btnTimHopDong.setIcon(new ImageIcon(urlTim));
		btnTimHopDong.setBounds(295, 5, 25, 25);
		pnlTim.add(btnTimHopDong);

		btnLamMoiHD = new JButton("");
		btnLamMoiHD.setBorderPainted(false);
		btnLamMoiHD.setBackground(new Color(255, 255, 255));
		btnLamMoiHD.setIcon(new ImageIcon(urlLamMoi));
		btnLamMoiHD.setBounds(24, 5, 25, 25);
		pnlTim.add(btnLamMoiHD);

		JLabel lblTnH = new JLabel("Tên HĐ");
		lblTnH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTnH.setBounds(109, 4, 60, 25);
		pnlTim.add(lblTnH);

		JPanel pnlTableHopDong = new JPanel();
		pnlTableHopDong.setBackground(new Color(255, 255, 255));
		pnlDanhSachHopDong.add(pnlTableHopDong, BorderLayout.CENTER);
		pnlTableHopDong.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		pnlTableHopDong.add(scrollPane);

		String headerHD[] = { "Mã HD", "Hợp đồng" };
		modelHD = new DefaultTableModel(headerHD, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblHopDong = new JTable(modelHD);
		tblHopDong.setRowHeight(20);
		tblHopDong.setSelectionForeground(new Color(255, 255, 255));
		tblHopDong.setFillsViewportHeight(true);
		tblHopDong.setGridColor(new Color(128, 128, 128));
		tblHopDong.setSelectionBackground(new Color(0, 128, 255));
		scrollPane.setViewportView(tblHopDong);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(new Color(255, 255, 255));
		btnLamMoi.setIcon(new ImageIcon(urlLamMoi));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setBounds(730, 247, 120, 30);
		pnlThongTin.add(btnLamMoi);

		JLabel lblMaSanPham = new JLabel("Mã sản phẩm");
		lblMaSanPham.setBounds(803, 20, 115, 25);
		pnlThongTin.add(lblMaSanPham);
		lblMaSanPham.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtMaSanPham = new JTextField();
		txtMaSanPham.setBounds(903, 20, 150, 25);
		pnlThongTin.add(txtMaSanPham);
		txtMaSanPham.setDisabledTextColor(new Color(0, 0, 0));
		txtMaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtMaSanPham.setEnabled(false);
		txtMaSanPham.setColumns(10);

		JLabel lblTenSanPham = new JLabel("Tên sản phẩm");
		lblTenSanPham.setBounds(803, 55, 100, 25);
		pnlThongTin.add(lblTenSanPham);
		lblTenSanPham.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setBounds(803, 90, 115, 25);
		pnlThongTin.add(lblSoLuong);
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtTenSanPham = new JTextField();
		txtTenSanPham.setBounds(903, 55, 150, 25);
		pnlThongTin.add(txtTenSanPham);

		JLabel lblGhiChu = new JLabel("Ghi chú");
		lblGhiChu.setBounds(803, 160, 81, 25);
		pnlThongTin.add(lblGhiChu);
		lblGhiChu.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblDonViTinh = new JLabel("Đơn vị tính");
		lblDonViTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDonViTinh.setBounds(803, 125, 115, 25);
		pnlThongTin.add(lblDonViTinh);

		cmbDonViTinh = new JComboBox<String>();
		cmbDonViTinh.setModel(new DefaultComboBoxModel<String>(new String[] { "Cái", "Chiếc", "Tấm" }));
		cmbDonViTinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbDonViTinh.setBounds(903, 125, 150, 25);
		pnlThongTin.add(cmbDonViTinh);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(urlThem));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBackground(Color.WHITE);
		btnThem.setBounds(860, 247, 120, 30);
		pnlThongTin.add(btnThem);

		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setIcon(new ImageIcon(urlLuu));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBackground(Color.WHITE);
		btnLuu.setBounds(990, 247, 120, 30);
		pnlThongTin.add(btnLuu);

		spnSoLuong = new JSpinner();
		spnSoLuong.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(10)));
		spnSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnSoLuong.setBounds(903, 90, 150, 25);
		customJSpiner(spnSoLuong);
		pnlThongTin.add(spnSoLuong);

		txtGhiChu = new JTextArea();
		txtGhiChu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtGhiChu.setBounds(903, 161, 150, 55);
		pnlThongTin.add(txtGhiChu);

		lblTBTenSP = new JLabel("");
		lblTBTenSP.setIcon(new ImageIcon(urlTBFail));
		lblTBTenSP.setHorizontalAlignment(SwingConstants.CENTER);
		lblTBTenSP.setBackground(Color.WHITE);
		lblTBTenSP.setBounds(1063, 55, 25, 25);
		pnlThongTin.add(lblTBTenSP);

		pnlDanhSachSanPham = new JPanel();
		pnlDanhSachSanPham.setBorder(
				new TitledBorder(null, "Danh s\u00E1ch sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachSanPham.setBackground(new Color(255, 255, 255));
		add(pnlDanhSachSanPham, BorderLayout.CENTER);
		pnlDanhSachSanPham.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(255, 255, 255));
		pnlDanhSachSanPham.add(scrollPane_1);

		String headerSP[] = { "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn vị tính", "Hợp đồng", "Ghi chú" };
		modelSP = new DefaultTableModel(headerSP, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblSanPham = new JTable(modelSP);
		tblSanPham.setSelectionForeground(new Color(255, 255, 255));
		tblSanPham.setRowHeight(20);
		tblSanPham.setGridColor(new Color(128, 128, 128));
		tblSanPham.setFillsViewportHeight(true);
		tblSanPham.setSelectionBackground(new Color(0, 128, 255));
		scrollPane_1.setViewportView(tblSanPham);

		JPanel pnlTimSP = new JPanel();
		pnlTimSP.setLayout(null);
		pnlTimSP.setSize(new Dimension(0, 100));
		pnlTimSP.setPreferredSize(new Dimension(10, 35));
		pnlTimSP.setBackground(Color.WHITE);
		pnlDanhSachSanPham.add(pnlTimSP, BorderLayout.NORTH);

		txtTimSanPham = new JTextField();
		txtTimSanPham.setColumns(10);
		txtTimSanPham.setBounds(341, 5, 226, 25);
		pnlTimSP.add(txtTimSanPham);

		cmbLoc = new JComboBox<String>();
		cmbLoc.setModel(new DefaultComboBoxModel<String>(new String[] { "Tất cả", "Tên sản phẩm" }));
		cmbLoc.setBounds(80, 5, 116, 25);
		pnlTimSP.add(cmbLoc);

		JLabel lblLoc = new JLabel("Lọc");
		lblLoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoc.setBounds(10, 5, 60, 25);
		pnlTimSP.add(lblLoc);

		btnTimSP = new JButton("");
		btnTimSP.setBorderPainted(false);
		btnTimSP.setIcon(new ImageIcon(urlTim));
		btnTimSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimSP.setBorderPainted(false);
		btnTimSP.setBackground(Color.WHITE);
		btnTimSP.setBounds(577, 5, 25, 25);
		pnlTimSP.add(btnTimSP);

		txtTenSanPham.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				btnThem.setEnabled(enableThem());
				btnLuu.setEnabled(enableLuu());
				if (valiDataTenSP()) {
					lblTBTenSP.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBTenSP.setIcon(new ImageIcon(urlTBFail));
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				btnThem.setEnabled(enableThem());
				btnLuu.setEnabled(enableLuu());
				if (valiDataTenSP()) {
					lblTBTenSP.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBTenSP.setIcon(new ImageIcon(urlTBFail));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		
		txtTimSanPham.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String value = cmbLoc.getSelectedItem().toString();
				locSanPham(value);
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String value = cmbLoc.getSelectedItem().toString();
				locSanPham(value);
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnTimHopDong.addActionListener(this);
		btnTimSP.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnLamMoiHD.addActionListener(this);
		tblHopDong.addMouseListener(this);
		tblSanPham.addMouseListener(this);
		modelHD.addTableModelListener(this);

		LoadDanhSachSanPham(sanPham_dao.getAllSanPham());
		LoadDanhSachHopDong(hopDong_dao.getAllHopDong());

		TableRowSorter<TableModel> sorterHD = new TableRowSorter<TableModel>(modelHD);
		tblHopDong.setRowSorter(sorterHD);
		TableRowSorter<TableModel> sorterSP = new TableRowSorter<TableModel>(modelSP);
		tblSanPham.setRowSorter(sorterSP);
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

	private void clearTable(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int r = table.getRowCount();
		while (r > 0) {
			model.removeRow(r - 1);
			r--;
		}
	}

	private boolean valiDataTenSP() {
		String tenSP = txtTenSanPham.getText().trim();
		if (tenSP.isEmpty()) {
			return false;
		}
		return true;
	}

	private boolean enableThem() {
		int r = tblHopDong.getSelectedRow();
		if (valiDataTenSP() && r >= 0) {
			return true;
		}
		return false;
	}

	private boolean enableLuu() {
		if (valiDataTenSP()) {
			return true;
		}
		return false;
	}

	private void LoadDanhSachHopDong(ArrayList<HopDong> dsHD) {
		clearTable(tblHopDong);
		for (HopDong hd : dsHD) {
			modelHD.addRow(new Object[] { hd.getMaHD(), hd });
		}
	}

	private void LoadDanhSachSanPham(ArrayList<SanPham> dsSP) {
		clearTable(tblSanPham);

		for (SanPham sp : dsSP) {
			modelSP.addRow(new Object[] { sp.getMaSP(), sp, sp.getSoLuong(), sp.getDonViTinh(),
					sp.getHopDong().getTenHD(), sp.getGhiChu() });
		}
	}

	private void fillForm() {
		int r = tblSanPham.getSelectedRow();
		if (r < 0) {
			return;
		}
		SanPham sp = (SanPham) tblSanPham.getValueAt(r, 1);
		if (sp != null) {
			txtMaSanPham.setText(sp.getMaSP());
			txtTenSanPham.setText(sp.getTenSP());
			spnSoLuong.setValue(sp.getSoLuong());
			String donVi = new String(sp.getDonViTinh());
			cmbDonViTinh.setSelectedItem(donVi);
			txtGhiChu.setText(sp.getGhiChu());
			LoadDanhSachHopDong(hopDong_dao.getHopDongByMa(sp.getHopDong().getMaHD()));
		}
	}

	public void locSanPham(String locValue) {
		try {
			String tenSP = txtTimSanPham.getText();
			ArrayList<SanPham> danhSachSanPham = null;

			if (locValue.equals("Tất cả")) {
				danhSachSanPham = sanPham_dao.getAllSanPham();
				return;
			}

			if (locValue.equals("Tên sản phẩm")) {
				danhSachSanPham = sanPham_dao.timKiemSanPhamTheoTenSanPham(tenSP);
			}
			LoadDanhSachSanPham(danhSachSanPham);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void themSanPham() {
		QuanLyMaSanPham qlMa = new QuanLyMaSanPham();
		String maSanPham = qlMa.generateMaSanPham();
		String tenSanPham = txtTenSanPham.getText();
		int soLuong = (int) spnSoLuong.getValue();
		String donViTinh = cmbDonViTinh.getSelectedItem().toString();
		String ghiChu = txtGhiChu.getText();

		int r = tblHopDong.getSelectedRow();
		if (r < 0) {
			JOptionPane.showMessageDialog(this, "Chọn hợp đồng trước !");
			return;
		}
		HopDong hd = (HopDong) tblHopDong.getValueAt(r, 1);

		if (tenSanPham.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return;
		}
		SanPham sanPham = new SanPham(maSanPham, tenSanPham, soLuong, donViTinh, ghiChu, hd);

		boolean success = sanPham_dao.themSanPham(sanPham);
		if (success) {
			JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công.");
			LoadDanhSachSanPham(sanPham_dao.getAllSanPham());
		} else {
			JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void suaSanPham() {
		String maSanPham = txtMaSanPham.getText().trim();
		String tenSanPham = txtTenSanPham.getText();
		int soLuong = (int) spnSoLuong.getValue();
		String donViTinh = cmbDonViTinh.getSelectedItem().toString();
		String ghiChu = txtGhiChu.getText();

		int r = tblSanPham.getSelectedRow();
		if (r < 0) {
			JOptionPane.showMessageDialog(this, "Chọn sản phẩm trước !");
			return;
		}
		SanPham sp = (SanPham) tblSanPham.getValueAt(r, 1);

		if (tenSanPham.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return;
		}
		SanPham sanPham = new SanPham(maSanPham, tenSanPham, soLuong, donViTinh, ghiChu, sp.getHopDong());

		boolean success = sanPham_dao.capNhatSanPham(sanPham);
		if (success) {
			JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công.");
			LoadDanhSachSanPham(sanPham_dao.getAllSanPham());
		} else {
			JOptionPane.showMessageDialog(this, "Sửa sản phẩm thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnTimHopDong)) {
			String tenHD = txtTimHopDong.getText().trim();

			if (!tenHD.trim().isEmpty()) {
				ArrayList<HopDong> dsHD = HopDong_DAO.timKiemHopDongTheoTen(tenHD);
				LoadDanhSachHopDong(dsHD);
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khoá để tìm kiếm hợp đồng.", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		if (o.equals(btnTimSP)) {
			String value = cmbLoc.getSelectedItem().toString();
			locSanPham(value);
		}

		if (o.equals(btnLamMoi)) {
			txtTimHopDong.setText("");
			LoadDanhSachHopDong(hopDong_dao.getAllHopDong());
			txtMaSanPham.setText("");
			txtTenSanPham.setText("");
			spnSoLuong.setValue(0);
			cmbDonViTinh.setSelectedIndex(0);
			txtGhiChu.setText("");
			LoadDanhSachSanPham(sanPham_dao.getAllSanPham());
		}

		if (o.equals(btnThem)) {
			themSanPham();
		}

		if (o.equals(btnLuu)) {
			if(JOptionPane.showConfirmDialog(this, "Bạn muốn lưu thay đổi", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				suaSanPham();
			}
		}

		if (o.equals(btnLamMoiHD)) {
			LoadDanhSachHopDong(hopDong_dao.getAllHopDong());
		}
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		if (e.getType() == TableModelEvent.INSERT) {
			btnThem.setEnabled(enableThem());
			btnLuu.setEnabled(enableLuu());
		}

		if (e.getType() == TableModelEvent.DELETE) {
			btnThem.setEnabled(enableThem());
			btnLuu.setEnabled(enableLuu());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		btnThem.setEnabled(enableThem());
		btnLuu.setEnabled(enableThem());

		Object o = e.getSource();
		if (o.equals(tblHopDong)) {
			btnLuu.setEnabled(false);
			int r = tblHopDong.getSelectedRow();
			if (r < 0) {
				return;
			}
			HopDong hd = (HopDong) tblHopDong.getValueAt(r, 1);
			LoadDanhSachSanPham(sanPham_dao.timSanPhamTheoMaHopDong(hd.getMaHD()));
		}

		if (o.equals(tblSanPham)) {
			fillForm();
			btnLuu.setEnabled(enableLuu());
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}