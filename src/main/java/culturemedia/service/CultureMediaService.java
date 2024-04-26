package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;

public interface CultureMediaService {
    void uploadVideo(Video video);
    void playVideo(View reproduction);
    int getTotalViews(String codeVideo);
}