package lk.naseeha.AllocationService.Service;

import lk.naseeha.AllocationService.Entity.Allocation;
import lk.naseeha.AllocationService.Repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AllocationServiceImpl implements AllocationService{

    @Autowired
    AllocationRepository allocationRepository;

    @Override
    public Optional<Allocation> getAllocation(int empId) {
        return allocationRepository.findById(empId);
    }

    @Override
    public Allocation save(Allocation allocation) {
        return allocationRepository.save(allocation);
    }
}
