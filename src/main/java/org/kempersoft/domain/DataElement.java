package org.kempersoft.domain;

/**
 * Created by rpkem on 2/26/2017.
 */
public abstract class DataElement {

    private static Long nextId = 1000L;

    public static Long getNextId() {
        synchronized (nextId) {
            Long retVal = nextId;
            nextId = nextId + 1;
            return retVal;
        }
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
