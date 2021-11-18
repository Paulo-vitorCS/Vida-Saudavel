package Aplicativo;

import java.time.LocalDate;

public class Treino {
    
    // Atributos:
    private String grupoMuscular;
    private String data;
    private double caloriasGastas;
    private int dia, mes, ano;
    private LocalDate date;
    
    // Construtor:
    public Treino(String tipo, String data, double calorias) {
        setGrupoMuscular(tipo);
        setData(data);
        setCaloriasGastas(calorias);
        montarData();
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getCaloriasGastas() {
        return caloriasGastas;
    }

    public void setCaloriasGastas(double caloriasGastas) {
        this.caloriasGastas = caloriasGastas;
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
