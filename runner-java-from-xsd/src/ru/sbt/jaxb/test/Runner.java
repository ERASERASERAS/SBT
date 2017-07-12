package ru.sbt.jaxb.test;

import classesFromXSD.EmailArtifact;
import classesFromXSD.ObjectFactory;
import javax.xml.bind.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;

/**
 * Created by usersbt on 05.07.2017.
 */
public class Runner {
    public static void main(String[] args) throws JAXBException {
        ObjectFactory objectFactory = new ObjectFactory();
        EmailArtifact ea = objectFactory.createEmailArtifact();
        ea.setBcc("bcc");
        ea.setFrom("fromjaxb");

        //todo step1 this element need to convert to xml and print it to sout
        saveObject(new File("save.xml"),ea);
       EmailArtifact ea1 = (EmailArtifact) getObject(new File("save.xml"), EmailArtifact.class);
        System.out.println(ea1.getBcc());
        System.out.println(ea1.getFrom());

    }


    public static Object getObject(File file, Class c) throws JAXBException {
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
