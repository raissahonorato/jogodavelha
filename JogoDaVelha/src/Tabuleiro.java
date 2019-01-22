import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
 
/**
 * IFPB - TSI - POO 
 * @author Prof. Fausto Ayres
 *
 */
public class Tabuleiro  {
 
    private JFrame frame;
    private JLabel[][] labels = new JLabel[3][3];
    private JogoDaVelha jogo;
    private int numeroJogador=1;
    private JLabel label;
    private JButton button;
    private JPanel panel_1;
 
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tabuleiro window = new Tabuleiro();
                    window.frame.setVisible(true);
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
        frame = new JFrame();
        frame.setTitle("Matriz de Labels");
        frame.setBounds(100, 100, 417, 437);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
         
        label = new JLabel("Jogador:");
        label.setBounds(23, 332, 105, 14);
        frame.getContentPane().add(label);
         
        button = new JButton("reiniciar");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jogo = new JogoDaVelha("xx","xxx");
                numeroJogador=1;
                for(int i=0; i < 3; i++)
                    for(int j=0; j < 3; j++)
                        labels[i][j].setBackground(Color.YELLOW);
            }
        });
        button.setBounds(10, 364, 89, 23);
        frame.getContentPane().add(button);
        
        panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Tabuleiro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(10, 21, 250, 338);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(57, 35, 155, 144);
        panel_1.add(panel);
        panel.setLayout(null);
 
        //inicializar a matriz de labels
        for(int i=0; i < 3; i++){
            for(int j=0; j < 3; j++){
                labels[i][j]=new JLabel("");
                frame.getContentPane().add(labels[i][j]);
                labels[i][j].setBounds(i*40, j*40, 40, 40); //x,y, width, height - 40x40
                labels[i][j].setBackground(SystemColor.controlHighlight);
                labels[i][j].setBorder(new LineBorder(new Color(0, 0, 0)));
                labels[i][j].setOpaque(true);
                panel.add(labels[i][j]);
                labels[i][j].addMouseListener(new  MouseAdapter(){
                    public void mouseClicked(MouseEvent e){     //click
                        JLabel b = (JLabel)e.getSource();
                        int indicex = b.getX()/40;
                        int indicey = b.getY()/40;
                        if(numeroJogador==1) {
                        	labels[indicex][indicey].setText("X");
                            labels[indicex][indicey].setBackground(Color.BLUE);	
							labels[indicex][indicey].removeMouseListener(this);
							labels[indicex][indicey].disable();
                        }
                        
                        else {
                        	
                        	labels[indicex][indicey].setText("O");
                        	labels[indicex][indicey].setBackground(Color.GREEN);
                        	labels[indicex][indicey].removeMouseListener(this);
							labels[indicex][indicey].disable();
                        }
                     
                    //  if(jogo.terminou())
                    //      label.setText(jogo.getResultado());
                             
                             
                        System.out.println("clicou na celula:"+  indicex + "-" + indicey);
                        label.setText("jogador:"+numeroJogador);
                        boolean jogadavalida = jogo.jogarJogador(numeroJogador, indicex, indicey);
                         
                        if(numeroJogador==1) 
                            numeroJogador=2; 
                        else numeroJogador=1;
                    }
                });
            }
        }
 
    }
}