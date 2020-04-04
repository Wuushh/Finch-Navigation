
public class Error {
	private void errorcheck(String direction,int duration,int speed1,int speed2){
		String error="No";
		Gui errormsg = new Gui();
		if (duration > 6000) {
			error = "Duration";
			errormsg.errormsg(error);
		} else if (speed1 > 255 || speed2 > 255 || speed1 < 0 || speed2 < 0) {
			error = "Speed";
			errormsg.errormsg(error);
		} else {
			switch (direction) {
			case "L":
			case "R":
				if (speed1 == speed2) {
					error = "Turn";
					errormsg.errormsg(error);
				} else
					getinput(direction, duration, speed1, speed2);
					error = "No";
					errormsg.errormsg(error);
					break;
			case "F":
			case "B":
				getinput(direction, duration, speed1, speed2);
				error = "No";
				errormsg.errormsg(error);
				break;
			}
		}
	}
	public void seterror(String direction,int duration,int speed1,int speed2){
		errorcheck(direction,duration,speed1,speed2);
	}
	public void getinput(String direction,int duration,int speed1,int speed2){
		finch_physical_action finchirl = new finch_physical_action();
		finchirl.setmove(direction, duration, speed1, speed2);
	}
}
