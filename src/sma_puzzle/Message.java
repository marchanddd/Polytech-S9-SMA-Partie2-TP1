/**
 * AMELIORATION : expiration du message / annulation (envoie d'un message annulant une demande)
 */

package sma_puzzle;

/**
 *
 * @author Epulapp
 */
public class Message {
    
    public static enum ACTLANGAGE {REQUEST};
    public static enum ACTION {BOUGER};
    
    private Agent expediteur;
    private Agent destinataire;
    private ACTLANGAGE actLang;
    private ACTION action;
    private Coordonnees position; //position

    public Message(Agent expediteur, Agent destinataire, ACTLANGAGE actLang, ACTION action, Coordonnees position) {
        this.expediteur = expediteur;
        this.destinataire = destinataire;
        this.actLang = actLang;
        this.action = action;
        this.position = position;
    }
    
    /**
     * Getters / Setters
     */
    
    public Agent getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(Agent expediteur) {
        this.expediteur = expediteur;
    }

    public Agent getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Agent destinataire) {
        this.destinataire = destinataire;
    }

    public ACTLANGAGE getActLang() {
        return actLang;
    }

    public void setActLang(ACTLANGAGE actLang) {
        this.actLang = actLang;
    }

    public ACTION getAction() {
        return action;
    }

    public void setAction(ACTION action) {
        this.action = action;
    }

    public Coordonnees getPosition() {
        return position;
    }

    public void setPosition(Coordonnees position) {
        this.position = position;
    }

    
    
}
