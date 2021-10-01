import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Ordenacao {
    static void geraVetor (int[] v, int limite) {
        Random random = new Random();
        for (int i=0; i<v.length; i++) v[i] = random.nextInt(limite);
    }
    static void mostraVetor(int[] v, String msg) {
        System.out.println(msg);
        for (int i=0; i<v.length; i++) System.out.print(v[i] + " ");
        System.out.println();
    }

    //selection
    static void Selection (int n, int v[]){
        for(int i=0; i<n-1; i++){
            int min = i;
            for(int j = i+1; j<n; j++){
                if(v[j] < v[min]){
                    min=j;
                    int x=v[i]; v[i] = v[min]; v[min]=x;
                }
            }

        }
    }

    //Insertion
    static void Insertion (int n, int v[]){
        for (int j=1; j<n; ++j){
            int x = v[j];
            int i;
            for(i=j-1; i>=0 && v[i] > x; i--)
            v[i+1] = v[i];
        }
    }


    //Bubble
    static void bubble (int[] v) {
        for (int i=1; i<v.length; i++) {
            for (int j=0; j<v.length-i; j++) {
                if (v[j] > v[j+1]) {
                    int temp = v[j];
                    v[j] = v[j+1];
                    v[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("digite o tamanho do vetor: ");
        int n = entrada.nextInt();
        System.out.print("digite o limite de geracao: ");
        int limite = entrada.nextInt();
        int[] v = new int[n];
        geraVetor(v, limite);
        //mostraVetor (v, "Vetor gerado:");
        System.out.println("ordenando vetor...");
        
        Date date = new Date();
        long ini = date.getTime();
        //bubble(v);
        Insertion(n, v);
        //Selection(n, v);
        long fim = new Date().getTime();

        System.out.println("o Inserction demorou " + (fim-ini) + "ms para tamanho " + n);
        
        //mostraVetor(v, "vetor ordenado:");
        entrada.close();
    }
}
