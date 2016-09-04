package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 26/07/2015.
 */
@Entity
@Table(name="tags", schema = "meta")
public class Tag {

    @Id
    @SequenceGenerator(name = "tag_id_seq", sequenceName = "tags_tag_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_id_seq")
    @Column(name="tag_id")
    private Integer id;

    @Column(name="tag_name")
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
