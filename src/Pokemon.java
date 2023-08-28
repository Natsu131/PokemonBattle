public class Pokemon {
    private String pokemonName;
    private int force;
    private int defence;
    private int healthPoints;


    public Pokemon(String pokemonName, int force, int defence, int healthPoints) {
        this.pokemonName = pokemonName;
        this.force = force;
        this.defence = defence;
        this.healthPoints = healthPoints;

    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "pokemonName='" + pokemonName + '\'' +
                ", force=" + force +
                ", defence=" + defence +
                ", healthPoints=" + healthPoints +
                '}';
    }
}
