package lk.naseeha.AllocationService.Controller;

import lk.naseeha.AllocationService.Entity.Allocation;
import lk.naseeha.AllocationService.Service.AllocationService;
import lk.naseeha.AllocationService.Service.AllocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AllocationController {

    @Autowired
    AllocationService allocationServiceImpl;

    @RequestMapping(value = "/getAllocation/{id}" ,method= RequestMethod.GET)
    public Optional<Allocation> getAllocation(@PathVariable Integer id){
        return allocationServiceImpl.getAllocation(id);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Allocation saveAllocation(@RequestBody Allocation allocation){
        return allocationServiceImpl.save(allocation);
    }
}
