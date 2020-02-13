package offtop.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Report{
    
    @Id
    public int Id;
    public String createdAt;
    public String sessions;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getSessions() {
        return sessions;
    }

    public void setSessions(String sessions) {
        this.sessions = sessions;
    }
}