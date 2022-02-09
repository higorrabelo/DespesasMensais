package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Despesa implements Serializable, Comparable<Despesa>{
    
    private int Id;
    private String despesa;
    private String descricao;
    private Double valor;
    private Date vencimento;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Despesa(String despesa, String descricao, Double valor, Date vencimento){
        this.despesa=despesa;
        this.descricao=descricao;
        this.valor=valor;
        this.vencimento=vencimento;
    }
    public Despesa(int id, String despesa, String descricao, Double valor, Date vencimento){
        this.Id=id;
        this.despesa=despesa;
        this.descricao=descricao;
        this.valor=valor;
        this.vencimento=vencimento;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDespesa() {
        return despesa;
    }

    public void setDespesa(String despesa) {
        this.despesa = despesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public String toString() {
        return Id+","+despesa+","+descricao+","+String.format("%.2f",valor)+","+sdf.format(vencimento);
    }

    @Override
    public int compareTo(Despesa o) {
        return despesa.compareTo(o.getDespesa());
    }
    
    
}
