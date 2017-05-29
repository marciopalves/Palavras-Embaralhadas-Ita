package dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utils.Utils;

public class LerDados extends Utils{
    
    private FileReader arquivo;
    private List<String> lista;

    public List<String> getPalavraArquivo() throws IOException{
        
        lista = new ArrayList<>();
        
        try{
            File f = new File("lista_palavras.txt");
            arquivo = new FileReader(f);
            BufferedReader lerArq = new BufferedReader(arquivo);

            String linha = lerArq.readLine(); 
            
            while (linha != null) {
                lista.add(linha);
                linha = lerArq.readLine(); 
            }
        }catch (IOException e) {
            printLN("Erro ao ler arquivo contendo as palavras");
        }finally{
            arquivo.close();
        }  
        return  lista;
    }
}
