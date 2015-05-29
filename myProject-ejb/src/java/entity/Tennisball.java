package entity;

import enums.BallType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "tennisball")
public class Tennisball extends Article {

    protected double diameter;
    @Enumerated(EnumType.STRING)
    protected BallType balltype;
    
    public Tennisball() {
        super();
    }

    public Tennisball(Integer id, int price, String description) {
        super(price, description);
    }

    public Tennisball(double diameter, BallType balltype, int price, String description) {
        super(price, description);
        this.diameter = diameter;
        this.balltype = balltype;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public BallType getBalltype() {
        return balltype;
    }

    public void setBalltype(BallType balltype) {
        this.balltype = balltype;
    }

}
