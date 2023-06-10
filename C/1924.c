#include <stdio.h>

int main(){
	int mm, dd;
	int month[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	char *day[7] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	
	scanf("%d %d", &mm, &dd);
	for(int i=0; i < mm - 1; i++){
		dd += month[i];
	}

	printf("%s\n", day[dd % 7]);
}