package com.tenantbridge.api.model;

import com.tenantbridge.api.model.property.Property;
import com.tenantbridge.api.model.user.User;
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
@Document(collection = "Landlords")
public class Landlord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @DBRef
    private User user;

    @DBRef
    private List<Property> ownedProperties;

    @DBRef
    private Address address;
}
