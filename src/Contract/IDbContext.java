package Contract;

import org.hibernate.Session;

public interface IDbContext {
    Session getContext();

    void closeFactory();
}
