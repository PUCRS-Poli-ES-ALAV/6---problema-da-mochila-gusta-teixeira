public class ProblemaEdicao {

    public static int iter = 0;
    public static void main(String[] args) {
        
        String s1 = "Casablanca";
        String s2 = "Portentoso";
        System.out.println("ALGORITMO ---------------------- TEMPO (s) ----------------- RESULTADO -------------- ITERACOES");
        long start = System.nanoTime();
        int result = edicao(s1, s2, s1.length(), s2.length());
        long end = System.nanoTime();
        
        System.out.printf("Edicao recursivo ---------------  %.9f ---------------- %d -------------- %d\n", (end-start)*(1e-9), result, iter);

        System.out.printf("Edicao recursivo --------------- NAO TERMINA\n");

        iter = 0;
        start = System.nanoTime();
        result = edicaoDinamica(s1, s2);
        end = System.nanoTime();
        System.out.printf("Edicao dinamica ---------------  %.9f ---------------- %d -------------- %d\n", (end-start)*(1e-9), result, iter);


        s1 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to simplify the build processes in the Jakarta Turbine project. There were several projects, each with their own Ant build files, that were all slightly different. JARs were checked into CVS. We wanted a standard way to build the projects, a clear definition of what the project consisted of, an easy way to publish project information and a way to share JARs across several projects. The result is a tool that can now be used for building and managing any Java-based project. We hope that we have created something that will make the day-to-day work of Java developers easier and generally help with the comprehension of any Java-based project.";
        s2 =  "This post is not about deep learning. But it could be might as well. This is the power of kernels. They are universally applicable in any machine learning algorithm. Why you might ask? I am going to try to answer this question in this article. Go to the profile of Marin Vlastelica Pogančić Marin Vlastelica Pogančić Jun";

        iter = 0;

        start = System.nanoTime();
        result = edicaoDinamica(s1, s2);
        end = System.nanoTime();
        System.out.printf("Edicao dinamica ---------------  %.9f ---------------- %d -------------- %d\n", (end-start)*(1e-9), result, iter);




    }
    
    
    public static int edicao(String S, String T, int i, int j){
        iter++;
        if(i == 0 && j == 0){
            return 0;
        }
        else if(i == 0){
            return T.length();
        }
        else if(j == 0){
            return S.length();
        }

        if(S.charAt(i-1) == T.charAt(j-1)){
            return edicao(S, T, i-1, j-1);
        }
        int sub = edicao(S, T, i-1, j-1) + 1;
        int ins = edicao(S, T, i, j-1) + 1;
        int rem = edicao(S, T, i-1, j) + 1;
        return Math.min(sub, Math.min(ins,rem));

    }


    public static int edicaoDinamica(String S, String T){
        iter++;
        int m = S.length();
        int n = T.length();
        int matriz[][] = new int[m+1][n+1];
        matriz[0][0] = 0;

        for(int i = 1; i < m; i++){
            iter++;
            matriz[i][0] = matriz[i-1][0] + 1;
        }

        for(int j = 1; j < n; j++){
            iter++;
            matriz[0][j] = matriz[0][j-1] + 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                iter++;
                int custoExtra;
                if(S.charAt(i) == T.charAt(j)){
                    custoExtra = 0;
                }else{
                    custoExtra = 1;
                }
                matriz[i][j] = Math.min(matriz[i-1][j] +1, Math.min(matriz[i][j-1] +1, matriz[i-1][j-1] + custoExtra));
            }
        }

        return matriz[m-1][n-1] + 1;

    }

}
