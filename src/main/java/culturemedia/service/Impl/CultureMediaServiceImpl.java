package culturemedia.service.Impl;
import culturemedia.exception.CultureMediaException;
import culturemedia.exception.VideoNotFoundException;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CultureMediaService;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {
    private VideoRepository videoRepository;
    private ViewsRepository viewsRepository;

    public CultureMediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }
    @Override
    public List<Video> findAll() throws VideoNotFoundException {
        List<Video> videos = videoRepository.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videos;
    }

    public Video save(Video video)  {
        return videoRepository.save(video);
    }

    public View save(View view)  {
        return viewsRepository.add(view);
    }
    @Override
    public List<Video> find(String title) throws VideoNotFoundException {
        List<Video> filteredVideos = videoRepository.find(title);
        if (filteredVideos.isEmpty()){
            throw new VideoNotFoundException();
        }else{
            return filteredVideos;
        }

    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) throws VideoNotFoundException {
        List<Video> filteredVideos = videoRepository.find(fromDuration, toDuration);
        if (filteredVideos.isEmpty()) {
            throw new VideoNotFoundException();
        } else {
            return filteredVideos;
        }
    }
}


