package br.com.carstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carstore.data.entity.CarPost;

@Repository
public interface CarPostRepository extends JpaRepository<CarPost, Long> {
}

