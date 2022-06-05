package com.stopwaiting.server.domain.waitingQueue;

import com.stopwaiting.server.domain.timetable.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaitingQueueRepository extends JpaRepository<WaitingQueue,Long> {
    WaitingQueue findByTimetable(Timetable timetable);
}
