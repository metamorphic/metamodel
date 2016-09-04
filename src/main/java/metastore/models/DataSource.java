package metastore.models;

import metastore.elasticsearch.Searchable;

import javax.persistence.*;

/**
 * Created by markmo on 28/03/2015.
 */
@Entity
@Table(name = "data_sources", schema = "meta")
@DiscriminatorColumn(name = "data_source_type", discriminatorType = DiscriminatorType.STRING, length = 10)
public abstract class DataSource extends AuditedModel implements Searchable {

    @Id
    @SequenceGenerator(name = "data_source_id_seq", sequenceName = "data_sources_data_source_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_source_id_seq")
    @Column(name = "data_source_id")
    private Long id;

    @Column(name = "data_source_name")
    private String name;

    private String sourcingMethod;
    private String hostname;
    private String ipaddr;
    private int port;
    private String firewallStatus;
    private String description;
    private AnalysisStatus analysisStatus;

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

    public String getSourcingMethod() {
        return sourcingMethod;
    }

    public void setSourcingMethod(String sourcingMethod) {
        this.sourcingMethod = sourcingMethod;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFirewallStatus() {
        return firewallStatus;
    }

    public void setFirewallStatus(String firewallStatus) {
        this.firewallStatus = firewallStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AnalysisStatus getAnalysisStatus() {
        return analysisStatus;
    }

    public void setAnalysisStatus(AnalysisStatus analysisStatus) {
        this.analysisStatus = analysisStatus;
    }
}
