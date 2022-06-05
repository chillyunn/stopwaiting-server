package com.stopwaiting.server.domain.waitingInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WaitingInfoRepository extends JpaRepository<WaitingInfo,Long> {
    List<WaitingInfo> findByAdminId(Long id);

    @Query("select w from WaitingInfo w where w.status=:status")
    List<WaitingInfo> findByStatus(@Param("status")Status status);
}
