import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    public Game game = new Game();
    private final Player first = new Player(1, "egor", 100);
    private final Player second = new Player(2, "second", 200);
    private final Player third = new Player(3, "third", 300);
    private final Player forth = new Player(4, "forth", 400);
    private final Player fifth = new Player(5, "fifth", 500);

    @Test
    void shouldCalc() {
        game.save(second);
        Player[] expected = {second};
        Player[] actual = game.findAll().toArray(new Player[0]);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrow() {
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Egor", "second"));
    }

    @Test
    void shouldFindByName() {
        assertTrue(game.matchesInt(first, "egor"));
    }

    @Test
    void shouldReturn1() throws NotRegisteredException {
        game.save(third);
        game.save(second);
        game.save(first);
        int actual = game.round("egor", "third");
        assertEquals(2, actual);
    }

    @Test
    void shouldReturnThrow() throws NotRegisteredException {
        game.save(third);
        game.save(first);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("third", "first"));
    }

    @Test
    void shouldReturn0() throws NotRegisteredException {
        game.save(second);
        game.save(fifth);
        int actual = game.round("second", "fifth");
        assertEquals(1, actual);
    }

    @Test
    void shouldReturn2() throws NotRegisteredException {
        game.save(second);
        game.save(fifth);
        int actual = game.round("fifth", "second");
        assertEquals(2, actual);
    }

}