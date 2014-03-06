package commande.exceptions;

public class PrixNulException extends RuntimeException{
    
    public PrixNulException() {
        super("Le prix ne peut pas être nul.");
    }
}
