package culturemedia.service.Impl;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CultureMediaService;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {
    private ViewsRepository viewsRepository;

    public CultureMediaServiceImpl() {
        this.viewsRepository = viewsRepository;
    }

    public List<Video> findAll() {
        return List.of();
    }


    public View save(View view) {
        return null;
    }


    public Video save(Video video) {
        return null;
    }
}


