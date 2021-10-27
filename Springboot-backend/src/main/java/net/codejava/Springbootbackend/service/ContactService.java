/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.Springbootbackend.service;

import java.util.List;
import net.codejava.Springbootbackend.model.Contact;

/**
 *
 * @author BOSS
 */
public interface ContactService {
    Contact saveContact(Contact contact); 
    List<Contact> getAllContacts();
    Contact getContactById(long id);
    Contact updateContact(Contact contact, long id);
    void deleteContact(long id);
 
}
