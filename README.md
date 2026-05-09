# API de Registro de Atividade Física

API RESTful desenvolvida em Java com Spring Boot para registro e consulta de atividades físicas realizadas por funcionários.

## Pré-requisitos

- Java 17+
- Maven
- PostgreSQL
- Insomnia (para testes)

## Configuração do Banco de Dados

Crie um banco de dados no PostgreSQL chamado `atividadesFisicas`:

```sql
CREATE DATABASE atividadesFisicas;
```

Em seguida, execute o script de criação da tabela disponível em `Banco de dados/DDL.sql`.

## Configuração da Aplicação

No arquivo `atividade_fisica/src/main/resources/application.properties`, preencha as credenciais do seu banco:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/atividadesFisicas
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

## Como Executar

**Via IDE:** Execute a classe `AtividadeFisicaApplication.java` localizada em `src/main/java/com/itau/api/atividade_fisica/`.

**Via terminal:**

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Testando com Insomnia

Importe a collection disponível em `Insomnia/collection.json` no Insomnia e execute as requisições já configuradas.

---

## Endpoints

### POST `/atividades`

Registra uma nova atividade física.

**Body (JSON):**

```json
{
  "funcional": "123456789",
  "dataHora": "2025-09-24T07:30:00",
  "codigoAtividade": "RUN",
  "descricaoAtividade": "Corrida de 5km"
}
```

**Resposta de sucesso — `201 Created`:**

```json
{
  "idAtividade": 1,
  "funcional": "123456789",
  "codigoAtividade": "RUN",
  "descricaoAtividade": "Corrida de 5km",
  "dataHora": "2025-09-24T07:30:00"
}
```

---

### GET `/atividades`

Lista todas as atividades físicas cadastradas.

**Resposta de sucesso — `200 OK`:**

```json
[
  {
    "funcional": "123456789",
    "codigoAtividade": "RUN",
    "descricaoAtividade": "Corrida de 5km",
    "dataHora": "2025-09-24T07:30:00"
  },
  {
    "funcional": "987654321",
    "codigoAtividade": "RUN",
    "descricaoAtividade": "Corrida de 5km",
    "dataHora": "2025-09-24T07:30:00"
  }
]
```

---

### GET `/atividades/{funcional}`

Lista todas as atividades de um funcionário específico.

**Parâmetro:** `funcional` — código do funcionário informado na URL.

**Exemplo:** `GET /atividades/123456789`

**Resposta de sucesso — `200 OK`:**

```json
[
  {
    "funcional": "123456789",
    "codigoAtividade": "RUN",
    "descricaoAtividade": "Corrida de 5km",
    "dataHora": "2025-09-24T07:30:00"
  },
  {
    "funcional": "123456789",
    "codigoAtividade": "FUTEBOL",
    "descricaoAtividade": "40 minutos de jogo",
    "dataHora": "2025-09-25T07:30:00"
  }
]
```
