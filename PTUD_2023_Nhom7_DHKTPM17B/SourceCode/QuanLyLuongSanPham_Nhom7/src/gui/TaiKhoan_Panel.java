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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.NhanVien;
import entity.TaiKhoan;
import util.MaHoa;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

/**
 * @author	Nguyễn Hồng Quân
 */
public class TaiKhoan_Panel extends JPanel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtTimNhanVien;
	private JTable tblNhanVien;
	private JTextField txtMaTaiKhoan;
	private JTextField txtTenTaiKhoan;
	private JPasswordField txtMatKhau;
	private JTable tblTaiKhoan;
	private DefaultTableModel model;
	private JButton btnTimNhanVien;
	private JButton btnReload;
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnLamMoi;
	private DefaultTableModel modelTaiKhoan;
	private JComboBox<String> cmbQuyen;
	private JButton btnXoa;
	private NhanVien_DAO nhanVien_dao = new NhanVien_DAO();
	private TaiKhoan_DAO taiKhoan_dao = new TaiKhoan_DAO();
	private URL urlTim = TaiKhoan_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
	private URL urlThem = TaiKhoan_Panel.class.getResource("/img/Custom-Icon-Design-Flatastic-1-Add-1.24.png");
	private URL urlXoa = TaiKhoan_Panel.class.getResource("/img/Pictogrammers-Material-Delete-forever.24.png");
	private URL urlLamMoi = TaiKhoan_Panel.class.getResource("/img/Hopstarter-Button-Button-Reload.24.png");
	private URL urlLuu = TaiKhoan_Panel.class.getResource("/img/Oxygen-Icons.org-Oxygen-Actions-document-save.24.png");
	private URL urlTBFail = TaiKhoan_Panel.class.getResource("/img/Saki-NuoveXT-Actions-button-cancel.16.png");
	private URL urlTBSuccess = TaiKhoan_Panel.class.getResource("/img/Custom-Icon-Design-Pretty-Office-8-Accept.16.png");
	public TaiKhoan_Panel() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setPreferredSize(new Dimension(10, 320));
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
		pnlDanhSachNhanVien.setBounds(210, 0, 408, 236);
		pnlThongTin.add(pnlDanhSachNhanVien);
		pnlDanhSachNhanVien.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTim = new JPanel();
		pnlTim.setBackground(new Color(255, 255, 255));
		pnlTim.setPreferredSize(new Dimension(10, 35));
		pnlDanhSachNhanVien.add(pnlTim, BorderLayout.NORTH);
		pnlTim.setLayout(null);
		
		txtTimNhanVien = new JTextField();
		txtTimNhanVien.setColumns(10);
		txtTimNhanVien.setBounds(129, 5, 123, 25);
		pnlTim.add(txtTimNhanVien);
		
		btnTimNhanVien = new JButton("");
		btnTimNhanVien.setBackground(new Color(255, 255, 255));
		btnTimNhanVien.setBorderPainted(false);
		btnTimNhanVien.setIcon(new ImageIcon(urlTim));
		btnTimNhanVien.setBounds(262, 5, 25, 25);
		pnlTim.add(btnTimNhanVien);
		
		JLabel lblMaNV = new JLabel("Mã NV");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNV.setBounds(82, 5, 45, 25);
		pnlTim.add(lblMaNV);
		
		btnReload = new JButton("");
		btnReload.setBackground(new Color(255, 255, 255));
		btnReload.setBorderPainted(false);
		btnReload.setIcon(new ImageIcon(urlLamMoi));
		btnReload.setBounds(361, 5, 25, 25);
		pnlTim.add(btnReload);
		
		JPanel pnlTableNhanVien = new JPanel();
		pnlTableNhanVien.setBackground(new Color(255, 255, 255));
		pnlDanhSachNhanVien.add(pnlTableNhanVien, BorderLayout.CENTER);
		pnlTableNhanVien.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		pnlTableNhanVien.add(scrollPane);
		
		String header[] = {"Mã NV", "Họ tên", "Trạng thái"};
		model = new DefaultTableModel(header, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		tblNhanVien = new JTable(model);
		tblNhanVien.setRowHeight(20);
		tblNhanVien.setSelectionForeground(new Color(255, 255, 255));
		tblNhanVien.setFillsViewportHeight(true);
		tblNhanVien.setGridColor(new Color(128, 128, 128));
		tblNhanVien.setSelectionBackground(new Color(0, 128, 255));
		scrollPane.setViewportView(tblNhanVien);
		
		JPanel pnlThongTinTaiKhoan = new JPanel();
		pnlThongTinTaiKhoan.setBackground(new Color(255, 255, 255));
		pnlThongTinTaiKhoan.setBorder(new TitledBorder(null, "Th\u00F4ng tin t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinTaiKhoan.setBounds(674, 0, 396, 236);
		pnlThongTin.add(pnlThongTinTaiKhoan);
		pnlThongTinTaiKhoan.setLayout(null);
		
		JLabel lblMaTaiKhoan = new JLabel("Mã tài khoản");
		lblMaTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaTaiKhoan.setBounds(45, 40, 115, 25);
		pnlThongTinTaiKhoan.add(lblMaTaiKhoan);
		
		JLabel lblTenTaiKhoan = new JLabel("Tên tài khoản");
		lblTenTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenTaiKhoan.setBounds(45, 80, 115, 25);
		pnlThongTinTaiKhoan.add(lblTenTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMatKhau.setBounds(45, 120, 115, 25);
		pnlThongTinTaiKhoan.add(lblMatKhau);
		
		JLabel lblQuyen = new JLabel("Quyền");
		lblQuyen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuyen.setBounds(45, 160, 81, 25);
		pnlThongTinTaiKhoan.add(lblQuyen);
		
		txtMaTaiKhoan = new JTextField();
		txtMaTaiKhoan.setDisabledTextColor(new Color(0, 0, 0));
		txtMaTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtMaTaiKhoan.setEnabled(false);
		txtMaTaiKhoan.setBounds(160, 40, 150, 25);
		pnlThongTinTaiKhoan.add(txtMaTaiKhoan);
		txtMaTaiKhoan.setColumns(10);
		
		txtTenTaiKhoan = new JTextField();
		txtTenTaiKhoan.setDisabledTextColor(new Color(0, 0, 0));
		txtTenTaiKhoan.setEnabled(false);
		txtTenTaiKhoan.setBounds(160, 80, 180, 25);
		pnlThongTinTaiKhoan.add(txtTenTaiKhoan);
		txtTenTaiKhoan.setColumns(10);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setEchoChar('*');
		txtMatKhau.setBounds(160, 120, 130, 25);
		pnlThongTinTaiKhoan.add(txtMatKhau);
		
		cmbQuyen = new JComboBox<String>();
		cmbQuyen.addItem("Quản trị viên");
		cmbQuyen.addItem("QL nhân sự");
		cmbQuyen.addItem("QL dự án");
		cmbQuyen.addItem("Kế toán");
		cmbQuyen.addItem("Tổ trưởng");
		cmbQuyen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbQuyen.setBounds(160, 160, 130, 25);
		pnlThongTinTaiKhoan.add(cmbQuyen);
		
		JLabel lblTBMatKhau = new JLabel("");
		lblTBMatKhau.setIcon(new ImageIcon(urlTBFail));
		lblTBMatKhau.setBackground(Color.WHITE);
		lblTBMatKhau.setBounds(300, 120, 20, 20);
		pnlThongTinTaiKhoan.add(lblTBMatKhau);
		
		btnThem = new JButton("Thêm");
		btnThem.setEnabled(false);
		btnThem.setBackground(new Color(255, 255, 255));
		btnThem.setIcon(new ImageIcon(urlThem));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBounds(371, 246, 120, 30);
		pnlThongTin.add(btnThem);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setBackground(new Color(255, 255, 255));
		btnLuu.setIcon(new ImageIcon(urlLuu));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBounds(509, 246, 120, 30);
		pnlThongTin.add(btnLuu);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(new Color(255, 255, 255));
		btnLamMoi.setIcon(new ImageIcon(urlLamMoi));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setBounds(666, 246, 120, 30);
		pnlThongTin.add(btnLamMoi);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setEnabled(false);
		btnXoa.setIcon(new ImageIcon(urlXoa));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(819, 246, 120, 30);
		pnlThongTin.add(btnXoa);
		
		JPanel pnlDanhSachTaiKhoan = new JPanel();
		pnlDanhSachTaiKhoan.setBorder(new TitledBorder(null, "Danh s\u00E1ch t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachTaiKhoan.setBackground(new Color(255, 255, 255));
		add(pnlDanhSachTaiKhoan, BorderLayout.CENTER);
		pnlDanhSachTaiKhoan.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(255, 255, 255));
		pnlDanhSachTaiKhoan.add(scrollPane_1);
		
		String headerTaiKhoan[] = {"Mã NV (Mã TK)", "Tên TK", "Mật khẩu", "Quyền"};
		modelTaiKhoan = new DefaultTableModel(headerTaiKhoan, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};		
		tblTaiKhoan = new JTable(modelTaiKhoan);
		tblTaiKhoan.setSelectionForeground(new Color(255, 255, 255));
		tblTaiKhoan.setRowHeight(20);
		tblTaiKhoan.setGridColor(new Color(128, 128, 128));
		tblTaiKhoan.setFillsViewportHeight(true);
		tblTaiKhoan.setSelectionBackground(new Color(0, 128, 255));
		scrollPane_1.setViewportView(tblTaiKhoan);
		
		txtMatKhau.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				btnThem.setEnabled(validDataMatKhau());
				if (validDataMatKhau()) {
					lblTBMatKhau.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBMatKhau.setIcon(new ImageIcon(urlTBFail));
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				btnThem.setEnabled(validDataMatKhau());
				if (validDataMatKhau()) {
					lblTBMatKhau.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBMatKhau.setIcon(new ImageIcon(urlTBFail));
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
		});
		
		LoadDanhSachNhanVienVaoTableNhanVien(nhanVien_dao.getDanhSachNhanVienTheoTrangThaiTaiKhoan(0));
		LoadDanhSachTaiKhoan(taiKhoan_dao.getAllTaiKhoan());
		
		btnTimNhanVien.addActionListener(this);
		btnReload.addActionListener(this);
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnXoa.addActionListener(this);
		tblNhanVien.addMouseListener(this);
		tblTaiKhoan.addMouseListener(this);
		
		TableRowSorter<TableModel> sorterNV = new TableRowSorter<TableModel>(model);
		tblNhanVien.setRowSorter(sorterNV);
		TableRowSorter<TableModel> sorterTK = new TableRowSorter<TableModel>(modelTaiKhoan);
		tblTaiKhoan.setRowSorter(sorterTK);
	}
	
	private void clearTableNhanVien() {
		int r = tblNhanVien.getRowCount();
		while(r > 0) {
			model.removeRow(r-1);
			r--;
		}
	}
	
	private void clearTableTaiKhoan() {
		int r = tblTaiKhoan.getRowCount();
		while(r > 0) {
			modelTaiKhoan.removeRow(r-1);
			r--;
		}
	}

	private void LoadDanhSachNhanVienVaoTableNhanVien(ArrayList<NhanVien> dsNV) {
		clearTableNhanVien();
		for (NhanVien nv : dsNV) {
			String status = "";
			if(nv.getTrangThaiTaiKhoan() == 1) {
				status += "Đã cấp";
			}
			
			if(nv.getTrangThaiTaiKhoan() == 0) {
				status += "Chưa cấp";
			}
			model.addRow(new Object[] { nv.getMaNV(), nv.getHoTen(), status.toString() });
		}
	}
	
	private void LoadDanhSachTaiKhoan(ArrayList<TaiKhoan> dsTK) {
		clearTableTaiKhoan();
		for (TaiKhoan tk : dsTK) {
			modelTaiKhoan.addRow(new Object[] { tk.getMaTK(), tk.getTenTK(), tk.getMatKhau(), tk.getGiaTri() });
		}
	}
	
	private void fillForm(JTable table) {
		int r = table.getSelectedRow();
		if(r < 0) {
			return;
		}
		String maNV = table.getValueAt(r, 0).toString();
		txtMaTaiKhoan.setText(maNV);
		String tenNV = table.getValueAt(r, 1).toString();
		txtTenTaiKhoan.setText(tenNV);
	}
	
	private void lamMoiFields() {
		txtMaTaiKhoan.setText("");
		txtTenTaiKhoan.setText("");
		txtMatKhau.setText("");
		tblNhanVien.clearSelection();
		tblTaiKhoan.clearSelection();
		btnXoa.setEnabled(false);
		btnLuu.setEnabled(false);
		LoadDanhSachTaiKhoan(taiKhoan_dao.getAllTaiKhoan());
	}
	
	public boolean validDataMatKhau() {
		char[] passwordChars = txtMatKhau.getPassword();
		String matKhau = new String(passwordChars);
		
		if (!matKhau.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
			return false;
		}
		return true;
	}
	
	private TaiKhoan revertTaiKhoanFromFields() {
		TaiKhoan tk = null;
		try {
			String maTK = txtMaTaiKhoan.getText().trim();
			String tenTK = txtTenTaiKhoan.getText().trim();
			char[] passwordChars = txtMatKhau.getPassword();
			String matKhau = new String(passwordChars);
			new MaHoa();
			String maHoaMatKhau = MaHoa.toSHA1(matKhau);
			
			String quyenSelected = cmbQuyen.getSelectedItem().toString();
			int giaTri = 1;
			if(quyenSelected.equalsIgnoreCase("QL nhân sự")) {
				giaTri = 2;
			}
			if(quyenSelected.equalsIgnoreCase("QL dự án")) {
				giaTri = 3;
			}
			if(quyenSelected.equalsIgnoreCase("Kế toán")) {
				giaTri = 4;
			}
			if(quyenSelected.equalsIgnoreCase("Tổ trưởng")) {
				giaTri = 5;
			}
			NhanVien nv = nhanVien_dao.TimMaNhanVien(new NhanVien(maTK));
			tk = new TaiKhoan(maTK, tenTK, maHoaMatKhau, giaTri, nv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tk;
	}
	
	private void themTK() {
		TaiKhoan tk = revertTaiKhoanFromFields();
		boolean flag = taiKhoan_dao.kiemTraTonTaiCuaMaTaiKhoan(tk.getMaTK());
		if(flag == false) {
			taiKhoan_dao.themTK(tk);
			nhanVien_dao.capNhatTrangThaiTaiKhoan(tk.getNhanVien().getMaNV(), 1);
			LoadDanhSachTaiKhoan(taiKhoan_dao.getAllTaiKhoan());
			LoadDanhSachNhanVienVaoTableNhanVien(nhanVien_dao.getDanhSachNhanVienTheoTrangThaiTaiKhoan(0));
			lamMoiFields();
			JOptionPane.showMessageDialog(this, "Thêm thành công");
		}else {
			JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại");
		}
	}
	
	private void xoaTK() {
		String xoaMaTK = txtMaTaiKhoan.getText().trim();
		TaiKhoan tk = new TaiKhoan(xoaMaTK);
		if(JOptionPane.showConfirmDialog(this, "Bạn muốn xóa đúng không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if(taiKhoan_dao.xoaTK(tk)) {
				nhanVien_dao.capNhatTrangThaiTaiKhoan(tk.getMaTK(), 0);
				LoadDanhSachNhanVienVaoTableNhanVien(nhanVien_dao.getDanhSachNhanVienTheoTrangThaiTaiKhoan(0));
				LoadDanhSachTaiKhoan(taiKhoan_dao.getAllTaiKhoan());
				btnXoa.setEnabled(false);
				btnLuu.setEnabled(false);
				lamMoiFields();
				JOptionPane.showMessageDialog(this, "Xóa thành công");
			}else {
				JOptionPane.showMessageDialog(this, "Không thể xóa");
			}
		}
	}
	
	private void capNhatTK() {
		TaiKhoan tk = revertTaiKhoanFromFields();
		if(JOptionPane.showConfirmDialog(this, "Bạn muốn có muốn lưu thay đổi?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if(taiKhoan_dao.capNhatTK(tk)) {
				LoadDanhSachTaiKhoan(taiKhoan_dao.getAllTaiKhoan());
				lamMoiFields();
				btnLuu.setEnabled(false);
				btnXoa.setEnabled(false);
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
			}else {
				JOptionPane.showMessageDialog(this, "Không thể lưu thay đổi");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTimNhanVien)) {
			String maNhanVien = txtTimNhanVien.getText().trim();
			if (maNhanVien.isEmpty()) {
				return;
			} else {
				ArrayList<NhanVien> ds = nhanVien_dao.TimMaNhanVienTheoTrangThaiTaiKhoan(maNhanVien, 0);
				if (ds.size() > 0) {
					LoadDanhSachNhanVienVaoTableNhanVien(ds);
				} else {
					JOptionPane.showMessageDialog(this, "Không tin thấy mã " + maNhanVien);
				}
			}
		}
		
		if(o.equals(btnReload)) {
			LoadDanhSachNhanVienVaoTableNhanVien(nhanVien_dao.getDanhSachNhanVienTheoTrangThaiTaiKhoan(0));
		}
		
		if(o.equals(btnThem)) {
			themTK();
		}

		if(o.equals(btnXoa)) {
			xoaTK();
		}
		
		if(o.equals(btnLuu)) {
			capNhatTK();
		}
		
		if(o.equals(btnLamMoi)) {
			lamMoiFields();
			LoadDanhSachTaiKhoan(taiKhoan_dao.getAllTaiKhoan());
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o.equals(tblNhanVien)) {
			fillForm(tblNhanVien);
			tblTaiKhoan.clearSelection();
			btnXoa.setEnabled(false);
			btnLuu.setEnabled(false);					
		}
		
		if(o.equals(tblTaiKhoan)) {
			fillForm(tblTaiKhoan);
			int r = tblTaiKhoan.getSelectedRow();
			if(r < 0) {
				return;
			}
			txtMatKhau.setText(tblTaiKhoan.getValueAt(r, 2).toString());
			tblNhanVien.clearSelection();
			btnThem.setEnabled(false);
			btnXoa.setEnabled(true);
			btnLuu.setEnabled(true);
			
			String giaTri = tblTaiKhoan.getValueAt(r, 3).toString();
			String itemNQT = new String("Quản trị viên");
			String itemQLNS = new String("QL nhân sự");
			String itemQLDA = new String("QL dự án");
			String itemKT = new String("Kế toán");
			String itemTT = new String("Tổ trưởng");
			if(giaTri.equalsIgnoreCase("1")) {
				cmbQuyen.setSelectedItem(itemNQT);
			}
			
			if(giaTri.equalsIgnoreCase("2")) {
				cmbQuyen.setSelectedItem(itemQLNS);
			}
			
			if(giaTri.equalsIgnoreCase("3")) {
				cmbQuyen.setSelectedItem(itemQLDA);
			}
			
			if(giaTri.equalsIgnoreCase("4")) {
				cmbQuyen.setSelectedItem(itemKT);
			}
			
			if(giaTri.equalsIgnoreCase("5")) {
				cmbQuyen.setSelectedItem(itemTT);
			}
		}
		
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
