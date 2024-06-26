#include <stdio.h>
#define SIZE 1001

int DFS_arr[SIZE];
int BFS_arr[SIZE];
int queue[SIZE];
int graph[SIZE][SIZE] = {0};

void dfs(int v, int n){
	DFS_arr[v] = 1;
	printf("%d ", v);

	for(int k=1; k<=n; k++){
		if(DFS_arr[k] == 0 && graph[v][k] == 1)
			dfs(k, n);
	}
}

void bfs(int v, int n){
	int front, rear, pop;

	front=rear=0;

	BFS_arr[v] = 1;
	queue[front] = v;	rear++;
	printf("%d ", v);
	
	while(front < rear){
		pop = queue[front];		front++;

		for(int k=1; k<=n; k++){
			if(BFS_arr[k] == 0 && graph[pop][k] == 1){
				printf("%d ", k);
				BFS_arr[k] = 1;
				queue[rear] = k;	rear++;
			}
		}
	}
}

int main(){
	int N, M, V;
	int u, v;

	scanf("%d %d %d", &N, &M, &V);

	for(int i=1; i<=M; i++){
		scanf("%d %d", &u, &v);
		graph[u][v] = 1;
		graph[v][u] = 1;
	}

	dfs(V, N);
	printf("\n");
	bfs(V, N);
}