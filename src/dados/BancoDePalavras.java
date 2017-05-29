package dados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BancoDePalavras {
  
    private LerDados dados = new LerDados();
    private List<String> listaPalavras = new ArrayList<>();
    
    public String getNext(){
        try {
            listaPalavras = dados.getPalavraArquivo();
        } catch (IOException ex) {
            Logger.getLogger(BancoDePalavras.class.getName()).log(Level.SEVERE, null, ex);
        }
        Random random = new Random(System.currentTimeMillis());
        int referencia = random.nextInt();
        int indice = referencia % (listaPalavras.size());
        
        return  listaPalavras.get(Math.abs(indice));
    }
    
    public int getTamanho(){
        return listaPalavras.size();
    }
}
