package com.cauandev.service;

import com.cauandev.database.SunshineSchoolData;
import com.cauandev.enums.Qualifications;
import com.cauandev.model.Teacher;
import com.cauandev.util.Validations;

import java.time.LocalDate;

public class TeacherService extends PersonService{

    public TeacherService() {}

    public void register(String name, LocalDate dateOfBirth, Qualifications qualification,String phoneNumber,
                         String street, String city, String state, String cep, String neighborhood) {

        super.basicInfoValidation(SunshineSchoolData.TEACHERS, name.strip(), dateOfBirth, street.strip(),
                                  city.strip(), state.strip(), cep.strip(), neighborhood.strip());
        Validations.textValidation(qualification.toString(), "qualificação");
        Validations.phoneValidation(phoneNumber);

        Teacher newTeacher = new Teacher(newId, name.strip(), dateOfBirth, qualification, address, phoneNumber.strip());
        SunshineSchoolData.TEACHERS.put(newId, newTeacher);
    }

    public void update(String name)
    public void deleteTeacher() {}
}
