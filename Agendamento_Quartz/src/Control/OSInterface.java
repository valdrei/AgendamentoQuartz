package Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSInterface {

	public OSInterface(){
		
	}

	public String executeCommand(String commandLine){
		
		boolean success = false;  
	    String result;  
	  
	    Process p;  
	    BufferedReader input;  
	    StringBuffer cmdOut = new StringBuffer();  
	    String lineOut = null;  
	    int numberOfOutline = 0;  
	  
	    try {  
	  
	        p = Runtime.getRuntime().exec(commandLine);  
	  
	        input = new BufferedReader(new InputStreamReader(p.getInputStream()));  
	  
	        while ((lineOut = input.readLine()) != null) {  
	            if (numberOfOutline > 0) {  
	                cmdOut.append("\n");  
	            }  
	            cmdOut.append(lineOut);  
	            numberOfOutline++;  
	        }  
	  
	        result = cmdOut.toString();  
	  
	        success = true;  
	  
	        input.close();  
	          
	    } catch (IOException e) {  
	        result = String.format("Falha ao executar comando %s. Erro: %s", commandLine, e.toString());  
	    }  
	  
	    // Se não executou com sucesso, lança a falha  
	    if (!success) {  
	        try {
				throw new IOException(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	    }  
	  
	    return result;  
	}

}
