package commande.exceptions;

public class PrixNegatifException extends RuntimeException {
    
    
    public PrixNegatifException() {
        super("Le prix d'un article ne peut être négatif.");
    }
}
