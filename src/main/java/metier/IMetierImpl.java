package metier;
import dao.IDao;

public class IMetierImpl implements IMetier {
    private IDao dao;
    @Override
    public double calcul() {
        double tmp=dao.getData();

        return 0;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
