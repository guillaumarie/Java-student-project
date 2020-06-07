package Vue;

import Controleur.GestionModele;
import Controleur.GestionVue;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.util.TableOrder;

public class Graphique extends JFrame {
    
    private GestionVue gestionVue = null;
    private GestionModele gestionModele = null;

    public Graphique(GestionVue gestionVue_con, GestionModele gestionModele_con) {
        gestionVue = gestionVue_con;
        gestionModele = gestionModele_con;
        
        Date dateActuelle = new Date(System.currentTimeMillis()); // Date actuelle
        Date dateTest = new Date(120, 3, 22);      // Date test : 22 avril 2020
        
        ArrayList<String> nomsCours = new ArrayList<>();
        for (int i = 0; i < gestionVue.getCours().size(); i++) {
            if (nomsCours.contains(gestionVue.getCours().get(i))) {
            } else {
                nomsCours.add(gestionVue.getCours().get(i));
            }
        }
        
        int nombreCours = nomsCours.size();
        String cours[] = new String[nombreCours];
        double [][]progression = new double[nombreCours][2];
        for (int i = 0; i < gestionVue.getDates().size(); i++) {
            int coursParcouru = 0;
            for (int j = 0; j < nombreCours; j++) {
                if (gestionVue.getCours().get(i).equals(nomsCours.get(j))) {
                    coursParcouru = j;
                    break;
                }
            }
            Date dateParcourue = gestionVue.getDates().get(i);
            int compare = dateParcourue.compareTo(dateTest);
            if (compare == -1) {    // Si date du cours avant date du jour
                progression[coursParcouru][0] = progression[coursParcouru][0]+1;
            }
            if (compare == 1) {    // Si date du cours après date du jour
                progression[coursParcouru][1] = progression[coursParcouru][1]+1;
            }
            if (compare == 0) {    // Si date du cours égale date du jour
                LocalTime maintenant = LocalTime.now();
                Time heureActuelle = Time.valueOf(maintenant);
                Time heureTest = new Time(11, 0, 0);
                Time heureParcourue = gestionVue.getDebuts().get(i);
                int compare2 = heureParcourue.compareTo(heureTest);
                if (compare2 == -1) {    // Si heure du cours avant heure actuelle
                    progression[coursParcouru][0] = progression[coursParcouru][0]+1;
                }
                if (compare2 == 1) {    // Si heure du cours avant heure actuelle
                    progression[coursParcouru][1] = progression[coursParcouru][1]+1;
                }
            }
            cours[coursParcouru] = gestionVue.getCours().get(i);
        }
        
        String etat[] = {"Passé", "A venir"};
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
                cours, etat, progression);

        /* create chart */
        JFreeChart chart = ChartFactory.createMultiplePieChart("Progression des cours", dataset,
                TableOrder.BY_ROW, true, true, true);

        /* create and display chart on frame */
        ChartFrame frame = new ChartFrame("Statistiques", chart);
        frame.setVisible(true);
        frame.pack();
    }
    
    // Source : https://self-learning-java-tutorial.blogspot.com/2015/06/jfreechart-multiple-pie-charts.html#:~:text=JFreeChart%20Multiple%20Pie%20charts,following%20constructors%20to%20instantiate%20MultiplePieChart.
}
