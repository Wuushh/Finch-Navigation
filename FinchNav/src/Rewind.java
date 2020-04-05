import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Rewind {
	private File log = new File("log.txt");
	private String line;
	private Stack<String> storelogs = new Stack<String>();

	private void recall(String Rewind) throws IOException {
		try {
			int duration, speed1, speed2, Rewind_num = Integer.parseInt(Rewind);
			String direction;

			FileReader Fr = new FileReader(log);
			BufferedReader Br = new BufferedReader(Fr);
			while ((line = Br.readLine()) != null) {
				storelogs.add(line);
			}
			Br.close();
			Fr.close();
			for (int i = 0; i < Rewind_num; i++) {
				String[] inputsplit = storelogs.pop().split("\\ ");
				direction = inputsplit[0];
				duration = Integer.parseInt(inputsplit[1]);
				speed1 = Integer.parseInt(inputsplit[2]);
				speed2 = Integer.parseInt(inputsplit[3]);
				getrewind(direction, duration, speed1, speed2);

			}
			PrintWriter Filecleaner = new PrintWriter(log);
			Filecleaner.flush();
			Filecleaner.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cant rewaind that amound of times");
		}

	}

	public void setlogs(String logs) {
		try {
			if (!log.exists()) {
				log.createNewFile();
			}
			FileWriter Fw = new FileWriter(log, true);
			BufferedWriter Bw = new BufferedWriter(Fw);
			Bw.write(logs + "\n");
			Bw.close();
			Fw.close();
		} catch (IOException e) {
			System.out.println("COULD NOT LOG!!");
		}
	}

	public void setrewind(String Rewind) throws IOException {
		recall(Rewind);
	}

	public void getrewind(String direction, int duration, int speed1, int speed2) {
		FinchMovement finchirl = new FinchMovement();
		finchirl.setmove(direction, duration, speed1, speed2);
	}
}
