-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 04, 2019 at 05:18 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `si_fengtay`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `id` int(11) NOT NULL,
  `bank_code` varchar(255) NOT NULL,
  `bank_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`id`, `bank_code`, `bank_name`) VALUES
(1, 'B0001', 'Bank Mutiara Biru'),
(2, 'B0002', 'Bank Ini Itu');

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE `data` (
  `app_number` varchar(255) NOT NULL,
  `currency` varchar(5) NOT NULL,
  `payment_for` varchar(255) NOT NULL,
  `vendor_code` varchar(255) NOT NULL,
  `vendor_name` varchar(255) NOT NULL,
  `bank_code` varchar(255) NOT NULL,
  `bank_name` varchar(255) NOT NULL,
  `account_number` varchar(255) NOT NULL,
  `due_date` date NOT NULL,
  `total_amount` int(11) NOT NULL,
  `amount_deduct` varchar(255) NOT NULL,
  `input_date` date NOT NULL,
  `prepared_by` varchar(255) NOT NULL,
  `hakakses` varchar(255) NOT NULL,
  `confirm` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`app_number`, `currency`, `payment_for`, `vendor_code`, `vendor_name`, `bank_code`, `bank_name`, `account_number`, `due_date`, `total_amount`, `amount_deduct`, `input_date`, `prepared_by`, `hakakses`, `confirm`) VALUES
('1907001', 'IDR', '-', '1', 'Pertaminaz', '1', 'BCAZ', '1110001', '2019-07-16', 200000, '200000', '2019-07-16', 'admin', 'Admin', 0),
('1907002', 'IDR', '-', '1', 'Pertaminaz', '1', 'BCAZ', '1110001', '2019-07-16', 200000, '200000', '2019-07-16', 'admin', 'Admin', 0),
('1907003', 'IDR', 'asd', '123', '', '123', '', '123', '2019-07-16', 123123, '123123', '2019-07-16', 'admin', 'Admin', 0),
('1907004', 'IDR', 'Jasa 4', 'V0001', 'PT. Satu Dua Tiga', 'B0001', 'Bank Mutiara Biru', '123123', '2019-07-17', 200000, '0', '2019-07-17', 'admin', 'Staff', 0),
('1907005', 'IDR', 'Jasa 5', 'V0001', 'PT. Satu Dua Tiga', 'B0002', 'Bank Ini Itu', '12435452', '2019-07-18', 49454593, '0', '2019-07-18', 'admin', 'Staff', 0);

-- --------------------------------------------------------

--
-- Table structure for table `deduct`
--

CREATE TABLE `deduct` (
  `deduct_number` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `amount` int(11) NOT NULL,
  `note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deduct`
--

INSERT INTO `deduct` (`deduct_number`, `date`, `amount`, `note`) VALUES
('DN0001', '2019-07-16', 100000, 'Deduct Coba 1'),
('DN0002', '2019-07-18', 200000, 'Coba 2');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoice_number` varchar(255) NOT NULL,
  `invoice_date` date NOT NULL,
  `invoice_amount` int(11) NOT NULL,
  `number_awb` varchar(255) NOT NULL,
  `id_data` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoice_number`, `invoice_date`, `invoice_amount`, `number_awb`, `id_data`) VALUES
('INVOICE0001', '2019-07-16', 100000, 'AWB00001', 1907001),
('INVOICE0002', '2019-07-16', 300000, 'AWB00002', 1907001),
('INVOICE0003', '2019-07-16', 700000, 'AWB00003', 1907001),
('IN0001236', '2019-07-16', 200000, 'AWB00004', 1907004),
('1234123987', '2019-07-17', 24542112, 'AWB00008', 1907005),
('1234123987', '2019-07-17', 24542112, 'AWB00009', 1907005),
('1231234', '2019-07-18', 123456, 'AWB00010', 1907005),
('1', '2019-07-18', 1, 'AWB00011', 1907005),
('235456', '2019-07-18', 123456, 'AWB00012', 1907005),
('235456', '2019-07-18', 123456, 'AWB00013', 1907005);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `privilage` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `nama`, `privilage`) VALUES
(1, 'nisa', 'nisa', 'Annisa', 'Staff'),
(2, 'karina nur', 'duabelas12', 'Karina Nurhidayah', 'Staff'),
(3, 'sri hafni', 'srihafni', 'Sri Hafni ', 'Manager'),
(4, 'astri', 'astri', 'Sulastri', 'Direktur'),
(5, 'iin indra', 'iinindra', 'Iin Indrawati', 'VGM');

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE `vendor` (
  `id` int(11) NOT NULL,
  `vendor_code` varchar(255) NOT NULL,
  `vendor_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`id`, `vendor_code`, `vendor_name`) VALUES
(1, 'V0001', 'PT. Satu Dua Tiga'),
(2, 'V0002', 'CV. Maju Jaya');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`app_number`);

--
-- Indexes for table `deduct`
--
ALTER TABLE `deduct`
  ADD PRIMARY KEY (`deduct_number`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`number_awb`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bank`
--
ALTER TABLE `bank`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `vendor`
--
ALTER TABLE `vendor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
