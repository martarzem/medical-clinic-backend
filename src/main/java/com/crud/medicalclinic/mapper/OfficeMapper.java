package com.crud.medicalclinic.mapper;

import com.crud.medicalclinic.domain.Office;
import com.crud.medicalclinic.domain.OfficeDto;
import com.crud.medicalclinic.domain.Patient;
import com.crud.medicalclinic.domain.PatientDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<OfficeDto> mapToOfficeDtoList(final List<Office> officeList) {
        return officeList.stream()
                .map(o -> new OfficeDto(o.getId(), o.getNumber(), o.getDescription()))
                .collect(Collectors.toList());
    }
}
