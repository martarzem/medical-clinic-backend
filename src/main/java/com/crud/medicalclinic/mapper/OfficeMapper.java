package com.crud.medicalclinic.mapper;

import com.crud.medicalclinic.domain.Office;
import com.crud.medicalclinic.domain.OfficeDto;
import org.springframework.stereotype.Component;

@Component
public class OfficeMapper {
    public Office mapToOffice(final OfficeDto officeDto) {
        return new Office(
                officeDto.getId(),
                officeDto.getNumber(),
                officeDto.getDescription()
        );
    }

    public OfficeDto mapToOfficeDto(final Office office) {
        return new OfficeDto(
                office.getId(),
                office.getNumber(),
                office.getDescription()
        );
    }
}
