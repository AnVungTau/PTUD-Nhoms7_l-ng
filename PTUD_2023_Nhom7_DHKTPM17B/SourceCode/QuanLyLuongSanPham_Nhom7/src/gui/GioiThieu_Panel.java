package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;

/**
 * @author Nguyễn Hồng Quân
 */
public class GioiThieu_Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblClock;

	public GioiThieu_Panel() {
		setLayout(new BorderLayout(0, 0));
		JPanel pnlBackGround = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Vẽ hình nền
				URL urlImage = GioiThieu_Panel.class.getResource("/img/SplashScreen.png");
				Image backgroundImage = new ImageIcon(urlImage).getImage();
				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
			}
		};
		add(pnlBackGround);
		pnlBackGround.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pnlSouth.setOpaque(false);
		pnlSouth.setBackground(new Color(255, 255, 255));
		pnlBackGround.add(pnlSouth, BorderLayout.SOUTH);
		
		lblClock = new JLabel("00:00:00 AM");
		lblClock.setHorizontalAlignment(SwingConstants.CENTER);
		lblClock.setForeground(new Color(255, 255, 255));
		lblClock.setFont(new Font("Tahoma", Font.BOLD, 30));
		pnlSouth.add(lblClock);
		
		clock();
	}

	private void clock() {
		new Thread() {
			public void run() {
				while (true) {
					Calendar ca = new GregorianCalendar();
					int hour = ca.get(Calendar.HOUR);
					int min = ca.get(Calendar.MINUTE);
					int sec = ca.get(Calendar.SECOND);
					int am_pm = ca.get(Calendar.AM_PM);
					
					
					String day_night;
					if(am_pm == 1) {
						day_night = "PM";
					}else {
						day_night = "AM";
					}
					
					lblClock.setText(hour + ":" + min + ":" + sec + " " + day_night);
				}
			}
		}.start();
	}

}
