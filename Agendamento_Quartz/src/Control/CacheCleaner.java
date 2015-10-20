package Control;


import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


//� necess�rio implementar uma interface Job para executar as funcionalidades da classe
public class CacheCleaner implements Job {
	
	OSInterface os;
	
	//Metodo execute � quem ira guardar a logica que dever� ser executada
	public void execute(JobExecutionContext arg0) throws JobExecutionException{
		//Simula��o
		System.out.println("Limpando Cache");
		System.out.println(os.executeCommand(""));
		System.out.println(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date( (System.currentTimeMillis())))); 
		
		
	}

}
