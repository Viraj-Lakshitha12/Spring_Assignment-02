package lk.ijse.gdse.service;


import lk.ijse.gdse.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    void saveProject(ProjectDTO dto);
    void deleteProject(String id);
    void updateProject(ProjectDTO dto);
    ProjectDTO searchProject(String id);
    List<ProjectDTO> getAllProject();
}
