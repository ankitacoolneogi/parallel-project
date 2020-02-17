-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Feb 17, 2020 at 04:10 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banking`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `account_no` int(10) NOT NULL,
  `cust_id` int(5) NOT NULL,
  `balance` int(11) NOT NULL,
  `balance_s` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`account_no`, `cust_id`, `balance`, `balance_s`) VALUES
(4206, 11, 86998, 1),
(4207, 12, 214563, 1),
(4208, 13, 25000, 1),
(4209, 14, 25000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cust_id` int(5) NOT NULL,
  `password` varchar(10) NOT NULL,
  `cust_name` varchar(40) NOT NULL,
  `dob` date NOT NULL,
  `phno` varchar(10) NOT NULL,
  `email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cust_id`, `password`, `cust_name`, `dob`, `phno`, `email`) VALUES
(11, 'ani12345', 'Animesh', '1992-02-02', '8768278578', 'animesh@yahoo.com'),
(12, 'qwertyui', 'shreya', '2009-12-11', '7878787878', 'shre@ebay.com'),
(13, 'ankita13', 'Ankita', '1996-01-12', '8759192872', 'ankita@gmail.com'),
(14, 'yukti123', 'Yukti', '1998-03-17', '9464890864', 'syukti1998@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `from_acc` int(10) NOT NULL,
  `to_acc` int(10) NOT NULL,
  `type` varchar(20) NOT NULL,
  `amount` int(11) NOT NULL,
  `date_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`from_acc`, `to_acc`, `type`, `amount`, `date_time`) VALUES
(4200, 4200, 'Deposit', 2200, '2020-02-14 05:54:16'),
(4200, 4200, 'Deposit', 2245, '2020-02-14 05:58:20'),
(4200, 4200, 'Deposit', 2500, '2020-02-14 06:03:05'),
(4200, 4200, 'Deposit', 5000, '2020-02-14 06:03:38'),
(4200, 4200, 'Deposit', 1500, '2020-02-14 06:04:01'),
(4201, 4201, 'Deposit', 1700, '2020-02-14 06:09:56'),
(0, 0, 'Deposit', 1700, '2020-02-14 06:28:13'),
(4203, 4203, 'Deposit', 2200, '2020-02-14 06:31:28'),
(4204, 4204, 'Deposit', 2000, '2020-02-14 06:42:05'),
(4204, 4204, 'Deposit', 100, '2020-02-14 06:42:31'),
(4204, 4204, 'Deposit', 10000, '2020-02-14 06:42:49'),
(4204, 4204, 'Deposit', 600, '2020-02-14 06:43:21'),
(4205, 4205, 'Withdrawal', 1700, '2020-02-15 09:48:17'),
(4205, 4205, 'Deposit', 2300, '2020-02-15 09:48:41'),
(4204, 4205, 'Sent', 340, '2020-02-16 09:40:11'),
(4204, 4205, 'Recieve', 340, '2020-02-16 09:40:11'),
(4205, 4204, 'Sent', 40, '2020-02-16 09:42:08'),
(4205, 4204, 'Recieve', 40, '2020-02-16 09:42:08'),
(4206, 4, 'Sent', 240, '2020-02-16 09:43:59'),
(4206, 4, 'Recieve', 240, '2020-02-16 09:43:59'),
(4206, 4207, 'Sent', 559, '2020-02-16 09:56:07'),
(4206, 4207, 'Recieve', 559, '2020-02-16 09:56:07'),
(0, 249202, 'Sent', 50000000, '2020-02-16 09:56:35'),
(0, 249202, 'Recieve', 50000000, '2020-02-16 09:56:35'),
(4206, 4206, 'Sent', 21, '2020-02-16 10:14:58'),
(4206, 4206, 'Recieve', 21, '2020-02-16 10:14:58'),
(4206, 4207, 'Sent', 55, '2020-02-16 10:15:32'),
(4206, 4207, 'Recieve', 55, '2020-02-16 10:15:32'),
(4206, 4208, 'Sent', 22, '2020-02-16 10:16:31'),
(4206, 4208, 'Recieve', 22, '2020-02-16 10:16:31'),
(4206, 4206, 'Withdrawal', 249124, '2020-02-16 10:32:55'),
(4206, 4206, 'Deposit', 67000, '2020-02-16 11:18:26'),
(4206, 4207, 'Sent', 3, '2020-02-16 11:18:53'),
(4207, 4206, 'Recieve', 3, '2020-02-16 11:18:53'),
(4208, 4207, 'Sent', 600, '2020-02-16 11:20:58'),
(4207, 4208, 'Recieve', 600, '2020-02-16 11:20:58'),
(4206, 4207, 'Sent', 3, '2020-02-16 21:29:38'),
(4207, 4206, 'Recieve', 3, '2020-02-16 21:29:38'),
(4207, 4206, 'Sent', 20004, '2020-02-16 21:33:31'),
(4206, 4207, 'Recieve', 20004, '2020-02-16 21:33:31'),
(4209, 4209, 'Withdrawal', 25000, '2020-02-16 21:35:34');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`account_no`),
  ADD KEY `CUST` (`cust_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cust_id`),
  ADD UNIQUE KEY `cust_id` (`cust_id`,`phno`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD KEY `TACC` (`from_acc`,`to_acc`),
  ADD KEY `taccc` (`to_acc`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `account_no` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4210;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `cust_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `cid` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
