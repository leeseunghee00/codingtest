/*백준 2562번*/
#include <stdio.h>

int main(){
    int N,count;
    int max=0;

    for(int i=0; i<9; i++){
        scanf("%d", &N);
        if(N>max){
            max=N;
            count=i+1;
        }
    }

    printf("%d\n%d\n", max, count);

    return 0;
}