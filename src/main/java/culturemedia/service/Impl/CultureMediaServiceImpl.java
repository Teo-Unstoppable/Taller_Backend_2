package culturemedia.service.Impl;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CultureMediaService;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {
    private ViewsRepository viewsRepository;

    public CultureMediaServiceImpl(ViewsRepository viewsRepository) {
        this.viewsRepository = viewsRepository;
    }

    public List<Video> getAllVideos() {
        return List.of();
    }


    public View registerView(View view) {
        return null;
    }


    public Video saveVideo(Video video) {
        return null;
    }
}


