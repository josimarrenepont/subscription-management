# 💳 Subscription Management API

Sistema backend para gerenciamento de assinaturas, planos, clientes e processamento simulado de pagamentos, 
construído com Java 21 e Spring Boot utilizando os princípios da **Clean Architecture (Hexagonal)** e **SOLID**.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3** (Web, Data JPA)
- **PostgreSQL** (Banco de dados relacional)
- **Docker & Docker Compose** (Containerização) | Falta implementar
- **Maven** (Gerenciador de dependências)

---

## 🏛️ Arquitetura

O projeto foi desenvolvido seguindo a **Clean Architecture**, garantindo desacoplamento total entre as regras de negócio centrais e frameworks/ferramentas externas.

```

🛠️ Endpoints da API
👤 Clientes (/api/v1/customers)
POST /api/v1/customers — Cadastra um novo cliente

GET /api/v1/customers/{id} — Busca dados de um cliente por ID

📦 Planos (/api/v1/plans)
POST /api/v1/plans — Cadastra um novo plano de assinatura

GET /api/v1/plans/{id} — Busca detalhes de um plano por ID

📑 Assinaturas (/api/v1/subscriptions)
POST /api/v1/subscriptions — Cria e processa o pagamento de uma nova assinatura

GET /api/v1/subscriptions/{id} — Consulta detalhes e status de uma assinatura

💻 Como Rodar o Projeto
Pré-requisitos
Java 21+

Docker e Docker Compose

Maven (ou execute via ./mvnw)

Passo a passo

git clone [https://github.com/josimarrenepont/subscription-management.git](https://github.com/josimarrenepont/subscription-management.git)
cd subscription-management

docker-compose up -d

./mvnw spring-boot:run


A API estará acessível em http://localhost:8080.

📝 Exemplo de Uso (Criar Assinatura)
Requisição (POST /api/v1/subscriptions):

{
  "customerId": 1,
  "planId": 1,
  "paymentMethod": "CREDIT_CARD"
}

{
  "id": 1,
  "customerId": 1,
  "planId": 1,
  "status": "ACTIVE",
  "startDate": "2026-09-06T00:00:00Z",
  "endDate": "2026-10-06T00:00:00Z",
  "nextBillingDate": "2026-10-06T00:00:00Z",
  "lastPaymentAmount": 49.90,
  "paymentMethod": "CREDIT_CARD"
}

✒️ Autor
Desenvolvido por Josimar Renepont dos Santos.

