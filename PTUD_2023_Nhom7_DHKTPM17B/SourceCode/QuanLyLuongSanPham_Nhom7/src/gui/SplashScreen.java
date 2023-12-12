package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.util.Random;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
/**
 * @author Nguyễn Hồng Quân
 */
public class SplashScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progressBar;
	private JLabel lblInfo;

	public SplashScreen() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setLocationRelativeTo(null);
		URL urlicon = SplashScreen.class.getResource("/img/logo_icon.png");
		ImageIcon icon = new ImageIcon((urlicon));
		setIconImage(icon.getImage());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInfo = new JLabel("Preparing...");
		lblInfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfo.setBounds(10, 280, 480, 25);
		contentPane.add(lblInfo);
		
		JLabel lblCopy = new JLabel("Copyright (C) 2023");
		lblCopy.setHorizontalAlignment(SwingConstants.LEFT);
		lblCopy.setForeground(Color.WHITE);
		lblCopy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCopy.setBounds(10, 255, 480, 25);
		contentPane.add(lblCopy);
		
		JLabel lblVer = new JLabel("Salar v1");
		lblVer.setHorizontalAlignment(SwingConstants.LEFT);
		lblVer.setForeground(new Color(255, 255, 255));
		lblVer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVer.setBounds(10, 230, 480, 25);
		contentPane.add(lblVer);
		
		JLabel lblHinh = new JLabel("");
		lblHinh.setBounds(2, 2, 496, 303);
		URL urlHinh = SplashScreen.class.getResource("/img/SplashScreen.png");
		lblHinh.setIcon(new ImageIcon(urlHinh));
		contentPane.add(lblHinh);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setBounds(2, 305, 496, 18);
		progressBar.setOpaque(true);
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		progressBar.setForeground(new Color(2, 125, 183));
		contentPane.add(progressBar);
		
		Task t = new Task();
		t.execute();
	}
	
	class Task extends SwingWorker<Void, Void>{

		@Override
		protected Void doInBackground() throws Exception {
			Random ran = new Random();
			int progress = 0;
			while(progress <= 100) {
				try {
					Thread.sleep(ran.nextInt(1000));
				} catch (Exception e) {
					System.out.println(e);
				}
				progress += ran.nextInt(10);
				setProgress(Math.min(progress, 100));
				progressBar.setValue(progress);
				if(progress <= 20) {
					lblInfo.setText("Preparing system " + progress + "%");
				}else if(progress <= 50){
					lblInfo.setText("Preparing resources " + progress + "%");
				}else if(progress <= 90){
					lblInfo.setText("Preparing GUI " + progress + "%");
				}
			}
			lblInfo.setText("done");
			return null;
		}
		
		@Override
		protected void done() {
			try {
				dispose();
				new DangNhap().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
