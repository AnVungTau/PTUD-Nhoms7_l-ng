package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import dao.ToNhom_DAO;
import entity.ToNhom;
import util.QuanLyMaToNhom;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JTextField;

public class ToNhom_Panel extends JPanel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JTable tblTo;
	private DefaultTableModel model;
	private JTextField txtMa;
	private JTextField txtTenNhom;
	private ToNhom_DAO to_dao = new ToNhom_DAO();
	private JButton btnLuu;
	private JButton btnLamMoi;
	private JButton btnThem;
	private URL urlThem = ToNhom_Panel.class.getResource("/img/Custom-Icon-Design-Flatastic-1-Add-1.24.png");
	private URL urlLamMoi = ToNhom_Panel.class.getResource("/img/Hopstarter-Button-Button-Reload.24.png");
	private URL urlLuu = ToNhom_Panel.class.getResource("/img/Oxygen-Icons.org-Oxygen-Actions-document-save.24.png");

	public ToNhom_Panel() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(255, 255, 255));
		add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN TỔ/NHÓM");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pnlNorth.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel pnlChucNang = new JPanel();
		pnlNorth.add(pnlChucNang, BorderLayout.SOUTH);
		
		btnThem = new JButton("Thêm");
		btnThem.setEnabled(false);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBackground(new Color(255, 255, 255));
		btnThem.setIcon(new ImageIcon(urlThem));
		pnlChucNang.add(btnThem);
		
		btnLuu = new JButton("Cập nhật");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBackground(new Color(255, 255, 255));
		btnLuu.setIcon(new ImageIcon(urlLuu));
		pnlChucNang.add(btnLuu);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setBackground(new Color(255, 255, 255));
		btnLamMoi.setIcon(new ImageIcon(urlLamMoi));
		pnlChucNang.add(btnLamMoi);
		
		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setBackground(new Color(255, 255, 255));
		pnlThongTin.setPreferredSize(new Dimension(10, 100));
		pnlNorth.add(pnlThongTin, BorderLayout.CENTER);
		pnlThongTin.setLayout(null);
		
		JLabel lblMa = new JLabel("Mã");
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMa.setBounds(528, 21, 115, 25);
		pnlThongTin.add(lblMa);
		
		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtMa.setEnabled(false);
		txtMa.setDisabledTextColor(Color.BLACK);
		txtMa.setColumns(10);
		txtMa.setBounds(643, 21, 150, 25);
		pnlThongTin.add(txtMa);
		
		JLabel lblToNhom = new JLabel("Tên nhóm");
		lblToNhom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblToNhom.setBounds(528, 56, 115, 25);
		pnlThongTin.add(lblToNhom);
		
		txtTenNhom = new JTextField();
		txtTenNhom.setDisabledTextColor(Color.BLACK);
		txtTenNhom.setColumns(10);
		txtTenNhom.setBounds(643, 56, 150, 25);
		pnlThongTin.add(txtTenNhom);
		
		JPanel pnlDanhSachTo = new JPanel();
		pnlDanhSachTo.setBackground(new Color(240, 240, 240));
		add(pnlDanhSachTo, BorderLayout.CENTER);
		pnlDanhSachTo.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlDanhSachTo.add(scrollPane);
		
		String header[] = {"Mã", "Tên tổ", "Số lượng công nhân"};
		model = new DefaultTableModel(header, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		
		txtTenNhom.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				btnThem.setEnabled(valiDataTen());
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				btnThem.setEnabled(valiDataTen());
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tblTo = new JTable(model);
		tblTo.setFillsViewportHeight(true);
		tblTo.setSelectionForeground(new Color(255, 255, 255));
		tblTo.setSelectionBackground(new Color(0, 128, 255));
		tblTo.setRowHeight(20);
		scrollPane.setViewportView(tblTo);

		TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
		tblTo.setRowSorter(sorter);
		
		LoadDanhSachTo(to_dao.getAllTo());
		
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnLamMoi.addActionListener(this);
		
		tblTo.addMouseListener(this);
		
	}
	
	private void clearTable() {
		int r = tblTo.getRowCount();
		while(r > 0) {
			model.removeRow(r-1);
			r--;
		}
	}
	
	private void LoadDanhSachTo(ArrayList<ToNhom> ds) {
		clearTable();
		for (ToNhom t : ds) {
			model.addRow(new Object[] { t.getMaTo(), t.getTenTo(), t.demSoLuongCongNhan()});
		}
	}
	
	private boolean valiDataTen() {
		String ten = txtTenNhom.getText().trim();
		if (ten.isEmpty()) {
			return false;
		}
		return true;
	}
	
	private ToNhom revertToFromFields() {
		ToNhom t = null;
		try {
			int maTo = Integer.parseInt(txtMa.getText().trim());
			String ten = txtTenNhom.getText().trim();
			
			t = new ToNhom(maTo, ten);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	private void fillForm() {
		int r = tblTo.getSelectedRow();
		if (r < 0) {
			return;
		}
		String maTo = tblTo.getValueAt(r, 0).toString();
		String tenTo = tblTo.getValueAt(r, 1).toString();
		
		txtMa.setText(maTo);
		txtTenNhom.setText(tenTo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			QuanLyMaToNhom radomMaToNhom = new QuanLyMaToNhom();
			txtMa.setText(radomMaToNhom.generateMaToNhom() + "");
			ToNhom t = revertToFromFields();
			if(to_dao.them(t)) {
				LoadDanhSachTo(to_dao.getAllTo());
				JOptionPane.showMessageDialog(this, "Thêm thành công");
			}else {
				JOptionPane.showMessageDialog(this, "Trùng mã");
			}
		}
		
		if(o.equals(btnLamMoi)) {
			LoadDanhSachTo(to_dao.getAllTo());
			txtMa.setText("");
			txtTenNhom.setText("");
			tblTo.clearSelection();
		}
		
		if(o.equals(btnLuu)) {
			int r = tblTo.getSelectedRow();
			if(r < 0) {
				JOptionPane.showMessageDialog(this, "Chọn dòng muốn sửa");
				return;
			}
			if(JOptionPane.showConfirmDialog(this, "Bạn muốn lưu thay đổi", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				ToNhom t = revertToFromFields();
				if(to_dao.sua(t)) {
					LoadDanhSachTo(to_dao.getAllTo());
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				}else {
					JOptionPane.showMessageDialog(this, "Xảy ra lỗi");
				}
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		fillForm();
		btnThem.setEnabled(false);
		
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

}
