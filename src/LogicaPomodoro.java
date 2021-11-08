import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;



/**
 * @author Renan Alencar Dores
 * @version 1.0.0
 */
public class LogicaPomodoro {


	//Variáveis
	private static int contador = 0;
	private static int contadorShort = 0;
	private static boolean cronometrando = false;
	private static boolean cronometrandoShort= false;
	private static int segundos;
	private static int minutos;
	private static int horas ;
	
	//private static Timer timer;
    // Contrutores
    static Timer timer = new Timer();
    //static GuiPomodoro gui = new GuiPomodoro(0,0);
    
    
    /*
     * Classe que realiza a marcação de tempo estabelecido
     */
	public static void LogicInit()  {

		 //System.out.println("Clicou em Iniciar");
		 if (!cronometrando) {
			 
			 timer = new Timer();
			 cronometrando = true;
			 
		timer.scheduleAtFixedRate(new TimerTask() {
			
			public void run() {
				
				contador++;
				segundos = contador % 60;
				minutos = contador / 60;
				horas = minutos / 60; 
				minutos %= 60;
				GuiPomodoro.contagemTimer.setText(String.format("%02d:%02d:%02d", horas,minutos,segundos));
				
				/*
				 * Lógica para iniciar o  Short Break
				 */
				if (minutos == 25) {
					/*
					 * tocar um alerta aqui
					 */
					Toolkit.getDefaultToolkit().beep();
					GuiPomodoro.estadoAtual.setText(String.format("Descanço"));
					JOptionPane.showMessageDialog(null, "Tire uma pequena Pausa\n"
							+ "Você merece ;)");
					LogicPause(); // Pausa o timer
					ShortBreak(); // chama a função que incia o contador do ShorBreak
				}
				
				}
			},1000,1000); 
		}
	}
	
	  /*
     * Classe que realiza o logica para parar o timer
     */
	public static void LogicPause() {

		 //System.out.println("Clicou em PAUSAR");
		 if (cronometrando) {
			 timer.cancel();
			 //GuiPomodoro.contagemTimer.setText(String.format("00:00:00"));
			 cronometrando = false;
			 //contador = 0;
			 
		 }
	}
	  /*
     * Classe que realiza o logica para parar e depois continuar o timer
     */
	public static void LogicStop() {


		 //System.out.println("Clicou em PARAR");
		 if (cronometrando) {
			 timer.cancel();
			 GuiPomodoro.contagemTimer.setText(String.format("00:00:00"));
			 cronometrando = false;
			 contador = 0;
			 
		 }
		
	}
	public static void ShortBreak() {

		  /*
		   * Contador do ShortBreak
		   */
		 if (!cronometrandoShort) {
			 
			 timer = new Timer();
			 cronometrando = true;
			 
		timer.scheduleAtFixedRate(new TimerTask() {
			
			public void run() {
				
				contadorShort++;
				segundos = contadorShort % 60;
				minutos = contadorShort / 60;
				horas = minutos / 60; 
				minutos %= 60;
				GuiPomodoro.contagemTimer.setText(String.format("%02d:%02d:%02d", horas,minutos,segundos));
				/*
				 * Quando o contador chegar a 5 minutos, o short break acaba
				 */
				if (minutos == 5) {
					Toolkit.getDefaultToolkit().beep(); // emite um alerta
					GuiPomodoro.estadoAtual.setText(String.format("Trabalhando"));
					JOptionPane.showMessageDialog(null, "Sua pausa acabou\n"
							+ "De volta ao trabalho ;)");
					LogicStop(); // Chama a função stop para zerar o timer
					LogicInit(); // Inicia o time
				}
				
				}
			},1000,1000); 
		}
	}
	
    /*
     * Classe que permite adicionar tarefas (deverá ser implementado no gui
     * utilizando o jpanel)
     */
    public void LogicaTarefas() {

    	// em desenvolvimento
   	
    }
}
