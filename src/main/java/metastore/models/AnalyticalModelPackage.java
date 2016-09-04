package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 1/08/2015.
 */
@Entity
@Table(name = "analytical_model_packages", schema = "meta")
public class AnalyticalModelPackage extends AuditedModel {

    @Id
    @SequenceGenerator(name = "package_id_seq", sequenceName = "analytical_model_packages_package_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "package_id_seq")
    @Column(name = "package_id")
    private Integer id;

    @Column(name = "package_name")
    private String name;

    private String version;

    @Column(length = 8000)
    private String description;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
