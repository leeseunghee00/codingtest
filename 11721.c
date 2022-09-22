#include <stdio.h>
#include <string.h>

int main() {
	char str[100];
	int len;

	scanf("%s", str);
	len = strlen(str);

	for (int i = 0; i < len; i++) {
		if (i % 10 == 0 && i != 0) {
			printf("\n");
			printf("%c", str[i]);
		}
		else
			printf("%c", str[i]);
	}
}