package com.cooper.messagelog.repo;

import com.cooper.messagelog.entities.Asset;
import com.cooper.messagelog.entities.AssetId;
import org.springframework.data.repository.CrudRepository;

public interface AssetRepository extends CrudRepository<Asset, AssetId> {
    Asset findByAssetIdAssetIdAndAssetIdversionNumber(String assetId, int versionNumber);
}
