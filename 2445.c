#include <stdio.h>

int main(){
	int n;

	scanf("%d", &n);
	for(int i=0; i<n; i++){
		for(int j=0; j<=i; j++)
			printf("*");
		for(int s=2*n-2*(i+1); s>0; s--)
			printf(" ");
		for(int k=0; k<=i; k++)
			printf("*");
		printf("\n");
	}
	for(int i=n-2; i>=0; i--){
		for(int j=i; j>=0; j--)
			printf("*");
		for(int s=0; s<2*n-2*(i+1); s++)
			printf(" ");
		for(int k=i; k>=0; k--)
			printf("*");
		printf("\n");
	}
}