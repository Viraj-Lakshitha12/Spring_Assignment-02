package lk.ijse.gdse.service;


import lk.ijse.gdse.dto.TechLeadDTO;

import java.util.List;

public interface TechLeadService {
    void saveTechLead(TechLeadDTO dto);
    void deleteTechLead(String id);
    void updateTechLead(TechLeadDTO dto);
    TechLeadDTO searchTechLead(String id);
    List<TechLeadDTO> getAllTechLead();
}
