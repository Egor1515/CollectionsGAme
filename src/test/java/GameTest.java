import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    public Game game = new Game();
    private final Player first = new Player(1, "Egor", 100);
    private final Player second = new Player(2, "Egor", 200);
    private final Player third = new Player(3, "Egor", 300);
    private final Player forth = new Player(4, "Egor", 400);
    private final Player fifth = new Player(5, "Egor", 500);

    @Test
    void shouldCalc() {

        game.save(second);
        Player[] expected = {second};
        Player[] actual = game.findAll().toArray(new Player[0]);


        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrow() {

        Assertions.assertThrows(NotRegisteredException.class, () -> game.register(first, false));
    }

    @Test
    void shouldAddIfRegistered() throws NotRegisteredException {


        boolean actual = game.register(second, true);

        assertTrue( actual);


    }

    @Test
    void shouldFindBy() {
        assertTrue(game.matchesInt(first, "Egor"));

    }

    @Test
    void shouldReturn1() throws NotRegisteredException {
        game.save(third);
        game.save(first);

        game.register(first,true);
        game.register(third,true);

        int actual =game.round("first","third");

        assertEquals(2,actual);


    }
    @Test
    void shouldReturnThrow() throws NotRegisteredException {
        game.save(third);
        game.save(first);

        game.register(first,true);
        game.register(third,false);

        Assertions.assertThrows(NotRegisteredException.class,() -> game.round("third","first"));


    }
    @Test
    void shouldReturn0() throws NotRegisteredException {
        game.save(fifth);
        game.save(second);

        int actual =game.round("second","fifth");
        assertEquals(1,actual);

    }

}