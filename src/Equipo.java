public class Equipo
{
    private String nombre;
    private int puntos;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int diferenciaGoles;
    public Equipo(String nombre)
    {
        this.nombre=nombre;
        puntos=0;
        partidosEmpatados=0;
        partidosGanados=0;
        partidosJugados=0;
        partidosPerdidos=0;
        diferenciaGoles=0;
    }
    public void win(int goles)
    {
        diferenciaGoles+=goles;
        partidosGanados++;
        puntos+=3;
        partidosJugados++;
    }
    public void lose(int goles)
    {
        diferenciaGoles+=goles;
        partidosPerdidos++;
        partidosJugados++;
    }
    public void draw()
    {
        partidosEmpatados++;
        puntos++;
        partidosJugados++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public int getDiferenciaGoles() {
        return diferenciaGoles;
    }

    @Override
    public String toString() {
        return getNombre()+"\t"+getPuntos()+"\t"+getPartidosJugados() +"\t"+getPartidosGanados()+"\t"+getPartidosEmpatados()+"\t"+getPartidosPerdidos()+"\t"+getDiferenciaGoles()+"\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj!=null)
        {
            if(obj instanceof Equipo)
            {
                Equipo aux=(Equipo) obj;
                if(aux.getNombre().equals(nombre))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
