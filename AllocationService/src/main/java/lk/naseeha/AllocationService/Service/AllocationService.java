package lk.naseeha.AllocationService.Service;

import lk.naseeha.AllocationService.Entity.Allocation;

import java.util.Optional;

public interface AllocationService {

    public Optional<Allocation> getAllocation(int empId);

    public Allocation save(Allocation allocation);
}
