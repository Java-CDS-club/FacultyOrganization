-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 11, 2015 at 05:25 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `orgstruktura`
--
CREATE DATABASE IF NOT EXISTS `orgstruktura` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `orgstruktura`;

-- --------------------------------------------------------

--
-- Table structure for table `fakulteti`
--

CREATE TABLE IF NOT EXISTS `fakulteti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Fakultet` varchar(50) NOT NULL,
  `Dekan` varchar(50) NOT NULL,
  `Adresa` varchar(50) NOT NULL,
  `Telefon` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `fakulteti`
--

INSERT INTO `fakulteti` (`id`, `Fakultet`, `Dekan`, `Adresa`, `Telefon`) VALUES
(2, 'FON', 'Ma', 'Jove Ilica', '01122222');

-- --------------------------------------------------------

--
-- Table structure for table `kategorija`
--

CREATE TABLE IF NOT EXISTS `kategorija` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(50) NOT NULL,
  `KategorijaID` int(11) NOT NULL,
  `Fakultet` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `kategorija`
--

INSERT INTO `kategorija` (`id`, `Naziv`, `KategorijaID`, `Fakultet`) VALUES
(1, 'Savet fakulteta', 1, 'FON');

-- --------------------------------------------------------

--
-- Table structure for table `orgstruktura`
--

CREATE TABLE IF NOT EXISTS `orgstruktura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NazivOrg` varchar(50) NOT NULL,
  `Osoba1` varchar(50) NOT NULL,
  `Osoba2` varchar(50) NOT NULL,
  `Email` varchar(70) NOT NULL,
  `Website` varchar(70) NOT NULL,
  `Telefon` varchar(50) NOT NULL,
  `Fakultet` varchar(50) NOT NULL,
  `KategorijaID` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `orgstruktura`
--

INSERT INTO `orgstruktura` (`id`, `NazivOrg`, `Osoba1`, `Osoba2`, `Email`, `Website`, `Telefon`, `Fakultet`, `KategorijaID`) VALUES
(12, 'SAVETFON', 'khj', 'hkkj', 'kj', 'kjh', 'kj', 'FON', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `password`) VALUES
(1, 'Andreja', 'a', 'a');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
