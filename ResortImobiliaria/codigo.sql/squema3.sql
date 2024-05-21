create schema IMOBILIARIA;

use IMOBILIARIA;

CREATE TABLE IMOBILIARIA.Imovel (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(255),
    tipoVenda VARCHAR(255),
    valor DECIMAL(10, 2),
    endereco VARCHAR(255),
    numero VARCHAR(20),
    cidade VARCHAR(255),
    uf VARCHAR(2),
    cep VARCHAR(10),
    numQuartos VARCHAR(255),
    numBanheiros VARCHAR(255),
    metrosQuadrados DECIMAL(10, 2),
    descricao TEXT,
    USER_ID INTEGER
);

CREATE TABLE IMOBILIARIA.Usuario (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NOME_COMPLETO TEXT,
    SENHA VARCHAR(100),
    DATA_NASCIMENTO TEXT,
    EMAIL TEXT,
    CPF_CNPJ TEXT,
    TELEFONE TEXT
);

CREATE TABLE IMOBILIARIA.ImovelImagem (
    id INT AUTO_INCREMENT PRIMARY KEY,
    imovel_id INT,
    caminho_imagem VARCHAR(255),
    FOREIGN KEY (imovel_id) REFERENCES Imovel(id)
);