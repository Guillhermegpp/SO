#Semaforo
from threading import Thread,Semaphore
import time

#Cria a instancia
s = Semaphore() 

#Função para simular seção critica 
#com um tempo para finalizar
def regiaoCritica(): 
    time.sleep(1)

#Função do primeiro processo
def processamentoA(times, delay):
    #para cada iteração ...
    for x in range(times):
        print ("Secao de Entrada A - ",x+1)    
        #método do semaforo, só deixa um processo entrar
        #por vez, nao criando conflito 
        #Se um processo ja estiver nessa regiao, ele aguarda.          
        s.acquire()
        print ("Regiao Critica A")  
        #chama a função da seção critica       
        regiaoCritica()
        print ("Secao de Saida A")
        #Libera a vez, para que outro processo possa entrar
        #na seção critica
        s.release()
        print ("Regiao nao critica A\n")
        #Simula a seção nao critica, 
        #com o tempo determinado na main
        time.sleep(delay)    

#Função do segundo processo
def processamentoB(times, delay):
    #para cada iteração ...
    for x in range(times):
        print ("Secao de Entrada B - ",x+1)
        #método do semaforo, só deixa um processo entrar
        #por vez, nao criando conflito.
        #Se um processo ja estiver nessa regiao, ele aguarda.         
        s.acquire()
        print ("Regiao Critica B")    
        #chama a função da seção critica 
        regiaoCritica()
        print ("Secao de Saida B")
        #Libera a vez, para que outro processo possa entrar
        #na seção critica
        s.release()
        print ("Regiao nao critica B\n")
        #Simula a seção nao critica, 
        #com o tempo determinado na main
        time.sleep(delay)


print ("Exemplo de Estrita Aternancia")
#inicia a flag com as posições falsas
execTimes = 5

#Cria as thread dos processos com os parametros de quantidade 
#de iteração e tempo que a seção nao critica ficará rodando
tA = Thread(target=processamentoA, args=(execTimes,1,))
#inicia a thread
tA.start()
tB = Thread(target=processamentoB, args=(execTimes,5,))
tB.start()
