package commande;

import commande.exceptions.PrixNegatifException;
import commande.exceptions.PrixNulException;

public class Article implements Comparable<Article> {
    
    private String nom;
    private String description;
    private Montant prix;
    
    public Article(String nom, String description, Montant prix) throws PrixNegatifException, PrixNulException {
        if (prix.estNegatif()) {
            throw new PrixNegatifException();
        } else if (prix.estNul()) {
            throw new PrixNulException();
        }
        
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }
        
    public String obtenirNom() {
        return this.nom;
    }
    
    public Montant obtenirPrix() {
        return this.prix;
    }
    
    public String obtenirDescription() {
        return this.description;
    }
    
    public void modifierDescription(String nouvelleDescription) {
        this.description = nouvelleDescription;
    }
    
    public void modifierPrix(Montant nouveauPrix) throws PrixNegatifException, PrixNulException {
        if (nouveauPrix.estNegatif()) {
            throw new PrixNegatifException();
        } else if (nouveauPrix.estNul()) {
            throw new PrixNulException();
        }
        
        this.prix = nouveauPrix;
    }
    

    @Override
    public int compareTo(Article autre) {
        return this.nom.compareTo(autre.nom);
    }


}
