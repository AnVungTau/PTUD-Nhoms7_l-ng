package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Nguyễn Hồng Quân
 */
public class DangNhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMa;
	private JPasswordField txtMatKhau;
	private JTextField textField;
	private JPanel pnlDangNhap;
	private JPanel pnlQuenMatKhau;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		ImageIcon icon = new ImageIcon("img//salary.png");
		setIconImage(icon.getImage());
		setTitle("QUẢN LÝ LƯƠNG");
		
		JPanel pnlLeft = new JPanel();
		pnlLeft.setBackground(new Color(0, 128, 128));
		pnlLeft.setBounds(0, 0, 350, 313);
		contentPane.add(pnlLeft);
		pnlLeft.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to 7 Wood");
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcome.setBounds(91, 173, 169, 27);
		pnlLeft.add(lblWelcome);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBackground(new Color(255, 255, 255));
		lblIcon.setBounds(138, 99, 64, 64);
		lblIcon.setIcon(new ImageIcon("img//businessman.png"));
		pnlLeft.add(lblIcon);
		
		JPanel pnlRight = new JPanel();
		pnlRight.setBounds(351, 0, 335, 313);
		contentPane.add(pnlRight);
		pnlRight.setLayout(new CardLayout(0, 0));
		
		pnlDangNhap = new JPanel();
		pnlDangNhap.setBackground(new Color(255, 255, 255));
		pnlRight.add(pnlDangNhap, "name_530517731490100");
		pnlDangNhap.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTopDN = new JPanel();
		pnlTopDN.setBackground(new Color(255, 255, 255));
		pnlDangNhap.add(pnlTopDN, BorderLayout.NORTH);
		
		JLabel lblDangNhap = new JLabel("Đăng nhập");
		lblDangNhap.setFont(new Font("Arial", Font.BOLD, 18));
		pnlTopDN.add(lblDangNhap);
		
		JPanel pnlCenterDN = new JPanel();
		pnlCenterDN.setBackground(new Color(255, 255, 255));
		pnlDangNhap.add(pnlCenterDN, BorderLayout.CENTER);
		pnlCenterDN.setLayout(null);
		
		JLabel lblMa = new JLabel("Mã NV");
		lblMa.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMa.setBounds(56, 56, 60, 13);
		pnlCenterDN.add(lblMa);
		
		txtMa = new JTextField();
		txtMa.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMa.setBounds(56, 71, 220, 25);
		pnlCenterDN.add(txtMa);
		txtMa.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMatKhau.setBounds(56, 106, 87, 13);
		pnlCenterDN.add(lblMatKhau);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDangNhap.setForeground(new Color(255, 255, 255));
		btnDangNhap.setBackground(new Color(0, 128, 128));
		btnDangNhap.setFont(new Font("Arial", Font.BOLD, 14));
		btnDangNhap.setBounds(56, 179, 220, 25);
		pnlCenterDN.add(btnDangNhap);
		
		JButton btnQuenMatKhau = new JButton("Quên mật khẩu ?");
		btnQuenMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlDangNhap.setVisible(false);
				pnlQuenMatKhau.setVisible(true);
			}
		});
		btnQuenMatKhau.setBackground(new Color(0, 0, 0));
		btnQuenMatKhau.setFont(new Font("Arial", Font.PLAIN, 10));
		btnQuenMatKhau.setBounds(56, 214, 133, 21);
		btnQuenMatKhau.setOpaque(false);
		pnlCenterDN.add(btnQuenMatKhau);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMatKhau.setEchoChar('*');
		txtMatKhau.setBounds(56, 122, 220, 25);
		pnlCenterDN.add(txtMatKhau);
		
		pnlQuenMatKhau = new JPanel();
		pnlRight.add(pnlQuenMatKhau, "name_530532394773100");
		pnlQuenMatKhau.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(new Color(255, 255, 255));
		pnlQuenMatKhau.add(pnlTop, BorderLayout.NORTH);
		
		JLabel lblQuenMatKhau = new JLabel("Quên mật khẩu");
		lblQuenMatKhau.setFont(new Font("Arial", Font.BOLD, 18));
		pnlTop.add(lblQuenMatKhau);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(255, 255, 255));
		pnlQuenMatKhau.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmail.setBounds(58, 84, 45, 13);
		pnlCenter.add(lblEmail);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setBounds(58, 98, 220, 25);
		pnlCenter.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(58, 133, 220, 25);
		pnlCenter.add(btnNewButton);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBackground(new Color(0, 0, 0));
		btnQuayLai.setOpaque(false);
		btnQuayLai.setFont(new Font("Arial", Font.PLAIN, 10));
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlDangNhap.setVisible(true);
				pnlQuenMatKhau.setVisible(false);
			}
		});
		btnQuayLai.setBounds(58, 168, 78, 21);
		pnlCenter.add(btnQuayLai);
		setLocationRelativeTo(null);
	}
}
