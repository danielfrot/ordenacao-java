package ordenacao;

import java.util.Random;

public class Ordenacao {

    public static void main(String[] args) {
        long tempoInicialPreencher = System.currentTimeMillis(); // captura o tempo no instante em que inicia o preenchimento do vetor
        
        int[] vetor = new int[1000]; // quantidade de posições do vetor
        
        //preencherCrescente(vetor);
        //preencherDecrescente(vetor);
        preencherAleatorio(vetor);
        
        mostrar(vetor);
        System.out.println("Vetor criado em: " + (System.currentTimeMillis() - tempoInicialPreencher) + " ms."); // captura o tempo no instante em que termina o preenchimento do vetor
        
        long tempoInicialselectionSort = System.currentTimeMillis(); // captura o tempo no instante em que inicia a execução do método
        selectionSort(vetor);
        System.out.println("o metodo selectionSort executou em: " + (System.currentTimeMillis() - tempoInicialselectionSort) + " ms."); // captura o tempo no instante em que termina a execução do método
        
        long tempoInicialbubbleSort = System.currentTimeMillis(); // captura o tempo no instante em que inicia a execução do método
        bubbleSort(vetor);
        System.out.println("o metodo bubbleSort executou em: " + (System.currentTimeMillis() - tempoInicialbubbleSort) + " ms."); // captura o tempo no instante em que termina a execução do método
        
        long tempoInicialinsertionSort = System.currentTimeMillis(); // captura o tempo no instante em que inicia a execução do método
        insertionSort(vetor);
        System.out.println("o metodo insertionSort executou em: " + (System.currentTimeMillis() - tempoInicialinsertionSort) + " ms."); // captura o tempo no instante em que termina a execução do método
        
        long tempoInicialquickSort = System.currentTimeMillis(); // captura o tempo no instante em que inicia a execução do método
        quickSort(vetor, 0, vetor.length-1);
        System.out.println("o metodo quickSort executou em: " + (System.currentTimeMillis() - tempoInicialquickSort) + " ms."); // captura o tempo no instante em que termina a execução do método
        
        System.out.println("Finalizado.");
        
    }
    
    
    
    public static void selectionSort(int[] vetor) { // ordena seleção
        for (int i = 0; i < vetor.length - 1; i++) {  
            int menor = i;  
            for (int j = i + 1; j < vetor.length; j++){  
                if (vetor[j] < vetor[menor]){  
                    menor = j;
                }  
            }  
            trocar(vetor, i, menor);
        }
    }
    
    public static void bubbleSort(int[] vetor) { // ordena bolha
        for (int i = vetor.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (vetor[j - 1] > vetor[j]) {
                    trocar(vetor, j, j-1);
                }
            }
        }
    }
    
    public static void insertionSort(int[] vetor) { // ordena inserção
        for (int i = 0; i < vetor.length; i++) {
            int a = vetor[i];
            for (int j = i - 1; j >= 0 && vetor[j] > a; j--) {
                vetor[j + 1] = vetor[j];
                vetor[j] = a;
            }
        }
    }
    
    public static void quickSort(int vetor[], int esquerda, int direita) { // ordena rápido
        int esq = esquerda;
        int dir = direita;
        int pivo = vetor[(esq + dir) / 2];
        int troca;
        while (esq <= dir) {
            while (vetor[esq] < pivo) {
                    esq = esq + 1;
            }
            while (vetor[dir] > pivo) {
                    dir = dir - 1;
            }
            if (esq <= dir) {
                    troca = vetor[esq];
                    vetor[esq] = vetor[dir];
                    vetor[dir] = troca;
                    esq = esq + 1;
                    dir = dir - 1;
            }
        }
        if (dir > esquerda){
            quickSort(vetor, esquerda, dir);
        }
        if (esq < direita){
            quickSort(vetor, esq, direita);
        }
    }
    
    public static void preencherCrescente(int[] vetor) { //preencher Crescente -> melhor caso
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i+1;
        }
    }
    
    public static void preencherDecrescente(int[] vetor) { //preencher Decrescente -> pior caso    
        int temp = 0;
        for (int i = 0; i < vetor.length /2; i++) {
            temp = vetor[vetor.length - 1];
            vetor[vetor.length - 1] = vetor[i];
            vetor[i] = temp;
        }
    }
    
    public static void preencherAleatorio(int[] vetor) { //preencher Aleatório
        Random r = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = r.nextInt(20);
        }
    }
    
    public static void mostrar(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("\n");
    }
    
    public static void trocar(int[] vetor, int a, int b) { //trocar
        int aux = vetor[a];   
        vetor[a] = vetor[b];  
        vetor[b] = aux;  
    }
    
}
