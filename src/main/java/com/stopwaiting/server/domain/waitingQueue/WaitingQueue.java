package com.stopwaiting.server.domain.waitingQueue;

import com.stopwaiting.server.domain.user.User;
import com.stopwaiting.server.domain.userqueue.UserQueue;
import com.stopwaiting.server.domain.waitingInfo.WaitingInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class WaitingQueue {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WAITINGINFO_ID")
    private WaitingInfo waitingInfo;

    @OneToMany(mappedBy = "waitingqueue",cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "waitingqueue",cascade = CascadeType.ALL)
    private List<UserQueue> userQueues = new ArrayList<>();
    @Builder
    public WaitingQueue(WaitingInfo waitingInfo, List<User> users) {
        this.waitingInfo = waitingInfo;
    }
    public void addUserQueue(UserQueue userQueue){
        this.userQueues.add(userQueue);
        userQueue.updateWaitingQueue(this);

    }
}
