package entity;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic(optional = false)
    @NotNull
    private LocalDateTime timestamp;
    @Basic(optional = false)
    @NotNull
    private boolean paid;
    @Basic(optional = false)
    @NotNull
    private boolean sent;
    @Basic(optional = false)
    @NotNull
    private boolean delivered;
    @ManyToOne
    @JoinColumn(name="buyer_id")
    private Person buyer;
    @ManyToMany
    private List<Article> articles;

    public Purchase() {
        articles = new LinkedList<>();
    }

    public Purchase(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        articles = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public Person getBuyer() {
        return buyer;
    }

    public void setBuyer(Person buyer) {
        this.buyer = buyer;
    }

    public List<Article> getArticles() {
        return articles;
    }
    
   public void addArticle(Article a){
       articles.add(a);
   }
   
   public void removeArticle(Article a){
       articles.remove(a);
   }
    
}
