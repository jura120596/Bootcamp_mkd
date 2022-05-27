package com.samsung.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.samsung.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;
    private String country;
    private String region;
    private String locality;
    private String street;
    private Date created_at;

	public static Address fromDto(AddressDTO o) {

		if (o == null) return null;
        return Address.builder()
        		.country(o.getCountry())
        		.region(o.getRegion())
        		.locality(o.getLocality())
        		.street(o.getStreet())
        		.created_at(o.created_at)
        		.build();
    }

    public static AddressDTO toDto(Address o) {

        return AddressDTO.builder()
        		.id(o.getId())
        		.country(o.getCountry())
        		.region(o.getRegion())
        		.locality(o.getLocality())
        		.street(o.getStreet())
        		.created_at(o.getCreated_at())
        		.build();
    }
}
