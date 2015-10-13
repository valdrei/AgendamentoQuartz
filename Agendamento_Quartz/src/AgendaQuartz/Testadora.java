package AgendaQuartz;

public class Testadora {
	
	
	
	public Testadora(){
		
	}

	public static void main(String[] args){
		String teste;
		String teste2;
		
		/*Parâmetros de execução do job.
		Cada variavel implementa um parâmetro que pode ser usado em um ou mais jobs.
		Funciona da seguinte forma da esquerda para a direita ( segundos , minutos, horas , dia do mês, dia da semana e ano)
		Resumindo onde esta "0/10" são os segundos, neste caso na variavel 'teste' são 10 segundos, se
		usasse apenas 10 estariamos dizendo que a execução de cada job iria ocorrer toda vez nos 10 segundos de qualquer minuto.
		*/
		teste = "0/10 * * * * ?";
		teste2 = "0/15 * * * * ?";
		
		
		//Criando um objeto do tipo QuartzApp, classe onde etsa localizado
		//os jobs e triggers.
		QuartzApp testando = new QuartzApp();
		
		
		//chamando os metodos e passando como parâmetros o tempo de execução de cada job. 
		testando.quartzApp01(teste);
		testando.quartzApp02(teste2);
	
		
	}
	

}
