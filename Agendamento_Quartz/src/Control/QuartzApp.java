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

import Model.ScheduleSetup;


public class QuartzApp {
	
	//A expressão de tempo implementada na classe testadora é passada por parâmetro. 
	public void quartzApp01(String valores){
		
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
			JobDetail job = JobBuilder.newJob(ValidadorJob.class).withIdentity("ValidadorJob","grupo01").build();
			
			//A trigger é responsael por configurar o agendamento das tarefas e disparar as tarefas.
			//Utiliza o mesmo conceito de idendificação  que o Job, e deve estar no mesmo grupo mencionado no job.
			//withSchedule é responsavel por implementar os dados do agendamento, a partir dele utilizamos o CronScheduleBuilder que
			// é responsavel por trabalhar com o Crontrigger, o mesmo utiliza a expressão armazenada na variavel passada por parâmetro.
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("ValidadorTRIGGER", "grupo01").withSchedule(CronScheduleBuilder.cronSchedule(valores)).build();
			
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
			
				JobDetail job2 = JobBuilder.newJob(ValidadorJob2.class).withIdentity("ValidadorJob2","grupo01").build();
				
				Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("ValidadorTRIGGER2", "grupo01").withSchedule(CronScheduleBuilder.cronSchedule(valores)).build();
				
				scheduler.scheduleJob(job2,trigger2);
				
			}catch (SchedulerException e){
				e.printStackTrace();
			}
	}
		
		
		public void setSchedule(ScheduleSetup schedule){

		
		/*Par�metros de execu��o do job.
		Cada variavel implementa um par�metro que pode ser usado em um ou mais jobs.
		Funciona da seguinte forma da esquerda para a direita ( segundos , minutos, horas , dia do m�s, dia da semana e ano)
		Resumindo onde esta "0/10" s�o os segundos, neste caso na variavel 'teste' s�o 10 segundos, se
		usasse apenas 10 estariamos dizendo que a execu��o de cada job iria ocorrer toda vez nos 10 segundos de qualquer minuto.
		*/
		//teste = "0/10 * * * * ?";
		//teste2 = "0/15 * * * * ?";
		
		
		
		//chamando os metodos e passando como par�metros o tempo de execu��o de cada job. 
		this.quartzApp01(schedule.getSecCache());
		this.quartzApp02(schedule.getSecCacheClear());
		
		}
	

}
