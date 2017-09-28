import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class StaffPage extends JFrame
{
	JPanel jp,jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9;
	JTabbedPane pn;
	int i=0;
	void panel(StaffPage obj)
	{
		i=0;
		Toolkit t=getToolkit();
		setSize(t.getScreenSize());
		getContentPane().setLayout(new BorderLayout());
		setTitle("Welcome Admin");
		pn=new JTabbedPane();
		pn.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		pn.setTabPlacement(JTabbedPane.LEFT);
		jp=new Panel_home();
		pn.addTab("HOME",new ImageIcon("home-icon.png"),jp );
		jp1=new Customer(obj);
		pn.addTab("CUSTOMERS",new ImageIcon("customerLarge.png"),jp1 );
		jp1.setLayout(null);
		jp4=new Invoice();
		pn.addTab("INVOICE DETAILS",new ImageIcon("invoice.jpg"),jp4 );
		jp3=new JPanel();
		pn.addTab("PURCHASING DETAIL",new ImageIcon("purchase.jpeg"),jp3 );
		jp3.setLayout(null);
		jp5=new AvailableStock(obj);
		pn.addTab("AVAILABLE STOCK",new ImageIcon("productLarge.png"),jp5);
		jp2=new JPanel();
		pn.addTab("CHART OF ACCCOUNT",new ImageIcon("chart.jpg"),jp2 );
		jp8=new JPanel();
		pn.addTab("INVOICE CUSTOMER",new ImageIcon("search-icon.png"),jp8 );
		jp7=new Purchase();
		pn.addTab("PURCHASING",new ImageIcon("purchase.jpeg"),jp7);
		jp9=new Supplier(obj);
		pn.addTab("SUPPLIER",new ImageIcon("supplierLarge.png"),jp9);
		jp6=new JPanel();
		pn.addTab("LOGOUT",new ImageIcon("logoutLarge.png"),jp6);
		pn.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				if(pn.getSelectedIndex()==9 && e.getButton()==MouseEvent.BUTTON1)
				{
					Exit1 obj=new Exit1();
					obj.setLocationRelativeTo(obj);
					obj.setVisible(true);
				}
			}
		});
		getContentPane().add(pn,BorderLayout.CENTER);
		
	}
	public static void main(String args[])
	{
		StaffPage tb=new StaffPage();
		tb.panel(tb);
		tb.setVisible(true);
		tb.setResizable(false);
		
	}
}