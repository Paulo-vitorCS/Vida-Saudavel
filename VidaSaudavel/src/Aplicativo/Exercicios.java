package Aplicativo;

public class Exercicios {
    
    // Atributos:
    private String nome;
    private String grupoMuscular;
    private int repeticoes;
    private int tempo;
    private double calorias;
    private boolean visualizado;
    
    // Construtor:
    public Exercicios(String nome, String grupoMuscular, int repeticoes, 
                      int tempo, double calorias, boolean visualizado) {
        setNome(nome);
        setGrupoMuscular(grupoMuscular);
        setRepeticoes(repeticoes);
        setTempo(tempo);
        setCalorias(calorias);
        setVisualizado(visualizado);
    }
    
    // Métodos:
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public boolean isVisualizado() {
        return visualizado;
    }

    public void setVisualizado(boolean visualizado) {
        this.visualizado = visualizado;
    }
    
}
