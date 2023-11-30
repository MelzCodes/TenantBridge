package com.tenantbridge.api.model.property;

import com.tenantbridge.api.model.Address;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "PropertyDetails")
public class PropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @DBRef
    private Property property;

    @DBRef
    private Address address;

    @NotNull
    private double rentPerMonth;

    @NotNull
    private int occupancyLimit;

    private int bathrooms;

    private String dimensions;

    private List<String> images;

    private Status status;

    private String description;
}
