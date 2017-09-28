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

public class AvailableStock extends JPanel
{
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	JTextArea textArea;
	private JTextField textField_6;
	private JTable table_1;
	private JTextField textField_4;
	String a,b,c,e,f;
	
	public AvailableStock(StaffPage obj)
	{
		setLayout(null);
		
		JLabel lblDate = new JLabel("Product name");
		lblDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblDate.setBounds(124, 248, 167, 28);
		add(lblDate);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_1.setBounds(318, 248, 199, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddress = new JLabel("Detail");
		lblAddress.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblAddress.setBounds(124, 319, 184, 28);
		add(lblAddress);
		
		textArea = new JTextArea();
		textArea.setBounds(318,290,199,99);
		textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(318,290,199,99);
		add(scrollPane);
		
		JLabel lblPhoneNumber = new JLabel("Quantity");
		lblPhoneNumber.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(124, 449, 184, 28);
		add(lblPhoneNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField.setBounds(318, 449, 199, 28);
		textField.setText("0");
		textField.setEditable(false);
		add(textField);
		textField.setColumns(10);
		
		
		JLabel lblCustomerId = new JLabel("Product ID");
		lblCustomerId.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblCustomerId.setBounds(124, 149, 167, 28);
		add(lblCustomerId);
		
		textField_2 = new JTextField(Info2.math1());
		textField_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_2.setBounds(318, 149, 199, 28);
		textField_2.setEditable(false);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCity = new JLabel("Price");
		lblCity.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblCity.setBounds(124, 400, 68, 28);
		add(lblCity);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_3.setBounds(318, 403, 199, 28);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDateIn_1 = new JLabel("Date");
		lblDateIn_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblDateIn_1.setBounds(124, 199, 109, 28);
		add(lblDateIn_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnNewButton.setBounds(97, 505, 150, 35);
		btnNewButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String s1=textField_2.getText();
				String s2=textField_1.getText();
				String s3=textField_3.getText();
				String s4=textField.getText();
				String sa=textArea.getText();
				if(s1.length()==0 ||s2.length()==0 ||s4.length()==0 ||s3.length()==0 ||sa.length()==0)
				{
					 JOptionPane.showMessageDialog(AvailableStock.this, "Please fill/select all the fields", "Error", JOptionPane.ERROR_MESSAGE);		
				}
				else
				{

					String query="insert into stock values(?,?,?,?,?)";
					String query1="select * from stock where ProductId = ?";
					String query2="update stock set ProductName=?,Detail=?,Price=?,Quantity=? where ProductId=?";
					int flag=0,flag1=0;
					Connection con,con1,con2;
					try
					{
						 con=Info2.con();
						 con1=Info2.con();
						 con2=Info2.con();
						 PreparedStatement ps1=con1.prepareStatement(query1);
						 ps1.setString(1, textField_2.getText());
						 ResultSet res=ps1.executeQuery();
						 while(res.next())
							{
								flag1=1;
							}
						 if(flag1==1)
						 {
							 PreparedStatement ps2=con2.prepareStatement(query2);
							 ps2.setString(1, textField_1.getText());
							 ps2.setString(2, textArea.getText());
							 ps2.setString(3, textField_3.getText());
							 ps2.setString(4, textField.getText());
							 ps2.setString(5, textField_2.getText());
							 flag=ps2.executeUpdate();
						 }
						 else
						 {
						 PreparedStatement ps=con.prepareStatement(query);
						 ps.setString(1, textField_2.getText());
						 ps.setString(2, textField_1.getText());
						 ps.setString(3, textArea.getText());
						 ps.setString(4, textField_3.getText());
						 ps.setString(5, textField.getText());
						 flag=ps.executeUpdate();
						 }
					} 
					catch (Exception e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(flag==1)
					{
						JOptionPane.showMessageDialog(AvailableStock.this, "Product is added", "Added", JOptionPane.INFORMATION_MESSAGE);
						reset1();
					}
					else
					{
						JOptionPane.showMessageDialog(AvailableStock.this, "Product is not added", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
					
			}
		});
		add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnReset.setBounds(282, 505, 150, 35);
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
		textField_6.setBounds(318, 199, 199, 28);
		textField_6.setEditable(false);
		add(textField_6);
		textField_6.setColumns(10);
		
		Vector<String> header=new Vector<>();
		Vector<Vector<String>> outer=new Vector<>();
		String query="select * from stock"; 
		Connection con;
		try
		{
			con=Info2.con();
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=res.getMetaData();
			int colcount=rsmd.getColumnCount();
			for(int i=1;i<=colcount;i++)
			{
				String colName=rsmd.getColumnName(i);
			   header.add(colName);
			}
			
			//getting table records
			while(res.next())
			{
				Vector<String> records=new Vector<>();
				for(int i=1;i<=colcount;i++)
				{
					String v=res.getString(i);
					records.add(v);
				}
				outer.add(records);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		table_1 = new JTable(outer,header);
		table_1.setBounds(581, 101, 569, 248);
		table_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		table_1.setRowHeight(32);
		table_1.setEnabled(false);
		add(table_1);
		JScrollPane pane=new JScrollPane(table_1);
		pane.setBounds(581, 101, 569, 248);
		add(pane);
		
		JLabel lblNewLabel = new JLabel("Product ID ");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel.setBounds(124, 28, 149, 28);
		add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		textField_4.setBounds(318, 32, 199, 28);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		btnSearch.setBounds(253, 82, 122, 35);
		btnSearch.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String s1=textField_4.getText();
				int flag=0;
				if(s1.length()==0)
				{
					JOptionPane.showMessageDialog(AvailableStock.this, "Please fill the ID to be searched", "Error", JOptionPane.ERROR_MESSAGE);	
				}
				else
				{
					String query="select * from stock where ProductId = ?";
					Connection con;
					try
					{
						con=Info2.con();
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, s1);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							a=res.getString(1);
							b=res.getString(2);
							c=res.getString(3);
							e=res.getString(4);
							f=res.getString(5);
						}
						textField_2.setText(a);
						textField_1.setText(b);
						textArea.setText(c);
						textField_3.setText(e);
						textField.setText(f);
						
				}
					catch(Exception x)
					{
						x.printStackTrace();
					}
			}
			}
		});
		add(btnSearch);
		
		JButton btnNewButton_1 = new JButton("Display Data");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		btnNewButton_1.setBounds(780, 51, 210, 35);
		btnNewButton_1.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				obj.setVisible(false);
				StaffPage x=new StaffPage();
				x.panel(x);
				x.pn.setSelectedIndex(4);
				x.setVisible(true);
				x.setResizable(false);
			}
		});
		add(btnNewButton_1);
		
		JButton btnReset_1 = new JButton("Delete");
		btnReset_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnReset_1.setBounds(461, 505, 150, 35);
		btnReset_1.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String query="delete from stock where ProductID = ?";
				int flag=0;
				Connection con;
				try
				{
					con=Info2.con();
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, textField_2.getText());
					flag=ps.executeUpdate();
				}
				catch(Exception x)
				{
					x.printStackTrace();
				}
				if(flag==1)
				{
					JOptionPane.showMessageDialog(AvailableStock.this, "Product is deleted", "Added", JOptionPane.INFORMATION_MESSAGE);
					reset1();
				}
				else
				{
					JOptionPane.showMessageDialog(AvailableStock.this, "Product is not deleted", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		add(btnReset_1);
		
		}
	
	void reset1()
	{
		textField_2.setText(Info2.math1());
	      textField_1.setText(null);
	      textField.setText("0");
	      textField_3.setText(null);
	      textArea.setText(null);
	      textField_4.setText(null);
	}
}
