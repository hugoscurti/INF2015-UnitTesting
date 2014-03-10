package commande;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommandeTest {
    
    Commande commande;
    
    @Before
    public void setUp() {
        commande = new Commande();
    }
    
    @After
    public void tearDown() {
        commande = null;
    }

    @Test
    public void testAjouterArticles() {
        Article pomme = new Article("Pomme", "Fruit rouge", new Montant(1.50));
        commande.ajouterArticles(pomme, 15);
        assertEquals(15, (int) commande.articlesCommandes.get(pomme));
        commande.ajouterArticles(pomme, 3);
        assertEquals(18, (int) commande.articlesCommandes.get(pomme));
    }

    @Test
    public void testRetirerArticles() {
        Article cafe = new Article("Café", "Boisson psychotrope fait à partir de grains moulus", new Montant(8.55));
        commande.ajouterArticles(cafe, 20);
        assertEquals(20, (int) commande.articlesCommandes.get(cafe));
        commande.retirerArticles(cafe, 18);
        assertEquals(2, (int) commande.articlesCommandes.get(cafe));
    }
    
    @Test
    public void testRetirerArticlesQuantiteSuperieur() {
        Article cafe = new Article("Café", "Boisson psychotrope fait à partir de grains moulus", new Montant(8.55));
        commande.ajouterArticles(cafe, 20);
        assertEquals(20, (int) commande.articlesCommandes.get(cafe));
        commande.retirerArticles(cafe, 30);
        assertFalse(commande.articlesCommandes.containsKey(cafe));
    }

    @Test
    public void testAjouterRabais() {
        Article oreo = new Article("Oréo", "Biscuit au chocolat et à la crème", new Montant(10));
        commande.ajouterArticles(oreo, 20);
        commande.ajouterRabais(10);
        assertEquals(180, commande.calculerPrixCommande(), 0);
    }

    @Test
    public void testCalculerPrixCommande() {
        Article oreo = new Article("Oréo", "Biscuit au chocolat et à la crème", new Montant(10));
        Article cafe = new Article("Café", "Boisson psychotrope fait à partir de grains moulus", new Montant(8.55));
        Article pomme = new Article("Pomme", "Fruit rouge", new Montant(1.50));
        Article carotte = new Article("Carotte", "Légume racine", new Montant(6.50));
        
        commande.ajouterArticles(oreo, 10);
        commande.ajouterArticles(cafe, 5);
        commande.ajouterArticles(pomme, 30);
        commande.ajouterArticles(carotte, 10);
        
        assertEquals(252.75, commande.calculerPrixCommande(), 0);
    }
}