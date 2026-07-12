# VetNelli API 🐾

API REST desenvolvida com Java + Spring Boot para gerenciamento de consultas veterinárias.

## 🚀 Tecnologias utilizadas

* Java 25
* Spring Boot
* Spring Web
* Spring Security
* JWT (JJWT)
* Spring Data MongoDB
* MongoDB Atlas
* Lombok
* MapStruct
* Jakarta Validation
* JUnit 5
* Mockito
* Maven

---

## 📁 Estrutura do projeto

```text
src/main/java
├── auth
├── config
├── consulta
├── enums
├── exception
├── mapper
├── security
├── usuario
```

---

## ⚙️ Funcionalidades

### Autenticação
* Cadastro de usuários
* Login com autenticação via JWT
* Proteção de rotas com Spring Security (sessões stateless)

### Consultas
* Cadastro de consultas
* Busca de consulta por ID
* Listagem de consultas
* Atualização de consultas
* Exclusão de consultas
* Atualização de status da consulta

### Geral
* Validações de dados
* Tratamento global de exceções
---

## 🔐 Autenticação

### POST `/auth/login`

```json
{
  "email": "usuario@email.com",
  "senha": "123456"
}
```

### Resposta

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

As demais rotas exigem o header:

```
Authorization: Bearer {token}
```

## 🧪 Testes

O projeto possui testes unitários utilizando:

* JUnit 5
* Mockito

Testando:

* Services
* Exceptions
* Regras de negócio
* Fluxos de atualização e exclusão

---

## 📦 Exemplo de requisição

### POST `/consultas`

```json
{
  "nomePet": "Lasanha",
  "idadePet": "ADULTO",
  "nomeDono": "Giovanni",
  "motivo": "Vacinação",
  "dataConsulta": "2026-05-30T14:00:00"
}
```

---

## 📤 Exemplo de resposta

```json
{
  "id": "6824b7c123456789",
  "nomePet": "Lasanha",
  "idadePet": "ADULTO",
  "nomeDono": "Giovanni",
  "motivo": "Vacinação",
  "status": "AGENDADA",
  "dataConsulta": "2026-05-30T14:00:00"
}
```

---

## ❌ Exemplos de erro

### Erro de validação (400)

```json
{
  "status": 400,
  "message": "Data da consulta inválida",
  "timestamp": "2026-05-21T01:30:00"
}
```

### Erro de autenticação (401)

```json
{
  "status": 401,
  "message": "Credenciais inválidas",
  "timestamp": "2026-07-12T14:22:00"
}
```

### Erro de token expirado ou inválido (401)

```json
{
  "status": 401,
  "message": "Token inválido ou expirado",
  "timestamp": "2026-07-12T14:25:00"
}
```

### Recurso não encontrado (404)

```json
{
  "status": 404,
  "message": "Consulta não encontrada",
  "timestamp": "2026-07-12T14:30:00"
}
```
##  Arquitetura do Projeto

Interface web desenvolvida em React.

🔗 Frontend: https://github.com/GiovanniCainelli/VetNelli-Front

Principais Funcionalidades: 

- Cadastro de consultas veterinárias
- Listagem de consultas cadastradas
- Busca de consultas pelo nome do responsável
- Edição de consultas em tempo real
- Atualização de status da consulta
- Exclusão de consultas
- Validação de formulários
- Exibição de mensagens de erro da API
- Interface responsiva para desktop e dispositivos móveis
- Integração com API REST desenvolvida em Spring Boot

---

## ▶️ Como executar

### Clone o projeto

```bash
git clone https://github.com/GiovanniCainelli/vet-Nelli-API.git
```

### Entre na pasta

```bash
cd vet-Nelli-API
```

### Configure a variável de ambiente

```env
MONGO_URI=sua_uri_mongodb
```

### Execute o projeto

```bash
./mvnw spring-boot:run
```

---

## 👨‍💻 Autor

Desenvolvido por Giovanni Cainelli.
