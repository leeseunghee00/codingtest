#include <stdio.h>
#include <limits.h>

int main(){
	int min = INT_MAX, max = INT_MIN;
	int N, num;

	scanf("%d", &N);
	for(int i=0; i<N; i++){
		scanf("%d", &num);
		
		if (max < num)	max = num;
		if (min > num)	min = num;
	}
	printf("%d %d\n", min, max);
}