package vista;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Ing. Diego
 */
public class PlanSRT {

    public ArrayList<Proces> ordenarProces(ArrayList<Proces> procesoaOrd) {
        for (int i = 0; i < procesoaOrd.size() - 1; i++) {
            for (int j = i + 1; j < procesoaOrd.size(); j++) {
                if (procesoaOrd.get(i).obtieneDuracion() > procesoaOrd.get(j).obtieneDuracion()) {
                    Proces proAux = procesoaOrd.get(i);
                    procesoaOrd.set(i, procesoaOrd.get(j));
                    procesoaOrd.set(j, proAux);
                }
            }
        }
        return procesoaOrd;
    }

    public double durPromedioDeProcces(ArrayList<Proces> procesosOrd) {
        double duraProm = durTotal(procesosOrd);
        duraProm = duraProm / procesosOrd.size();
        return duraProm;
    }
    public double durPromedioDeProccesEspera(ArrayList<Proces> procesosOrd) {
        double duraProm = durTotal1(procesosOrd);
        duraProm = duraProm / procesosOrd.size();
        return duraProm;
    }

    public int durTotal(ArrayList<Proces> procesos) {
        int durTota = 0;
        for (Proces proceso : procesos) {
            durTota = durTota + proceso.obtieneDuracion();
        }
        return durTota;
    }
    public int durTotal1(ArrayList<Proces> procesos) {
        int durTota = 0;
        for (Proces proceso : procesos) {
            durTota = durTota +proceso.obtieneTiempoLLega();
        }
        return durTota;
    }

    public boolean proEncontrado(Proces p, ArrayList<Proces> procesos) {
        for (Proces proceso : procesos) {
            if (proceso.getStrNombre().equals(p.getStrNombre())) {
                System.out.println(proceso.getStrNombre());
                return true;
            }
        }
        return false;
    }

    public void agregarADiagramaGant(JPanel jP, ArrayList<Proces> procOrd) {
        jP.removeAll();
        jP.setLayout(new java.awt.GridLayout(1, procOrd.size(), 5, 5));
        for (Proces p : procOrd) {
            JLabel jb = new JLabel("<html>" + p.getStrNombre() + "<br>" + p.obtieneDuracion() + " segundos<br>LLega: "+p.obtieneTiempoLLega()+"</html>");
            jb.setBorder(new LineBorder(Color.ORANGE));
            jP.add(jb);

        }
    }

    public String[][] convertirAMatriz(ArrayList<Proces> proc) {
        String procesos[][] = new String[proc.size()][2];
        for (int i = 0; i < proc.size(); i++) {
            procesos[i][0] = proc.get(i).getStrNombre();
            procesos[i][1] = proc.get(i).obtieneDuracion() + "";
        }
        return procesos;
    }
}
