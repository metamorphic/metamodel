package metastore.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by markmo on 1/08/2015.
 */
@Entity
@Table(name = "analytical_models", schema = "meta")
public class AnalyticalModel extends AuditedModel {

    @Id
    @SequenceGenerator(name = "model_id_seq", sequenceName = "analytical_models_model_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_id_seq")
    @Column(name = "model_id")
    private Integer id;

    @Column(name = "model_name")
    private String name;
    private String version;
    private String committer;
    private String contactPerson;

    @Column(length = 8000)
    private String description;

    private boolean ensemble;

    @ManyToMany
    @JoinTable(
            name = "model_packages_link", schema = "meta",
            joinColumns = @JoinColumn(name = "model_id"),
            inverseJoinColumns = @JoinColumn(name = "package_id")
    )
    private List<AnalyticalModelPackage> packages;

    @ManyToMany
    @JoinTable(
            name = "related_analytical_models", schema = "meta",
            joinColumns = @JoinColumn(name = "model_id_1"),
            inverseJoinColumns = @JoinColumn(name = "model_id_2")
    )
    private List<AnalyticalModel> relatedModels;

    // TODO
    // inputFeatures

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

    public String getCommitter() {
        return committer;
    }

    public void setCommitter(String committer) {
        this.committer = committer;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnsemble() {
        return ensemble;
    }

    public void setEnsemble(boolean ensemble) {
        this.ensemble = ensemble;
    }

    public List<AnalyticalModelPackage> getPackages() {
        return packages;
    }

    public void setPackages(List<AnalyticalModelPackage> packages) {
        this.packages = packages;
    }

    public String getPackagesId() {
        if (packages == null) {
            return null;
        }
        int n = packages.size();
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) {
            ids[i] = packages.get(i).getId().toString();
        }
        if (n == 0) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (String id : ids) {
                sb.append(id).append(',');
            }
            return sb.substring(0, sb.length() - 1);
        }
    }

    public List<AnalyticalModel> getRelatedModels() {
        return relatedModels;
    }

    public void setRelatedModels(List<AnalyticalModel> relatedModels) {
        this.relatedModels = relatedModels;
    }

    public String getRelatedModelsId() {
        if (relatedModels == null) {
            return null;
        }
        int n = relatedModels.size();
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) {
            ids[i] = relatedModels.get(i).getId().toString();
        }
        if (n == 0) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (String id : ids) {
                sb.append(id).append(',');
            }
            return sb.substring(0, sb.length() - 1);
        }
    }
}
