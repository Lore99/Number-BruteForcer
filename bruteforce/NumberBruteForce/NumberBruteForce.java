/*
Copyright 2017 Lorenzo Boldorini

NumberBruteForce is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
NumberBruteForce is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
See the GNU Affero General Public License for more details.
You should have received a copy of the GNU General Public License along with NumberBruteForce.
If not, see <http://www.gnu.org/licenses/>.
*/
package bruteforce.NumberBruteForce;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class NumberBruteForce {
    private int howLong;
    private int provider;
    private String max;
    private String min;
    private String prefix;
    
    //you can omitt provider to use this as a number generetor from 0 to howlong
    public NumberBruteForce(String prefix, int howLong, int provider) {
    	this.setHowLong(howLong);
    	this.setPrefix(prefix);
    	this.setProvider(provider);
    	this.generateMax();
    	this.generateMin();
    }
    
    public NumberBruteForce(String prefix, int howLong) {
    	this(prefix, howLong, -1);
    }
    
    //fill the minimum string with zeros (if howLong = 4 -> sminimum string = 0000)
    private void generateMin() {
    	String temp = new String("");
	    for(int i = 0; i < this.getHowLong(); i++) {
	    	temp = temp +"0";
	    }
    	this.setMin(temp);
    }
    
  //fill the maximum string with nines (if howLong = 4 -> maximim string = 9999)
    private void generateMax() {
    	String temp = new String("");
    	for(int i = 0; i < this.getHowLong(); i++) {
    		temp = temp +"9";
    	}
    	this.setMax(temp);
    }
    
    //generate all the numbers between min and max and add them to fa file like {num1##num2##num3##num4}
    public boolean bruteForce(String outputFile) {
    	long localMax =(long) Long.parseLong(this.getMax());
    	long localMin = (long) Long.parseLong(this.getMin());
    	for(long i = localMin; i <= localMax; i++) {
    		String number;
    		//add the number to the prefix
    		if(this.getProvider() == -1) {
    			number = this.getPrefix() + String.format("%0"+this.getHowLong()+"d", i ) + "##";
    		}
    		else {
    			number = this.getPrefix() + Integer.toString(this.getProvider()) + String.format("%0"+this.getHowLong()+"d", i ) + "##";
    		}
    		
    		//output the new number to outputFile
    		 BufferedWriter writer = null;
    	      try {
    	          File logFile = new File(outputFile);
    	          writer = new BufferedWriter(new FileWriter(logFile, true));
    	          writer.write(number);
    	          System.out.println("Aggiunto il numero: " + number);
    	      } catch(Exception e) {
    	          e.printStackTrace();
    	      } finally {
    	          try {
    	              // Close the writer regardless of what happens...
    	              writer.close();
    	          } catch(Exception e2) {
    	        	  e2.printStackTrace();
    	          }
    	      }
    	}
    	
    	return true;
    }    
    
    
    /*
     * Getter And Setter Methods
     * 
    */  
  
	public int getHowLong() {
		return howLong;
	}

	public void setHowLong(int howLong) {
		this.howLong = howLong;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public int getProvider() {
		return provider;
	}

	public void setProvider(int provider) {
		this.provider = provider;
	}

}
