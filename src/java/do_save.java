
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class do_save extends db_connect implements Serializable {

    String username;
    String firstname;
    String nickname;

    public do_save() throws Exception {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    String password;

    public void save() throws Exception {
        if (this.getFirstname().equals("") || this.getNickname().equals("") || this.getUsername().equals("") || this.getPassword().equals("")) {
            this.give_alert();
        } else {
            boolean door=this.do_saving();
            if(door){
                this.do_it();
            }
            else{
                this.give_alert();
            }
        }
    }

    public boolean do_saving() throws Exception {
        String query = "INSERT INTO USERS (firstname,nickname,username,password) VALUES ('" + this.getFirstname() + "','" + this.getNickname() + "','"
                + this.getUsername() + "','" + this.getPassword() + "')";
        int num = stmt.executeUpdate(query);
        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }

    public String give_alert() {
        //hata yazdır buraya
        return "index.xhtml";
    }
    
     public String do_it() {
        //başarılı uyarı yazdır buraya
        return "index.xhtml";
    }
}