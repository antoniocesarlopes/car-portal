package br.com.carstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carstore.data.entity.OwnerPost;

@Repository
public interface OwnerPostRepository extends JpaRepository<OwnerPost, Long> {
}

