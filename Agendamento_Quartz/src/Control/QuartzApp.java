package Control;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class QuartzApp {
	
	//A express�o de tempo implementada na classe testadora � passada por par�metro. 
	public void quartzApp01(String valores){
		
		//Implement��o do padr�o factory a partir da classe StdSchedulerFactory.
		SchedulerFactory shedFact = new StdSchedulerFactory();
		try{
			//captura de uma inst�ncia de Scheduler, a partir dele � possivel monitorar tarefas e agendas
			Scheduler scheduler = shedFact.getScheduler();
			
			//inicia o monitoramento
			scheduler.start();
			
			//Neste ponto � onde come�a a definir o job, usando o JobBuilder.
			//� a partir dele que chamamos a classe que esta com as funcionalidades que ser�o executadas.
			//Identificamos o job atrav�s do withIdentity e criamos um grupo para ele.
			JobDetail job = JobBuilder.newJob(ValidadorJob.class).withIdentity("ValidadorJob","grupo01").build();
			
			//A trigger � responsael por configurar o agendamento das tarefas e disparar as tarefas.
			//Utiliza o mesmo conceito de idendifica��o  que o Job, e deve estar no mesmo grupo mencionado no job.
			//withSchedule � responsavel por implementar os dados do agendamento, a partir dele utilizamos o CronScheduleBuilder que
			// � responsavel por trabalhar com o Crontrigger, o mesmo utiliza a express�o armazenada na variavel passada por par�metro.
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("ValidadorTRIGGER", "grupo01").withSchedule(CronScheduleBuilder.cronSchedule(valores)).build();
			
			//Adiciona os objetos job e trigger ao scheduler, dessa maneira ele sabera qual tarefa executar e em qual tempo ela deve ser chamada.
			scheduler.scheduleJob(job,trigger);
			
			
			
			
		}catch (SchedulerException e){
			e.printStackTrace();
		}
	}
		
	
	// Metodo abaixo utiliza os mesmo conceitos utilizados acima, sua diferen�a esta na classe em o job chama e 
	// o tempo de execu��o da trigger.
		public void quartzApp02(String valores){
			
			SchedulerFactory shedFact = new StdSchedulerFactory();
			try{
			
				Scheduler scheduler = shedFact.getScheduler();
				
				scheduler.start();
			
				JobDetail job2 = JobBuilder.newJob(ValidadorJob2.class).withIdentity("ValidadorJob2","grupo01").build();
				
				Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("ValidadorTRIGGER2", "grupo01").withSchedule(CronScheduleBuilder.cronSchedule(valores)).build();
				
				scheduler.scheduleJob(job2,trigger2);
				
			}catch (SchedulerException e){
				e.printStackTrace();
			}
	}
	
	

}
