
import Contract.ICourse;
import Contract.IDbContext;
import Contract.IRegistration;
import Contract.IUser;
import Entities.User;
import MySQL.DbContext;
import MySQL.MySQLRepositoryCourse;
import MySQL.MySQLRepositoryRegistrations;
import MySQL.MySQLRepositoryUsers;


public class TestHibernate {

    public static void main(String[] args) {

        IDbContext context = new DbContext();

        ICourse sqlCourse = new MySQLRepositoryCourse(context);

        IUser sqlUser = new MySQLRepositoryUsers(context);

        IRegistration sqlReg = new MySQLRepositoryRegistrations(context);


        try {


//            User user = new User();
//            user.setFirstName("Robert");
//            user.setLastName("Jones");
//            user.setPwd("xojsosj");
//            sqlUser.insert(user, (short)1);



        } catch (Exception ex) {
            System.out.println(ex);
        }


    }
}
