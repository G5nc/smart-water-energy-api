# Smart Water & Energy API

API REST em Spring Boot para monitoramento da estação de água e energia.

## Integrantes
- Gustavo Nobre Coppola (RM561423)

## Como Executar
1. Clone o repositório.
2. Abra no IntelliJ IDEA.
3. Rode a classe `EstacaoApiApplication`.
4. A API estará disponível em `http://localhost:8080`.

## Endpoints
- `GET /api/estacao/leituras` - Lista todas as leituras.
- `GET /api/estacao/atual` - Retorna a última leitura.
- `POST /api/estacao/simular` - Simula uma nova leitura e salva no banco H2.

## Banco de Dados
- H2 em modo arquivo: `jdbc:h2:file:./data/estacao`
- Os dados persistem após reiniciar a aplicação.