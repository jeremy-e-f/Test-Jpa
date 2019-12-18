-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 18 déc. 2019 à 11:34
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bibliotheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `ID` int(10) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`ID`, `NOM`, `PRENOM`) VALUES
(1, 'Brigand', 'Pierre'),
(2, 'YU', 'Cheng'),
(3, 'BERRAD', 'Hicham');

-- --------------------------------------------------------

--
-- Structure de la table `compo`
--

CREATE TABLE `compo` (
  `ID` int(11) NOT NULL,
  `ID_LIV` int(10) NOT NULL,
  `ID_EMP` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `compo`
--

INSERT INTO `compo` (`ID`, `ID_LIV`, `ID_EMP`) VALUES
(1, 1, 1),
(2, 4, 1),
(3, 2, 2),
(4, 3, 2),
(5, 1, 3),
(6, 5, 4),
(7, 2, 4),
(8, 3, 5);

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

CREATE TABLE `emprunt` (
  `ID` int(10) NOT NULL,
  `DATE_DEBUT` datetime NOT NULL,
  `DATE_FIN` datetime DEFAULT NULL,
  `DELAI` int(10) DEFAULT NULL,
  `ID_CLIENT` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `emprunt`
--

INSERT INTO `emprunt` (`ID`, `DATE_DEBUT`, `DATE_FIN`, `DELAI`, `ID_CLIENT`) VALUES
(1, '2017-11-12 00:00:00', '2017-11-18 00:00:00', 15, 1),
(2, '2017-12-08 00:00:00', '2017-12-23 00:00:00', 30, 2),
(3, '2017-12-09 00:00:00', '2018-01-04 00:00:00', 30, 3),
(4, '2018-01-03 00:00:00', NULL, 21, 1),
(5, '2018-01-13 00:00:00', NULL, 21, 3);

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `ID` int(10) NOT NULL,
  `TITRE` varchar(255) NOT NULL,
  `AUTEUR` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`ID`, `TITRE`, `AUTEUR`) VALUES
(1, 'Vingt mille lieues sous les mers', 'Jules Verne'),
(2, 'Germinal', 'Emile Zola'),
(3, 'Guerre et paix', 'Léon Tolstoï'),
(4, 'Apprendre à parler aux animaux', 'Gaston Pouet'),
(5, '1001 recettes de Cuisine', 'Jean-Pierre Coffe');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `compo`
--
ALTER TABLE `compo`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `compo`
--
ALTER TABLE `compo`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
