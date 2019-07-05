import by.Khadasevich.Decan.Decan;
import by.Khadasevich.Stream.RemedialStream;
import by.Khadasevich.Student.Form.FormEnum;
import by.Khadasevich.Student.Form.SpecialityEnum;
import by.Khadasevich.Student.Student;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.testng.Assert;
import org.testng.annotations.*;

public class Tests {

    private Student student;

    @BeforeSuite
    public void testBeforeSuite() {
        System.out.println("@BeforeSuite");
    }

    @BeforeTest
    public void testBeforeTest() {
        System.out.println("@BeforeTest");
        student = new Student("Светлана", SpecialityEnum.POIT, 2, FormEnum.DAY, 6.7);
    }

    public int sum(int a, int b) {
        int c = a + b;
        return c;
    }

    @BeforeGroups
    public void testBeforeGroups() {
        System.out.println("@BeforeGroups");
    }

    @BeforeClass
    public void testBeforeClass() {
        System.out.println("@BeforeClass");
    }

    @BeforeMethod
    public void testBeforeMethod() {
        System.out.println("@BeforeMethod");
    }


    @AfterSuite
    public void testASuite() {
        System.out.println("@AfterSuite");
    }

    @AfterTest
    public void testATest() {
        System.out.println("@AfterTest");
    }

    @AfterGroups
    public void testAGroups() {
        System.out.println("@AfterGroups");
    }

    @BeforeClass
    public void testAClass() {
        System.out.println("@AfterClass");
        Student st = new Student("Светлана", SpecialityEnum.POIT, 3, FormEnum.DAY, 6.7);
        Decan jc = Decan.getInstance();
        RemedialStream s = jc.FactoryMethod("First");
        s.AddStudent(st);
        jc.CounntCourses(s);
    }

    @AfterMethod
    public void testAMethod() {
        System.out.println("@AfterMethod");
    }

    // тест конструктора
    @Ignore()
    @Test(alwaysRun = true)
    public void testObject() {
        try {
            if (student == null)
                throw new NullPointerException();
            Assert.assertEquals(student.getSurname(), "Dmitry");
            Assert.assertEquals(student.getCourse(), 2);
            System.out.println("@Test");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

//    проверка сеттера

    @Test()
    private void setgetTest() throws Exception {
        student.setCourse(1);
        Assert.assertEquals(student.getCourse(), 1, 0.5);
    }

    //    assert
    @Test(enabled = true)
    public void ExTst() {
        Assert.fail();
    }

    //timeout
    @Test(timeOut = 100)
    public void ignoredTest() {
        System.out.println("Ignored");
    }

    //groups
    @Test(groups = {"Group"})
    public void test1Group() {
        System.out.println("method 1 test in group");
    }

    @Test(groups = {"Group"})
    public void test2Group() {
        System.out.println("method 2 test in group");
    }

    @Test(dependsOnGroups = "Group")
    public void testGroup() {
        System.out.println("Group test");
    }


    @DataProvider(name = "tdata")
    public Object[][] CreateData() {
        return new Object[][]{
                {1, 2, 3},
                {2, 3, 5},
                {3, 3, 7}
        };
    }

    @Test(dataProvider = "tdata")
    public void testAdd(int a, int b, int c) throws Exception {
        Assert.assertEquals(c, sum(a, b), 3);
        System.out.println(a + " + " + b + " = " + c);
    }

    @Test
    public void TestClass() throws Exception{
        Student st1 = new Student("Светлана", SpecialityEnum.POIT, 3, FormEnum.DAY, 6.7);
        Student st2 = new Student("Владимир", SpecialityEnum.POIT, 3, FormEnum.DAY, 6.0);
        Assert.assertNotSame(st1, st2);
    }
}
