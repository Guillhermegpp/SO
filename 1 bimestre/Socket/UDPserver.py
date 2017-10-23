


#UDP Server
import socket
HOST = '' # Endereco IP do Servidor // Vazio == LocalHost
PORT = 5000 #Porta do Servidor
udp = socket.socket(socket.AF_INET,socket.SOCK_DGRAM) # criação do socket
orig = (HOST, PORT)
udp.bind(orig)
while True: 
    msg, cliente = udp.recvfrom(1024)   #recebe os dados do cliente(mensagem e ID)
    print (cliente, msg) #imprime o identificador do cliente e a mensagem
udp.close()#Fecha o socket
