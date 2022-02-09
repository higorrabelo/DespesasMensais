
package Model;

import java.util.List;

public interface DespesaDao {
    void inserirDespesa(Despesa d);
    void removerDespesa(Despesa d);
    List<Despesa> listarDespesas();
    Despesa selecionaDespesa(int id);
    void salvarArquivo(List<Despesa> despesas, String caminho);
    List<Despesa> abrirArquivo(String caminho);
    
}
