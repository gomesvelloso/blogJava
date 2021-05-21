DROP DATABASE IF EXISTS blog;
CREATE DATABASE blog;
USE blog;

DROP TABLE IF EXISTS categoria;
CREATE TABLE categoria (
  `categoriaId` int(11) NOT NULL AUTO_INCREMENT,
  `categoriaNome` varchar(255) NOT NULL,
  PRIMARY KEY (`categoriaId`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO categoria (categoriaId, categoriaNome) VALUES (1, 'Tecnologia');
INSERT INTO categoria (categoriaId, categoriaNome) VALUES (2, 'Economia');
INSERT INTO categoria (categoriaId, categoriaNome) VALUES (3, 'Mundo');

DROP TABLE IF EXISTS post;
CREATE TABLE post (
  `postId` int(11) NOT NULL AUTO_INCREMENT,
  `postData` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `postTitulo` text,
  `postTexto` text,
  `categoriaId` int(11) NOT NULL,
  PRIMARY KEY (`postId`),
  KEY `categoriaId` (`categoriaId`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`categoriaId`) REFERENCES `categoria` (`categoriaId`) ON DELETE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;