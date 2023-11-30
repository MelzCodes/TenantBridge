package com.tenantbridge.api.model.property;

import com.tenantbridge.api.model.tenant.Tenant;
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
@Document(collection = "Properties")
public class Tenancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @DBRef
    private List<Tenant> tenants;
}
