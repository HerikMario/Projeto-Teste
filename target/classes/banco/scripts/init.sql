CREATE TABLE IF NOT EXISTS usuarios (
    id SERIAL PRIMARY KEY, -- Chave primaria, auto-incrementada
    nome VARCHAR(100) NOT NULL, -- Nome do usuário, obrigatório (não nulo)
    email VARCHAR(100) UNIQUE NOT NULL, -- Email do usuário, campo único e obrigatório
    sexo CHAR(1) CHECK (sexo IN ('M', 'F')), -- "M" para Masculino e "F" para Feminino
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Data de criação do registro, valor padrão é a data e hora atual
);

-- Inserindo valores iniciais na tabela 'usuarios'
INSERT INTO usuarios (nome, email, sexo) 
VALUES 
    ('João Silva', 'joao.silva@email.com', 'M'),
    ('Maria Souza', 'maria.souza@email.com', 'F'),
    ('Carlos Santos', 'carlos.santos@email.com', 'M'),
    ('Ana Oliveira', 'ana.oliveira@email.com', 'F'),
    ('Pedro Costa', 'pedro.costa@email.com', 'M'),
    ('Beatriz Lima', 'beatriz.lima@email.com', 'F'),
    ('Rafael Pereira', 'rafael.pereira@email.com', 'M'),
    ('Carla Martins', 'carla.martins@email.com', 'F'),
    ('Lucas Fernandes', 'lucas.fernandes@email.com', 'M'),
    ('Mariana Rocha', 'mariana.rocha@email.com', 'F'),
    ('João Cardoso', 'joao.cardoso@email.com', 'M'),
    ('Fernanda Silva', 'fernanda.silva@email.com', 'F'),
    ('Rodrigo Alves', 'rodrigo.alves@email.com', 'M');




-- comandos básicos:

-- Acessar o shell do container:
--  docker exec -it <nome_do_container> psql -U <usuario> -d <banco_de_dados>
--  \dt : para listar as tabelas do banco de dados informado
-- SELECT * FROM usuarios; : recebe os todos os dados da tabela usuarios