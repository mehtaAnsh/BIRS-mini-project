-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 25, 2019 at 05:37 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `login`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `name` varchar(25) NOT NULL,
  `stock` tinyint(1) NOT NULL,
  `sr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`name`, `stock`, `sr`) VALUES
('Half Girlfriend', 0, 1),
('Elon Musk', 0, 2),
('Deep Love', 3, 4),
('Rich dad Poor dad', 5, 5),
('TestBook', 5, 9);

-- --------------------------------------------------------

--
-- Table structure for table `record`
--

CREATE TABLE `record` (
  `Username` varchar(20) NOT NULL,
  `Returned` tinyint(1) NOT NULL,
  `Name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `record`
--

INSERT INTO `record` (`Username`, `Returned`, `Name`) VALUES
('anshm', 1, 'Rich dad Poor dad'),
('anshm', 1, 'ABCDEFGH'),
('anshm', 1, 'Books'),
('anshm', 1, 'Rich dad Poor dad'),
('anshm', 1, 'Deep '),
('anshm', 1, 'Deep '),
('anshm', 1, 'Rich dad Poor dad'),
('anshm', 1, 'ABCDEFGH'),
('sd2000', 1, 'Books'),
('anshm', 1, 'Half Girlfriend');

-- --------------------------------------------------------

--
-- Table structure for table `username`
--

CREATE TABLE `username` (
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Security` varchar(20) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Lname` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `username`
--

INSERT INTO `username` (`Username`, `Password`, `Security`, `Name`, `Lname`) VALUES
('deepv', 'hello', '0000', 'd', 'v'),
('', '', '', '', ''),
('abcd', 'abcdefgh', '1234', ' Ansh', 'Mehta'),
('anshm', 'abcd', '1234', 'Ansh ', 'Mehta'),
('sd', 'sd', '1221', 'Soham ', 'Dave'),
('sp', 'sp', '1221', 'SHubham', 'PAtil'),
('abcdef', 'tttt222222', '11', 'ggdbj ', 'jsajfs'),
('abcd', 'abcdefgh', '666', 'sfsd ', 'uhbsb'),
('anshm', 'abcdefgh', '1234', 'Ansh ', 'Mehta'),
('sd2000', 'sd200001234', '1234', 'Soham ', 'Dave'),
('admin', 'administrator', '0000', 'Administrator', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`sr`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `sr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
