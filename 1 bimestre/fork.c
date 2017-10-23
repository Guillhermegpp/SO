#include<stdio.h>			//lib para usar fprintf() e perror()
#include<stdlib.h>		//lib para usar macros EXIT_SUCCESS e EXIT_FAILURE
#include<unistd.h>		//lib para usar fork(), getpid() e getppid()
#include<sys/types.h>		//lib para usar tipo pid_t
#include<sys/wait.h>		//lib para usar wait()

int global_var = 50;

int main(int argc, char *argv[]){
  pid_t child_pid;
  int status, local_var = 10;

	/* Cria processo filho */
	child_pid = fork();

	if( child_pid == 0 ){
		/* Processo filho. */
		local_var = 25;
		global_var = 91;
		fprintf(stdout, "Processo filho. meu PID: %d.\n", (int)getpid() );
		fprintf(stdout, "Processo filho. PID do meu pai: %d.\n", (int)getppid() );
		fprintf(stdout, "Processo filho. local_var: %d.\n", local_var );
		fprintf(stdout, "Processo filho. global_var: %d.\n", global_var );
		_exit(EXIT_SUCCESS);
	}
	else if( child_pid < 0 ){
		/* Se houver erro ao criar processo filho */
		perror("fork");
		exit(EXIT_FAILURE);
	}
	else{
		/* Código do processo pai continua aqui */
		/* Aguarda processo filho terminar e recebe status */
		wait(& status);

		/* Verifica se o processo filho terminou normalmente */
		/* Caso tenha terminado, imprime o status de saída do filho */
		if( WIFEXITED(status) )
			fprintf(stdout, "Status de saida do filho: %d.\n", WEXITSTATUS(status) );
		else
			fprintf(stdout, "Processo filho terminou de forma anormal.\n");

		/* Imprime dados na tela */
		fprintf(stdout, "Processo pai. meu PID: %d.\n", (int)getpid() );
		fprintf(stdout, "Processo pai. PID do meu filho: %d.\n", (int)child_pid );
		fprintf(stdout, "Processo pai. local_var: %d.\n", local_var );
		fprintf(stdout, "Processo pai. global_var: %d.\n", global_var );

	}
	return 0;
}
