package nombresbinaires.exceptions;

public class PasUnNombreBinaireException extends RuntimeException {
    
    public PasUnNombreBinaireException(String chaine) {
        super("La chaîne " + chaine + " n'est pas un nombre binaire.");
    }
}
