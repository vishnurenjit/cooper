package com.cooper.messagelog.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConfigId {
    @Column(name = "UUID")
    private String UUId;
    @Column(name = "NTFTNID")
    private String NTFTNId;

    public String getUUId() {
        return UUId;
    }

    public void setUUId(String UUId) {
        this.UUId = UUId;
    }

    public String getNTFTNId() {
        return NTFTNId;
    }

    public void setNTFTNId(String NTFTNId) {
        this.NTFTNId = NTFTNId;
    }
}
