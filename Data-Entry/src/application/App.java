
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class App implements ActionListener {
	
	JFrame frame;
	JTextField t1,t2,t3,t4,t5;
    JPanel panel;
    JLabel label1,label2,label3,label4,label5,label6,label7,msg;
    JRadioButton male,Female;
    JComboBox day,month,year;
    JCheckBox terms;
    JButton submit;
    JTextArea screen;
    char operator;


    Font myfont = new Font("Standard",Font.BOLD,20);

	
	App(){

        frame = new JFrame("Entry Form");

        frame.setLayout(null);
        frame.setSize(700, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = frame.getContentPane();
        c.setLayout(null);

        label1 = new JLabel("Name");
        label1.setBounds(20, 50, 100, 20);
        c.add(label1);
        
        t1 = new JTextField();
        t1.setBounds(130, 100, 100, 20);
        c.add(t1);

        label2 = new JLabel("Registration Number");
        label2.setBounds(20, 100, 100, 20);
        c.add(label2);
        
        t2 = new JTextField();
        t2.setBounds(130, 50, 100, 20);
        c.add(t2);

        label3 = new JLabel("Gender");
        label3.setBounds(20,150,100,20);
        c.add(label3);

        male = new JRadioButton("Male");
        Female = new JRadioButton("Female");

        male.setBounds(130,150,80,20);
        Female.setBounds(220,150,80,20);
        male.setSelected(true);

        c.add(male);
        c.add(Female);

        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(Female);

        label4 = new JLabel("Date of Birth");
        label4.setBounds(20,200,100,20);
        c.add(label4);

        String days[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String months[] = {"JAN","FEB","MAR","APR","MAY","JUNE","JULY","AUG","SEP","OCT","NOV","DEC"};
        String years[] = {"2023","2022","2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997","1996","1995","1994","1993","1992","1990","1989"};


        day = new JComboBox(days);
        month = new JComboBox(months);
        year = new JComboBox(years);

        day.setBounds(130,200,40,20);
        month.setBounds(190,200,60,20);
        year.setBounds(270,200,60,20);

        c.add(day);
        c.add(month);
        c.add(year);

        label5 = new JLabel("Place of Birth");
        label5.setBounds(20,250,100,20);
        c.add(label5);

        t3 = new JTextField();
        t3.setBounds(130,240,200,30);
        c.add(t3);

        label6 = new JLabel("Age");
        label6.setBounds(20,300,100,20);
        c.add(label6);

        t4 = new JTextField();
        t4.setBounds(130,300,100,20);
        c.add(t4);

        label7 = new JLabel("Marks Obtained");
        label7.setBounds(20,350,100,20);
        c.add(label7);

        t5 = new JTextField();
        t5.setBounds(130,350,100,20);
        c.add(t5);

        submit = new JButton("Submit");
        submit.setBounds(150,400,80,20);
        c.add(submit);
        submit.addActionListener(this);
        submit.setFocusable(false);

        screen = new JTextArea();
        screen.setBounds(360,50,300,400);
        c.add(screen);
        screen.setEditable(false);
        screen.setFont(myfont);

        msg = new JLabel();
        msg.setBounds(20,450,250,30);
        c.add(msg);

        frame.setVisible(true);
    }
	public static void main(String[] args) {
		App form = new App();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

        msg.setText("Registration Successful");

        String name = t1.getText();
        String Reg_No = t2.getText();
        String gender = "male";
        if(Female.isSelected()){
            gender = "female";
        }
        String dob = day.getSelectedItem() + "-" + month.getSelectedItem() + "-" + year.getSelectedItem();
        String pob = t3.getText();
        String age = t4.getText();
        String marks = t5.getText();

        screen.setText(" Registration Number : " + name + "\n\n Name :" + Reg_No + "\n\n Gender : " + gender + "\n\n Date of Birth : " + dob + "\n\n Place of Birth : " + pob + "\n\n Age : " + age + "\n\n Marks Obtained : " + marks);

	}
}
