package com.case_social_network.controller;

import com.case_social_network.entity.FriendShip;
import com.case_social_network.entity.User;
import com.case_social_network.service.impl.FriendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/friendship")
public class FriendController {
    @Autowired
    FriendServiceImpl friendService;

    /// hien các yêu cầu kết bạn cua user 2 đang chờ xử lý
    @GetMapping("/pending/{userId}")
    public List<FriendShip> getPendingFriendRequests(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return friendService.getPendingFriendRequests(user);
    }

    // Gửi Kết bạn
    @PostMapping("/send/{user1Id}/{user2Id}")
    public void sendFriendRequest(@PathVariable Long user1Id, @PathVariable Long user2Id) {
        User user1 = new User();
        user1.setId(user1Id);
        User user2 = new User();
        user2.setId(user2Id);
        friendService.sendFriend(user1, user2);
    }

// chấp nhận kết bạn
    @PostMapping("/accept/{user1Id}/{user2Id}")
    public void acceptFriendRequest(@PathVariable Long user1Id, @PathVariable Long user2Id) {
        User user1 = new User();
        user1.setId(user1Id);
        User user2 = new User();
        user2.setId(user2Id);
        friendService.acceptFriend(user1, user2);
    }

    // từ chối kết bạn va huy ket ban
    @PostMapping("/decline/{user1Id}/{user2Id}")
    public void declineFriendRequest(@PathVariable Long user1Id, @PathVariable Long user2Id){
        User user1 = new User();
        user1.setId(user1Id);
        User user2 = new User();
        user2.setId(user2Id);
        friendService.notAcceptFriendAndUnFriend(user1,user2);
    }


}
