import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;

class Gui extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// frames hold all your components (objects or fields)
    JPanel mypanel;
    JButton F, L, R, B, S, Run, Recall;
    JLabel lable_v1,lable_v2;
    JTextField mytext;
    

    public Gui() {
        // constructor creates panel and GUI components and adds them to the frame and
        // panel

        mypanel = new JPanel();
        F = new JButton("F");
        L = new JButton("L");
        R = new JButton("R");
        B = new JButton("B");
        S = new JButton("S");
        Run = new JButton("Run");
        Recall = new JButton("Recall");
        lable_v1 = new JLabel("Choose the direction");
        lable_v2 = new JLabel("sex");
        mytext = new JTextField(20);
        mytext.setEditable(false); 
        lable_v2.setVisible(false);

        add(mypanel);
        mypanel.add(F);
        mypanel.add(L);
        mypanel.add(R);
        mypanel.add(B);
        mypanel.add(S);
        mypanel.add(lable_v1);
        mypanel.add(lable_v2);
        mypanel.add(mytext);
        mypanel.add(Run);
        mypanel.add(Recall);
        F.addActionListener(this);
        L.addActionListener(this);
        R.addActionListener(this);
        B.addActionListener(this);
        S.addActionListener(this);
        Run.addActionListener(this);
        Recall.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == F) {
            
            lable_v1.setText("Input duration and speed separated by a space");
        	lable_v2.setVisible(true);
        	lable_v2.setText("Duration (max 6) and Speeds (0 to 100) ");
            mytext.setEditable(true);
        }
        else if(e.getSource()== L){
        	lable_v1.setText("Input duration and 2 different speeds separated by a space");
        	lable_v2.setVisible(true);
        	lable_v2.setText("Duration (max 6) and Speeds (-100 to 100) ");
            mytext.setEditable(true);
        }
        else if(e.getSource()== R){
        	lable_v1.setText("Input duration and 2 different speeds separated by a space");
        	lable_v2.setVisible(true);
        	lable_v2.setText("Duration (max 6) and Speeds (-100 to 100) ");
            mytext.setEditable(true);
        }
        else if(e.getSource()== B){
        	lable_v1.setText("Input duration and speed separated by a space");
        	lable_v2.setVisible(true);
        	lable_v2.setText("Duration (max 6) and Speeds (0 to 100) ");
            mytext.setEditable(true);
        }
       
        else if(e.getSource()== Run){
        	String user_input = mytext.getText();
        	Inputconverter Conv = new Inputconverter();
        	Conv.setinput(user_input);
        	lable_v1.setText("Choose the direction");
        	lable_v2.setVisible(false);
        	mytext.setText("");
        	mytext.setEditable(false);        	
        }
        else if(e.getSource()== S){
        	
        }
        else if(e.getSource()== Recall){
        	
        }

    }

    public void doit() {
        JFrame myFrame = new Gui();
        myFrame.setTitle("Finch Controller");
        myFrame.setSize(360, 200);
        myFrame.setLocation(10, 220);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}