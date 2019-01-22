import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

// RAISSA HONORATO PONTES - REDES DE COMPUTADORES - 20141380300
public class JogoDaVelha {
	private static final String NULL = null;
	private String nome1;
	private String nome2;
	private String[][] matriz = new String[3][3];
	private int contjogada;
	private String historico ="";
	private int resultado;
	private int linha;
	private int coluna;
	private int numJogador;
	private int ultimoJogador;

	//  CONSTRUTOR. 2 JOGADORES ABRE O ARQUIVO TXT PARA GRAVAÇÃO INICIALIZA O ARRAY E OS DEMAIS  ATRIBUTOS. 
	public JogoDaVelha(String nome1, String nome2) {
		this.nome1 = nome1;
		this.nome2 = nome2;
		
    	
		historico += "#########################################\n\n";
		historico += "JOGADORES:\n";
		historico += "Jogador 1: "+ nome1 + "\n";
		historico += "Jogador 2: "+ nome2 +"\n\n";		
	}
	//#####################################################################################################
	
	
	// INICIALIZA ONDE O JOGADOR 2 É O COMPUTADOR. 
	public JogoDaVelha(String nome1) {
		this.nome1 = nome1;
		this.nome2 = "Maquina";
		historico += "jogadores:" + nome1 + " contra " + nome2;

	}
	//######################################################################################################

	
	
	// VERIFICA SE EXISTE UMA POSICAO VALIDA NO TABULEIRO PARA O JOGADOR, SE SIM, MARCA A POSIÇÃO, SE NAO, RETORNA FALSE
	public boolean jogarJogador(int numj, int lin, int col) {
			if (numj == 1) {
				historico+="\nO Jogador "+numj+" jogou na linha: "+lin+" e na coluna: "+col+"\n";
				System.out.println(historico);
				
				numJogador = 1;
				matriz[linha][coluna] = "X";
				for (int i = 0; i < 3; i++){
					System.out.print("|  ");
					for (int j = 0; j < 3; j++) {	
						System.out.print(matriz[i][j] + "  |  ");
					}
					System.out.println();
				}
				return true;
			}
			else {
				matriz[linha][coluna] = "O";	
				for (int i = 0; i < 3; i++){
					System.out.print("|  ");
					for (int j = 0; j < 3; j++) {
						System.out.print(matriz[i][j] + " | ");
						

					}
					System.out.println();
				}
				return true;
			}
	}


	
	public boolean terminou() {
		++contjogada;

		if(contjogada == 9) {
			resultado = 3;
			ArquivoTxt(historico);
			return true;
		}
		for(int i=0; i<3; i++){
			if(matriz[i][0] + matriz[i][1] + matriz[i][2] == "X" ||
					matriz[0][i] + matriz[1][i] + matriz[2][i] == "X" ||
					matriz[0][0] + matriz[1][1] + matriz[2][2] == "X" ||
					matriz[0][2] + matriz[1][1] + matriz[2][0] == "X") {
				resultado = 1;
				ArquivoTxt(historico);
				return true;
			}

			if(matriz[i][0] + matriz[i][1] + matriz[i][2] == "O" ||
					matriz[0][i] + matriz[1][i] + matriz[2][i] == "O" ||
					matriz[0][0] + matriz[1][1] + matriz[2][2] == "O" ||
					matriz[0][2] + matriz[1][1] + matriz[2][0] == "O") {
				resultado = 2;
				ArquivoTxt(historico);
				return true;
			}
		}

		return false;
	}
	
	
	// RETORNA O NOME DO JOGADOR
	public String getNomeJogador(int jogador) {
		if(jogador == 1) {
			return nome1 + " ";
		}
		if(jogador == 2) {
			return nome2 + " ";
		}
		return "";
	}
	//###############################################//

	
	
	
	//RETORNA 1(JOAGDOR1), 2(JOGADOR2) ou 3(EMPATE) E FECHA O ARQUIVO
	public int getResultado() { 
		return resultado;
	}
	//####################################################################//
	
	
	// GRAVA O HISTORICO DO JOGO EM UM ARQUIVO TXT
	public void ArquivoTxt(String historico) {
		try {
			FileWriter arq = new FileWriter( new File("HistoricoJogo.txt") );
			

			arq.write(historico);
			arq.close();

		}catch(IOException e){
			System.out.println("Ocorreu um erro na hora de gravar o aquivo.");
			System.exit(0);
		}
	}
	//####################################################################//
	

	
	// RETORNA A LINHA DA ULTIMA JOGADA REALIZADA
	public int getUltimaLinha() {
		return linha;
	}
	//###############################################//
	

	
	
	// RETORNA A COLUNA DA ULTIMA JOGADA REALIZADA
	public  int  getUltimaColuna() {
		return coluna;
	}
	//###############################################//

	
	
	
	// RETORNA O NUMERO DO JOGADOR DA ULTIMA JOGADA REALIZADA
	public  int  getUltimoJogador() {
		return numJogador;
	}
	//###############################################//


	// LOCALIZA E MARCA UMA POSICAO VALIDA NO TABULEIRO PARA O JOGADOR 2
	public void jogarMaquina() {
		Random maquina = new Random();


		int linha;
		int coluna;

		do {
			linha = maquina.nextInt(3);
			coluna = maquina.nextInt(3);
		}while(!jogarJogador(2,linha+1,coluna+1));
	}

	}
	//###############################################//