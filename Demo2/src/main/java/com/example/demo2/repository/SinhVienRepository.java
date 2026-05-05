package com.example.demo2.repository;

import com.example.demo2.entity .Table_SV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<Table_SV, String> {
}

