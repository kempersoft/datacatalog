package org.kempersoft.services.impl;

import org.kempersoft.domain.DataCatalog;
import org.kempersoft.domain.DataSource;
import org.kempersoft.domain.Tag;
import org.kempersoft.services.IDataCatalogService;
import org.kempersoft.services.ITagService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.naming.NameNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rpkem on 2/26/2017.
 */
@Service
public class DataCatalogService implements IDataCatalogService {


    private final ITagService tagService;

    public DataCatalogService(final ITagService tagService) {
        this.tagService = tagService;
    }

    private DataCatalog dataCatalog;

    @Override
    public DataCatalog getDataCatalog() throws Exception {
        return dataCatalog;
    }

    @Override
    public DataSource getDataSourceInCatalog(Long datasourceId) throws Exception {
        if (datasourceId == null) {
            throw new Exception("Invalid datasourceId specified (null)");
        }
        for (DataSource dataSource : dataCatalog.getAvailableDataSources()) {
            if (datasourceId.equals(dataSource.getId())) {
                return dataSource;
            }
        }
        throw new NameNotFoundException("Unable to find datasource with id " + datasourceId);
    }

    @PostConstruct
    private void initCatalog() {

        dataCatalog = new DataCatalog();

        List<DataSource> dataSources = new ArrayList<>();

        // create the tags we'll use...
        // fix this one up later..
        try {
            tagService.createTag(new Tag("2016_General_Election", "Information about the 2016 General Election"));
            tagService.createTag(new Tag("Florida", "Information pertaining to the State of Florida"));
            tagService.createTag(new Tag("Orange County, FL", "Information pertaining to Orange County, Florida"));
        } catch (Exception ex) {
            // log the exception - need to set up logging later
            // TODO: setup logging
            System.out.println("Error creating tags!" + ex.getMessage());
        }
        dataSources.add(createFloridaMainDatasource());
        dataSources.add(createOrangeCountyDatasource());

        dataCatalog.setAvailableDataSources(dataSources);
    }

    private DataSource createFloridaMainDatasource() {
        DataSource dataSource = new DataSource("2016GenElect_FL");
        dataSource.setLongName("2016 Florida General Election Results File");
        dataSource.setDescription("This file contains the general elections results from the state of Florida for the election held on 11/08/2016");
        dataSource.setType("Tab-delimited file");
        dataSource.setCreatedBy("Bob Kemper");
        dataSource.setCreatedDate(new Date());
        List<Tag> tags = new ArrayList<>();
        try {
            tags.add(tagService.findTagByLabel("2016_General_Election"));
            tags.add(tagService.findTagByLabel("Florida"));
        } catch (Exception ex) {
            // TODO: log this
            System.out.println("Error getting tag!" + ex.getMessage());
        }
        dataSource.setTags(tags);
        return dataSource;
    }

    private DataSource createOrangeCountyDatasource() {
        DataSource dataSource = new DataSource("2016GenElect_OrangeFL");
        dataSource.setLongName("2016 Florida General Election - Orange County Precinct Data File");
        dataSource.setDescription("This file contains the general elections results for all precincts and races for Orange County, Florida for the election held on 11/08/2016");
        dataSource.setType("Excel");
        dataSource.setCreatedBy("Bob Kemper");
        dataSource.setCreatedDate(new Date());
        List<Tag> tags = new ArrayList<>();
        try {
            tags.add(tagService.findTagByLabel("2016_General_Election"));
            tags.add(tagService.findTagByLabel("Orange County, FL"));
        } catch (Exception ex) {
            // TODO: log this
            System.out.println("Error getting tag!" + ex.getMessage());
        }
        dataSource.setTags(tags);


        return dataSource;
    }
}
