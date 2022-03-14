CREATE TABLE `users` (
                         `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `user_created_at` datetime DEFAULT NULL,
                         `user_email` varchar(64) NOT NULL,
                         `user_is_active` bit(1) DEFAULT NULL,
                         `user_name` varchar(128) NOT NULL,
                         `user_password` varchar(255) NOT NULL,
                         `user_phone_number` varchar(255) NOT NULL,
                         `user_secret` varchar(64) DEFAULT NULL,
                         PRIMARY KEY (`user_id`),
                         UNIQUE KEY `UK_33uo7vet9c79ydfuwg1w848f` (`user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;