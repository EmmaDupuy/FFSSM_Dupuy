/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.util.Calendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlongeesTest {
    Personne p ;
    Plongeur pl;
    Licence l;
    Plongee plo;
    Club c;
    Embauche e;
    Moniteur m;
    Site s;
    
    @Before
	public void setUp() {
            p= new Personne("2 99 05 57", "Dupont", "Margot", null, null, null);
            pl= new Plongeur("2 99 05 57", "Dupont", "Margot", null, null, null,1, GroupeSanguin.APLUS);
            plo = new Plongee(s, m, null, 20, 30);
            c = new Club(null, "Argeles-su-Mer", null);
            e = new Embauche(null, m,c);
            m = new Moniteur("2 99 05 57", "Dupont", "Margot", null, null, null,2,1, GroupeSanguin.APLUS,null);
	}
    
    @Test    
    public void testEstValide(){
        Calendar delivrance = Calendar.getInstance();
        l = new Licence(pl,"1",delivrance,2,c);
        assertTrue(l.estValide(delivrance));
        
        Calendar lAnAprès = (Calendar) delivrance.clone(); 
        lAnAprès.add(Calendar.YEAR, 1);
        assertTrue(l.estValide(lAnAprès));
        Calendar DeuxAnAprès = (Calendar) delivrance.clone(); 
        DeuxAnAprès.add(Calendar.YEAR, 2);
        assertFalse(l.estValide(DeuxAnAprès));
    }
   /* @Test
    public void testEstConforme(){
    Calendar delivrance = Calendar.getInstance();
    l = new Licence(pl,"1",delivrance,2,c);
    pl.ajouteLicence(l);
    plo.ajouteParticipant(pl);
    //System.out.println(plo.estConforme());
    assertTrue(plo.estConforme());
   }*/
    
    @Test 
    public void testAjouteLicence(){
    Calendar delivrance = Calendar.getInstance();
    l = new Licence(pl,"1",delivrance,2,c);
    pl.ajouteLicence(l);    
    assertEquals(pl.lesLicences.get(pl.lesLicences.size()-1), l);
    }
    
    @Test 
    public void testAjouteParticipants(){
        Calendar delivrance = Calendar.getInstance();
        l = new Licence(pl,"1",delivrance,2,c);
        pl.ajouteLicence(l);
        plo.ajouteParticipant(pl);    
        assertEquals(plo.lesParticipants.get(plo.lesParticipants.size()-1), pl);
    }
    
    @Test 
    public void testDerniereLicence(){
        Calendar delivrance = Calendar.getInstance();
        l = new Licence(pl,"1",delivrance,2,c);
        assertEquals(pl.derniereLicence(), null);
        pl.ajouteLicence(l);
        assertEquals(pl.derniereLicence(), l);
    }
    
    @Test
    public void testTerminerEmbauche(){
        Calendar dateEmbauche = Calendar.getInstance();
        e = new Embauche(dateEmbauche, m,c);
        Calendar unMoisApres = (Calendar) dateEmbauche.clone(); 
        unMoisApres.add(Calendar.MONTH, 1);
        e.terminer(unMoisApres);
        assertTrue(e.estTerminee());
    }
    
    @Test 
    public void testMoniteur(){
        Calendar debutNouvelle = Calendar.getInstance();
        m.nouvelleEmbauche(c, debutNouvelle);
        assertEquals(m.employeurActuel(), c);
    }
    
    @Test
    public void testClub(){
        
    }
}

