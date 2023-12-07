package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.KeyStroke;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.util.Rotation;


import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

public class ThongKe_Panel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSpinner spn_Thang_His;
	private JSpinner spn_Year_His;
	private SpinnerNumberModel spinnerModel_Thang_His = new SpinnerNumberModel(12, 1, 12, 1);
	private SpinnerNumberModel spinnerModel_Nam_His = new SpinnerNumberModel(2023, 2020, 2030, 1);
	private SpinnerNumberModel spinnerModel_TuThang_Plot = new SpinnerNumberModel(12, 1, 12, 1);
	private SpinnerNumberModel spinnerModel_TuNam_Plot = new SpinnerNumberModel(2023, 2020, 2030, 1);
	private SpinnerNumberModel spinnerModel_DenThang_Plot = new SpinnerNumberModel(1, 1, 12, 1);
	private SpinnerNumberModel spinnerModel_DenNam_Plot = new SpinnerNumberModel(2024, 2020, 2030, 1);
	private JButton btn_Plot;
	private JButton btn_Xem_Plot;
	private JSpinner spn_DenYear_Plot;
	private JSpinner spn_DenThang_Plot;
	private JSpinner spn_TuYear_Plot;
	private JSpinner spn_TuThang_Plot;
	private JButton btn_Xem_His;
	private JButton btn_His;
	private JPanel pnl_His;
	private JComponent pnl_Plot;
	private ChartPanel layBieuDo_His = new ChartPanel(null);
	private ChartPanel layBieuDo_Tron= new ChartPanel(null);
	private ChartPanel layBieuDo_Plot= new ChartPanel(null);
	private JFreeChart chart_Tron;
	private JFreeChart chart_Plot;
	private JFreeChart chart_His;
	
	
	public ThongKe_Panel() throws SQLException {
		setLayout(null);
		
		JLabel lbl_TieuDe = new JLabel("THỐNG KÊ NHÂN VIÊN");
		lbl_TieuDe.setBounds(10, 10, 1241, 25);
		lbl_TieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TieuDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lbl_TieuDe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 49, 1300, 533);
		add(scrollPane);
		
		JPanel pnl_Lon = new JPanel();
		scrollPane.setViewportView(pnl_Lon);
		pnl_Lon.setPreferredSize(new Dimension(1222, 700)); 
		pnl_Lon.setLayout(null);
		
		pnl_His = new JPanel();
//		pnl_His.setBorder(new RoundBorder());
		pnl_His.setBackground(Color.WHITE);
		pnl_His.setBounds(10, 11, 495, 441);
		pnl_His.setLayout(null);
		pnl_Lon.add(pnl_His);
		
		pnl_Plot = new JPanel();
//		pnl_Plot.setBorder(new RoundBorder());
		pnl_Plot.setBackground(Color.WHITE);
		pnl_Plot.setBounds(515, 11, 756, 441);
		pnl_Plot.setLayout(null);
		pnl_Lon.add(pnl_Plot);
        
        btn_His = new JButton("");
        btn_His.setBorderPainted(false);
        btn_His.setBackground(Color.WHITE);
        btn_His.setIcon(new ImageIcon("image\\download.png"));
        btn_His.setBounds(548, 60, 33, 27);
        pnl_His.add(btn_His);
        
        btn_Plot = new JButton("");
        btn_Plot.setBounds(1150, 60, 33, 27);
        pnl_Plot.add(btn_Plot);
        btn_Plot.setBorderPainted(false);
        btn_Plot.setIcon(new ImageIcon("image\\download.png"));
        btn_Plot.setBackground(Color.WHITE);
	
		
		
		
        JPanel pnl_Chon_His = new JPanel();
        pnl_Chon_His.setBounds(10, 10, 440, 65);
        pnl_His.add(pnl_Chon_His);
        pnl_Chon_His.setBackground(Color.WHITE);
        pnl_Chon_His.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Bi\u1EC3u \u0110\u1ED3 Histogram Ti\u1EC1n L\u01B0\u01A1ng Tr\u1EA3 Cho T\u1EEBng Nh\u00E2n Vi\u00EAn Trong Th\u00E1ng ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        pnl_Chon_His.setLayout(null);
        
        JLabel lbl_Thang_His = new JLabel("Tháng");
        lbl_Thang_His.setBounds(56, 23, 46, 32);
        pnl_Chon_His.add(lbl_Thang_His);
        lbl_Thang_His.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_Thang_His.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spn_Thang_His = new JSpinner(spinnerModel_Thang_His);
        spn_Thang_His.setBounds(104, 23, 46, 32);
        spn_Thang_His.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spn_Thang_His.setBackground(Color.WHITE);
        pnl_Chon_His.add(spn_Thang_His);
        
        JLabel lbl_Nam_His = new JLabel("Năm");
        lbl_Nam_His.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_Nam_His.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_Nam_His.setBounds(176, 23, 36, 32);
        pnl_Chon_His.add(lbl_Nam_His);
        spn_Year_His = new JSpinner(spinnerModel_Nam_His);
        spn_Year_His.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spn_Year_His.setBackground(Color.WHITE);
        spn_Year_His.setBounds(213, 23, 64, 32);
        pnl_Chon_His.add(spn_Year_His);
        
        btn_Xem_His = new JButton("Xem");
        btn_Xem_His.setToolTipText("Xem biểu đồ");
        btn_Xem_His.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btn_Xem_His.setBounds(354, 23, 71, 29);
        pnl_Chon_His.add(btn_Xem_His);
        
        JPanel pnl_Chon_Plot = new JPanel();
        pnl_Chon_Plot.setLayout(null);
        pnl_Chon_Plot.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Bi\u1EC3u \u0110\u1ED3 Bar T\u1ED5ng Ti\u1EC1n L\u01B0\u01A1ng Tr\u1EA3 Cho Nh\u00E2n Vi\u00EAn T\u1EEB Th\u00E1ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        pnl_Chon_Plot.setBackground(Color.WHITE);
        pnl_Chon_Plot.setBounds(10, 10, 607, 65);
        pnl_Plot.add(pnl_Chon_Plot);
        
        JLabel lbl_TuThang_Plot = new JLabel("Từ tháng");
        lbl_TuThang_Plot.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_TuThang_Plot.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_TuThang_Plot.setBounds(24, 21, 64, 32);
        pnl_Chon_Plot.add(lbl_TuThang_Plot);
        
        spn_TuThang_Plot = new JSpinner((SpinnerModel) spinnerModel_TuThang_Plot);
        spn_TuThang_Plot.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spn_TuThang_Plot.setBackground(Color.WHITE);
        spn_TuThang_Plot.setBounds(95, 22, 47, 32);
        pnl_Chon_Plot.add(spn_TuThang_Plot);
        
        spn_TuYear_Plot = new JSpinner((SpinnerModel) spinnerModel_TuNam_Plot);
        spn_TuYear_Plot.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spn_TuYear_Plot.setBackground(Color.WHITE);
        spn_TuYear_Plot.setBounds(143, 22, 64, 32);
        pnl_Chon_Plot.add(spn_TuYear_Plot);
        
        JLabel lbl_DenThang_Plot = new JLabel("Đến tháng");
        lbl_DenThang_Plot.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_DenThang_Plot.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_DenThang_Plot.setBounds(282, 20, 72, 32);
        pnl_Chon_Plot.add(lbl_DenThang_Plot);
        
        spn_DenThang_Plot = new JSpinner((SpinnerModel) spinnerModel_DenThang_Plot);
        spn_DenThang_Plot.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spn_DenThang_Plot.setBackground(Color.WHITE);
        spn_DenThang_Plot.setBounds(361, 21, 35, 32);
        pnl_Chon_Plot.add(spn_DenThang_Plot);
        
        spn_DenYear_Plot = new JSpinner((SpinnerModel) spinnerModel_DenNam_Plot);
        spn_DenYear_Plot.setFont(new Font("Tahoma", Font.PLAIN, 14));
        spn_DenYear_Plot.setBackground(Color.WHITE);
        spn_DenYear_Plot.setBounds(398, 21, 64, 32);
        pnl_Chon_Plot.add(spn_DenYear_Plot);
        
        btn_Xem_Plot = new JButton("Xem");
        btn_Xem_Plot.setToolTipText("Xem biểu đồ");
        btn_Xem_Plot.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btn_Xem_Plot.setBounds(525, 21, 72, 29);
        pnl_Chon_Plot.add(btn_Xem_Plot);
        
        macDinh_His();
        macDinh_Plot();
		
        btn_Xem_Plot.addActionListener(this);
        btn_Xem_Plot.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control shift pressed F3"), "buttonAction");
        btn_Xem_Plot.getActionMap().put("buttonAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	btn_Xem_Plot.doClick();
            }
        });
        btn_Xem_His.addActionListener(this);
        btn_Xem_His.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control shift pressed F2"), "buttonAction");
        btn_Xem_His.getActionMap().put("buttonAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	btn_Xem_His.doClick();
            }
        });
        btn_His.addActionListener(this);
        btn_Plot.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		 }
	
	
	
	private ChartPanel layBieuDo_His(HistogramDataset dataset, String title){
		chart_His = ChartFactory.createHistogram(
                title, 
                "Tiền lương", 
                "Tần số", 
                dataset, 
                PlotOrientation.VERTICAL, 
                true, 
                true, 
                false 
        );
        
        ChartPanel cpnl_His = new ChartPanel(chart_His);
        cpnl_His.setBounds(43, 97, 374, 274);
        cpnl_His.setPreferredSize(new Dimension(600, 400));
		return cpnl_His;
	}
	
	private ChartPanel layBieuDo_Plot(DefaultCategoryDataset dataset, String title){
		chart_Plot = ChartFactory.createBarChart(
                title, 
                "Tháng", 
                "Tổng lương", 
                dataset, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false 
        );

		chart_Plot.getCategoryPlot().getRenderer().setSeriesPaint(0, new Color(0, 128, 0));

        ChartPanel chartPanel = new ChartPanel(chart_Plot);
        chartPanel.setBounds(56, 95, 621, 277);
        chartPanel.setPreferredSize(new Dimension(600, 400));
		return chartPanel;
	}
	
	
	
	private void macDinh_His() {
		String ngayTinhLuong = Integer.parseInt(spn_Thang_His.getValue().toString())+"-"+Integer.parseInt(spn_Year_His.getValue().toString());
		String title ="Biểu đồ Histogram tiền lương trả cho nhân viên tháng "+ngayTinhLuong;
		List<Double> list=null;
		
		
		double[] arr = list.stream().mapToDouble(Double::doubleValue).toArray();
        
		HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Dữ liệu", arr, 5);
        
        layBieuDo_His = layBieuDo_His(dataset,title);
        pnl_His.add(layBieuDo_His);
        updateUI();
	}
	
	private void macDinh_Plot() {
		spn_TuThang_Plot.setValue(1);
		spn_TuYear_Plot.setValue(2023);
		spn_DenThang_Plot.setValue(7);
		spn_DenYear_Plot.setValue(2023);
		DefaultCategoryDataset datase = new DefaultCategoryDataset();
		Map<String, Long> map = null;
		String title ="Biểu đồ Bar thể hiện tổng tiền lương đã trả cho nhân viên Từ 1-2023 đến 7-2023";
		
		
		map.entrySet().forEach(i->{
			datase.addValue(i.getValue(), "Lương", i.getKey());
		});
		
		layBieuDo_Plot =layBieuDo_Plot(datase, title);
        pnl_Plot.add(layBieuDo_Plot);
        updateUI();
	}
	
	private void xuatFile(JFreeChart chart) {
		JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) { 
            File selectedFile = fileChooser.getSelectedFile(); 
            String absolutePath = selectedFile.getAbsolutePath();
            String tr = absolutePath.substring(absolutePath.length() - 4);
            
            if(!tr.equals(".png")) {
            	File newFile = new File(absolutePath+".png");
            	 selectedFile = newFile;
            }
           
            try {
				ChartUtilities.saveChartAsPNG(selectedFile, chart, 1280, 720);
				JOptionPane.showMessageDialog(this, "File đã được lưu tại '"+selectedFile.getAbsolutePath()+"'", "Phần Mềm Tính Lương", 1);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, e, "Phần Mềm Tính Lương", 2);
				e.printStackTrace();
			}
        } else 
        	JOptionPane.showMessageDialog(this, "Lưu thất bại", "Phần Mềm Tính Lương", 2);
    }
}
