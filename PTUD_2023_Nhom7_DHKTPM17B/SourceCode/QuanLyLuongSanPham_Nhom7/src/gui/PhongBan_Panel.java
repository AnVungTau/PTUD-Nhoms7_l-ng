package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import entity.PhongBan;
import util.QuanLyMaPhongBan;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.BorderLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultFormatter;

import dao.PhongBan_DAO;

import javax.swing.ImageIcon;
/**
 * @author Nguyễn Tuấn Hùng
 */
public class PhongBan_Panel extends JPanel implements  ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtMaPB;
	private JTextField txtTenPhong;
	private JTextField txtGhiChu;
	private JTextField txtTimKiem;
	private JTable tblPhongBan;
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnLamMoi;
	private JButton btnTim;
	private DefaultTableModel model;
	private PhongBan_DAO pb_DAO  = new  PhongBan_DAO();
	private JSpinner spnDienTich = new JSpinner();
	private JSpinner spnTang = new JSpinner();
	private JComboBox<String> cmbToaNha = new JComboBox<>();
	private JComboBox<String> cmbTimKiem = new JComboBox<>();
	private URL urlTim = CongNhan_Panel.class.getResource("/img/Ampeross-Qetto-2-Search.24.png");
	private URL urlThem = CongNhan_Panel.class.getResource("/img/Custom-Icon-Design-Flatastic-1-Add-1.24.png");
	private URL urlLamMoi = CongNhan_Panel.class.getResource("/img/Hopstarter-Button-Button-Reload.24.png");
	private URL urlLuu = CongNhan_Panel.class.getResource("/img/Oxygen-Icons.org-Oxygen-Actions-document-save.24.png");
	private URL urlTBFail = CongNhan_Panel.class.getResource("/img/Saki-NuoveXT-Actions-button-cancel.16.png");
	private URL urlTBSuccess = CongNhan_Panel.class.getResource("/img/Custom-Icon-Design-Pretty-Office-8-Accept.16.png");
	public PhongBan_Panel() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTop = new JPanel();
		pnlTop.setPreferredSize(new Dimension(10, 250));
		pnlTop.setBackground(new Color(255, 255, 255));
		add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN PHÒNG BAN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 1280, 25);
		pnlTop.add(lblNewLabel);
		
		JLabel lblMaPhongBan = new JLabel("Mã phòng ");
		lblMaPhongBan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaPhongBan.setPreferredSize(new Dimension(64, 14));
		lblMaPhongBan.setMinimumSize(new Dimension(64, 14));
		lblMaPhongBan.setMaximumSize(new Dimension(64, 14));
		lblMaPhongBan.setBounds(351, 60, 82, 25);
		pnlTop.add(lblMaPhongBan);
		
		JLabel lblTenPhong = new JLabel("Tên phòng");
		lblTenPhong.setPreferredSize(new Dimension(64, 14));
		lblTenPhong.setMinimumSize(new Dimension(64, 14));
		lblTenPhong.setMaximumSize(new Dimension(64, 14));
		lblTenPhong.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenPhong.setBounds(351, 100, 82, 25);
		pnlTop.add(lblTenPhong);
		
		JLabel lblToaNha = new JLabel("Toà nhà ");
		lblToaNha.setPreferredSize(new Dimension(64, 14));
		lblToaNha.setMinimumSize(new Dimension(64, 14));
		lblToaNha.setMaximumSize(new Dimension(64, 14));
		lblToaNha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblToaNha.setBounds(351, 140, 82, 25);
		pnlTop.add(lblToaNha);
		
		JLabel lblTang = new JLabel("Tầng");
		lblTang.setPreferredSize(new Dimension(64, 14));
		lblTang.setMinimumSize(new Dimension(64, 14));
		lblTang.setMaximumSize(new Dimension(64, 14));
		lblTang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTang.setBounds(590, 140, 52, 25);
		pnlTop.add(lblTang);
		
		JLabel lblDienTich = new JLabel("Diện tích");
		lblDienTich.setPreferredSize(new Dimension(64, 14));
		lblDienTich.setMinimumSize(new Dimension(64, 14));
		lblDienTich.setMaximumSize(new Dimension(64, 14));
		lblDienTich.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDienTich.setBounds(725, 140, 82, 25);
		pnlTop.add(lblDienTich);
		
		txtMaPB = new JTextField();
		txtMaPB.setDisabledTextColor(new Color(0, 0, 0));
		txtMaPB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaPB.setText("");
		txtMaPB.setEnabled(false);
		txtMaPB.setColumns(10);
		txtMaPB.setBounds(461, 60, 150, 25);
		pnlTop.add(txtMaPB);
		
		txtTenPhong = new JTextField();
		txtTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTenPhong.setColumns(10);
		txtTenPhong.setBounds(461, 100, 180, 25);
		pnlTop.add(txtTenPhong);
		
		spnTang = new JSpinner();
		spnTang.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spnTang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnTang.setBounds(635, 140, 65, 25);
		customJSpiner(spnTang);
		pnlTop.add(spnTang);
		
		spnDienTich = new JSpinner();
		spnDienTich.setModel(new SpinnerNumberModel(Float.valueOf(1), Float.valueOf(1), Float.valueOf(1000), Float.valueOf(1)));
		spnDienTich.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnDienTich.setBounds(796, 140, 65, 25);
		customJSpiner(spnDienTich);
		pnlTop.add(spnDienTich);
		
		cmbToaNha = new JComboBox<>();
		for (char c = 'A'; c <= 'Z'; c++) {
            cmbToaNha.addItem(String.valueOf(c));
        }
		cmbToaNha.setBackground(new Color(255, 255, 255));
		cmbToaNha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbToaNha.setBounds(461, 140, 100, 25);
		pnlTop.add(cmbToaNha);
		
		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setPreferredSize(new Dimension(64, 14));
		lblGhiCh.setMinimumSize(new Dimension(64, 14));
		lblGhiCh.setMaximumSize(new Dimension(64, 14));
		lblGhiCh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGhiCh.setBounds(725, 60, 82, 25);
		pnlTop.add(lblGhiCh);
		
		txtGhiChu = new JTextField();
		txtGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtGhiChu.setColumns(10);
		txtGhiChu.setBounds(796, 60, 159, 65);
		pnlTop.add(txtGhiChu);
		
		btnThem = new JButton("Thêm");
		btnThem.setEnabled(false);
		btnThem.setBackground(new Color(255, 255, 255));
		btnThem.setIcon(new ImageIcon(urlThem));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBounds(446, 195, 120, 30);
		pnlTop.add(btnThem);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setBackground(new Color(255, 255, 255));
		btnLuu.setIcon(new ImageIcon(urlLuu));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBounds(597, 195, 120, 30);
		pnlTop.add(btnLuu);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(new Color(255, 255, 255));
		btnLamMoi.setIcon(new ImageIcon(urlLamMoi));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setBounds(741, 195, 120, 30);
		pnlTop.add(btnLamMoi);
		
		JLabel lblTBTen = new JLabel("");
		lblTBTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTBTen.setIcon(new ImageIcon(urlTBFail));
		lblTBTen.setBackground(Color.WHITE);
		lblTBTen.setBounds(651, 100, 25, 25);
		pnlTop.add(lblTBTen);
		
		JPanel pnlDanhSach = new JPanel();
		pnlDanhSach.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch ph\u00F2ng ban", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDanhSach.setBackground(Color.WHITE);
		add(pnlDanhSach);
		pnlDanhSach.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTim = new JPanel();
		pnlTim.setLayout(null);
		pnlTim.setSize(new Dimension(0, 100));
		pnlTim.setPreferredSize(new Dimension(10, 35));
		pnlTim.setBackground(Color.WHITE);
		pnlDanhSach.add(pnlTim, BorderLayout.NORTH);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(257, 6, 226, 25);
		pnlTim.add(txtTimKiem);
		
		String cmbSX[] = { "Mã phòng ban", "Tên phòng", "Toà nhà", "Tầng", "Diện tích"};
		cmbTimKiem = new JComboBox<>(cmbSX);
		cmbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTimKiem.setBounds(109, 5, 116, 25);
		pnlTim.add(cmbTimKiem);
		
		JLabel lblLoc = new JLabel("Tìm kiếm theo");
		lblLoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoc.setBounds(10, 5, 89, 20);
		pnlTim.add(lblLoc);
		
		btnTim = new JButton("");
		btnTim.setBorderPainted(false);
		btnTim.setBackground(new Color(255, 255, 255));
		btnTim.setIcon(new ImageIcon(urlTim));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTim.setBounds(493, 5, 25, 25);
		pnlTim.add(btnTim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		pnlDanhSach.add(scrollPane, BorderLayout.CENTER);
		
		String headerPB[] = { "Mã PB", "Tên phòng ban", "Tòa nhà", "Tầng", "Diện tích (m2)", "Ghi chú" };
		model = new DefaultTableModel(headerPB, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		txtTenPhong.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				btnThem.setEnabled(valiDataTenPB());
				btnLuu.setEnabled(valiDataTenPB());
				if (valiDataTenPB()) {
					lblTBTen.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBTen.setIcon(new ImageIcon(urlTBFail));
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				btnThem.setEnabled(valiDataTenPB());
				btnLuu.setEnabled(valiDataTenPB());
				if (valiDataTenPB()) {
					lblTBTen.setIcon(new ImageIcon(urlTBSuccess));
				} else {
					lblTBTen.setIcon(new ImageIcon(urlTBFail));
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tblPhongBan = new JTable(model);
		tblPhongBan.setRowHeight(20);
		tblPhongBan.setSelectionForeground(new Color(255, 255, 255));
		tblPhongBan.setSelectionBackground(new Color(0, 128, 255));
		tblPhongBan.setFillsViewportHeight(true);
		tblPhongBan.setBackground(Color.WHITE);
		scrollPane.setViewportView(tblPhongBan);
		btnThem.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTim.addActionListener(this);
		btnLuu.addActionListener(this);
		LoadDanhSachPhongBan(pb_DAO.getAllPhongBan());
		addTableSelectionListener(tblPhongBan);
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        tblPhongBan.setRowSorter(sorter);
	}
	
	private void customJSpiner(JSpinner X) {
		JComponent editor = X.getEditor();
		if (editor instanceof JSpinner.DefaultEditor) {
			JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
			DefaultFormatter formatter = (DefaultFormatter) textField.getFormatter();
			formatter.setOverwriteMode(true);
			textField.setHorizontalAlignment(JTextField.CENTER);
		}
	}

	private void clearTable() {
		DefaultTableModel model = (DefaultTableModel) tblPhongBan.getModel();
	    model.setRowCount(0);
	}
	private void LoadDanhSachPhongBan(ArrayList<PhongBan> dsPB) {
		clearTable();
		DefaultTableModel model = (DefaultTableModel) tblPhongBan.getModel();
		for (PhongBan pb : dsPB) {
	        model.addRow(new Object[] { pb.getMaPhong(), pb.getTenPhong(), pb.getToaNha(), pb.getTang(), pb.getDienTich(), pb.getGhiChu()});
	    }
	}
	public PhongBan revertPhongBanFromFields() {
	    PhongBan pb = null;
	    try {
	        String maPB = txtMaPB.getText().trim();
	        String tenPB = txtTenPhong.getText().trim();
			String toaNha = cmbToaNha.getSelectedItem().toString(); 
			int tang =  (int) spnTang.getValue(); 
			float dienTich = Float.valueOf(spnDienTich.getValue().toString());
	        String ghiChu = txtGhiChu.getText().trim();

	        pb = new PhongBan(maPB, tenPB, toaNha,tang, dienTich,ghiChu);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return pb;
	}
	public void themPB() {
	    PhongBan pb = revertPhongBanFromFields();
	    QuanLyMaPhongBan quanLyMaPhongBan = new QuanLyMaPhongBan();
	    pb.setMaPhong(quanLyMaPhongBan.generateMaPhongBan());

	    if (pb.getDienTich() > 0) {
	        if (pb_DAO.themPB(pb)) {
	            LoadDanhSachPhongBan(pb_DAO.getAllPhongBan());
	            JOptionPane.showMessageDialog(this, "Thêm phòng ban thành công!");
	        } else {
	            JOptionPane.showMessageDialog(this, "Lỗi khi thêm phòng ban!");
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Diện tích phải lớn hơn 0!");
	    }
	}
	public void suaPB() {
		int r = tblPhongBan.getSelectedRow();
		if(r < 0) {
			JOptionPane.showMessageDialog(this, "Chọn dòng muốn sửa");
			return;
		}
	    PhongBan phongBan = revertPhongBanFromFields();
	    phongBan.setMaPhong(txtMaPB.getText());
	    if (phongBan.getDienTich() > 0) {
	        if (pb_DAO.suaPhongBan(phongBan)) {
	            // Load lại danh sách phòng ban sau khi sửa
	            LoadDanhSachPhongBan(pb_DAO.getAllPhongBan());
	            JOptionPane.showMessageDialog(this, "Sửa phòng ban thành công!");
	        } else {
	            JOptionPane.showMessageDialog(this, "Lỗi khi sửa phòng ban!");
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Diện tích phải lớn hơn 0!");
	    }
	}
	private void clearPhongBanFields() {
	    txtMaPB.setText("");
	    txtTenPhong.setText("");
	    cmbToaNha.setSelectedIndex(0);
	    spnTang.setValue(1); 
	    spnDienTich.setValue(0); 
	    txtGhiChu.setText("");
	    txtMaPB.requestFocus(); 
	}
	private void reloadCongDoanPanel() {
        clearPhongBanFields();
        tblPhongBan.clearSelection();
	}
	public boolean valiDataTenPB() {
		String hoten = txtTenPhong.getText().trim();
		if (hoten.isEmpty()) {
			return false;
		}
		return true;
	}
	public boolean validData() {
		if (valiDataTenPB() && valiDataDienTich()) {
			return true;
		}
		return false;
	}
	public boolean valiDataDienTich() {
		Float dienTich = Float.valueOf(spnDienTich.getValue().toString());
		if (dienTich <= 0) {
			return false;
		}
		return true;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

	    if (o.equals(btnLamMoi)) {
	    	reloadCongDoanPanel();
	    	LoadDanhSachPhongBan(pb_DAO.getAllPhongBan());
	    }
	    if (o.equals(btnThem)) {  	
	        themPB();
	        reloadCongDoanPanel();
	    }
	    if(o.equals(btnLuu)) {
	    	if(JOptionPane.showConfirmDialog(this, "Bạn muốn lưu thay đổi", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
	    		suaPB();
		    	reloadCongDoanPanel();
	    	}
	    }
	    if (o.equals(btnTim)) {
	    	String timKiem = txtTimKiem.getText();
	        int chon = cmbTimKiem.getSelectedIndex();
	        if (timKiem.trim().isEmpty()) 
	            return;
	        else {
	            ArrayList<PhongBan> ds = pb_DAO.timPhongBan(chon, timKiem);
	            		LoadDanhSachPhongBan(ds);     		
	        }
	    }
	}

	private void addTableSelectionListener(JTable table) {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get information from the selected row and populate JTextFields
                        txtMaPB.setText(table.getValueAt(selectedRow, 0).toString());
                        txtTenPhong.setText(table.getValueAt(selectedRow, 1).toString());
                        cmbToaNha.setSelectedItem(table.getValueAt(selectedRow, 2).toString());
                        spnTang.setValue(table.getValueAt(selectedRow, 3));                                        
                        spnDienTich.setValue(table.getValueAt(selectedRow, 4));
                        String ghiChu_tam = "";
                        if(table.getValueAt(selectedRow, 5)!= null) {
                        	ghiChu_tam = table.getValueAt(selectedRow, 5).toString();
                        }                        	
                        txtGhiChu.setText(ghiChu_tam);
                        // Additional fields can be updated similarly
                    }
                }
            }
        });
	}
}
