import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    void shouldNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.next();

        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void shouldNextStationAfter9() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.prev();

        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldPrevStationBefore0() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        radio.prev();

        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldSetStationInRange() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);

        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.setCurrentStation(15);

        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.setCurrentStation(-1);

        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(50);

        radio.increaseVolume();

        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolumeAbove100() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);

        radio.increaseVolume();

        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);

        radio.decreaseVolume();

        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolumeBelow0() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);

        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldNotSetVolumeAbove100() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);

        radio.setCurrentVolume(150);

        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    void shouldNotSetVolumeBelow0() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);

        radio.setCurrentVolume(-10);

        assertEquals(50, radio.getCurrentVolume());
    }
}