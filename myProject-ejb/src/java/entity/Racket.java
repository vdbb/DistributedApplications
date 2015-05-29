package entity;

import enums.RacketVendor;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "racket")
public class Racket extends Article {

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    @NotNull
    protected RacketVendor vendor;
    @Basic(optional = false)
    @NotNull
    protected double weight;
    @Basic(optional = false)
    @NotNull
    protected double stringtension;
    
    
    public Racket() {
        super();
    }

    public Racket(Integer id, int price, String description) {
        super(price, description);
    }

    public Racket(RacketVendor vendor, double weight, double stringtension, int price, String description) {
        super(price, description);
        this.vendor = vendor;
        this.weight = weight;
        this.stringtension = stringtension;
    }

    public RacketVendor getVendor() {
        return vendor;
    }

    public void setVendor(RacketVendor vendor) {
        this.vendor = vendor;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getStringtension() {
        return stringtension;
    }

    public void setStringtension(double stringtension) {
        this.stringtension = stringtension;
    }
    
    
}
