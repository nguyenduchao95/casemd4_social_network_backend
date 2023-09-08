package com.case_social_network.service.impl;

import com.case_social_network.entity.FriendShip;
import com.case_social_network.entity.User;
import com.case_social_network.repository.IFriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl {
    @Autowired
    IFriendRepo friendRepo;
    // nhận được các yêu cầu kết bạn đang chờ xử lý
    public List<FriendShip> getPendingFriendRequests(User user){
        return friendRepo.findByUser2AndStatus(user, "pending");
    }

    // Gửi kết bạn
    public void sendFriend(User user1, User user2){
        FriendShip friendShip = new FriendShip();
        friendShip.setUser1(user1);
        friendShip.setUser2(user2);
        friendShip.setStatus("Pending");
        friendRepo.save(friendShip);
    }
// Chấp nhận lời mời kết bạn
    public void acceptFriend(User user1, User user2){
        // mối quan hệ kết bạn user 1, user 2
        FriendShip friendShip = friendRepo.findByUser1AndUser2(user1,user2);
        if (friendShip != null && friendShip.getStatus().equals("Pending")){
            friendShip.setStatus("connected");
            friendRepo.save(friendShip);
        }
    }


    // Từ chối lời mời kết bạn
    public void notAcceptFriend (User user1, User user2){
        FriendShip friendShip = friendRepo.findByUser1AndUser2(user1,user2);
        if (friendShip != null && friendShip.getStatus().equals("connected")){
            friendRepo.delete(friendShip);
        }
    }

}
