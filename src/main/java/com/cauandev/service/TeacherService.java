package com.cauandev.service;

import com.cauandev.model.Address;
import com.cauandev.model.Qualifications;
import com.cauandev.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Set;

public class TeacherService {
    private static final Logger logger = LoggerFactory.getLogger(TeacherService.class);

    public void register(String name, LocalDate dateOfBirth, Address address, Qualifications qualification,
                                String phoneNumber) {
        if (name == null || dateOfBirth == null || address == null || qualification == null || phoneNumber == null) {
            logger.error("Erro ao criar o registro de teacher");
            return;
        }

        Teacher newTeacher = new Teacher(name)
    }


}
