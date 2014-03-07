/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commande;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ch891311
 */
public class ArticleTest {
    
    Article article;
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testObtenirNom() {
        article = new Article("Banane", "Fruit jaune", new Montant(1.50));
        assertEquals("Banane", article.obtenirNom());        
    }

    @Test
    public void testObtenirPrix() {
        article = new Article("Orange", "Fruit orange", new Montant(2.50));
        assertEquals(2.50, article.obtenirPrix().valeurMontant(), 0);
    }

    @Test
    public void testObtenirDescription() {
        article = new Article("Riz", "Aliment qui s'agence bien avec n'importe quel plat", 
                new Montant(10.50));
        assertEquals("Aliment qui s'agence bien avec n'importe quel plat", article.obtenirDescription());
    }

    @Test
    public void testModifierDescription() {
        article = new Article("Banane", "Fruit jaune", new Montant(2.50));
        article.modifierDescription("Fruit jaune qui se trouve dans toutes les épiceries");
        assertFalse(article.obtenirDescription().equals("Fruit jaune"));
        assertEquals("Fruit jaune qui se trouve dans toutes les épiceries", article.obtenirDescription());
    }

    @Test
    public void testModifierPrix() {
        article = new Article("Kitkat", "barre de chocolat", new Montant(1.50));
        article.modifierPrix(new Montant(0.75));
        assertFalse(article.obtenirPrix().valeurMontant() == 1.50);
        assertEquals(0.75, article.obtenirPrix().valeurMontant(), 0);
    }

    @Test
    public void testCompareTo() {
        article = new Article("Kitkat", "barre de chocolat", new Montant(1.50));
        Article  article2 = new Article("Banane", "barre de chocolat", new Montant(1.50));
        
        assertTrue(article.compareTo(article2) > 0);
    }
    
}
