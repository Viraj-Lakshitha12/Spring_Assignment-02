package lk.ijse.gdse.repo;


import lk.ijse.gdse.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project,String> {
}
