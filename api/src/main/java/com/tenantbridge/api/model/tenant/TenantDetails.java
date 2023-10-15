package com.tenantbridge.api.model.tenant;

import com.tenantbridge.api.model.Address;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "TenantDetails")
public class TenantDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @DBRef
    private Tenant tenant;

    @DBRef
    private Address currentAddress;

    private LocalDate dateOfBirth;

    //private List<String> userUploadedDocuments;

}
