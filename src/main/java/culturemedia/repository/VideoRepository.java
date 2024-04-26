package culturemedia.repository;

import java.util.List;

import culturemedia.model.Video;

/**
 * Implementation of VideoRepository using an in-memory map.
 */

public interface VideoRepository {
    List<Video> findAll();
    Video save(Video save);
    List<Video> find(String title);
    List<Video> find(Double fromDuration, Double toDuration);
}