import com.aptech.AlbumManagement;
import com.aptech.models.Artist;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAlbum {
    private Faker faker = new Faker();
    private AlbumManagement albumManagement = new AlbumManagement();
    @Test
    public void testArtists(){
        List<Artist> artists = new ArrayList<Artist>();
        for(int i = 0; i < 1000; i++) {
            Artist artist = new Artist(faker.artist().name());
            artists.add(artist);
            System.out.println(artist);
        }
        assertEquals (1000, artists.size());
    }
    @Test
    public void testViewCount(){
        albumManagement.initiateAlbumnList();
        assertEquals (130, albumManagement.getMinViewCount().getViewCount());
        assertEquals (15000, albumManagement.getMaxViewCount().getViewCount());
    }
}
