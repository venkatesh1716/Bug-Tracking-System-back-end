package com.tmt.bugreviewsystem.brs.repo;

import com.tmt.bugreviewsystem.brs.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE project SET status='Deleted' WHERE id=:id",nativeQuery = true)
    void  deleteBookByBookID(int id);
}
