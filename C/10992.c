#include <stdio.h>

int main() {
	int n;
	int i, j, k;

	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		for (j = 0; j < n - (i + 1); j++) {
			printf(" ");
		}
		
		if (i == 0)
			printf("*\n");
		else if (i == n - 1) {
			for (i = 0; i < 2 * n - 1; i++)
				printf("*");
		}
		else {
			for (k = 0; k < 2 * (i + 1); k++) {
				if (k == 0 || k == 2 * (i + 1) - 2)
					printf("*");
				else
					printf(" ");
			}
			printf("\n");
		}
	}
}