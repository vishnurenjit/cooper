package com.cooper.messagelog.service;

import com.cooper.messagelog.BO.MessageBO;
import com.cooper.messagelog.entities.Asset;
import com.cooper.messagelog.entities.AudLog;
import com.cooper.messagelog.repo.AssetRepository;
import com.cooper.messagelog.repo.AudLogRepository;
import com.cooper.messagelog.repo.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private AudLogRepository audLogRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private ConfigRepository configRepository;

    public List<MessageBO> getMessages(long custId, String channel) {
        List<String> ids = configRepository.findAssetIdByStatus();

        List<AudLog> audLogs = null;
        if(channel == null) {
            audLogs = audLogRepository.findByCustIdOrderByLoanNumber(custId);
        } else {
            audLogs = audLogRepository.findByCustIdAndChannelOrderByLoanNumber(custId, channel);
        }
        return audLogs.stream().map(e -> buildBo(e)).collect(Collectors.toList());
    }

    private MessageBO buildBo(AudLog e) {
        MessageBO messageBo = new MessageBO();
        messageBo.setAssetId(e.getAsset().getAssetId().getAssetId());
        messageBo.setChannel(e.getChannel());
        messageBo.setCustId(e.getCustId());
        messageBo.setAssetVerNum(e.getAsset().getAssetId().getVersionNumber());
        messageBo.setLoanNumber(e.getLoanNumber());
        messageBo.setRecId(e.getAudLogId().getRecId());
        messageBo.setSendDate(e.getAudLogId().getSentDate().getTime());
        messageBo.setViewStatus(e.getViewStatus() == 1 ? "read" : "unread");
        return messageBo;
    }

    public String getAssetBody(String assetId, int verNum) {
        Asset asset = assetRepository.findByAssetIdAssetIdAndAssetIdversionNumber(assetId, verNum);
        return asset.getHtmlString();
    }

    public boolean updateLog(long recId, Boolean read, Boolean delete) {
        char rd = (read != null && read) ? '1' : '0';
        char dlt = (delete != null && delete) ? '1' : '0';
        if(rd == '1' || dlt == '1') {
            audLogRepository.updateDelFlagAndViewStatusByRecId(dlt, rd, recId);
        }
        return true;
    }
}
