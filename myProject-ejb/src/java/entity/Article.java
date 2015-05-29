package entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Article implements Serializable {
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    @ManyToMany
    protected List<Purchase> purchases;
    @Basic(optional = false)
    @NotNull
    protected int price;
    @Size(min = 1, max = 255)
    protected String description;

    public Article(){
        purchases = new LinkedList<>();
    }
    
    public Article(int price, String description) {
        this.price = price;
        this.description = description;
        purchases = new LinkedList<>();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addPurchase(Purchase p){
        purchases.add(p);
    }
    
    public void removePurchase(Purchase p){
        purchases.remove(p);
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Article[ id=" + id + " ]" + this.getClass();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
