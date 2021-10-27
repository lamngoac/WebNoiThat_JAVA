/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.Springbootbackend.controller;

import java.util.List;

import net.codejava.Springbootbackend.model.Contact;
import net.codejava.Springbootbackend.service.ContactService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BOSS
 */
@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private ContactService contactService;
    
    public ContactController(ContactService contactService){
        super();
        this.contactService = contactService;
    }
    
    @PostMapping()
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact){
        return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Contact> getAllEmployees(){
	return contactService.getAllContacts();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Contact> getEmployeeById(@PathVariable("id") long contactId){
	return new ResponseEntity<Contact>(contactService.getContactById(contactId), HttpStatus.OK);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable("id") long id
	,@RequestBody Contact contact){
	return new ResponseEntity<Contact>(contactService.updateContact(contact, id), HttpStatus.OK);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") long id){
		
		// delete employee from DB
	contactService.deleteContact(id);
		
	return new ResponseEntity<String>("Contact deleted successfully!.", HttpStatus.OK);
    }
}
