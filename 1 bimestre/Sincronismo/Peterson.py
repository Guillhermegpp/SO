#Solucao Peterson
from threading import Thread
import time

#variaveis globais
global turn, i, j, flag

#Função para simular seção critica 
#com um tempo para finalizar
def regiaoCritica():
    time.sleep(1)

#Função do primeiro processo
def processamentoA(times, delay):
    global turn, i, j, flag
    #para cada iteração ...
    for x in range(times):
        print ("Secao de Entrada A - ",x+1)  
        #Flag posicao 0 (Processo A) é verdadeiro
        flag[i] = True
        #J é para processo B
        turn = j
        #Espera até o outro processo sair da seção critica, 
        #(espera até uma das duas condiçoes ser falsa)
        while (flag[j] and turn == j):
            continue
        print ("Regiao Critica A")
        #chama a função da seção critica
        regiaoCritica()
        print ("Secao de Saida A")
        #Após sair da seção critica, caso o outro processo esteja 
        #esperando, da a vez para ele. Se o outro ainda estiver 
        #na seção nao critica, esse processo chama a seção 
        #critica novamente
        flag[i] = False
        print ("Regiao nao critica A\n")
        #Simula a seção nao critica, 
        #com o tempo determinado na main
        time.sleep(delay)    

#Função do segundo processo
def processamentoB(times, delay):
    global turn, i, j, flag
    #para cada iteração ...
    for x in range(times):
        print ("Secao de Entrada B - ",x+1)
        #Flag posicao 1 (Processo B) é verdadeiro
        flag[j] = True
        #I é para processo A
        turn = i        
        #Espera até o outro processo sair da seção critica, 
        #(espera até uma das duas condiçoes ser falsa)
        while (flag[i] and turn == i):
            continue
        print ("Regiao Critica B")    
        #chama a função da seção critica    
        regiaoCritica()
        print ("Secao de Saida B")
        #Após sair da seção critica, caso o outro processo esteja 
        #esperando, da a vez para ele. Se o outro ainda estiver 
        #na seção nao critica, esse processo chama a seção 
        #critica novamente
        flag[j] = False
        print ("Regiao nao critica B\n")
        #Simula a seção nao critica, 
        #com o tempo determinado na main
        time.sleep(delay)


print ("Exemplo de Solucao de Peterson")
#Define a quantidade de iterações
execTimes = 5
turn = 0
#I é para processo A
i = 0
#J é para processo B
j = 1
flag = []
#inicia a flag com as posições falsas
flag.append(False)
flag.append(False)

#Cria as thread dos processos com os parametros de quantidade 
#de iteração e tempo que a seção nao critica ficará rodando
tA = Thread(target=processamentoA, args=(execTimes,1,))
#inicia a thread
tA.start()
tB = Thread(target=processamentoB, args=(execTimes,5,))
tB.start()