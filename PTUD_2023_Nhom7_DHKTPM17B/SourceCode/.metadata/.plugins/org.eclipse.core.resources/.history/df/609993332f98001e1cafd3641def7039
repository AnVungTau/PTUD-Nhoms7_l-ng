package gui;

import javax.swing.JPanel;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
/**
 * @author Nguyễn Hồng Quân
 */
public class LuongCongNhan_Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;


	public LuongCongNhan_Panel() {
		setBackground(new Color(255, 255, 255));
		setBorder(new TitledBorder(null, "Ti\u1EC1n l\u01B0\u01A1ng c\u00F4ng nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(new Color(255, 255, 255));
		pnlTop.setPreferredSize(new Dimension(10, 110));
		add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(null);
		
		JLabel lblThang = new JLabel("Tháng");
		lblThang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThang.setBounds(73, 10, 99, 20);
		pnlTop.add(lblThang);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(83, 40, 143, 25);
		pnlTop.add(monthChooser);
		
		JLabel lblNam = new JLabel("Năm");
		lblNam.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNam.setBounds(273, 10, 64, 20);
		pnlTop.add(lblNam);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(283, 40, 64, 25);
		pnlTop.add(yearChooser);
		
		JButton btnXuatFile = new JButton("Xuất File");
		btnXuatFile.setBounds(800, 40, 85, 20);
		pnlTop.add(btnXuatFile);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(255, 255, 255));
		pnlCenter.setBorder(new TitledBorder(null, "Danh s\u00E1ch ti\u1EC1n l\u01B0\u01A1ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));
		
		String header[] = {"STT", "Mã CN", "Họ tên", "Phụ cấp", "Giá tiền CĐ", "Tổng số lượng HT", "Tổng lương"};
		DefaultTableModel model = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane();
		pnlCenter.add(scrollPane);
		
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

	}
}
