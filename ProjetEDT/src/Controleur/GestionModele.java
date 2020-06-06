/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.DAO.*;
import Modele.POJO.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class GestionModele {
    
    private Connection conn;
    
    private final AdminDAO adminDao;
    private final CoursDAO coursDao;
    private final EnseignantDAO enseignantDao;        
    private final EtudiantDAO etudiantDao;        
    private final GroupeDAO groupeDao;        
    private final PromoDAO promoDao;        
    private final ReferentDAO referentDao;        
    private final SalleDAO salleDao;        
    private final SeanceDAO seanceDao;        
    private final SeanceEnseignantDAO seDao;        
    private final SeanceGroupeDAO sgDao;        
    private final SeanceSalleDAO ssDao;        
    private final SiteDAO siteDao;        
    private final TypeDAO typeDao;
    
    public GestionModele() {
        this.adminDao = new AdminDAO();
        this.coursDao = new CoursDAO();
        this.enseignantDao = new EnseignantDAO();        
        this.etudiantDao = new EtudiantDAO();        
        this.groupeDao = new GroupeDAO();        
        this.promoDao = new PromoDAO();        
        this.referentDao = new ReferentDAO();        
        this.salleDao = new SalleDAO();        
        this.seanceDao = new SeanceDAO();        
        this.seDao = new SeanceEnseignantDAO();        
        this.sgDao = new SeanceGroupeDAO();        
        this.ssDao = new SeanceSalleDAO();        
        this.siteDao = new SiteDAO();        
        this.typeDao = new TypeDAO();
    }
    
    public void ConnexionBDD() {
        try {
            Connexion maconnexion = new Connexion();
            conn = maconnexion.getConnexion();
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void InitialiserTables() {
        try {
            adminDao.init(conn);
            coursDao.init(conn);
            enseignantDao.init(conn);
            etudiantDao.init(conn);
            groupeDao.init(conn);
            promoDao.init(conn);
            referentDao.init(conn);
            salleDao.init(conn);
            seanceDao.init(conn);
            seDao.init(conn);
            sgDao.init(conn);
            ssDao.init(conn);
            siteDao.init(conn);
            typeDao.init(conn);
        } catch (SQLException e) {
            Logger.getLogger(GestionModele.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void ReinitialiserTables (){
        adminDao.vider();
        coursDao.vider();
        enseignantDao.vider();
        etudiantDao.vider();
        groupeDao.vider();
        promoDao.vider();
        referentDao.vider();
        salleDao.vider();
        seanceDao.vider();
        seDao.vider();
        sgDao.vider();
        ssDao.vider();
        siteDao.vider();
        typeDao.vider();
        this.InitialiserTables();
    }
    
    public void ajouterSeance(int semaine, Date date, Time debut, Time fin, int cours, int type) {
        Seance nouvelleSeance = new Seance(0, semaine, date, debut, fin, true, cours, type);
        try {
            seanceDao.create(nouvelleSeance, conn);
        } catch (SQLException ex) {
            Logger.getLogger(GestionModele.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.ReinitialiserTables();
    }
    
    public void supprimerSeance(Seance seanceSup) {
        try {
            seanceDao.delete(seanceSup, conn);
        } catch (SQLException ex) {
            Logger.getLogger(GestionModele.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.ReinitialiserTables();
    }
    
    public void modifierSeance(Seance seanceMaj) {
        try {
            seanceDao.update(seanceMaj, conn);
        } catch (SQLException ex) {
            Logger.getLogger(GestionModele.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.ReinitialiserTables();
    }
    
    
    public AdminDAO getAdminDAO() {return adminDao;}
    public CoursDAO getCoursDAO() {return coursDao;}
    public EnseignantDAO getEnseignantDAO() {return enseignantDao;}
    public EtudiantDAO getEtudiantDAO() {return etudiantDao;}
    public GroupeDAO getGroupeDAO() {return groupeDao;}
    public PromoDAO getPromoDAO() {return promoDao;}
    public ReferentDAO getReferentDAO() {return referentDao;}
    public SalleDAO getSalleDAO() {return salleDao;}
    public SeanceDAO getSeanceDAO() {return seanceDao;}
    public SeanceEnseignantDAO getSEDAO() {return seDao;}
    public SeanceGroupeDAO getSGDAO() {return sgDao;}
    public SeanceSalleDAO getSSDAO() {return ssDao;}
    public SiteDAO getSiteDAO() {return siteDao;}
    public TypeDAO getTypeDAO() {return typeDao;}
}
