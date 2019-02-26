/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadXML;
import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;   
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

/**
 *
 * @author Kushagra
 */
public class ReadXML {
    public static void main(String[] args)throws Exception
    {
        Scanner sc = new Scanner(System.in);
        
        
        String name,email;
        int k;
        System.out.println("\t***WELCOME TO COMPUTER ADAPTIVE LEARNING PLATFORM BY Appricod Technologies");
            
        System.out.println("Enter your name: ");
        name=sc.next();
        
        System.out.println("Enter your email");
        email=sc.next();
        
        System.out.println("Press Y if you want to begin the test");
        k=sc.next().charAt(0);
        
        if(k=='Y'|| k=='y')
        {
            
        
        
        
        File xmlFile = new File("C:\\Users\\Kushagra\\Documents\\NetBeansProjects\\CAT\\src\\CAT\\data.html");
       DocumentBuilderFactory  documentBuilderFactory =  DocumentBuilderFactory.newInstance();
       DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);
        
        NodeList list = document.getElementsByTagName("QS");
        
        
        for(int i=0; i<list.getLength(); i++)
        {
            String f;
            Node node = list.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                
                Element element = (Element) node;
                String id = element.getAttribute("id");
                NodeList nameList = element.getChildNodes();
                for(int j=0; j<nameList.getLength();j++)
                {
                    Node n = nameList.item(j);
                    if(n.getNodeType()==Node.ELEMENT_NODE){
                        Element names = (Element) n;
                        
                        
                System.out.println("Question:"+names.getAttribute("QS"));
                
                System.out.println("question:"+names.getElementsByTagName("question").item(i).getTextContent());
                System.out.println("Options:\n"+names.getElementsByTagName("options").item(i).getTextContent());
                System.out.println("Enter Your option: ");
                f=sc.next();
                if(f.compareTo(names.getElementsByTagName("answer").item(i).getTextContent())==0)
                {
                    System.out.println("Correct");
                }
                else
                {
                    System.out.println("False");
                }
                
            }}}
        }
       
    }
        else
        {
            System.out.println("Can't start the test");
        }
    }
    
    
}
