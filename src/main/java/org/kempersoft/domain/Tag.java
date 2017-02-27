package org.kempersoft.domain;

/**
 * Created by rpkem on 2/26/2017.
 */
public class Tag extends DataElement {

    public Tag() {

    }

    public Tag(String label, String description) {
        this.setId(DataElement.getNextId());
        this.label = label;
        this.description = description;
    }

    private String label;
    private String description;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
