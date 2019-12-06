/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public String grade;
    public List<Embauche> lesEmbauches;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome, int niveau, GroupeSanguin gs, String grade) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau,gs);
        this.numeroDiplome = numeroDiplome;
        this.grade=grade;
        lesEmbauches = new LinkedList<>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur, ou null
     */
    public Club employeurActuel() {
        if (lesEmbauches.isEmpty()){
            return null;
        }
        else {
            if (lesEmbauches.get(lesEmbauches.size() - 1).estTerminee()){
            return null;
            }
            else {
            return lesEmbauches.get(lesEmbauches.size() - 1).getEmployeur();
            }
        }
        }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {   
        if (! lesEmbauches.isEmpty()) { 
            Embauche derniereEmbauche = lesEmbauches.get(lesEmbauches.size() - 1);
            if (null == derniereEmbauche.getFin()) 
                derniereEmbauche.setFin(debutNouvelle);    
        }	
        Embauche newEmbauche = new Embauche(debutNouvelle, this, employeur);
        lesEmbauches.add(newEmbauche);
    }

    public List<Embauche> emplois() {
        return Collections.unmodifiableList(lesEmbauches);

    }

}
