/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.LinkedList;

public class Plongee {

	public Site lieu;

	public Moniteur chefDePalanquee;

	public Calendar date;

	public int profondeur;

	public int duree;
        
        public List<Plongeur> lesParticipants;

	public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
                lesParticipants = new LinkedList<>();
	}

	public void ajouteParticipant(Plongeur participant) {
            lesParticipants.add(participant);
	}

	public Calendar getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
            boolean conforme = true;
            for (Plongeur participant : lesParticipants)
            {
                if (participant.derniereLicence() == null)
                {
                    conforme = false;
                }
                else if (!participant.derniereLicence().estValide(participant.derniereLicence().getDelivrance())){
                    conforme=false;
                }
            }
            return conforme;
	}

}
