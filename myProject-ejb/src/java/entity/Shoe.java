package entity;

import enums.ShoeBrand;
import enums.TerrainType;
import java.awt.Color;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "shoe")
public class Shoe extends Article {

    @Enumerated(EnumType.STRING)
    protected ShoeBrand brand;
    protected double size;
    @Enumerated(EnumType.STRING)
    protected TerrainType terrain;
    protected Color color;
    
    public Shoe() {
    }

    public Shoe(int price, String description) {
        super(price, description);
    }

    public Shoe(ShoeBrand brand, double size, TerrainType terrain, Color color, int price, String description) {
        super(price, description);
        this.brand = brand;
        this.size = size;
        this.terrain = terrain;
        this.color = color;
    }

    public ShoeBrand getBrand() {
        return brand;
    }

    public void setBrand(ShoeBrand brand) {
        this.brand = brand;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public TerrainType getTerrain() {
        return terrain;
    }

    public void setTerrain(TerrainType terrain) {
        this.terrain = terrain;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
}
