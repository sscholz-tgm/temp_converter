
package password;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sebastian
 */
@ManagedBean
@SessionScoped
public class LoginView {
    private final static String superSecret = "DasSicherstePasswort";
    private final static String bestUser = "admin";
    
    private String password = "";
    private String username = "";
    private boolean islogin;

    public boolean isIslogin() {
        return islogin;
    }

    public void setIslogin(boolean islogin) {
        this.islogin = islogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public boolean getValidation(){
        
        System.out.println("getValidation()");
        System.out.println(password+","+bestUser);
        if(password.equals(superSecret)&&username.equals(bestUser)){
            try {
                System.out.println("valid");
                islogin=true;
                FacesContext.getCurrentInstance().getExternalContext().redirect("hello.xhtml");
            } catch (IOException ex) {
                islogin = false;
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        islogin = false;
        System.out.println("not valid");
        return false;
    }
    
    public void onload() { 
        System.out.println("onload");
        if(islogin)return;
        else{
            try {
                password = "";
                username="";
                    FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

    }
    


}
