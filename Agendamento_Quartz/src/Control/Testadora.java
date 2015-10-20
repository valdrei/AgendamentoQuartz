package Control;

public class Testadora {
	
	
	
	public Testadora(){
		
	}

	public static void main(String[] args){
		String teste;
		String teste2;
		
		/*Par�metros de execu��o do job.
		Cada variavel implementa um par�metro que pode ser usado em um ou mais jobs.
		Funciona da seguinte forma da esquerda para a direita ( segundos , minutos, horas , dia do m�s, dia da semana e ano)
		Resumindo onde esta "0/10" s�o os segundos, neste caso na variavel 'teste' s�o 10 segundos, se
		usasse apenas 10 estariamos dizendo que a execu��o de cada job iria ocorrer toda vez nos 10 segundos de qualquer minuto.
		*/
		teste = "0/10 * * * * ?";
		teste2 = "0/15 * * * * ?";
		
		
		//Criando um objeto do tipo QuartzApp, classe onde etsa localizado
		//os jobs e triggers.
		QuartzApp testando = new QuartzApp();
		
		
		//chamando os metodos e passando como par�metros o tempo de execu��o de cada job. 
		testando.quartzApp01(teste,"teste1","trigger1",new Cache().getClass());
		testando.quartzApp01(teste2,"teste2","trigger2",new CacheCleaner().getClass());
	
		
	}
	

}
