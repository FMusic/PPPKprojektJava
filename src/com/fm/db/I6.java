package com.fm.db;

import com.fm.dbRepo.RepoManager;
import com.fm.model.FuelsList;
import com.fm.model.generated.FuelsEntity;
import com.fm.model.generated.RoutesEntity;
import com.fm.model.generated.TravelWarrantsEntity;
import com.fm.pdf.PDFUtils;
import org.hibernate.Session;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.query.Query;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

public class I6 {

    public static String getXmlReceipts() {
        StringWriter sw = new StringWriter();
        FuelsList fuelsList = new FuelsList();
        Session s = RepoManager.getSession();
        Query q = s.createQuery("from FuelsEntity");
        List<FuelsEntity> lista = (List<FuelsEntity>)q.list();
        fuelsList.setFuels(lista);
        try{
            JAXBContext context = JAXBContext.newInstance(FuelsList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(fuelsList, sw);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    public static boolean saveXmlReceipts(String xmlReceipt){
        FuelsList fuels = null;
        try {
            JAXBContext context = JAXBContext.newInstance(FuelsList.class);
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlReceipt);
            fuels = (FuelsList)jaxbUnmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        if (fuels != null){
            saveListToDatabase(fuels.getFuels());
            return true;
        }
        return false;
    }

    private static void saveListToDatabase(List<FuelsEntity> fuels) {
        Session s = RepoManager.getSession();
        s.beginTransaction();
        fuels.forEach(x->{
            s.save(x);
        });
        s.getTransaction().commit();
        RepoManager.closeSession();
    }

    public static void getPdfForWarrant(TravelWarrantsEntity tw, String path) throws IOException {
        String qs = "from RoutesEntity where travelWarrantsByWarrantId = " + tw.getIdTwarrant();
        Session s = RepoManager.getSession();
        Query q = s.createQuery(qs);
        PDFUtils.savePDFFileForWarrant(tw, (List<RoutesEntity>) q.list(), path);
    }

    public static List<TravelWarrantsEntity> getAllWarrants(){
        String qs = "from TravelWarrantsEntity";
        Session s = RepoManager.getSession();
        Query q = s.createQuery(qs);
        return ((List<TravelWarrantsEntity>) q.list());
    }
}
