/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.Springbootbackend.service.impl;

import java.util.List;
import net.codejava.Springbootbackend.exception.ResourceNotFoundException;
import net.codejava.Springbootbackend.model.Contact;
import net.codejava.Springbootbackend.repository.ContactRepository;
import net.codejava.Springbootbackend.service.ContactService;
import org.springframework.stereotype.Service;

/**
 *
 * @author BOSS
 */
@Service
public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;
    
    public ContactServiceImpl(ContactRepository contactRepository){
        super();
        this.contactRepository = contactRepository;
    }
    
    @Override
    public Contact saveContact(Contact contact){
        return contactRepository.save(contact);
    }
    
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }
    
    @Override
    public Contact getContactById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
	return contactRepository.findById(id).orElseThrow(() -> 
            new ResourceNotFoundException("Contact", "Id", id));
    }
    
    @Override
    public Contact updateContact(Contact contact, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
	Contact existingContact = contactRepository.findById(id).orElseThrow(
		() -> new ResourceNotFoundException("Contact", "Id", id)); 
		
	existingContact.setFirstName(contact.getFirstName());
	existingContact.setLastName(contact.getLastName());
	existingContact.setEmail(contact.getEmail());
		// save existing employee to DB
	contactRepository.save(existingContact);
	return existingContact;
    }
    
    @Override
    public void deleteContact(long id) {
		
		// check whether a employee exist in a DB or not
        contactRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Contact", "Id", id));
	contactRepository.deleteById(id);
}
}
