/*백준 10818번*/
#include <stdio.h>
#include <limits.h>

int main(){
    int N, k;
    int max=INT_MIN, min=INT_MAX;

    scanf("%d", &N);

    for(int i=0; i<N; i++){
        scanf("%d", &k);

        if(min>k)   min=k;
        if(max<k)   max=k;       
    }
    
    printf("%d %d \n", min, max);

    return 0;
}