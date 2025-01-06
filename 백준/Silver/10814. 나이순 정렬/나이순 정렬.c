#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int age;
	int idx;
	char name[101];
} Member;


int compare(Member* a, Member* b) {
    return (a->age > b->age ? 1 : (a->age < b->age ? -1: 0));
}

int main(){
	int n;
	scanf("%d", &n);

	Member *m;
	m = (Member *)malloc(sizeof(Member) * n);

	for(int i=0; i<n; i++){
		scanf("%d %s", &m[i].age, m[i].name);
		m[i].idx = i; 
	}

	qsort(m, n, sizeof(Member), compare);

	for(int i=0; i<n; i++){
		printf("%d %s\n", m[i].age, m[i].name);
	}

	return 0;
}