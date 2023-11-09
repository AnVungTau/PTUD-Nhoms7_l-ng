package gui;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Font;
/**
 * @author Nguyễn Hồng Quân
 */
public class ManHinhChinh extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Panel pnlNhanVien;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhChinh frame = new ManHinhChinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ManHinhChinh() {
		setTitle("QUẢN LÝ LƯƠNG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ImageIcon icon = new ImageIcon("img//salary.png");
		setIconImage(icon.getImage());
		setLocationRelativeTo(null);
		contentPane.setLayout(new CardLayout(0, 0));
		
		pnlNhanVien = new Panel();
		pnlNhanVien.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlNhanVien, "name_546892073299700");
		pnlNhanVien.setLayout(new BorderLayout(0, 0));
		NhanVien_Panel nv = new NhanVien_Panel();
		pnlNhanVien.add(nv);
		
		Panel pnlPhongBan = new Panel();
		pnlPhongBan.setBackground(new Color(0, 128, 255));
		contentPane.add(pnlPhongBan, "name_546892085841599");		
		
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
		
		JPanel pnlTienLuongCN = new JPanel();
		contentPane.add(pnlTienLuongCN, "name_850260952036700");
		pnlTienLuongCN.setLayout(new BorderLayout(0, 0));
		LuongCongNhan_Panel lcn = new LuongCongNhan_Panel();
		pnlTienLuongCN.add(lcn);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnuQuanLy = new JMenu("Quản lý");
		mnuQuanLy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mnuQuanLy);
		
		JMenuItem mniPhongBan = new JMenuItem("Phòng ban");
		mniPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mniPhongBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(true);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTienLuongCN.setVisible(false);
			}
		});
		mnuQuanLy.add(mniPhongBan);
		
		JMenuItem mniNhanVien = new JMenuItem("Nhân viên");
		mniNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mniNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(true);
				pnlTaiKhoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTienLuongCN.setVisible(false);
			}
		});
		mnuQuanLy.add(mniNhanVien);
		
		JMenuItem mniTaiKhoan = new JMenuItem("Tài khoản");
		mniTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mniTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(true);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTienLuongCN.setVisible(false);
				
			}
		});
		mnuQuanLy.add(mniTaiKhoan);
		
		JMenuItem mniHopDong = new JMenuItem("Hợp đồng");
		mniHopDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlHopDong.setVisible(true);
				pnlChamCongCN.setVisible(false);
				pnlTienLuongCN.setVisible(false);
			}
		});
		mniHopDong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnuQuanLy.add(mniHopDong);
		
		JMenu mnuXuLy = new JMenu("Xử lý");
		mnuXuLy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mnuXuLy);
		
		JMenu mnNewMenu = new JMenu("Chấm công");
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnuXuLy.add(mnNewMenu);
		
		JMenuItem mniChamCongNV = new JMenuItem("Chấm công nhân viên");
		mniChamCongNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnNewMenu.add(mniChamCongNV);
		
		JMenuItem mniChamCongCN = new JMenuItem("Chấm công công nhân");
		mniChamCongCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(true);
				pnlTienLuongCN.setVisible(false);
			}
		});
		mniChamCongCN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnNewMenu.add(mniChamCongCN);
		
		JMenu mnuTienLuong = new JMenu("Tiền lương");
		mnuTienLuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnuXuLy.add(mnuTienLuong);
		
		JMenuItem mniTienLuongNV = new JMenuItem("Tiền lương nhân viên");
		mniTienLuongNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnuTienLuong.add(mniTienLuongNV);
		
		JMenuItem mniTienLuongCN = new JMenuItem("Tiền lương công nhân");
		mniTienLuongCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlPhongBan.setVisible(false);
				pnlNhanVien.setVisible(false);
				pnlTaiKhoan.setVisible(false);
				pnlHopDong.setVisible(false);
				pnlChamCongCN.setVisible(false);
				pnlTienLuongCN.setVisible(true);
			}
		});
		mniTienLuongCN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnuTienLuong.add(mniTienLuongCN);
		
		JMenu mnuHoTro = new JMenu("Hỗ trợ");
		mnuHoTro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mnuHoTro);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mntmNewMenuItem_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnuHoTro.add(mntmNewMenuItem_2);
		
		Component horizontalStrut = Box.createHorizontalStrut(668);
		horizontalStrut.setMaximumSize(new Dimension(700, 32767));
		horizontalStrut.setMinimumSize(new Dimension(700, 0));
		horizontalStrut.setPreferredSize(new Dimension(700, 0));
		menuBar.add(horizontalStrut);
		JMenu mnuThongTinDangNhap = new JMenu("Nguyễn Hồng Quân");
		mnuThongTinDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnuThongTinDangNhap.setIcon(new ImageIcon("img\\user.png"));
		menuBar.add(mnuThongTinDangNhap);
		
		JMenuItem mniDoiPass = new JMenuItem("Đổi mật khẩu");
		mniDoiPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnuThongTinDangNhap.add(mniDoiPass);
		
		JMenuItem mniDangXuat = new JMenuItem("Đăng xuất");
		mniDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnuThongTinDangNhap.add(mniDangXuat);
	}


}
