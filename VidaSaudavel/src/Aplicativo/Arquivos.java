package Aplicativo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import java.util.ArrayList;

public class Arquivos {
    
    static ArrayList<Usuario> dadosUsuario = new ArrayList<>();
    static ArrayList<Treino> dadosTreino = new ArrayList<>();
    static ArrayList<Alimentacao> dadosDieta = new ArrayList<>();
    static ArrayList<Exercicios> dadosExercicios = new ArrayList<>();
    static String[] capturarDados = new String[2];
    static double caloriasTreino = 0;
    
    public static void salvarDadosUsuario(String nome, int idade, double peso, double altura,
                                          String sexo, String categoria) {
        Usuario novoUsuario = new Usuario(nome, idade, peso, altura, sexo, categoria);
        dadosUsuario.add(novoUsuario);
    }
    
    public static void salvarDadosTreino(String grupoMuscular, String data, double caloriasGastas) {
        Treino novoTreino = new Treino(grupoMuscular, data, caloriasGastas);
        dadosTreino.add(novoTreino);
    }
    
    public static void salvarDadosDieta(String refeicao, String descricao, String data, double calorias) {
        Alimentacao dieta = new Alimentacao(refeicao, descricao, data, calorias);
        dadosDieta.add(dieta);
    }
    
    // Leitura de um arquivo:
    public static String lerArquivo(String nomeArquivo){
        String texto = "", linha;
        BufferedReader arquivo = null;  // Objeto leitor
        try{
            arquivo = new BufferedReader(new FileReader(new File(nomeArquivo)));
            linha = arquivo.readLine();
            while(linha != null){
                texto += linha + "\n";
                linha = arquivo.readLine();
            }
            arquivo.close();
        }catch(java.io.IOException excecao){
            System.out.print("\nFile error: " + excecao.toString());
        }
        return texto;
    }
    
    // Escrita do arquivo com os dados do Usuário:
    public static void escreverArquivoUsuario(String nomeArquivo) {
        String texto;
        BufferedWriter escritor = null;
        try{
            escritor = new BufferedWriter(new FileWriter(new File(nomeArquivo)));
            for(Usuario aux : dadosUsuario){
                texto = aux.getNome() + ";" +
                        aux.getIdade() + ";" +
                        aux.getPeso() + ";" +
                        aux.getAltura() + ";" +
                        aux.getSexo() + ";" +
                        aux.getCategoria() + "\n";
                escritor.write(texto);
                escritor.flush();
            }
            escritor.close();
        }catch(IOException excecao){
            excecao.printStackTrace();
        }
    }
    
    // Escrita do arquivo com os dados do Treino:
    public static void escreverArquivoTreino(String nomeArquivo) {
        String texto;
        BufferedWriter escritor = null;
        try{
            escritor = new BufferedWriter(new FileWriter(new File(nomeArquivo)));
            for(Treino aux : dadosTreino){
                texto = aux.getGrupoMuscular() + ";" +
                        aux.getData() + ";" +
                        aux.getCaloriasGastas() + "\n";
                escritor.write(texto);
                escritor.flush();
            }
            escritor.close();
        }catch(IOException excecao){
            excecao.printStackTrace();
        }
    }
    
    // Escrita do arquivo com os dados de alimentação:
    public static void escreverArquivoDieta(String nomeArquivo) {
        String texto;
        BufferedWriter escritor = null;
        try{
            escritor = new BufferedWriter(new FileWriter(new File(nomeArquivo)));
            for(Alimentacao aux : dadosDieta){
                texto = aux.getRefeicao() + ";" +
                        aux.getDescricao() + ";" +
                        aux.getData() + ";" +
                        aux.getCalorias() + "\n";
                escritor.write(texto);
                escritor.flush();
            }
            escritor.close();
        }catch(IOException excecao){
            excecao.printStackTrace();
        }
    }
    
    // Escrita do arquivo com os dados dos exercicios
    public static void escreverArquivoExercicios(String nomeArquivo) {
        String texto;
        BufferedWriter escritor = null;
        try{
            escritor = new BufferedWriter(new FileWriter(new File(nomeArquivo)));
            for(Exercicios aux : dadosExercicios){
                texto = aux.getNome() + ";" +
                        aux.getGrupoMuscular() + ";" +
                        aux.getRepeticoes() + ";" +
                        aux.getTempo() + ";" +
                        aux.getCalorias() + ";" +
                        aux.isVisualizado() + "\n";
                escritor.write(texto);
                escritor.flush();
            }
            escritor.close();
        }catch(IOException excecao){
            excecao.printStackTrace();
        }
    }
    
    // Preenche o arraylist de Usuario com os dados do arquivo.
    public static void preencherDadosUsuario() {
        // Leitura do arquivo de dados
        String nomeArquivo = "DadosUsuario.txt";
        String conteudo = lerArquivo(nomeArquivo);
        if(conteudo.isEmpty()){
            escreverArquivoUsuario(nomeArquivo);
            return;
        }

        String linhas[] = conteudo.split("\n");
        for(String aux : linhas){
            String valores[] = aux.split(";");
            Usuario usuario = new Usuario(valores[0], parseInt(valores[1]), 
                    parseDouble(valores[2]), parseDouble(valores[3]), 
                    valores[4], valores[5]);
            dadosUsuario.add(usuario);
        }
    }
    
    // Preenche o arraylist de Treino com os dados do arquivo.
    public static void preencherDadosTreino() {
        // Leitura do arquivo de dados
        String nomeArquivo = "DadosTreino.txt";
        String conteudo = lerArquivo(nomeArquivo);
        if(conteudo.isEmpty()){
            escreverArquivoTreino(nomeArquivo);
            return;
        }

        String linhas[] = conteudo.split("\n");
        for(String aux : linhas){
            String valores[] = aux.split(";");
            Treino treino = new Treino(valores[0], valores[1], 
                    parseDouble(valores[2]));
            dadosTreino.add(treino);
        }
    }
    
    // Preenche o arraylist de Dieta com os dados do arquivo.
    public static void preencherDadosDieta() {
        // Leitura do arquivo de dados
        String nomeArquivo = "DadosDieta.txt";
        String conteudo = lerArquivo(nomeArquivo);
        if(conteudo.isEmpty()){
            escreverArquivoDieta(nomeArquivo);
            return;
        }

        String linhas[] = conteudo.split("\n");
        for(String aux : linhas){
            String valores[] = aux.split(";");
            Alimentacao dieta = new Alimentacao(valores[0], valores[1], 
                    valores[2], parseDouble(valores[3]));
            dadosDieta.add(dieta);
        }
    }
    
    // Preenche o arraylist de Exercicios com os dados do arquivo.
    public static void preencherDadosExercicios() {
        // Leitura do arquivo de dados
        String nomeArquivo = "DadosExercicios.txt";
        String conteudo = lerArquivo(nomeArquivo);
        if(conteudo.isEmpty()){
            escreverArquivoExercicios(nomeArquivo);
            return;
        }

        String linhas[] = conteudo.split("\n");
        for(String aux : linhas){
            String valores[] = aux.split(";");
            Exercicios exerc = new Exercicios(valores[0], valores[1], parseInt(valores[2]),
                                              parseInt(valores[3]), parseDouble(valores[4]),
                                              Boolean.parseBoolean(valores[5]));
            dadosExercicios.add(exerc);
        }
    }
    
    public static int buscarDataRefeicao(String refeicao, String data) {
        int j = -1;
        for(int i = 0; i < dadosDieta.size(); i++){
            if(data.equals(dadosDieta.get(i).getData()) && 
               refeicao.equals(dadosDieta.get(i).getRefeicao())){
                j = i;
                break;
            }
        }
        return j;
    }
    
    public static int buscarDataTreino(String grupoMuscular, String data) {
        int j = -1;
        if(!dadosTreino.isEmpty()){
            for(int i = 0; i < dadosTreino.size(); i++){
                if(data.equals(dadosTreino.get(i).getData()) && 
                   grupoMuscular.equals(dadosTreino.get(i).getGrupoMuscular())){
                    j = i;
                    break;
                }
            }
        }
        return j;
    }
    
    public static int buscaExercicio(String grupoMuscular) {
        int j = -1;
        for(int i = 0; i < dadosExercicios.size(); i++){
            if(grupoMuscular.equals(dadosExercicios.get(i).getGrupoMuscular()) && 
               dadosExercicios.get(i).isVisualizado() == false){
                j = i;
                break;
            }
        }
        return j;
    }
    
    public static void setStatusVisualizado(int num, boolean status) {
        dadosExercicios.get(num).setVisualizado(true);
    }
    
    public static void setStatusFalse(String grupoMuscular) {
        for(int i = 0; i < dadosExercicios.size(); i++){
                dadosExercicios.get(i).setVisualizado(false);
        }
    }
    
    public static double coletarCaloriasTreino(String dataInicial, String dataFinal) {
        double caloriasTotais = 0;
        
        String[] date1 = dataInicial.split("/"); 
        int dia1 = parseInt(date1[0]);
        int mes1 = parseInt(date1[1]);
        int ano1 = parseInt(date1[2]);
        
        String[] date2 = dataFinal.split("/"); 
        int dia2 = parseInt(date2[0]);
        int mes2 = parseInt(date2[1]);
        int ano2 = parseInt(date2[2]);
        
        LocalDate primeiraData = LocalDate.of(ano1, mes1, dia1);
        LocalDate ultimaData = LocalDate.of(ano2, mes2, dia2);
        
        for(int i = 0; i < dadosTreino.size(); i++) {
            String[] date3 = dadosTreino.get(i).getData().split("/"); 
            int dia3 = parseInt(date3[0]);
            int mes3 = parseInt(date3[1]);
            int ano3 = parseInt(date3[2]);
            
            LocalDate dataTreino = LocalDate.of(ano3, mes3, dia3);
            
            if(dataTreino.compareTo(primeiraData) >= 0 &&
                    dataTreino.compareTo(ultimaData) <= 0) {
                caloriasTotais = caloriasTotais + dadosTreino.get(i).getCaloriasGastas();
            }
        }
        return caloriasTotais;
    }
    
    public static double coletarCaloriasDieta(String dataInicial, String dataFinal) {
        double caloriasTotais = 0;
        
        String[] date1 = dataInicial.split("/"); 
        int dia1 = parseInt(date1[0]);
        int mes1 = parseInt(date1[1]);
        int ano1 = parseInt(date1[2]);
        
        String[] date2 = dataFinal.split("/"); 
        int dia2 = parseInt(date2[0]);
        int mes2 = parseInt(date2[1]);
        int ano2 = parseInt(date2[2]);
        
        LocalDate primeiraData = LocalDate.of(ano1, mes1, dia1);
        LocalDate ultimaData = LocalDate.of(ano2, mes2, dia2);
        
        for(int i = 0; i < dadosDieta.size(); i++) {
            String[] date3 = dadosDieta.get(i).getData().split("/"); 
            int dia3 = parseInt(date3[0]);
            int mes3 = parseInt(date3[1]);
            int ano3 = parseInt(date3[2]);
            
            LocalDate dataTreino = LocalDate.of(ano3, mes3, dia3);
            
            if(dataTreino.compareTo(primeiraData) >= 0 &&
               dataTreino.compareTo(ultimaData) <= 0) {
                caloriasTotais = caloriasTotais + dadosDieta.get(i).getCalorias();
            }
        }
        return caloriasTotais;
    }
    
}
