package com.cauandev.database;

import com.cauandev.model.Guardian;
import com.cauandev.model.Student;
import com.cauandev.model.Teacher;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SunshineSchoolData {
    public static Map<UUID, Student> STUDENTS = new HashMap<>();
    public static Map<UUID, Teacher> TEACHERS = new HashMap<>();
    public static Map<UUID, Guardian> GUARDIAN = new HashMap<>();
    public static Map<UUID, Class> CLASSES = new HashMap<>();
}
