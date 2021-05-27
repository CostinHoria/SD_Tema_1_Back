package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PrescripedDrugDTO;
import ro.tuc.ds2020.dtos.PrescripedDrugDetailsDTO;
import ro.tuc.ds2020.entities.PrescripedDrug;

public class PrescriptedDrugBuilder {

    public PrescriptedDrugBuilder() {
    }

    public static PrescripedDrugDTO toPrescritpedDrugDTO(PrescripedDrug prescripedDrug){
        return new PrescripedDrugDTO(prescripedDrug.getId(),prescripedDrug.getName_drug(), prescripedDrug.getStart_date(), prescripedDrug.getEnd_date(),prescripedDrug.getAdministration());
    }

    public static PrescripedDrugDetailsDTO toPrescriptedDrugDetailsDTO(PrescripedDrug prescripedDrug){
        return new PrescripedDrugDetailsDTO(prescripedDrug.getId(),
                prescripedDrug.getName_drug(),
                prescripedDrug.getStart_date(),
                prescripedDrug.getEnd_date(),
                prescripedDrug.getAdministration());
    }

    public static PrescripedDrug toEntity(PrescripedDrugDetailsDTO prescripedDrugDetailsDTO){
        return new PrescripedDrug(prescripedDrugDetailsDTO.getId(),
                prescripedDrugDetailsDTO.getName_drug(),
                prescripedDrugDetailsDTO.getStart_date(),
                prescripedDrugDetailsDTO.getEnd_date(),
                prescripedDrugDetailsDTO.getAdministration());
    }

    public static void updateEntity(PrescripedDrugDetailsDTO prescripedDrugDetailsDTO, PrescripedDrug prescripedDrug){
        if(prescripedDrugDetailsDTO!=null && prescripedDrug!=null) {
            prescripedDrug.setId(prescripedDrugDetailsDTO.getId());
            prescripedDrug.setName_drug(prescripedDrugDetailsDTO.getName_drug());
            prescripedDrug.setStart_date(prescripedDrugDetailsDTO.getStart_date());
            prescripedDrug.setEnd_date(prescripedDrugDetailsDTO.getEnd_date());
            prescripedDrug.setAdministration(prescripedDrugDetailsDTO.getAdministration());
        }
    }
}
