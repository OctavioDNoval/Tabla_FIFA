import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner scan= new Scanner(System.in);
    public static void main(String[] args) {
        String nombreEquipo="-1";
        ArrayList<Equipo>equipos= new ArrayList<>();
        System.out.println("ingrese 0 para continuar\n");
        System.out.println("ingrese equipos: ");
        do
        {
            nombreEquipo=scan.nextLine();
            equipos.add(new Equipo(nombreEquipo));
        }while(!(nombreEquipo.equals("0")));
        equipos.remove(equipos.getLast());
        Tabla tabla= new Tabla(equipos);
        System.out.println(tabla.imprimirTabla());
        ArrayList<Partido>partidos=new ArrayList<>();
        //cargamos partiods
        for(int f=0;f< equipos.size();f++)
        {
            for(int i=f+1;i<equipos.size();i++)
            {
                partidos.add(new Partido(equipos.get(f),equipos.get(i)));
            }
        }
        Collections.shuffle(partidos);
        for (int i=0;i< partidos.size();i++)
        {
            System.out.println((i+1)+"° partido\n"+ partidos.get(i).toString()+"\n----Resultado----\n"+partidos.get(i).getTeam1().getNombre()+": ");
            int score1=scan.nextInt();
            scan.nextLine();
            System.out.println(partidos.get(i).getTeam2().getNombre());
            int score2=scan.nextInt();
            scan.nextLine();
            if(score1>score2)//gana team 1
            {
                Equipo ganador=partidos.get(i).getTeam1();
                Equipo perdedor=partidos.get(i).getTeam2();
                ganador.win(score1-score2);
                perdedor.lose(score2-score1);
                tabla.updateTabla(ganador,perdedor);
            }
            else if (score1==score2)
            {
                //las variables son ganador y perdedor porque no se me ocurrio otra
                //no cambia nada en el update
                Equipo ganador=partidos.get(i).getTeam1();
                Equipo perdedor=partidos.get(i).getTeam2();
                ganador.draw();
                perdedor.draw();
                tabla.updateTabla(ganador,perdedor);
            }
            else //caso que queda de que score 2 sea mayor que score 1
            {
                Equipo ganador=partidos.get(i).getTeam2();
                Equipo perdedor=partidos.get(i).getTeam1();
                ganador.win(score2-score1);
                perdedor.lose(score1-score2);
                tabla.updateTabla(ganador,perdedor);
            }
            tabla.ordenarEquipos();
            System.out.println("\n"+tabla.imprimirTabla());
        }
    }

}