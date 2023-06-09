package Account_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registration_data {

	private JFrame frame;
	private JTextField tb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration_data window = new Registration_data();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration_data() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 638, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(254, 11, 131, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(45, 116, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Branch");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(45, 228, 65, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(45, 172, 65, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Progamming Language");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(45, 274, 169, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JRadioButton r1 = new JRadioButton("Male");
		r1.setForeground(Color.BLACK);
		r1.setBackground(Color.WHITE);
		r1.setFont(new Font("Tahoma", Font.BOLD, 15));
		r1.setBounds(235, 168, 86, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Female");
		r2.setFont(new Font("Tahoma", Font.BOLD, 15));
		r2.setBounds(328, 168, 86, 23);
		frame.getContentPane().add(r2);
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JComboBox co = new JComboBox();
		co.setModel(new DefaultComboBoxModel(new String[] {"Select", "CSE", "IT", "ECE", "AIML", "DS", "IOT"}));
		co.setBounds(232, 226, 86, 22);
		frame.getContentPane().add(co);
		
		JCheckBox cb1 = new JCheckBox("Java");
		cb1.setBounds(232, 272, 97, 23);
		frame.getContentPane().add(cb1);
		
		JCheckBox cb2 = new JCheckBox("Python\r\n");
		cb2.setBounds(340, 272, 97, 23);
		frame.getContentPane().add(cb2);
		
		JCheckBox cb3 = new JCheckBox("C");
		cb3.setBounds(449, 272, 97, 23);
		frame.getContentPane().add(cb3);
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=tb.getText();
				String g;
				if(r1.isSelected()) {
					g="male";
				}
				else if(r2.isSelected())
				{
					g="female";
				}
				else
				{
				g="invalid";
			}
				String b=(String) co.getSelectedItem();
				String pl="";
				if(cb1.isSelected())
				{
					pl=pl+"Java,";
				}
				if(cb2.isSelected())
				{
					pl=pl+"Python,";
				}
			if(cb3.isSelected())
			{
					pl=pl+"C";
				}
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sagar","root","mrec");
					String q="insert into registration values('"+n+"','"+g+"','"+b+"','"+pl+"')";
					Statement sta=con.createStatement();
					sta.execute(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton,"Done");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(277, 347, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		tb = new JTextField();
		tb.setBounds(232, 115, 86, 20);
		frame.getContentPane().add(tb);
		tb.setColumns(10);
		
	
	}
}
