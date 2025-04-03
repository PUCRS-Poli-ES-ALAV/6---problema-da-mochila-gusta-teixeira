import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        int [][] itens = {{0,0},{5, 2}, {2,2}, {2,4}, {1,3}}; //i = peso,  j = valor
        System.out.println(backPackPd(itens.length, 9, itens));
    }

    public static int backPackPd(int n, int c, int[][] itens){
        final int N = n;
        final int C = c;
        int iter = 1;
        int [][] maxTab = new int[N+1][C+1]; 

        for(int i = 1; i < N; i++){
            for(int j = 1; j < C; j++){
                iter++;
                if(itens[i][0] <= j){
                    maxTab[i][j] = Math.max(maxTab[i-1][j], itens[i][1] + maxTab[i-1][j-itens[i][0]]);
                }else{
                    maxTab[i][j] = maxTab[i-1][j];
                }
                }
            }

        for(int[] i : maxTab){
            System.out.println(Arrays.toString(i));
        }
        System.out.println("iteracoes: " + iter);
        return maxTab[N-1][C-1];
        }
}
