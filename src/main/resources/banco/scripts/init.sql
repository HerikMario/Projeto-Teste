-- Tabela de Usuários
CREATE TABLE usuario (
    ID_usuario SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(30),
    saldo DECIMAL(10, 2) DEFAULT 0,
    senha VARCHAR(255) NOT NULL, -- varchar grande para armazenar hash da senha
    endNumero VARCHAR(10),
    endRua VARCHAR(100),
    endBairro VARCHAR(30),
    endCidade VARCHAR(30),
    endEstado VARCHAR(30),
    endCep VARCHAR(10) 
);

-- Tabela de Contas Bancárias
CREATE TABLE contaBanco (
    ID_contaBanco SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    nome VARCHAR(150),
    conta VARCHAR(50),
    agencia VARCHAR(10),
    FOREIGN KEY (id_usuario) REFERENCES usuario (ID_usuario) ON DELETE CASCADE -- Cascata na exclusão
);

-- Tabela de Usinas
CREATE TABLE usinas (
    ID_usina SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE,
    capacidade_total BIGINT NOT NULL, -- Usando BIGINT para capacidades maiores
    capacidade_restante BIGINT NOT NULL CHECK (capacidade_restante <= capacidade_total), -- Checagem para evitar inconsistências
    quantidade_vitis_restante SMALLINT NOT NULL,
    valor_vitis DECIMAL(10, 2) NOT NULL, -- Usando DECIMAL para valores monetários
    localizacao VARCHAR(200)
);

-- Tabela de Transações de Vitis
CREATE TABLE transacoes_vitis (
    ID_transacoes_vitis SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_usina INT NOT NULL,
    tipo_transacao VARCHAR(20) CHECK (tipo_transacao IN ('cede', 'compra')),
    quantidade_vitis INT NOT NULL, -- Usando INT para quantidades que podem ser maiores
    data_transacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario (ID_usuario) ON DELETE CASCADE, -- Cascata na exclusão
    FOREIGN KEY (id_usina) REFERENCES usinas (ID_usina) ON DELETE CASCADE -- Cascata na exclusão
);

insert into usuario values (default, 'Jo Soares', 'jojo@gmail.com', '629695959', '123456789', default, 'jo@1234');
insert into usuario values (default, 'Silvio Santos', 'silvio99@gmail.com', '765348762344', '6655778833', default, 'silvio567');
insert into usuario values (default, 'Gugu Abravanel', 'gupiuy1@gmail.com', '214235346', '4125465467', default, 'gu@1234');
insert into usuario values (default, 'Juan Souza', 'souzajuan@gmail.com', '24124125', '8899554433', 500, 'juju@1234');

insert into contaBanco values (default, 2, 'SILVIO S ABRAVANEL', '66677895', '5514');
insert into contaBanco values (default, 1, 'JO S SILVA', '124215555', '5513');
insert into contaBanco values (default, 3, 'GUSTAVO A TORRES', '6425666', '5513');
insert into contaBanco values (default, 4, 'JUAN S HOLANDA', '888855555', '5520');

insert into usinas values (default, 'usina 1', 50, 12, 1000, 5514, 'LUA');
insert into usinas values (default, 'usina 2', 35, 13, 933, 5513, 'MARTE');
insert into usinas values (default, 'usina 3', 20, 14, 111, 5513, 'JUPTER');
insert into usinas values (default, 'usina 4', 15, 15, 123, 5520, 'CAUCAIA');

insert into transacoes_vitis values (default, 1, 1, 'compra', 10, default);
insert into transacoes_vitis values (default, 2, 2, 'compra', 5, default);

/*

script de (teste)

select 
	u.nome,
	u.cpf,
	c.conta,
	c.agencia
from usuario u
inner join contaBanco c
on u.id_usuario = c.id_usuario
where u.saldo >100;

*/


-- comandos básicos:

-- Acessar o shell do container:
--  docker exec -it <nome_do_container> psql -U <usuario> -d <banco_de_dados>
--  \dt : para listar as tabelas do banco de dados informado
-- SELECT * FROM usuarios; : recebe os todos os dados da tabela usuarios