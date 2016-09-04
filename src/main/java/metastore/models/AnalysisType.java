package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 5/07/2015.
 */
@Entity
@Table(name = "analysis_types", schema = "meta")
public class AnalysisType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "analysis_type_id")
    private Integer id;

    @Column(name = "analysis_type_name")
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
