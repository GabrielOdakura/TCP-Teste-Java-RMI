# Java Network Calculator

Este é um projeto simples em Java que demonstra a comunicação entre **dois computadores em rede local** utilizando o **protocolo TCP**.  
O cliente envia um objeto contendo dois números e um operador matemático, e o servidor realiza o cálculo e devolve o resultado.

## 🧩 Tecnologias utilizadas
- Java SE (Socket API)
- Protocolo **TCP**
- Serialização de objetos (`Serializable`)

## ⚙️ Estrutura do projeto
O projeto contém três classes principais:

- `Operation.java` — Classe serializável que representa a operação matemática (`a`, `b`, `operator`)
- `Server.java` — Servidor que recebe a operação, calcula e devolve o resultado
- `Client.java` — Cliente que envia a operação e recebe o resultado

## 💻 Como executar

### 1. Configurar os dois computadores
- Ambos devem estar na **mesma rede local** (Wi-Fi ou cabo).
- Descubra o **endereço IP** do computador que será o **servidor**:
    - **Linux:** `hostname -I`
    - **Windows:** `ipconfig`

### 2. No servidor (Linux)
1. Compile os arquivos:
```bash
javac Operation.java Server.java
```
   
Execute o servidor:
```bash
java Server
```

Ele ficará aguardando conexões na porta 5000.

3. No cliente (Windows)

Copie o mesmo arquivo Operation.java.

No código do cliente, substitua SERVER_IP pelo IP do servidor:
```java
Socket socket = new Socket("192.168.x.x", 5000);
```


Compile e execute:
```cmd
javac Operation.java Client.java
java Client
```

4. Resultado esperado

O servidor mostrará a operação recebida:
```makefile
Received: 10 + 5
```


O cliente mostrará o resultado:

```makefile
Result from server: 15
```

📡 Observações

Este projeto utiliza TCP, garantindo entrega confiável e ordenada dos dados.

O exemplo foi testado entre Windows ↔ Linux em uma mesma rede local.

A porta padrão é 5000, mas pode ser alterada nos códigos.