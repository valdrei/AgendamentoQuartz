package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

import Control.QuartzApp;
import Model.ScheduleSetup;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Screen extends JFrame {

	JList list;
	
	
	private JPanel contentPane;
	private JTextField fCache;
	private JTextField fClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Screen() {
		setTitle("Cache");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList();
		list.setBorder(new TitledBorder(null, "Logs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list.setBounds(10, 34, 651, 377);
		contentPane.add(list);
		
		JLabel lblCache = new JLabel("Cache:");
		lblCache.setBounds(10, 9, 34, 14);
		contentPane.add(lblCache);
		
		fCache = new JTextField();
		fCache.setBounds(48, 6, 42, 20);
		contentPane.add(fCache);
		fCache.setColumns(10);
		
		JLabel lblClearCache = new JLabel("Clear Cache:");
		lblClearCache.setBounds(144, 9, 70, 14);
		contentPane.add(lblClearCache);
		
		fClear = new JTextField();
		fClear.setBounds(212, 6, 42, 20);
		contentPane.add(fClear);
		fClear.setColumns(10);
		
		JButton btnAtualizar = new JButton("Iniciar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				execute();
			}
		});
		btnAtualizar.setBounds(572, 5, 89, 23);
		contentPane.add(btnAtualizar);
		
		JLabel label = new JLabel("''");
		label.setBounds(100, 9, 13, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("''");
		label_1.setBounds(264, 9, 13, 14);
		contentPane.add(label_1);
	}
	
	public void addLog(String log){		
		DefaultListModel model=(DefaultListModel) list.getModel();
		model.addElement(log);
		list.setModel(model);			
	}
	
	private void execute(){
		new QuartzApp().setSchedule(this.getValues());
	}
	
	public ScheduleSetup getValues(){
		return new ScheduleSetup(Integer.parseInt(fCache.getText()), Integer.parseInt(fClear.getText()));
	}
}
