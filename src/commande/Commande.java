package commande;

import java.util.Map.Entry;
import java.util.TreeMap;

public class Commande {
    
    protected TreeMap<Article, Integer> articlesCommandes;
    protected int rabais;
    
    public Commande() {
        articlesCommandes = new TreeMap<>();
        rabais = 0;
    }
    
    /**
     * Ajoute à la commande la quantité de l'article spécifié.
     */
    public void ajouterArticles(Article article, int quantite) {
        if (quantite > 0) {
            Integer ancienne = articlesCommandes.get(article);
            if (ancienne != null) {
                quantite += ancienne;
            }
            articlesCommandes.put(article, quantite);
        }
    }
    
    /**
     * Enleve à la commande la quantité de l'article spécifié.
     * Si l'article n'est pas dans la commande, on ne fait rien.
     * Si la quantité de l'article est inférieur à celle spécifié, 
     * on enlève l'article de la commande.
     * Si la quantité est négative, on ne fait rien.
     */
    public void retirerArticles(Article article, int quantite) {
        if(quantite > 0) {
            
            Integer quantiteTotale = articlesCommandes.get(article);
            if (quantiteTotale != null) {
                quantiteTotale -= quantite;

                if(quantiteTotale < 0) {
                    articlesCommandes.remove(article);
                } else {
                    articlesCommandes.put(article, quantiteTotale);
                }
            }
        }
    }
    
    /**
     * 
     * @param pourcentage Pourcentage entre 0 et 100 exclusivement.
     * @return Vrai si le pourcentage a été ajouté, faux sinon.
     */
    public boolean ajouterRabais(int pourcentage) {
        if(pourcentage > 0 && pourcentage < 100) {
            rabais = pourcentage;
            return true;
        }
        
        return false;
    }

    public double calculerPrixCommande() {
        Montant total = new Montant(0);
        
        try{
            Thread.sleep(10);   //Simulation de long traitement.
        } catch (Exception e) {}
        
        
        //Additionner les montants
        for(Entry<Article, Integer> entree: articlesCommandes.entrySet()) {
            Montant totalPartiel = new Montant(0);
            totalPartiel.additionnerMontant(entree.getKey().obtenirPrix());
            totalPartiel.multiplierFacteur(entree.getValue());
            total.additionnerMontant(totalPartiel);
        }
        
        //Appliquer les rabais
        total.appliquerRabais(this.rabais);
        
        return total.valeurMontant();
    }
    
}
