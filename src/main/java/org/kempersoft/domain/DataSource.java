package org.kempersoft.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by rpkem on 2/26/2017.
 */
public class DataSource extends DataElement {

    private String shortName;
    private String longName;
    private String description;
    private String type;
    private Date createdDate;
    private String createdBy;

    public DataSource(String shortName) {
        this.setId(DataElement.getNextId());
        this.shortName = shortName;
    }

    private List<Tag> tags;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
