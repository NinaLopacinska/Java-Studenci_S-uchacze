/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenprojectstudentsluchacz;

import com.mycompany.mavenprojectstudentsluchacz.service.IExporter;
import com.mycompany.mavenprojectstudentsluchacz.service.TextFileExporter;
import com.mycompany.mavenprojectstudentsluchacz.service.RaportGenerator;
import com.mycompany.mavenprojectstudentsluchacz.domain.Student;
import com.mycompany.mavenprojectstudentsluchacz.domain.Sluchacz;
import com.mycompany.mavenprojectstudentsluchacz.domain.Osoba;
import com.mycompany.mavenprojectstudentsluchacz.baza.BazaOsob;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 48514
 */
public class MavenprojectStudentSluchacz {

    public static void main(String[] args) {

        System.out.println("Witaj w dzienniki elektronicznym:");
        Scanner scanner = new Scanner(System.in);
        BazaOsob bazaOsob = new BazaOsob();
        RaportGenerator raportGenerator = new RaportGenerator();
        IExporter exporter = new TextFileExporter();

        boolean czyWyjsc = false;

        while (!czyWyjsc) {
            System.out.println("Wybierz odpowiednij numer:");
            System.out.println("1. Dodaj nowa osobe.");
            System.out.println("2. Wyswietl liste osob.");
            System.out.println("3. Grneruj raport.");
            System.out.println("4. Zapisz do pliku.");
            System.out.println("5. Opusc dziennik.");

            if (scanner.hasNextInt()) {
                int nrOpcji = scanner.nextInt();

                switch (nrOpcji) {
                    case 1:
                        System.out.println("Dodaj nowego Studenta - 1, Sluchcza -2.");
                        int nowaOsoba = scanner.nextInt();
                        scanner.nextLine();
                        if (nowaOsoba == 1) {

                            boolean poprawna1 = false;
                            String imieStudenta;

                            do {
                                System.out.println("Podaj imie Studenta: ");
                                imieStudenta = scanner.nextLine();

                                if (imieStudenta.equals("") || imieStudenta.length() > 120) {
                                    System.out.println("Podaj poprane imie Studenta.");
                                } else {
                                    poprawna1 = true;
                                }
                            } while (!poprawna1);

                            boolean poprawna2 = false;
                            String nazwiskoStudent;
                            do {
                                System.out.println("Podaj nazwisko Studenta: ");
                                nazwiskoStudent = scanner.nextLine();
                                if (nazwiskoStudent.equals("") || nazwiskoStudent.length() > 120) {
                                    System.out.println("Podaj poprawne nazwisko Studenta.");
                                } else {
                                    poprawna2 = true;
                                }
                            } while (!poprawna2);
                            boolean poprawna3 = false;
                            String nrAlbumu;
                            do {
                                System.out.println("Podaj numer albumu Studenta: ");
                                nrAlbumu = scanner.nextLine();
                                if (nrAlbumu.length() != 10) {
                                    System.out.println("Podaj poprawny numer albumu.");
                                } else {
                                    poprawna3 = true;
                                }
                            } while (!poprawna3);

                            boolean poprawna4 = false;
                            int iloscOcenStudenta;
                            do {
                                System.out.println("Ile ocen chcesz dac: ");
                                iloscOcenStudenta = scanner.nextInt();
                                if (iloscOcenStudenta < 0 || iloscOcenStudenta > 10) {
                                    System.out.println("Podaj prawidlowa ilosc ocen.");
                                } else {
                                    poprawna4 = true;
                                }
                            } while (!poprawna4);
                            List<Integer> ocenyStudenta = new ArrayList<>();
                            int ocenaZla2 = 0;

                            for (int i = 0; i < iloscOcenStudenta; i++) {
                                boolean poprawna5 = false;
                                int ocena = 0;
                                do {
                                    System.out.println("Podaj ocene :");
                                    try {
                                        ocena = Integer.parseInt(scanner.nextLine());
                                        if (ocena < 1 || ocena > 5) {
                                            System.out.println("Podaj poprawna ocene z przedzialu 1-5.");
                                        } else {
                                            {
                                                if (ocena == 2) {
                                                    ocenaZla2 = 1;
                                                }
                                            }
                                            ocenyStudenta.add(ocena);
                                            poprawna5 = true;
                                        }
                                    } catch (NumberFormatException e) {

                                    }
                                } while (!poprawna5);

                            }
                            int sumaOcenaStudenta = 0;
                            for (Integer x : ocenyStudenta) {
                                sumaOcenaStudenta += x;
                            }
                            double sredniaOcen = (double) sumaOcenaStudenta / iloscOcenStudenta;

                            Student student = new Student();
                            student.setImie(imieStudenta);
                            student.setNazwisko(nazwiskoStudent);
                            student.setNrAlbumy(nrAlbumu);
                            student.setSredniaOcen(sredniaOcen);
                            student.setOcenaZla2(ocenaZla2);

                            bazaOsob.getOsoby().add(student);

                        } else if (nowaOsoba == 2) {
                            boolean poprawna6 = false;
                            String imieSluchacza;
                            do {
                                System.out.println("Podaj imie Sluchacza: ");
                                imieSluchacza = scanner.nextLine();
                                if (imieSluchacza.equals("") || imieSluchacza.length() > 120) {
                                    System.out.println("Podaj poprawne imie Sluchacza.");
                                } else {
                                    poprawna6 = true;
                                }
                            } while (!poprawna6);

                            boolean poprawna7 = false;
                            String nazwiskoSluchacza;
                            do {
                                System.out.println("Podaj nazwisko Sluchacza: ");
                                nazwiskoSluchacza = scanner.nextLine();
                                if (nazwiskoSluchacza.equals("") || nazwiskoSluchacza.length() > 120) {
                                    System.out.println("Podaj poprawne nazwisko.");
                                } else {
                                    poprawna7 = true;
                                }
                            } while (!poprawna7);

                            boolean poprawna8 = false;
                            boolean czyZarejestrowany = false;
                            String odp;
                            do {
                                System.out.println("Czy Sluchacz jest zarejestrowany? Tak/Nie");
                                odp = scanner.nextLine();
                                if (odp.equals("Tak")) {
                                    czyZarejestrowany = true;
                                    poprawna8 = true;
                                } else if (odp.equals("Nie")) {
                                    czyZarejestrowany = false;
                                    poprawna8 = true;
                                } else {
                                    System.out.println("Podaj 'Tak' lub 'Nie'");
                                }
                            } while (!poprawna8);

                            boolean poprawna9 = false;
                            int iloscOcenSluchacza;
                            do {
                                System.out.println("Ile ocen chcesz dac: ");
                                iloscOcenSluchacza = scanner.nextInt();
                                if (iloscOcenSluchacza < 0 || iloscOcenSluchacza > 10) {
                                    System.out.println("Podaj prawidlowa ilosc ocen.");
                                } else {
                                    poprawna9 = true;
                                }
                            } while (!poprawna9);

                            List<Integer> ocenySluchacz = new ArrayList<>();
                            int ocenaZla2 = 0;

                            for (int i = 0; i < iloscOcenSluchacza; i++) {
                                boolean poprawna10 = false;
                                int ocena = 0;
                                do {
                                    System.out.println("Podaj ocene :");
                                    try {
                                        ocena = Integer.parseInt(scanner.nextLine());
                                        if (ocena < 1 || ocena > 5) {
                                            System.out.println("Podaj poprawna ocene z przedzialu 1-5.");
                                        } else {
                                            if (ocena == 2) {
                                                ocenaZla2 = 1;
                                            }
                                        }
                                        {
                                            ocenySluchacz.add(ocena);
                                            poprawna10 = true;
                                        }
                                    } catch (NumberFormatException e) {

                                    }
                                } while (!poprawna10);

                            }
                            int sumaOcenaSluchacza = 0;
                            for (Integer x : ocenySluchacz) {
                                sumaOcenaSluchacza += x;
                            }
                            double sredniaOcen = (double) sumaOcenaSluchacza / iloscOcenSluchacza;

                            Sluchacz sluchacz = new Sluchacz();
                            sluchacz.setImie(imieSluchacza);
                            sluchacz.setNazwisko(nazwiskoSluchacza);
                            sluchacz.setCzyZarejestrowany(czyZarejestrowany);
                            sluchacz.setSredniaOcen(sredniaOcen);
                            sluchacz.setOcenaZla2(ocenaZla2);

                            bazaOsob.getOsoby().add(sluchacz);
                        } else {
                            System.out.println("Podaj poprawna wartosc 1 lub 2.");
                        }

                        break;

                    case 2:
                        int nrPorzadkowy = 1;
                        for (Osoba x : bazaOsob.getOsoby()) {
                            if (x instanceof Student) {
                                Student student = (Student) x;
                                System.out.println(nrPorzadkowy + " " + "Student- " + student.getImie() + " " + student.getNazwisko() + " nr albumu: " + student.getNrAlbumy() + " " + nrPorzadkowy + ".");
                            } else if (x instanceof Sluchacz) {
                                Sluchacz sluchacz = (Sluchacz) x;
                                System.out.println("Sluchacz- " + sluchacz.getImie() + " " + sluchacz.getNazwisko() + " czy zarejstrowany: " + sluchacz.isCzyZarejestrowany() + ".");
                            }
                            nrPorzadkowy++;
                        }
                        break;
                    case 3:
                        raportGenerator.generujRaport(bazaOsob);
                        break;
                    case 4:
                        System.out.println("Podaj nazwę pliku do zapisu (np. lista_osob.txt): ");
                        String nazwaPliku = scanner.nextLine();
                        scanner.hasNextLine();
                        try {
                            exporter.export(bazaOsob.getOsoby(), nazwaPliku);
                            System.out.println("Lista osób została zapisana do pliku: " + nazwaPliku);
                        } catch (IOException e) {
                            System.err.println("Błąd podczas zapisu pliku: " + e.getMessage());
                        }
                        break;
                    case 5:
                        System.out.println("Do zobaczenia!");
                        czyWyjsc = true;
                        break;

                }
            } else {
                System.out.println("Podaj poprawny numer opcji. ");
            }
            System.out.println("Błędna wartość!");
            scanner.next();
        }
        scanner.close();
    }
}
