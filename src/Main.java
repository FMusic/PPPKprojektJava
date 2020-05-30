import com.fm.dbRepo.RepoManager;
import com.fm.ui.DriversForm;
import com.fm.ui.TravelsPdfForm;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class Main {
    public static void main(String[] args) {
        hibernateCheck();
        //new DriversForm();
        new TravelsPdfForm();
    }

    private static void hibernateCheck() {
        final Session session = RepoManager.getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}
