package org.kempersoft.controllers;

import org.kempersoft.domain.DataCatalog;
import org.kempersoft.domain.DataSource;
import org.kempersoft.services.IDataCatalogService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rpkem on 2/26/2017.
 */
@RestController
@RequestMapping("org/kempersoft/api/datacatalog")
public class DataCatalogController {


    private final IDataCatalogService dataCatalogService;

    public DataCatalogController(final IDataCatalogService dataCatalogService) {
        this.dataCatalogService = dataCatalogService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public DataCatalog getDataCatalog() throws Exception {
        return dataCatalogService.getDataCatalog();
    }

    @RequestMapping(value = "/{datasourceId}", method = RequestMethod.GET)
    @ResponseBody
    public DataSource getDataSource(@PathVariable Long datasourceId) throws Exception {
        return dataCatalogService.getDataSourceInCatalog(datasourceId);
    }

}
