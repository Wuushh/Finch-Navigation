import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

public class Recall {
	File log = new File("log.txt");
	String line;
	private Stack<String> logs = new Stack<String>();
	private void recall(String replays)throws IOException{
		  int duration,speed1,speed2;
	        String direction;
	        int replaynum = Integer.parseInt(replays);
	        
	        FileReader filereader = new FileReader(log);
	        BufferedReader bufferreader = new BufferedReader(filereader);
	        
	        while ((line = bufferreader.readLine())!=null) {
	        	logs.add(line);
	        }
	        
	        for(int i=0;i<replaynum;i++){
	            String[] inputsplit =logs.pop().split("\\ ");
	            direction=inputsplit[0];
	            System.out.println(inputsplit[0]);
	            duration=Integer.parseInt(inputsplit[1]);
	            speed1=Integer.parseInt(inputsplit[2]);
	            speed2=Integer.parseInt(inputsplit[3]);
	          getrecall(direction, duration, speed1, speed2);
	            
	}
	        PrintWriter writer = new PrintWriter(log);
	        writer.flush();
	}
	public void setlogs(String Logs){
		try{
		    if(!log.exists()){	     
		        log.createNewFile();
		    }

		    FileWriter fileWriter = new FileWriter(log, true);
		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		    bufferedWriter.write(Logs + "\n");
		    bufferedWriter.close();

		    
		} catch(IOException e) {
		    System.out.println("COULD NOT LOG!!");
		}

	}
	public void setreplays(String replays) throws IOException{
		recall(replays);
	}
	public void getrecall(String direction,int duration,int speed1,int speed2){
		finch_physical_action finchirl = new finch_physical_action();
		finchirl.setmove(direction, duration, speed1, speed2);
	}
}
