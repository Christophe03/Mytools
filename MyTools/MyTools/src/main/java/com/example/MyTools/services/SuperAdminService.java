package com.example.MyTools.services;

import com.example.MyTools.model.SuperAdmin;

import java.util.List;

public interface SuperAdminService {
    SuperAdmin ajouterSuperAdmin(SuperAdmin superAdmin);
    List<SuperAdmin> listerpersonne();
    String supprimerSuperAdmin(Integer id);
    void modifierSuperAdmin(SuperAdmin superAdmin, Integer id);
    SuperAdmin afficherSuperAdminById(Integer id);
    SuperAdmin connexion(String email, String password);
}
