package gui;

import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import dao.BangChamCongNhanVien_DAO;
import dao.PhongBan_DAO;
import entity.BangChamCongNhanVien;
import entity.PhongBan;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

/**
 * @author Nguyễn Thành An
 */
public class ChamCongNhanVien_Panel extends JPanel implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	private JTable tblChamCong;
	private JTextField txtTimTenNV;
	private DefaultTableModel model;
	private BangChamCongNhanVien_DAO bangChamCongNhanVien_DAO = new BangChamCongNhanVien_DAO();
	private PhongBan_DAO phongBan_dao = new PhongBan_DAO();
	private JDateChooser dateNgayCham;
	private JButton btnTimTheoTen;
	private JButton btnChamCong;
	private JButton btnSua;
	private JComboBox<String> comboBoxTrangThai;
	private JButton btnDSChuaCham;
	private JButton btnDSDaCham;
	private JComboBox<PhongBan> cmbPhongBan;
	private JButton btnTimTheoPB;

	public ChamCongNhanVien_Panel() {
		setBackground(new Color(255, 255, 255));
		setBorder(new TitledBorder(null, "CHẤM CÔNG NHÂN VIÊN", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(new Color(255, 255, 255));
		pnlTop.setPreferredSize(new Dimension(10, 180));
		add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(null);

		JLabel lblNgayCham = new JLabel("Ngày chấm công:");
		lblNgayCham.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayCham.setBounds(324, 48, 116, 25);
		pnlTop.add(lblNgayCham);

		dateNgayCham = new JDateChooser();
		dateNgayCham.setDate(new Date());
		dateNgayCham.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateNgayCham.setLocale(new Locale("vi", "VN"));
		dateNgayCham.setDateFormatString("dd/MM/yyyy");
		dateNgayCham.setBounds(448, 48, 150, 25);
		pnlTop.add(dateNgayCham);

		JLabel lblTmTheoTen = new JLabel("Tìm theo tên:");
		lblTmTheoTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTmTheoTen.setBounds(629, 48, 116, 25);
		pnlTop.add(lblTmTheoTen);

		txtTimTenNV = new JTextField();
		txtTimTenNV.setBounds(768, 49, 150, 25);
		pnlTop.add(txtTimTenNV);
		txtTimTenNV.setColumns(10);

		btnTimTheoTen = new JButton("");
		btnTimTheoTen.setBorderPainted(false);
		URL urlBtnTimTheoTen = ChamCongNhanVien_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
		btnTimTheoTen.setIcon(new ImageIcon(urlBtnTimTheoTen));
		btnTimTheoTen.setBackground(new Color(255, 255, 255));
		btnTimTheoTen.setBounds(928, 46, 30, 30);
		pnlTop.add(btnTimTheoTen);

		JLabel lblTmTheoPB = new JLabel("Tìm theo phòng ban:");
		lblTmTheoPB.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTmTheoPB.setBounds(629, 83, 129, 25);
		pnlTop.add(lblTmTheoPB);

		cmbPhongBan = new JComboBox<>();
		cmbPhongBan.setBounds(768, 84, 150, 25);
		pnlTop.add(cmbPhongBan);

		btnDSDaCham = new JButton("DS đã chấm");
		URL urlBtnDSDaCham = ChamCongNhanVien_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
		btnDSDaCham.setIcon(new ImageIcon(urlBtnDSDaCham));
		btnDSDaCham.setBackground(new Color(255, 255, 255));
		btnDSDaCham.setHorizontalAlignment(SwingConstants.LEFT);
		btnDSDaCham.setBounds(448, 123, 150, 30);
		pnlTop.add(btnDSDaCham);

		btnDSChuaCham = new JButton("DS chưa chấm");
		URL urlBtnDSChuaCham = ChamCongNhanVien_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
		btnDSChuaCham.setIcon(new ImageIcon(urlBtnDSChuaCham));
		btnDSChuaCham.setBackground(new Color(255, 255, 255));
		btnDSChuaCham.setHorizontalAlignment(SwingConstants.LEFT);
		btnDSChuaCham.setBounds(448, 83, 150, 30);
		pnlTop.add(btnDSChuaCham);

		btnTimTheoPB = new JButton("");
		btnTimTheoPB.setBorderPainted(false);
		URL urlBtnTimTheoPB = ChamCongNhanVien_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
		btnTimTheoPB.setIcon(new ImageIcon(urlBtnTimTheoPB));
		btnTimTheoPB.setBackground(new Color(255, 255, 255));
		btnTimTheoPB.setBounds(928, 83, 30, 30);
		pnlTop.add(btnTimTheoPB);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(255, 255, 255));
		pnlCenter.setBorder(new TitledBorder(null, "Danh sách chấm công nhân viên", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));

		String header[] = { "STT", "Mã nhân viên", "Họ tên", "Trạng thái", "Số giờ tăng ca", "Ghi chú" };
		model = new DefaultTableModel(header, 0) {
			private static final long serialVersionUID = 1L;

			private static int clamp(Number value, int min, int max) {
				return Math.min(Math.max(value.intValue(), min), max);
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (columnIndex == 3) {
					return JComboBox.class;
				}

				if (columnIndex == 4) {
					return Integer.class;
				}
				return super.getColumnClass(columnIndex);
			}

			@Override
			public void setValueAt(Object value, int row, int column) {
				if (column == 4 && value instanceof Number) {
					super.setValueAt(clamp((Number) value, 0, 4), row, column);
				} else {
					super.setValueAt(value, row, column);
				}
			}

		};
		comboBoxTrangThai = new JComboBox<>(
				new String[] { "Nguyên ngày", "Nửa ngày", "Vắng không phép", "Vắng có phép" });
		JScrollPane scrollPane = new JScrollPane();
		pnlCenter.add(scrollPane);

		tblChamCong = new JTable(model);
		tblChamCong.setSelectionForeground(new Color(255, 255, 255));
		tblChamCong.setSelectionBackground(new Color(0, 128, 255));
		tblChamCong.setRowHeight(20);
		tblChamCong.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBoxTrangThai));
		tblChamCong.getColumnModel().getColumn(3).setCellRenderer(new ComboBoxTableCellRenderer());

		tblChamCong.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblChamCong);

		JPanel pnlSouth = new JPanel();
		pnlSouth.setPreferredSize(new Dimension(10, 50));
		pnlSouth.setBackground(Color.WHITE);
		pnlCenter.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));

		btnChamCong = new JButton("Chấm công");
		URL urlBtnChamCong = ChamCongNhanVien_Panel.class.getResource("/img/tick.png");
		btnChamCong.setIcon(new ImageIcon(urlBtnChamCong));
		btnChamCong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlSouth.add(btnChamCong);

		btnSua = new JButton("Lưu");
		btnSua.setEnabled(false);
		URL urlBtnSua = ChamCongNhanVien_Panel.class.getResource("/img/Oxygen-Icons.org-Oxygen-Actions-document-save.24.png");
		btnSua.setIcon(new ImageIcon(urlBtnSua));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSua.setEnabled(false);
		pnlSouth.add(btnSua);

		loadPhongBan(phongBan_dao.getAllPhongBan());
		loadDanhSachChamCong(bangChamCongNhanVien_DAO.getDanhSachChamCongTheoNgay(dateNgayCham.getDate()));

		btnDSChuaCham.addActionListener(this);
		btnDSDaCham.addActionListener(this);
		btnTimTheoTen.addActionListener(this);
		btnTimTheoPB.addActionListener(this);
		btnChamCong.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimTheoTen.addActionListener(this);
	}

	private static class ComboBoxTableCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {
		private static final long serialVersionUID = 1L;

		@Override
		public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
				boolean hasFocus, int row, int column) {
			if (value instanceof JComboBox) {
				return (JComboBox<?>) value;
			}
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
	}

	private void clearTable() {
		int r = tblChamCong.getRowCount();
		while (r > 0) {
			model.removeRow(r - 1);
			r--;
		}
	}

	private void loadPhongBan(ArrayList<PhongBan> ds) {
		cmbPhongBan.removeAllItems();
		for (PhongBan t : ds) {
			cmbPhongBan.addItem(t);
		}
	}

	private void loadDanhSachChamCong(ArrayList<BangChamCongNhanVien> ds) {
		clearTable();
		int i = 1;
		String str = new String("Nguyên ngày");
		for (BangChamCongNhanVien cc : ds) {
			model.addRow(
					new Object[] { i++, cc, cc.getNhanVien().getHoTen(), str, cc.getSoGIoTangCa(), cc.getGhiChu() });
		}
	}

	private void loadDanhSachDaChamCong(ArrayList<BangChamCongNhanVien> ds) {
		clearTable();
		int i = 1;
		for (BangChamCongNhanVien cc : ds) {
			String trangThai = null;
			if (cc.getTrangThaiDiLam() == 1) {
				trangThai = new String("Nguyên ngày");
			}
			if (cc.getTrangThaiDiLam() == 2) {
				trangThai = new String("Nửa ngày");
			}
			if (cc.getTrangThaiDiLam() == 3) {
				trangThai = new String("Vắng không phép");
			}
			if (cc.getTrangThaiDiLam() == 4) {
				trangThai = new String("Vắng có phép");
			}

			model.addRow(new Object[] { i++, cc, cc.getNhanVien().getHoTen(), trangThai, cc.getSoGIoTangCa(),
					cc.getGhiChu() });
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnChamCong)) {
			int rowCount = tblChamCong.getRowCount();
			if (rowCount == 0) {
				JOptionPane.showMessageDialog(this, "Danh sách rỗng !");
				return;
			}

			ArrayList<BangChamCongNhanVien> dsCC = new ArrayList<>();
			while (rowCount > 0) {
				BangChamCongNhanVien cc = (BangChamCongNhanVien) tblChamCong.getValueAt(rowCount - 1, 1);

				String trangThaiDiLam = tblChamCong.getValueAt(rowCount - 1, 3).toString();
				int trangThai = 0;
				if (trangThaiDiLam.equalsIgnoreCase("Nguyên ngày")) {
					trangThai = 1;
				}
				if (trangThaiDiLam.equalsIgnoreCase("Nửa ngày")) {
					trangThai = 2;
				}
				if (trangThaiDiLam.equalsIgnoreCase("Vắng không phép")) {
					trangThai = 3;
				}
				if (trangThaiDiLam.equalsIgnoreCase("Vắng có phép")) {
					trangThai = 4;
				}

				cc.setNgayCham(dateNgayCham.getDate());
				cc.setTrangThaiDiLam(trangThai);
				int soGioTangCa = Integer.parseInt(tblChamCong.getValueAt(rowCount - 1, 4).toString());
				cc.setSoGIoTangCa(soGioTangCa);
				String ghiChu = (String) tblChamCong.getValueAt(rowCount - 1, 5);
				cc.setGhiChu(ghiChu);
				dsCC.add(cc);
				rowCount--;
			}

			int insertSuccess = 0;
			int insertFail = 0;
			if (dsCC.size() > 0) {
				for (BangChamCongNhanVien cc : dsCC) {
					if (bangChamCongNhanVien_DAO.them(cc)) {
						insertSuccess++;
					} else {
						insertFail++;
					}
				}
			}
			JOptionPane.showMessageDialog(this,
					"Insert thành công: " + insertSuccess + "\nInsert thất bại: " + insertFail);
			loadDanhSachDaChamCong(bangChamCongNhanVien_DAO.getDanhSachDaChamCongTheoNgay(dateNgayCham.getDate()));
			btnChamCong.setEnabled(false);

		}

		if (o.equals(btnSua)) {
			int rowCount = tblChamCong.getRowCount();
			if (rowCount == 0) {
				JOptionPane.showMessageDialog(this, "Danh sách rỗng !");
				return;
			}

			ArrayList<BangChamCongNhanVien> dsCC = new ArrayList<>();
			while (rowCount > 0) {
				BangChamCongNhanVien cc = (BangChamCongNhanVien) tblChamCong.getValueAt(rowCount - 1, 1);

				String trangThaiDiLam = tblChamCong.getValueAt(rowCount - 1, 3).toString();
				int trangThai = 0;
				if (trangThaiDiLam.equalsIgnoreCase("Nguyên ngày")) {
					trangThai = 1;
				}
				if (trangThaiDiLam.equalsIgnoreCase("Nửa ngày")) {
					trangThai = 2;
				}
				if (trangThaiDiLam.equalsIgnoreCase("Vắng không phép")) {
					trangThai = 3;
				}
				if (trangThaiDiLam.equalsIgnoreCase("Vắng có phép")) {
					trangThai = 4;
				}
				cc.setTrangThaiDiLam(trangThai);
				int soGioTangCa = Integer.parseInt(tblChamCong.getValueAt(rowCount - 1, 4).toString());
				cc.setSoGIoTangCa(soGioTangCa);
				String ghiChu = (String) tblChamCong.getValueAt(rowCount - 1, 5);
				cc.setGhiChu(ghiChu);
				dsCC.add(cc);
				rowCount--;
			}

			int updateSuccess = 0;
			int updateFail = 0;
			if (dsCC.size() > 0) {
				for (BangChamCongNhanVien cc : dsCC) {
					if (bangChamCongNhanVien_DAO.capNhat(cc)) {
						updateSuccess++;
					} else {
						updateFail++;
					}
				}
			}
			JOptionPane.showMessageDialog(this,
					"Update thành công: " + updateSuccess + "\nUpdate thất bại: " + updateFail);
			loadDanhSachDaChamCong(bangChamCongNhanVien_DAO.getDanhSachDaChamCongTheoNgay(dateNgayCham.getDate()));
		}

		if (o.equals(btnDSChuaCham)) {
			btnChamCong.setEnabled(true);
			btnSua.setEnabled(false);
			loadDanhSachChamCong(bangChamCongNhanVien_DAO.getDanhSachChamCongTheoNgay(dateNgayCham.getDate()));
		}

		if (o.equals(btnTimTheoTen)) {
			btnChamCong.setEnabled(true);
			btnSua.setEnabled(false);
			Date date = dateNgayCham.getDate();
			String timKiem = new String(txtTimTenNV.getText().trim());
			loadDanhSachChamCong(bangChamCongNhanVien_DAO.getDanhSachChamCongTheoDieuKien(date, timKiem));
		}

		if (o.equals(btnTimTheoPB)) {
			btnChamCong.setEnabled(true);
			btnSua.setEnabled(false);
			Date date = dateNgayCham.getDate();
			PhongBan pb = (PhongBan) cmbPhongBan.getSelectedItem();
			loadDanhSachChamCong(bangChamCongNhanVien_DAO.getDanhSachChamCongTheoDieuKien(date, pb));
		}

		if (o.equals(btnDSDaCham)) {
			loadDanhSachDaChamCong(bangChamCongNhanVien_DAO.getDanhSachDaChamCongTheoNgay(dateNgayCham.getDate()));
			btnChamCong.setEnabled(false);
			btnSua.setEnabled(true);
		}

	}
}