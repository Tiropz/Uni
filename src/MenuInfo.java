public class MenuInfo {
    private String nom, sexe, age, cheveux, taille;

    public MenuInfo(){}
    public MenuInfo(String nom, String sexe, String cheveux, String taille){
        this.nom = nom;
        this.sexe = sexe;
        this.cheveux = cheveux;
        this.taille = taille;
    }

    public String toString(){
        String str;
        if(this.nom != null && this.sexe != null && this.taille != null && this.cheveux != null){
            str = "Voici ton personnage\n";
            str += "Nom : " + this.nom + "\n";
            str += "Sexe : " + this.sexe + "\n";
            str += "Cheveux : " + this.cheveux + "\n";
            str += "Taille : " + this.taille + "\n";
        }
        else{
            str = "Aucune information !";
        }
        return str;
    }
    public String getNom(){
        return this.nom;
    }
    public String getSexe(){
        return this.sexe;
    }
    public String getCheveux(){
        return this.cheveux;
    }
}