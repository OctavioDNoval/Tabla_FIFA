import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.ListIterator;

public class Tabla
{
    private ArrayList<Equipo> tablaEquipos;
    public Tabla(ArrayList<Equipo> equipos)
    {
        tablaEquipos=equipos;
    }
    public ArrayList<Equipo> getTablaEquipos() {
        return tablaEquipos;
    }
    public void ordenarEquipos()
    {
        tablaEquipos.sort((j1, j2) -> Integer.compare(j2.getPuntos(), j1.getPuntos()));
    }
    public String imprimirTabla()
    {
        String aux="EQUIPO\tPTS\tPJ\tPG\tPE\tPP\tDG\n";
        for(Equipo a:tablaEquipos)
        {
            aux=aux.concat(a.toString());
        }
        return aux;
    }
    public Equipo getEquipo(String nombre)
    {
        for(Equipo a:tablaEquipos)
        {
            if (a.getNombre().equals(nombre))
            {
                return a;
            }
        }
        return null;
    }
    public void updateTabla(Equipo ganador, Equipo perdedor)
    {
        ListIterator<Equipo> iterator = tablaEquipos.listIterator();
        while (iterator.hasNext())
        {
            Equipo a = iterator.next();
            if (a.equals(ganador))
            {
                iterator.remove();
                iterator.add(ganador);
            } else if (a.equals(perdedor))
            {
                iterator.remove();
                iterator.add(perdedor);
            }
        }
    }
}
