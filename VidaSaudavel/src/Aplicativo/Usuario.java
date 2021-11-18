package Aplicativo;

public class Usuario {
    
    // Atributos:
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private String sexo;
    private String categoria;
    
    // Construtor:
    public Usuario(String nome, int idade, double peso, double altura,
                   String sexo, String categoria) {
        setNome(nome);
        setIdade(idade);
        setPeso(peso);
        setAltura(altura);
        setSexo(sexo);
        setCategoria(categoria);
    }

    // Métodos:
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
