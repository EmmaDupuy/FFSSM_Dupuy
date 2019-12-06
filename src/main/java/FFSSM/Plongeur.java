package FFSSM;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Plongeur extends Personne {
	public int niveau;
        public GroupeSanguin gs;
        public List<Licence> lesLicences;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int niveau, GroupeSanguin gs) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.gs=gs;
        lesLicences = new LinkedList<>();
    }
    public void ajouteLicence(Licence l) {
	lesLicences.add(l);
	}

    public Licence derniereLicence(){
        int size;
        size = lesLicences.size();
        if (lesLicences.isEmpty()){
            return null;
        }
        else{
            return lesLicences.get(size-1);
        }
    }
}
