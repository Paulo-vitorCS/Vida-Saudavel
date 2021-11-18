package Aplicativo;

import java.time.LocalDate;

public class Alimentacao {
    
    // Atributos:
    private String refeicao;
    private String descricao;
    private String data;
    private double calorias;
    private int dia, mes, ano;
    private LocalDate date;
    
    // Construtor:
    public Alimentacao(String refeicao, String descricao, String data, double calorias) {
        setRefeicao(refeicao);
        setDescricao(descricao);
        setData(data);
        setCalorias(calorias);
        montarData();
    }
    
    //Métodos:
    public String getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public void montarData(){
        String valores[] = data.split("/");
        dia = Integer.parseInt(valores[0]);
        mes = Integer.parseInt(valores[1]);
        ano = Integer.parseInt(valores[2]);
        date = LocalDate.of(ano, mes, dia);
    }
    
    public LocalDate getDate(){
        return date;
    }
    
}
