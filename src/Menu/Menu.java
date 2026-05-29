package Menu;
import Model.Genero;
import Model.Prestamo;
import Model.Videogame;
import Operations.PrestamoDAO;
import Operations.VideogameDAO;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Menu {
    public static void Inicio() {
        Scanner sc = new Scanner(System.in);
        int q;
        do {
            System.out.println("Bienvenido al sistema de stock y prestamos de videojuegos.");
            System.out.println("\n\nSeleccione el menu de su interes.\n\n1). Videojuegos.\n\n2). Prestamos.\n\n3). Salir.\n\nIngrese el indice del menu para continuar.\n");
            q = sc.nextInt();
            switch (q) {//selecciona cual menu va a tocar
                case 1: {// Menu videojuegos
                    int z;
                    do {
                        System.out.println("Bienvenido al menu Videojuegos.");
                        System.out.println("\n\nSeleccione la accion que desea realizar.\n\n1). Busqueda.\n\n2). Acciones.\n\n3).Regresar.");
                        z = sc.nextInt();
                        switch (z) {
                            case 1: {// este maldito es para la busqueda
                                int e;
                                do {
                                    System.out.println("Como desea realizar la busqueda?");
                                    System.out.println("1). General\n\n2). Por nombre.\n\n3). Por genero.\n\n4).Regresar.\n");
                                    e = sc.nextInt();
                                    switch (e) {
                                        case 1: {
                                            List<Videogame> vs = VideogameDAO.getAllVideogames();
                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                            for (Videogame v : vs) {
                                                System.out.println(v);
                                            }
                                            break;
                                        }
                                        case 2: {
                                            System.out.println("Ingrese el nombre del juego que desea mirar o ingrese 0 para regresar.");
                                            String s = sc.next();
                                            if (s.equals("0")) {
                                                break;
                                            }
                                            List<Videogame> nm = VideogameDAO.getByName(s);
                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                            for(Videogame v : nm) {
                                                System.out.println(v);
                                            }
                                            break;
                                        }
                                        case 3: {
                                            int r;
                                            do {
                                                System.out.println("Seleccione el genero de su interes.");
                                                System.out.println("1).Accion.\n\n2).Fantasia.\n\n3).Shooter.\n\n4).Terror.\n\n5)Plataformas.\n\n6).Aventura.\n\n7).Carreras.\n\n8).Pelea.\n\n9).Deportes.\n\n10).RPG.\n\n11).Simulacion.\n\n12).Estrategia.\n\n13).Detectives.\n\n14).Realidad_Aumentada.\n\n15).Sandbox.\n\n16).Dungeon_Crawler.\n\n17).Cartas.\n\n18).Puzzle.\n\n19).Sigilo.\n\n20).SciFi.\n\n21).Musical.\n\n22).Regresar.\n\n");
                                                if(sc.hasNextInt()) {
                                                    r = sc.nextInt();
                                                    switch (r) {
                                                        case 1: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Accion;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 2: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Fantasia;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 3: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Shooter;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 4: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Terror;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 5: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Plataformas;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 6: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Aventura;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 7: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Carreras;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 8: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Pelea;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 9: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Deportes;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 10: {
                                                            sc.nextLine();
                                                            Genero g = Genero.RPG;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 11: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Simulacion;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 12: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Estrategia;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 13: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Detectives;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 14: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Realidad_Aumentada;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 15: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Sandbox;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 16: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Dungeon_Crawler;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 17: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Cartas;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 18: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Puzzle;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 19: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Sigilo;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 20: {
                                                            sc.nextLine();
                                                            Genero g = Genero.SciFi;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 21: {
                                                            sc.nextLine();
                                                            Genero g = Genero.Musical;
                                                            List<Videogame> ge= VideogameDAO.getByGenre(g);
                                                            System.out.println("|   id  |       Nombre      |   Genero  |   Precio  |   Unidades Disponibles    |   id Desarrollador    |");
                                                            for (Videogame v : ge) {
                                                                System.out.println(v);
                                                            }
                                                            break;
                                                        }
                                                        case 22: {
                                                            sc.nextLine();
                                                            System.out.println("Regresando...");
                                                            break;
                                                        }
                                                        default: {
                                                            System.out.println("Opción inválida");
                                                        }
                                                    }
                                                }
                                                else{
                                                    sc.nextLine();
                                                    System.out.println("Eso no es un numerito.");
                                                    break;
                                                }
                                            } while (r != 22);
                                            break;
                                        }
                                        case 4:{
                                            System.out.println("Regresando...");
                                        }
                                        default: {
                                            System.out.println("Opción inválida");
                                        }
                                    }
                                } while (e != 4);
                                break;
                            }
                            case 2: { // este otro desgraciado es para las acciones
                                int r;
                                do {
                                    System.out.println("Que accion desea realizar?\n\n");
                                    System.out.println("1).Adicionar Juego.\n\n2).Alquilar Juego.\n\n3).Agregar Unidades Disponibles.\n\n4)Regresar.\n\n");
                                    r = sc.nextInt();
                                    switch (r) {
                                        case 1: {
                                            System.out.println("Ingrese el nombre del juego:\n\n");
                                            String nombre = sc.nextLine();
                                            System.out.println("Escoja el genero de su juego.");
                                            System.out.println("1).Accion.\n\n2).Fantasia.\n\n3).Shooter.\n\n4).Terror.\n\n5)Plataformas.\n\n6).Aventura.\n\n7).Carreras.\n\n8).Pelea.\n\n9).Deportes.\n\n10).RPG.\n\n11).Simulacion.\n\n12).Estrategia.\n\n13).Detectives.\n\n14).Realidad_Aumentada.\n\n15).Sandbox.\n\n16).Dungeon_Crawler.\n\n17).Cartas.\n\n18).Puzzle.\n\n19).Sigilo.\n\n20).SciFi.\n\n21).Musical.\n\n22).Regresar.\n\n");
                                            String genero="";
                                            if (sc.hasNextInt()) {
                                                switch (sc.nextInt()) {
                                                    case 1: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Accion;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 2: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Fantasia;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 3: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Shooter;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 4: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Terror;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 5: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Plataformas;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 6: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Aventura;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 7: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Carreras;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 8: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Pelea;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 9: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Deportes;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 10: {
                                                        sc.nextLine();
                                                        Genero g = Genero.RPG;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 11: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Simulacion;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 12: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Estrategia;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 13: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Detectives;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 14: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Realidad_Aumentada;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 15: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Sandbox;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 16: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Dungeon_Crawler;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 17: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Cartas;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 18: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Puzzle;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 19: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Sigilo;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 20: {
                                                        sc.nextLine();
                                                        Genero g = Genero.SciFi;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 21: {
                                                        sc.nextLine();
                                                        Genero g = Genero.Musical;
                                                        genero = g.toString();
                                                        break;
                                                    }
                                                    case 22: {
                                                        sc.nextLine();
                                                        System.out.println("Regresando...");
                                                        break;
                                                    }
                                                    default: {
                                                        System.out.println("Opción inválida");
                                                    }
                                                }
                                            }
                                            else{
                                                System.out.println("Eso no es un numerito.");
                                            }
                                            System.out.println("Ingrese el precio del juego:");
                                            double pr =sc.nextDouble();
                                            System.out.println("Ingrese las unidades que va a ingresar del juego:");
                                            int u =sc.nextInt();
                                            System.out.println("Escoja el desarrollador de su videojuego:");
                                            System.out.println("1). FromSoftware\n\n2). Nintendo\n\n3). Rockstar Games\n\n4). Mojang\n\n5). CD Projekt Red\n\n6). Ubisoft\n\n7). Valve\n\n8). Capcom\n\n9). Square Enix\n\n10). Bethesda\n\n11). Epic Games\n\n12). Blizzard Entertainment\n\n13). SEGA\n\n14). Bandai Namco\n\n15). Electronic Arts\n\n16). Konami\n\n17). Respawn Entertainment\n\n18). Naughty Dog\n\n 19). Santa Monica Studio\n\n20). Insomniac Games");
                                            int idD=0;
                                            if(sc.hasNextInt()){
                                                int o=sc.nextInt();
                                                switch(o) {
                                                    case 1:
                                                        idD = 1; // FromSoftware
                                                        break;
                                                    case 2:
                                                        idD = 2; // Nintendo
                                                        break;
                                                    case 3:
                                                        idD = 3; // Rockstar Games
                                                        break;
                                                    case 4:
                                                        idD = 4; // Mojang
                                                        break;
                                                    case 5:
                                                        idD = 5; // CD Projekt Red
                                                        break;
                                                    case 6:
                                                        idD = 6; // Ubisoft
                                                        break;
                                                    case 7:
                                                        idD = 7; // Valve
                                                        break;
                                                    case 8:
                                                        idD = 8; // Capcom
                                                        break;
                                                    case 9:
                                                        idD = 9; // Square Enix
                                                        break;
                                                    case 10:
                                                        idD = 10; // Bethesda
                                                        break;
                                                    case 11:
                                                        idD = 11; // Epic Games
                                                        break;
                                                    case 12:
                                                        idD = 12; // Blizzard Entertainment
                                                        break;
                                                    case 13:
                                                        idD = 13; // SEGA
                                                        break;
                                                    case 14:
                                                        idD = 14; // Bandai Namco
                                                        break;
                                                    case 15:
                                                        idD = 15; // Electronic Arts
                                                        break;
                                                    case 16:
                                                        idD = 16; // Konami
                                                        break;
                                                    case 17:
                                                        idD = 17; // Respawn Entertainment
                                                        break;
                                                    case 18:
                                                        idD = 18; // Naughty Dog
                                                        break;
                                                    case 19:
                                                        idD = 19; // Santa Monica Studio
                                                        break;
                                                    case 20:
                                                        idD = 20; // Insomniac Games
                                                        break;
                                                    default:
                                                        idD = -1; // opción inválida
                                                        System.out.println("Opción no válida");
                                                }
                                            }
                                            Videogame v = new Videogame(nombre,genero,pr,u,idD);
                                            VideogameDAO.insertVideogame(v);
                                            break;
                                        }
                                        case 2: {// alquila juegardos
                                            System.out.println("Ingrese el id del juego que desea alquilar.");
                                            int id =sc.nextInt();
                                            System.out.println("Ingrese su nombre y apellido.");
                                            String np = sc.nextLine();
                                            VideogameDAO.alquilarV(id,np);
                                            break;
                                        }
                                        case 3: {//agrega unidades
                                            System.out.println("Ingrese el id del juego");
                                            int id=sc.nextInt();
                                            System.out.println("Ingrese el nombre del juego que va a agregar.");
                                            String juego=sc.nextLine();

                                            VideogameDAO.agregarVideojuego(juego,id);
                                            break;
                                        }
                                        case 4:{
                                            System.out.println("Regresando");
                                        }
                                        default: {
                                            System.out.println("Opcion invalida.");
                                        }
                                    }
                                } while (r != 4);
                                break;
                            }
                            case 3: {
                                System.out.println("Regresando...");
                                break;
                            }
                            default: {
                                System.out.println("Opcion Invalida.");
                            }
                        }
                    } while (z != 3);
                    break;
                }
                case 2: {//prestamos
                    int m;
                    do {
                        System.out.println("Bienvenido al menu de prestamos.\n\n");
                        System.out.println("Seleccione la opcion de su interes.\n\n1).Busqueda.\n\n2).Devolucion.\n\n3).Regresar\n\n");
                        m = sc.nextInt();
                        switch (m) {
                            case 1: {
                                int n;
                                do {
                                    System.out.println("Ingrese el filtro de busqueda.\n\n1).General.\n\n2).Por id.\n\n3).Por nombre de la persona.\n\n4).Por Id del juego.\n\n5).Regresar.\n\n");
                                    n = sc.nextInt();
                                    switch (n) {
                                        case 1: {
                                            List<Prestamo> prst= PrestamoDAO.getAllPrestamos();
                                            System.out.println("|   id  |       Persona      |   Fecha  |   id Videojuego  |");
                                            for (Prestamo p : prst) {
                                                System.out.println(p);
                                            }
                                            break;
                                        }
                                        case 2: {
                                            System.out.println("Escriba el id del prestamo:");
                                            if(sc.hasNextInt()) {
                                                Prestamo p=PrestamoDAO.getById(sc.nextInt());
                                                System.out.println("|   id  |       Persona      |   Fecha  |   id Videojuego  |");
                                                System.out.println(p);
                                            }else{
                                                System.out.println("Eso no es un numerito");
                                                break;
                                            }
                                            break;
                                        }
                                        case 3: {
                                            System.out.println("Ingrese el nombre de la persona");
                                            List<Prestamo> p = PrestamoDAO.getByPers(sc.nextLine());
                                            System.out.println("|   id  |       Persona      |   Fecha  |   id Videojuego  |");
                                            for  (Prestamo p2 : p) {
                                                System.out.println(p2);
                                            }
                                            break;
                                        }
                                        case 4: {
                                            System.out.println("Ingrese el id del juego");
                                            if(sc.hasNextInt()) {
                                                List<Prestamo> p = PrestamoDAO.getByVideogameId(sc.nextInt());
                                                System.out.println("|   id  |       Persona      |   Fecha  |   id Videojuego  |");
                                                for  (Prestamo p2 : p) {
                                                    System.out.println(p2);
                                                }

                                            }
                                            else{
                                                System.out.println("Eso no es un numerito.");
                                                break;
                                            }
                                            break;
                                        }
                                        default: {
                                            System.out.println("Opcion invalida");
                                        }
                                    }
                                } while (n != 5);
                                break;
                            }
                            case 2: {
                                System.out.println("Ingrese el id del juego que desea devolver.");
                                int id = sc.nextInt();
                                PrestamoDAO.devolverV(id);
                                break;
                            }
                            case 3: {
                                System.out.println("Regresando...");
                                break;
                            }
                            default: {
                                System.out.println("Opcion Invalida.");
                            }
                        }
                    } while (m != 3);
                    break;
                }
                case 3: {
                    System.out.println("Chao pescao...");
                    break;
                }
                default: {
                    System.out.println("Opcion invalida");
                }
            }
        } while (q != 3);
    }
}