/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.Springbootbackend.repository;

import net.codejava.Springbootbackend.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BOSS
 */
public interface ContactRepository extends JpaRepository<Contact, Long>{
    
}
