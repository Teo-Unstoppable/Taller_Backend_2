package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;
import java.util.List;

public interface CultureMediaService {
    List<Video> getAllVideos();
    View registerView(View view);
    Video saveVideo(Video video);
}