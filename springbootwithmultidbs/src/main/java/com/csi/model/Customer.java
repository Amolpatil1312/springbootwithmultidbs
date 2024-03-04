package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;

    @Size(min = 2, message = "Name should be atleast 2 character")
    private String custName;

    private String custAddress;

    private double custAccountBalance;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date custDOB;

    @Email(message = "EMAIL ID Must be Valid")
    private String custEmailId;

    @Size(min = 4, message = "Password should be atleast 4 character")
    private String custPassword;
}
