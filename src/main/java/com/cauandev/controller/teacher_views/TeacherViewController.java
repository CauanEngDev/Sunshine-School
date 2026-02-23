package com.cauandev.controller.teacher_views;

import com.cauandev.controller.GeneralController;
import com.cauandev.controller.default_views.DefaultView1Controller;
import com.cauandev.enums.ViewNames;

import static java.lang.IO.println;

public class TeacherViewController extends DefaultView1Controller {

    public TeacherViewController() {
        super();
        setTitle("Professor");
        setAvatar("/assets/images/teacher_image.png");
        setCreateButton("Inscrever Professor");
        setDeleteButton("Deletar Professor");
        setSearchButton("Professores");
        setUpdateButton("Atualizar Currículo");
    }

    @Override
    public void createAction() { GeneralController.switchView(ViewNames.TEACHERCREATION); }

    @Override
    public void deleteAction() { println("Wingadium Leviosa!"); }

    @Override
    public void updateAction() { println("Espectro Patronum"); }

    @Override
    public void searchAction() { println("Accio!"); }
}
