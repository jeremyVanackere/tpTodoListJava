package todolist;
public enum Etat {
    TERMINER("Terminer"),
    EN_COUR("En cour");

    private String value = "";

    //Constructeur
    Etat(String value){
        this.value = value;
    }

    public String toString(){
        return value;
    }
}
