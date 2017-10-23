


#TCP Server
import socket
HOST = '' # Endereco IP do Servidor // Vazio == LocalHost
PORT = 5555 # Porta do Servidor
tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)#cria o socket
orig = (HOST, PORT) #Faz a ligação do IP com a Porta
tcp.bind(orig)
tcp.listen(1)
while True: 
    con, cliente = tcp.accept() #Conecta com um cliente
    print ('Concetado por', cliente)
    while True: 
        msg = con.recv(1024) #recebe a mensagem do cliente
        if not msg: break #Se nao houver mensagem ele sai do laço
        print (cliente, msg) #imprime quem mandou e a mensagem
    print ('Finalizando conexao do cliente', cliente)
    con.close()#fecha o socket
