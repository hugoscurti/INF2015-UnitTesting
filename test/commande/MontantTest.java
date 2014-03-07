
package commande;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MontantTest {
    
    Montant montant;
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testEstNegatifMontantNegatif() {
        montant = new Montant(-2.50);
        assertTrue(montant.estNegatif());
    }
    
    @Test
    public void testEstNegatifMontantPositif() {
        montant = new Montant(12.15);
        assertFalse(montant.estNegatif());
    }
    
    
    @Test
    public void testEstNul() {
        montant = new Montant(0.0);
        assertTrue(montant.estNul());
    }
    
    @Test
    public void testEstNulMontantNonNul() {
        montant = new Montant(12);
        assertFalse(montant.estNul());
    }

    @Test
    public void testAdditionnerMontant() {
        montant = new Montant(4.55);
        montant.additionnerMontant(new Montant(2.15));
        assertEquals(6.70, montant.valeurMontant(), 0);
    }

    @Test
    public void testMultiplierFacteur() {
        montant = new Montant(3.10);
        montant.multiplierFacteur(4);
        assertEquals(12.40, montant.valeurMontant(), 0);
    }

    @Test
    public void testAppliquerRabais() {
        montant = new Montant(50);
        montant.appliquerRabais(10);
        assertEquals(45, montant.valeurMontant(), 0);
    }

    @Test
    public void testValeurMontant() {
        montant = new Montant(132.15);
        assertEquals(132.15, montant.valeurMontant(), 0);
    }
    
}
