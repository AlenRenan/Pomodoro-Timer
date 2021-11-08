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
    private JButton jbIniciar; // Bot�o para inicar o timer
    private JButton jbPausar; // Bot�o para pausar o timer
    private JButton jbParar; // Bot�o para parar o timer

    // Eventos
    ActionListener clicarIniciar;
    ActionListener clicarPausar;
    ActionListener clicarParar;

    /*
     * 
     * Interface Gr�fica
     * 
     */
    public GuiPomodoro(int larg, int alt) {

        /*
         * 
         * Implementa��es da Janela
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
         * Implementa��es dos Eventos
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
         * Implementa��o bot�o Iniciar
         */
        jbIniciar = new JButton("INICIAR"); // Cria o bot�o com texto
        jbIniciar.setLocation (10, 500);// Locacliza��o (x e y) do bot�o
        jbIniciar.setSize(200, 50); // Largura e altura do bot�o
        jbIniciar.setFont(new Font("", Font.BOLD, 30));
        jbIniciar.addActionListener(clicarIniciar); // Atribui a fun��o do bot�o
        janela.add(jbIniciar); // Adiciona o bot�o na janela
        /*
         * Implementa��o bot�o Pausar
         */
        jbPausar = new JButton("PAUSAR"); // Cria o bot�o com texto
        jbPausar.setLocation (350, 500);// Locacliza��o (x e y) do bot�o
        jbPausar.setSize(200, 50); // Largura e altura do bot�o
        jbPausar.setFont(new Font("", Font.BOLD, 30));
        jbPausar.addActionListener(clicarPausar); // Atribui a fun��o do bot�o
        janela.add(jbPausar); // Adiciona o bot�o na janela
        /*
         * Implementa��o bot�o Parar
         */
        jbParar = new JButton("ZERAR"); // Cria o bot�o com texto
        jbParar.setLocation(670, 500); // Locacliza��o (x e y) do bot�o
        jbParar.setSize(200, 50); // Largura e altura do bot�o
        jbParar.setFont(new Font("", Font.BOLD, 30));
        jbParar.addActionListener(clicarParar); // Atribui a fun��o do bot�
        janela.add(jbParar); // Adiciona o bot�o na janela
    }
}
