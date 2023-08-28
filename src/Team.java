import java.util.ArrayList;
import java.util.List;

public class Team {

    private String color;
    private List<Pokemon> pokemonsList = new ArrayList<>();

    public Team() {
    }

    public Team(List<Pokemon> pokemonsList, String color) {
        this.pokemonsList = pokemonsList;
        this.color = color;
    }

    public List<Pokemon> getPokemonsList() {
        return pokemonsList;
    }

    public void setPokemonsList(List<Pokemon> pokemonsList) {
        this.pokemonsList = pokemonsList;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Team{" +
                "pokemonsList=" + pokemonsList +
                ", color='" + color + '\'' +
                '}';
    }
}

