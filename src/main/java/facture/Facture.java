package facture;

import java.io.PrintStream;
import java.util.Date;
import java.util.LinkedList;

public class Facture {
    private int numero;
    private Date emission;
    private Client destinataire;
    private LinkedList<LigneFacture> mafacture = new LinkedList<>(); 
    

    public Facture(Client destinataire, Date emission, int numero) {
         this.numero= numero;
         this.emission = emission;
         this.destinataire= destinataire; 
        
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Get the value of emission
     *
     * @return the value of emission
     */
    public Date getEmission() {
         return emission;
    }

    /**
     * Get the value of destinataire
     *
     * @return the value of destinataire
     */
    public Client getDestinataire() {
        return destinataire;
    }


    
    public void ajouteLigne(Article a, int nombre, float remise) {
        mafacture.add( new LigneFacture(nombre, this, a, remise));
        
   }
    
   public float montantTTC(float tauxTVA) {
       float prix = 0;
       for (LigneFacture l : mafacture){
           prix += l.montantLigne()*(1+tauxTVA);
       }
       return prix;
   }
   
   public void print(float tva) {
        int nombreArticle = 0;
        System.out.println(" Facture " + getNumero() + " ");
        System.out.println("Destinataire : " + getDestinataire().ToString());
        System.out.println("Emis le : " + getEmission());
        System.out.println("Nombre total d'Article :" + nombreArticle);
        System.out.println("Total HT :" + montantTTC(0) + "€");
        System.out.println("Total TTC :" + montantTTC(tva) + "€");
   }
   
}
