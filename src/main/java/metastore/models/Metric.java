package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 5/07/2015.
 */
@Entity
@Table(name = "metrics", schema = "meta")
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "metric_id")
    private Integer id;

    @Column(name = "metric_name")
    private String name;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
