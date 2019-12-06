
package ordenacao;

import java.util.Random;

public class Ordenacao {

    public static void main(String[] args) {
        int[] vetor = new int[1000000];
        fill(vetor);
        System.out.println("Vetor criado:");
        show(vetor);
        // tempo inicial
        //selectionSort(vetor);
        //bubbleSort(vetor);
        quickSort(vetor, 0, vetor.length-1);
        // tempo final
        System.out.println("Finalizado.");
    }
    
    public static void selectionSort(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {  
            int menor = i;  
            for (int j = i + 1; j < vetor.length; j++){  
                if (vetor[j] < vetor[menor]){  
                    menor = j;
                }  
            }  
            swap(vetor, i, menor);
            show(vetor);
        }  
    }
    
    public static void bubbleSort(int[] vetor) {
        for (int i = vetor.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (vetor[j - 1] > vetor[j]) {
                    swap(vetor, j, j-1);
                }
            }
            show(vetor);
        }
    }
    
    public static void quickSort(int vetor[], int esquerda, int direita) {
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
        if (dir > esquerda)
            quickSort(vetor, esquerda, dir);

        if (esq < direita)
            quickSort(vetor, esq, direita);
    }
    
    public static void fill(int[] vetor) {
        Random r = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = r.nextInt(20);
        }
    }
    
    public static void show(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i] + " ");
        }
        System.out.println("");
    }
    
    public static void swap(int[] vetor, int a, int b) {
        int aux = vetor[a];   
        vetor[a] = vetor[b];  
        vetor[b] = aux;  
    }
}