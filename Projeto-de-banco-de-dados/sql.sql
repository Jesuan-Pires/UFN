CREATE DATABASE  IF NOT EXISTS `exercicio_aula` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `exercicio_aula`;
-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: exercicio_aula
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `Dnome` varchar(15) NOT NULL,
  `Dnumero` int(11) NOT NULL,
  `Cpf_gerente` char(11) DEFAULT NULL,
  `Data_inicio_gerente` date DEFAULT NULL,
  PRIMARY KEY (`Dnumero`),
  UNIQUE KEY `Dnumero` (`Dnumero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES ('Matriz',1,'88866555576','1981-06-19'),('Administração',4,'98765432168','1995-01-01'),('Pesquisa',5,'33344555587','1988-05-22');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependente`
--

DROP TABLE IF EXISTS `dependente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dependente` (
  `Fcpf` char(11) NOT NULL,
  `Nome_dependente` varchar(15) NOT NULL,
  `Sexo` char(1) DEFAULT NULL,
  `Datanasc` date DEFAULT NULL,
  `Parentesco` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`Fcpf`,`Nome_dependente`),
  CONSTRAINT `fk_Fcpf` FOREIGN KEY (`Fcpf`) REFERENCES `funcionario` (`Cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependente`
--

LOCK TABLES `dependente` WRITE;
/*!40000 ALTER TABLE `dependente` DISABLE KEYS */;
INSERT INTO `dependente` VALUES ('12345678966','Alicia','F','1988-12-30','Filha'),('12345678966','Elizabeth','F','1967-05-05','Esposa'),('12345678966','Michael','M','1988-01-04','Filho'),('33344555587','Alicia','F','1986-04-05','Filha'),('33344555587','Janaína','F','1986-04-05','Esposa'),('33344555587','Tiago','M','1983-10-25','Filho'),('98765432168','Antonio','M','1942-02-28','Marido');
/*!40000 ALTER TABLE `dependente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `Pnome` varchar(15) DEFAULT NULL,
  `Minicial` char(1) DEFAULT NULL,
  `Unome` varchar(50) NOT NULL,
  `Cpf` varchar(11) NOT NULL,
  `Datanasc` date DEFAULT NULL,
  `Endereco` varchar(255) DEFAULT NULL,
  `Sexo` char(1) DEFAULT NULL,
  `Salario` decimal(10,2) DEFAULT NULL,
  `Cpf_supervisor` char(11) DEFAULT NULL,
  `Dnr` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cpf`),
  KEY `Cpf_supervisor` (`Cpf_supervisor`),
  KEY `Dnr` (`Dnr`),
  CONSTRAINT `Cpf_supervisor` FOREIGN KEY (`Cpf_supervisor`) REFERENCES `funcionario` (`Cpf`),
  CONSTRAINT `Dnr` FOREIGN KEY (`Dnr`) REFERENCES `departamento` (`Dnumero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES ('João','B','Silva','12345678966','1965-01-09','Rua das Flores,751,São Paulo,SP','M',30000.00,'33344555587',5),('FERNANDO','T','Wong','33344555587','1955-12-08','Rua da Lapa,34,São Paulo,SP','M',40000.00,'88866555576',5),('Joice','A','Leite','45345345376','1972-07-31','AV.Lucas Obes,74,São Paulo,SP','F',25000.00,'33344555587',5),('Ronaldo','K','Lima','66688444476','1962-09-15','Rua Rebouças,65,Piracicaba,SP','M',38000.00,'33344555587',5),('Jorge','E','Brito','88866555576','1937-11-10','Rua do Horto,35,São Paulo,SP','M',55000.00,NULL,1),('Jennifer','S','Souza','98765432168','1941-06-20','AV.Arthur de Lima,54,Santo André,SP','F',43000.00,'88866555576',4),('André','E','Pereira','98798798733','1969-03-29','Rua Timbira,35,São Paulo,SP','M',55000.00,'98765432168',4),('Alice','J','Zelaya','99988777767','1968-01-19','Rua Souza Lima,35,Curitiba,PR','F',25000.00,'98765432168',4);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localizacao_dep`
--

DROP TABLE IF EXISTS `localizacao_dep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localizacao_dep` (
  `Dnumero` int(11) NOT NULL,
  `Dlocal` varchar(15) NOT NULL,
  PRIMARY KEY (`Dnumero`,`Dlocal`),
  CONSTRAINT `Dnumero` FOREIGN KEY (`Dnumero`) REFERENCES `departamento` (`Dnumero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localizacao_dep`
--

LOCK TABLES `localizacao_dep` WRITE;
/*!40000 ALTER TABLE `localizacao_dep` DISABLE KEYS */;
INSERT INTO `localizacao_dep` VALUES (1,'São Paulo'),(4,'Mauá'),(5,'Itu'),(5,'Santo André'),(5,'São Paulo');
/*!40000 ALTER TABLE `localizacao_dep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projeto`
--

DROP TABLE IF EXISTS `projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projeto` (
  `Projnome` varchar(15) NOT NULL,
  `Projnumero` int(11) NOT NULL,
  `Projlocal` varchar(15) DEFAULT NULL,
  `Dnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`Projnumero`),
  UNIQUE KEY `Projnome` (`Projnome`),
  UNIQUE KEY `Projnome_2` (`Projnome`),
  KEY `Dnum` (`Dnum`),
  CONSTRAINT `Dnum` FOREIGN KEY (`Dnum`) REFERENCES `departamento` (`Dnumero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projeto`
--

LOCK TABLES `projeto` WRITE;
/*!40000 ALTER TABLE `projeto` DISABLE KEYS */;
INSERT INTO `projeto` VALUES ('ProdutoX',1,'Santo André',5),('ProdutoY',2,'Itu',5),('ProdutoZ',3,'São Paulo',5),('Informatização',10,'Mauá',4),('Reorganização',20,'São Paulo',1),('NovosBenefícios',30,'Mauá',4);
/*!40000 ALTER TABLE `projeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabalha_em`
--

DROP TABLE IF EXISTS `trabalha_em`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabalha_em` (
  `Fcpf` char(11) NOT NULL,
  `Pnr` int(11) NOT NULL,
  `Horas` decimal(3,1) DEFAULT NULL,
  PRIMARY KEY (`Fcpf`,`Pnr`),
  KEY `pk_projeto` (`Pnr`),
  CONSTRAINT `pk_funcionario` FOREIGN KEY (`Fcpf`) REFERENCES `funcionario` (`Cpf`),
  CONSTRAINT `pk_projeto` FOREIGN KEY (`Pnr`) REFERENCES `projeto` (`Projnumero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabalha_em`
--

LOCK TABLES `trabalha_em` WRITE;
/*!40000 ALTER TABLE `trabalha_em` DISABLE KEYS */;
INSERT INTO `trabalha_em` VALUES ('12345678966',1,32.5),('12345678966',2,7.5),('33344555587',2,10.0),('33344555587',3,10.0),('33344555587',10,10.0),('33344555587',20,10.0),('45345345376',1,20.0),('45345345376',2,20.0),('66688444476',3,40.0),('88866555576',20,NULL),('98765432168',30,15.0),('99988777767',10,10.0),('99988777767',30,30.0);
/*!40000 ALTER TABLE `trabalha_em` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'exercicio_aula'
--

--
-- Dumping routines for database 'exercicio_aula'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-25 20:20:08
