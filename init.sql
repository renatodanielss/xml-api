CREATE DATABASE IF NOT EXISTS xml;
USE xml;
CREATE TABLE `agentes` (
    `codigo` int NOT NULL AUTO_INCREMENT,
    `versao` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `agente` (
    `codigo` int NOT NULL AUTO_INCREMENT,
    `data` date DEFAULT NULL,
    `agentes_codigo` int DEFAULT NULL,
    PRIMARY KEY (`codigo`),
    KEY `FKd2mmhj1w8buv1awdy6ilhvxk4` (`agentes_codigo`),
    CONSTRAINT `FKd2mmhj1w8buv1awdy6ilhvxk4` FOREIGN KEY (`agentes_codigo`) REFERENCES `agentes` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `regiao` (
    `codigo` int NOT NULL AUTO_INCREMENT,
    `sigla` varchar(255) DEFAULT NULL,
    `agente_codigo` int DEFAULT NULL,
    PRIMARY KEY (`codigo`),
    KEY `FKqr6xek1axaiaguy9x7n053uxx` (`agente_codigo`),
    CONSTRAINT `FKqr6xek1axaiaguy9x7n053uxx` FOREIGN KEY (`agente_codigo`) REFERENCES `agente` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `compra_valor` (
    `codigo` int NOT NULL AUTO_INCREMENT,
    `valor` double DEFAULT NULL,
    `regiao_codigo` int DEFAULT NULL,
    PRIMARY KEY (`codigo`),
    KEY `FKbx0vhnwa6r3kag2niyv523wo0` (`regiao_codigo`),
    CONSTRAINT `FKbx0vhnwa6r3kag2niyv523wo0` FOREIGN KEY (`regiao_codigo`) REFERENCES `regiao` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `geracao_valor` (
    `codigo` int NOT NULL AUTO_INCREMENT,
    `valor` double DEFAULT NULL,
    `regiao_codigo` int DEFAULT NULL,
    PRIMARY KEY (`codigo`),
    KEY `FKe54tl4rm79af7jecp59vxvecg` (`regiao_codigo`),
    CONSTRAINT `FKe54tl4rm79af7jecp59vxvecg` FOREIGN KEY (`regiao_codigo`) REFERENCES `regiao` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `preco_medio_valor` (
    `codigo` int NOT NULL AUTO_INCREMENT,
    `valor` double DEFAULT NULL,
    `regiao_codigo` int DEFAULT NULL,
    PRIMARY KEY (`codigo`),
    KEY `FKma2hpaqwbnk1u8wxw4o0miqgx` (`regiao_codigo`),
    CONSTRAINT `FKma2hpaqwbnk1u8wxw4o0miqgx` FOREIGN KEY (`regiao_codigo`) REFERENCES `regiao` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4;