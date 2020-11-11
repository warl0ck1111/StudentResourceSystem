-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 29, 2020 at 10:59 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentresource`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `answer_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `answer_timestamp` datetime(6) NOT NULL,
  `vote_count` int(11) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `question_id` int(11) NOT NULL,
  `question_description` varchar(255) NOT NULL,
  `question_title` varchar(255) NOT NULL,
  `timestamp` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`answer_id`, `user_id`, `answer_timestamp`, `vote_count`, `answer`, `question_id`, `question_description`, `question_title`, `timestamp`) VALUES
(1, 2, '2019-10-09 00:00:00.000000', 0, 'because of the solar sysstem dummy!!', 2, '', '', '0000-00-00 00:00:00'),
(3, 1, '2018-10-09 00:00:00.000000', 0, 'thats just how it is dummy', 2, '', '', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `question_id` int(11) NOT NULL,
  `question_title` varchar(255) NOT NULL,
  `question_description` varchar(255) NOT NULL,
  `user_id` int(255) NOT NULL,
  `question_timestamp` datetime(6) NOT NULL,
  `vote_count` int(255) NOT NULL,
  `approved_answer` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`question_id`, `question_title`, `question_description`, `user_id`, `question_timestamp`, `vote_count`, `approved_answer`) VALUES
(1, 'this is my Quesstion Title', 'this is my question description', 1, '2020-01-03 11:12:07.320367', 0, 0),
(2, 'the sunSet', 'why does it always happen in the west?', 1, '2019-05-03 11:11:07.320367', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `question_tag`
--

CREATE TABLE `question_tag` (
  `question_tag_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `question_tag`
--

INSERT INTO `question_tag` (`question_tag_id`, `question_id`, `tag_id`) VALUES
(1, 2, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `resource`
--

CREATE TABLE `resource` (
  `resource_id` int(11) NOT NULL,
  `course_code` varchar(255) NOT NULL,
  `course_title` varchar(255) NOT NULL,
  `resource_type` varchar(255) NOT NULL,
  `institution` varchar(255) NOT NULL,
  `resource_timestamp` datetime(6) NOT NULL,
  `user_id` int(11) NOT NULL,
  `resource_description` varchar(255) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `resource_path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `subscription`
--

CREATE TABLE `subscription` (
  `subscription_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tag`
--

CREATE TABLE `tag` (
  `tag_id` int(11) NOT NULL,
  `tag_name` varchar(255) NOT NULL,
  `tag_description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tag`
--

INSERT INTO `tag` (`tag_id`, `tag_name`, `tag_description`) VALUES
(1, 'sun', 'sun'),
(2, 'sunset', 'sunset');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `email`, `password`) VALUES
(1, 'admin', 'admin', 'admin'),
(2, 'warl0ck', 'warl0ck@rocketmail.com', 'mohammad');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`answer_id`),
  ADD KEY `FKs4yfxjrfvek48fcsvg9ndcktu` (`question_id`),
  ADD KEY `FK68tbcw6bunvfjaoscaj851xpb` (`user_id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`question_id`),
  ADD KEY `FK4ekrlbqiybwk8abhgclfjwnmc` (`user_id`);

--
-- Indexes for table `question_tag`
--
ALTER TABLE `question_tag`
  ADD PRIMARY KEY (`question_tag_id`),
  ADD KEY `fk_question_tag` (`question_id`),
  ADD KEY `question_tag_ibfk_2` (`tag_id`);

--
-- Indexes for table `resource`
--
ALTER TABLE `resource`
  ADD PRIMARY KEY (`resource_id`),
  ADD KEY `FK26y67tcsqg4jk8gjlaju0lehe` (`tag_id`),
  ADD KEY `FKgverld5ylkmwkhca8tcjwggps` (`user_id`);

--
-- Indexes for table `subscription`
--
ALTER TABLE `subscription`
  ADD PRIMARY KEY (`subscription_id`),
  ADD KEY `FK8t296tmkj5d9sla6xmfvolnm8` (`tag_id`),
  ADD KEY `FK8l1goo02px4ye49xd7wgogxg6` (`user_id`);

--
-- Indexes for table `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`tag_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `answer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `question_tag`
--
ALTER TABLE `question_tag`
  MODIFY `question_tag_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `resource`
--
ALTER TABLE `resource`
  MODIFY `resource_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subscription`
--
ALTER TABLE `subscription`
  MODIFY `subscription_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tag`
--
ALTER TABLE `tag`
  MODIFY `tag_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `FK68tbcw6bunvfjaoscaj851xpb` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKs4yfxjrfvek48fcsvg9ndcktu` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`);

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `FK4ekrlbqiybwk8abhgclfjwnmc` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `question_tag`
--
ALTER TABLE `question_tag`
  ADD CONSTRAINT `fk_question_tag` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`),
  ADD CONSTRAINT `question_tag_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`);

--
-- Constraints for table `resource`
--
ALTER TABLE `resource`
  ADD CONSTRAINT `FK26y67tcsqg4jk8gjlaju0lehe` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`),
  ADD CONSTRAINT `FKgverld5ylkmwkhca8tcjwggps` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `subscription`
--
ALTER TABLE `subscription`
  ADD CONSTRAINT `FK8l1goo02px4ye49xd7wgogxg6` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FK8t296tmkj5d9sla6xmfvolnm8` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
