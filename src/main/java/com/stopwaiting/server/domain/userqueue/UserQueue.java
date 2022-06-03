package com.stopwaiting.server.domain.userqueue;

import com.stopwaiting.server.domain.user.User;
import com.stopwaiting.server.domain.waitingQueue.WaitingQueue;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UserQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WAITINGQUEUE_ID")
    private WaitingQueue waitingQueue;
}
