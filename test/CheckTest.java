import model.check.Check;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckTest {

    private Check checkClass;

    @Test
    public void checkLoginLibrarian_goodResult_True() throws Exception
    {
        String extendedLogin = "admin";
        String extendedPassword = "admin";
        Assert.assertEquals(true, checkClass.checkLoginAndPasswordLibrarian(extendedLogin, extendedPassword));
    }

    @Test
    public void checkLoginLibrarian_badResult_False() throws Exception
    {
        String extendedLogin = "nastya";
        String extendedPassword = "0303";
        Assert.assertEquals(false, checkClass.checkLoginAndPasswordLibrarian(extendedLogin, extendedPassword));
    }
}
