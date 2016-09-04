package metastore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by markmo on 26/07/2015.
 */
@Entity
@Table(name = "feature_families", schema = "meta")
public class FeatureFamily extends AuditedModel {

    @Id
    @SequenceGenerator(name = "feature_family_id_seq", sequenceName = "feature_families_feature_family_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feature_family_id_seq")
    @Column(name = "feature_family_id")
    private Integer id;

    @Column(name = "feature_family_name")
    private String name;

    private String description;

    private String wideTableName;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "feature_family_types", schema = "meta",
            joinColumns = @JoinColumn(name = "feature_family_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_type_id")
    )
    private List<FeatureType> featureTypes = new ArrayList<FeatureType>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWideTableName() {
        return wideTableName;
    }

    public void setWideTableName(String wideTableName) {
        this.wideTableName = wideTableName;
    }

    public List<FeatureType> getFeatureTypes() {
        return featureTypes;
    }

    public void setFeatureTypes(List<FeatureType> featureTypes) {
        this.featureTypes = featureTypes;
    }

    public String getFeatureTypesId() {
        if (featureTypes == null) {
            return null;
        }
        int n = featureTypes.size();
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) {
            ids[i] = featureTypes.get(i).getId().toString();
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
