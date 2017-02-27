package org.kempersoft.services.impl;

import org.kempersoft.domain.Tag;
import org.kempersoft.services.ITagService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by rpkem on 2/26/2017.
 */

@Service
public class TagService implements ITagService {


    private HashMap<String, Tag> tagsByLabel = new HashMap<>();

    @Override
    public Collection<Tag> getTags() throws Exception {
        return tagsByLabel.values();
    }

    @Override
    public Tag findTagByLabel(String label) throws Exception {
        return tagsByLabel.get(label);
    }

    @Override
    public Tag getTag(String tagId) throws Exception {
        return null;
    }

    @Override
    public Tag createTag(Tag tag) throws Exception {
        tagsByLabel.put(tag.getLabel(), tag);
        return tag;
    }

    @Override
    public void deleteTag(String tagId) throws Exception {

    }

}


