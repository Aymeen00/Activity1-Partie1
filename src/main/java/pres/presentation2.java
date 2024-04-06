package pres;
import dao.IDao;
import metier.IMetier;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
public class presentation2 {
    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        /*
        instanciation dynamique
        faut: 1/ connaitre le nom de la classe
        2/ charger la classe en memoire
        3/ instancier la classe
         */
        Scanner scan =new Scanner(new File("config.txt"));
        String daoClassName=scan.nextLine();
        Class cDao=Class.forName(daoClassName);//si classe existe : chargement de bytecode en memoire , sinon generation d'une exception
        //instancier la classe
        //MewInstance retourne type object
        //Exception: classcastException si on fais appel a une classe qui n'implemente pas l'interface IDao {cast vers une class qui n'herite pas de cette interface}
        IDao dao = (IDao) cDao.newInstance();

         String metierClassName= scan.nextLine();
        Class cMetier=Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.newInstance();

        Method method=cMetier.getMethod("setDao",IDao.class);
        method.invoke(metier,dao);
        System.out.println("Resultat=>"+metier.calcul());
    }
}
