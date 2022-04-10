import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Game extends Player {
    private final Collection<Player> players = new ArrayList<>();


    public boolean register(Player player, boolean registered) throws NotRegisteredException {

        if (registered) {
            players.add(player);
            return true;

        }
        throw new NotRegisteredException("Не зарегистрирован");

    }

    public boolean matchesInt(Player player, String name) {
        return player.getName().equals(name);
    }


    public Collection<Player> findAll() {
        return players;
    }

    public int round(String player1, String player2) throws NotRegisteredException {

        for (Player player : findAll()) {
            if (register(player, true)) {
                int result = player1.compareTo(player2);
                if (result > 0) {
                    return 1;
                }
                if (result < 0) {
                    return 2;
                }

            }
        }
        return 0;
    }

    public void save(Player player) {
        players.add(player);
    }


}


