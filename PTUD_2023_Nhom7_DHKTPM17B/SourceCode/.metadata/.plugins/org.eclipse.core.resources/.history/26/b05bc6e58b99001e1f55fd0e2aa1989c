package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultFormatter;
import com.toedter.calendar.JDateChooser;
import dao.BangPhanCong_DAO;
import dao.CongDoan_DAO;
import dao.SanPham_DAO;
import dao.ToNhom_DAO;
import entity.BangPhanCong;
import entity.CongDoan;
import entity.CongNhan;
import entity.SanPham;
import entity.ToNhom;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.border.EtchedBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;

/**
 * @author Nguyễn Hồng Quân
 */
public class PhanCongCongNhan_Panel extends JPanel
		implements MouseListener, ActionListener, ItemListener, TableModelListener {

	private static final long serialVersionUID = 1L;
	private JTable tblCongNhan;
	private JTable tblSanPham;
	private JTable tblCongDoan;
	private JTable tblDSPhanCong;
	private JTextField txtTimPC;
	private DefaultTableModel modelCongNhan;
	private SanPham_DAO sanPham_dao = new SanPham_DAO();
	private CongDoan_DAO congDoan_dao = new CongDoan_DAO();
	private ToNhom_DAO to_dao = new ToNhom_DAO();
	private BangPhanCong_DAO bangPhanCong_dao = new BangPhanCong_DAO();
	private DefaultTableModel modelSanPham;
	private DefaultTableModel modelCongDoan;
	private JButton btnThem;
	private JDateChooser dateNgayPhanCong;
	private DefaultTableModel modelPhanCong;
	private JTable tblCongNhanDuocChon;
	private JComboBox<ToNhom> cmbTo;
	private DefaultTableModel modelCongNhanDuocChon;
	private ArrayList<BangPhanCong> temp = new ArrayList<>();
	private JButton btnLamMoi;
	private JButton btnTimTheoNgay;
	private JComboBox<String> cmbLoc;
	private JButton btnXoa;
	private JButton btnSua;
	private URL urlTim = PhanCongCongNhan_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
	private URL urlThem = PhanCongCongNhan_Panel.class.getResource("/img/Custom-Icon-Design-Flatastic-1-Add-1.24.png");
	private URL urlXoa = PhanCongCongNhan_Panel.class.getResource("/img/Pictogrammers-Material-Delete-forever.24.png");
	private URL urlLamMoi = PhanCongCongNhan_Panel.class.getResource("/img/Hopstarter-Button-Button-Reload.24.png");
	private URL urlLuu = PhanCongCongNhan_Panel.class.getResource("/img/Oxygen-Icons.org-Oxygen-Actions-document-save.24.png");
	public PhanCongCongNhan_Panel() {
		setLayout(new BorderLayout(0, 0));

		JPanel pnlTop = new JPanel();
		pnlTop.setPreferredSize(new Dimension(10, 400));
		pnlTop.setBackground(Color.WHITE);
		add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(null);

		JScrollPane scrollPane_CongNhan = new JScrollPane();
		scrollPane_CongNhan.setBorder(
				new TitledBorder(null, "C\u00F4ng nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_CongNhan.setBounds(370, 80, 300, 300);
		pnlTop.add(scrollPane_CongNhan);

		String headerCN[] = { "Mã CN", "Họ tên" };
		modelCongNhan = new DefaultTableModel(headerCN, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblCongNhan = new JTable(modelCongNhan);
		tblCongNhan.setRowHeight(20);
		tblCongNhan.setSelectionForeground(new Color(255, 255, 255));
		tblCongNhan.setSelectionBackground(new Color(0, 128, 255));
		tblCongNhan.setFillsViewportHeight(true);
		scrollPane_CongNhan.setViewportView(tblCongNhan);

		JScrollPane scrollPane_SanPham = new JScrollPane();
		scrollPane_SanPham.setBorder(
				new TitledBorder(null, "S\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_SanPham.setBounds(50, 80, 250, 130);
		pnlTop.add(scrollPane_SanPham);

		String headerSP[] = { "Mã SP", "Tên SP" };
		modelSanPham = new DefaultTableModel(headerSP, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblSanPham = new JTable(modelSanPham);
		tblSanPham.setRowHeight(20);
		tblSanPham.setSelectionForeground(new Color(255, 255, 255));
		tblSanPham.setSelectionBackground(new Color(0, 128, 255));
		tblSanPham.setFillsViewportHeight(true);
		scrollPane_SanPham.setViewportView(tblSanPham);

		JScrollPane scrollPane_CongDoan = new JScrollPane();
		scrollPane_CongDoan.setBorder(
				new TitledBorder(null, "C\u00F4ng \u0111o\u1EA1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_CongDoan.setBounds(50, 250, 250, 130);
		pnlTop.add(scrollPane_CongDoan);

		String headerCD[] = { "Mã CĐ", "Tên CĐ", "Số lượng cần" };
		modelCongDoan = new DefaultTableModel(headerCD, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblCongDoan = new JTable(modelCongDoan);
		tblCongDoan.setRowHeight(20);
		tblCongDoan.setSelectionForeground(new Color(255, 255, 255));
		tblCongDoan.setSelectionBackground(new Color(0, 128, 255));
		tblCongDoan.setFillsViewportHeight(true);
		scrollPane_CongDoan.setViewportView(tblCongDoan);

		btnThem = new JButton("Thêm");
		btnThem.setEnabled(false);
		btnThem.setBackground(new Color(255, 255, 255));
		btnThem.setIcon(new ImageIcon(urlThem));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBounds(1156, 120, 110, 30);
		pnlTop.add(btnThem);

		JLabel lblNewLabel = new JLabel("PHÂN CÔNG CÔNG NHÂN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 0, 1279, 37);
		pnlTop.add(lblNewLabel);

		JLabel lblNgay = new JLabel("Ngày");
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgay.setBounds(50, 40, 52, 25);
		pnlTop.add(lblNgay);

		dateNgayPhanCong = new JDateChooser();
		dateNgayPhanCong.setLocale(new Locale("vi", "VN"));
		dateNgayPhanCong.setDateFormatString("dd/MM/yyyy");
		dateNgayPhanCong.setDate(new Date());
		dateNgayPhanCong.setBounds(105, 40, 150, 25);
		pnlTop.add(dateNgayPhanCong);

		cmbTo = new JComboBox<ToNhom>();
		cmbTo.setBounds(432, 41, 150, 25);
		pnlTop.add(cmbTo);

		JLabel lblToNhom = new JLabel("Tổ");
		lblToNhom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblToNhom.setBounds(370, 40, 52, 25);
		pnlTop.add(lblToNhom);

		JScrollPane scrollPane_CongNhanDuocChon = new JScrollPane();
		scrollPane_CongNhanDuocChon
				.setBorder(new TitledBorder(null, "C\u00F4ng nh\u00E2n \u0111\u01B0\u1EE3c ch\u1ECDn",
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_CongNhanDuocChon.setBounds(786, 80, 360, 300);
		pnlTop.add(scrollPane_CongNhanDuocChon);

		String headerCNDC[] = { "Mã CN", "Họ tên", "Số lượng PC" };
		modelCongNhanDuocChon = new DefaultTableModel(headerCNDC, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblCongNhanDuocChon = new JTable(modelCongNhanDuocChon);
		tblCongNhanDuocChon.setSelectionForeground(new Color(255, 255, 255));
		tblCongNhanDuocChon.setSelectionBackground(new Color(0, 128, 255));
		tblCongNhanDuocChon.setRowHeight(20);
		tblCongNhanDuocChon.setFillsViewportHeight(true);
		scrollPane_CongNhanDuocChon.setViewportView(tblCongNhanDuocChon);
		
		btnTimTheoNgay = new JButton("");
		btnTimTheoNgay.setBorderPainted(false);
		btnTimTheoNgay.setIcon(new ImageIcon(urlTim));
		btnTimTheoNgay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimTheoNgay.setBackground(Color.WHITE);
		btnTimTheoNgay.setBounds(265, 40, 25, 25);
		pnlTop.add(btnTimTheoNgay);

		JLabel lblMuiTen = new JLabel("");
		lblMuiTen.setHorizontalAlignment(SwingConstants.CENTER);
		URL urlMuiTen = PhanCongCongNhan_Panel.class.getResource("/img/forward.png");
		lblMuiTen.setIcon(new ImageIcon(urlMuiTen));
		lblMuiTen.setBounds(680, 205, 96, 64);
		pnlTop.add(lblMuiTen);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(urlLamMoi));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setBackground(Color.WHITE);
		btnLamMoi.setBounds(1156, 80, 110, 30);
		pnlTop.add(btnLamMoi);

		JPanel pnlDanhSach = new JPanel();
		pnlDanhSach.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch ph\u00E2n c\u00F4ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDanhSach.setBackground(Color.WHITE);
		add(pnlDanhSach);
		pnlDanhSach.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pnlDanhSach.add(scrollPane, BorderLayout.CENTER);

		String headerPC[] = { "Mã CN", "Ngày PC", "Tên", "Sản phẩm", "Công đoạn", "Số lượng PC", "Số lượng làm", "Trạng thái"};
		modelPhanCong = new DefaultTableModel(headerPC, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblDSPhanCong = new JTable(modelPhanCong);
		tblDSPhanCong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblDSPhanCong.setRowHeight(20);
		tblDSPhanCong.setSelectionForeground(new Color(255, 255, 255));
		tblDSPhanCong.setSelectionBackground(new Color(0, 128, 255));
		tblDSPhanCong.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblDSPhanCong);

		JPanel pnlTim = new JPanel();
		pnlTim.setLayout(null);
		pnlTim.setSize(new Dimension(0, 100));
		pnlTim.setPreferredSize(new Dimension(10, 35));
		pnlTim.setBackground(Color.WHITE);
		pnlDanhSach.add(pnlTim, BorderLayout.NORTH);

		txtTimPC = new JTextField();
		txtTimPC.setColumns(10);
		txtTimPC.setBounds(220, 6, 226, 25);
		pnlTim.add(txtTimPC);

		cmbLoc = new JComboBox<String>();
		cmbLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbLoc.setModel(new DefaultComboBoxModel<String>(new String[] {"Mã công nhân", "Tên công nhân", "Mã sản phẩm", "Tên sản phẩm", "Mã công đoạn", "Tên công đoạn"}));
		cmbLoc.setBounds(65, 5, 108, 25);
		pnlTim.add(cmbLoc);

		JLabel lblLoc = new JLabel("Lọc");
		lblLoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoc.setBounds(10, 5, 60, 25);
		pnlTim.add(lblLoc);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(urlXoa));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setEnabled(false);
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(1156, 310, 110, 30);
		pnlTop.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(urlLuu));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSua.setEnabled(false);
		btnSua.setBackground(Color.WHITE);
		btnSua.setBounds(1156, 350, 110, 30);
		pnlTop.add(btnSua);
		
		txtTimPC.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String timKiem = txtTimPC.getText().trim();
		        String chon = cmbLoc.getSelectedItem().toString();
		        if (timKiem.isEmpty()) 
		        	return;
		        else {
		        	loadDataIntoTableDSPhanCong(bangPhanCong_dao.getDanhSachPhanCongTheoDieuKienTim(chon, timKiem));  		
		        }
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String timKiem = txtTimPC.getText().trim();
		        String chon = cmbLoc.getSelectedItem().toString();
		        if (timKiem.isEmpty()) 
		        	return;
		        else {
		        	loadDataIntoTableDSPhanCong(bangPhanCong_dao.getDanhSachPhanCongTheoDieuKienTim(chon, timKiem));  		
		        }
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
		});

		LoadTo(to_dao.getAllTo());
		loadDataIntoTableSanPham(sanPham_dao.getAllSanPham());
		loadDataIntoTableDSPhanCong(bangPhanCong_dao.getDanhSachPhanCong());
		
		btnTimTheoNgay.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		tblCongNhan.addMouseListener(this);
		tblCongNhanDuocChon.addMouseListener(this);
		tblSanPham.addMouseListener(this);
		tblCongDoan.addMouseListener(this);
		tblDSPhanCong.addMouseListener(this);
		cmbTo.addItemListener(this);
		modelCongNhanDuocChon.addTableModelListener(this);
		
		TableRowSorter<TableModel> sorterSP = new TableRowSorter<TableModel>(modelSanPham);
		tblSanPham.setRowSorter(sorterSP);
		
		TableRowSorter<TableModel> sorterPC = new TableRowSorter<TableModel>(modelPhanCong);
		tblDSPhanCong.setRowSorter(sorterPC);
	}

	private void LoadTo(ArrayList<ToNhom> ar) {
		cmbTo.removeAllItems();
		for (ToNhom to : ar) {
			cmbTo.addItem(to);
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

	private void loadDataIntoTableCongNhanDuocChon(ArrayList<BangPhanCong> ds) {
		clearTable(tblCongNhanDuocChon);
		for (BangPhanCong bpc : ds) {
			modelCongNhanDuocChon
					.addRow(new Object[] { bpc.getCongNhan().getMaCN(), bpc.getCongNhan(), bpc.getSoLuongPC() });
		}
	}

	private void loadDataIntoTableCongNhan(ArrayList<CongNhan> ds) {
		clearTable(tblCongNhan);
		for (CongNhan cn : ds) {
			modelCongNhan.addRow(new Object[] { cn.getMaCN(), cn });
		}
	}

	private void loadDataIntoTableSanPham(ArrayList<SanPham> ds) {
		clearTable(tblSanPham);
		for (SanPham sp : ds) {
			modelSanPham.addRow(new Object[] { sp.getMaSP(), sp, sp.getSoLuong() });
		}
	}

	private void loadDataIntoTableCongDoan(ArrayList<CongDoan> ds) {
		clearTable(tblCongDoan);
		for (CongDoan cd : ds) {
			modelCongDoan.addRow(new Object[] { cd.getMaCD(), cd, cd.getsoLuongCan() });
		}
	}

	private void loadDataIntoTableDSPhanCong(ArrayList<BangPhanCong> ds) {
		bangPhanCong_dao.capNhatTrangThaiTuDong();
		clearTable(tblDSPhanCong);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		for (BangPhanCong bpc : ds) {
			String trangThai = "";
			if (bpc.demSoLuongLamDuoc() == 0) {
				trangThai += "Chưa làm";
			} else {
				if (bpc.demSoLuongLamDuoc() >= bpc.getSoLuongPC()) {
					trangThai += "Hoàn thành";
				} else {
					trangThai += "Đang làm";
				}
			}
			modelPhanCong.addRow(new Object[] { bpc, bpc.getNgayPhanCong(), bpc.getCongNhan(),
					bpc.getCongDoan().getSp(), bpc.getCongDoan(), bpc.getSoLuongPC(), bpc.demSoLuongLamDuoc(),
					trangThai });
		}
	}

	private boolean enableBtnThem() {
		int r = tblCongNhanDuocChon.getRowCount();
		if (r <= 0) {
			return false;
		}
		return true;
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
		Object o = e.getSource();

		if (o.equals(tblCongNhan)) {
			int r = tblCongNhan.getSelectedRow();
			if (r < 0) {
				return;
			}

			if (e.getClickCount() == 2) {
				if (tblCongDoan.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(this, "Chọn công đoạn !");
					return;
				}
				int row = tblCongNhan.rowAtPoint(e.getPoint());
				int col = tblCongNhan.columnAtPoint(e.getPoint());

				if (row >= 0 && col >= 0) {
					CongDoan cd = (CongDoan) tblCongDoan.getValueAt(tblCongDoan.getSelectedRow(), 1);
					CongNhan cn = (CongNhan) tblCongNhan.getValueAt(r, 1);
					Date ngayPC = dateNgayPhanCong.getDate();
					int trangThai = 0;

					int soLuongCan = cd.getsoLuongCan();
					int soLuongCN = temp.size() + 1;
					int soLuongPC = (int) (soLuongCan / soLuongCN + (soLuongCan / soLuongCN) * 0.05);

					BangPhanCong bpc = new BangPhanCong(cn, cd, soLuongPC, ngayPC, trangThai);
					for (BangPhanCong bangpc : temp) {
						bangpc.setSoLuongPC(soLuongPC);
					}
					temp.add(bpc);
					loadDataIntoTableCongNhanDuocChon(temp);
					modelCongNhan.removeRow(row);
				}
			}

		}

		if (o.equals(tblCongNhanDuocChon)) {
			int r = tblCongNhanDuocChon.getSelectedRow();
			if (r < 0) {
				return;
			}
			if (e.getClickCount() == 2) {
				if (tblCongDoan.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(this, "Chọn công đoạn !");
					return;
				}
				int row = tblCongNhanDuocChon.rowAtPoint(e.getPoint());
				int col = tblCongNhanDuocChon.columnAtPoint(e.getPoint());

				if (row >= 0 && col >= 0) {
					CongDoan cd = (CongDoan) tblCongDoan.getValueAt(tblCongDoan.getSelectedRow(), 1);
					CongNhan cn = temp.get(row).getCongNhan();

					int soLuongCan = cd.getsoLuongCan();
					modelCongNhan.addRow(new Object[] { cn.getMaCN(), cn });
					temp.remove(row);
					int soLuongCN = temp.size();
					int soLuongPC = 0;
					if (soLuongCN != 0) {
						soLuongPC = (int) (soLuongCan / soLuongCN + (soLuongCan / soLuongCN) * 0.05);
						for (BangPhanCong bangpc : temp) {
							bangpc.setSoLuongPC(soLuongPC);
						}
						loadDataIntoTableCongNhanDuocChon(temp);
					} else {
						loadDataIntoTableCongNhanDuocChon(temp);
					}
				}

			}

		}

		if (o.equals(tblSanPham)) {
			int r = tblSanPham.getSelectedRow();
			if (r < 0) {
				return;
			}
			SanPham sp = (SanPham) tblSanPham.getValueAt(r, 1);
			loadDataIntoTableCongDoan(congDoan_dao.getAllCongDoanTheoMaSanPham(sp));

		}

		if (o.equals(tblCongDoan)) {
			int r = tblCongDoan.getSelectedRow();
			if (r < 0) {
				return;
			}
			temp.removeAll(temp);
			loadDataIntoTableCongNhanDuocChon(temp);

			int maTo = ((ToNhom) cmbTo.getSelectedItem()).getMaTo();
			CongDoan cd = (CongDoan) tblCongDoan.getValueAt(tblCongDoan.getSelectedRow(), 1);
			loadDataIntoTableCongNhan(bangPhanCong_dao.getDSCongNhanChuaDuocPhanCongVaoCongDoan(maTo, cd.getMaCD()));
		}

		if (o.equals(tblDSPhanCong)) {
			int r = tblDSPhanCong.getSelectedRow();
			if(r < 0) {
				return;
			}
			btnSua.setEnabled(true);
			btnXoa.setEnabled(true);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnThem)) {
			if (temp.size() <= 0) {
				return;
			}
			int insertSuccess = 0;
			int insertFail = 0;
			for (BangPhanCong bpc : temp) {
				if (bangPhanCong_dao.them(bpc)) {
					insertSuccess++;
				} else {
					insertFail++;
				}
			}
			JOptionPane.showMessageDialog(this,
					"Insert thành công: " + insertSuccess + "\nInsert thất bại: " + insertFail);
			loadDataIntoTableDSPhanCong(bangPhanCong_dao.getDanhSachPhanCong());
			temp.removeAll(temp);
			loadDataIntoTableCongNhanDuocChon(temp);
		}

		if (o.equals(btnLamMoi)) {
			dateNgayPhanCong.setDate(new Date());
			loadDataIntoTableSanPham(sanPham_dao.getAllSanPham());
			LoadTo(to_dao.getAllTo());
			clearTable(tblCongNhan);
			clearTable(tblCongDoan);
			temp.removeAll(temp);
			loadDataIntoTableCongNhanDuocChon(temp);
			loadDataIntoTableDSPhanCong(bangPhanCong_dao.getDanhSachPhanCong());
		}

		if (o.equals(btnTimTheoNgay)) {
			Date ngay = dateNgayPhanCong.getDate();
			loadDataIntoTableDSPhanCong(bangPhanCong_dao.getDanhSachPhanCongTheoNgay(ngay));
		}
		
		if(o.equals(btnXoa)) {
			int r = tblDSPhanCong.getSelectedRow();
			if(r < 0) {
				JOptionPane.showMessageDialog(this, "Chọn dòng muốn xóa trên bảng phân công !");
				return;
			}
			
			String trangThai = tblDSPhanCong.getValueAt(r, 7).toString();
			if(trangThai.equalsIgnoreCase("Hoàn thành")) {
				JOptionPane.showMessageDialog(this, "Công việc đã hoàn thành. Không thể xóa");
				return;
			}
			
			if(trangThai.equalsIgnoreCase("Đang làm")) {
				JOptionPane.showMessageDialog(this, "Công việc đang thực hiện. Không thể xóa");
				return;
			}
			
			BangPhanCong pc = (BangPhanCong) tblDSPhanCong.getValueAt(r, 0);
			if(bangPhanCong_dao.xoa(pc)) {
				JOptionPane.showMessageDialog(this, "Đã xóa");
				loadDataIntoTableDSPhanCong(bangPhanCong_dao.getDanhSachPhanCong());
			}
			
		}
		
		
		if(o.equals(btnSua)) {
			int r = tblDSPhanCong.getSelectedRow();
			if(r < 0) {
				JOptionPane.showMessageDialog(this, "Chọn dòng muốn sửa trên bảng phân công !");
				return;
			}
			
			String trangThai = tblDSPhanCong.getValueAt(r, 7).toString();
			if(trangThai.equalsIgnoreCase("Hoàn thành")) {
				JOptionPane.showMessageDialog(this, "Công việc đã hoàn thành. Không thể sửa");
				return;
			}
			BangPhanCong pc = (BangPhanCong) tblDSPhanCong.getValueAt(r, 0);
			if(trangThai.equalsIgnoreCase("Đang làm")) {
				SpinnerNumberModel model = new SpinnerNumberModel(Integer.valueOf(pc.demSoLuongLamDuoc()), Integer.valueOf(pc.demSoLuongLamDuoc()), Integer.valueOf(1500), Integer.valueOf(20));
		        JSpinner spinner = new JSpinner(model);
		        customJSpiner(spinner);
		        
		        int result = JOptionPane.showOptionDialog(
		                null,
		                spinner,
		                "Số lượng PC >= " + pc.demSoLuongLamDuoc() + " và <= 1500",
		                JOptionPane.OK_CANCEL_OPTION,
		                JOptionPane.PLAIN_MESSAGE,
		                null,
		                null,
		                null
		        );
		        if (result == JOptionPane.OK_OPTION) {
		            int soLuongPCMoi = (int) spinner.getValue();
					if(soLuongPCMoi > pc.demSoLuongLamDuoc() && soLuongPCMoi <= 1500) {
						pc.setSoLuongPC(soLuongPCMoi);
						if(bangPhanCong_dao.capNhatSoLuongPhanCong(pc)) {
							JOptionPane.showMessageDialog(this, "Đã cập nhật");
							loadDataIntoTableDSPhanCong(bangPhanCong_dao.getDanhSachPhanCong());
							return;
						}else {
							JOptionPane.showMessageDialog(this, "Không thể thay đổi !");
							return;
						}
					}
		        }
			}

			
			if(trangThai.equalsIgnoreCase("Chưa làm")) {
				SpinnerNumberModel model = new SpinnerNumberModel(Integer.valueOf(pc.demSoLuongLamDuoc()), Integer.valueOf(pc.demSoLuongLamDuoc()), Integer.valueOf(1500), Integer.valueOf(20));
		        JSpinner spinner = new JSpinner(model);
		        customJSpiner(spinner);
		        
		        int result = JOptionPane.showOptionDialog(
		                null,
		                spinner,
		                "Số lượng PC >= " + pc.demSoLuongLamDuoc() + " và <= 1500",
		                JOptionPane.OK_CANCEL_OPTION,
		                JOptionPane.PLAIN_MESSAGE,
		                null,
		                null,
		                null
		        );
		        
		        if (result == JOptionPane.OK_OPTION) {
		            int soLuongPCMoi = (int) spinner.getValue();
					if(soLuongPCMoi >= pc.demSoLuongLamDuoc() && soLuongPCMoi <= 1500) {
						pc.setSoLuongPC(soLuongPCMoi);
						if(bangPhanCong_dao.capNhatSoLuongPhanCong(pc)) {
							JOptionPane.showMessageDialog(this, "Đã cập nhật");
							loadDataIntoTableDSPhanCong(bangPhanCong_dao.getDanhSachPhanCong());
							return;
						}else {
							JOptionPane.showMessageDialog(this, "Không thể thay đổi !");
							return;
						}
					}
		        }
			}
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			Object o = e.getSource();

			if (o.equals(cmbTo)) {
				if (tblCongDoan.getSelectedRow() < 0) {
					return;
				}
				int maTo = ((ToNhom) cmbTo.getSelectedItem()).getMaTo();
				CongDoan cd = (CongDoan) tblCongDoan.getValueAt(tblCongDoan.getSelectedRow(), 1);
				loadDataIntoTableCongNhan(
						bangPhanCong_dao.getDSCongNhanChuaDuocPhanCongVaoCongDoan(maTo, cd.getMaCD()));
			}
		}

	}

	@Override
	public void tableChanged(TableModelEvent e) {
		if (e.getType() == TableModelEvent.INSERT) {
			btnThem.setEnabled(enableBtnThem());
		}

		if (e.getType() == TableModelEvent.DELETE) {
			btnThem.setEnabled(enableBtnThem());
		}

	}

}
