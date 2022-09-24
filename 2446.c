#include <stdio.h>

int main() {
	int n;

	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		if (i > 0) {
			for (int k = 0; k < i; k++) {
				printf(" ");
			}
		}
		for (int j = 2 * (n - i) - 1; j > 0; j--) {
			printf("*");
		}
		printf("\n");
	}
	
	for (int i = 1; i < n; i++) {
		for (int k = n - i - 1; k > 0; k--) {
			printf(" ");
		}
		for (int j = 0; j < 2 * (i + 1) - 1; j++) {
			printf("*");
		}
		printf("\n");
	}
}