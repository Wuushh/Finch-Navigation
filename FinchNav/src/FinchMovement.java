import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FinchMovement {

	private void Actionirl(String direction, int duration, int speed1, int speed2) {
		Finch Finch = new Finch();

		switch (direction) {
		case "F":
			Finch.setWheelVelocities(speed1, speed2, duration);
			break;
		case "B":
			Finch.setWheelVelocities(-speed1, -speed2, duration);
			break;
		case "R":
			if (speed1 > speed2)
				Finch.setWheelVelocities(speed1, speed2, duration);
			else
				Finch.setWheelVelocities(speed2, speed1, duration);
			break;
		case "L":
			if (speed1 > speed2)
				Finch.setWheelVelocities(speed2, speed1, duration);
			else
				Finch.setWheelVelocities(speed1, speed2, duration);
			break;
		}

	}

	public void setmove(String direction, int duration, int speed1, int speed2) {
		Actionirl(direction, duration, speed1, speed2);
	}
}
