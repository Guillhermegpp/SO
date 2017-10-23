#Servidor TCP
import socket
from threading import Thread

#Função
def conexao(con,cli):
    while True:
        msg = con.recv(1024)
        if not msg: break
        print (msg)
    print ('Finalizando conexao do cliente', cli)
    con.close() 

# Endereco IP do Servidor
HOST = ''
# Porta que o Servidor vai escutar
PORT = 5002
#Cria o socket
tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
#Faz a junção do host com a porta
orig = (HOST, PORT)

tcp.bind(orig) #ligação do tcp com o host e a porta
tcp.listen(1)

while True:
    con, cliente = tcp.accept()
    print ('Concetado por ', cliente)
    t = Thread(target=conexao, args=(con,cliente,))
    t.start() #inicia a thread
