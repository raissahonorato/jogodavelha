import java.util.Scanner;
 
public class TesteJogo1 {
	
 
    public static void main(String[] args) {
    	
    	
        Scanner teclado = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha("joao", "maria");
        int linha, coluna;
        boolean jogadavalida;
        int numeroJogador=1;
        do {
        	
            do {
            	
                System.out.println("Jogador:" + numeroJogador);
                System.out.println("Digite a linha");
                linha = teclado.nextInt();
                System.out.println("Digite a coluna");
                coluna = teclado.nextInt();
                jogadavalida = jogo.jogarJogador(numeroJogador, linha, coluna);
                if(jogadavalida){
                    linha = jogo.getUltimaLinha();
                    coluna = jogo.getUltimaColuna();
                   // System.out.println("O jogador " + jogo.getUltimoJogador() + " jogou na posicao "+linha + "-" + coluna+"\n\n");
                }
                else
                    System.out.println("Jogada invalida, a posicao que voce indicou est� ocupada\n");
            }while(!jogadavalida);
 
            if(numeroJogador==1) 
                numeroJogador=2; 
            else numeroJogador=1;
 
        }while( !jogo.terminou());
 
        switch(jogo.getResultado()) {
        case 1: System.out.println(jogo.getNomeJogador(1) + "venceu"); break;
        case 2: System.out.println(jogo.getNomeJogador(2) + "venceu"); break;
        case 3: System.out.println("ninguem venceu");
        }
         
        //  gravar no arquivo jogo.txt  o hist�rico do jogo at� o resultado
 
    }
}