package com.cauandev.controller.teacher_views;

import com.cauandev.controller.default_views.PersonInfoDefaultView;

import static java.lang.IO.println;

public class TeacherCreateView extends PersonInfoDefaultView {

    public TeacherCreateView() {
        super();
        setAvatar("/assets/images/happy_teacher.png");
        setSpecificLabel("Telefone >");
    }

    @Override
    public void confirmAction() {
        println("Lumos!");
    }
}
