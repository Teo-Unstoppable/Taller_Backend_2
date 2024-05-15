package culturemedia.controllers;

import java.util.*;

import culturemedia.exception.CultureMediaException;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.Impl.VideoRepositoryImpl;
import culturemedia.repository.Impl.ViewsRepositoryImpl;
import culturemedia.service.CultureMediaService;
import culturemedia.service.Impl.CultureMediaServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CultureMediaController {
    private final CultureMediaService cultureMediaService;


    public CultureMediaController(CultureMediaService cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }

    public CultureMediaController(){
        this.cultureMediaService = new CultureMediaServiceImpl(new VideoRepositoryImpl(), new ViewsRepositoryImpl());
    }

    @GetMapping
    public List<Video> findAllVideos() throws CultureMediaException {
        try {
            return cultureMediaService.findAll();
        }catch (VideoNotFoundException e){
            return Collections.emptyList();
        }
    }

    @PostMapping
    public Video addVideo(@RequestBody Video video){
        return cultureMediaService.save(video);
    }
}

