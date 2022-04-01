import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    private final Player player1 = new Player(1, "Egor", 100);
    private final Player player2 = new Player(2, "Egor", 200);
    private final Player player3 = new Player(3, "Egor", 300);
    private final Player player4 = new Player(4, "Egor", 400);
    private final Player player5 = new Player(5, "Egor", 500);

    @Test
    void shouldCalc() {

        game.save(player2);
        Player[] expected = {player2};
        Player[] actual = game.findAll().toArray(new Player[0]);


        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrow() throws NotRegisteredException {


        Assertions.assertThrows(NotRegisteredException.class, () -> game.register(player1, false));
    }

    @Test
    void shouldAddIfRegistered() throws NotRegisteredException {


        Player[] expected = {player1};
        Player[] actual = game.register(player1, true).toArray(new Player[0]);

        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldFindBy() {
        assertTrue(game.matchesInt(player1, "Egor"));


    }

    @Test
    void shouldReturn2() {
        game.save(player1);
        game.save(player2);

        int actual =game.round(player1,player2);

        assertEquals(2,actual);


    }
    @Test
    void shouldReturn1() {
        game.save(player1);
        game.save(player2);

        int actual =game.round(player2,player1);

        assertEquals(1,actual);


    }
    @Test
    void shouldReturn0() {
        game.save(player1);


        int actual =game.round(player1,player1);

        assertEquals(0,actual);

    }

}