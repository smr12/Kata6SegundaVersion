package kata6.model;
public class Mail {
    private final String mail;
    private final Integer id;
    public Mail(Integer id, String mail) {
        this.mail = mail;
        this.id = id;
    }
    public String getMail() {
        return mail;
    }
    /*public String getDomain(){
        return mail.split("@")[1];
    }*/
}
