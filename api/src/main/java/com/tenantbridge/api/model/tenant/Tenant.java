package com.tenantbridge.api.model.tenant;

import com.tenantbridge.api.model.User;
import com.tenantbridge.api.model.property.PropertyApplication;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Document(collection = "Tenants")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @DBRef
    private User user;

    @DBRef
    private List<PropertyApplication> applications;

    @DBRef
    private TenantDetails tenantDetails;

}
