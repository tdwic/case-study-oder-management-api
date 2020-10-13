package com.bravo.system.service;

import com.bravo.system.entity.ProcumentStaffEntity;
import com.bravo.system.entity.SeniorManagerEntity;
import com.bravo.system.entity.SupplierEntity;
import com.bravo.system.model.ProcumentStaff;
import com.bravo.system.model.SeniorManager;
import com.bravo.system.model.Supplier;
import com.bravo.system.repository.ProcumentStaffRepository;
import com.bravo.system.repository.SeniorManagerRepository;
import com.bravo.system.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private SeniorManagerRepository seniorManagerRepository;

    @Autowired
    private ProcumentStaffRepository procumentStaffRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    //Post Methods
    public SeniorManagerEntity NewSeniorManager(SeniorManager seniorManager){

        String id = seniorManager.getId();
        String fName = seniorManager.getfName();
        String lName = seniorManager.getlName();
        String email = seniorManager.getEmail();
        String password = seniorManager.getPassword();
        String role = seniorManager.getRole();

        SeniorManagerEntity seniorManagerEntity = new SeniorManagerEntity(id,fName,lName,email,password,role);
        return seniorManagerRepository.save(seniorManagerEntity);

    }

    public ProcumentStaffEntity NewProcumentStafe(ProcumentStaff procumentStaff){

        String id = procumentStaff.getId();
        String fName = procumentStaff.getfName();
        String lName = procumentStaff.getlName();
        String email = procumentStaff.getEmail();
        String password = procumentStaff.getPassword();
        String role = procumentStaff.getRole();

        ProcumentStaffEntity procumentStaffEntity = new ProcumentStaffEntity(id,fName,lName,email,password,role);
        return procumentStaffRepository.save(procumentStaffEntity);
    }

    public SupplierEntity NewSupplier(Supplier supplier){

        String id = supplier.getId();
        String fName = supplier.getfName();
        String lName = supplier.getlName();
        String email = supplier.getEmail();
        String password = supplier.getPassword();
        String role = supplier.getRole();
        String company = supplier.getCompany();

        SupplierEntity supplierEntity = new SupplierEntity(id,fName,lName,email,password,role,company);

        return supplierRepository.save(supplierEntity);

    }
    //Post Methods

    //Get Methods
    public List<SeniorManagerEntity> GetAllSeniorManagers(){
        return seniorManagerRepository.findAll();
    }

    public List<ProcumentStaffEntity> GetAllProcumentStaff(){
        return procumentStaffRepository.findAll();
    }

    public List<SupplierEntity> GetAllSuppliers(){
        return supplierRepository.findAll();
    }
    //Get Methods

}
