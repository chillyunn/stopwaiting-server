//package com.stopwaiting.server.domain.waitingQueue;
//
//import com.stopwaiting.server.domain.user.User;
//import com.stopwaiting.server.domain.waitingInfo.WaitingInfo;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Getter
//@NoArgsConstructor
//@Entity
//public class WaitingQueue {
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "MEMBER_ID")
//    private WaitingInfo waitingInfo;
//
//    @OneToMany(mappedBy = "watingqueue")
//    private Set<User> users = new HashSet<>();
//
//    @Builder
//    public WaitingQueue(WaitingInfo waitingInfo, Set<User> users) {
//        this.waitingInfo = waitingInfo;
//        this.users = users;
//    }
//}
