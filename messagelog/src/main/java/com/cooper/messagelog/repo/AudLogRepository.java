package com.cooper.messagelog.repo;

import com.cooper.messagelog.entities.AudLog;
import com.cooper.messagelog.entities.AudLogId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AudLogRepository extends CrudRepository<AudLog, AudLogId> {
    List<AudLog> findByCustIdOrderByLoanNumber(long custId);
    List<AudLog> findByCustIdAndChannelOrderByLoanNumber(long custId, String channel);

    @Query("update AudLog a set a.delFlag =: dlt and a.viewStatus =: rd where a.audLogId.recId =: recId")
    @Modifying
    void updateDelFlagAndViewStatusByRecId(@Param("dlt") char dlt, @Param("rd")char rd, @Param("recId")long recId);
}
