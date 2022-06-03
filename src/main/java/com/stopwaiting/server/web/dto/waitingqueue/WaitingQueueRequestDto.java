package com.stopwaiting.server.web.dto.waitingqueue;

import com.stopwaiting.server.domain.user.User;
import com.stopwaiting.server.domain.waitingInfo.WaitingInfo;
import com.stopwaiting.server.domain.waitingQueue.WaitingQueue;

import java.util.ArrayList;
import java.util.List;

public class WaitingQueueRequestDto {
    private WaitingInfo waitingInfo;
    private List<User> users = new ArrayList<>();
    private List<WaitingQueue> waitingQueues = new ArrayList<>();




}
