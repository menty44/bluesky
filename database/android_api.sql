-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 08, 2017 at 12:34 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `android_api`
--

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `article_id` int(5) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`article_id`, `title`, `category`) VALUES
(1, 'Java Concurrency', 'Java'),
(2, 'Hibernate HQL ', 'Hibernate'),
(3, 'Spring MVC with Hibernate', 'Spring'),
(16, 'kuku', 'danger'),
(17, 'mokaya', 'begies');

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE `groups` (
  `userid` int(11) NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `createdon` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`userid`, `uuid`, `name`, `description`, `createdon`) VALUES
(2, '', 'User', 'test', ''),
(3, '87768', 'Client', 'test', '99999'),
(4, '8769876897', 'Admin', 'Administrator of the portal', '3/8/2017'),
(5, '9887sa6d8a57s^87asf', 'Staff', 'staff of the companies', ''),
(7, '*D&f6*AD&gf687', 'john doe', 'test', '');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `prodid` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `suggestedunitprice` varchar(255) NOT NULL,
  `buyunitprice` varchar(255) NOT NULL,
  `unitsinstock` varchar(255) NOT NULL,
  `productcode` varchar(255) NOT NULL,
  `uuid` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`prodid`, `name`, `description`, `suggestedunitprice`, `buyunitprice`, `unitsinstock`, `productcode`, `uuid`) VALUES
(1, 'omo', 'washing powder', '150', '102', '1500', '6546548r65465', 'sad6gf+6asd925'),
(2, 'Supa Loaf ', 'breaf', '55', '40', '200', '7865865765786', 'jk2h3f2y45fjkhy45f');

-- --------------------------------------------------------

--
-- Table structure for table `stores`
--

CREATE TABLE `stores` (
  `storeid` int(11) NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phoneno` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `branch` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `vatno` varchar(255) NOT NULL,
  `krapin` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stores`
--

INSERT INTO `stores` (`storeid`, `uuid`, `name`, `phoneno`, `email`, `branch`, `location`, `vatno`, `krapin`) VALUES
(1, '', 'Tuskys', '0788589658', 'info@tusky.com', 'Buruburu', 'Buruburu Phase 3', '0158778787r87b', '67878878878887'),
(2, '', 'Tuskys', '0788555500', 'info@tusky.com', 'Rongai', 'Rongai', '64664y46454', '654666465464');

-- --------------------------------------------------------

--
-- Table structure for table `userfred`
--

CREATE TABLE `userfred` (
  `userid` int(11) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userfred`
--

INSERT INTO `userfred` (`userid`, `firstname`, `lastname`, `dob`, `email`) VALUES
(1, 'Daniel', 'NikoJdbc', '2014-05-13', 'prateek@itcompany.com'),
(2, 'Daniel', 'NikoJdbc', '2014-05-13', 'prateek@example.com'),
(3, 'zgzcgsFH', 'zsfh', NULL, 'zxchzfh');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userid` int(11) NOT NULL,
  `unique_id` varchar(23) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `idpass` varchar(255) NOT NULL,
  `phoneno` varchar(255) NOT NULL,
  `group` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `encrypted_password` varchar(80) NOT NULL,
  `salt` varchar(10) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `unique_id`, `name`, `email`, `idpass`, `phoneno`, `group`, `status`, `encrypted_password`, `salt`, `created_at`, `updated_at`) VALUES
(3, '58b7ea297e7a09.93457397', 'oluoch', 'fmenty@blaqueyard.com', '2345', '', '', 'Deactivated', 'R7p4mGgfNZwleinN4w/1AG5GelRjMTA2NDYwNTVi', 'c10646055b', '2017-03-02 11:47:21', NULL),
(2, '58b7db697f5437.47403836', 'oluoch', 'fred.oluoch@blaqueyard.com', '24626', '', '', 'Active', 'nVWsKoun+La4qkWaTlCbIwAfFpQ3N2M2NzI2ZDg1', '77c6726d85', '2017-03-02 10:44:25', NULL),
(7, '58b7eef5b3e4e5.39536327', 'root', 'root@gmail.com', '222534535', '0720106420', '', 'Active', 'root', 'root', '2017-03-02 12:07:49', NULL),
(8, '58b943157d27f1.39992267', 'Omera', 'menty44@gmail.com', '3462346', '0720106420', '', 'Active', 'omera', 'omera', '2017-03-03 12:19:01', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`article_id`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`userid`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`prodid`);

--
-- Indexes for table `stores`
--
ALTER TABLE `stores`
  ADD PRIMARY KEY (`storeid`);

--
-- Indexes for table `userfred`
--
ALTER TABLE `userfred`
  ADD PRIMARY KEY (`userid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`),
  ADD UNIQUE KEY `unique_id` (`unique_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `prodid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `stores`
--
ALTER TABLE `stores`
  MODIFY `storeid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `userfred`
--
ALTER TABLE `userfred`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
