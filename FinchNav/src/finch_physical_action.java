import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class finch_physical_action {

	private void Actionirl(String direction, int duration, int speed1, int speed2) {
		Finch myfinch = new Finch();

		switch (direction) {
		case "F":
			myfinch.setWheelVelocities(speed1, speed2, duration);
			break;
		case "B":
			myfinch.setWheelVelocities(-speed1, -speed2, duration);
			break;
		case "R":
			if (speed1 > speed2)
				myfinch.setWheelVelocities(speed1, speed2, duration);
			else
				myfinch.setWheelVelocities(speed2, speed1, duration);
			break;
		case "L":
			if (speed1 > speed2)
				myfinch.setWheelVelocities(speed2, speed1, duration);
			else
				myfinch.setWheelVelocities(speed1, speed2, duration);
			break;
		}

	}

	public void setmove(String direction, int duration, int speed1, int speed2) {
		Actionirl(direction, duration, speed1, speed2);
	}

}
