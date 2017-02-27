package org.kempersoft.controllers;

import org.kempersoft.domain.Tag;
import org.kempersoft.services.ITagService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by rpkem on 2/26/2017.
 */

@RestController
@RequestMapping("org/kempersoft/api/tags")
public class TagController {

    private final ITagService tagService;

    public TagController(final ITagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    Collection<Tag> getTags() throws Exception {
        return tagService.getTags();
    }

}
