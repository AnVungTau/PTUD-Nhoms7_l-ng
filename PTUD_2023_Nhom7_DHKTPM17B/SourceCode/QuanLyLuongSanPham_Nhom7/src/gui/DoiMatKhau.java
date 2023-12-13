package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import dao.TaiKhoan_DAO;
import entity.TaiKhoan;
import util.Keycode;
import util.MaHoa;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.ImageIcon;
/**
 * @author Nguyễn Hồng Quân
 */
public class DoiMatKhau extends JFrame implements ActionListener, WindowListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtMatKhauMoi;
	private JButton btnLuu;
	private JButton btnDong;
	private JLabel lblTBMatKhau;
	private URL urlTBFail = DoiMatKhau.class.getResource("/img/Saki-NuoveXT-Actions-button-cancel.16.png");
	private URL urlTBSuccess = DoiMatKhau.class.getResource("/img/Custom-Icon-Design-Pretty-Office-8-Accept.16.png");

	public DoiMatKhau() {
		setTitle("Đổi mật khẩu mới");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		setLocationRelativeTo(null);
		URL urlicon = DoiMatKhau.class.getResource("/img/logo_icon.png");
		ImageIcon icon = new ImageIcon(urlicon);
		setIconImage(icon.getImage());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatKhuMoi = new JLabel("Mật khẩu mới");
		lblMatKhuMoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMatKhuMoi.setBounds(70, 52, 99, 25);
		contentPane.add(lblMatKhuMoi);
		
		txtMatKhauMoi = new JPasswordField();
		txtMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMatKhauMoi.setBounds(70, 72, 260, 28);
		contentPane.add(txtMatKhauMoi);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setBackground(new Color(255, 255, 255));
		btnLuu.setEnabled(false);
		btnLuu.setBounds(70, 110, 120, 30);
		contentPane.add(btnLuu);
		
		btnDong = new JButton("Đóng");
		btnDong.setBackground(new Color(255, 255, 255));

		btnDong.setBounds(210, 110, 120, 30);
		contentPane.add(btnDong);
		
		lblTBMatKhau = new JLabel("");
		lblTBMatKhau.setIcon(new ImageIcon(urlTBFail));
		lblTBMatKhau.setBounds(333, 77, 20, 20);
		contentPane.add(lblTBMatKhau);
		
		txtMatKhauMoi.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				btnLuu.setEnabled(validDataMatKhau());
				if (validDataMatKhau()) {
					lblTBMatKhau.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBMatKhau.setIcon(new ImageIcon(urlTBFail));
				}
				
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				btnLuu.setEnabled(validDataMatKhau());
				if (validDataMatKhau()) {
					lblTBMatKhau.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBMatKhau.setIcon(new ImageIcon(urlTBFail));
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnDong.addActionListener(this);
		btnLuu.addActionListener(this);
		addWindowListener(this);
	}
	
	public boolean validDataMatKhau() {
		char[] passwordChars = txtMatKhauMoi.getPassword();
		String matKhau = new String(passwordChars);
		
		if (!matKhau.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
			return false;
		}
		return true;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDong)) {
			this.dispose();
		}
		
		if(o.equals(btnLuu)) {
			TaiKhoan tk = Keycode.getTaiKhoan();
			char[] passwordChars = txtMatKhauMoi.getPassword();
			String matKhau = new String(passwordChars);
			new MaHoa();
			String maHoaMatKhau = MaHoa.toSHA1(matKhau);
			tk.setMatKhau(maHoaMatKhau);
			TaiKhoan_DAO taiKhoan_dao = new TaiKhoan_DAO();
			if(taiKhoan_dao.capNhatTK(tk)) {
				JOptionPane.showMessageDialog(this, "Đã cập nhật");
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "Không thành công");
			}
		}
		
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		this.dispose();
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



}
