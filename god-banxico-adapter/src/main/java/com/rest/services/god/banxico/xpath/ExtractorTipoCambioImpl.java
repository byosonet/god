package com.rest.services.god.banxico.xpath;

import com.rest.services.god.banxico.adapter.BanxicoTipoCambioAdapter.Moneda;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.namespace.NamespaceContext; 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author emartinez
 */
public class ExtractorTipoCambioImpl implements ExtractorTipoCambio {
    public static ExtractorTipoCambioImpl getInstace(){
        return ExtractorTipoCambioImpl.InstanceHolder.SINGLETON;
    }
    private ExtractorTipoCambioImpl(){}
    private static final class InstanceHolder{
        private static final ExtractorTipoCambioImpl SINGLETON=new ExtractorTipoCambioImpl();
    }
    public String extraer(String xml,Moneda moneda) throws Exception {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        //System.out.println(" -- Xml: "+xml);
        Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));

        XPathFactory factory = XPathFactory.newInstance();
      
        XPath xpath = factory.newXPath();
        xpath.setNamespaceContext(BanxicoTipoCambioNamespaceContext.getInstance());
        XPathExpression expr = xpath.compile("//bm:Series[@IDSERIE='"+moneda.getIdSerie()+"']/bm:Obs/@OBS_VALUE");
        
        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        return nodes.item(0).getNodeValue();
    }
    public static class BanxicoTipoCambioNamespaceContext implements NamespaceContext{
        
        private BanxicoTipoCambioNamespaceContext(){
            this.prefixesMap=new HashMap<String, String>();
            this.prefixesMap.put("ns1", "http://www.SDMX.org/resources/SDMXML/schemas/v1_0/message");
            this.prefixesMap.put("bm", "http://www.banxico.org.mx/structure/key_families/dgie/sie/series/compact");
            this.prefixesMap.put("ns3", "http://www.SDMX.org/resources/SDMXML/schemas/v1_0/compact");
        }
        public String getNamespaceURI(String prefix) {
            return this.prefixesMap.get(prefix);
        }

        public String getPrefix(String namespaceURI) {
            for(String prefix:this.prefixesMap.keySet()){
                if(this.prefixesMap.get(prefix).equals(namespaceURI))return prefix;
            }
            return null;
        }

        public Iterator getPrefixes(String namespaceURI) {
            return this.prefixesMap.keySet().iterator();
        }
        public static BanxicoTipoCambioNamespaceContext getInstance(){
            return BanxicoTipoCambioNamespaceContext.InstanceHolder.SINGLETON;
        }
        private Map<String,String>prefixesMap;
        private static final class InstanceHolder{
            private static final BanxicoTipoCambioNamespaceContext SINGLETON=new BanxicoTipoCambioNamespaceContext();
        }
    }
}
