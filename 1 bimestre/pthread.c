#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
//Cria uma constante para o limite de threads
#define N_THREADS 10

void *print_hello_world(void *tid){
	//Essa função imprime o identificador do thread e sai.
	printf("Olá Mundo. Thread n: %d\n",tid);
	//Conclui a chamada thread.
	pthread_exite(NULL);
}

int main(int arc, char *argv[]){
	//Criando um vetor para a criação de até 10 threads.
	pthread_t threads[N_THREADS]; 
	int status, i;
	
	//Popular as 10 threads.
	for(i = 0 ;i < N_THREADS;i++){//
		printf("Principal. Criando a thread n. %d\n",i);
		//Status recebe a criação de uma nova thread e imprime qual id dela.
		status = pthread_criate(&threads[i],NULL,print_hello_world,(*void)i);
		//Caso nao seja criado a thread, retorna uma mensagem avisando
		if (status != 0){
			printf("Nao foi possivel criar uma nova thread. Codigo de erro: %d\n",status);
			exit(-1);
		}
	}
	exit(NULL);
}




