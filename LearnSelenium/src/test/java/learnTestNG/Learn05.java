package learnTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Learn05 {
  @Test(dataProvider = "dp")
  public void f(String user, String pass) {
	  System.out.println("user name:"+user+"password: "+ pass);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "user1", "password1" },
      new Object[] { "user2", "password2" },
      new Object[] { "user3", "password3" },
      new Object[] { "user4", "password4" },
    };
  }
}
