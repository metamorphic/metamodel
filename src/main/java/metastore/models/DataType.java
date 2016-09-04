package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 28/03/2015.
 */
@Entity
@Table(name="data_types", schema = "meta")
public class DataType extends AuditedModel {

    @Id
    @SequenceGenerator(name = "data_type_id_seq", sequenceName = "data_types_data_type_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_type_id_seq")
    @Column(name="data_type_id")
    private Integer id;

    @Column(name="data_type_name")
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
