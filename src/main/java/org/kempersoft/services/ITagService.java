package org.kempersoft.services;

import org.kempersoft.domain.Tag;

import java.util.Collection;

/**
 * Created by rpkem on 2/26/2017.
 */
public interface ITagService {

    Collection<Tag> getTags() throws Exception;

    Tag findTagByLabel(String label) throws Exception;

    Tag getTag(String tagId) throws Exception;

    Tag createTag(Tag tag) throws Exception;

    void deleteTag(String tagId) throws Exception;
}
