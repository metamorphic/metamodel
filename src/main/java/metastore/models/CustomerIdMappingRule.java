package metastore.models;

import javax.persistence.*;

/**
 * Created by markmo on 14/04/15.
 */
@Entity
@Table(name = "customer_id_mapping_rules", schema = "meta")
public class CustomerIdMappingRule extends AuditedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id_mapping_rule_id")
    private Integer id;

    @Column(name = "customer_id_mapping_rule_name")
    private String name;

    @Column(length = 8000)
    private String filterExpression;

    @ManyToOne
    @JoinColumn(name = "customer_id_type_id_1")
    private CustomerIdType customerIdType1;

    @Column(name = "customer_id_1_expression", length = 8000)
    private String customerIdExpression1;

    @ManyToOne
    @JoinColumn(name = "customer_id_type_id_2")
    private CustomerIdType customerIdType2;

    @Column(name = "customer_id_2_expression", length = 8000)
    private String customerIdExpression2;

    @Column(name = "start_ts_expression", length = 8000)
    private String startTimeExpression;

    @Column(name = "start_ts_format")
    private String startTimeFormat;

    @Column(name = "start_ts_timezone")
    private String startTimezone;

    @Column(name = "end_ts_expression", length = 8000)
    private String endTimeExpression;

    @Column(name = "end_ts_format")
    private String endTimeFormat;

    @Column(name = "end_ts_timezone")
    private String endTimezone;

    private double confidenceLevel;

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

    public String getFilterExpression() {
        return filterExpression;
    }

    public void setFilterExpression(String filterExpression) {
        this.filterExpression = filterExpression;
    }

    public CustomerIdType getCustomerIdType1() {
        return customerIdType1;
    }

    public void setCustomerIdType1(CustomerIdType customerIdType1) {
        this.customerIdType1 = customerIdType1;
    }

    public String getCustomerIdExpression1() {
        return customerIdExpression1;
    }

    public void setCustomerIdExpression1(String customerIdExpression1) {
        this.customerIdExpression1 = customerIdExpression1;
    }

    public CustomerIdType getCustomerIdType2() {
        return customerIdType2;
    }

    public void setCustomerIdType2(CustomerIdType customerIdType2) {
        this.customerIdType2 = customerIdType2;
    }

    public String getCustomerIdExpression2() {
        return customerIdExpression2;
    }

    public void setCustomerIdExpression2(String customerIdExpression2) {
        this.customerIdExpression2 = customerIdExpression2;
    }

    public String getStartTimeExpression() {
        return startTimeExpression;
    }

    public void setStartTimeExpression(String startTimeExpression) {
        this.startTimeExpression = startTimeExpression;
    }

    public String getStartTimeFormat() {
        return startTimeFormat;
    }

    public void setStartTimeFormat(String startTimeFormat) {
        this.startTimeFormat = startTimeFormat;
    }

    public String getStartTimezone() {
        return startTimezone;
    }

    public void setStartTimezone(String startTimezone) {
        this.startTimezone = startTimezone;
    }

    public String getEndTimeExpression() {
        return endTimeExpression;
    }

    public void setEndTimeExpression(String endTimeExpression) {
        this.endTimeExpression = endTimeExpression;
    }

    public String getEndTimeFormat() {
        return endTimeFormat;
    }

    public void setEndTimeFormat(String endTimeFormat) {
        this.endTimeFormat = endTimeFormat;
    }

    public String getEndTimezone() {
        return endTimezone;
    }

    public void setEndTimezone(String endTimezone) {
        this.endTimezone = endTimezone;
    }

    public double getConfidenceLevel() {
        return confidenceLevel;
    }

    public void setConfidenceLevel(double confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }
}
