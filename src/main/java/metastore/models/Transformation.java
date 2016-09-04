package metastore.models;

import metastore.elasticsearch.Searchable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by markmo on 5/06/15.
 */
@Entity
@Table(name = "transformations")
public class Transformation extends AuditedModel implements Searchable {

    @Id
    @SequenceGenerator(name = "transformation_id_seq", sequenceName = "transformations_transformation_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transformation_id_seq")
    @Column(name = "transformation_id")
    private Long id;

    @Column(name = "transformation_name")
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "output_dataset_id")
    private Dataset outputDataset;

    @Column(length = 8000)
    private String routine;

    private String reference;
    private String language;
    private String leadCommitter;
    private String contactEmail;
    private String repo;
    private String commitHash;
    private int version;

    @Transient
    private boolean create;

    @Transient
    private String newDatasetName;

    @Transient
    private String createAs;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "transformed_sets", schema = "meta",
            joinColumns = @JoinColumn(name = "transformation_id"),
            inverseJoinColumns = @JoinColumn(name = "dataset_id")
    )
    private Set<Dataset> inputDatasets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Dataset getOutputDataset() {
        return outputDataset;
    }

    public void setOutputDataset(Dataset outputDataset) {
        this.outputDataset = outputDataset;
    }

    public String getRoutine() {
        return routine;
    }

    public void setRoutine(String routine) {
        this.routine = routine;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLeadCommitter() {
        return leadCommitter;
    }

    public void setLeadCommitter(String leadCommitter) {
        this.leadCommitter = leadCommitter;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getCommitHash() {
        return commitHash;
    }

    public void setCommitHash(String commitHash) {
        this.commitHash = commitHash;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Set<Dataset> getInputDatasets() {
        return inputDatasets;
    }

    public void setInputDatasets(Set<Dataset> inputDatasets) {
        this.inputDatasets = inputDatasets;
    }

    public String getInputDatasetsId() {
        if (inputDatasets == null) {
            return null;
        }
        int n = inputDatasets.size();
        List<Dataset> datasets = new ArrayList<Dataset>(inputDatasets);
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) {
            ids[i] = datasets.get(i).getId().toString();
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

    public String getInputDatasetsName() {
        if (inputDatasets == null) {
            return null;
        }
        int n = inputDatasets.size();
        List<Dataset> datasets = new ArrayList<Dataset>(inputDatasets);
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = datasets.get(i).getName();
        }
        if (n == 0) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (String name : names) {
                sb.append(name).append(',');
            }
            return sb.substring(0, sb.length() - 1);
        }
    }

    public void addInputDataset(Dataset dataset) {
        if (inputDatasets == null) {
            inputDatasets = new HashSet<Dataset>();
        }
        inputDatasets.add(dataset);
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public String getNewDatasetName() {
        return newDatasetName;
    }

    public void setNewDatasetName(String newDatasetName) {
        this.newDatasetName = newDatasetName;
    }

    public String getCreateAs() {
        return createAs;
    }

    public void setCreateAs(String createAs) {
        this.createAs = createAs;
    }
}
