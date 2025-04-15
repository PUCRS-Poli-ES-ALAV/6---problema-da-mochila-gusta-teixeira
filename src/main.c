#include <stdio.h>
#include <math.h>

#define MIN(a, b) ((a) < (b) ? (a) : (b))
#define MAX(a, b) ((a) > (b) ? (a) : (b))

const int sLen = 721;
const int tLen = 320;

int edicao(char* S, char* T, int s, int t);

int edicaoDin();


void main(){
    char* S = "Casablanca";
    char* T = "Portentoso";
    char* s1 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to simplify the build processes in the Jakarta Turbine project. There were several projects, each with their own Ant build files, that were all slightly different. JARs were checked into CVS. We wanted a standard way to build the projects, a clear definition of what the project consisted of, an easy way to publish project information and a way to share JARs across several projects. The result is a tool that can now be used for building and managing any Java-based project. We hope that we have created something that will make the day-to-day work of Java developers easier and generally help with the comprehension of any Java-based project.";
    char* s2 =  "This post is not about deep learning. But it could be might as well. This is the power of kernels. They are universally applicable in any machine learning algorithm. Why you might ask? I am going to try to answer this question in this article. Go to the profile of Marin Vlastelica Pogančić Marin Vlastelica Pogančić Jun";
  

    printf("%d\n", edicao(S, T, 10,10));

    printf("%d\n", edicao(s1,s2,sLen, tLen));

}


int edicao(char* S, char* T, int i, int j){
    if(i == 0 && j == 0){
        return 0;
    }
    else if(i == 0){
        return j;
    }
    else if(j == 0){
        return i;
    }

    if(S[i-1] == T[j-1]){
        return edicao(S, T, i-1, j-1);
    }
    int sub = edicao(S, T, i-1, j-1) + 1;
    int ins = edicao(S, T, i, j-1) + 1;
    int rem = edicao(S, T, i-1, j) + 1;
    
    return MIN(sub, MIN(ins,rem));
}