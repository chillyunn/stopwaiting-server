package com.stopwaiting.server.domain.waitingInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WaitingInfoRepository extends JpaRepository<WaitingInfo,Long> {
}
