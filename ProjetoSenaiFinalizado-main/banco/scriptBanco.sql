CREATE SCHEMA banco2;
use banco2;


CREATE TABLE `chat___conversa` (
  `Horario` time DEFAULT NULL,
  `Data` date DEFAULT NULL,
  `Assunto` varchar(45) DEFAULT NULL,
  `IDConversa` int NOT NULL,
  PRIMARY KEY (`IDConversa`)
);



CREATE TABLE `cadrastro_de_medicacoes` (
  `IdCadastroMedicacao` int NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(45) DEFAULT NULL,
  `NomedoMedicamento` varchar(45) DEFAULT NULL,
  `DuracaoDias` int DEFAULT NULL,
  `periodoHoras` int DEFAULT NULL,
  `Dosagem` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`IdCadastroMedicacao`),
  UNIQUE KEY `IdCadastroMedicacao_UNIQUE` (`IdCadastroMedicacao`)
);



CREATE TABLE `comunica` (
  `fk_Medico_Responsavel_IDMedico` int DEFAULT NULL,
  `fk_Participantes_IDParticipantes` int DEFAULT NULL
);
CREATE TABLE `comunica2` (
  `fk_UsuarioCuidador_IDCuidador` int DEFAULT NULL,
  `fk_Participantes_IDParticipantes` int DEFAULT NULL
);
CREATE TABLE `cuida` (
  `fk_usuariopaciente_IDpaciente` int DEFAULT NULL,
  `fk_usuariocuidador_IDCuidador` int DEFAULT NULL
);
CREATE TABLE `medicamento_cadastrado` (
  `fk_Cadrastro_de_medicacoes_IdCadastroMedicacao` int DEFAULT NULL,
  `fk_Prescricao_medica_IDPrescricao` int DEFAULT NULL
);

CREATE TABLE `mensagens` (
  `Conversa_` varchar(1000) DEFAULT NULL,
  `IDUsuario` int DEFAULT NULL,
  `IDMesnagens` int NOT NULL,
  `Emissor` varchar(45) DEFAULT NULL,
  `Data` date DEFAULT NULL,
  `Horario` time DEFAULT NULL,
  PRIMARY KEY (`IDMesnagens`)
);
CREATE TABLE `participantes` (
  `IdMedico` int DEFAULT NULL,
  `IDpaciente` int DEFAULT NULL,
  `IDCuidador` int DEFAULT NULL,
  `IDParticipantes` int NOT NULL,
  PRIMARY KEY (`IDParticipantes`)
);
CREATE TABLE `prescricao_medica` (
  `IDPrescricao` int NOT NULL,
  `HorarioInicial` time DEFAULT NULL,
  `Dosagem` float DEFAULT NULL,
  `Periodicidade_` time DEFAULT NULL,
  `DuracaoDoTratamento` int DEFAULT NULL,
  PRIMARY KEY (`IDPrescricao`)
);
CREATE TABLE `recebeu` (
  `fk_Prescricao_medica_IDPrescricao` int DEFAULT NULL,
  `fk_UsuatioPaciente_IDpaciente` int DEFAULT NULL
);
CREATE TABLE `registro_de_medicacao_administrada` (
  `Horario_da_aplicacao` time DEFAULT NULL,
  `IDRegistro` int NOT NULL,
  `Justificativa` varchar(200) DEFAULT NULL,
  `Data` date DEFAULT NULL,
  PRIMARY KEY (`IDRegistro`)
);
CREATE TABLE `relatomedicamentoprescricao` (
  `fk_Prescricao_medica_IDPrescricao` int DEFAULT NULL,
  `fk_Registro_de_medicacao_administrada_IDRegistro` int DEFAULT NULL
);
CREATE TABLE `trata` (
  `fk_Medico_Responsavel_IDMedico` int DEFAULT NULL,
  `fk_UsuatioPaciente_IDpaciente` int DEFAULT NULL
);
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
);
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
);
CREATE TABLE `armazena` (
  `fk_Chat___Conversa_IDConversa` int DEFAULT NULL,
  `fk_Mensagens_IDMesnagens` int DEFAULT NULL,
  KEY `FK_Armazena_1` (`fk_Chat___Conversa_IDConversa`),
  KEY `FK_Armazena_2` (`fk_Mensagens_IDMesnagens`),
  CONSTRAINT `FK_Armazena_1` FOREIGN KEY (`fk_Chat___Conversa_IDConversa`) REFERENCES `chat___conversa` (`IDConversa`) ON DELETE RESTRICT,
  CONSTRAINT `FK_Armazena_2` FOREIGN KEY (`fk_Mensagens_IDMesnagens`) REFERENCES `mensagens` (`IDMesnagens`) ON DELETE RESTRICT
);
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
);
