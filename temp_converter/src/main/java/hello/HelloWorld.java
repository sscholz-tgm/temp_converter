package hello;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import password.LoginView;

@ManagedBean(name = "helloWorld")
/*
@RequestScoped
@SessionScoped
@ApplicationScoped
@Dependent
@ConversationScoped
*/
@SessionScoped
public class HelloWorld implements Serializable{
	private static final long serialVersionUID = 1L;
	private String firstName = "John";
    private String lastName = "Doe";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGreeting() {
        return "Hello" + " " + firstName + " " + lastName + "!";
    }
    

}
