package jsu.cn.user;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

class cs{
	private static JFrame j;
	private JLabel jj;
	public cs(){
		j=new JFrame("cs");
		jj=new JLabel("ggggggggggggg");
		j.add(jj);
		j.setBounds(200, 200, 200, 200);
		j.setVisible(true);
	}
	public void show1() {
		j.setVisible(false);
	}
	public void show2() {
		j.setVisible(true);
	}
//	JFrame j=new JFrame("cs");
//	JFrame j1=new JFrame("cs1");
//	JLabel jj=new JLabel("ggggggggggggg");
//	JLabel jj1=new JLabel("ddddddddddd");
//	j.add(jj1);
//	j1.add(jj);
//	j.setBounds(200, 200, 200, 200);
//	j1.setBounds(200, 200, 200, 200);
//	j.setVisible(true);
}
class ggg implements ActionListener{
     JFrame jf;
     JLabel jl;
     public int i;
     public ggg() {
    	 jf= new JFrame("ddd");
    	 jl = new JLabel("ÄãºÃ");
    	 jf.setLayout(null);
    	 jf.setBounds(200, 200, 400, 4000);
    	 jl.setBounds(200, 200, 50, 50);
    	 //JButton jb=new JButton();
    	
    	 jf.add(jl);
    	 jf.setVisible(true);
    	 Timer t= new Timer(1000,this);
    	 t.start();
     }
	@Override
	public void actionPerformed(ActionEvent e) {
		i++;
		jl.setText(String.valueOf(i));
		System.out.println(3);
		System.out.println(4);
	}
}
public class csDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s[]=null;
           s=show();
   System.out.println(s.length);
    	
	}
       public static String [] show() {
    	String s[] =new String[1];
    	s[0]="ddd";
    	return s;
    }
}
