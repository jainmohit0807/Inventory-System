import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class Purchase extends JPanel
{
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	JComboBox comboBox,comboBox_1,comboBox_2;
	
	public Purchase()
	{
		setLayout(null);
		
		JLabel lblDate = new JLabel("Product name");
		lblDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblDate.setBounds(327, 180, 167, 28);
		add(lblDate);
		
		JLabel lblPhoneNumber = new JLabel("Quantity");
		lblPhoneNumber.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(327, 233, 184, 28);
		add(lblPhoneNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField.setBounds(523, 233, 199, 28);
		add(textField);
		textField.setColumns(10);
		
		
		JLabel lblCustomerId = new JLabel("Supplier name");
		lblCustomerId.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblCustomerId.setBounds(327, 132, 167, 28);
		add(lblCustomerId);
		
		JLabel lblCity = new JLabel("Total");
		lblCity.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblCity.setBounds(327, 428, 68, 28);
		add(lblCity);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_3.setBounds(523, 428, 199, 28);
		textField_3.setEditable(false);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDateIn_1 = new JLabel("Date");
		lblDateIn_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblDateIn_1.setBounds(327, 86, 109, 28);
		add(lblDateIn_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnNewButton.setBounds(362, 584, 150, 35);
		btnNewButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String s1=textField_2.getText();
				String s2=textField_4.getText();
				String s3=textField_3.getText();
				String sc1=(String) comboBox.getSelectedItem();
				String sc2=(String) comboBox_1.getSelectedItem();
				String sc3=(String) comboBox_2.getSelectedItem();
				if(s1.length()==0 ||s2.length()==0||sc3.equalsIgnoreCase("Select")||s3.length()==0)
				{
					 JOptionPane.showMessageDialog(Purchase.this, "Please fill/select all the fields", "Error", JOptionPane.ERROR_MESSAGE);		
				}
				else
				{

					String query="insert into purchase values(?,?,?,?,?,?,?,?,?)";
					String query1="update stock set Quantity=? where ProductName=?";
					Connection con,con1;
					int flag=0,flag1=0;
					try
					{
						 con=Info2.con();
						 con1=Info2.con();
						 PreparedStatement ps=con.prepareStatement(query);
						 PreparedStatement ps1=con1.prepareStatement(query1);
						 ps1.setString(1,textField.getText());
						 ps1.setString(2,sc2);
						 ps.setString(1, textField_5.getText());
						 ps.setString(2, textField_6.getText());
						 ps.setString(3, sc1);
						 ps.setString(4, sc2);
						 ps.setString(5, textField.getText());
						 ps.setString(6, textField_1.getText());
						 ps.setString(7, sc3);
						 ps.setString(8, textField_3.getText());
						 ps.setString(9, textField_4.getText());
						 
						 flag=ps.executeUpdate();
						 flag1=ps1.executeUpdate();
						 if(flag==1)
						 {
							 JOptionPane.showMessageDialog(Purchase.this, "Product is added", "Added", JOptionPane.INFORMATION_MESSAGE);
								reset1();
						 }
						 else
						 {
							 JOptionPane.showMessageDialog(Purchase.this, "Product is not added", "Error", JOptionPane.ERROR_MESSAGE);
						 }
					} 
					catch (Exception e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
			}
		});
		add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnReset.setBounds(574, 584, 150, 35);
		btnReset.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				reset1();
			}
		});
		add(btnReset);
		
		Date d=new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
		textField_6 = new JTextField(ft.format(d));
		textField_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_6.setBounds(523, 86, 199, 28);
		textField_6.setEditable(false);
		add(textField_6);
		textField_6.setColumns(10);
		
		Vector<String> d1=new Vector<>();
		d1.add("Select");
		String query="select SupplierName from supplier"; 
		Connection con;
		try
		{
			con=Info2.con();
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				d1.add(res.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		comboBox = new JComboBox(d1);
		comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		comboBox.setBounds(523, 132, 199, 28);
		add(comboBox);
		
		Vector<String> d2=new Vector<>();
		d2.add("Select");
		String query1="select ProductName from stock"; 
		Connection con1;
		try
		{
			con1=Info2.con();
			PreparedStatement ps1=con1.prepareStatement(query1);
			ResultSet res1=ps1.executeQuery();
			while(res1.next())
			{
				d2.add(res1.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		comboBox_1 = new JComboBox(d2);
		comboBox_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		comboBox_1.setBounds(523, 180, 199, 28);
		add(comboBox_1);
		
		JLabel lblPaymentMode = new JLabel("Unit Price");
		lblPaymentMode.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblPaymentMode.setBounds(327, 333, 167, 28);
		add(lblPaymentMode);
		
		JButton btnGetPrice = new JButton("Get Price");
		btnGetPrice.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		btnGetPrice.setBounds(425, 281, 210, 35);
		btnGetPrice.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String sc=(String) comboBox.getSelectedItem();
				String sc1=(String) comboBox_1.getSelectedItem();
				String h=textField.getText();
				if(sc.equalsIgnoreCase("Select")||sc1.equalsIgnoreCase("Select")||h.length()==0)
				{
					JOptionPane.showMessageDialog(Purchase.this, "Please fill/select all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					int a=Integer.parseInt(h);
					String q="select Price from stock where ProductName=?";
					Connection con2;
					try
					{
						con2=Info2.con();
						PreparedStatement ps1=con2.prepareStatement(q);
						ps1.setString(1, sc1);
						ResultSet res1=ps1.executeQuery();
						while(res1.next())
						{
							textField_1.setText(res1.getString(1));
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					int b=Integer.parseInt(textField_1.getText());
					String c=Integer.toString(a*b);
					textField_3.setText(c);
				}
			}
		});
		add(btnGetPrice);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_1.setColumns(10);
		textField_1.setBounds(523, 333, 199, 28);
		textField_1.setEditable(false);
		add(textField_1);
		
		JLabel lblPaymentMode_1 = new JLabel("Payment Mode");
		lblPaymentMode_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblPaymentMode_1.setBounds(327, 382, 184, 28);
		add(lblPaymentMode_1);
		
		String[] d3=new String[6];
		d3[0]="Select";
		d3[1]="Cash";
		d3[2]="DebitCard";
		d3[3]="Paytm";
		d3[4]="CreditCard";
		d3[5]="Netbanking";
		
		comboBox_2 = new JComboBox(d3);
		comboBox_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		comboBox_2.setBounds(523, 382, 199, 28);
		add(comboBox_2);
		
		JLabel lblPay = new JLabel("Pay");
		lblPay.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblPay.setBounds(327, 473, 68, 28);
		add(lblPay);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_2.setColumns(10);
		textField_2.setBounds(523, 473, 199, 28);
		add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_4.setColumns(10);
		textField_4.setBounds(523, 524, 199, 28);
		add(textField_4);
		
		JLabel lblRemaining = new JLabel("Remaining");
		lblRemaining.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblRemaining.setBounds(327, 524, 109, 28);
		add(lblRemaining);
		
		JLabel lblPurchaseId = new JLabel("Purchase ID");
		lblPurchaseId.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblPurchaseId.setBounds(327, 34, 150, 28);
		add(lblPurchaseId);
		
		textField_5 = new JTextField(Info2.math1());
		textField_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_5.setColumns(10);
		textField_5.setBounds(523, 34, 199, 28);
		textField_5.setEditable(false);
		add(textField_5);
		
		}
	
	void reset1()
	{
		  comboBox.setSelectedIndex(0);
		  comboBox_1.setSelectedIndex(0);
		  comboBox_2.setSelectedIndex(0);
		  textField_5.setText(Info2.math1());
	      textField_1.setText(null);
	      textField.setText(null);
	      textField_2.setText(null);
	      textField_3.setText(null);
	      textField_4.setText(null);
	}
}
