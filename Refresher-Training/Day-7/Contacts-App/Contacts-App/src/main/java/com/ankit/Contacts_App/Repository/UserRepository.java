package com.ankit.Contacts_App.Repository;

import com.ankit.Contacts_App.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Contact,Long> {
}
