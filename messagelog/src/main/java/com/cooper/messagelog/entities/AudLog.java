package com.cooper.messagelog.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class AudLog {

    @EmbeddedId
    private AudLogId audLogId;
    @ManyToOne
    @JoinColumn(name = "ASSET_ID")
    private Asset asset;
    @Column(name = "CUST_ID")
    private long custId;
    @Column(name = "LOAN_NUM")
    private String loanNumber;
    @Column(name = "CHNL")
    private String channel;
    @Column(name = "VIEW_STS")
    private Character viewStatus;
    @Column(name = "SENT_TO")
    private String sentTo;
    @Column(name = "DEL_FLAG")
    private Character delFlag;
    @Column(name = "VER_NUM")
    private int verNum;
    @Column(name = "ASSET_EFF_DT")
    private Date assetEffectiveDate;

    public AudLogId getAudLogId() {
        return audLogId;
    }

    public void setAudLogId(AudLogId audLogId) {
        this.audLogId = audLogId;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Character getViewStatus() {
        return viewStatus;
    }

    public void setViewStatus(Character viewStatus) {
        this.viewStatus = viewStatus;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public Character getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Character delFlag) {
        this.delFlag = delFlag;
    }

    public int getVerNum() {
        return verNum;
    }

    public void setVerNum(int verNum) {
        this.verNum = verNum;
    }

    public Date getAssetEffectiveDate() {
        return assetEffectiveDate;
    }

    public void setAssetEffectiveDate(Date assetEffectiveDate) {
        this.assetEffectiveDate = assetEffectiveDate;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
