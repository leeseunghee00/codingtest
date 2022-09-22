#include <stdio.h>

int main(){
	int n;

	scanf("%d", &n);
	for(int i=0; i<n; i++){
		for(int j=n-1-i; j>0; j--)
			printf(" ");
		for(int k=0; k<=i; k++)
			printf("*");
		printf("\n");
	}
	for(int i=n-2; i>=0; i--){
		for(int j=0; j<n-1-i; j++)
			printf(" ");
		for(int k=i; k>=0; k--)
			printf("*");
		printf("\n");
	}
}