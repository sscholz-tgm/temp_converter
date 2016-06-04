package tempconv;
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
public class TemperatureConverter {
    
    private double temp = 0;
    private double tempConv = 0;
    private String unit = "C";

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempConv() {
        return tempConv;
    }

    public void setTempConv(double tempConv) {
        this.tempConv = tempConv;
    }
    
    public void convert(String from, String to){
        double tempFrom = 0;
        //alles nach K
        switch(from){
            case "C": tempFrom=temp+273.15;
                break;
            case "F": tempFrom=(temp+459.67)*5/9;
                break;
            case "K": break;
            default: break;
        }
        //alles von K
         switch(to){
            case "C": tempConv = tempFrom -273.15;
            unit = "C";
                break;
            case "F":  tempConv = (tempFrom-273.15)*1.8 +32;
            unit = "F";
                break;
            case "K": tempConv = tempFrom;
            unit = "K";
                break;
            
            default: break;
        }
      
    }
    
    public void reset(){
        temp = 0;
        tempConv = 0;
        unit = "C";
    }
    
}
