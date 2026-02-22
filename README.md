# libraryProject
REST API desenvolvida com Java e Spring Boot para gerenciamento de autores, implementando regras de negócio, controle de acesso por perfil (Gerente e Operador), validações robustas e padronização de respostas HTTP conforme contrato de API.

⸻

📚 LibraryProject

📌 Project Overview

LibraryProject é uma API RESTful desenvolvida em Java 17 + Spring Boot, responsável pelo gerenciamento do domínio Autor dentro de um contexto de biblioteca.

A aplicação foi construída com foco em:
	•	Arquitetura limpa e desacoplada
	•	Implementação rigorosa de contrato de API
	•	Controle de acesso baseado em papéis (RBAC)
	•	Governança de dados e auditoria
	•	Padronização de respostas HTTP
	•	Boas práticas de engenharia de software

O projeto simula um cenário corporativo onde regras de negócio, integridade de dados e segurança são requisitos obrigatórios.

⸻

🏛️ Arquitetura

A aplicação segue o padrão Layered Architecture com separação clara de responsabilidades:

├── controller        → Camada de exposição REST
├── service           → Regras de negócio
├── domain            → Entidades e agregados
├── repository        → Acesso a dados (JPA)
├── dto               → Contratos de entrada e saída
├── exception         → Tratamento global de erros
├── security          → Configuração RBAC
├── config            → Beans e configurações gerais

📐 Princípios Aplicados
	•	SOLID
	•	Clean Architecture (adaptado)
	•	Fail Fast Validation
	•	Separation of Concerns
	•	DTO Pattern
	•	Exception Handling Centralizado
	•	Imutabilidade quando possível

⸻

🧠 Domínio: Autor

📌 Campos de Negócio

Campo	Tipo	Obrigatório
nome	String	✅
dataNascimento	LocalDate	✅
nacionalidade	String	✅

📌 Campos de Auditoria

Campo	Tipo
id	UUID
dataCadastro	LocalDateTime
dataUltimaAtualizacao	LocalDateTime
usuarioUltimaAtualizacao	String

Estratégia de Identificação
	•	Uso de UUID como chave primária
	•	Evita previsibilidade de IDs sequenciais
	•	Melhor compatibilidade com arquiteturas distribuídas

⸻

🔐 Segurança

Implementado Role-Based Access Control (RBAC) via Spring Security.

Perfis

Role	Permissões
GERENTE	Criar, Atualizar, Excluir
OPERADOR	Apenas leitura

Estratégia
	•	Controle via @PreAuthorize
	•	Segurança declarativa
	•	Princípio do menor privilégio

⸻

📜 Regras de Negócio

1️⃣ Autor Duplicado

Não é permitido cadastrar dois autores com:
	•	Mesmo nome
	•	Mesma data de nascimento
	•	Mesma nacionalidade

Violação → 409 Conflict

⸻

2️⃣ Exclusão Controlada

Não é permitido excluir autor que possua livros vinculados.

Violação → 400 Bad Request

⸻

3️⃣ Validação de Campos Obrigatórios

Violação → 422 Unprocessable Entity

Validação via:
	•	Bean Validation (@NotBlank, @NotNull)
	•	Handler global de exceção

⸻

🌐 API Contract

Base Path: /autores

⸻

➕ Criar Autor

POST /autores

Success

201 Created

Header:

Location: /autores/{uuid}


⸻

🔎 Buscar Autor por ID

GET /autores/{id}
	•	200 OK
	•	404 Not Found

⸻

🔍 Pesquisar Autores

GET /autores?nome=&nacionalidade=

Filtro dinâmico implementado via:
	•	Specification API ou Query Methods

⸻

✏ Atualizar Autor

PUT /autores/{id}`
	•	204 No Content
	•	422 Unprocessable Entity
	•	409 Conflict

⸻

🗑 Excluir Autor

DELETE /autores/{id}`
	•	204 No Content
	•	400 Bad Request

⸻

📦 Padrão de Resposta de Erro

Estrutura padronizada:

{
  "status": 422,
  "message": "Erro de Validação",
  "errors": [
    {
      "field": "nome",
      "error": "Nome é obrigatório"
    }
  ],
  "timestamp": "2026-02-22T18:10:00"
}

Implementado via:
	•	@ControllerAdvice
	•	@ExceptionHandler
	•	Classe customizada ApiError

⸻

🗄 Persistência

Estratégia
	•	Spring Data JPA
	•	Controle transacional na camada de serviço
	•	Constraints de unicidade no nível de aplicação

Banco
	•	H2 (ambiente local)
	•	PostgreSQL (produção)

⸻

📊 Observabilidade
	•	Logs estruturados via SLF4J
	•	Logging de:
	•	Requisições
	•	Erros de negócio
	•	Exceções inesperadas

Preparado para futura integração com:
	•	Prometheus
	•	Grafana
	•	ELK Stack

⸻

🧪 Testes

Cobertura
	•	Unitários (Service)
	•	Controller (MockMvc)
	•	Validações
	•	Regra de duplicidade
	•	Exclusão com vínculo

Ferramentas:
	•	JUnit 5
	•	Mockito
	•	Spring Boot Test

⸻

🐳 Containerização

Imagem Docker otimizada para execução isolada:

docker build -t libraryproject .
docker run -p 8080:8080 libraryproject

Preparado para:
	•	Docker Compose
	•	Deploy em Kubernetes

⸻

📑 Documentação

Swagger disponível em:

/swagger-ui.html

Permite:
	•	Testar endpoints
	•	Visualizar contratos
	•	Inspecionar modelos
