import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.Collection;


public class Game extends Player {
    public final Collection<Player> players = new ArrayList<>();


    public Collection<Player> register(Player player, boolean registered) throws NotRegisteredException {

        if (registered) {
            players.add(player);
            return players;
        }
        throw new NotRegisteredException("Не зарегистрирован");

    }

    public boolean matchesInt(Player player, String name) {
        return player.getName().equals(name);
    }

    public Collection<Player> findByName(String Name) {
        for (Player player : findAll()) {
            if (matchesInt(player, Name)) {
                return players;
            }
        }
        return null;


    }

    public int compare(Player o1, Player o2) {
        return o1.getStrength() - o2.getStrength();
    }


    public int round(Player player1, Player player2) {
        int result = compare(player1, player2);
        if (result > 0) {
            return 1;
        }
        if (result < 0) {
            return 2;
        }
        return 0;
    }


    public void save(Player player) {
        players.add(player);
    }

    public Collection<Player> findAll() {
        return players;
    }

}
