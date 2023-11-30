package com.tenantbridge.api.model;

import com.tenantbridge.api.model.property.PropertyDetails;
import com.tenantbridge.api.model.tenant.TenantDetails;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String flatNumber;

    @NotBlank
    private String addressLine1;

    private String addressLine2;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    @NotBlank
    private String postcode;

    @DBRef
    private TenantDetails tenantDetails;

    @DBRef
    private PropertyDetails propertyDetails;

    @DBRef
    private Landlord landlord;
}
