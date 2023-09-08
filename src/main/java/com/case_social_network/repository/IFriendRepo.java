package com.case_social_network.repository;

import com.case_social_network.entity.FriendShip;
import com.case_social_network.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFriendRepo extends CrudRepository<FriendShip,Long> {
  List<FriendShip> findByUser1AndStatus(User user1, String status);
  List<FriendShip> findByUser2AndStatus(User user2, String status);

  // Tìm kiếm mối quan hệ kết bạn của user1 và user 2
  FriendShip findByUser1AndUser2(User user1, User user2);



}
