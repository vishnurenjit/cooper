package com.cooper.messagelog.entities;

import javax.persistence.*;

@Entity
@Table(name = "CONFIG")
public class Config {
    @EmbeddedId
    private ConfigId configId;
    @Column(name = "CUST_ID")
    private long custId;
    @Column(name = "LOAN_NBR")
    private String loanNumber;
    @ManyToOne
    @JoinColumn(name = "ASSET_ID")
    private Asset asset;
    @Column(name = "UUID")
    private Character status;

    public ConfigId getConfigId() {
        return configId;
    }

    public void setConfigId(ConfigId configId) {
        this.configId = configId;
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

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
