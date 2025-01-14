package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JYearChooser;
import dao.BangChamCongCongNhan_DAO;
import entity.CongNhan;
import com.toedter.calendar.JMonthChooser;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import com.opencsv.CSVWriter;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 * @author Nguyễn Tuấn Hùng
 */
public class LuongCongNhan_Panel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTable tblLuongNV;
	private JButton btnTinhLuong;
	private JButton btnXuatFile;
	private DefaultTableModel modelBangLuong;
	private JTextField txtTim;
	private JButton btnTim;
	private JYearChooser yearChooser;
	private JMonthChooser monthChooser;
	private BangChamCongCongNhan_DAO bcccn_DAO = new BangChamCongCongNhan_DAO();
	private URL urlTim = LuongCongNhan_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
	private URL urlTinhLuong = LuongCongNhan_Panel.class.getResource("/img/calculator.png");
	private URL urlXuatFile = LuongCongNhan_Panel.class.getResource("/img/export.png");
	private JLabel lblBngLngCng;
	public LuongCongNhan_Panel() {
		setBackground(new Color(255, 255, 255));
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ti\u1EC1n l\u01B0\u01A1ng c\u00F4ng nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(new Color(255, 255, 255));
		pnlTop.setPreferredSize(new Dimension(10, 110));
		add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(null);
		btnXuatFile = new JButton("Xuất File");
		btnXuatFile.setIcon(new ImageIcon(urlXuatFile));
		btnXuatFile.setBackground(new Color(255, 255, 255));
		btnXuatFile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXuatFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXuatFile.setBounds(800, 40, 120, 30);
		pnlTop.add(btnXuatFile);
		
		btnTinhLuong = new JButton("Tính lương");
		btnTinhLuong.setIcon(new ImageIcon(urlTinhLuong));
		btnTinhLuong.setBackground(new Color(255, 255, 255));
		btnTinhLuong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTinhLuong.setBounds(323, 39, 150, 30);
		pnlTop.add(btnTinhLuong);
		
		JLabel lblChonThang = new JLabel("Chọn tháng");
		lblChonThang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChonThang.setBounds(21, 40, 93, 25);
		pnlTop.add(lblChonThang);
		
		monthChooser = new JMonthChooser();
		monthChooser.getComboBox().setFont(new Font("Tahoma", Font.PLAIN, 12));
		setComboBoxLocale(monthChooser, new Locale("vi"));
		monthChooser.setBounds(112, 40, 115, 25);
		pnlTop.add(monthChooser);
		
		yearChooser = new JYearChooser();
		yearChooser.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 12));
		yearChooser.setBounds(237, 40, 76, 25);
		pnlTop.add(yearChooser);
		
		lblBngLngCng = new JLabel("BẢNG LƯƠNG CÔNG NHÂN");
		lblBngLngCng.setHorizontalAlignment(SwingConstants.CENTER);
		lblBngLngCng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBngLngCng.setBackground(Color.WHITE);
		lblBngLngCng.setBounds(10, 8, 1268, 22);
		pnlTop.add(lblBngLngCng);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(255, 255, 255));
		pnlCenter.setBorder(new TitledBorder(null, "Danh s\u00E1ch ti\u1EC1n l\u01B0\u01A1ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));
		
		String header[] = {"Mã CN", "Họ tên","Tiền trợ cấp","Tổng lương"};
		modelBangLuong = new DefaultTableModel(header, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if(columnIndex == 2 || columnIndex == 3) {
					return Integer.class;
				}
				return super.getColumnClass(columnIndex);
			}	
		};
		JScrollPane scrollPane = new JScrollPane();
		pnlCenter.add(scrollPane);
		
		JPanel pnlTimNhanVien = new JPanel();
		pnlTimNhanVien.setLayout(null);
		pnlTimNhanVien.setSize(new Dimension(0, 100));
		pnlTimNhanVien.setPreferredSize(new Dimension(10, 35));
		pnlTimNhanVien.setBackground(Color.WHITE);
		pnlCenter.add(pnlTimNhanVien, BorderLayout.NORTH);
		
		txtTim = new JTextField();
		txtTim.setColumns(10);
		txtTim.setBounds(341, 5, 226, 25);
		pnlTimNhanVien.add(txtTim);
		
		JLabel lblTimKiem = new JLabel("Mã CN");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTimKiem.setBounds(250, 5, 60, 25);
		pnlTimNhanVien.add(lblTimKiem);
		
		btnTim = new JButton("");
		btnTim.setBorderPainted(false);
		btnTim.setIcon(new ImageIcon(urlTim));
		btnTim.setBackground(new Color(255, 255, 255));
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTim.setBounds(577, 5, 25, 25);
		pnlTimNhanVien.add(btnTim);
		
		tblLuongNV = new JTable(modelBangLuong);
		tblLuongNV.setSelectionForeground(new Color(255, 255, 255));
		tblLuongNV.setSelectionBackground(new Color(0, 128, 255));
		tblLuongNV.setRowHeight(20);
		tblLuongNV.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblLuongNV);
		TableRowSorter<TableModel> sorterSP = new TableRowSorter<TableModel>(modelBangLuong);
		tblLuongNV.setRowSorter(sorterSP);
		
		btnTim.addActionListener(this);
		btnTinhLuong.addActionListener(this);
		btnXuatFile.addActionListener(this);
	}
	private void clearTable() {
		int r = tblLuongNV.getRowCount();
		while (r > 0) {
			modelBangLuong.removeRow(r - 1);
			r--;
		}
	}
	
	private void LoadDanhSachCongNhan(ArrayList<CongNhan> dscn) {
		clearTable();
		DecimalFormat format = new DecimalFormat("#,##0 VND");
		for(CongNhan cn : dscn) {
			float tongLuong = Float.parseFloat(cn.getGhiChu());
			modelBangLuong.addRow(new Object[] { cn.getMaCN(),cn.getHoTen(),format.format(cn.getPhuCap()),format.format(tongLuong)});
		}
		
	}

	public static void exportToCSV(JTable table, String filePath) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
             CSVWriter writer = new CSVWriter(osw)) {

            // BOM (Byte Order Mark) for UTF-8
            osw.write('\ufeff');

            // Xuất tiêu đề cột
            String[] header = new String[table.getColumnCount()];
            for (int col = 0; col < table.getColumnCount(); col++) {
                header[col] = table.getColumnName(col);
            }
            writer.writeNext(header);

            // Xuất dữ liệu từ JTable
            for (int row = 0; row < table.getRowCount(); row++) {
                String[] rowValues = new String[table.getColumnCount()];
                for (int col = 0; col < table.getColumnCount(); col++) {
                    Object value = table.getValueAt(row, col);
                    rowValues[col] = (value != null) ? value.toString() : "";
                }
                writer.writeNext(rowValues);
            }

            JOptionPane.showMessageDialog(null, "Xuất CSV thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi xuất CSV.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void setComboBoxLocale(JComponent component, Locale locale) {
        component.setLocale(locale);
        component.getComponent(0).setLocale(locale);
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnTim)) {
			int thang = monthChooser.getMonth() +1;
			int nam = yearChooser.getYear();
			txtTim.getText().toString();
			LoadDanhSachCongNhan(bcccn_DAO.getDanhSachTinhLuongTheoNgayVaMa(txtTim.getText().toString(), thang, nam));
		}
		if(o.equals(btnTinhLuong)) {
			int thang = monthChooser.getMonth() +1;
			int nam = yearChooser.getYear();
			LoadDanhSachCongNhan(bcccn_DAO.getDanhSachTinhLuongTheoThangNam(thang, nam));
		}
		if(o.equals(btnXuatFile)) {
			JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn vị trí lưu file");
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                exportToCSV(tblLuongNV, fileToSave.getAbsolutePath());
            }
		}
	}
}
