public class MenuInfo {
    private String nom, sexe, study, cercle;

    public MenuInfo(){}
    public MenuInfo(String nom, String sexe, String study, String cercle){
        this.nom = nom;
        this.sexe = sexe;
        this.study = study;
        this.cercle = cercle;
    }

    public String toString(){
        String str;
        if(this.nom != null && this.sexe != null && this.cercle != null && this.study != null){
            str = "Voici ton personnage\n";
            str += "Nom : " + this.nom + "\n";
            str += "Sexe : " + this.sexe + "\n";
            str += "Etudes : " + this.study + "\n";
            str += "Cercle : " + this.cercle + "\n";
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
    public String getStudy(){
        return this.study;
    }
}