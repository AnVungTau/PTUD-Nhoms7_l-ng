package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.FlowLayout;
/**
 * @author Nguyễn Hồng Quân
 */
public class ChamCongCongNhan_Panel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ChamCongCongNhan_Panel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTop = new JPanel();
		pnlTop.setPreferredSize(new Dimension(10, 110));
		add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(new Color(255, 255, 255));
		pnlTop.add(pnlTitle, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Chấm công công nhân");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnlTitle.add(lblTitle);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlTop.add(pnlChucNang, BorderLayout.CENTER);
		pnlChucNang.setLayout(null);
		
		JLabel lblNgayCham = new JLabel("Ngày chấm");
		lblNgayCham.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayCham.setBounds(73, 10, 99, 20);
		pnlChucNang.add(lblNgayCham);
		
		JDateChooser dateNgayCham = new JDateChooser();
		dateNgayCham.setBounds(83, 40, 115, 20);
		pnlChucNang.add(dateNgayCham);
		
		JLabel lblSanPham = new JLabel("Sản phẩm");
		lblSanPham.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSanPham.setBounds(273, 10, 99, 20);
		pnlChucNang.add(lblSanPham);
		
		JComboBox cmbSanPham = new JComboBox();
		cmbSanPham.setBounds(283, 40, 115, 20);
		pnlChucNang.add(cmbSanPham);
		
		JLabel lblCongDoan = new JLabel("Công đoạn");
		lblCongDoan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCongDoan.setBounds(473, 10, 99, 20);
		pnlChucNang.add(lblCongDoan);
		
		JComboBox cmbCongDoan = new JComboBox();
		cmbCongDoan.setBounds(483, 40, 115, 20);
		pnlChucNang.add(cmbCongDoan);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(255, 255, 255));
		pnlCenter.setBorder(new TitledBorder(null, "Danh s\u00E1ch c\u00F4ng nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(pnlCenter, BorderLayout.CENTER);
		
		String header[] = {"STT", "Mã CN", "Họ tên", "Sản phẩm", "Công đoạn", "Số lượng PC", "Số lượng HT", "Trạng thái"};
		DefaultTableModel model = new DefaultTableModel(header, 0);
		pnlCenter.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		pnlCenter.add(scrollPane);
		
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		JPanel pnlSouth = new JPanel();
		pnlSouth.setPreferredSize(new Dimension(10, 30));
		pnlSouth.setBackground(new Color(255, 255, 255));
		add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(null);

		
		JButton btnChamCong = new JButton("Chấm công");
		btnChamCong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnChamCong.setBounds(800, 5, 129, 20);
		pnlSouth.add(btnChamCong);

	}
}
