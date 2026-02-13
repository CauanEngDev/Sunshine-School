package com.cauandev.service;

import com.cauandev.database.SunshineSchoolData;
import com.cauandev.model.Qualifications;
import com.cauandev.model.Teacher;
import com.cauandev.util.Validations;

import java.time.LocalDate;

public class TeacherService extends PersonService{


    public void register(String name, LocalDate dateOfBirth, Qualifications qualification,String phoneNumber,
                         String street, String city, String state, String cep, String neighborhood) {

        super.basicInfoValidation(SunshineSchoolData.TEACHERS, name, dateOfBirth, street,
                                  city, state, cep, neighborhood);
        Validations.textValidation(qualification.toString(), "qualificação");
        Validations.phoneValidation(phoneNumber);

        Teacher newTeacher = new Teacher(newId, name, dateOfBirth, qualification, address, phoneNumber);
        SunshineSchoolData.TEACHERS.put(newId, newTeacher);
    }
}
