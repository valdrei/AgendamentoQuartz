package Control;


import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

//� necess�rio implementar uma interface Job para executar as funcionalidades da classe
public class ValidadorJob2 implements Job {
	
	//Metodo execute � quem ira guardar a logica que dever� ser executada
	public void execute(JobExecutionContext arg0) throws JobExecutionException{
		//Simula��o
			
		System.out.println("Executando Quartz 2 em: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date( (System.currentTimeMillis())))); 
		
		
	}

}
