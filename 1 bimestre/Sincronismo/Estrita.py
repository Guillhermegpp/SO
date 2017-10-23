#Estrita Alternância
from threading import Thread
import time

#variavel global
global turn

#Função para simular seção critica 
#com um tempo para finalizar
def regiaoCritica():
    time.sleep(1)

#Função do primeiro processo
def processamentoA(times, delay):
    global turn
    #para cada iteração ...
    for x in range(times):
        print ("Secao de Entrada A - ",x+1) 
        #Fica esperando até turn for igual a 0
        #Espera o outro processo terminar a seção critica
        while (turn != 0):
            continue
        print ("Regiao Critica A") 
        #chama a função da seção critica      
        regiaoCritica()
        print ("Secao de Saida A")
        #Da a vez para o outro processo
        turn = 1
        print ("Regiao nao critica A\n")
        #Simula a seção nao critica, 
        #com o tempo determinado na main
        time.sleep(delay)

#Função do segundo processo
def processamentoB(times, delay):
    global turn
    #para cada iteração ...
    for x in range(times):
        print ("Secao de Entrada B - ",x+1)
         #Fica esperando até turn for igual a 1
        #Espera o outro processo terminar a seção critica
        while (turn != 1):
            continue
        print ("Regiao Critica B")        
        #chama a função da seção critica 
        regiaoCritica()
        print ("Secao de Saida B")
        #Da a vez para o outro processo
        turn = 0
        print ("Regiao nao critica B\n")
        #Simula a seção nao critica, 
        #com o tempo determinado na main
        time.sleep(delay)


print ("Exemplo de Estrita Aternancia")
#Define a quantidade de iterações
execTimes = 5
#O processo A começa com a vez
turn = 0

#Cria as thread dos processos com os parametros de quantidade 
#de iteração e tempo que a seção nao critica ficará rodando
tA = Thread(target=processamentoA, args=(execTimes,1,))
#inicia a thread
tA.start()
tB = Thread(target=processamentoB, args=(execTimes,5,))
tB.start()