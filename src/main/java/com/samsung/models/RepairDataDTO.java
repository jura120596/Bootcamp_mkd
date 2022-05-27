package com.samsung.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.samsung.entity.Address;
import com.samsung.entity.ObjectMkd;
import com.samsung.entity.RepairData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepairDataDTO {

	private Long id;
    private int substructure;
    private int facade;
    private int roof;
    private int elevator;
    private int energy;
    private int heating;
    private int watter;
    private int hotWatter;
    private int watterOut;
    private int other;
	private ObjectMkd object;

	public static RepairData fromDto(RepairDataDTO o) {

		if (o == null) return null;
        return RepairData.builder()
        		.substructure(o.substructure)
        		.facade(o.facade)
        		.elevator(o.roof)
        		.substructure(o.elevator)
        		.energy(o.energy)
        		.heating(o.heating)
        		.watter(o.watter)
        		.hotWatter(o.hotWatter)
        		.watterOut(o.watterOut)
        		.other(o.other)
        		.build();
    }

    public static RepairDataDTO toDto(RepairData o) {

		if (o == null) return null;
        return RepairDataDTO.builder()
        		.id(o.getId())
        		.substructure(o.getSubstructure())
        		.facade(o.getFacade())
        		.elevator(o.getRoof())
        		.substructure(o.getElevator())
        		.energy(o.getEnergy())
        		.heating(o.getHeating())
        		.watter(o.getWatter())
        		.hotWatter(o.getHotWatter())
        		.watterOut(o.getWatterOut())
        		.other(o.getOther())
        		.build();
    }
}
