package nombresbinaires;

import nombresbinaires.exceptions.PasUnNombreBinaireException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class NombreBinaireTest {

    NombreBinaire nombreBinaire;
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test(expected=PasUnNombreBinaireException.class)
    public void testConstructeurPasUnNombreBinaire() {
        nombreBinaire = new NombreBinaire("352");
    }

    @Test
    public void testLongueur() {
        nombreBinaire = new NombreBinaire("1110010");
        assertEquals(7, nombreBinaire.longueur());
    }

    @Test
    public void testEnleverZerosInutiles() {
        nombreBinaire = new NombreBinaire("0001010");
        assertEquals(7, nombreBinaire.longueur());
        nombreBinaire.enleverZerosInutiles();
        assertEquals(4, nombreBinaire.longueur());
        assertEquals("1010", nombreBinaire.toString());
    }
    
    @Test
    public void testEnleverZeroNombreNul() {
        nombreBinaire = new NombreBinaire("00000000");
        assertEquals(8, nombreBinaire.longueur());
        nombreBinaire.enleverZerosInutiles();
        assertEquals(1, nombreBinaire.longueur());
    }
    

    @Test
    @Ignore
    public void testObtenirValeurDecimale() {
        nombreBinaire = new NombreBinaire("11010");
        assertEquals(26, nombreBinaire.obtenirValeurDecimale());
    }
    
    @Test
    public void testObtenirValeurDecimaleNulle() {
        nombreBinaire = new NombreBinaire("0");
        assertEquals(0 , nombreBinaire.obtenirValeurDecimale());
        
    }

    @Test
    public void testToString() {
        nombreBinaire = new NombreBinaire("000101010110");
        assertEquals("000101010110" , nombreBinaire.toString());
    }
}