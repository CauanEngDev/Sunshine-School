package com.cauandev.controller;

public class StudentViewController extends DefaultView1Controller{
    public StudentViewController() {
        super("/view/DefaultOptionsView.fxml");
        setTitle("Aluno");
        setAvatar("/assets/images/Emoji_Aluno.png");
        setCreateButton("Matricular Aluno");
        setDeleteButton("Remover Matrícula");
        setSearchButton("Matrículas");
        setUpdateButton("Atualizar Matrícula");
    }
}
