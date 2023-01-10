package otherHomework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader {
//    public static void main(String[] args) {
//
//        BufferedWriter writer;
//
//        {
//            try {
//                writer = new BufferedWriter(new FileWriter("Prueba.txt")); //si lo quiero poner en otro lado que no sea el archivo, pongo el absolute path
//                writer.write("In the fifth year of his reign, the king changed his name from Amenhotep (“Amon Is Content”)\n" +
//                        "to Akhenaten (“Beneficial to Aton”).Nefertiti’s name was expanded to Neferneferuaten\n" +
//                        "(“Beautiful Is the Beauty of Aton”)-Nefertiti. That same year Akhenaten moved his capital to a new site some 200 miles\n" +
//                        "(300 km) north of Thebes. The location chosen for the new capital, named Akhetaton (“Horizon of the Aton”;\n" +
//                        "Tell el-Amarna), was a virgin site on the east bank of the Nile River, a large desert embayment enclosed by limestone\n" +
//                        "cliffs, in which a series of boundary stelae were carved. The boundary texts, dated the fifth, sixth, and eighth years\n" +
//                        "of his rule, describe the planned city in some detail and reveal Akhenaten’s primary intention: to construct a city\n" +
//                        "dedicated to the worship of the Aton separate from already established cults.");
//
//
//                writer.close(); //siempre hay que cerrarlo para que funcione
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//                //e.printStackTrace();
//
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        }
//
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("Prueba.txt"));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//            reader.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}