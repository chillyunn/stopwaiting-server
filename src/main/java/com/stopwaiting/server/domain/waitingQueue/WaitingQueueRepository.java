package com.stopwaiting.server.domain.waitingQueue;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WaitingQueueRepository extends JpaRepository<WaitingQueue,Long> {
}
