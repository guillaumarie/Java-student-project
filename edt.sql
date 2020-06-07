-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Jun 07, 2020 at 12:08 PM
-- Server version: 8.0.18
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `edt`
--

-- --------------------------------------------------------

--
-- Table structure for table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `cours`
--

INSERT INTO `cours` (`ID`, `Nom`) VALUES
(1, 'Probabilités et statistiques'),
(2, 'Analyse financière et économique'),
(3, 'Initiation Réseaux'),
(4, 'POO Java'),
(5, 'Anglais 6'),
(6, 'Allemand'),
(7, 'Arabe'),
(8, 'Espagnol'),
(9, 'Russe'),
(10, 'Italien'),
(11, 'Chinois'),
(12, 'Coréen'),
(13, 'Japonais'),
(14, 'Analyse de Fourier'),
(15, 'Anthropologie'),
(16, 'Droit du travail'),
(17, 'Implication promotion école'),
(18, 'Amphi d\'accueil'),
(19, 'Amphi d\'information'),
(20, 'MOOC Nanotechnologies'),
(21, 'VPE'),
(22, 'Projet d\'électronique'),
(23, 'Projet Web dynamique'),
(24, 'Table Ronde Métiers'),
(25, 'Thermodynamique'),
(26, 'Traitement du signal 1'),
(27, 'Traitement du signal 2'),
(28, 'Web dynamique'),
(29, 'Projet Java'),
(30, 'Electromagnétisme'),
(31, 'Ingénieur et société'),
(32, 'PSTE'),
(33, 'C++'),
(34, 'Projet C++'),
(35, 'Théorie des graphes'),
(36, 'Projet Théorie des graphes'),
(37, 'Electronique fondamentale'),
(38, 'Projet VHDL'),
(39, 'Mathématiques 4');

-- --------------------------------------------------------

--
-- Table structure for table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `ID_Utilisateur` int(11) NOT NULL,
  `ID_Cours` int(11) NOT NULL,
  PRIMARY KEY (`ID_Utilisateur`,`ID_Cours`),
  KEY `enseignant_id_cours` (`ID_Cours`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `enseignant`
--

INSERT INTO `enseignant` (`ID_Utilisateur`, `ID_Cours`) VALUES
(75, 1),
(102, 1),
(91, 2),
(69, 3),
(92, 3),
(103, 3),
(2, 4),
(73, 4),
(86, 5),
(104, 7),
(3, 14),
(63, 14),
(64, 14),
(66, 14),
(68, 15),
(84, 15),
(78, 16),
(94, 19),
(71, 21),
(76, 21),
(80, 22),
(2, 23),
(73, 23),
(74, 23),
(70, 25),
(72, 25),
(85, 25),
(62, 26),
(77, 26),
(80, 26),
(82, 26),
(62, 27),
(77, 27),
(80, 27),
(82, 27),
(2, 28),
(73, 28),
(74, 28),
(2, 29),
(67, 30),
(70, 30),
(81, 30),
(68, 31),
(76, 32),
(93, 33),
(93, 34),
(93, 35),
(93, 36),
(62, 37),
(77, 38),
(63, 39),
(79, 39);

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_Utilisateur` int(11) NOT NULL,
  `Numero` int(11) NOT NULL,
  `ID_Groupe` int(11) NOT NULL,
  PRIMARY KEY (`ID_Utilisateur`),
  KEY `etudiant_id_groupe` (`ID_Groupe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`ID_Utilisateur`, `Numero`, `ID_Groupe`) VALUES
(4, 931801215, 1),
(5, 931701883, 1),
(6, 931702399, 1),
(7, 931800900, 1),
(8, 931702145, 1),
(9, 931702156, 1),
(10, 931701657, 1),
(11, 931701672, 1),
(12, 931701581, 2),
(13, 931701587, 2),
(14, 931701605, 2),
(15, 931800051, 2),
(16, 931900554, 2),
(17, 931900570, 3),
(18, 931701594, 3),
(19, 931701601, 3),
(20, 931702125, 3),
(21, 931702135, 3),
(22, 931701572, 4),
(23, 931800052, 4),
(24, 931702138, 4),
(25, 931701634, 4),
(26, 931701645, 4),
(27, 931900601, 5),
(28, 931702122, 5),
(29, 931700108, 5),
(30, 931900713, 5),
(31, 931702378, 5),
(32, 931900722, 6),
(33, 931900732, 6),
(34, 931700133, 6),
(35, 931900752, 6),
(36, 931702146, 6),
(37, 931702113, 7),
(38, 931701646, 7),
(39, 931701656, 7),
(40, 931900675, 7),
(41, 931800067, 7),
(42, 931701588, 8),
(43, 931700048, 8),
(44, 931701616, 8),
(45, 931701618, 8),
(46, 931701623, 8),
(47, 931701590, 9),
(48, 931702126, 9),
(49, 931701622, 9),
(50, 931703047, 9),
(51, 931801199, 9),
(52, 931702376, 10),
(53, 931701602, 10),
(54, 931702123, 10),
(55, 931801318, 10),
(56, 931900572, 10),
(57, 931700106, 11),
(58, 931702132, 11),
(59, 931800987, 11),
(60, 931900568, 11),
(61, 931800870, 11),
(96, 978542233, 35),
(97, 46899542, 39),
(98, 54622879, 45),
(99, 878554623, 41),
(100, 65789542, 33),
(101, 2547896, 37);

-- --------------------------------------------------------

--
-- Table structure for table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `ID_Promotion` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `groupe_id_promo` (`ID_Promotion`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `groupe`
--

INSERT INTO `groupe` (`ID`, `Nom`, `ID_Promotion`) VALUES
(1, 'TD 1', 3),
(2, 'TD 2', 3),
(3, 'TD 3', 3),
(4, 'TD 4', 3),
(5, 'TD 5', 3),
(6, 'TD 6', 3),
(7, 'TD 7', 3),
(8, 'TD 8', 3),
(9, 'TD 9', 3),
(10, 'TD 10', 3),
(11, 'TD 11', 3),
(13, 'TD 1', 1),
(14, 'TD 2', 1),
(15, 'TD 3', 1),
(16, 'TD 4', 1),
(17, 'TD 5', 1),
(18, 'TD 6', 1),
(19, 'TD 7', 1),
(20, 'TD 8', 1),
(21, 'TD 9', 1),
(22, 'TD 10', 1),
(23, 'TD 1', 2),
(24, 'TD 2', 2),
(25, 'TD 3', 2),
(26, 'TD 4', 2),
(27, 'TD 5', 2),
(28, 'TD 6', 2),
(29, 'TD 7', 2),
(30, 'TD 8', 2),
(31, 'TD 9', 2),
(32, 'TD 10', 2),
(33, 'Finance 1', 4),
(34, 'Finance 2', 4),
(35, 'Environnement Fr', 4),
(36, 'Environnement Inter', 4),
(37, 'OCRES 1', 4),
(38, 'OCRES 2', 4),
(39, 'Santé', 4),
(40, 'SI Fr 1', 4),
(41, 'SI Fr 2', 4),
(42, 'SI Inter 1', 4),
(43, 'SI Inter 2', 4),
(44, 'SE Fr', 4),
(45, 'SE Inter', 4),
(46, 'Finance', 5),
(47, 'Environnement Fr', 5),
(48, 'Environnement Inter', 5),
(49, 'OCRES', 5),
(50, 'Santé', 5),
(51, 'SI Fr', 5),
(52, 'SI Inter', 5),
(53, 'SE Fr', 5),
(54, 'SE Inter', 5);

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`ID`, `Nom`) VALUES
(1, 'ING 1'),
(2, 'ING 2'),
(3, 'ING 3'),
(4, 'ING 4'),
(5, 'ING 5');

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Capacite` int(11) NOT NULL,
  `ID_Site` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `salle_id_site` (`ID_Site`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `salle`
--

INSERT INTO `salle` (`ID`, `Nom`, `Capacite`, `ID_Site`) VALUES
(1, 'Labo P314', 25, 2),
(2, 'Labo P315B', 25, 2),
(3, 'Labo P317', 25, 2),
(4, 'Labo P345', 25, 2),
(5, 'Labo P406', 25, 2),
(6, 'Labo P416', 25, 2),
(7, 'Labo P417', 25, 2),
(8, 'Labo P429', 25, 2),
(9, 'Labo P430', 25, 2),
(10, 'Labo P447', 25, 2),
(11, 'Salle EM219', 40, 1),
(12, 'Salle FabLab', 10, 2),
(13, 'Salle P304', 80, 2),
(14, 'Salle P305', 25, 2),
(15, 'Salle P306', 25, 2),
(16, 'Salle P307', 40, 2),
(17, 'Salle P308', 10, 2),
(18, 'Salle P315A', 40, 2),
(19, 'Salle P316', 40, 2),
(20, 'Salle P346', 40, 2),
(21, 'Salle P347', 40, 2),
(22, 'Salle P348', 40, 2),
(23, 'Salle P404', 10, 2),
(24, 'Salle P405', 15, 2),
(25, 'Salle P407', 40, 2),
(26, 'Salle P415', 80, 2),
(27, 'Salle P440', 40, 2),
(28, 'Salle P445', 80, 2),
(29, 'Salle P446', 40, 2),
(30, 'Salle SC008', 80, 1),
(31, 'Amphi 1', 150, 7),
(32, 'Amphi 1', 150, 7),
(33, 'Amphi 3', 150, 7),
(34, 'Amphi EM009', 150, 1),
(35, 'Amphi EM010', 150, 1),
(36, 'Amphi', 150, 5),
(37, 'Amphi', 150, 6),
(38, 'Salle G007', 25, 4),
(39, 'Salle G002', 150, 4),
(40, 'Salle G003', 25, 4),
(41, 'Salle G004', 25, 4),
(42, 'Salle G005', 25, 4),
(43, 'Salle G006', 25, 4),
(44, 'Salle G008', 40, 4),
(45, 'Salle G009', 40, 4),
(46, 'Salle G010', 40, 4),
(47, 'Salle G011', 25, 4),
(48, 'Salle G012', 25, 4),
(49, 'Salle G013', 25, 4),
(50, 'Salle G014', 25, 4),
(51, 'Salle G015', 25, 4),
(52, 'Salle G016', 25, 4),
(53, 'ZOOM', 300, 8);

-- --------------------------------------------------------

--
-- Table structure for table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Semaine` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Heure_Debut` time NOT NULL,
  `Heure_Fin` time NOT NULL,
  `Etat` tinyint(1) NOT NULL,
  `ID_Cours` int(11) NOT NULL,
  `ID_Type` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `seance_id_cours` (`ID_Cours`),
  KEY `seance_id_type` (`ID_Type`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `seance`
--

INSERT INTO `seance` (`ID`, `Semaine`, `Date`, `Heure_Debut`, `Heure_Fin`, `Etat`, `ID_Cours`, `ID_Type`) VALUES
(2, 17, '2020-04-20', '08:30:00', '10:00:00', 1, 4, 1),
(3, 17, '2020-04-20', '15:30:00', '17:00:00', 1, 4, 3),
(4, 17, '2020-04-21', '10:15:00', '11:45:00', 1, 25, 1),
(5, 17, '2020-04-21', '13:45:00', '15:15:00', 1, 25, 2),
(6, 17, '2020-04-21', '15:30:00', '17:00:00', 1, 15, 1),
(7, 17, '2020-04-22', '08:30:00', '10:00:00', 1, 1, 2),
(8, 17, '2020-04-22', '10:15:00', '11:45:00', 1, 14, 1),
(9, 17, '2020-04-22', '12:00:00', '13:30:00', 1, 26, 1),
(10, 17, '2020-04-22', '15:30:00', '17:00:00', 1, 14, 2),
(11, 17, '2020-04-22', '17:15:00', '18:45:00', 1, 26, 3),
(12, 17, '2020-04-23', '15:30:00', '16:30:00', 1, 19, 6),
(13, 23, '2020-06-01', '08:30:00', '10:00:00', 1, 23, 4),
(14, 23, '2020-06-01', '10:15:00', '11:45:00', 1, 23, 4),
(15, 23, '2020-06-01', '12:00:00', '13:30:00', 1, 5, 1),
(16, 23, '2020-06-01', '15:30:00', '17:00:00', 1, 23, 3),
(17, 23, '2020-06-01', '17:15:00', '18:45:00', 1, 1, 2),
(18, 23, '2020-06-02', '10:15:00', '11:45:00', 1, 4, 1),
(19, 23, '2020-06-02', '13:45:00', '15:15:00', 1, 27, 1),
(20, 23, '2020-06-02', '15:30:00', '17:00:00', 1, 27, 1),
(21, 23, '2020-06-02', '17:15:00', '18:45:00', 1, 7, 1),
(22, 23, '2020-06-03', '08:30:00', '10:00:00', 1, 3, 1),
(23, 23, '2020-06-03', '10:15:00', '11:45:00', 1, 3, 1),
(24, 23, '2020-06-04', '08:30:00', '10:00:00', 1, 7, 1),
(25, 23, '2020-06-04', '10:15:00', '11:45:00', 1, 15, 1),
(26, 23, '2020-06-04', '14:45:00', '16:15:00', 1, 26, 9),
(27, 23, '2020-06-04', '16:45:00', '17:45:00', 1, 2, 9),
(28, 24, '2020-06-08', '12:00:00', '13:30:00', 1, 21, 4),
(29, 24, '2020-06-08', '13:45:00', '15:15:00', 1, 27, 1),
(30, 24, '2020-06-08', '15:30:00', '17:00:00', 1, 4, 3),
(31, 24, '2020-06-08', '17:15:00', '18:45:00', 1, 15, 1),
(32, 24, '2020-06-09', '08:30:00', '10:00:00', 1, 27, 3),
(33, 24, '2020-06-09', '10:15:00', '11:45:00', 1, 27, 3),
(34, 24, '2020-06-09', '13:45:00', '15:15:00', 1, 4, 3),
(35, 24, '2020-06-09', '15:30:00', '17:00:00', 1, 16, 1),
(36, 24, '2020-06-10', '13:45:00', '15:15:00', 1, 4, 1),
(37, 24, '2020-06-10', '17:15:00', '18:45:00', 1, 16, 1),
(38, 24, '2020-06-11', '10:15:00', '11:15:00', 1, 25, 9),
(39, 24, '2020-06-11', '12:00:00', '13:30:00', 1, 14, 9),
(40, 24, '2020-06-11', '15:30:00', '17:00:00', 1, 4, 4),
(41, 24, '2020-06-12', '08:30:00', '10:00:00', 1, 1, 1),
(42, 24, '2020-06-12', '10:15:00', '11:45:00', 1, 1, 1),
(43, 24, '2020-06-12', '13:45:00', '15:15:00', 1, 4, 3),
(44, 24, '2020-06-12', '17:15:00', '18:45:00', 1, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `seance_enseignants`
--

DROP TABLE IF EXISTS `seance_enseignants`;
CREATE TABLE IF NOT EXISTS `seance_enseignants` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Enseignant` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Enseignant`),
  KEY `seance_enseignants_id_enseignant` (`ID_Enseignant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `seance_enseignants`
--

INSERT INTO `seance_enseignants` (`ID_Seance`, `ID_Enseignant`) VALUES
(2, 2),
(3, 2),
(18, 2),
(30, 2),
(34, 2),
(36, 2),
(40, 2),
(43, 2),
(10, 3),
(9, 62),
(8, 66),
(5, 70),
(13, 74),
(14, 74),
(16, 74),
(7, 75),
(41, 75),
(42, 75),
(44, 75),
(28, 76),
(35, 78),
(37, 78),
(11, 80),
(19, 80),
(20, 80),
(29, 80),
(32, 80),
(33, 80),
(6, 84),
(25, 84),
(31, 84),
(4, 85),
(15, 86),
(12, 94),
(17, 102),
(22, 103),
(23, 103),
(21, 104),
(24, 104);

-- --------------------------------------------------------

--
-- Table structure for table `seance_groupes`
--

DROP TABLE IF EXISTS `seance_groupes`;
CREATE TABLE IF NOT EXISTS `seance_groupes` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Groupe` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Groupe`),
  KEY `seance_groupes_id_groupe` (`ID_Groupe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `seance_groupes`
--

INSERT INTO `seance_groupes` (`ID_Seance`, `ID_Groupe`) VALUES
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(15, 1),
(16, 1),
(17, 1),
(18, 1),
(19, 1),
(20, 1),
(22, 1),
(23, 1),
(24, 1),
(25, 1),
(26, 1),
(27, 1),
(28, 1),
(29, 1),
(30, 1),
(31, 1),
(32, 1),
(33, 1),
(34, 1),
(35, 1),
(36, 1),
(37, 1),
(38, 1),
(39, 1),
(40, 1),
(41, 1),
(42, 1),
(43, 1),
(44, 1),
(2, 2),
(4, 2),
(8, 2),
(9, 2),
(10, 2),
(12, 2),
(18, 2),
(19, 2),
(20, 2),
(21, 2),
(26, 2),
(27, 2),
(28, 2),
(29, 2),
(35, 2),
(36, 2),
(37, 2),
(38, 2),
(39, 2),
(40, 2),
(41, 2),
(42, 2),
(2, 3),
(4, 3),
(8, 3),
(9, 3),
(12, 3),
(18, 3),
(19, 3),
(20, 3),
(22, 3),
(23, 3),
(26, 3),
(27, 3),
(28, 3),
(29, 3),
(36, 3),
(38, 3),
(39, 3),
(40, 3),
(41, 3),
(42, 3),
(2, 4),
(4, 4),
(8, 4),
(9, 4),
(18, 4),
(19, 4),
(20, 4),
(28, 4),
(29, 4),
(36, 4),
(40, 4),
(41, 4),
(42, 4),
(18, 5),
(28, 5),
(40, 5),
(18, 6),
(22, 6),
(23, 6),
(40, 6),
(12, 7),
(18, 7),
(40, 7),
(12, 8),
(18, 8),
(40, 8),
(40, 9),
(40, 10),
(40, 11);

-- --------------------------------------------------------

--
-- Table structure for table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Salle` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Salle`),
  KEY `seance_salles_id_salle` (`ID_Salle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `seance_salles`
--

INSERT INTO `seance_salles` (`ID_Seance`, `ID_Salle`) VALUES
(3, 2),
(26, 2),
(44, 2),
(34, 4),
(43, 4),
(11, 5),
(13, 6),
(14, 6),
(16, 6),
(30, 7),
(32, 9),
(33, 9),
(15, 15),
(5, 19),
(6, 21),
(7, 21),
(25, 22),
(21, 24),
(24, 24),
(37, 26),
(17, 27),
(26, 28),
(27, 28),
(35, 28),
(26, 29),
(27, 29),
(19, 32),
(20, 32),
(41, 32),
(42, 32),
(2, 34),
(18, 34),
(22, 34),
(23, 34),
(29, 34),
(38, 34),
(8, 35),
(9, 35),
(18, 35),
(36, 35),
(39, 35),
(4, 37),
(26, 38),
(27, 38),
(10, 39),
(26, 39),
(27, 39),
(26, 40),
(27, 40),
(26, 41),
(27, 41),
(26, 42),
(27, 42),
(26, 43),
(27, 43),
(31, 52),
(12, 53),
(28, 53),
(40, 53);

-- --------------------------------------------------------

--
-- Table structure for table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `site`
--

INSERT INTO `site` (`ID`, `Nom`) VALUES
(1, 'EIFFEL 1'),
(2, 'EIFFEL 2'),
(3, 'EIFFEL 3'),
(4, 'EIFFEL 4'),
(5, 'EIFFEL 5'),
(6, 'VELL'),
(7, 'CNAM'),
(8, 'ONLINE');

-- --------------------------------------------------------

--
-- Table structure for table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `type_cours`
--

INSERT INTO `type_cours` (`ID`, `Nom`) VALUES
(1, 'Cours magistral'),
(2, 'TD'),
(3, 'TP'),
(4, 'Projet'),
(5, 'Soutien'),
(6, 'Amphi de présentation'),
(7, 'Conférence'),
(8, 'MOOC'),
(9, 'Examen');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `Droit` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `Email`, `Password`, `Nom`, `Prenom`, `Droit`) VALUES
(1, 'christophe.baujault@ece.fr', 'admin', 'BAUJAULT', 'Christophe', 1),
(2, 'jean-pierre.segado@ece.fr', 'azerty', 'SEGADO', 'Jean-Pierre', 3),
(3, 'laurent.delisle@umontreal.ca', 'azerty', 'DELISLE', 'Laurent', 3),
(4, 'guillaume.marie@edu.ece.fr', '1111', 'MARIE', 'Guillaume', 4),
(5, 'killian.lennon@edu.ece.fr', '2222', 'LENNON', 'Killian', 4),
(6, 'larys.quistin@edu.ece.fr', '3333', 'QUISTIN', 'Larys', 4),
(7, 'alexandre.baumgarth@edu.ece.fr', '0000', 'BAUMGARTH', 'Alexandre', 4),
(8, 'antoine.bourgeois@edu.ece.fr', '0000', 'BOURGEOIS', 'Antoine', 4),
(9, 'matheo.cambier@edu.ece.fr', '0000', 'CAMBIER', 'Mathéo', 4),
(10, 'luka.carneiro@edu.ece.fr', '0000', 'CARNEIRO', 'Luka', 4),
(11, 'pascal.chen@edu.ece.fr', '0000', 'CHEN', 'Pascal', 4),
(12, 'sawsane.aloui@edu.ece.fr', '0000', 'ALOUI', 'Sawsane', 4),
(13, 'xavier.antoine@edu.ece.fr', '0000', 'ANTOINE', 'Xavier', 4),
(14, 'lea.belliard@edu.ece.fr', '0000', 'BELLIARD', 'Léa', 4),
(15, 'remi.breton@edu.ece.fr', '0000', 'BRETON', 'Rémi', 4),
(16, 'estelle.cano@edu.ece.fr', '0000', 'CANO', 'Estelle', 4),
(17, 'enzo.aguecci@edu.ece.fr', '0000', 'AGUECCI', 'Enzo', 4),
(18, 'carl.badaoui@edu.ece.fr', '0000', 'BADAOUI', 'Carl', 4),
(19, 'clement.bartoli@edu.ece.fr', '0000', 'BARTOLI', 'Clément', 4),
(20, 'ines.belloir@edu.ece.fr', '0000', 'BELLOIR', 'Ines', 4),
(21, 'romain.bernard@edu.ece.fr', '0000', 'BERNARD', 'Romain', 4),
(22, 'yacin-malo.abdoulnasir@edu.ece.fr', '0000', 'ABDOULNASIR', 'Yacin-Malo', 4),
(23, 'charlotte.bichot@edu.ece.fr', '0000', 'BICHOT', 'Charlotte', 4),
(24, 'alexandre.bizord@edu.ece.fr', '0000', 'BIZORD', 'Alexandre', 4),
(25, 'valentin.boucher@edu.ece.fr', '0000', 'BOUCHER', 'Valentin', 4),
(26, 'camille.bruant@edu.ece.fr', '0000', 'BRUANT', 'Camille', 4),
(27, 'heddi.adoudi@edu.ece.fr', '0000', 'ADOUDI', 'Heddi', 4),
(28, 'thomas.bastide@edu.ece.fr', '0000', 'BASTIDE', 'Thomas', 4),
(29, 'chloe.baut@edu.ece.fr', '0000', 'BAUT', 'Chloé', 4),
(30, 'samy.benrahhalate@edu.ece.fr', '0000', 'BENRAHHALATE', 'Samy', 4),
(31, 'youssef.benslimane@edu.ece.fr', '0000', 'BENSLIMANE', 'Youssef', 4),
(32, 'simon.abul-kalam@edu.ece.fr', '0000', 'ABUL KALAM', 'Simon', 4),
(33, 'oumar.anne@edu.ece.fr', '0000', 'ANNE', 'Oumar', 4),
(34, 'antoine.benard@edu.ece.fr', '0000', 'BENARD', 'Antoine', 4),
(35, 'zakaria.berguen@edu.ece.fr', '0000', 'BERGUEN', 'Zakaria', 4),
(36, 'matthieu.boyer@edu.ece.fr', '0000', 'BOYER', 'Matthieu', 4),
(37, 'jade.anbari@edu.ece.fr', '0000', 'ANBARI', 'Jade', 4),
(38, 'timothe.bruckert@edu.ece.fr', '0000', 'BRUCKERT', 'Timothé', 4),
(39, 'dominik.carbon@edu.ece.fr', '0000', 'CARBON', 'Dominik', 4),
(40, 'valentin.carron@edu.ece.fr', '0000', 'CARRON', 'Valentin', 4),
(41, 'emma.chauvet@edu.ece.fr', '0000', 'CHAUVET', 'Emma', 4),
(42, 'melchior.arnal@edu.ece.fr', '0000', 'ARNAL', 'Melchior', 4),
(43, 'thibault.arnold@edu.ece.fr', '0000', 'ARNOLD', 'Thibault', 4),
(44, 'paul.biancalana@edu.ece.fr', '0000', 'BIANCALANA', 'Paul', 4),
(45, 'lucie.blin@edu.ece.fr', '0000', 'BLIN', 'Lucie', 4),
(46, 'timothee.bois@edu.ece.fr', '0000', 'BOIS', 'Timothée', 4),
(47, 'gabriel.attal@edu.ece.fr', '0000', 'ATTAL', 'Gabriel', 4),
(48, 'jorge.belmonte-jimenez@edu.ece.fr', '0000', 'BELMONTE-JIMENEZ', 'Jorge', 4),
(49, 'celia.bocher@edu.ece.fr', '0000', 'BOCHER', 'Célia', 4),
(50, 'quentin.bonnard@edu.ece.fr', '0000', 'BONNARD', 'Quentin', 4),
(51, 'merwane.boumediene-refosco@edu.ece.fr', '0000', 'BOUMEDIENE-REFOSCO', 'Merwane', 4),
(52, 'jorge.ayllon-chaupis@edu.ece.fr', '0000', 'AYLLON CHAUPIS', 'Jorge', 4),
(53, 'axel.basocak@edu.ece.fr', '0000', 'BASOCAK', 'Axel', 4),
(54, 'clement.bazart@edu.ece.fr', '0000', 'BAZART', 'Clément', 4),
(55, 'theo.beaujois@edu.ece.fr', '0000', 'BEAUJOIS', 'Théo', 4),
(56, 'noemie.begey@edu.ece.fr', '0000', 'BEGEY', 'Noémie', 4),
(57, 'mathieu.baumas@edu.ece.fr', '0000', 'BAUMAS', 'Mathieu', 4),
(58, 'aristide.bentz@edu.ece.fr', '0000', 'BENTZ', 'Aristide', 4),
(59, 'edouard.botherel@edu.ece.fr', '0000', 'BOTHEREL', 'Edouard', 4),
(60, 'wassim.bouhtout@edu.ece.fr', '0000', 'BOUHTOUT', 'Wassim', 4),
(61, 'baptiste.boyer@edu.ece.fr', '0000', 'BOYER', 'Baptiste', 4),
(62, 'bouabd2001@yahoo.fr', 'azerty', 'BOUBEZOUL', 'Abderrahmane', 3),
(63, 'scerbah@yahoo.fr', 'azerty', 'CERBAH', 'Said', 3),
(64, 'anis.chaari@ece.fr', 'azerty', 'CHAARI', 'Anis', 3),
(65, 'emmaclarke2000@hotmail.com', 'azerty', 'CLARKE', 'Emma', 3),
(66, 'fabienne.coudray@ece.fr', 'azerty', 'COUDRAY', 'Fabienne', 3),
(67, 'christine.crambes@ece.fr', 'azerty', 'CRAMBES', 'Christine', 3),
(68, 'bcrimail@yahoo.fr', 'azerty', 'CRIMAIL', 'Bertrand', 3),
(69, 'aghilesdjoudi@gmail.com', 'azerty', 'DJOUDI', 'Aghiles', 3),
(70, 'serena.gallanti@ece.fr', 'azerty', 'GALLANTI', 'Serena', 3),
(71, 'olivier.girinsky@ece.fr', 'azerty', 'GIRINSKY', 'Olivier', 3),
(72, 'thomas.guillemot@ece.fr', 'azerty', 'GUILLEMOT', 'Thomas', 3),
(73, 'manolo-dulva.hina@ece.fr', 'azerty', 'HINA', 'Manolo', 3),
(74, 'adrien.kourganoff@ece.fr', 'azerty', 'KOURGANOFF', 'Adrien', 3),
(75, 'luc.le-cor@edu.ece.fr', 'azerty', 'LE COR', 'Luc', 3),
(76, 'stephanie.le-marec@ece.fr', 'azerty', 'LE MAREC', 'Stéphanie', 3),
(77, 'nicolas@lopes.io', 'azerty', 'LOPES', 'Nicolas', 3),
(78, 'yves.maupile@yahoo.fr', 'azerty', 'MAUPILE', 'Yves', 3),
(79, 'houari.mechkour@ece.fr', 'azerty', 'MECHKOUR', 'Houari', 3),
(80, 'arash.mokhber@gmail.com', 'azerty', 'MOKHBER', 'Arash', 3),
(81, 'waleed.mouhali@ece.fr', 'azerty', 'MOUHALI', 'Waleed', 3),
(82, 'fatma-zohra.nacer@ece.fr', 'azerty', 'NACER', 'Nassima', 3),
(83, 'jpalasi@inseec-edu.com', 'azerty', 'PALASI', 'Julienne', 3),
(84, 'nprinzhorn@gmail.com', 'azerty', 'PRINZHORN', 'Nina', 3),
(85, 'michel.pullicino@free.fr', 'azerty', 'PULLICINO', 'Michel', 3),
(86, 'james@jamesreesebooks.com', 'azerty', 'REESE', 'James', 3),
(87, 'elisabeth.rendler@ece.fr', 'azerty', 'RENDLER', 'Elisabeth', 3),
(88, 'jacques.rossard@ece.fr', 'azerty', 'ROSSARD', 'Jacques', 3),
(89, 'maxime.schneider@ece.fr', 'azerty', 'SCHNEIDER', 'Maxime', 3),
(90, 'assia.soukane@ece.fr', 'azerty', 'SOUKANE', 'Assia', 3),
(91, 'francesco.turzi@orange.fr', 'azerty', 'TURZI', 'Francesco', 3),
(92, 'rafik.zitouni@ece.fr', 'azerty', 'ZITOUNI', 'Rafik', 3),
(93, 'rfercoq@inseec-edu.com', 'azerty', 'FERCOQ', 'Robin', 3),
(94, 'nicolas.dacher@ece.fr', 'azerty', 'DACHER', 'Nicolas', 3),
(95, 'murielle.caravelle@edu.ece.fr', '1234', 'CARAVELLE', 'Murielle', 2),
(96, 'nicolas.hulot@edu.ece.fr', '0000', 'HULOT', 'Nicolas', 4),
(97, 'didier.raoult@edu.ece.fr', '0000', 'RAOULT', 'Didier', 4),
(98, 'carlos.ghosn@edu.ece.fr', '0000', 'GHOSN', 'Carlos', 4),
(99, 'cedric.o@edu.ece.fr', '0000', 'O', 'Cédric', 4),
(100, 'bruno.lemaire@edu.ece.fr', '0000', 'LEMAIRE', 'Bruno', 4),
(101, 'pascal.obispo', '0000', 'OBISPO', 'Pascal', 4),
(102, 'begricheyoucef@yahoo.fr', 'azerty', 'BEGRICHE', 'Youcef', 3),
(103, 'naila.bouchemal@ece.fr', 'azerty', 'BOUCHEMAL', 'Naila', 3),
(104, 'assia.barchiche@ece.fr', 'azerty', 'BARCHICHE', 'Assia', 3);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `enseignant_heritage` FOREIGN KEY (`ID_Utilisateur`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `enseignant_id_cours` FOREIGN KEY (`ID_Cours`) REFERENCES `cours` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_heritage` FOREIGN KEY (`ID_Utilisateur`) REFERENCES `utilisateur` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etudiant_id_groupe` FOREIGN KEY (`ID_Groupe`) REFERENCES `groupe` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `groupe_id_promo` FOREIGN KEY (`ID_Promotion`) REFERENCES `promotion` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `salle_id_site` FOREIGN KEY (`ID_Site`) REFERENCES `site` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `seance_id_cours` FOREIGN KEY (`ID_Cours`) REFERENCES `cours` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seance_id_type` FOREIGN KEY (`ID_Type`) REFERENCES `type_cours` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `seance_enseignants`
--
ALTER TABLE `seance_enseignants`
  ADD CONSTRAINT `seance_enseignants_id_enseignant` FOREIGN KEY (`ID_Enseignant`) REFERENCES `enseignant` (`ID_Utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seance_enseignants_id_seance` FOREIGN KEY (`ID_Seance`) REFERENCES `seance` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `seance_groupes`
--
ALTER TABLE `seance_groupes`
  ADD CONSTRAINT `seance_groupes_id_groupe` FOREIGN KEY (`ID_Groupe`) REFERENCES `groupe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seance_groupes_id_seance` FOREIGN KEY (`ID_Seance`) REFERENCES `seance` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `seance_salles`
--
ALTER TABLE `seance_salles`
  ADD CONSTRAINT `seance_salles_id_salle` FOREIGN KEY (`ID_Salle`) REFERENCES `salle` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seance_salles_id_seance` FOREIGN KEY (`ID_Seance`) REFERENCES `seance` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
