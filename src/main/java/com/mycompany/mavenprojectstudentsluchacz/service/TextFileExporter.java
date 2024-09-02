/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectstudentsluchacz.service;

import com.mycompany.mavenprojectstudentsluchacz.domain.Student;
import com.mycompany.mavenprojectstudentsluchacz.domain.Sluchacz;
import com.mycompany.mavenprojectstudentsluchacz.domain.Osoba;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author 48514
 */
public class TextFileExporter implements IExporter {

    @Override
    public void export(List<Osoba> osoby, String nazwaPliku) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nazwaPliku))) {
            for (Osoba osoba : osoby) {
                if (osoba instanceof Student) {
                    Student student = (Student) osoba;
                    writer.println("Student: " + student.getImie() + " " + student.getNazwisko()
                            + " | Nr albumu: " + student.getNrAlbumy());
                } else if (osoba instanceof Sluchacz) {
                    Sluchacz sluchacz = (Sluchacz) osoba;
                    writer.println("Sluchacz: " + sluchacz.getImie() + "  " + sluchacz.getNazwisko() + " "
                            + sluchacz.isCzyZarejestrowany());
                }
            }
        }
        
    }
}
