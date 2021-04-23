package com.assignment.docs.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@AllArgsConstructor
@Data
public class Docs {

    private int id;

    private String docType;

    private int companyID;

    private LocalDate date;

    private int docId;

    private String sign;

    private int amount;


}
