package culturemedia.repository;

import java.util.List;

import culturemedia.model.Video;

/**
 * Implementation of VideoRepository using an in-memory map.
 */

public interface VideoRepository {
    List<Video> getAllVideos();
    Video saveVideo(Video save);
    List<Video> searchByName(String title);
    List<Video> findByDuration(Double fromDuration, Double toDuration);
}

