package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.Impl.CultureMediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class CultureMediaServiceImplTest {

    private CultureMediaService cultureMediaService;
    private VideoRepository videoRepositoryMock;
    private ViewsRepository viewsRepositoryMock;

    @BeforeEach
    void setUp() {
        videoRepositoryMock = Mockito.mock(VideoRepository.class);
        viewsRepositoryMock = Mockito.mock(ViewsRepository.class);

        cultureMediaService = new CultureMediaServiceImpl(videoRepositoryMock, viewsRepositoryMock);
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        // Arrange
        List<Video> videos = new ArrayList<>();
        videos.add(new Video("01", "Título 1", "----", 4.5));
        videos.add(new Video("02", "Título 2", "----", 5.5));
        when(videoRepositoryMock.findAll()).thenReturn(videos);

        List<Video> result = cultureMediaService.findAll();
        assertEquals(2, result.size());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        when(videoRepositoryMock.findAll()).thenReturn(new ArrayList<>());
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.findAll());
    }

    @Test
    void when_FindByTitle_title_exists_should_return_videos_successfully() throws VideoNotFoundException {
        // Arrange
        List<Video> videos = new ArrayList<>();
        videos.add(new Video("01", "Título 1", "----", 4.5));
        when(videoRepositoryMock.find("Título 1")).thenReturn(videos);

        List<Video> result = cultureMediaService.find("Título 1");
        assertEquals(1, result.size());
    }

    @Test
    void when_FindByTitle_title_does_not_exist_an_VideoNotFoundException_should_be_thrown_successfully() {
        when(videoRepositoryMock.find("Título Inexistente")).thenReturn(new ArrayList<>());
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.find("Título Inexistente"));
    }

    @Test
    void when_FindAllVideosByDuration_videos_exist_with_given_duration_should_return_videos_successfully() throws VideoNotFoundException {
        Video video = new Video("01", "Titulo 1", "Documentary", 4.5);
        List<Video> videos = new ArrayList<>();
        videos.add(video);
        when(videoRepositoryMock.find(1.5, 4.5)).thenReturn(videos);
        cultureMediaService.save(video);
        List<Video> foundVideos = cultureMediaService.find(1.5, 4.5);
        assertEquals(1, foundVideos.size());
    }

    @Test
    void when_FindAllVideosByDuration_no_videos_exist_with_given_duration_an_VideoNotFoundException_should_be_thrown_successfully() {
        when(videoRepositoryMock.find(1.5, 3.5)).thenReturn(Collections.emptyList());
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.find(1.5, 3.5);
        });


    }
}

