package com.cooper.messagelog.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class AudLogId {
    @Column(name = "REC_ID")
    private long recId;
    @Column(name = "SENT_DTTM")
    private Date sentDate;

    public long getRecId() {
        return recId;
    }

    public void setRecId(long recId) {
        this.recId = recId;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }
}
