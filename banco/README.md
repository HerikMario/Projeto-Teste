# Projeto PostgreSQL com Docker e Tabela de Usuários

Este projeto configura um banco de dados PostgreSQL em um contêiner Docker com persistência de dados. Além disso, inclui a criação de uma tabela chamada `usuarios` com alguns dados iniciais inseridos automaticamente.

## Pré-requisitos

Antes de começar, você precisará ter as seguintes ferramentas instaladas em seu sistema:

- [Docker](https://docs.docker.com/get-docker/)

## Instruções de Uso

### 1. Clonar o Repositório

Clone este repositório em sua máquina local:

```bash
git clone <url-do-repositorio>
cd <nome-do-repositorio>
```

### 2.Definir Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto para armazenar as credenciais do banco de dados.
Exemplo de arquivo `.env:`
```bash
POSTGRES_USER=root
POSTGRES_PASSWORD=root123
POSTGRES_DB=banco_teste
```
### 4.Executar o Banco de Dados com Docker

Para iniciar o contêiner Docker com o PostgreSQL, execute o seguinte comando:

`docker-compose up -d`

Este comando usará o arquivo docker-compose.yml para configurar e iniciar o serviço PostgreSQL. O banco de dados estará disponível na porta 54320 do host (mapeada para a porta 5432 dentro do contêiner).

### 5. Acessar o Banco de Dados

Acesse o shell do contêiner PostgreSQL:

`docker exec -it postgres_teste psql -U $POSTGRES_USER -d $POSTGRES_DB`

Comandos úteis dentro do psql:

- listar tabelas no banco de dados: `\dt`
- Selecionar todos os dados da tabela usuarios: `SELECT * FROM usuarios;
`
