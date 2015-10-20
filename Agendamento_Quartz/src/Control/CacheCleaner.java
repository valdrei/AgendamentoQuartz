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
		
		//Coleta a data
		//String dataComando=new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date( (System.currentTimeMillis())));
		String data=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date( (System.currentTimeMillis())));
		//Define o comando
		String comando="del C:\\log*";
		System.out.println("\nRemovendo Cache\n");
		System.out.println(comando);
		System.out.println(os.executeCommand(comando));
		System.out.println("Executed: "+data); 
		
		
	}

}
