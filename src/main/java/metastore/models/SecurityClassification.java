package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 28/03/2015.
 */
@Entity
@Table(name="security_classifications", schema = "meta")
public class SecurityClassification extends AuditedModel {

    @Id
    @SequenceGenerator(name = "security_classification_id_seq", sequenceName = "security_classifications_security_classification_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "security_classification_id_seq")
    @Column(name="security_classification_id")
    private Integer id;

    @Column(name="security_classification_name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
