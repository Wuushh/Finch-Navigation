import javax.swing.JOptionPane;

public class Error {
	private void errorcheck(String direction, int duration, int speed1, int speed2) {
		String logs = direction + " " + duration + " " + speed1 + " " + speed2;

		if (duration > 6000) {
			JOptionPane.showMessageDialog(null, "Duration out of bounds(0-6)");
		} else if (speed1 > 255 || speed2 > 255 || speed1 < 0 || speed2 < 0) {
			JOptionPane.showMessageDialog(null, "Speed out of bounds(0-100)");
		} else {
			switch (direction) {
			case "L":
			case "R":
				if (speed1 == speed2) {
					JOptionPane.showMessageDialog(null, "For left or right speeds must be different");
				} else
					getinput(direction, duration, speed1, speed2, logs);
				break;
			case "F":
			case "B":
				getinput(direction, duration, speed1, speed2, logs);
				break;
			}
		}
	}

	public void seterror(String direction, int duration, int speed1, int speed2) {
		errorcheck(direction, duration, speed1, speed2);
	}

	public void getinput(String direction, int duration, int speed1, int speed2, String logs) {
		FinchMovement finchirl = new FinchMovement();
		finchirl.setmove(direction, duration, speed1, speed2);

		Rewind setlogs = new Rewind();
		setlogs.setlogs(logs);
	}
}
