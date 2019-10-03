-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Sep 24, 2019 at 08:29 AM
-- Server version: 5.7.26
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `grue-projetA3`
--

-- --------------------------------------------------------

--
-- Table structure for table `TB_PERSONNE`
--

CREATE TABLE `TB_PERSONNE` (
  `id` int(8) NOT NULL,
  `name` char(30) NOT NULL,
  `firstName` char(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `TB_PERSONNE`
--

INSERT INTO `TB_PERSONNE` (`id`, `name`, `firstName`) VALUES
(1, 'Gouze', 'Paul'),
(2, 'Georges', 'Alexis'),
(3, 'Berthaud', 'Vincent'),
(4, 'Liagre', 'Joseph'),
(5, 'Silov', 'Thomas');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `TB_PERSONNE`
--
ALTER TABLE `TB_PERSONNE`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `TB_PERSONNE`
--
ALTER TABLE `TB_PERSONNE`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
