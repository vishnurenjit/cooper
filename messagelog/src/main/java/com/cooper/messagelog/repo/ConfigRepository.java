package com.cooper.messagelog.repo;

import com.cooper.messagelog.entities.Config;
import com.cooper.messagelog.entities.ConfigId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConfigRepository extends CrudRepository<Config, ConfigId> {
    @Query("select c.asset.assetId FROM Config c where c.status = '1'")
    List<String> findAssetIdByStatus();
}
