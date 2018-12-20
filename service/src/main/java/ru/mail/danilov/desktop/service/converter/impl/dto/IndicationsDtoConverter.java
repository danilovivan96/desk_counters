package ru.mail.danilov.desktop.service.converter.impl.dto;

import ru.mail.danilov.desktop.dao.models.Indications;
import ru.mail.danilov.desktop.service.converter.ConverterDto;
import ru.mail.danilov.desktop.service.dto.IndicationsDto;

import java.util.ArrayList;
import java.util.List;

public class IndicationsDtoConverter implements ConverterDto<Indications, IndicationsDto> {

    @Override
    public IndicationsDto toDto(Indications indications) {
        IndicationsDto indicationsDto = new IndicationsDto();
        indicationsDto.setDate(indications.getDate());
        indicationsDto.setGas(indications.getGas());
        indicationsDto.setLight(indications.getLight());
        indicationsDto.setWater(indications.getWater());
        return indicationsDto;
    }

    @Override
    public List<IndicationsDto> toDtoList(List<Indications> list) {
        List<IndicationsDto> dtoList = new ArrayList<>();
        for (Indications indications : list) {
            IndicationsDto indicationsDto = new IndicationsDto();
            indicationsDto.setDate(indications.getDate());
            indicationsDto.setGas(indications.getGas());
            indicationsDto.setLight(indications.getLight());
            indicationsDto.setWater(indications.getWater());
            dtoList.add(indicationsDto);
        }
        return dtoList;
    }
}
