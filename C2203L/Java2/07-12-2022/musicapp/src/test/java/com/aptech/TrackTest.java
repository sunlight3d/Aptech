package com.aptech;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test read/write csv")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TrackTest {
    private static List<Track> trackList = new ArrayList<>();
    private String fileName = "output.csv";

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all test methods");
        Track track1 = new Track("t1", 123);
        Track track2 = new Track("t2", 222);
        Track track3 = new Track("t3", 333);
        trackList = List.of(track1, track2, track3);
    }
    @Test
    @Order(1)
    void testNumberOfTracks() {
        assertEquals(3, trackList.size());
    }
    @Test
    @Order(2)
    void testWriteCsvFile() {
        try {
            FileWriter fileWriter = new FileWriter(this.fileName);
            for(Track track: trackList) {
                fileWriter.write(String.format("%s,%d\n",
                        track.getName(), track.getViewCount()));
            }
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    @Test
    @Order(3)
    void testReadCsvFile() {
        ArrayList<Track> tracks = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(this.fileName));
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                Track track = new Track(data.split(",")[0], Integer.parseInt(data.split(",")[1]));
                tracks.add(track);
            }
            scanner.close();
            assertEquals(3, tracks.size());
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Test
    void testToString() {
    }
    @AfterAll
    static void afterAll() {
        System.out.println("After all test methods");
    }
}