package com.cauandev.controller;

import static java.lang.IO.println;

public class StudentViewController extends DefaultView1Controller{

    public StudentViewController() {
        super();
        setTitle("Aluno");
        setAvatar("/assets/images/student_image.png");
        setCreateButton("Matricular Aluno");
        setDeleteButton("Remover Matrícula");
        setSearchButton("Matrículas");
        setUpdateButton("Atualizar Matrícula");
    }

    @Override
    public void createAction() { println("Protego!"); }

    @Override
    public void deleteAction() { println("Protego Diabolica!"); }

    @Override
    public void updateAction() { println("Aresto Momentum");}

    @Override
    public void searchAction() { println("Expelliarmus!");}
}
