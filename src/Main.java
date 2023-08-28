import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        // Liste de toutes les équipes de pokemons
        List<Team> teamsList = new ArrayList<>();
        // Données complètes à ne pas modifier
        List<Pokemon> pokemonList = new ArrayList<>();
        List<String> colorList = new ArrayList<>();

        // Remplis les listes passées en argument avec les données importées des fichiers JSon
        FillListsFromImportedDatasetFromJson(pokemonList,colorList);

        // Données temporaires pouvant être modifées
        List<String> tempListColors = new ArrayList<>(colorList);
        List<Pokemon> tempListPokemons = new ArrayList<>(pokemonList);

        // Je crée les équipes
        TeamCreation(tempListColors, tempListPokemons, teamsList);

        // J'affiche les résultats
        DisplayResult(teamsList);

        // Séléction de 2 équipes alétoires

        // Combat entre les deux équipes
            // Séléction de deux pokemons de deux équipes
            // Combat des deux pokemons
            // Créer le système de changement de pokemon quand il y a un mort
                // Peut-être le meilleur moment pour vérifier qu'une équipe est vide
            // Combat des deux pokemons
            // ...
            // Vérifications qu'une équipe est vide (pokemons tous mort)

        // Afficher les résultats des combats



    }

    private static void DisplayResult(List<Team> teamsList) {
        for (int i = 0; i < teamsList.size(); i++) {
            //Stock l'équipe en cours en cours
            Team currentTeam = teamsList.get(i);
            System.out.println("Groupe " + (i + 1) + " : " + currentTeam.getColor() +
                    " | Pokemons : " + currentTeam.getPokemonsList());
        }
    }

    private static void TeamCreation(List<String> tempListColors, List<Pokemon> tempListPokemons, List<Team> teamsList) {
        int countGroup = 0;
        Random random = new Random();

        while (!tempListPokemons.isEmpty()) {
            Team team = new Team();

            for (int i = 0; i < 5; i++) {
                // Vérifie s'il y a encore des tempListPokemons dans ma liste car sinon elle continue ses 5 itérations
                if (!tempListPokemons.isEmpty()) {
                    // Je recupère un pokemon
                    int randomPokemon = random.nextInt(tempListPokemons.size());
                    Pokemon myPokemon = tempListPokemons.get(randomPokemon);
                    // J'ajoute le pokemon
                    List<Pokemon> teamPokemonsList = team.getPokemonsList();
                    teamPokemonsList.add(myPokemon);
                    // J'enlève le pokemon de la liste de base
                    tempListPokemons.remove(randomPokemon);

                } else {
                    System.out.println("Tous les pokemons ont été ajoutés à la liste, la liste Json est vide");
                }

            }
            // J'attribue une couleur aléatoire à chaque équipe de pokemon
            String randomColor = tempListColors.get(random.nextInt(tempListColors.size()));

            tempListColors.remove(randomColor);

            // Ajouter toute la logique de couleur à l'équipe
            // Remplacer "toto" par la couleur qui sera sélectionnée
            team.setColor(randomColor);

            teamsList.add(team);
            countGroup++;

            //System.out.println(teamsList.size() + " ont été créés");
            // Validation du chantier
        /* Format de la réponse
           X groupes ont été créées :
           Groupe 1 : couleur | Pokemons : titi, toto, tata, tutu, tete
           Groupe 2 : couleur | Pokemons : titi, toto, tata, tutu, tete
           Groupe 3 : couleur | Pokemons : titi, toto, tata, tutu, tete
           Groupe 4 : couleur | Pokemons : titi, toto, tata, tutu, tete
           Groupe 5 : couleur | Pokemons : titi, toto, tata, tutu, tete
           ...
         */

        }
        // Affiche le nombre de groupes
        System.out.println(countGroup + " ont été créés");
    }

    private static void FillListsFromImportedDatasetFromJson(List<Pokemon> pokemonList, List<String> colorList) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader
                ("C:/zoneDev/pokedie/PokeListJSON.json"));
        JSONObject jsonObject2 = (JSONObject) jsonParser.parse((new FileReader(
                "c:/zoneDev/pokedie/ListCouleursJSON.json")));

        for (Object color : jsonObject2.keySet()) {
            String colorName = color.toString();
            colorList.add(colorName);
        }
        /* Autres méthodes pour créer une nouvelle instance de la liste existante (cloner une liste)
        List<String> tempListColors = listColors.stream().toList();

        List<String> tempListColors = new ArrayList<>();
        tempListColors.addAll(listColors);
        */


        /*La boucle itère sur les clés (les noms des pokemon) de l'objet jsonObjet, qui est ma
        qui contient mes données */

        for (Object objet : jsonObject.keySet()) {
            //La clé nom de pokemon est convertie en string puis stokée dans pokemonName
            String pokemonName = objet.toString();
            /* On extrait la valeur associée à la clé actuelle de ma liste jsonObject
            Permet de transformer un objet en JsonObjetct, pour créer une struture. Sans ça
            on ne peut pas appeler les méthodes (get par exemple)
            */
            JSONObject pokemonData = (JSONObject) jsonObject.get(pokemonName);
            //TODO: Commenter le code
            /*
                Ici, le code extrait la valeur associée à la clé "force" à partir de l'objet pokemonData.
                Cette valeur est d'abord obtenue en tant qu'objet, puis elle est convertie en chaîne de caractères en utilisant .toString(),
                et enfin, cette chaîne est convertie en entier à l'aide de Integer.parseInt(...).
                La valeur entière résultante est stockée dans la variable force.
             */

            int force = Integer.parseInt(pokemonData.get("force").toString());
            int defense = Integer.parseInt(pokemonData.get("defense").toString());
            int healthPoints = Integer.parseInt(pokemonData.get("points_de_vie").toString());


            //
            pokemonList.add(new Pokemon(pokemonName, force, defense, healthPoints));
            //Pokemon.add(jsonObject.get(newPokemon).toString());
            /*System.out.println("PokemonName :" + pokemonName);
            System.out.println("Force: " + force);
            System.out.println("Defense: " + defense);
            System.out.println("HealthPoints: " + healthPoints);
            */
        }
    }
}
