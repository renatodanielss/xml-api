package br.com.xml.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "selection_process")
@Data
@NoArgsConstructor
public class SelectionProcess implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "selection_process_id")
    private Integer selectionProcessId;

    @Column(name = "selection_process_name")
    @Size(max = 100)
    @NotNull
    private String selectionProcessName;

    @Column(name = "ux_use")
    private Boolean uxUse;

    @Column(name = "final_list_edited")
    private Boolean finalListEdited;

    @Column(name = "ats_customer_id")
    @NotNull
    private Integer atsCustomerId;

    @Column(name = "selection_process_locale_id")
    private Long selectionProcessLocaleId;

    @Column(name = "selection_process_status_id", nullable = false)
    @NotNull
    private Integer selectionProcessStatusId;

    @Column(name = "hiring_type_id", nullable = false)
    @NotNull
    private Integer hiringTypeId;

    @Column(name = "hiring_company_alt_name")
    @Size(max = 100)
    private String hiringCompanyAltName;

    @Column(name = "hiring_company_alt_description")
    @Size(max = 2000)
    private String hiringCompanyAltDescription;

    @Column(name = "featured")
    private Boolean featured;

    @Column(name = "show_inscription_period")
    private Boolean showInscriptionPeriod;

    @Column(name = "show_deficiency_registration")
    private Boolean showDeficiencyRegistration;

    @Temporal(TemporalType.DATE)
    @Column(name = "inscription_begin")
    @NotNull
    private Date inscriptionBegin;

    @Temporal(TemporalType.DATE)
    @Column(name = "inscription_end")
    @NotNull
    private Date inscriptionEnd;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "extended_inscription_end")
    private Date extendedInscriptionDate;

    @Column(name = "hiring_month")
    @Range(min = 0, max = 12)
    @NotNull
    private Integer hiringMonth;

    @Column(name = "hiring_year")
    @NotNull
    private Integer hiringYear;

    @Temporal(TemporalType.DATE)
    @Column(name = "selection_process_deadline", columnDefinition = "DATE")
    private Date selectionProcessDeadline;

    @Column(name = "confidential")
    private Boolean confidential;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_last_modified", columnDefinition = "DATETIME", insertable = false)
    private Date dateLastModified;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "authorization_date", columnDefinition = "DATETIME")
    private Date authorizationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "finished_date", columnDefinition = "DATETIME")
    private Date finishedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "excluded_date", columnDefinition = "DATETIME")
    private Date excludedDate;

    @Column(name = "external_id")
    private Integer externalId;

    public SelectionProcess(Integer selectionProcessId) {
        this.selectionProcessId = selectionProcessId;
    }

    @PrePersist
    void onPersist() {
        if (this.creationDate == null) {
            this.creationDate = new Date();
        }
        if (this.inscriptionBegin == null) {
            this.inscriptionBegin = new Date();
        }
        if (this.inscriptionEnd != null && this.hiringMonth == null) {
            this.hiringMonth = this.inscriptionEnd.getMonth();
        }
        if (this.inscriptionEnd != null && this.hiringYear == null) {
            this.hiringYear = this.inscriptionEnd.getYear();
        }
        if (this.uxUse == null) {
            this.uxUse = true;
        }
        if (this.showInscriptionPeriod == null) {
            this.showInscriptionPeriod = true;
        }
        if (this.showInscriptionPeriod == null) {
            this.showInscriptionPeriod = true;
        }
        if (this.showDeficiencyRegistration == null) {
            this.showDeficiencyRegistration = true;
        }
    }

    @PreUpdate
    void onUpdate() {
        this.dateLastModified = new Date();
    }

}
