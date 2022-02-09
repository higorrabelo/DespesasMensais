package Model;
public class DaoFactory {
    
    public static DespesaDao criarDespesa(){
        return new DespesaService();
    }
    
}
