import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;


//import org.w3c.dom.events.MouseEvent;

public class Tabuleiro {
	
	private JFrame frmJogoDaVelha;
	private JLabel[][] labels = new JLabel[3][3];
	private JogoDaVelha jogo;
	private int numeroJogador=1;
	private JLabel label;
	private JButton button;
	String Simbolo;

	

	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tabuleiro window = new Tabuleiro();
                    window.frmJogoDaVelha.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
	/**
	 * Create the application.
	 */
	public Tabuleiro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jogo = new JogoDaVelha("joao", "maria");
		frmJogoDaVelha = new JFrame();
		frmJogoDaVelha.setResizable(false);
		frmJogoDaVelha.setTitle("Jogo da Velha");
		frmJogoDaVelha.setBounds(100, 100, 444, 436);
		frmJogoDaVelha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJogoDaVelha.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tabuleiro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 214, 386);
		frmJogoDaVelha.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelTabuleiro = new JPanel();
		panelTabuleiro.setBounds(26, 37, 155, 192);
		panel.add(panelTabuleiro);
		panelTabuleiro.setLayout(new GridLayout(3, 3, 10, 10));
		
		JButton btnNovoJogo = new JButton("Novo Jogo");
		btnNovoJogo.setBounds(57, 248, 97, 28);
		panel.add(btnNovoJogo);
		
		JButton btnNewButton = new JButton("Resultado");
		btnNewButton.setBounds(57, 300, 97, 28);
		panel.add(btnNewButton);
		
		
		
		
		
		
				
				for(int i=0; i < 3; i++){
					for(int j=0; j < 3; j++){
						
							
							labels[i][j]=new JLabel("");
							frmJogoDaVelha.getContentPane().add(labels[i][j]);
							labels[i][j].setBounds(i*60, j*60, 50, 50); //x,y, width, height - 40x40
							labels[i][j].setBackground(SystemColor.controlHighlight);
							//labels[i][j].setBorder(new lineBorder(new Color(0, 0, 0)));
							labels[i][j].setOpaque(true);
							panelTabuleiro.add(labels[i][j]);
					
						
						
						
						labels[i][j].addMouseListener(new MouseAdapter(){
							

							
							public void mouseClicked(MouseEvent e){
								JLabel b = (JLabel)e.getSource();
								int col = b.getX()/40;
								int lin = b.getY()/40;
								
								if(numeroJogador==1) {
									Simbolo = "X";
									//labels[col][lin].setText("X");
									labels[col][lin].setBackground(Color.GREEN);
									labels[col][lin].removeMouseListener(this);
									labels[col][lin].disable();
								} else {
									Simbolo = "O";
									//labels[col][lin].setText("X");
									labels[col][lin].setBackground(Color.BLUE);
									labels[col][lin].removeMouseListener(this);
									labels[col][lin].disable();
								}
								
								labels[col][lin].setText(Simbolo);
								boolean jogadavalida = jogo.jogarJogador(numeroJogador, lin, col);


								if(numeroJogador==1) 
									numeroJogador=2; 
								else numeroJogador=1;
							}
						});
						
						

						
						
						
					} //segundo for
				}
				
				

		
		 


		
	}
}
