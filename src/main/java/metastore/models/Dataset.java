package metastore.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import metastore.elasticsearch.Searchable;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by markmo on 28/03/2015.
 */
@Entity
@Table(name = "datasets", schema = "meta")
@DiscriminatorColumn(name = "dataset_type", discriminatorType = DiscriminatorType.STRING, length = 10)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public abstract class Dataset extends AuditedModel implements Searchable {

    @Id
    @SequenceGenerator(name = "dataset_id_seq", sequenceName = "datasets_dataset_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dataset_id_seq")
    @Column(name = "dataset_id")
    private Long id;

    @Column(name = "dataset_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "security_classification_id")
    private SecurityClassification securityClassification;

    private String namespace;
    private String description;
    private String comments;
    private String contactPerson;
    private boolean customerData;

    @Enumerated(EnumType.STRING)
    private TimeUnit availableHistoryUnitOfTime;

    private int availableHistoryUnits;
    private boolean batch;

    @Enumerated(EnumType.STRING)
    private TimeUnit refreshFrequencyUnitOfTime;

    private int refreshFrequencyUnits;
    private Time timeOfDayDataAvailable;

    @Enumerated(EnumType.STRING)
    private TimeUnit dataAvailableUnitOfTime;

    private String dataAvailableDaysOfWeek;

    @Enumerated(EnumType.STRING)
    private TimeUnit dataLatencyUnitOfTime;

    private int dataLatencyUnits;

    @ManyToMany
    @JoinTable(
            name = "event_types_datasets", schema = "meta",
            joinColumns = @JoinColumn(name = "dataset_id"),
            inverseJoinColumns = @JoinColumn(name = "event_type_id")
    )
    private List<EventType> eventTypes = new ArrayList<EventType>();

//    @ManyToMany
//    @JoinTable(
//            name = "id_mapping_rules_datasets", schema = "meta",
//            joinColumns = @JoinColumn(name = "dataset_id"),
//            inverseJoinColumns = @JoinColumn(name = "customer_id_mapping_rule_id")
//    )
    @Transient
    private List<CustomerIdMappingRule> customerIdMappingRules = new ArrayList<CustomerIdMappingRule>();

    private AnalysisStatus analysisStatus;


    // custom attributes
    private String architectureDomain;
    private boolean financialBankingData;
    private boolean idAndServiceHistory;
    private boolean creditCardData;
    private boolean financialReportingData;
    private boolean privacyData;
    private boolean regulatoryData;
    private boolean nbnConfidentialData;
    private boolean nbnCompliant;
    private String ssuReady;
    private String ssuRemediationMethod;
    private int historyDataSizeGb;
    private int refreshDataSizeGb;


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

    public abstract String getType();

    public abstract DataSource getDataSource();

    public SecurityClassification getSecurityClassification() {
        return securityClassification;
    }

    public void setSecurityClassification(SecurityClassification securityClassification) {
        this.securityClassification = securityClassification;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public boolean isCustomerData() {
        return customerData;
    }

    public void setCustomerData(boolean customerData) {
        this.customerData = customerData;
    }

    public TimeUnit getAvailableHistoryUnitOfTime() {
        return availableHistoryUnitOfTime;
    }

    public void setAvailableHistoryUnitOfTime(TimeUnit availableHistoryUnitOfTime) {
        this.availableHistoryUnitOfTime = availableHistoryUnitOfTime;
    }

    public int getAvailableHistoryUnits() {
        return availableHistoryUnits;
    }

    public void setAvailableHistoryUnits(int availableHistoryUnits) {
        this.availableHistoryUnits = availableHistoryUnits;
    }

    public boolean isBatch() {
        return batch;
    }

    public void setBatch(boolean batch) {
        this.batch = batch;
    }

    public TimeUnit getRefreshFrequencyUnitOfTime() {
        return refreshFrequencyUnitOfTime;
    }

    public void setRefreshFrequencyUnitOfTime(TimeUnit refreshFrequencyUnitOfTime) {
        this.refreshFrequencyUnitOfTime = refreshFrequencyUnitOfTime;
    }

    public int getRefreshFrequencyUnits() {
        return refreshFrequencyUnits;
    }

    public void setRefreshFrequencyUnits(int refreshFrequencyUnits) {
        this.refreshFrequencyUnits = refreshFrequencyUnits;
    }

    public Time getTimeOfDayDataAvailable() {
        return timeOfDayDataAvailable;
    }

    public void setTimeOfDayDataAvailable(Time timeOfDayDataAvailable) {
        this.timeOfDayDataAvailable = timeOfDayDataAvailable;
    }

    public TimeUnit getDataAvailableUnitOfTime() {
        return dataAvailableUnitOfTime;
    }

    public void setDataAvailableUnitOfTime(TimeUnit dataAvailableUnitOfTime) {
        this.dataAvailableUnitOfTime = dataAvailableUnitOfTime;
    }

    public String getDataAvailableDaysOfWeek() {
        return dataAvailableDaysOfWeek;
    }

    public void setDataAvailableDaysOfWeek(String dataAvailableDaysOfWeek) {
        this.dataAvailableDaysOfWeek = dataAvailableDaysOfWeek;
    }

    public TimeUnit getDataLatencyUnitOfTime() {
        return dataLatencyUnitOfTime;
    }

    public void setDataLatencyUnitOfTime(TimeUnit dataLatencyUnitOfTime) {
        this.dataLatencyUnitOfTime = dataLatencyUnitOfTime;
    }

    public int getDataLatencyUnits() {
        return dataLatencyUnits;
    }

    public void setDataLatencyUnits(int dataLatencyUnits) {
        this.dataLatencyUnits = dataLatencyUnits;
    }

    public List<EventType> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(List<EventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    public void addEventType(EventType eventType) {
        if (eventTypes == null) {
            eventTypes = new ArrayList<EventType>();
        }
        eventTypes.add(eventType);
    }

    public String getEventTypesId() {
        if (eventTypes == null) {
            return null;
        }
        int n = eventTypes.size();
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) {
            ids[i] = eventTypes.get(i).getId().toString();
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

    public List<CustomerIdMappingRule> getCustomerIdMappingRules() {
        return customerIdMappingRules;
    }

    public void setCustomerIdMappingRules(List<CustomerIdMappingRule> customerIdMappingRules) {
        this.customerIdMappingRules = customerIdMappingRules;
    }

    public void addCustomerIdMappingRule(CustomerIdMappingRule customerIdMappingRule) {
        if (customerIdMappingRules == null) {
            customerIdMappingRules = new ArrayList<CustomerIdMappingRule>();
        }
        customerIdMappingRules.add(customerIdMappingRule);
    }

    public String getCustomerIdMappingRulesId() {
        if (customerIdMappingRules == null) {
            return null;
        }
        int n = customerIdMappingRules.size();
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) {
            ids[i] = customerIdMappingRules.get(i).getId().toString();
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

    public AnalysisStatus getAnalysisStatus() {
        return analysisStatus;
    }

    public void setAnalysisStatus(AnalysisStatus analysisStatus) {
        this.analysisStatus = analysisStatus;
    }

    // custom attributes
    public String getArchitectureDomain() {
        return architectureDomain;
    }

    public void setArchitectureDomain(String architectureDomain) {
        this.architectureDomain = architectureDomain;
    }

    public boolean isFinancialBankingData() {
        return financialBankingData;
    }

    public void setFinancialBankingData(boolean financialBankingData) {
        this.financialBankingData = financialBankingData;
    }

    public boolean isIdAndServiceHistory() {
        return idAndServiceHistory;
    }

    public void setIdAndServiceHistory(boolean idAndServiceHistory) {
        this.idAndServiceHistory = idAndServiceHistory;
    }

    public boolean isCreditCardData() {
        return creditCardData;
    }

    public void setCreditCardData(boolean creditCardData) {
        this.creditCardData = creditCardData;
    }

    public boolean isFinancialReportingData() {
        return financialReportingData;
    }

    public void setFinancialReportingData(boolean financialReportingData) {
        this.financialReportingData = financialReportingData;
    }

    public boolean isPrivacyData() {
        return privacyData;
    }

    public void setPrivacyData(boolean privacyData) {
        this.privacyData = privacyData;
    }

    public boolean isRegulatoryData() {
        return regulatoryData;
    }

    public void setRegulatoryData(boolean regulatoryData) {
        this.regulatoryData = regulatoryData;
    }

    public boolean isNbnConfidentialData() {
        return nbnConfidentialData;
    }

    public void setNbnConfidentialData(boolean nbnConfidentialData) {
        this.nbnConfidentialData = nbnConfidentialData;
    }

    public boolean isNbnCompliant() {
        return nbnCompliant;
    }

    public void setNbnCompliant(boolean nbnCompliant) {
        this.nbnCompliant = nbnCompliant;
    }

    public String getSsuReady() {
        return ssuReady;
    }

    public void setSsuReady(String ssuReady) {
        this.ssuReady = ssuReady;
    }

    public String getSsuRemediationMethod() {
        return ssuRemediationMethod;
    }

    public void setSsuRemediationMethod(String ssuRemediationMethod) {
        this.ssuRemediationMethod = ssuRemediationMethod;
    }

    public int getHistoryDataSizeGb() {
        return historyDataSizeGb;
    }

    public void setHistoryDataSizeGb(int historyDataSizeGb) {
        this.historyDataSizeGb = historyDataSizeGb;
    }

    public int getRefreshDataSizeGb() {
        return refreshDataSizeGb;
    }

    public void setRefreshDataSizeGb(int refreshDataSizeGb) {
        this.refreshDataSizeGb = refreshDataSizeGb;
    }
}
