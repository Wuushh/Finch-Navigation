import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

class Gui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JPanel Panel;
	JButton F, L, R, B, S, Run, Rewind;
	JLabel Lable_1, Lable_2;
	JTextField Textbox;
	String direction = "";

	public Gui() {

		Panel = new JPanel();
		F = new JButton("F");
		L = new JButton("L");
		R = new JButton("R");
		B = new JButton("B");
		S = new JButton("S");
		Run = new JButton("Run");
		Rewind = new JButton("Rewind");
		Lable_1 = new JLabel("Choose the direction");
		Lable_2 = new JLabel();
		Lable_2.setVisible(false);
		Textbox = new JTextField(20);
		Textbox.setEditable(false);

		add(Panel);
		Panel.add(F);
		Panel.add(L);
		Panel.add(R);
		Panel.add(B);
		Panel.add(S);
		Panel.add(Rewind);
		Panel.add(Lable_1);
		Panel.add(Lable_2);
		Panel.add(Textbox);
		Panel.add(Run);

		F.addActionListener(this);
		L.addActionListener(this);
		R.addActionListener(this);
		B.addActionListener(this);
		S.addActionListener(this);
		Run.addActionListener(this);
		Rewind.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		Inputconverter Conv = new Inputconverter();
		Rewind logs = new Rewind();
		if (e.getSource() == F) {

			Lable_1.setText("Input duration and speed separated by a space");
			Lable_2.setVisible(true);
			Lable_2.setText("Duration (max 6) and Speeds (0 to 100) ");
			Textbox.setEditable(true);
			direction = "F";
		} else if (e.getSource() == L) {
			Lable_1.setText("Input duration and 2 different speeds separated by a space");
			Lable_2.setVisible(true);
			Lable_2.setText("Duration (max 6) and Speeds (-100 to 100) ");
			Textbox.setEditable(true);
			direction = "L";
		} else if (e.getSource() == R) {
			Lable_1.setText("Input duration and 2 different speeds separated by a space");
			Lable_2.setVisible(true);
			Lable_2.setText("Duration (max 6) and Speeds (-100 to 100) ");
			Textbox.setEditable(true);
			direction = "R";
		} else if (e.getSource() == B) {
			Lable_1.setText("Input duration and speed separated by a space");
			Lable_2.setVisible(true);
			Lable_2.setText("Duration (max 6) and Speeds (0 to 100) ");
			Textbox.setEditable(true);
			direction = "B";
		}

		else if (e.getSource() == Run) {
			String user_input = Textbox.getText();
			if (direction == null) {
				try {
					logs.setrewind(user_input);
				} catch (IOException e1) {
					System.out.println("error in Gui (sending to Rewind)");
				}
			} else {
				Conv.setinput(user_input, direction);
			}
			Lable_1.setText("Choose the direction");
			Lable_2.setVisible(false);
			Textbox.setText("");
			Textbox.setEditable(false);
		} else if (e.getSource() == S) {
			System.exit(0);
		} else if (e.getSource() == Rewind) {
			Lable_1.setText("Choose how many commands to replay");
			Lable_2.setVisible(true);
			Lable_2.setText("Duration (max 6) and Speeds (-100 to 100) ");
			Textbox.setEditable(true);
			direction = null;
		}

	}

	public void doit() {
		JFrame Frame = new Gui();
		Frame.setTitle("Finch Controller");
		Frame.setSize(365, 200);
		Frame.setLocation(10, 220);
		Frame.setVisible(true);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}