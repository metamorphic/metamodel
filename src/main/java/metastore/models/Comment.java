package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 17/09/2015.
 */
@Entity
@Table(name = "comments", schema = "meta")
public class Comment extends AuditedModel {

    @Id
    @SequenceGenerator(name = "comment_id_seq", sequenceName = "comments_comment_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_seq")
    @Column(name = "comment_id")
    private Integer id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "column_id")
    private DataColumn column;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public DataColumn getColumn() {
        return column;
    }

    public void setColumn(DataColumn column) {
        this.column = column;
    }
}
