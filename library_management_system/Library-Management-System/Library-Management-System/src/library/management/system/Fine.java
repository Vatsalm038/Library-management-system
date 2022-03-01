package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.sql.*;

public class Fine extends JFrame implements ActionListener{

	private JPanel contentPane;
    JDateChooser dateChooser;
    private JTextField search;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    private JTable table;
    private JButton b1,b2,b3,b4;
        public static void main(String[] args) {
            
            new Fine().setVisible(true);			
	}
 
        public Fine() {
            setBounds(300, 100, 400, 400);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(new Color(34,35,36));
	contentPane.setLayout(null);

    JLabel l1 = new JLabel("Student_id");
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setForeground(new Color(225,225,225));
	l1.setBounds(47, 66, 100, 23);
	contentPane.add(l1);

	JLabel l2 = new JLabel("Book_id");
	l2.setForeground(new Color(225,225,225));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(47, 97, 100, 23);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Date of Issue");
	l3.setForeground(new Color(225,225,225));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(47, 131, 100, 23);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Date Of return");
	l4.setForeground(new Color(225,225,225));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(47, 165, 100, 23);
	contentPane.add(l4);

	JLabel l5= new JLabel("*Fine Amt = 5rs/perday");
	l5.setForeground(new Color(255, 127, 80));
	l5.setFont(new Font("Tahoma", Font.BOLD, 13));
	l5.setBounds(20, 270, 200, 23);
	contentPane.add(l5);
	JLabel l6= new JLabel("after 15 days of issue book*");
	l6.setForeground(new Color(255, 127, 80));
	l6.setFont(new Font("Tahoma", Font.BOLD, 13));
	l6.setBounds(20, 300, 200, 23);
	contentPane.add(l6);

    
    t1 = new JTextField();
	t1.setForeground(new Color(0,0,0));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t1.setBounds(140, 66, 86, 20);
	contentPane.add(t1);
	
	b1 = new JButton("Search");
	b1.addActionListener(this);
	b1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b1.setBackground(new Color(152, 251,152));
        b1.setForeground(Color.BLACK);
	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b1.setBounds(234, 59, 100, 30);
        
	contentPane.add(b1);

    b2 = new JButton("Fine");
	b2.addActionListener(this);
	b2.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b2.setBackground(new Color(152, 251,152));
        b2.setForeground(Color.BLACK);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b2.setBounds(50, 200, 100, 30);
        
	contentPane.add(b2);
  
	b3 = new JButton("Back");
	b3.addActionListener(this);
	b3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b3.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	b3.setBounds(230, 250, 100, 33);
	b3.setBackground(new Color(255, 127, 80));
        b3.setForeground(Color.black);
        contentPane.add(b3);

    t2 = new JTextField();
	t2.setEditable(false);
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setBounds(160, 100, 100, 20);
	contentPane.add(t2);
	t2.setColumns(10);

	t3 = new JTextField();
	t3.setEditable(false);
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(160, 131, 100, 20);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setEditable(false);
	t4.setForeground(new Color(47, 79, 79));
	t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t4.setColumns(10);
	t4.setBounds(160, 168, 100, 20);
	contentPane.add(t4);

    t5= new JTextField();
	t5.setEditable(false);
	t5.setForeground(new Color(47, 79, 79));
	t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t5.setColumns(10);
	t5.setBounds(180, 210, 50, 20);
	contentPane.add(t5);

    JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(220,220,220), 2, true)));
	panel.setFont(new Font("Tahoma", Font.BOLD, 14));
	panel.setBounds(10, 38, 345, 288);
        panel.setBackground(new Color(34,35,36));
	contentPane.add(panel);
           
	}
        


public void actionPerformed(ActionEvent ae){
    try{
        conn con = new conn();
        if(ae.getSource() == b1){
            String sql = "select * from returnbook where student_id = ?";
    PreparedStatement st = con.c.prepareStatement(sql);
    st.setString(1, t1.getText());
    ResultSet rs = st.executeQuery();
    
            while (rs.next()) {
                t2.setText(rs.getString("book_id"));
                t3.setText(rs.getString("dateOfIssue"));
                t4.setText(rs.getString("dateOfReturn"));
    }
    st.close();
    rs.close();
   }

   if(ae.getSource() == b2){
    String sql = "select * from returnbook where student_id = ?";
    PreparedStatement st = con.c.prepareStatement(sql);
    st.setString(1, t1.getText());
    ResultSet rs = st.executeQuery();
    
            while (rs.next()) {

              String dateOfI = rs.getString("dateOfIssue");
			  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy",Locale.ENGLISH);
			  LocalDate date = LocalDate.parse(dateOfI, formatter);
             
              String dateOfR = rs.getString("dateOfReturn");
			  DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy",Locale.ENGLISH);
			  LocalDate date1 = LocalDate.parse(dateOfR, formatter1);
             Duration dif = Duration.between(date.atStartOfDay(), date1.atStartOfDay());
			 long difdays = dif.toDays();
			 long g;
			 if(difdays>15)
			 {
				 long l = difdays-15;
				 g=l*5;
				 String h = Long.toString(g);
			 t5.setText(h);
			 }
			 else
			 {
				t5.setText("0");
			 }
	

             




}
st.close();
rs.close();

}
if(ae.getSource() == b3){
	this.setVisible(false);
new Home().setVisible(true);

}
}catch(Exception e){
        
    }
}
}

