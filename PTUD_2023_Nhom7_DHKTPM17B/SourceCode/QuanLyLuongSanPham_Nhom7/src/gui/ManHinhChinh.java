package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import util.Keycode;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
/**
 * @author Nguyễn Hồng Quân
 */
public class ManHinhChinh extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mniDangXuat;

	public ManHinhChinh() {
		setTitle("QUẢN LÝ LƯƠNG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		URL urlicon = ManHinhChinh.class.getResource("/img/logo_icon.png");
		ImageIcon icon = new ImageIcon(urlicon);
		setIconImage(icon.getImage());
		setLocationRelativeTo(null);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel pnlGioiThieu = new JPanel();
		pnlGioiThieu.setBackground(new Color(240, 240, 240));
		contentPane.add(pnlGioiThieu, "name_866271484529900");
		pnlGioiThieu.setLayout(new BorderLayout(0, 0));
		GioiThieu_Panel gt = new GioiThieu_Panel();
		pnlGioiThieu.add(gt);
		
		Panel pnlNhanVien = new Panel();
		pnlNhanVien.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlNhanVien, "name_546892073299700");
		pnlNhanVien.setLayout(new BorderLayout(0, 0));
		NhanVien_Panel nv = new NhanVien_Panel();
		nv.setBackground(new Color(0, 128, 255));
		pnlNhanVien.add(nv);
		
		Panel pnlPhongBan = new Panel();
		pnlPhongBan.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlPhongBan, "name_546892085841599");	
		pnlPhongBan.setLayout(new BorderLayout(0, 0));
		PhongBan_Panel pb = new PhongBan_Panel();
		pnlPhongBan.add(pb);
		
		JPanel pnlTaiKhoan = new JPanel();
		pnlTaiKhoan.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTaiKhoan, "name_753936047563000");
		pnlTaiKhoan.setLayout(new BorderLayout(0, 0));
		TaiKhoan_Panel tk = new TaiKhoan_Panel();
		pnlTaiKhoan.add(tk);
		
		JPanel pnlHopDong = new JPanel();
		contentPane.add(pnlHopDong, "name_768352962996400");
		pnlHopDong.setLayout(new BorderLayout(0, 0));
		HopDong_Panel hd = new HopDong_Panel();
		pnlHopDong.add(hd);
		
		JPanel pnlChamCongCN = new JPanel();
		contentPane.add(pnlChamCongCN, "name_847585581681500");
		pnlChamCongCN.setLayout(new BorderLayout(0, 0));
		ChamCongCongNhan_Panel cccn = new ChamCongCongNhan_Panel();
		pnlChamCongCN.add(cccn);
		
		JPanel pnlTinhLuongCN = new JPanel();
		contentPane.add(pnlTinhLuongCN, "name_850260952036700");
		pnlTinhLuongCN.setLayout(new BorderLayout(0, 0));
		LuongCongNhan_Panel lcn = new LuongCongNhan_Panel();
		pnlTinhLuongCN.add(lcn);
		
		JPanel pnlCongNhan = new JPanel();
		contentPane.add(pnlCongNhan, "name_1052588786228600");
		pnlCongNhan.setLayout(new BorderLayout(0, 0));
		CongNhan_Panel cn = new CongNhan_Panel();
		pnlCongNhan.add(cn);
		
		JPanel pnlChamCongNV = new JPanel();
		contentPane.add(pnlChamCongNV, "name_1053030999642700");
		pnlChamCongNV.setLayout(new BorderLayout(0, 0));
		ChamCongNhanVien_Panel ccnv = new ChamCongNhanVien_Panel();
		pnlChamCongNV.add(ccnv);
		
		JPanel pnlCongDoan = new JPanel();
		contentPane.add(pnlCongDoan, "name_1212400148451200");
		pnlCongDoan.setLayout(new BorderLayout(0, 0));
		CongDoan_Panel cd = new CongDoan_Panel();
		pnlCongDoan.add(cd);
		
		JPanel pnlSanPham = new JPanel();
		contentPane.add(pnlSanPham, "name_1228550237435500");
		pnlSanPham.setLayout(new BorderLayout(0, 0));
		SanPham_Panel sp = new SanPham_Panel();
		pnlSanPham.add(sp);
		
		JPanel pnlPhanCong = new JPanel();
		contentPane.add(pnlPhanCong, "name_1307824863196200");
		pnlPhanCong.setLayout(new BorderLayout(0, 0));
		PhanCongCongNhan_Panel pc = new PhanCongCongNhan_Panel();
		pnlPhanCong.add(pc);
		
		JPanel pnlToNhom = new JPanel();
		contentPane.add(pnlToNhom, "name_135946871882100");
		pnlToNhom.setLayout(new BorderLayout(0, 0));
		ToNhom_Panel tn = new ToNhom_Panel();
		pnlToNhom.add(tn);
		
		JPanel pnlThongKe = new JPanel();
		contentPane.add(pnlThongKe, "name_93440288109800");
		pnlThongKe.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTinhLuongNV = new JPanel();
		contentPane.add(pnlTinhLuongNV, "name_527274620109300");
		pnlTinhLuongNV.setLayout(new BorderLayout(0, 0));
		LuongNhanVien_Panel lnv = new LuongNhanVien_Panel();
		pnlTinhLuongNV.add(lnv);
		ThongKe_Panel thongke;
		thongke = new ThongKe_Panel();
		pnlThongKe.add(thongke);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(2, 5, 2, 0));
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);
		
		JMenu mnuHome = new JMenu("Home");
		mnuHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(false);
				pnlChamCongNV.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(true);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		URL urlHome = ManHinhChinh.class.getResource("/img/home.png");
		mnuHome.setIcon(new ImageIcon(urlHome));
		mnuHome.setForeground(new Color(0, 0, 0));
		mnuHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuBar.add(mnuHome);
		
		JMenu mnuQuanLy = new JMenu("Quản lý");
		URL urlQuanLy = ManHinhChinh.class.getResource("/img/folder.png");
		mnuQuanLy.setIcon(new ImageIcon(urlQuanLy));
		mnuQuanLy.setForeground(new Color(0, 0, 0));
		mnuQuanLy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuBar.add(mnuQuanLy);
		
		JMenuItem mniPhongBan = new JMenuItem("Phòng ban");
		mniPhongBan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		URL urlPhongBan = ManHinhChinh.class.getResource("/img/department.png");
		mniPhongBan.setIcon(new ImageIcon(urlPhongBan));
		mniPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mniPhongBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(true);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(false);
				pnlChamCongNV.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		mnuQuanLy.add(mniPhongBan);
		
		JMenuItem mniNhanVien = new JMenuItem("Nhân viên");
		mniNhanVien.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		URL urlNhanVien = ManHinhChinh.class.getResource("/img/employee.png");
		mniNhanVien.setIcon(new ImageIcon(urlNhanVien));
		mniNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mniNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(true);
				pnlTaiKhoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(false);
				pnlChamCongNV.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		mnuQuanLy.add(mniNhanVien);
		
		JMenuItem mniTaiKhoan = new JMenuItem("Tài khoản");
		mniTaiKhoan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		URL urlTaiKhoan = ManHinhChinh.class.getResource("/img/user.png");
		mniTaiKhoan.setIcon(new ImageIcon(urlTaiKhoan));
		mniTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mniTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(true);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(false);
				pnlChamCongNV.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		
		JMenuItem mniCongNhan = new JMenuItem("Công nhân");
		mniCongNhan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		URL urlCongNhan = ManHinhChinh.class.getResource("/img/worker.png");
		mniCongNhan.setIcon(new ImageIcon(urlCongNhan));
		mniCongNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(true);
				pnlChamCongNV.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		mniCongNhan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mnuQuanLy.add(mniCongNhan);
		mnuQuanLy.add(mniTaiKhoan);
		
		JMenuItem mniHopDong = new JMenuItem("Hợp đồng");
		mniHopDong.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		URL urlHopDong = ManHinhChinh.class.getResource("/img/contract.png");
		mniHopDong.setIcon(new ImageIcon(urlHopDong));
		mniHopDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlHopDong.setVisible(true);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(false);
				pnlChamCongNV.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		mniHopDong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mnuQuanLy.add(mniHopDong);
		
		
		JMenuItem mniCongDoan = new JMenuItem("Công đoạn");
		mniCongDoan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		URL urlCongDoan = ManHinhChinh.class.getResource("/img/procedure.png");
		mniCongDoan.setIcon(new ImageIcon(urlCongDoan));
		mniCongDoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlCongDoan.setVisible(true);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(false);
				pnlChamCongNV.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		
		JMenuItem mniSanPham = new JMenuItem("Sản phẩm");
		mniSanPham.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		URL urlSanPham = ManHinhChinh.class.getResource("/img/product.png");
		mniSanPham.setIcon(new ImageIcon(urlSanPham));
		mniSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlCongDoan.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(false);
				pnlChamCongNV.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlSanPham.setVisible(true);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		mniSanPham.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mnuQuanLy.add(mniSanPham);
		mniCongDoan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mnuQuanLy.add(mniCongDoan);
		
		JMenuItem mniToNhom = new JMenuItem("Tổ");
		mniToNhom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0));
		mniToNhom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlCongDoan.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(false);
				pnlChamCongNV.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(true);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		URL urlToNhom = ManHinhChinh.class.getResource("/img/group.png");
		mniToNhom.setIcon(new ImageIcon(urlToNhom));
		mniToNhom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mnuQuanLy.add(mniToNhom);
		
		JMenu mnuXuLy = new JMenu("Xử lý");
		URL urlXuLy = ManHinhChinh.class.getResource("/img/setting.png");
		mnuXuLy.setIcon(new ImageIcon(urlXuLy));
		mnuXuLy.setForeground(new Color(0, 0, 0));
		mnuXuLy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuBar.add(mnuXuLy);
		
		JMenu mnuChamCong = new JMenu("Chấm công");
		URL urlChamCong = ManHinhChinh.class.getResource("/img/timkeeping.png");
		mnuChamCong.setIcon(new ImageIcon(urlChamCong));
		mnuChamCong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mnuXuLy.add(mnuChamCong);
		
		JMenuItem mniChamCongNV = new JMenuItem("Chấm công nhân viên");
		mniChamCongNV.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		mniChamCongNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlChamCongNV.setVisible(true);
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlCongDoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		mniChamCongNV.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mnuChamCong.add(mniChamCongNV);
		
		JMenuItem mniChamCongCN = new JMenuItem("Chấm công công nhân");
		mniChamCongCN.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0));
		mniChamCongCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlCongDoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(true);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(false);
				pnlChamCongNV.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		mniChamCongCN.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mnuChamCong.add(mniChamCongCN);
		
		JMenu mnuTinhLuong = new JMenu("Tính lương");
		URL urlTinhLuong = ManHinhChinh.class.getResource("/img/paypal.png");
		mnuTinhLuong.setIcon(new ImageIcon(urlTinhLuong));
		mnuTinhLuong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mnuXuLy.add(mnuTinhLuong);
		
		JMenuItem mniTinhLuongNV = new JMenuItem("Tính lương nhân viên");
		mniTinhLuongNV.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, InputEvent.CTRL_DOWN_MASK));
		mniTinhLuongNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlCongDoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(false);
				pnlChamCongNV.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(true);
			}
		});
		mniTinhLuongNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnuTinhLuong.add(mniTinhLuongNV);
		
		JMenuItem mniTinhLuongCN = new JMenuItem("Tính lương công nhân");
		mniTinhLuongCN.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, InputEvent.CTRL_DOWN_MASK));
		mniTinhLuongCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlCongDoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(true);
				pnlCongNhan.setVisible(false);
				pnlChamCongNV.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		mniTinhLuongCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnuTinhLuong.add(mniTinhLuongCN);
		
		JMenuItem mniPhanCong = new JMenuItem("Phân công");
		mniPhanCong.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, InputEvent.ALT_DOWN_MASK));
		URL urlPhanCong = ManHinhChinh.class.getResource("/img/assignment.png");
		mniPhanCong.setIcon(new ImageIcon(urlPhanCong));
		mniPhanCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlCongDoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(false);
				pnlChamCongNV.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(true);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(false);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		mniPhanCong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mnuXuLy.add(mniPhanCong);
		
		JMenu mnuThongKe = new JMenu("Thống kê");
		mnuThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlCongDoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTinhLuongCN.setVisible(false);
				pnlCongNhan.setVisible(false);
				pnlChamCongNV.setVisible(false);
				pnlSanPham.setVisible(false);
				pnlPhanCong.setVisible(false);
				pnlGioiThieu.setVisible(false);
				pnlToNhom.setVisible(false);
				pnlThongKe.setVisible(true);
				pnlTinhLuongNV.setVisible(false);
			}
		});
		URL urlThongKe = ManHinhChinh.class.getResource("/img/excel.png");
		mnuThongKe.setIcon(new ImageIcon(urlThongKe));
		mnuThongKe.setForeground(new Color(0, 0, 0));
		mnuThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuBar.add(mnuThongKe);
		
		JMenu mnuHoTro = new JMenu("Hỗ trợ");
		mnuHoTro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        InputStream pdfStream = ManHinhChinh.class.getResourceAsStream("/support/07_7_ApplicationDevelopment_UserManual.pdf");
		        if (pdfStream != null) {
		            try {
		                java.nio.file.Path tempFile = java.nio.file.Files.createTempFile("tempPdf", ".pdf");
		                java.nio.file.Files.copy(pdfStream, tempFile, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
		                if (Desktop.isDesktopSupported()) {
		                    Desktop desktop = Desktop.getDesktop();
		                    if (desktop.isSupported(Desktop.Action.OPEN)) {
		                        desktop.open(tempFile.toFile());
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Hệ thống không hỗ trợ mở tệp PDF.");
		                    }
		                } else {
		                    JOptionPane.showMessageDialog(null, "Hệ thống không hỗ trợ Desktop Action.");
		                }
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Không thể tìm thấy tệp PDF trong JAR.");
		        }
			}
		});
		URL urlHoTro = ManHinhChinh.class.getResource("/img/support.png");
		mnuHoTro.setIcon(new ImageIcon(urlHoTro));
		mnuHoTro.setForeground(new Color(0, 0, 0));
		mnuHoTro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuBar.add(mnuHoTro);
		
		JMenu mnuAbout = new JMenu("About");
		URL urlAbout = ManHinhChinh.class.getResource("/img/about.png");
		mnuAbout.setIcon(new ImageIcon(urlAbout));
		mnuAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new About().setVisible(true);
			}
		});
		mnuAbout.setForeground(new Color(0, 0, 0));
		mnuAbout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		menuBar.add(mnuAbout);
		
		JMenuItem space = new JMenuItem("");
		space.setEnabled(false);
		space.setBackground(new Color(255, 255, 255));
		menuBar.add(space);
		
		JMenu mnuThongTinDangNhap = new JMenu(Keycode.getTaiKhoan().getNhanVien().getHoTen());
		mnuThongTinDangNhap.setForeground(new Color(0, 0, 0));
		mnuThongTinDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		URL urlThongTinDangNhap = ManHinhChinh.class.getResource("/img/user.png");
		mnuThongTinDangNhap.setIcon(new ImageIcon(urlThongTinDangNhap));
		menuBar.add(mnuThongTinDangNhap);
		
		JMenuItem mniDoiPass = new JMenuItem("Đổi mật khẩu");
		mniDoiPass.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_DOWN_MASK));
		URL urlDoiPass = ManHinhChinh.class.getResource("/img/changepassword.png");
		mniDoiPass.setIcon(new ImageIcon(urlDoiPass));
		mniDoiPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DoiMatKhau().setVisible(true);
			}
		});
		mniDoiPass.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mnuThongTinDangNhap.add(mniDoiPass);
		
		mniDangXuat = new JMenuItem("Đăng xuất");
		mniDangXuat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.CTRL_DOWN_MASK));
		URL urlDangXuat = ManHinhChinh.class.getResource("/img/logout.png");
		mniDangXuat.setIcon(new ImageIcon(urlDangXuat));
		mniDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mnuThongTinDangNhap.add(mniDangXuat);
		
		mniDangXuat.addActionListener(this);
		
		// Phân quyền người dùng
		int giaTri = Keycode.getTaiKhoan().getGiaTri();
		if(giaTri == 1) {
			
		}
		if(giaTri == 2) {
			mnuTinhLuong.setEnabled(false);
			mnuThongKe.setEnabled(false);
			mniHopDong.setEnabled(false);
			mniSanPham.setEnabled(false);
			mniCongDoan.setEnabled(false);
			mniChamCongCN.setEnabled(false);
			mniPhanCong.setEnabled(false);
		}
		if(giaTri == 3) {
			mniPhongBan.setEnabled(false);
			mniNhanVien.setEnabled(false);
			mniCongNhan.setEnabled(false);
			mniTaiKhoan.setEnabled(false);
			mnuXuLy.setEnabled(false);
			mnuThongKe.setEnabled(false);
			mniToNhom.setEnabled(false);
		}
		if(giaTri == 4) {
			mnuQuanLy.setEnabled(false);
			mnuChamCong.setEnabled(false);
			mniPhanCong.setEnabled(false);
			mniToNhom.setEnabled(false);
		}
		if(giaTri == 5) {
			mnuQuanLy.setEnabled(false);
			mniChamCongNV.setEnabled(false);
			mnuTinhLuong.setEnabled(false);
			mnuThongKe.setEnabled(false);
			mniToNhom.setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o.equals(mniDangXuat)) {
			this.dispose();
			new DangNhap().setVisible(true);
		}
		
	}
}
