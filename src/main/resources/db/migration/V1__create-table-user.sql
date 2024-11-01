-- Tabela de Usuários
CREATE TABLE usuario (
    ID_usuario SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(30),
    saldo DECIMAL(10, 2) DEFAULT 0,
    senha VARCHAR(255) NOT NULL, -- varchar grande para armazenar hash da senha
    end_numero VARCHAR(10),
    end_rua VARCHAR(100),
    end_bairro VARCHAR(30),
    end_cidade VARCHAR(30),
    end_estado VARCHAR(30),
    end_cep VARCHAR(10),
    data_nascimento DATE NOT NULL
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