# 🚀 Vet Nelli API

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de consultas veterinárias.

---

##  Sobre o projeto

Este projeto tem como objetivo praticar o desenvolvimento de uma API REST utilizando Spring Boot, aplicando arquitetura em camadas e integração com banco de dados NoSQL.

A aplicação permite o gerenciamento de consultas veterinárias.

---

## 🛠️ Tecnologias utilizadas

- ☕ Java
- 🌱 Spring Boot
- 📦 Maven

---

##  Banco de dados

- 🍃 MongoDB (NoSQL)
- Spring Data MongoDB para persistência de dados

---

## 📁 Arquitetura

- Controller → Requisições HTTP
- Service → Regras de negócio
- Repository → Comunicação com o banco
- DTOs → Transferência de dados
- Exception Handler → Tratamento global de erros

 
## 🧪 Testes Unitários

Foram implementados testes unitários seguindo o padrão AAA ( Arrange , Act , Assert), utilizando JUnit 5 e Mockito, com foco na camada de serviço da aplicação (Service Layer).

Os testes validam o comportamento da lógica de negócio isolando o repositório com mocks, garantindo independência do banco de dados.

### 📌 Cenários testados:

- Validação de data inválida ao cadastrar consulta
- Busca de consulta por ID
- Listagem de todas as consultas

### Tecnologias utilizadas:
- JUnit 5
- Mockito
- Spring Boot Test



---

##  Funcionalidades

- Criar consulta veterinária
- Listar consultas
- Buscar consulta por ID
- Atualizar consulta
- Deletar consulta
- Validação de dados
- Tratamento de exceções

---

## ⚙️ Configuração do MongoDB

A aplicação utiliza MongoDB Atlas.

###  Opção recomendada — Variável de ambiente

Defina a variável de ambiente:

```bash
MONGO_URI=mongodb+srv://USUARIO:SENHA@cluster.mongodb.net/vetnelli
```

E no `application.properties`:

```properties
spring.data.mongodb.uri=${MONGO_URI}
```

---

###  Opção simples — Diretamente no application.properties

```properties
spring.data.mongodb.uri=mongodb+srv://USUARIO:SENHA@cluster.mongodb.net/NOME_DO_BANCO
```

## ⚙️ Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/SEU_USUARIO/vet-nelli-api.git
