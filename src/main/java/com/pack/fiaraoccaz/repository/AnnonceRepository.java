package com.pack.fiaraoccaz.repository;

import com.pack.fiaraoccaz.entity.Annonce;
import com.pack.fiaraoccaz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long>, JpaSpecificationExecutor<Annonce> {

    List<Annonce> findByUser(User user);
}
