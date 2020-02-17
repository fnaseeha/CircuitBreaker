package lk.naseeha.AllocationService.Repository;

import lk.naseeha.AllocationService.Entity.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation,Integer> {
}
