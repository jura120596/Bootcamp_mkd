package com.samsung.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.samsung.entity.Address;
import com.samsung.entity.Communication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunicationDTO {

    private Long id;
    private String data;

	public static Communication fromDto(CommunicationDTO o) {

		if (o == null) return null;
        return Communication.builder()
        		.data(o.getData())
        		.build();
    }

    public static CommunicationDTO toDto(Communication o) {

		if (o == null) return null;
        return CommunicationDTO.builder()
        		.id(o.getId())
        		.data(o.getData())
        		.build();
    }
}
