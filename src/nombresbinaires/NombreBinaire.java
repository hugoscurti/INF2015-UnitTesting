package nombresbinaires;

import nombresbinaires.exceptions.PasUnNombreBinaireException;
import java.util.Arrays;

/**
 * Classe représentant un nombre binaire.
 */
public class NombreBinaire {
    
    /* Le bit le moins significatif est à l'index 0
    et le bit le plus significatif est à la dernière position. */
    private int[] bits;
    
    public NombreBinaire(String chaine) throws PasUnNombreBinaireException {
        if (!chaine.matches("^[01]*$")) {
            throw new PasUnNombreBinaireException(chaine);
        }
        
        bits = convertToArrayOfInteger(chaine);
    }
    
    
    private int[] convertToArrayOfInteger(String chaine) {
        
        int longueur = chaine.length(); 
        int[] resultat = new int[longueur];
            
        for (int i = 0; i < resultat.length; ++i) {
            resultat[i] = (int) chaine.charAt(longueur - i - 1) - '0';
        }
        
        return resultat;
    }
        
    
    public int longueur() {
        return bits.length;
    }
    
    
    public void enleverZerosInutiles() {
        int i = bits.length - 1;
        
        while (i > 0 && bits[i] == 0) {
            --i;
        }
        
        if (i < bits.length - 1) {
            bits = Arrays.copyOf(bits, i + 1);
        }
    }
    
    public int obtenirValeurDecimale() {
        int valeur = 0;
        
        for (int i = 0; i <= bits.length; ++i) {
            valeur += bits[i] * 2^i;
        }
        
        return valeur;
    }
    
    @Override
    public String toString() {
        StringBuilder nbBinaire = new StringBuilder(bits.length);
        
        for (int i = bits.length - 1; i >= 0; --i) {
            nbBinaire.append(String.valueOf(bits[i]));
        }
        
        return nbBinaire.toString();
    }
}
