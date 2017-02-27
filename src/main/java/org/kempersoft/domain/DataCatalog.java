package org.kempersoft.domain;

import java.util.List;

/**
 * Created by rpkem on 2/26/2017.
 */
public class DataCatalog extends DataElement {

    private List<DataSource> availableDataSources;

    public List<DataSource> getAvailableDataSources() {
        return availableDataSources;
    }

    public void setAvailableDataSources(List<DataSource> availableDataSources) {
        this.availableDataSources = availableDataSources;
    }

}
