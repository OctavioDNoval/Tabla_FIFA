public class  Partido
{
    private Equipo team1;
    private Equipo team2;

    public Partido(Equipo team1, Equipo team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public Equipo getTeam1() {
        return team1;
    }

    public Equipo getTeam2() {
        return team2;
    }

    @Override
    public String toString() {
        return team1.getNombre()+" vs "+team2.getNombre();
    }
}
