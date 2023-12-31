package lk.ijse.gdse.controller;
import lk.ijse.gdse.dto.ProjectDTO;
import lk.ijse.gdse.service.ProjectService;
import lk.ijse.gdse.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllProject(){
        return new ResponseUtil(200,"Success",projectService.getAllProject());
    }

    @PostMapping(path = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveProject(@ModelAttribute ProjectDTO projectDTO){

        if(projectDTO.getProjectId()==null || !projectDTO.getProjectId().matches("\"^(P)[-]?[0-9]{3}$\"")){
            throw new RuntimeException("Invalid id");
        }else if(projectDTO.getCusName()==null || !projectDTO.getCusName().matches("^[A-z ]{5,30}$")){
            throw new RuntimeException("Invalid name");
        }else if(projectDTO.getDate()==null){
            throw new RuntimeException("Invalid date");
        }else if(projectDTO.getPrice() == 0){
            throw new RuntimeException("Invalid price");
        }

        projectService.saveProject(projectDTO);
        return new ResponseUtil(200,"Success",projectDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateProject(@RequestBody ProjectDTO projectDTO){

        if(projectDTO.getCusName()==null || !projectDTO.getCusName().matches("^[A-z ]{5,30}$")){
            throw new RuntimeException("Invalid name");
        }else if(projectDTO.getDate()==null){
            throw new RuntimeException("Invalid date");
        }else if(projectDTO.getPrice() == 0){
            throw new RuntimeException("Invalid price");
        }

        projectService.updateProject(projectDTO);
        return new ResponseUtil(200,"Success",projectDTO);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteProject(@RequestParam String id){
        projectService.deleteProject(id);
        return new ResponseUtil(200,"Success",id);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchProject(@PathVariable String id){
        return new ResponseUtil(200,"Success",projectService.searchProject(id));
    }
}
