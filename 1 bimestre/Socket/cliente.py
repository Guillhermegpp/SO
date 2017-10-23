#Cliente TCP
import socket
# Endereco IP do Servidor
SERVER = '172.16.1.57'
# Porta que o Servidor esta escutando
PORT = 5002
tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM) #Cria o socket
dest = (SERVER, PORT) 
tcp.connect(dest)#Faz a conexão
print ('Para sair use CTRL+X\n')
msg = input() # Recebe a mensagem
while msg != '\x18': #Loop até apertar Ctrl+X
    tcp.send (msg.encode()) #Envia a mensagem para o servidor
    msg = input()
tcp.close() #Fecha a conexão



