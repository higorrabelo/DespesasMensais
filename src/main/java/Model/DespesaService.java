
package Model;

import Controller.DespesaException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;

public class DespesaService implements DespesaDao {
    
    private List<Despesa> despesas = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public DespesaService() {
    }

    @Override
    public void inserirDespesa(Despesa d) {
       if(d.getDespesa() == "" || d.getValor()==null){
           JOptionPane.showMessageDialog(null,"Não há Despesas a Adicionar");
       }
       despesas.add(d);
    }

    @Override
    public void removerDespesa(Despesa d) {
        despesas.removeIf(p->p.getDespesa().toUpperCase()==d.getDespesa().toUpperCase());
    }

    @Override
    public List<Despesa> listarDespesas() {
        return despesas;
    }

    @Override
    public Despesa selecionaDespesa(int id) {      
        Despesa novaDespesa = null;
        for(Despesa d : despesas){
            if(d.getId()==id){
                novaDespesa = d;
            }
        }
        return novaDespesa;
    }

    @Override
    public void salvarArquivo(List<Despesa> despesas, String caminho) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho+".csv"))){
           
            for(Despesa d : despesas){
                bw.write(d.toString()+"\n");
            }
            bw.close();
        JOptionPane.showMessageDialog(null,"Arquivo Salvo");
        }
        catch(IOException e){
            throw new DespesaException("Erro em Salvar o Arquivo");
        }
    }

    @Override
    public List<Despesa> abrirArquivo(String caminho){    
        List<Despesa> despesas = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(caminho+".csv"))){
            
            String line = br.readLine();
            while(line != null){
                String[] campos = line.split(",");
                int id = Integer.parseInt(campos[0]);
                String despesa = campos[1];
                String descricao = campos[2];
                Double valor = Double.parseDouble(campos[3]);
                Date vencimento = sdf.parse(campos[4]);
                Despesa d = new Despesa(id,despesa,descricao,valor,vencimento);
                despesas.add(d); 
                line = br.readLine();
                
            }
            br.close();
           return despesas; 
        }
        catch(IOException e){
            throw new DespesaException("Erro ao Abrir o Arquivo");
        }
        catch(ParseException p){
            throw new DespesaException("Erro na conversão de Datas");
        }
        
    }
    
}
