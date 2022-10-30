package com.ibik.academic.academicservices.programs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class ProgramsServices {
    @Autowired
    private ProgramsRepo programsRepo;

    public Programs save(Programs programs) {
        return programsRepo.save(programs);
    }

    public Programs update(Programs programs) {
        Programs result = findOne(programs.getId());

        result.setName(programs.getName());
        result.setDescription(programs.getDescription());
        result.setIs_active(programs.isIs_active());

        return result;
    }

    public Programs findOne(int id) {
        return programsRepo.findById(id).get();
    }

    public Iterable<Programs> findAll(){
        return programsRepo.findAll();
    }

    public void removeOne(int id){
        programsRepo.deleteById(id);
    }
}
