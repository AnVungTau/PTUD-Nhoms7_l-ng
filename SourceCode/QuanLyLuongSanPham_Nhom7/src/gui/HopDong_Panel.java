package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Trần Vũ Minh Nhật
 */
public class HopDong_Panel extends JPanel { 
	private JTextField textFieldMaHD;
    private JTextField textFieldTenHD;
    private JTextField textFieldTenKH;
    private JTextField textFieldTim;

    public HopDong_Panel() {   
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN HỢP ĐỒNG");
		lblNewLabel.setBounds(456, 10, 202, 43);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel);
		
		JLabel lblTenHopDong = new JLabel("Tên hợp đồng:");
		lblTenHopDong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenHopDong.setBounds(152, 136, 100, 19);
		add(lblTenHopDong);
		JLabel lblMaHopDong = new JLabel("Mã hợp đồng:");
		lblMaHopDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaHopDong.setBounds(152, 86, 95, 19);
		add(lblMaHopDong);
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(152, 188, 114, 19);
		add(lblTenKhachHang);
		
		JLabel lblTongTien = new JLabel("Tổng tiền (VND):");
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTongTien.setBounds(150, 229, 116, 19);
		add(lblTongTien);
		
		textFieldMaHD = new JTextField();
		textFieldMaHD.setBounds(277, 87, 138, 20);
		textFieldMaHD.setEditable(false); // Chuyển textField thành trường chỉ đọc

		add(textFieldMaHD);
		textFieldMaHD.setColumns(10);
		
		textFieldTenHD = new JTextField();
		textFieldTenHD.setColumns(10);
		textFieldTenHD.setBounds(277, 137, 138, 20);
		add(textFieldTenHD);
		
		textFieldTenKH = new JTextField();
		textFieldTenKH.setColumns(10);
		textFieldTenKH.setBounds(276, 189, 139, 20);
		add(textFieldTenKH);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(276, 229, 139, 22);
		add(comboBox);
		
		JLabel lblSoTienCoc = new JLabel("Số tiền cọc:");
		lblSoTienCoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoTienCoc.setBounds(506, 86, 79, 19);
		add(lblSoTienCoc);
		
		JLabel lblNgayBatDau = new JLabel("Ngày bắt đầu:");
		lblNgayBatDau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayBatDau.setBounds(506, 136, 96, 19);
		add(lblNgayBatDau);
		
		JLabel lblNgayKetThuc = new JLabel("Ngày kết thúc:");
		lblNgayKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayKetThuc.setBounds(506, 188, 99, 19);
		add(lblNgayKetThuc);
		
		JDateChooser dateChooserBatDau = new JDateChooser();
		dateChooserBatDau.setBounds(658, 136, 135, 20);
		add(dateChooserBatDau);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(658, 86, 135, 22);
		add(comboBox_1);
		
		// Tạo nút "Thêm" và đặt hình ảnh biểu tượng cho nó
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("img\\Iconsmind-Outline-Add.16.png"));
		btnThem.setBounds(393, 307, 79, 23);
		add(btnThem);

		// Tạo nút "Sửa" và đặt hình ảnh biểu tượng cho nó
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("img\\Iconsmind-Outline-File-Edit.16.png"));
		btnSua.setBounds(505, 307, 69, 23);
		add(btnSua);

		// Tạo nút "Làm mới" và đặt hình ảnh biểu tượng cho nó
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("img\\Iconsmind-Outline-Refresh.16.png"));
		btnLamMoi.setBounds(277, 307, 95, 23);
		add(btnLamMoi);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setBounds(613, 307, 63, 23);
		add(btnXoa);


		// Tạo một mảng 2D để lưu dữ liệu cho bảng
		Object[][] data = {
		    {"HD001", "Hợp đồng 1", "Khách hàng A", "1000000", "200000", "01/01/2023", "31/12/2023"},
		    {"HD002", "Hợp đồng 2", "Khách hàng B", "1500000", "300000", "15/02/2023", "14/02/2024"},
		    // Thêm dữ liệu cho các hàng khác ở đây
		};

		// Tạo một mảng chứa tên các cột
		String[] columnNames = {"Mã HD", "Hợp đồng", "Khách hàng", "Tổng tiền", "Tiền cọc", "Ngày bắt đầu", "Ngày kết thúc"};

		// Tạo một DefaultTableModel với dữ liệu và tên cột
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách hợp đồng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(72, 352, 141, 19);
		add(lblNewLabel_2);
				
				JComboBox comboBox_2 = new JComboBox();
				comboBox_2.setBounds(869, 352, 106, 22);
				add(comboBox_2);
		
				// Tạo một JTable với DefaultTableModel
				JTable table = new JTable(model);
				
						// Đặt kích thước và vị trí của bảng
						table.setBounds(100, 320, 800, 200);
						
								// Tạo một JScrollPane để cho phép cuộn bảng nếu có nhiều dữ liệu
								JScrollPane scrollPane = new JScrollPane(table);
								scrollPane.setBounds(0, 384, 975, 177);
								
										// Thêm bảng vào pnlHopDong
										add(scrollPane);
		
		textFieldTim = new JTextField();
		textFieldTim.setColumns(10);
		textFieldTim.setBounds(339, 353, 212, 20);
		add(textFieldTim);

		setBackground(new Color(255, 255, 255));
		
		JDateChooser dateChooserBatDau_1 = new JDateChooser();
		dateChooserBatDau_1.setBounds(658, 188, 135, 20);
		add(dateChooserBatDau_1);
    }
}
