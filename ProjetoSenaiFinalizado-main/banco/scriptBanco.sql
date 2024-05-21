-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: banco
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `armazena`
--

DROP TABLE IF EXISTS `armazena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `armazena` (
  `fk_Chat___Conversa_IDConversa` int DEFAULT NULL,
  `fk_Mensagens_IDMesnagens` int DEFAULT NULL,
  KEY `FK_Armazena_1` (`fk_Chat___Conversa_IDConversa`),
  KEY `FK_Armazena_2` (`fk_Mensagens_IDMesnagens`),
  CONSTRAINT `FK_Armazena_1` FOREIGN KEY (`fk_Chat___Conversa_IDConversa`) REFERENCES `chat___conversa` (`IDConversa`) ON DELETE RESTRICT,
  CONSTRAINT `FK_Armazena_2` FOREIGN KEY (`fk_Mensagens_IDMesnagens`) REFERENCES `mensagens` (`IDMesnagens`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armazena`
--

LOCK TABLES `armazena` WRITE;
/*!40000 ALTER TABLE `armazena` DISABLE KEYS */;
/*!40000 ALTER TABLE `armazena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadrastro_de_medicacoes`
--

DROP TABLE IF EXISTS `cadrastro_de_medicacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cadrastro_de_medicacoes` (
  `IdCadastroMedicacao` int NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(45) DEFAULT NULL,
  `NomedoMedicamento` varchar(45) DEFAULT NULL,
  `DuracaoDias` int DEFAULT NULL,
  `periodoHoras` int DEFAULT NULL,
  `Dosagem` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`IdCadastroMedicacao`),
  UNIQUE KEY `IdCadastroMedicacao_UNIQUE` (`IdCadastroMedicacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadrastro_de_medicacoes`
--

LOCK TABLES `cadrastro_de_medicacoes` WRITE;
/*!40000 ALTER TABLE `cadrastro_de_medicacoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `cadrastro_de_medicacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat___conversa`
--

DROP TABLE IF EXISTS `chat___conversa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat___conversa` (
  `Horario` time DEFAULT NULL,
  `Data` date DEFAULT NULL,
  `Assunto` varchar(45) DEFAULT NULL,
  `IDConversa` int NOT NULL,
  PRIMARY KEY (`IDConversa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat___conversa`
--

LOCK TABLES `chat___conversa` WRITE;
/*!40000 ALTER TABLE `chat___conversa` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat___conversa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comunica`
--

DROP TABLE IF EXISTS `comunica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comunica` (
  `fk_Medico_Responsavel_IDMedico` int DEFAULT NULL,
  `fk_Participantes_IDParticipantes` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comunica`
--

LOCK TABLES `comunica` WRITE;
/*!40000 ALTER TABLE `comunica` DISABLE KEYS */;
/*!40000 ALTER TABLE `comunica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comunica2`
--

DROP TABLE IF EXISTS `comunica2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comunica2` (
  `fk_UsuarioCuidador_IDCuidador` int DEFAULT NULL,
  `fk_Participantes_IDParticipantes` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comunica2`
--

LOCK TABLES `comunica2` WRITE;
/*!40000 ALTER TABLE `comunica2` DISABLE KEYS */;
/*!40000 ALTER TABLE `comunica2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuida`
--

DROP TABLE IF EXISTS `cuida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuida` (
  `fk_usuariopaciente_IDpaciente` int DEFAULT NULL,
  `fk_usuariocuidador_IDCuidador` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuida`
--

LOCK TABLES `cuida` WRITE;
/*!40000 ALTER TABLE `cuida` DISABLE KEYS */;
INSERT INTO `cuida` VALUES (11,10),(11,9),(11,15),(15,18),(16,10),(16,13),(16,9),(16,14),(16,12),(16,17),(17,13);
/*!40000 ALTER TABLE `cuida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento_cadastrado`
--

DROP TABLE IF EXISTS `medicamento_cadastrado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicamento_cadastrado` (
  `fk_Cadrastro_de_medicacoes_IdCadastroMedicacao` int DEFAULT NULL,
  `fk_Prescricao_medica_IDPrescricao` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento_cadastrado`
--

LOCK TABLES `medicamento_cadastrado` WRITE;
/*!40000 ALTER TABLE `medicamento_cadastrado` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicamento_cadastrado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico_responsavel`
--

DROP TABLE IF EXISTS `medico_responsavel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico_responsavel` (
  `IDMedico` int NOT NULL,
  `CRM` varchar(45) DEFAULT NULL,
  `Numero` varchar(9) DEFAULT NULL,
  `ddd` varchar(2) DEFAULT NULL,
  `fk_Prescricao_medica_IDPrescricao` int DEFAULT NULL,
  `senhaMedico` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDMedico`),
  KEY `FK_Medico_Responsavel_2` (`fk_Prescricao_medica_IDPrescricao`),
  CONSTRAINT `FK_Medico_Responsavel_2` FOREIGN KEY (`fk_Prescricao_medica_IDPrescricao`) REFERENCES `prescricao_medica` (`IDPrescricao`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico_responsavel`
--

LOCK TABLES `medico_responsavel` WRITE;
/*!40000 ALTER TABLE `medico_responsavel` DISABLE KEYS */;
/*!40000 ALTER TABLE `medico_responsavel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensagens`
--

DROP TABLE IF EXISTS `mensagens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensagens` (
  `Conversa_` varchar(1000) DEFAULT NULL,
  `IDUsuario` int DEFAULT NULL,
  `IDMesnagens` int NOT NULL,
  `Emissor` varchar(45) DEFAULT NULL,
  `Data` date DEFAULT NULL,
  `Horario` time DEFAULT NULL,
  PRIMARY KEY (`IDMesnagens`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensagens`
--

LOCK TABLES `mensagens` WRITE;
/*!40000 ALTER TABLE `mensagens` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensagens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participantes`
--

DROP TABLE IF EXISTS `participantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participantes` (
  `IdMedico` int DEFAULT NULL,
  `IDpaciente` int DEFAULT NULL,
  `IDCuidador` int DEFAULT NULL,
  `IDParticipantes` int NOT NULL,
  PRIMARY KEY (`IDParticipantes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participantes`
--

LOCK TABLES `participantes` WRITE;
/*!40000 ALTER TABLE `participantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `participantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescricao_medica`
--

DROP TABLE IF EXISTS `prescricao_medica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescricao_medica` (
  `IDPrescricao` int NOT NULL,
  `HorarioInicial` time DEFAULT NULL,
  `Dosagem` float DEFAULT NULL,
  `Periodicidade_` time DEFAULT NULL,
  `DuracaoDoTratamento` int DEFAULT NULL,
  PRIMARY KEY (`IDPrescricao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescricao_medica`
--

LOCK TABLES `prescricao_medica` WRITE;
/*!40000 ALTER TABLE `prescricao_medica` DISABLE KEYS */;
/*!40000 ALTER TABLE `prescricao_medica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recebeu`
--

DROP TABLE IF EXISTS `recebeu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recebeu` (
  `fk_Prescricao_medica_IDPrescricao` int DEFAULT NULL,
  `fk_UsuatioPaciente_IDpaciente` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recebeu`
--

LOCK TABLES `recebeu` WRITE;
/*!40000 ALTER TABLE `recebeu` DISABLE KEYS */;
/*!40000 ALTER TABLE `recebeu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_de_medicacao_administrada`
--

DROP TABLE IF EXISTS `registro_de_medicacao_administrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registro_de_medicacao_administrada` (
  `Horario_da_aplicacao` time DEFAULT NULL,
  `IDRegistro` int NOT NULL,
  `Justificativa` varchar(200) DEFAULT NULL,
  `Data` date DEFAULT NULL,
  PRIMARY KEY (`IDRegistro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_de_medicacao_administrada`
--

LOCK TABLES `registro_de_medicacao_administrada` WRITE;
/*!40000 ALTER TABLE `registro_de_medicacao_administrada` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_de_medicacao_administrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relatomedicamentoprescricao`
--

DROP TABLE IF EXISTS `relatomedicamentoprescricao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `relatomedicamentoprescricao` (
  `fk_Prescricao_medica_IDPrescricao` int DEFAULT NULL,
  `fk_Registro_de_medicacao_administrada_IDRegistro` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relatomedicamentoprescricao`
--

LOCK TABLES `relatomedicamentoprescricao` WRITE;
/*!40000 ALTER TABLE `relatomedicamentoprescricao` DISABLE KEYS */;
/*!40000 ALTER TABLE `relatomedicamentoprescricao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trata`
--

DROP TABLE IF EXISTS `trata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trata` (
  `fk_Medico_Responsavel_IDMedico` int DEFAULT NULL,
  `fk_UsuatioPaciente_IDpaciente` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trata`
--

LOCK TABLES `trata` WRITE;
/*!40000 ALTER TABLE `trata` DISABLE KEYS */;
/*!40000 ALTER TABLE `trata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariocuidador`
--

DROP TABLE IF EXISTS `usuariocuidador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuariocuidador` (
  `IDCuidador` int NOT NULL AUTO_INCREMENT,
  `TipoContrato` varchar(45) DEFAULT NULL,
  `NomePerfil` varchar(45) DEFAULT NULL,
  `Cidade` varchar(45) DEFAULT NULL,
  `Bairro` varchar(100) DEFAULT NULL,
  `Cpf` varchar(11) DEFAULT NULL,
  `DataNascimento` date DEFAULT NULL,
  `ddd` varchar(2) DEFAULT NULL,
  `numero` varchar(9) DEFAULT NULL,
  `DescricaoEspecialidades` varchar(500) DEFAULT NULL,
  `dddEmergencia` varchar(2) DEFAULT NULL,
  `NumeroEmergencia` varchar(9) DEFAULT NULL,
  `fk_Registro_de_medicacao_administrada_IDRegistro` int DEFAULT NULL,
  `periodo` varchar(45) DEFAULT NULL,
  `senhaCuidador` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDCuidador`),
  KEY `FK_UsuarioCuidador_2` (`fk_Registro_de_medicacao_administrada_IDRegistro`),
  CONSTRAINT `FK_UsuarioCuidador_2` FOREIGN KEY (`fk_Registro_de_medicacao_administrada_IDRegistro`) REFERENCES `registro_de_medicacao_administrada` (`IDRegistro`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariocuidador`
--

LOCK TABLES `usuariocuidador` WRITE;
/*!40000 ALTER TABLE `usuariocuidador` DISABLE KEYS */;
INSERT INTO `usuariocuidador` VALUES (5,'clt','henrique',NULL,NULL,'cpf',NULL,NULL,NULL,'sla',NULL,NULL,NULL,'tarde','senha'),(6,'clt','henrique',NULL,NULL,'cpf',NULL,NULL,NULL,'sla',NULL,NULL,NULL,'tarde','senha'),(7,'clt','henrique',NULL,NULL,'cpf',NULL,NULL,NULL,'sla',NULL,NULL,NULL,'tarde','senha'),(8,'clt','henrique',NULL,NULL,'cpf',NULL,NULL,NULL,'sla',NULL,NULL,NULL,'tarde','senha'),(9,'clt','henrique',NULL,NULL,'cpf',NULL,NULL,NULL,'sla',NULL,NULL,NULL,'tarde','senha'),(10,'clt','henrique',NULL,NULL,'12312312312',NULL,NULL,NULL,'sla',NULL,NULL,NULL,'tarde','666'),(11,'clt','henrique',NULL,NULL,'sla',NULL,NULL,NULL,'especialidade',NULL,NULL,NULL,'tarde','senhosa'),(12,'clt','henrique',NULL,NULL,'123',NULL,NULL,NULL,'especialidade',NULL,NULL,NULL,'tarde','12'),(13,'clt','henrique',NULL,NULL,'23',NULL,NULL,NULL,'especialidade',NULL,NULL,NULL,'tarde','slaa'),(14,'clt','henrique',NULL,NULL,'slaaa',NULL,NULL,NULL,'especialidade',NULL,NULL,NULL,'tarde','59'),(15,'CLT','nome',NULL,NULL,'slamermao',NULL,NULL,NULL,'aaaaaa',NULL,NULL,NULL,'Manhã','senha'),(16,'CLT','',NULL,NULL,'letra',NULL,NULL,NULL,'',NULL,NULL,NULL,'Manhã','letra'),(17,'CLT','',NULL,NULL,'sla',NULL,NULL,NULL,'',NULL,NULL,NULL,'Manhã','sla'),(18,'CLT','guilherme silva',NULL,NULL,'12345678910',NULL,NULL,NULL,'tratamento de diabeticos, crianças autistas',NULL,NULL,NULL,'Manhã','3083');
/*!40000 ALTER TABLE `usuariocuidador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariopaciente`
--

DROP TABLE IF EXISTS `usuariopaciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuariopaciente` (
  `IDpaciente` int NOT NULL AUTO_INCREMENT,
  `NomePerfil` varchar(45) DEFAULT NULL,
  `Cpf` varchar(11) DEFAULT NULL,
  `PessoaDesignada` varchar(45) DEFAULT NULL,
  `Familiar` varchar(45) DEFAULT NULL,
  `Bairro` varchar(100) DEFAULT NULL,
  `Cidade` varchar(45) DEFAULT NULL,
  `ddd` varchar(2) DEFAULT NULL,
  `numero` varchar(9) DEFAULT NULL,
  `DataNascimento` date DEFAULT NULL,
  `DescricaoNecessidades` varchar(500) DEFAULT NULL,
  `senhaPaciente` varchar(45) DEFAULT NULL,
  `idadePaciente` int DEFAULT NULL,
  PRIMARY KEY (`IDpaciente`),
  UNIQUE KEY `IDpaciente_UNIQUE` (`IDpaciente`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariopaciente`
--

LOCK TABLES `usuariopaciente` WRITE;
/*!40000 ALTER TABLE `usuariopaciente` DISABLE KEYS */;
INSERT INTO `usuariopaciente` VALUES (6,'antonho','65656',NULL,NULL,NULL,NULL,'72','numero',NULL,'necessidade2','senhapaciente',69),(7,'antonho','65656',NULL,NULL,NULL,NULL,'72','numero',NULL,'necessidade2','senhapaciente',69),(8,'antonho','65656',NULL,NULL,NULL,NULL,'72','numero',NULL,'necessidade2','senhapaciente',69),(9,'antonho','65656',NULL,NULL,NULL,NULL,'72','numero',NULL,'necessidade2','senhapaciente',69),(10,'a','65656',NULL,NULL,NULL,NULL,'72','numero',NULL,'necessidade2','senhapaciente',69),(11,'a','cpf',NULL,NULL,NULL,NULL,'72','numero',NULL,'necessidade2','123',69),(12,'veibroxa','999',NULL,NULL,NULL,NULL,'71','asda',NULL,'asdas',NULL,100),(13,'','123',NULL,NULL,NULL,NULL,'','',NULL,'','[C@afe569f',1),(14,'aaa','aaa',NULL,NULL,NULL,NULL,'','',NULL,'','senha',1),(15,'joão paulo silva','66666666666',NULL,NULL,NULL,NULL,'71','981362697',NULL,'afsjnaufhbnaolsnfhoashnfoasjhnfnlas','3083',102),(16,'gui','1234',NULL,NULL,NULL,NULL,'71','81362697',NULL,'','123',100),(17,'sla','444',NULL,NULL,'brotas','salvador','71','981362697',NULL,'sla','444',80);
/*!40000 ALTER TABLE `usuariopaciente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-20 23:05:53
