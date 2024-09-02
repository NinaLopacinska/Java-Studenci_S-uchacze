/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectstudentsluchacz.service;

import com.mycompany.mavenprojectstudentsluchacz.domain.Osoba;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author 48514
 */
public interface IExporter {
    void export(List<Osoba> osoby, String nazwaPliku) throws IOException;
}
