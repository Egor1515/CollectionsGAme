import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Game extends Player {
    private final Collection<Player> players = new ArrayList<>();


    public void register(Player player) {

        players.add(player);


    }

    public boolean matchesInt(Player player, String name) {
        return player.getName().equals(name);
    }


    public Collection<Player> findAll() {
        return players;
    }

    public int round(String player1, String player2) throws NotRegisteredException {

        for (Player firstPlayer : players) {
            if (firstPlayer.getName().equals(player1)) {
                for (Player secondPlayer : players)
                if (secondPlayer.getName().equals(player2)) {
                    int result = player1.compareTo(player2);
                    if (result > 0) {
                        return 1;
                    }
                    if (result < 0) {
                        return 2;
                    }
                    if (result == 0) {
                        return 0;
                    }
                }
            }
        }
        throw new NotRegisteredException("Не зарегистрирован");
    }

    public void save(Player player) {
        players.add(player);
    }


}


