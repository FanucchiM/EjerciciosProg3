import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ejercicio3 {

    class Actividad {
        int comienzo;
        int fin;

        public Actividad(int comienzo, int fin) {
            this.comienzo = comienzo;
            this.fin = fin;
        }
    }

    public class SeleccionActividadesGreedy {

        public static List<Actividad> seleccionarActividades(List<Actividad> actividades) {
            // Ordeno por tiempo de finalización ascendente
            actividades.sort(Comparator.comparingInt(a -> a.fin));

            List<Actividad> seleccionadas = new ArrayList<>();

            int tiempoFinAnterior = 0;

            for (Actividad a : actividades) {
                if (a.comienzo >= tiempoFinAnterior) {
                    seleccionadas.add(a);
                    tiempoFinAnterior = a.fin;
                }
            }

            return seleccionadas;
        }
    }



}