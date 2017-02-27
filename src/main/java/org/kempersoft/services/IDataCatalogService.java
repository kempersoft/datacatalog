package org.kempersoft.services;

import org.kempersoft.domain.DataCatalog;
import org.kempersoft.domain.DataSource;

/**
 * Created by rpkem on 2/26/2017.
 */
public interface IDataCatalogService {

    DataCatalog getDataCatalog() throws Exception;

    DataSource getDataSourceInCatalog(Long datasourceId) throws Exception;

}
