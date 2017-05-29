

import embaralhador.Embaralhador;
import embaralhador.FabricaEmbaralhadora;
import mecanica.ErrouTerminou;
import mecanica.FabricaMecanicaDoJogo;
import mecanica.MecanicaDoJogo;
import mecanica.PorVida;
import mecanica.TodasAsPalavras;
import utils.Utils;

import java.util.Scanner;

public class Principal extends Utils{
	
	    
	private static Scanner sc;

	public static void main(String[] args){

        sc = new Scanner(System.in);
        
        printLN("===============================================================");
        printLN("==================== ESCOLHA A MEC�NICA DO JOGO ===============");
        printLN("1 - Terminar.");
        printLN("2 - O maior n�mero de acertos.");
        printLN("3 - Tr�s vida e o jogo termina.");
        printT("->");
        int opcao = sc.nextInt();
	    switch(opcao){
	         case 1:
	            FabricaMecanicaDoJogo.set(new ErrouTerminou());
	            break;
	         case 2: 
	            FabricaMecanicaDoJogo.set(new TodasAsPalavras());
	            break;
	         case 3: 
	            FabricaMecanicaDoJogo.set(new PorVida());
	            break;
	         default:
	            printLN("Op��o invalida, programa terminado");
	            System.exit(0);
	         break;
	   } 


        MecanicaDoJogo mecanicaDoJogo = FabricaMecanicaDoJogo.get();

        printLN("*=============================================================*");
        printLN("*=========================== START ===========================*");
        printLN("Voc� vai jogar no modo: " + mecanicaDoJogo.getNome());
        printT("Descri��o: " + mecanicaDoJogo.getDescricao());
        
        espaco();
        
        while(!mecanicaDoJogo.isAcabou()){
            String palavra = mecanicaDoJogo.getPalavra();
            Embaralhador embaralhador = FabricaEmbaralhadora.getRandom();
            String embaralhada = embaralhador.embaralhar(palavra);
            
            printLN("Adivinhe a palavra: " + embaralhada);
            printT("-> ");
            String resposta = sc.nextLine().toUpperCase();
            String resultado = mecanicaDoJogo.tentativa(palavra, resposta);
            printLN("Resultado: " + resultado);
        }
        
        printLN(mecanicaDoJogo.getResultadoFinal());
    }
}
