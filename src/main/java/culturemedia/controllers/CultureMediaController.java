package culturemedia.controllers;

import java.util.*;

import culturemedia.exception.CultureMediaException;
import culturemedia.model.Video;
import culturemedia.service.CultureMediaService;


public class CultureMediaController {
    private final CultureMediaService cultureMediaService;


    public CultureMediaController(CultureMediaService cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }


    public List<Video> findAllVideos() throws CultureMediaException {
        return cultureMediaService.findAll();
    }
}

