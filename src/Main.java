
public class Main{
    public static int iter = 0;
    public static int instru = 0;

    public static void main(String[] args) {
        int[] capacidades = {9, 165, 190};
        int[][][] valores = {{{0,0},{5, 2}, {2,2}, {2,4}, {1,3}}
        ,{
            {0, 0},
            {56, 50},
            {59, 50},
            {80, 64},
            {64, 46},
            {75, 50},
            {17, 5}
        },
        {
            {0, 0},
            {23, 92},
            {31, 57},
            {29, 49},
            {44, 68},
            {53, 60},
            {38, 43},
            {63, 67},
            {85, 84},
            {89, 87},
            {82, 72}
        }};

        
        System.out.printf("%5s | %10s | %10s | %12s | %15s\n", "n", "Resultado", "Iterações", "Instruções", "Tempo (s)");
        int j = 0;
        
        System.out.println("----------------------------------------------------------------------");

        for(int [][] itens : valores){
            iter = 0;
            instru = 0;
            long inicio = System.nanoTime();
            long result = backpack_forcabruta(itens,capacidades[j]);
            long fim = System.nanoTime();
            long tempo = fim - inicio;
            System.out.printf("%5d | %10d | %10d | %12d | %.12f\n", capacidades[j], result, iter, instru, tempo*1e-9);
            j++;

        }

    }

    static int backpack_forcabruta(int[][] itens, int capacidade) {
        int n = itens.length;
        int melhorValor = 0;

        int totalComb = (int) Math.pow(2, n);

        for (int i = 0; i < totalComb; i++) {
            int pesoTotal = 0;
            int valorTotal = 0;

            for (int j = 0; j < n; j++) {
                if (((i / (int) Math.pow(2, j)) % 2) == 1) {
                    pesoTotal += itens[j][0];
                    valorTotal += itens[j][1];
                }
            }

            if (pesoTotal <= capacidade && valorTotal > melhorValor) {
                melhorValor = valorTotal;
            }
        }

        return melhorValor;
    }
    public static int backPackPd(int n, int c, int[][] itens){
        final int N = n;
        instru++;
        final int C = c;
        instru++;
        iter++;
        int [][] maxTab = new int[N+1][C+1]; 
        instru++;

        for(int i = 1; i < N; i++){
            for(int j = 1; j < C; j++){
                iter++;
                if(itens[i][0] <= j){
                    instru++;
                    maxTab[i][j] = Math.max(maxTab[i-1][j], itens[i][1] + maxTab[i-1][j-itens[i][0]]);
                }else{
                    instru++;
                    maxTab[i][j] = maxTab[i-1][j];
                }
                }
            }

        
        return maxTab[N-1][C-1];
        }

}
