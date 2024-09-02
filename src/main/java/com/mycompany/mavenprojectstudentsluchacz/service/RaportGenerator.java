/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectstudentsluchacz.service;

import com.mycompany.mavenprojectstudentsluchacz.domain.Student;
import com.mycompany.mavenprojectstudentsluchacz.domain.Sluchacz;
import com.mycompany.mavenprojectstudentsluchacz.domain.Osoba;
import com.mycompany.mavenprojectstudentsluchacz.baza.BazaOsob;
import java.util.OptionalDouble;

/**
 *
 * @author 48514
 */
public class RaportGenerator implements IRaport {

    @Override
    public void generujRaport(BazaOsob bazaOsob) {

        System.out.println("Osoby i ich srednia ocen:");
        bazaOsob.getOsoby().stream()
                .forEach(x -> {
                    if (x instanceof Student) {
                        Student student = (Student) x;
                        System.out.println("Student " + student.getImie() + " " + student.getNazwisko() + " : " + student.getSredniaOcen());
                    } else if (x instanceof Sluchacz) {
                        Sluchacz sluchacz = (Sluchacz) x;
                        System.out.println("Sluchacz" + sluchacz.getImie() + " " + sluchacz.getNazwisko() + " : " + sluchacz.getSredniaOcen());
                    }
                });

        OptionalDouble sredniaWszytskich = bazaOsob.getOsoby().stream()
                .mapToDouble(Osoba::getSredniaOcen)
                .average();

        long liczbaZlychOcen = bazaOsob.getOsoby().stream()
                .filter(x -> x.getOcenaZla2() > 0)
                .count();

        System.out.println("Ilosc osob z ocena niedostateczna wynosi: " + liczbaZlychOcen);
    }

}
