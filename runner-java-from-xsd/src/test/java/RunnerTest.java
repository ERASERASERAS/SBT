import classesFromXSD.Artifact;
import classesFromXSD.EmailArtifact;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;



/**
 * Created by usersbt on 05.07.2017.
 */


@RunWith(Parameterized.class)
public class RunnerTest {

    //@BeforeClass
    //public void testStart(){
        //System.out.println("Тест для " + pathToObject + " начался");
    //}

    //@AfterClass
   // public void testEnd(){
        //System.out.println("Тест для " + pathToObject + " закончился");
    //}

    EmailArtifact someArtifact;
    String pathToObject;

    public RunnerTest(String pathToObject) throws JAXBException {
        someArtifact = (EmailArtifact) getObject(new File(pathToObject), Artifact.class);
        this.pathToObject = pathToObject;
        String s = someArtifact.getClass().toString();
    }




    //todo
    @Test()
    public void testSomething() throws JAXBException {
        saveObject(new File(pathToObject), someArtifact);
        EmailArtifact rebuiltObj = (EmailArtifact) getObject(new File(pathToObject), EmailArtifact.class);
        Assert.assertEquals(someArtifact.getArtifactId(), rebuiltObj.getArtifactId());
        Assert.assertEquals(someArtifact.getArtifactType(), rebuiltObj.getArtifactType());
        Assert.assertEquals(someArtifact.getContentHash(), rebuiltObj.getContentHash());
    }

    @Test(expected = ArithmeticException.class)
    public void testForDivideByZero() throws JAXBException {
        int i = new Integer(someArtifact.getArtifactId()) / 0;
    }




    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {"./src/test/resources/ea1.xml"},
                {"./src/test/resources/ea2.xml"},
                {"./src/test/resources/ea3.xml"}
        });
    }

    public static Object getObject(File file, Class c) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(file);
        return object;
    }

    public static void saveObject(File file, Object o) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(o,file);
    }




}
