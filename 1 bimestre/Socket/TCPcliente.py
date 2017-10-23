

#TCP Client
import socket
HOST = '127.0.0.1' # Endereco IP do Servidor 
PORT = 5000 # Porta do Servidor
tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM) #cria o socket
dest = (HOST, PORT)
tcp.connect(dest) #conecta com o servidor
print ('Para sair use CTRL+X\n')
msg = input() #lê a mensagem
while msg != '\x18': # se for diferente de "CTRL+X" ele fica num looping
    tcp.send (msg) #envia a mesnsagem para o servidor
    msg = input() #lê a proxima mensagem
tcp.close() #fecha o socket
