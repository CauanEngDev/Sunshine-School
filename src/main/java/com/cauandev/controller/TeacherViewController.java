package com.cauandev.controller;

import static java.lang.IO.println;

public class TeacherViewController extends DefaultView1Controller {

    public TeacherViewController() {
        super();
        setTitle("Professor");
        setAvatar("/assets/images/student_image.png");
        setCreateButton("Inscrever Professor");
        setDeleteButton("Deletar Professor");
        setSearchButton("Professores");
        setUpdateButton("Atualizar Currículo");
    }

    @Override
    public void createAction() { println("Sectusempra!"); }

    @Override
    public void deleteAction() { println("Wingadium Leviosa!"); }

    @Override
    public void updateAction() { println("Espectro Patronum"); }

    @Override
    public void searchAction() { println("Accio!"); }
}
