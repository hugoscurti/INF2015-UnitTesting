package commande;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Montant {
    int cents;
      
    public Montant(double montant) {
        cents = (int) (montant * 100);
    }
    
    public boolean estNegatif() {
        return cents < 0;
    }
    
    public boolean estNul() {
        return cents == 0;
    }
    
    public void additionnerMontant(Montant autreMontant) {
        cents += autreMontant.cents;
    }
    
    public void multiplierFacteur(int facteur) {
        cents *= facteur;
    }
   
    /**
     * @param pourcentage Nombre entre 0 et 100 représentant le pourcentage
     * d'un rabais à appliquer
     */
    public void appliquerRabais(int pourcentage) {
        cents -= (cents * (pourcentage / 100.0));
    }
        
    public double valeurMontant() {
        double rawMontant = cents / 100.0;
        return new BigDecimal(rawMontant).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
