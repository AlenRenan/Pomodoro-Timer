import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;

/**
 * @author Renan Alencar Dores
 * @version 1.0.0
 */
public class GuiPomodoro extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public static JLabel contagemTimer;
	public static JLabel estadoAtual;
	public static JLabel contagemPausas;
	public static JLabel contagemTrabalhando;
	public JToolBar toolBar = new JToolBar();
	// Contrutores
    LogicaPomodoro logic = new LogicaPomodoro();

    // Botoes
    private JButton jbIniciar; // Botão para inicar o timer
    private JButton jbPausar; // Botão para pausar o timer
    private JButton jbParar; // Botão para parar o timer

    // Eventos
    ActionListener clicarIniciar;
    ActionListener clicarPausar;
    ActionListener clicarParar;

    /*
     * 
     * Interface Gráfica
     * 
     */
    public GuiPomodoro(int larg, int alt) {

        /*
         * 
         * Implementações da Janela
         * 
         */
    	
        JFrame janela = new JFrame("Pomodoro Timer Version 1.0.0 - Renan Alencar Dores"); // Mensagem da janela
        janela.setSize(larg, alt); // Tamanho
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao sair
        janela.setResizable(false); // Impede de redimensionar a janela
        //janela.setUndecorated(true); // TIRA A BARRA DE MINIMIZAR E MAXIMIZAR
        janela.setLocationRelativeTo(null); // Centraliza a janela
        janela.setVisible(true); // Mostra janela
        
        // Timer
        contagemTimer = new JLabel ("00:00:00");
        contagemTimer.setFont(new Font("", Font.PLAIN, 100));
        janela.add(contagemTimer, BorderLayout.NORTH);
        // Estado Atual
        estadoAtual = new JLabel ("Trabalhando");
        estadoAtual.setFont(new Font("", Font.PLAIN, 50));
        janela.add(estadoAtual, BorderLayout.CENTER);
        /*
         * 
         * Implementações dos Eventos
         * 
         */
        clicarIniciar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            	LogicaPomodoro.LogicInit();
            	
            }
        };

        clicarPausar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            	LogicaPomodoro.LogicPause();

            }
        };

        clicarParar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            	LogicaPomodoro.LogicStop();
            }
        };
        /*
         * Implementação botão Iniciar
         */
        jbIniciar = new JButton("INICIAR"); // Cria o botão com texto
        jbIniciar.setLocation (10, 500);// Locaclização (x e y) do botão
        jbIniciar.setSize(200, 50); // Largura e altura do botão
        jbIniciar.setFont(new Font("", Font.BOLD, 30));
        jbIniciar.addActionListener(clicarIniciar); // Atribui a função do botão
        janela.add(jbIniciar); // Adiciona o botão na janela
        /*
         * Implementação botão Pausar
         */
        jbPausar = new JButton("PAUSAR"); // Cria o botão com texto
        jbPausar.setLocation (350, 500);// Locaclização (x e y) do botão
        jbPausar.setSize(200, 50); // Largura e altura do botão
        jbPausar.setFont(new Font("", Font.BOLD, 30));
        jbPausar.addActionListener(clicarPausar); // Atribui a função do botão
        janela.add(jbPausar); // Adiciona o botão na janela
        /*
         * Implementação botão Parar
         */
        jbParar = new JButton("ZERAR"); // Cria o botão com texto
        jbParar.setLocation(670, 500); // Locaclização (x e y) do botão
        jbParar.setSize(200, 50); // Largura e altura do botão
        jbParar.setFont(new Font("", Font.BOLD, 30));
        jbParar.addActionListener(clicarParar); // Atribui a função do botã
        janela.add(jbParar); // Adiciona o botão na janela
    }
}
