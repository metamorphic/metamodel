package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 2/05/15.
 */
@Entity
@Table(name = "settings")
public class Setting extends AuditedModel {

    @Id
    private String name;

    private String description;

    @Column(length = 8000)
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
