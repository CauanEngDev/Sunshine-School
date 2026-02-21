package com.cauandev.service;

import com.cauandev.database.SunshineSchoolData;
import com.cauandev.enums.Qualifications;
import com.cauandev.model.Address;
import com.cauandev.model.Teacher;
import com.cauandev.util.Validations;

import java.time.LocalDate;

/**
 * Classe com regras de serviço dos professores.
 */
public class TeacherService extends PersonService{

    public TeacherService() {}

    /**
     * Método para criar e registrar professores.
     * @param name nome do professor.
     * @param dateOfBirth nascimento do professor.
     * @param qualification qualificação do professor.
     * @param phoneNumber telefone do professor.
     * @param street rua...
     * @param city cidade...
     * @param state estado...
     * @param cep codigo postal...
     * @param neighborhood bairro... que servem para criar o endereço do professor.
     */
    public void register(String name, LocalDate dateOfBirth, Qualifications qualification,String phoneNumber,
                         String street, String city, String state, String cep, String neighborhood) {

        // Validação base dos parâmetros
        super.basicInfoValidation(SunshineSchoolData.TEACHERS, name, dateOfBirth, street,
                                  city, state, cep, neighborhood);
        // Validação dos outros campos.
        Validations.textValidation(qualification.toString(), "qualificação");
        Validations.phoneValidation(phoneNumber);

        // Cria e salva o professor na lista estática.
        Teacher newTeacher = new Teacher(newId, name.strip(), dateOfBirth, qualification, address, phoneNumber.strip());
        SunshineSchoolData.TEACHERS.put(newId, newTeacher);
    }

    /**
     * Método para atualizar valores nos professores.
     * @param teacher Professor cujas informações serão alteradas.
     * @param name possível novo nome.
     * @param dateOfBirth possível data de aniversário.
     * @param qualification Possivel mudança da qualificação.
     * @param phoneNumber Possível mudança de telefone.
     * @param street rua...
     * @param city cidade...
     * @param state estado...
     * @param cep código postal...
     * @param neighborhood bairro... para possível criação de novo endereço.
     */
    public void update(Teacher teacher, String name, LocalDate dateOfBirth, Qualifications qualification,String phoneNumber,
                       String street, String city, String state, String cep, String neighborhood) {

        Address newAddress = new Address(street, city, state, cep, neighborhood);
        teacher.setAddress(newAddress);
        teacher.setDateOfBirth(dateOfBirth);
        teacher.setQualification(qualification);
        teacher.setPhoneNumber(phoneNumber);
        teacher.setName(name);
    }


}
