package pakcahyo2022;

public class cMember {
    String username;
    String pw;
    cMember (String id , String pass) {
        username = id;
        pw=pass;
    }
    public void setPass(String a){
        pw=a;
    }
    public String getUsername(){
        return username;
    }
    public String getPass(){
        return pw;
    }
}
