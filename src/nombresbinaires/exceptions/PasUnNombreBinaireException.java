package nombresbinaires.exceptions;

public class PasUnNombreBinaireException extends Exception {
    
    public PasUnNombreBinaireException(String chaine) {
        super("La chaîne" + chaine + " n'est pas un nombre binaire.");
    }
}
