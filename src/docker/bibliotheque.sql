-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 05, 2020 at 06:12 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bibliotheque`
--

-- --------------------------------------------------------

--
-- Table structure for table `auteurs`
--

CREATE TABLE `auteurs` (
  `idauteurs` int(11) NOT NULL,
  `auteur` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `emplacement`
--

CREATE TABLE `emplacement` (
  `idemplacement` int(11) NOT NULL,
  `nomemplacement` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `emplacement_livre`
--

CREATE TABLE `emplacement_livre` (
  `fk_idemplacement` int(11) NOT NULL,
  `fk_idlivres` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `emprunts`
--

CREATE TABLE `emprunts` (
  `idemprunt` int(11) NOT NULL,
  `dateemprunt` datetime DEFAULT NULL,
  `fk_idutilisateur` int(11) NOT NULL,
  `fk_idexemplaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `exemplaire`
--

CREATE TABLE `exemplaire` (
  `idexemplaire` int(11) NOT NULL,
  `disponibilite` tinyint(4) DEFAULT NULL,
  `fk_idlivres` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `livres`
--

CREATE TABLE `livres` (
  `idlivres` int(11) NOT NULL,
  `titre` varchar(100) DEFAULT NULL,
  `description` longtext DEFAULT NULL,
  `isbn` varchar(13) DEFAULT NULL,
  `code` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `livre_auteur`
--

CREATE TABLE `livre_auteur` (
  `fk_idlivres` int(11) NOT NULL,
  `fk_idauteurs` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `idutilisateurs` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `datenaissance` date DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `pseudo` varchar(45) DEFAULT NULL,
  `motdepasse` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auteurs`
--
ALTER TABLE `auteurs`
  ADD PRIMARY KEY (`idauteurs`),
  ADD UNIQUE KEY `auteur` (`auteur`);

--
-- Indexes for table `emplacement`
--
ALTER TABLE `emplacement`
  ADD PRIMARY KEY (`idemplacement`);

--
-- Indexes for table `emplacement_livre`
--
ALTER TABLE `emplacement_livre`
  ADD KEY `fk_idemplacement` (`fk_idemplacement`),
  ADD KEY `fk_idlivres` (`fk_idlivres`);

--
-- Indexes for table `emprunts`
--
ALTER TABLE `emprunts`
  ADD PRIMARY KEY (`idemprunt`),
  ADD KEY `fk_idutilisateur` (`fk_idutilisateur`),
  ADD KEY `fk_idexemplaire` (`fk_idexemplaire`);

--
-- Indexes for table `exemplaire`
--
ALTER TABLE `exemplaire`
  ADD PRIMARY KEY (`idexemplaire`),
  ADD KEY `fk_idlivres` (`fk_idlivres`);

--
-- Indexes for table `livres`
--
ALTER TABLE `livres`
  ADD PRIMARY KEY (`idlivres`);

--
-- Indexes for table `livre_auteur`
--
ALTER TABLE `livre_auteur`
  ADD KEY `fk_idlivres` (`fk_idlivres`),
  ADD KEY `fk_idauteurs` (`fk_idauteurs`);

--
-- Indexes for table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`idutilisateurs`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `auteurs`
--
ALTER TABLE `auteurs`
  MODIFY `idauteurs` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `emplacement`
--
ALTER TABLE `emplacement`
  MODIFY `idemplacement` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `emprunts`
--
ALTER TABLE `emprunts`
  MODIFY `idemprunt` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `exemplaire`
--
ALTER TABLE `exemplaire`
  MODIFY `idexemplaire` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `livres`
--
ALTER TABLE `livres`
  MODIFY `idlivres` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `idutilisateurs` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `emplacement_livre`
--
ALTER TABLE `emplacement_livre`
  ADD CONSTRAINT `emplacement_livre_ibfk_1` FOREIGN KEY (`fk_idemplacement`) REFERENCES `emplacement` (`idemplacement`),
  ADD CONSTRAINT `emplacement_livre_ibfk_2` FOREIGN KEY (`fk_idlivres`) REFERENCES `livres` (`idlivres`);

--
-- Constraints for table `emprunts`
--
ALTER TABLE `emprunts`
  ADD CONSTRAINT `emprunts_ibfk_1` FOREIGN KEY (`fk_idutilisateur`) REFERENCES `utilisateurs` (`idutilisateurs`),
  ADD CONSTRAINT `emprunts_ibfk_2` FOREIGN KEY (`fk_idexemplaire`) REFERENCES `exemplaire` (`idexemplaire`);

--
-- Constraints for table `exemplaire`
--
ALTER TABLE `exemplaire`
  ADD CONSTRAINT `exemplaire_ibfk_1` FOREIGN KEY (`fk_idlivres`) REFERENCES `livres` (`idlivres`);

--
-- Constraints for table `livre_auteur`
--
ALTER TABLE `livre_auteur`
  ADD CONSTRAINT `livre_auteur_ibfk_1` FOREIGN KEY (`fk_idlivres`) REFERENCES `livres` (`idlivres`),
  ADD CONSTRAINT `livre_auteur_ibfk_2` FOREIGN KEY (`fk_idauteurs`) REFERENCES `auteurs` (`idauteurs`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
