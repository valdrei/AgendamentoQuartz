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
	

	
	//A expressão de tempo implementada na classe testadora é passada por parâmetro. 
	public void quartzApp01(String valores,String jobName,String triggerName, Class classe){
		
		//Implementção do padrão factory a partir da classe StdSchedulerFactory.
		SchedulerFactory shedFact = new StdSchedulerFactory();
		try{
			//captura de uma instância de Scheduler, a partir dele é possivel monitorar tarefas e agendas
			Scheduler scheduler = shedFact.getScheduler();
			
			//inicia o monitoramento
			scheduler.start();
			
			//Neste ponto é onde começa a definir o job, usando o JobBuilder.
			//É a partir dele que chamamos a classe que esta com as funcionalidades que serão executadas.
			//Identificamos o job através do withIdentity e criamos um grupo para ele.
			JobDetail job = JobBuilder.newJob(classe).withIdentity(jobName,"grupo01").build();
			
			//A trigger é responsael por configurar o agendamento das tarefas e disparar as tarefas.
			//Utiliza o mesmo conceito de idendificação  que o Job, e deve estar no mesmo grupo mencionado no job.
			//withSchedule é responsavel por implementar os dados do agendamento, a partir dele utilizamos o CronScheduleBuilder que
			// é responsavel por trabalhar com o Crontrigger, o mesmo utiliza a expressão armazenada na variavel passada por parâmetro.
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, "grupo01").withSchedule(CronScheduleBuilder.cronSchedule(valores)).build();
			
			//Adiciona os objetos job e trigger ao scheduler, dessa maneira ele sabera qual tarefa executar e em qual tempo ela deve ser chamada.
			scheduler.scheduleJob(job,trigger);
			
		}catch (SchedulerException e){
			e.printStackTrace();
		}
	}
		
	
	// Metodo abaixo utiliza os mesmo conceitos utilizados acima, sua diferença esta na classe em o job chama e 
	// o tempo de execução da trigger.
		public void quartzApp02(String valores){
			
			SchedulerFactory shedFact = new StdSchedulerFactory();
			try{
			
				Scheduler scheduler = shedFact.getScheduler();
				
				scheduler.start();
			
				JobDetail job2 = JobBuilder.newJob(CacheCleaner.class).withIdentity("ValidadorJob2","grupo01").build();
				
				Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("ValidadorTRIGGER2", "grupo01").withSchedule(CronScheduleBuilder.cronSchedule(valores)).build();
				
				scheduler.scheduleJob(job2,trigger2);
				
			}catch (SchedulerException e){
				e.printStackTrace();
			}
	}
		
	

}
