package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 28/03/2015.
 */
@Entity
@Table(name="value_types", schema = "meta")
public class ValueType extends AuditedModel {

    @Id
    @SequenceGenerator(name = "value_type_id_seq", sequenceName = "value_types_value_type_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "value_type_id_seq")
    @Column(name="value_type_id")
    private Integer id;

    @Column(name="value_type_name")
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
