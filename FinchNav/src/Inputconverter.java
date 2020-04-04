import javax.swing.JOptionPane;

public class Inputconverter {
	
	private void converter(String userinput, String direction){
		try {
			int duration,speed1,speed2;
			String[] inputsplit =userinput.split("\\ ");
			

			if(direction=="L"||direction=="R"){
				
				duration=Integer.parseInt(inputsplit[0]);
				speed1=Integer.parseInt(inputsplit[1]);
				speed2=Integer.parseInt(inputsplit[2]);
				speed1=(speed1*255)/100;
				speed2=(speed2*255)/100;
				duration=duration*1000;
				
			}
			else {
				duration=Integer.parseInt(inputsplit[0]);
				speed1=Integer.parseInt(inputsplit[1]);
				speed1=(speed1*255)/100;
				speed2=speed1;
				duration=duration*1000;
				
			}	

		getinput(direction,duration,speed1,speed2);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Error invalid input, check the instruction");
			}
		
		
		
		
	}
	public void setinput (String userinput, String direction){
		converter(userinput,direction);
	}
	public void getinput(String direction,int duration,int speed1,int speed2){
		Error errorcheck = new Error();
		errorcheck.seterror(direction,duration,speed1,speed2);
	}
}
