package com.forcenhopital.payload;

import com.forcenhopital.dto.ConsultationDto;
import com.forcenhopital.dto.HospitalisationDto;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DossierPatientLoad {
    private List<HospitalisationDto> listHospi = new ArrayList<>();
    private List<ConsultationDto> listCons = new ArrayList<>();
}
