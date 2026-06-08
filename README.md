# VetNelli API 🐾

API REST desenvolvida com Java + Spring Boot para gerenciamento de consultas veterinárias.

## 🚀 Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Web
* Spring Data MongoDB
* MongoDB Atlas
* Lombok
* Jakarta Validation
* JUnit 5
* Mockito
* Maven

---

## 📁 Estrutura do projeto

```text
src/main/java
├── controller
├── service
├── repository
├── mapper
├── dto
├── entity
├── enums
├── exception
```

---

## ⚙️ Funcionalidades

*  Cadastro de consultas
*  Busca de consulta por ID
*  Listagem de consultas
* Atualização de consultas
*  Exclusão de consultas
* Atualização de status da consulta
* Validações de dados
*  Tratamento global de exceções
---

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

## ❌ Exemplo de erro

```json
{
  "status": 400,
  "message": "Data da consulta inválida",
  "timestamp": "2026-05-21T01:30:00"
}
```
##  Frontend

Interface web desenvolvida em React.

🔗 Frontend: https://github.com/GiovanniCainelli/VetNelli-Front

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
