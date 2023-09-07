INSERT INTO `users` (`id`, `first_name`, `last_name`, `gender`, `email`, `username`, `password`, `image`,
                     `created_at`, `updated_at`)
VALUES (3, 'Mohans', 'Giri', 0, 'whomonugiri2@gmail.com', 'whomonugiri', 'c68710d3fe56fc88f7905cb15f06cf5c',
        'https://cdn-icons-png.flaticon.com/512/3135/3135715.png', '2021-11-19 08:54:47', '2021-11-25 08:21:35'),
       (4, 'Mohans', 'Giri', 0, 'whomonugirdfgfi@gmail.com', 'asdsd', 'c68710d3fe56fc88f7905cb15f06cf5c',
        'https://cdn-icons-png.flaticon.com/512/3135/3135715.png', '2021-11-22 02:34:06', '2021-11-25 08:21:40'),
       (5, 'Mohans', 'Giri', 1, 'workwithmohan@gmail.com', 'oyeitsmgasdasd', 'c68710d3fe56fc88f7905cb15f06cf5c',
        'https://cdn-icons-png.flaticon.com/512/3135/3135715.png', '2021-11-23 12:00:13', '2021-11-25 08:21:43'),
       (6, 'Mohans', 'Giri', 1, 'mailtomonugiri@gmail.com', 'oyeitsmgasd', '970af30e481057c48f87e101b61e6994',
        'https://cdn-icons-png.flaticon.com/512/3135/3135715.png', '2021-11-23 13:24:40', '2021-11-27 19:12:06'),
       (7, 'Monu', 'Giri', 1, 'officialmohankumar@gmail.com', 'iamtheking', 'e10adc3949ba59abbe56e057f20f883e',
        'https://cdn-icons-png.flaticon.com/512/3135/3135715.png', '2021-11-25 08:45:24', '2021-11-25 08:49:44'),
       (8, 'Monu', 'Giri', 1, 'whomonugiri@gmail.com', 'devninja', '970af30e481057c48f87e101b61e6994',
        'https://cdn-icons-png.flaticon.com/512/3135/3135715.png', '2021-11-26 16:53:17', '2021-11-27 17:51:30'),
       (9, 'Test', 'Kumar', 1, 'test@gmail.com', 'testman', 'e10adc3949ba59abbe56e057f20f883e', '1638244233bot.png',
        '2021-11-30 03:45:35', '2021-11-30 03:50:33'),
       (10, 'Amit', 'Sharma', 1, 'amith@gmail.com', 'amithero', 'e10adc3949ba59abbe56e057f20f883e',
        'https://cdn-icons-png.flaticon.com/512/3135/3135715.png', '2021-12-02 18:06:37', '2021-12-02 18:09:03'),
       (11, 'Pankaj', 'Mishra', 1, 'officialmohankumar12@gmail.com', 'pankaj1427', 'e10adc3949ba59abbe56e057f20f883e',
        'https://cdn-icons-png.flaticon.com/512/3135/3135715.png', '2021-12-05 06:36:14', '2021-12-05 07:16:41');


INSERT INTO `posts` (`id`, `user_id`, `img`, `content`, `created_at`)
VALUES (1, 8, 'https://images.saymedia-content.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cq_auto:eco%2Cw_1200/MTk4MDQzMTI5NzY3NTM1ODA2/short-captions-for-profile-pictures.png', 'this is my first image post', '2021-11-27 18:54:22'),
       (2, 8, 'https://wallpapers.com/images/hd/aesthetic-profile-picture-52t290ggbex44jma.jpg', 'Hình ảnh có thể có bản quyền', '2021-11-27 19:07:49'),
       (3, 6, 'https://images.statusfacebook.com/profile_pictures/cartoon_girls/cartoon_girls_profile_picture80.jpg', 'my fisrt web app', '2021-11-27 19:15:08'),
       (5, 8, 'https://s.cafebazaar.ir/images/upload/screenshot/com.laknaidriapps.girlscartoon-27aed6e0-bc93-4548-84bd-eba47379c42d.jpeg', 'say hii to everyone', '2021-11-27 19:19:34'),
       (7, 6, 'https://i.pinimg.com/564x/fb/f7/ae/fbf7aedc29a9ec97a88204eb59551a4d.jpg', 'cartoon_girls', '2021-11-30 03:44:23'),
       (9, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwfx3i8dM0DYcbtesCCVwhRZu0H1ERrJ6dEPvkJ4rW5poNESXixPv1MYpARB3ITppmi5M&usqp=CAU', 'cool profile picture', '2021-12-02 18:19:59'),
       (10, 9, 'https://images.saymedia-content.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cq_auto:eco%2Cw_1200/MTk4MDQzMTI5NzY3NTM1ODA2/short-captions-for-profile-pictures.png', 'this is my first image post', '2021-11-27 18:54:22'),
       (11, 10, 'https://wallpapers.com/images/hd/aesthetic-profile-picture-52t290ggbex44jma.jpg', 'Hình ảnh có thể có bản quyền', '2021-11-27 19:07:49'),
       (12, 11, 'https://images.statusfacebook.com/profile_pictures/cartoon_girls/cartoon_girls_profile_picture80.jpg', 'my fisrt web app', '2021-11-27 19:15:08'),
       (13, 9, 'https://s.cafebazaar.ir/images/upload/screenshot/com.laknaidriapps.girlscartoon-27aed6e0-bc93-4548-84bd-eba47379c42d.jpeg', 'say hii to everyone', '2021-11-27 19:19:34'),
       (14, 10, 'https://i.pinimg.com/564x/fb/f7/ae/fbf7aedc29a9ec97a88204eb59551a4d.jpg', 'cartoon_girls', '2021-11-30 03:44:23'),
       (15, 11, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwfx3i8dM0DYcbtesCCVwhRZu0H1ERrJ6dEPvkJ4rW5poNESXixPv1MYpARB3ITppmi5M&usqp=CAU', 'cool profile picture', '2021-12-02 18:19:59');



INSERT INTO `comments` (`id`, `post_id`, `user_id`, `comment`, `created_at`)
VALUES (3, 5, 8, 'this is awesome guys', '2021-12-02 17:44:26'),
       (4, 5, 8, 'dfg', '2021-12-02 17:46:43'),
       (5, 5, 8, 'ok just testing', '2021-12-02 17:51:50'),
       (6, 5, 8, 'nice', '2021-12-02 17:52:00'),
       (7, 5, 8, 'sdfdsf', '2021-12-02 17:52:26'),
       (8, 5, 8, 'sdfsdf', '2021-12-02 17:52:27'),
       (9, 5, 8, 'sdfsdf', '2021-12-02 17:52:28'),
       (10, 5, 8, 'sdfsdf', '2021-12-02 17:52:29'),
       (11, 5, 8, 'sdfsdf', '2021-12-02 17:52:31'),
       (12, 5, 8, 'sdfsdf', '2021-12-02 17:52:32'),
       (13, 7, 8, 'this is awesome game', '2021-12-02 18:04:36'),
       (14, 3, 8, 'this is aweosme project', '2021-12-02 18:05:49'),
       (15, 7, 10, 'wowo, just super cool', '2021-12-02 18:07:31'),
       (16, 1, 10, 'nice and funny', '2021-12-02 18:09:17'),
       (17, 2, 10, 'awesome', '2021-12-02 18:12:01'),
       (18, 5, 10, 'nice pic', '2021-12-02 18:15:12'),
       (19, 3, 10, 'super cool man congrats', '2021-12-02 18:15:34'),
       (20, 5, 10, 'aweosme and cool', '2021-12-02 18:22:03'),
       (21, 1, 10, 'super cool', '2021-12-02 18:22:24'),
       (22, 5, 10, 'super nice', '2021-12-02 18:23:18'),
       (23, 9, 10, 'super cool', '2021-12-02 18:24:44'),
       (24, 3, 10, 'thanks bro', '2021-12-02 18:26:02'),
       (25, 2, 8, 'looking awesome bro', '2021-12-04 10:55:57'),
       (27, 2, 10, 'this is my fav image', '2021-12-04 11:18:13'),
       (28, 1, 10, 'congrats guys', '2021-12-04 11:37:42'),
       (29, 9, 8, 'nice pic brother ', '2021-12-04 12:09:12'),
       (30, 9, 10, 'thanks brother', '2021-12-04 12:09:36'),
       (32, 7, 8, 'super cool', '2021-12-04 12:24:06'),
       (34, 5, 8, 'aweomse', '2021-12-04 12:45:09'),
       (38, 1, 8, 'ok bye then', '2021-12-04 16:40:00'),
       (39, 1, 8, 'cool', '2021-12-04 16:44:10'),
       (40, 9, 8, 'ok nice', '2021-12-04 16:50:21'),
       (41, 9, 8, 'good', '2021-12-04 16:51:22'),
       (42, 1, 8, 'Nice pic', '2021-12-05 05:44:25'),
       (43, 9, 11, 'Hii bro', '2021-12-05 06:52:16'),
       (44, 3, 10, 'awesome pic bro', '2021-12-06 08:17:41'),
       (45, 5, 10, 'nice girls', '2021-12-06 08:19:08'),
       (46, 5, 8, 'Thanks', '2021-12-06 08:25:30'),
       (47, 3, 11, 'Awesosm', '2021-12-07 10:24:33');


INSERT INTO `follow` (`id`, `follower_user_id`, `user_id`)
VALUES (13, 9, 3),
       (15, 9, 6),
       (38, 10, 3),
       (42, 10, 7),
       (43, 10, 9),
       (57, 8, 4),
       (58, 8, 5),
       (66, 10, 11),
       (68, 11, 10),
       (69, 11, 7),
       (70, 11, 9),
       (71, 11, 3);


INSERT INTO `likes` (`id`, `post_id`, `user_id`)
VALUES (1, 3, 8),
       (2, 7, 9),
       (3, 5, 9),
       (4, 7, 8),
       (5, 3, 10),
       (6, 9, 10),
       (7, 1, 10),
       (8, 1, 8),
       (9, 2, 10),
       (10, 3, 8),
       (11, 9, 11),
       (12, 3, 10),
       (13, 5, 8),
       (14, 2, 8);


INSERT INTO `messages` (`id`, `from_user_id`, `to_user_id`, `message`, `read_status`, `created_at`)
VALUES (27, 8, 10, 'hii amit', 1, '2021-12-07 10:47:18'),
       (28, 8, 11, 'hii pankaj', 1, '2021-12-07 10:47:44'),
       (29, 11, 8, 'Hii monu bro', 1, '2021-12-07 10:48:03'),
       (30, 8, 11, 'ok get it', 1, '2021-12-07 10:48:15'),
       (31, 11, 8, 'Thanks for unblocking me', 1, '2021-12-07 11:05:27'),
       (32, 11, 8, 'No I am going to block you', 1, '2021-12-07 11:05:52'),
       (33, 10, 8, 'Hii bro', 1, '2021-12-07 11:10:12'),
       (34, 8, 10, 'hii man', 1, '2021-12-07 11:10:26'),
       (35, 10, 8, 'So what are you doing', 1, '2021-12-07 11:10:39'),
       (36, 8, 10, 'nothing big you tell', 1, '2021-12-07 11:11:00'),
       (37, 10, 8, 'Ohh same here', 1, '2021-12-07 11:11:08'),
       (38, 8, 10, 'lets go for party then', 1, '2021-12-07 11:11:30'),
       (39, 10, 8, 'Ya sure', 1, '2021-12-07 11:11:37'),
       (40, 8, 10, 'ok bye', 1, '2021-12-07 11:11:53');





INSERT INTO `notifications` (`id`, `to_user_id`, `message`, `created_at`, `from_user_id`, `read_status`, `post_id`)
VALUES (1, 10, 'Unblocked you !', '2021-12-06 08:16:11', 8, 1, 1),
       (2, 8, 'started following you !', '2021-12-06 08:16:59', 10, 1, 2),
       (3, 8, 'liked your post !', '2021-12-06 08:17:33', 10, 1, 5),
       (4, 8, 'commented on your post', '2021-12-06 08:17:41', 10, 1, 3),
       (5, 8, 'commented on your post', '2021-12-06 08:19:07', 10, 1, 7),
       (6, 10, 'blocked you', '2021-12-06 08:20:42', 8, 1, 9),
       (7, 10, 'Unblocked you !', '2021-12-06 08:21:09', 8, 1, 1),
       (8, 8, 'started following you !', '2021-12-06 08:21:34', 10, 1, 2),
       (9, 10, 'started following you !', '2021-12-06 08:22:17', 8, 1, 3),
       (10, 3, 'Unfollowed you !', '2021-12-06 08:26:01', 8, 0, 5),
       (11, 8, 'commented on your post', '2021-12-07 10:24:33', 11, 1, 7),
       (12, 11, 'blocked you', '2021-12-07 10:48:28', 8, 1, 9),
       (13, 11, 'Unblocked you !', '2021-12-07 11:04:05', 8, 1, 1),
       (14, 8, 'blocked you', '2021-12-07 11:08:54', 11, 1, 2),
       (15, 8, 'Unblocked you !', '2021-12-07 11:09:03', 11, 1, 3),
       (16, 8, 'blocked you', '2021-12-07 11:12:50', 10, 1, 5),
       (17, 8, 'Unblocked you !', '2021-12-07 11:13:04', 10, 1, 9);


INSERT INTO `block` (`id`, `block_user_id`, `user_id`)
VALUES (5, 8, 9);