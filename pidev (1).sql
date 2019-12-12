-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 12 avr. 2018 à 22:55
-- Version du serveur :  10.1.31-MariaDB
-- Version de PHP :  7.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pidev`
--

-- --------------------------------------------------------

--
-- Structure de la table `avis`
--

CREATE TABLE `avis` (
  `id` int(11) NOT NULL,
  `reponse` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `avis` double NOT NULL,
  `created` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `baby`
--

CREATE TABLE `baby` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `adrese` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `disponibilite` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idb` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prix` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datefin` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `numtel` int(11) NOT NULL,
  `etat` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `id_cat` int(11) DEFAULT NULL,
  `nom` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nbr_publications` int(11) NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `id_cat`, `nom`, `nbr_publications`, `type`) VALUES
(37, NULL, 'cat1', 0, 'categorie'),
(38, NULL, 'cat2test', 0, 'categorie'),
(40, 37, 'souscat1', 0, 'sous-categorie'),
(41, 37, 'soucat2', 0, 'sous-categorie'),
(42, 38, '', 0, 'sous-categorie'),
(43, 42, '', 0, 'sous-categorie'),
(44, 43, '', 0, 'sous-categorie'),
(45, 44, '', 0, 'sous-categorie'),
(46, 45, '', 0, 'sous-categorie'),
(47, 46, '', 0, 'sous-categorie'),
(48, 47, '', 0, 'sous-categorie');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `idp` int(11) NOT NULL,
  `idc` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prix` int(11) NOT NULL,
  `idf` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `image` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `age` int(11) NOT NULL,
  `genre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `etat` int(11) NOT NULL,
  `nomc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `categorie` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `idp`, `idc`, `nom`, `prix`, `idf`, `stock`, `quantite`, `image`, `description`, `age`, `genre`, `etat`, `nomc`, `categorie`) VALUES
(1, 1, 11, 'montre', 22, 0, 10, 4, '/images//images/aaa.jpg', 'sous marine', 2, 'garçon', 0, 'ahmed', 'chaussures'),
(2, 1, 11, 'montre', 22, 21, 7, 3, '/images//images/aaa.jpg', 'sous marine', 2, 'garçon', 0, 'ahmed', 'chaussures');

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `produit_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdAt` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `comment`
--

INSERT INTO `comment` (`id`, `produit_id`, `user_id`, `content`, `createdAt`) VALUES
(1, 1, 11, 'aaaa', '2018-04-12'),
(2, 1, 11, 'aaaaaaa', '2018-04-12'),
(3, 1, 11, 'aaaaaaasqdqsd', '2018-04-12');

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

CREATE TABLE `demande` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `adrese` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `disponibilite` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idb` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prix` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datefin` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `numtel` int(11) NOT NULL,
  `etat` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prix` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idu` int(11) NOT NULL,
  `particiate` int(11) DEFAULT NULL,
  `datedeb` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datefin` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nomorg` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lien` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id`, `nom`, `description`, `type`, `prix`, `idu`, `particiate`, `datedeb`, `datefin`, `nomorg`, `adresse`, `image`, `lien`) VALUES
(2, 'aaaa', 'qdfdqsf', 'Gratuit', '0', 5, 41, '2018-04-08', '2018-04-10', 'ghada', 'aaa', '/images/apple-touch-icon-144x144.png', NULL),
(3, 'aaaaaaaaaaaa', 'lùmgvghv', 'Gratuit', '0', 5, 10, '2018-04-08', '2018-04-19', 'ghada', 'aaaaaaaaaaa', '/images/29790397_2034282050156863_8363958027100965796_n.jpg', NULL),
(4, 'sdfsdfs', 'fefqdfsdfsdf', 'Gratuit', '0', 5, 9, '2018-04-11', '2018-04-13', 'ghada', 'dsfsdf', '/images/29790397_2034282050156863_8363958027100965796_n.jpg', 'https://www.youtube.com/watch?v=aZla1ttZHaw&index=3&list=RDLlU4FuIJT2k'),
(5, 'rrr', 'rrrrrrrrrrrrrr', 'Payant', '2255', 11, 2, '2018-04-12', '2018-04-26', 'ahmed', 'rrrrr', '/images/2018-04-09 04-58-31Pidev.jpg', 'rrrrr');

-- --------------------------------------------------------

--
-- Structure de la table `fos_user`
--

CREATE TABLE `fos_user` (
  `id` int(11) NOT NULL,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci COMMENT '(DC2Type:array)',
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(5000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `adrese` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `facebook_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `google_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `numtel` int(11) DEFAULT NULL,
  `prix` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `fos_user`
--

INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `nom`, `prenom`, `image`, `adrese`, `description`, `facebook_id`, `google_id`, `numtel`, `prix`) VALUES
(2, 'ikbel', 'ikbel', 'ikbel@esprit.tn', 'ikbel@esprit.tn', 1, NULL, '$2y$13$GjEKgeuIlUF0Rg1i0qj.YuV1pyamQBKMnWDTPXQ5AZY05Uykr4/3W', '2018-03-30 16:15:42', NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_PARENT\";}', 'ikbel', 'ikbel', '', '', '', NULL, NULL, NULL, NULL),
(3, 'seif', 'seif', 'seif@esprit.tn', 'seif@esprit.tn', 1, NULL, '$2y$13$PPbCPoq1R5po5elpGM5ofOSul4Ep6ShsB.SUPBxflGIBzIChTN.py', '2018-03-07 16:37:39', NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_PARENT\";}', 'seif', 'seif', '', '', '', NULL, NULL, NULL, NULL),
(4, 'aymen', 'aymen', 'aymen', 'aymen', 1, NULL, '$2y$10$Xl/0ZgRgLGZQgLSoJp.73uC6ssPnzODTh2UIbuQBI4.2D0XCp8tDi', NULL, NULL, NULL, NULL, 'aymen', 'aymen', NULL, 'aymen', NULL, NULL, NULL, 0, NULL),
(5, 'ghada', 'ghada', 'ghada', 'ghada', 1, NULL, '$2y$10$ozqMx9Kdin8/g8YMyzDwQutEo4d/fFCeFNL7B8qZX4CuU.Q/bhsSy', NULL, NULL, NULL, NULL, 'ghada', 'ghada', NULL, 'ghada', NULL, NULL, NULL, 0, NULL),
(6, 'ines', 'ines', 'ines', 'ines', 1, NULL, '$2y$10$9NIt5HsiFc2iNGi1b6eHiemheMlHp1riy2/xuTyxoos6k09Iz59Le', NULL, NULL, NULL, NULL, 'inesa', 'ines', NULL, 'ines', NULL, NULL, NULL, 0, NULL),
(7, 'yass', 'yass', 'yass', 'yass', 1, NULL, '$2y$10$qJyfMTZIK5okmxUwtVlMnOg7ul79faX2vn4x5xP9MVZom46jg9obm', NULL, NULL, NULL, NULL, 'yass', 'yass', NULL, 'yass', NULL, NULL, NULL, 200, NULL),
(8, 'test', 'test', 'test', 'test', 1, NULL, '$2y$10$hpMzBZ0HRuwbMho0PhdYXeeW5.hPFAN0CVD5ryj0Ce2ng1ZoGKeEC', NULL, NULL, NULL, NULL, 'test', 'test', NULL, 'test', NULL, NULL, NULL, 28874, NULL),
(9, 'testy', 'testy', 'testy', 'testy', 1, NULL, '$2y$10$sGAjVl0D5y9tQl8bbP2ZUOrPMhz9IOyE8elz7bRVvJ9xMC4cPo6s6', NULL, NULL, NULL, 'a:1:{i:0;s10:\"ROLE_ADMIN\";}', 'testy', 'testy', NULL, 'testy', NULL, NULL, NULL, 222, NULL),
(10, 'baby', 'baby', 'baby', 'baby', 1, NULL, '$2y$10$6dQaAGwqntphar1ucFXQIeug9c4gKqOmIYCXb.loBp33JWIA0Vt/K', NULL, NULL, NULL, 'a:1:{i:0;s:16:\"ROLE_BABY_SITTER\";}', 'baby', 'baby', NULL, 'baby', NULL, NULL, NULL, 1, NULL),
(11, 'ahmed', 'ahmed', 'ahmed', 'ahmed', 1, NULL, '$2y$10$7OVNS4b0k8i755pG6S10e.3.mTq5X7aJ50A9arZ5BirwpZQhRDmRa', NULL, NULL, NULL, 'a:1:{i:0;s:16:\"ROLE_BABY_SITTER\";}', 'ahmed', 'ahmed', NULL, 'ahmed', NULL, NULL, NULL, 0, NULL),
(12, 'testa', 'testa', 'testa', 'testa', 1, NULL, '$2y$10$tDXnKLUzt7FzNRVVesYO.e0.xGIF1JgTejMOjfoF2CYwHTzc9MQ7C', NULL, NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_PARENT\";}', 'testa', 'testa', NULL, 'testa', NULL, NULL, NULL, 1111, NULL),
(16, 'admin', 'admin', 'admin', 'admin', 1, NULL, '$2y$10$cGTyzyQDviAWvyH5Nq6HAOsBi1px46WjedGXa5xOqUcoWSssKKn2a', NULL, NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_ADMIN\";}', 'admin', 'admin', NULL, 'admin', NULL, NULL, NULL, 5555, NULL),
(18, 'aymoun', 'aymoun', 'aymoun', 'aymoun', 1, NULL, '$2y$10$DZQNM95DAnlcoJ9mi5u09.8U5DVFuO424DLcjRPqt.ksWj0RHNbbm', NULL, NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_PARENT\";}', 'aymoun', 'aymoun', NULL, 'aymoun', NULL, NULL, NULL, 20000, NULL),
(19, 'aa', 'aa', 'aa', 'aa', 1, NULL, '$2y$10$vH5BurOysqJUnlYex6KiU.Mse8JRBBwwYtWsXe1vK9kvrerkbajeS', NULL, NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_PARENT\";}', 'aa', 'aa', NULL, 'aa', NULL, NULL, NULL, 200, NULL),
(20, 'bb', 'bb', 'bb', 'bb', 1, NULL, '$2y$10$N/kwtEoCoviXh79nnYeM7Og3o5FjHex5Khc11YJe9XSnmfvkJfTN.', NULL, NULL, NULL, 'a:1:{i:0;s:17:\"ROLE_PROPRIETAIRE\";}', 'bb', 'bb', '/images/product.png', 'bb', NULL, NULL, NULL, 2000, NULL),
(21, 'firas', 'firas', 'firas', 'firas', 1, NULL, '$2y$10$SUq1SyhznEvuDKUZg314q.OXYyJLAqz0Iip3EmfLEUuIVz/gEp2qC', NULL, NULL, NULL, 'a:1:{i:0;s:12:\"ROLE_VENDEUR\";}', 'firas', 'firas', '/images/20294167_1825185387793231_6612368750501391146_n.jpg', 'firas', NULL, NULL, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `jarenfant`
--

CREATE TABLE `jarenfant` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `logo` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  `proprietaire` int(11) NOT NULL,
  `nbrnote` int(11) DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  `numtel` int(11) NOT NULL,
  `adressemail` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `jarenfant`
--

INSERT INTO `jarenfant` (`id`, `nom`, `description`, `adresse`, `logo`, `proprietaire`, `nbrnote`, `note`, `numtel`, `adressemail`) VALUES
(2, 'newjardin', 'almodhjqsq', 'sdfgsfg', '/images/bc4.jpg', 5, NULL, NULL, 0, 'dfgdfg'),
(3, 'qdfqdljfhkj', 'jlsdhgklsdhjfgl	bsghsjdg	sf', 'sdfsdfsdf', '/images/biberon.png', 5, NULL, NULL, 0, 'sdfsdfsdf'),
(4, 'thatjar', 'sdfsdfsdf', 'sdfsdf', '/images/aa.jpg', 5, NULL, NULL, 0, 'sdfsdf'),
(5, 'qdfqf', 'sdfsdf', 'sdfsdf', '/images/team5.jpg', 5, NULL, NULL, 0, 'sdfsdf'),
(6, 'jardinenfant', 'this is  a jar enfant', 'ghazela.com', '/images/team7.jpg', 5, NULL, NULL, 0, 'dfsdfsdf@sdf.com'),
(7, 'eqfsdf', 'sdfsdf', 'sdfsdf', '/images/rotating_card_thumb3.png', 5, NULL, NULL, 0, 'sdfsdf'),
(8, 'jardinyass', 'jardinsxcsvsdf', 'jardinyass', '/images/sm2.jpg', 7, NULL, NULL, 0, 'sdfsdfsdf'),
(10, 'ikeb', 'ikeb', 'ikeb', '/images/30581976_1724367330988534_8231203319821893632_o.jpg', 11, NULL, NULL, 0, 'ikeb');

-- --------------------------------------------------------

--
-- Structure de la table `mail`
--

CREATE TABLE `mail` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `text` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `thread_id` int(11) DEFAULT NULL,
  `sender_id` int(11) DEFAULT NULL,
  `body` longtext COLLATE utf8_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `message`
--

INSERT INTO `message` (`id`, `thread_id`, `sender_id`, `body`, `created_at`) VALUES
(1, 1, 3, 'aaaaaaaaaaaa', '2018-03-01 13:10:27'),
(2, 2, 2, 'coprs du message', '2018-03-02 09:40:27'),
(3, 3, 2, 'message', '2018-03-02 13:57:31'),
(4, 4, 2, 'eeeeeeeeeeeeeeeeeeee', '2018-03-07 16:35:53');

-- --------------------------------------------------------

--
-- Structure de la table `messages`
--

CREATE TABLE `messages` (
  `id` int(11) NOT NULL,
  `id_recepteur` int(11) NOT NULL,
  `idEmetteur` int(11) NOT NULL,
  `objet` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `contenu_message` varchar(3000) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `messages`
--

INSERT INTO `messages` (`id`, `id_recepteur`, `idEmetteur`, `objet`, `contenu_message`) VALUES
(1, 1, 2, 'mesasges', 'j\'aimerais vous contacter'),
(2, 5, 11, 'testy', 'testyyyyyyyyyyyy'),
(3, 5, 11, 'ok ', 'ok ok '),
(4, 5, 11, 'lololilol', 'lolilol'),
(5, 5, 11, 'this is msg', 'dqfsdfsdfsdfsdf'),
(6, 5, 11, 'dlfkldfkldkfdlkf', 'sdsdsdsd');

-- --------------------------------------------------------

--
-- Structure de la table `message_metadata`
--

CREATE TABLE `message_metadata` (
  `id` int(11) NOT NULL,
  `message_id` int(11) DEFAULT NULL,
  `participant_id` int(11) DEFAULT NULL,
  `is_read` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `message_metadata`
--

INSERT INTO `message_metadata` (`id`, `message_id`, `participant_id`, `is_read`) VALUES
(1, 1, 2, 1),
(2, 1, 3, 1),
(3, 2, 3, 0),
(4, 2, 2, 1),
(5, 3, 3, 0),
(6, 3, 2, 1),
(7, 4, 3, 0),
(8, 4, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `notif`
--

CREATE TABLE `notif` (
  `id` int(11) NOT NULL,
  `nominviteur` varchar(255) NOT NULL,
  `idu` int(11) NOT NULL,
  `ide` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `imagee` varchar(255) NOT NULL,
  `adressee` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `notif`
--

INSERT INTO `notif` (`id`, `nominviteur`, `idu`, `ide`, `nome`, `imagee`, `adressee`) VALUES
(1, 'ahmed', 11, 5, 'rrr', '/images/2018-04-09 04-58-31Pidev.jpg', 'rrrrr'),
(2, 'ahmed', 11, 5, 'rrr', '/images/2018-04-09 04-58-31Pidev.jpg', 'rrrrr'),
(3, 'ahmed', 21, 5, 'rrr', '/images/2018-04-09 04-58-31Pidev.jpg', 'rrrrr');

-- --------------------------------------------------------

--
-- Structure de la table `participer`
--

CREATE TABLE `participer` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prix` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idu` int(11) NOT NULL,
  `ide` int(11) NOT NULL,
  `particiate` int(11) DEFAULT NULL,
  `datedeb` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datefin` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nomorg` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `participer`
--

INSERT INTO `participer` (`id`, `nom`, `description`, `type`, `prix`, `idu`, `ide`, `particiate`, `datedeb`, `datefin`, `nomorg`, `adresse`, `image`) VALUES
(1, 'aaaaaaaaaaaa', 'lùmgvghv', 'Gratuit', '0', 11, 3, NULL, '2018-04-08', '2018-04-19', 'ghada', 'aaaaaaaaaaa', '/images/29790397_2034282050156863_8363958027100965796_n.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prix` int(11) NOT NULL,
  `idf` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `image` varchar(5000) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `age` int(11) NOT NULL,
  `genre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `categorie` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `nom`, `prix`, `idf`, `stock`, `image`, `description`, `age`, `genre`, `quantite`, `categorie`) VALUES
(1, 'montre', 22, 21, 7, '/images//images/aaa.jpg', 'sous marine', 2, 'garçon', 0, 'chaussures');

-- --------------------------------------------------------

--
-- Structure de la table `produit_donation`
--

CREATE TABLE `produit_donation` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idu` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datenow` date NOT NULL,
  `categorie` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tel` int(11) NOT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nomuser` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `genre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `appro` int(11) NOT NULL,
  `etat` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

CREATE TABLE `publication` (
  `id` int(11) NOT NULL,
  `id_categorie` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `titre_qestion` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nbr_vue` int(11) NOT NULL,
  `created` int(11) NOT NULL,
  `nbr_reponse` int(11) NOT NULL,
  `location` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `contenu` longtext COLLATE utf8_unicode_ci NOT NULL,
  `piece_jointe` varchar(5000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idcategorie` int(11) NOT NULL,
  `resolu` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `publication`
--

INSERT INTO `publication` (`id`, `id_categorie`, `id_user`, `titre_qestion`, `nbr_vue`, `created`, `nbr_reponse`, `location`, `contenu`, `piece_jointe`, `idcategorie`, `resolu`) VALUES
(12, 37, 2, 'test', 0, 1522275670, 0, 'approuver', 'tes', 'aaaaaa', 37, NULL),
(14, 37, 2, 'testtt', 1, 1861274346, 0, 'approuver', 'my content test is here', NULL, 37, 1),
(15, 41, 2, 'jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj', 0, 1522457404, 0, 'approuver', '<p>qNfluiqznfl;, q ckyuqsijk;, fcqei_uj,x ;,cq_ezurj,ze</p>', 'hg', 41, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `publicationresolu`
--

CREATE TABLE `publicationresolu` (
  `id` int(11) NOT NULL,
  `id_publication` int(11) DEFAULT NULL,
  `id_reponse` int(11) DEFAULT NULL,
  `id_pub` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `publicationresolu`
--

INSERT INTO `publicationresolu` (`id`, `id_publication`, `id_reponse`, `id_pub`) VALUES
(59, 14, 22, 14);

-- --------------------------------------------------------

--
-- Structure de la table `rating`
--

CREATE TABLE `rating` (
  `id` int(11) NOT NULL,
  `rating` int(11) DEFAULT NULL,
  `nom_produit` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idproduit` int(11) NOT NULL,
  `idf` int(11) NOT NULL,
  `idc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

CREATE TABLE `reponse` (
  `id` int(11) NOT NULL,
  `id_publication` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `contenu` longtext COLLATE utf8_unicode_ci NOT NULL,
  `created` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `reponse`
--

INSERT INTO `reponse` (`id`, `id_publication`, `id_user`, `contenu`, `created`) VALUES
(21, 14, 2, 'aaaaaaaaaaaa', '2018-03-30 16:16:59'),
(22, 14, 2, 'nouveau commentaire :)', '2018-03-31 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `thread`
--

CREATE TABLE `thread` (
  `id` int(11) NOT NULL,
  `created_by_id` int(11) DEFAULT NULL,
  `subject` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `is_spam` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `thread`
--

INSERT INTO `thread` (`id`, `created_by_id`, `subject`, `created_at`, `is_spam`) VALUES
(1, 3, 'aaaaa', '2018-03-01 13:10:27', 0),
(2, 2, 'sujet', '2018-03-02 09:40:27', 0),
(3, 2, 'sujet', '2018-03-02 13:57:31', 0),
(4, 2, 'aaaaaaa', '2018-03-07 16:35:53', 0);

-- --------------------------------------------------------

--
-- Structure de la table `thread_metadata`
--

CREATE TABLE `thread_metadata` (
  `id` int(11) NOT NULL,
  `thread_id` int(11) DEFAULT NULL,
  `participant_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL,
  `last_participant_message_date` datetime DEFAULT NULL,
  `last_message_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `thread_metadata`
--

INSERT INTO `thread_metadata` (`id`, `thread_id`, `participant_id`, `is_deleted`, `last_participant_message_date`, `last_message_date`) VALUES
(1, 1, 2, 0, NULL, '2018-03-01 13:10:27'),
(2, 1, 3, 0, '2018-03-01 13:10:27', NULL),
(3, 2, 3, 0, NULL, '2018-03-02 09:40:27'),
(4, 2, 2, 0, '2018-03-02 09:40:27', NULL),
(5, 3, 3, 0, NULL, '2018-03-02 13:57:31'),
(6, 3, 2, 0, '2018-03-02 13:57:31', NULL),
(7, 4, 3, 0, NULL, '2018-03-07 16:35:53'),
(8, 4, 2, 0, '2018-03-07 16:35:53', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `vues`
--

CREATE TABLE `vues` (
  `id` int(11) NOT NULL,
  `iduser` int(11) DEFAULT NULL,
  `idcategorie` int(11) DEFAULT NULL,
  `vue` int(11) NOT NULL,
  `idPublication` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `vues`
--

INSERT INTO `vues` (`id`, `iduser`, `idcategorie`, `vue`, `idPublication`) VALUES
(12, 2, NULL, 1, 14);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `avis`
--
ALTER TABLE `avis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_8F91ABF05FB6DEC7` (`reponse`),
  ADD KEY `IDX_8F91ABF08D93D649` (`user`);

--
-- Index pour la table `baby`
--
ALTER TABLE `baby`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_CB8C5497FAABF2` (`id_cat`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_9474526CF347EFB` (`produit_id`),
  ADD KEY `IDX_9474526CA76ED395` (`user_id`);

--
-- Index pour la table `demande`
--
ALTER TABLE `demande`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `fos_user`
--
ALTER TABLE `fos_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_957A647992FC23A8` (`username_canonical`),
  ADD UNIQUE KEY `UNIQ_957A6479A0D96FBF` (`email_canonical`),
  ADD UNIQUE KEY `UNIQ_957A6479C05FB297` (`confirmation_token`);

--
-- Index pour la table `jarenfant`
--
ALTER TABLE `jarenfant`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `mail`
--
ALTER TABLE `mail`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_B6BD307FE2904019` (`thread_id`),
  ADD KEY `IDX_B6BD307FF624B39D` (`sender_id`);

--
-- Index pour la table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `message_metadata`
--
ALTER TABLE `message_metadata`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_4632F005537A1329` (`message_id`),
  ADD KEY `IDX_4632F0059D1C3019` (`participant_id`);

--
-- Index pour la table `notif`
--
ALTER TABLE `notif`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `participer`
--
ALTER TABLE `participer`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit_donation`
--
ALTER TABLE `produit_donation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `publication`
--
ALTER TABLE `publication`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_AF3C6779C9486A13` (`id_categorie`),
  ADD KEY `IDX_AF3C67796B3CA4B` (`id_user`);

--
-- Index pour la table `publicationresolu`
--
ALTER TABLE `publicationresolu`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_1A3A7D33B72EAA8E` (`id_publication`),
  ADD UNIQUE KEY `UNIQ_1A3A7D33812B77B7` (`id_reponse`);

--
-- Index pour la table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_5FB6DEC7B72EAA8E` (`id_publication`),
  ADD KEY `IDX_5FB6DEC76B3CA4B` (`id_user`);

--
-- Index pour la table `thread`
--
ALTER TABLE `thread`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_31204C83B03A8386` (`created_by_id`);

--
-- Index pour la table `thread_metadata`
--
ALTER TABLE `thread_metadata`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_40A577C8E2904019` (`thread_id`),
  ADD KEY `IDX_40A577C89D1C3019` (`participant_id`);

--
-- Index pour la table `vues`
--
ALTER TABLE `vues`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_ECAC35835E5C27E9` (`iduser`),
  ADD KEY `IDX_ECAC3583EF619801` (`idPublication`),
  ADD KEY `IDX_ECAC358337667FC1` (`idcategorie`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `avis`
--
ALTER TABLE `avis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `baby`
--
ALTER TABLE `baby`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `demande`
--
ALTER TABLE `demande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `fos_user`
--
ALTER TABLE `fos_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `jarenfant`
--
ALTER TABLE `jarenfant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `mail`
--
ALTER TABLE `mail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `messages`
--
ALTER TABLE `messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `message_metadata`
--
ALTER TABLE `message_metadata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `notif`
--
ALTER TABLE `notif`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `participer`
--
ALTER TABLE `participer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `produit_donation`
--
ALTER TABLE `produit_donation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `publication`
--
ALTER TABLE `publication`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `publicationresolu`
--
ALTER TABLE `publicationresolu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT pour la table `rating`
--
ALTER TABLE `rating`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reponse`
--
ALTER TABLE `reponse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `thread`
--
ALTER TABLE `thread`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `thread_metadata`
--
ALTER TABLE `thread_metadata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `vues`
--
ALTER TABLE `vues`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `avis`
--
ALTER TABLE `avis`
  ADD CONSTRAINT `FK_8F91ABF05FB6DEC7` FOREIGN KEY (`reponse`) REFERENCES `reponse` (`id`),
  ADD CONSTRAINT `FK_8F91ABF08D93D649` FOREIGN KEY (`user`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `avis_ibfk_1` FOREIGN KEY (`reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `avis_ibfk_2` FOREIGN KEY (`reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD CONSTRAINT `FK_CB8C5497FAABF2` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_1` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_10` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_100` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_101` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_102` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_103` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_104` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_105` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_106` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_107` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_108` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_109` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_11` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_110` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_111` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_112` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_113` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_114` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_115` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_116` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_117` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_118` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_119` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_12` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_120` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_121` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_122` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_123` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_124` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_125` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_126` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_127` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_128` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_129` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_13` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_130` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_131` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_132` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_133` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_134` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_135` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_136` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_137` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_138` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_139` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_14` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_140` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_141` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_142` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_143` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_144` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_145` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_146` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_147` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_148` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_149` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_15` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_150` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_151` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_152` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_153` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_154` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_155` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_156` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_157` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_158` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_159` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_16` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_160` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_161` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_162` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_163` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_164` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_165` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_166` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_167` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_168` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_169` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_17` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_170` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_171` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_172` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_173` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_174` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_175` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_176` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_177` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_178` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_179` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_18` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_180` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_181` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_182` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_183` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_184` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_185` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_186` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_187` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_188` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_189` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_19` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_190` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_191` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_192` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_193` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_194` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_195` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_196` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_197` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_198` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_199` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_2` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_20` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_200` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_201` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_202` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_203` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_204` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_205` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_206` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_207` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_208` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_209` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_21` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_210` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_211` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_212` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_213` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_214` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_215` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_216` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_217` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_218` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_219` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_22` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_220` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_221` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_222` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_223` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_224` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_225` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_226` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_227` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_228` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_229` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_23` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_230` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_231` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_232` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_233` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_234` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_235` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_236` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_237` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_238` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_239` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_24` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_240` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_241` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_242` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_243` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_244` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_245` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_246` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_247` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_248` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_249` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_25` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_250` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_251` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_252` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_253` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_254` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_255` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_256` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_257` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_258` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_259` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_26` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_27` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_28` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_29` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_3` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_30` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_31` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_32` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_33` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_34` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_35` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_36` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_37` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_38` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_39` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_4` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_40` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_41` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_42` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_43` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_44` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_45` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_46` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_47` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_48` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_49` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_5` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_50` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_51` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_52` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_53` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_54` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_55` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_56` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_57` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_58` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_59` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_6` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_60` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_61` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_62` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_63` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_64` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_65` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_66` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_67` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_68` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_69` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_7` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_70` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_71` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_72` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_73` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_74` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_75` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_76` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_77` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_78` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_79` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_8` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_80` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_81` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_82` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_83` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_84` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_85` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_86` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_87` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_88` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_89` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_9` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_90` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_91` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_92` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_93` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_94` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_95` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_96` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_97` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_98` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie_ibfk_99` FOREIGN KEY (`id_cat`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK_9474526CA76ED395` FOREIGN KEY (`user_id`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_9474526CF347EFB` FOREIGN KEY (`produit_id`) REFERENCES `produit` (`id`);

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `FK_B6BD307FE2904019` FOREIGN KEY (`thread_id`) REFERENCES `thread` (`id`),
  ADD CONSTRAINT `FK_B6BD307FF624B39D` FOREIGN KEY (`sender_id`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `message_metadata`
--
ALTER TABLE `message_metadata`
  ADD CONSTRAINT `FK_4632F005537A1329` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`),
  ADD CONSTRAINT `FK_4632F0059D1C3019` FOREIGN KEY (`participant_id`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `publication`
--
ALTER TABLE `publication`
  ADD CONSTRAINT `FK_AF3C67796B3CA4B` FOREIGN KEY (`id_user`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_AF3C6779C9486A13` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`),
  ADD CONSTRAINT `publication_ibfk_10` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_100` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_101` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_102` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_103` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_104` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_105` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_106` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_107` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_108` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_109` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_11` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_110` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_111` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_112` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_113` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_114` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_115` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_116` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_117` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_118` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_119` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_12` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_120` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_121` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_122` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_123` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_124` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_125` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_126` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_127` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_128` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_129` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_13` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_130` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_131` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_132` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_133` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_134` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_135` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_136` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_137` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_138` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_139` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_14` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_140` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_141` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_142` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_143` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_144` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_145` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_146` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_147` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_148` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_149` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_15` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_150` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_151` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_152` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_153` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_154` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_155` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_156` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_157` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_158` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_159` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_16` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_160` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_161` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_162` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_163` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_164` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_165` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_166` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_167` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_168` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_169` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_17` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_170` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_171` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_172` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_173` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_174` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_175` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_176` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_177` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_178` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_179` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_18` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_180` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_181` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_182` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_183` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_184` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_185` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_186` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_187` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_188` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_189` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_19` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_190` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_191` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_192` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_193` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_194` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_195` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_196` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_197` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_198` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_199` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_2` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_20` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_200` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_201` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_202` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_203` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_204` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_205` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_206` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_207` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_208` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_209` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_21` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_210` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_211` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_212` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_213` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_214` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_215` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_216` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_217` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_218` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_219` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_22` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_220` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_221` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_222` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_223` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_224` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_225` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_226` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_227` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_228` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_229` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_23` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_230` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_231` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_24` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_25` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_26` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_27` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_28` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_29` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_3` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_30` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_31` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_32` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_33` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_34` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_35` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_36` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_37` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_38` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_39` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_4` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_40` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_41` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_42` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_43` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_44` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_45` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_46` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_47` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_48` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_49` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_5` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_50` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_51` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_52` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_53` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_54` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_55` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_56` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_57` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_58` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_59` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_6` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_60` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_61` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_62` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_63` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_64` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_65` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_66` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_67` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_68` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_69` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_7` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_70` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_71` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_72` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_73` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_74` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_75` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_76` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_77` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_78` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_79` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_8` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_80` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_81` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_82` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_83` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_84` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_85` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_86` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_87` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_88` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_89` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_9` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_90` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_91` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_92` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_93` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_94` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_95` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_96` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_97` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_98` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publication_ibfk_99` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `publicationresolu`
--
ALTER TABLE `publicationresolu`
  ADD CONSTRAINT `FK_1A3A7D33812B77B7` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_1A3A7D33B72EAA8E` FOREIGN KEY (`id_publication`) REFERENCES `publication` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_1` FOREIGN KEY (`id_publication`) REFERENCES `publication` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_10` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_11` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_12` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_13` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_14` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_2` FOREIGN KEY (`id_publication`) REFERENCES `publication` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_3` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_4` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_5` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_6` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_7` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_8` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicationresolu_ibfk_9` FOREIGN KEY (`id_reponse`) REFERENCES `reponse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD CONSTRAINT `FK_5FB6DEC76B3CA4B` FOREIGN KEY (`id_user`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_5FB6DEC7B72EAA8E` FOREIGN KEY (`id_publication`) REFERENCES `publication` (`id`),
  ADD CONSTRAINT `reponse_ibfk_1` FOREIGN KEY (`id_publication`) REFERENCES `publication` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reponse_ibfk_2` FOREIGN KEY (`id_publication`) REFERENCES `publication` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `thread`
--
ALTER TABLE `thread`
  ADD CONSTRAINT `FK_31204C83B03A8386` FOREIGN KEY (`created_by_id`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `thread_metadata`
--
ALTER TABLE `thread_metadata`
  ADD CONSTRAINT `FK_40A577C89D1C3019` FOREIGN KEY (`participant_id`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_40A577C8E2904019` FOREIGN KEY (`thread_id`) REFERENCES `thread` (`id`);

--
-- Contraintes pour la table `vues`
--
ALTER TABLE `vues`
  ADD CONSTRAINT `FK_ECAC358337667FC1` FOREIGN KEY (`idcategorie`) REFERENCES `categorie` (`id`),
  ADD CONSTRAINT `FK_ECAC35835E5C27E9` FOREIGN KEY (`iduser`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_ECAC3583EF619801` FOREIGN KEY (`idPublication`) REFERENCES `publication` (`id`),
  ADD CONSTRAINT `vues_ibfk_1` FOREIGN KEY (`idPublication`) REFERENCES `publication` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vues_ibfk_2` FOREIGN KEY (`idPublication`) REFERENCES `publication` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
