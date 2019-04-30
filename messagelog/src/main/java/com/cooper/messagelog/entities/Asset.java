package com.cooper.messagelog.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ASSET")
public class Asset {
    @EmbeddedId
    private AssetId assetId;
    @Column(name = "HTML_STRING")
    private String htmlString;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;

    public AssetId getAssetId() {
        return assetId;
    }

    public void setAssetId(AssetId assetId) {
        this.assetId = assetId;
    }

    public String getHtmlString() {
        return htmlString;
    }

    public void setHtmlString(String htmlString) {
        this.htmlString = htmlString;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
