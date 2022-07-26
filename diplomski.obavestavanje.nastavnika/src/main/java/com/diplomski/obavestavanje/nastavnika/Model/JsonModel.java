package com.diplomski.obavestavanje.nastavnika.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@JsonIgnoreProperties
public class JsonModel {
    private Long thesisId;
    private String thesisType;
    private String thesisTitle;
    private Date thesisRegistrationDate;
    private Date thesisDateOfSubmission ;
    private Date thesisDateOfDefense;
    private Integer thesisGrade;
    private List<ThesisProfessorRole> thesisCommission;
    private Student student;
}
