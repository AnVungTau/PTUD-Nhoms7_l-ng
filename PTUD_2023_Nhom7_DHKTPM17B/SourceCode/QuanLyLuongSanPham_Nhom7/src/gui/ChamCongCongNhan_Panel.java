package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import com.toedter.calendar.JDateChooser;
import dao.CongDoan_DAO;
import dao.BangChamCongCongNhan_DAO;
import dao.SanPham_DAO;
import dao.ToNhom_DAO;
import entity.CongDoan;
import entity.BangChamCongCongNhan;
import entity.SanPham;
import entity.ToNhom;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;

/**
 * @author Nguyễn Hồng Quân
 */
public class ChamCongCongNhan_Panel extends JPanel implements ItemListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable tblPhanCong;
	private DefaultTableModel model;
	private JComboBox<SanPham> cmbSanPham;
	private JComboBox<CongDoan> cmbCongDoan;
	private SanPham_DAO sanPham_dao = new SanPham_DAO();
	private CongDoan_DAO congDoan_dao = new CongDoan_DAO();
	private ToNhom_DAO toNhom_dao = new ToNhom_DAO();
	private BangChamCongCongNhan_DAO bangChamCongCongNhan_dao = new BangChamCongCongNhan_DAO();
	private JButton btnChamCong;
	private JDateChooser dateNgayCham;
	private JButton btnTimDSDaCham;
	private JButton btnTimDSChuaCham;
	private JButton btnTimDSToVaCD;
	private JComboBox<ToNhom> cmbTo;
	private JButton btnTimDSTheoTo;
	private JButton btnTimDSTheoCD;
	private JButton btnSua;

	public ChamCongCongNhan_Panel() {
		setLayout(new BorderLayout(0, 0));

		JPanel pnlTop = new JPanel();
		pnlTop.setPreferredSize(new Dimension(10, 200));
		add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(new BorderLayout(0, 0));

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(new Color(255, 255, 255));
		pnlTop.add(pnlTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("CHẤM CÔNG CÔNG NHÂN");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnlTitle.add(lblTitle);

		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlTop.add(pnlChucNang, BorderLayout.CENTER);
		pnlChucNang.setLayout(null);

		JLabel lblNgayCham = new JLabel("Ngày chấm");
		lblNgayCham.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayCham.setBounds(414, 10, 99, 25);
		pnlChucNang.add(lblNgayCham);

		dateNgayCham = new JDateChooser();
		dateNgayCham.setDate(new Date());
		dateNgayCham.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateNgayCham.setLocale(new Locale("vi", "VN"));
		dateNgayCham.setDateFormatString("dd/MM/yyyy");
		dateNgayCham.setBounds(414, 33, 150, 25);
		pnlChucNang.add(dateNgayCham);

		JLabel lblSanPham = new JLabel("Sản phẩm");
		lblSanPham.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSanPham.setBounds(666, 10, 99, 25);
		pnlChucNang.add(lblSanPham);

		cmbSanPham = new JComboBox<SanPham>();
		cmbSanPham.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbSanPham.setBounds(763, 10, 150, 25);
		pnlChucNang.add(cmbSanPham);

		JLabel lblCongDoan = new JLabel("Công đoạn");
		lblCongDoan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCongDoan.setBounds(666, 45, 99, 25);
		pnlChucNang.add(lblCongDoan);

		cmbCongDoan = new JComboBox<CongDoan>();
		cmbCongDoan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbCongDoan.setBounds(763, 45, 150, 25);
		pnlChucNang.add(cmbCongDoan);
		
		btnTimDSDaCham = new JButton("DS đã chấm");
		btnTimDSDaCham.setHorizontalAlignment(SwingConstants.LEFT);
		btnTimDSDaCham.setBackground(new Color(255, 255, 255));
		URL urlBtnTimDSDaCham = ChamCongCongNhan_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
		btnTimDSDaCham.setIcon(new ImageIcon(urlBtnTimDSDaCham));
		btnTimDSDaCham.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimDSDaCham.setBounds(414, 103, 150, 30);
		pnlChucNang.add(btnTimDSDaCham);
		
		btnTimDSChuaCham = new JButton("DS chưa chấm");
		btnTimDSChuaCham.setHorizontalAlignment(SwingConstants.LEFT);
		URL urlBtnTimDSChuaCham = ChamCongCongNhan_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
		btnTimDSChuaCham.setIcon(new ImageIcon(urlBtnTimDSChuaCham));
		btnTimDSChuaCham.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimDSChuaCham.setBackground(Color.WHITE);
		btnTimDSChuaCham.setBounds(414, 68, 150, 30);
		pnlChucNang.add(btnTimDSChuaCham);
		
		cmbTo = new JComboBox<ToNhom>();
		cmbTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTo.setBounds(763, 80, 150, 25);
		pnlChucNang.add(cmbTo);
		
		JLabel lblTo = new JLabel("Tổ");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTo.setBounds(666, 80, 99, 25);
		pnlChucNang.add(lblTo);
		
		btnTimDSToVaCD = new JButton("DS theo tổ & CĐ");
		URL urlBtnTimDSToVaCD = ChamCongCongNhan_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
		btnTimDSToVaCD.setIcon(new ImageIcon(urlBtnTimDSToVaCD));
		btnTimDSToVaCD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimDSToVaCD.setBackground(Color.WHITE);
		btnTimDSToVaCD.setBounds(763, 115, 185, 30);
		pnlChucNang.add(btnTimDSToVaCD);
		
		btnTimDSTheoTo = new JButton("");
		btnTimDSTheoTo.setBorderPainted(false);
		URL urlBtnTimDSTheoTo = ChamCongCongNhan_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
		btnTimDSTheoTo.setIcon(new ImageIcon(urlBtnTimDSTheoTo));
		btnTimDSTheoTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimDSTheoTo.setBackground(Color.WHITE);
		btnTimDSTheoTo.setBounds(923, 80, 25, 25);
		pnlChucNang.add(btnTimDSTheoTo);
		
		btnTimDSTheoCD = new JButton("");
		URL urlBtnTimDSTheoCD = ChamCongCongNhan_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
		btnTimDSTheoCD.setIcon(new ImageIcon(urlBtnTimDSTheoCD));
		btnTimDSTheoCD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimDSTheoCD.setBorderPainted(false);
		btnTimDSTheoCD.setBackground(Color.WHITE);
		btnTimDSTheoCD.setBounds(923, 45, 25, 25);
		pnlChucNang.add(btnTimDSTheoCD);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(255, 255, 255));
		pnlCenter.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch ch\u1EA5m c\u00F4ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(pnlCenter, BorderLayout.CENTER);
		
		String header[] = { "STT", "Mã CN", "Họ tên", "Sản phẩm", "Công đoạn", "Số lượng PC", "Số lượng làm" };
		model = new DefaultTableModel(header, 0) {
			private static final long serialVersionUID = 1L;
			
			private static int clamp(Number value, int min, int max) {
		        return Math.min(Math.max(value.intValue(), min), max);
		    }
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 6;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if(columnIndex == 6) {
					return Integer.class;
				}
				return super.getColumnClass(columnIndex);
			}
			
			@Override
			public void setValueAt(Object value, int row, int column) {
			    if (column == 6 && value instanceof Number) {
			    	int val = (int) tblPhanCong.getValueAt(row, column - 1);
			        super.setValueAt(clamp((Number) value, 0, val), row, column);
			    } else {
			        super.setValueAt(value, row, column);
			    }
			}
			
		};

		pnlCenter.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		pnlCenter.add(scrollPane);

		tblPhanCong = new JTable(model);
		tblPhanCong.setSelectionForeground(new Color(255, 255, 255));
		tblPhanCong.setSelectionBackground(new Color(0, 128, 255));
		tblPhanCong.setRowHeight(20);
		tblPhanCong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblPhanCong.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblPhanCong);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setPreferredSize(new Dimension(10, 50));
		pnlSouth.setBackground(new Color(255, 255, 255));
		add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));

		btnChamCong = new JButton("Chấm công");
		URL urlBtnChamCong = ChamCongCongNhan_Panel.class.getResource("/img/tick.png");
		btnChamCong.setIcon(new ImageIcon(urlBtnChamCong));
		btnChamCong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlSouth.add(btnChamCong);
		
		btnSua = new JButton("Lưu");
		btnSua.setEnabled(false);
		URL urlBtnSua = ChamCongCongNhan_Panel.class.getResource("/img/Oxygen-Icons.org-Oxygen-Actions-document-save.24.png");
		btnSua.setIcon(new ImageIcon(urlBtnSua));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlSouth.add(btnSua);

		loadSanPham(sanPham_dao.getAllSanPham());
		loadCongDoan(congDoan_dao.getAllCongDoanTheoMaSanPham(cmbSanPham.getItemAt(0)));
		loadToNhom(toNhom_dao.getAllTo());
		loadDanhSachChamCong(bangChamCongCongNhan_dao.getDanhSachChamCongTheoNgay(dateNgayCham.getDate()));

		cmbSanPham.addItemListener(this);
		cmbCongDoan.addItemListener(this);
		btnChamCong.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimDSDaCham.addActionListener(this);
		btnTimDSChuaCham.addActionListener(this);
		btnTimDSToVaCD.addActionListener(this);
		btnTimDSTheoTo.addActionListener(this);
		btnTimDSTheoCD.addActionListener(this);
	}

	private void clearTable() {
		int r = tblPhanCong.getRowCount();
		while (r > 0) {
			model.removeRow(r - 1);
			r--;
		}
	}

	private void loadSanPham(ArrayList<SanPham> ds) {
		cmbSanPham.removeAllItems();
		for (SanPham sp : ds) {
			cmbSanPham.addItem(sp);
		}
	}

	private void loadCongDoan(ArrayList<CongDoan> ds) {
		cmbCongDoan.removeAllItems();
		for (CongDoan cd : ds) {
			cmbCongDoan.addItem(cd);
		}
	}
	
	private void loadToNhom(ArrayList<ToNhom> ds) {
		cmbTo.removeAllItems();
		for (ToNhom t : ds) {
			cmbTo.addItem(t);
		}
	}
	
	private void loadDanhSachChamCong(ArrayList<BangChamCongCongNhan> ds) {
		clearTable();
		int i = 1;
		for (BangChamCongCongNhan cc : ds) {
			model.addRow(new Object[] { i++, cc, cc.getPhanCong().getCongNhan(),
					cc.getPhanCong().getCongDoan().getSp(), cc.getPhanCong().getCongDoan(), cc.getPhanCong().getSoLuongPC(), cc.getPhanCong().getSoLuongPC()});
		}
	}
	
	private void loadDanhSachDaChamCong(ArrayList<BangChamCongCongNhan> ds) {
		clearTable();
		int i = 1;
		for (BangChamCongCongNhan cc : ds) {
			model.addRow(new Object[] { i++, cc, cc.getPhanCong().getCongNhan(),
					cc.getPhanCong().getCongDoan().getSp(), cc.getPhanCong().getCongDoan(), cc.getPhanCong().getSoLuongPC(), cc.getSoLuongLam()});
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			Object o = e.getSource();

			if (o.equals(cmbSanPham)) {
				SanPham sp = (SanPham) cmbSanPham.getSelectedItem();
				loadCongDoan(congDoan_dao.getAllCongDoanTheoMaSanPham(sp));
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnChamCong)) {
			int rowCount = tblPhanCong.getRowCount();
			if(rowCount == 0) {
				JOptionPane.showMessageDialog(this, "Danh sách rỗng !");
				return;
			}
			
			ArrayList<BangChamCongCongNhan> dsCC = new ArrayList<>();
			while (rowCount > 0) {
				BangChamCongCongNhan cc = (BangChamCongCongNhan) tblPhanCong.getValueAt(rowCount - 1, 1);
				int soLuongLam = Integer.parseInt(tblPhanCong.getValueAt(rowCount - 1, 6).toString());
				cc.setNgayCham(dateNgayCham.getDate());
				cc.setSoLuongLam(soLuongLam);
				dsCC.add(cc);
				rowCount--;
			}
			
			int insertSuccess = 0;
			int insertFail = 0;
			if (dsCC.size() > 0) {
				for (BangChamCongCongNhan cc : dsCC) {
					if(bangChamCongCongNhan_dao.them(cc)) {
						insertSuccess++;
					}else {
						insertFail++;
					}
				}
			}
			JOptionPane.showMessageDialog(this,
					"Insert thành công: " + insertSuccess + "\nInsert thất bại: " + insertFail);
			loadDanhSachDaChamCong(bangChamCongCongNhan_dao.getDanhSachDaChamCongTheoNgay(dateNgayCham.getDate()));
			btnChamCong.setEnabled(false);
			
		}

		if (o.equals(btnSua)) {
			int rowCount = tblPhanCong.getRowCount();
			if(rowCount == 0) {
				JOptionPane.showMessageDialog(this, "Danh sách rỗng !");
				return;
			}
			
			ArrayList<BangChamCongCongNhan> dsCC = new ArrayList<>();
			while (rowCount > 0) {
				BangChamCongCongNhan cc = (BangChamCongCongNhan) tblPhanCong.getValueAt(rowCount - 1, 1);
				int soLuongLam = Integer.parseInt(tblPhanCong.getValueAt(rowCount - 1, 6).toString());
				cc.setSoLuongLam(soLuongLam);
				dsCC.add(cc);
				rowCount--;
			}
			
			int updateSuccess = 0;
			int updateFail = 0;
			if (dsCC.size() > 0) {
				for (BangChamCongCongNhan cc : dsCC) {
					if(bangChamCongCongNhan_dao.capNhat(cc)) {
						updateSuccess++;
					}else {
						updateFail++;
					}
				}
			}
			JOptionPane.showMessageDialog(this,
					"Update thành công: " + updateSuccess + "\nUpdate thất bại: " + updateFail);
			loadDanhSachDaChamCong(bangChamCongCongNhan_dao.getDanhSachDaChamCongTheoNgay(dateNgayCham.getDate()));
		}
		
		if(o.equals(btnTimDSDaCham)) {
			btnChamCong.setEnabled(false);
			btnSua.setEnabled(true);
			loadDanhSachDaChamCong(bangChamCongCongNhan_dao.getDanhSachDaChamCongTheoNgay(dateNgayCham.getDate()));
		}
		
		if(o.equals(btnTimDSChuaCham)) {
			btnChamCong.setEnabled(true);
			btnSua.setEnabled(false);
			loadDanhSachChamCong(bangChamCongCongNhan_dao.getDanhSachChamCongTheoNgay(dateNgayCham.getDate()));
		}
		
		if(o.equals(btnTimDSToVaCD)) {
			btnChamCong.setEnabled(true);
			btnSua.setEnabled(false);
			Date date = dateNgayCham.getDate();
			ToNhom to = (ToNhom) cmbTo.getSelectedItem();
			CongDoan cd = (CongDoan) cmbCongDoan.getSelectedItem();
			loadDanhSachChamCong(bangChamCongCongNhan_dao.getDanhSachChamCongTheoNgay_CongDoan_To(date, to, cd));
		}
		
		if(o.equals(btnTimDSTheoTo)) {
			btnChamCong.setEnabled(true);
			btnSua.setEnabled(false);
			Date date = dateNgayCham.getDate();
			ToNhom to = (ToNhom) cmbTo.getSelectedItem();
			loadDanhSachChamCong(bangChamCongCongNhan_dao.getDanhSachChamCongTheoDieuKien(date, to));
		}
		
		if(o.equals(btnTimDSTheoCD)) {
			btnChamCong.setEnabled(true);
			btnSua.setEnabled(false);
			Date date = dateNgayCham.getDate();
			CongDoan cd = (CongDoan) cmbCongDoan.getSelectedItem();
			loadDanhSachChamCong(bangChamCongCongNhan_dao.getDanhSachChamCongTheoDieuKien(date, cd));
		}

	}
}
