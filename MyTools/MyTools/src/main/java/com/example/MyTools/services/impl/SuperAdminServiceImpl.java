package com.example.MyTools.services.impl;

import com.example.MyTools.model.SuperAdmin;
import com.example.MyTools.repository.SuperAdminRepository;
import com.example.MyTools.services.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {
    @Autowired
    SuperAdminRepository superAdminRepository;
    @Override
    public SuperAdmin ajouterSuperAdmin(SuperAdmin superAdmin) {
        return this.superAdminRepository.save(superAdmin);
    }

    @Override
    public List<SuperAdmin> listerpersonne() {
        return this.superAdminRepository.findAll();
    }

    @Override
    public String supprimerSuperAdmin(Integer id) {
        this.superAdminRepository.deleteById(id);
        return "Supprimer avec success";
    }

    @Override
    public void modifierSuperAdmin(SuperAdmin superAdmin, Integer id) {
        SuperAdmin superAdminExistant = this.superAdminRepository.findById(id).orElseThrow();
        superAdminExistant.setNom(superAdmin.getNom());
        superAdminExistant.setContact(superAdmin.getContact());
        superAdminExistant.setGenre(superAdmin.getGenre());
        superAdminExistant.setEmail(superAdmin.getEmail());
        superAdminExistant.setGenre(superAdmin.getGenre());
        superAdminExistant.setPassword(superAdmin.getPassword());
    }

    @Override
    public SuperAdmin afficherSuperAdminById(Integer id) {
        return this.superAdminRepository.findById(id).get();
    }

    @Override
    public SuperAdmin connexion(String email, String password) {
        Optional<SuperAdmin> superAdmin = superAdminRepository.findByEmailAndPassword(email,password);
        if (superAdmin.isEmpty()){
            return null;
        }
        return superAdmin.get();
    }
}
