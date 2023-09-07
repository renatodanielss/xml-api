package br.com.xml.dto;

import br.com.xml.utils.JsonDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SelectionProcessFormDTO {
    private Integer selectionProcessId;

    private Integer atsCustomerId;

    private Boolean uxUse;

    private Long selectionProcessLocaleId;

    private Long betthaSelectionProcessSettingId;

    private Integer companyCountryId;

    private Integer SelectionProcessStatusId;

    private Integer hiringTypeId;

    @Size(max = 100)
    private String selectionProcessName;

    private String hiringCompanyAltName;

    private String hiringCompanyAltDescription;

    private Long altLogoRepositoryFileId;

    private Boolean featured;

    private Boolean showInscriptionPeriod;

    private Boolean showDeficiencyRegistration;

    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private Date inscriptionBegin;

    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private Date inscriptionEnd;

    private Integer hiringMonth;

    private Integer hiringYear;

    private Date selectionProcessDeadline;

    private Integer createdByUserId;

    private Date authorizationDate;

    private Integer finishedByUserId;

    private Date finishedDate;

    private Integer excludedByUserId;

    private Date excludedDate;

    private Integer externalId;

    private Boolean confidential;

    private Boolean finalListEdited;

    private Integer cityId;

    private Integer professionalAreaId;

    private Integer educationalLevelId;

    private Integer englishFluencyId;

    private String activitiesDescription;

    private String differentialDescription;

    private BigDecimal salary;

    private Boolean driverLicenseRequired;

    private Boolean salaryToBeDefined;

    private Boolean specialNeeds;

    private Boolean travelingRequired;

    private String workShift;

    @Deprecated
    private Integer positions;

    private List<Integer> benefitsIds;

    private Integer betthaContractTypeId; 
    
    private Integer betthaHiringModelId;

    private Boolean pendingNewIntegration;
}
