package pres;

import ext.DaoImp2;
import dao.DaoImpl;
import metier.IMetierImpl;

public class presentation {
    /*
    * Injection des dependances par instanciation statique (new (couplage fort))
     */
    public static void main(String[] args) {
        DaoImp2 dao = new DaoImp2();
        IMetierImpl metier = new IMetierImpl();
        metier.setDao(dao);
        System.out.println("Resultat="+metier.calcul());
    }
}