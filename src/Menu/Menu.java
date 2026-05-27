package Menu;
import Model.Genero;
import Model.Prestamo;
import Model.Videogame;
import Operations.PrestamoDAO;
import Operations.VideogameDAO;

import java.sql.SQLOutput;
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
                                        case 1: {// adiciona juego completo
                                            //VideogameDAO.insertVideogame();
                                            break;
                                        }
                                        case 2: {// alquila juegardos
                                            //VideogameDAO.alquilarV();
                                            break;
                                        }
                                        case 3: {//agrega unidades
                                            //VideogameDAO.agregarVideojuego();
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
                                            //PrestamoDAO.getAllPrestamos();
                                            break;
                                        }
                                        case 2: {
                                            //PrestamoDAO.getById();
                                            break;
                                        }
                                        case 3: {
                                            //PrestamoDAO.getByPers();
                                            break;
                                        }
                                        case 4: {
                                            //PrestamoDAO.getByVideogameId();
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
                                //PrestamoDAO.devolverV();
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
