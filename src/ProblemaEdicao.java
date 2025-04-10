public class ProblemaEdicao {

    
    public static void main(String[] args) {
        String s1 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to simplify the build processes in the Jakarta Turbine project. There were several projects, each with their own Ant build files, that were all slightly different. JARs were checked into CVS. We wanted a standard way to build the projects, a clear definition of what the project consisted of, an easy way to publish project information and a way to share JARs across several projects. The result is a tool that can now be used for building and managing any Java-based project. We hope that we have created something that will make the day-to-day work of Java developers easier and generally help with the comprehension of any Java-based project.";
        String s2 =  "This post is not about deep learning. But it could be might as well. This is the power of kernels. They are universally applicable in any machine learning algorithm. Why you might ask? I am going to try to answer this question in this article. Go to the profile of Marin Vlastelica Pogančić Marin Vlastelica Pogančić Jun";

        System.out.println(edicao(s1, s2, s1.length(), s2.length()));
    }
    
    public static int edicao(String S, String T, int i, int j){
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


}
