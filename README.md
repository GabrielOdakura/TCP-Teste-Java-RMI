# Java Network Calculator

Descrição
---------
Este projeto demonstra, de forma simples, a comunicação entre dois computadores em uma rede local utilizando o protocolo TCP em Java. O cliente envia ao servidor um objeto serializável que representa uma operação matemática (dois operandos e um operador). O servidor processa a operação e retorna o resultado ao cliente.

Tecnologias
-----------
- Java SE (Socket API)
- Protocolo TCP
- Serialização de objetos (`Serializable`)

Conteúdo do repositório
-----------------------
- `Operation.java` — Classe serializável que representa a operação matemática (campos: `a`, `b`, `operator`).
- `Server.java` — Aplicação servidor: aguarda conexões, recebe um objeto `Operation`, realiza o cálculo e devolve o resultado.
- `Client.java` — Aplicação cliente: cria e envia um objeto `Operation` para o servidor e exibe o resultado retornado.

Requisitos
----------
- JDK (Java SE) instalado (versão compatível com compilação e execução de arquivos `.java`).
- Dois computadores conectados na mesma rede local (um atuando como servidor e outro como cliente).

Como executar
-------------

1. Determine o IP do computador que será o servidor:
   - Linux: `hostname -I`
   - Windows: `ipconfig`

2. No computador que será o servidor:
   - Compile:
     ```bash
     javac Operation.java Server.java
     ```
   - Execute:
     ```bash
     java Server
     ```
   - O servidor aguarda conexões na porta padrão 5000 (pode ser alterada diretamente no código, se necessário).

3. No computador que será o cliente:
   - Copie `Operation.java` (mesma definição do servidor).
   - No código do cliente, atualize o endereço do servidor substituindo `SERVER_IP` pelo IP real do servidor. Exemplo:
     ```java
     Socket socket = new Socket("192.168.x.x", 5000);
     ```
   - Compile e execute:
     ```bash
     javac Operation.java Client.java
     java Client
     ```

Exemplo de execução esperada
---------------------------
- Saída do servidor (exemplo):
  ```
  Received: 10 + 5
  ```
- Saída do cliente (exemplo):
  ```
  Result from server: 15
  ```

Observações e limitações
------------------------
- Este projeto foi testado entre máquinas Windows e Linux na mesma rede local.
- A comunicação é baseada em TCP, garantindo entrega confiável e ordenada dos dados.
- A porta padrão utilizada é a 5000; altere-a nos arquivos de código se necessário.
- O projeto é um exemplo didático e não implementa controles avançados de segurança, autenticação nem tratamento de múltiplas conexões concorrentes além do comportamento já presente no código.

Contribuições e uso
-------------------
- Este repositório serve como base de estudo e demonstração. Para adaptar ou estender o projeto, edite os arquivos `.java` conforme necessário e recompilile.