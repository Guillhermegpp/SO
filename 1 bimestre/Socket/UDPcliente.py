

#UDP Client
import socket
#HOST = '127.0.0.1' # Endereco IP do Servidor
PORT = 5000 # Porta do Servidor
udp = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)# criação do socket
dest = (HOST, PORT) 
print ('Para sair use CTRL+X\n')
msg = input() #lê a mensagem
while msg != '\x18': # se for diferente de "CTRL+X" ele fica num looping
    udp.sendto (msg.encode(), dest) #pega a mensagem e envia para o 
                                    #destinatario, que é o ip e a porta
    msg = input()#lê uma nova mensagem
udp.close()#fecha o socket








