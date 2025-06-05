import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


//Maximizar el número de actividades compatibles. Se tienen n actividades que necesitan utilizar un
//recurso, tal como una sala de conferencias, en exclusión mutua. Cada actividad i tiene asociado un
//tiempo de comienzo ci y un tiempo de finalización fi de utilización del recurso, con ci < fi. Si la
//actividad i es seleccionada se llevará a cabo durante el intervalo [ci, fi). Las actividades i y j son
//compatibles si los intervalos [ci, fi) y [cj, fj) no se superponen (es decir, ci > fj o cj > fi). El problema
//consiste en encontrar la cantidad máxima de actividades compatibles entre sí.
public class Ejercicio3 {

    public class Actividad {
        private int comienzo;
        private int fin;

        public Actividad(int comienzo, int fin) {
            this.comienzo = comienzo;
            this.fin = fin;
        }

        public int getComienzo() {
            return comienzo;
        }

        public void setComienzo(int comienzo) {
            this.comienzo = comienzo;
        }

        public int getFin() {
            return fin;
        }

        public void setFin(int fin) {
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
                if (a.getComienzo() >= tiempoFinAnterior) {
                    seleccionadas.add(a);
                    tiempoFinAnterior = a.getFin();
                }
            }

            return seleccionadas;
        }
    }



}