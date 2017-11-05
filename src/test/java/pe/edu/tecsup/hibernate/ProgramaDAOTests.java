package pe.edu.tecsup.hibernate;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.tecsup.hibernate.dao.ProgramaDAO;
import pe.edu.tecsup.hibernate.model.Programa;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgramaDAOTests {

    @Autowired
    ProgramaDAO programaDAO;

   // @Test
    public void verifyList() {

        List<Programa> programas = programaDAO.list();
        for (Programa programa : programas) {
            System.out.println(programa.getNombre());
        }
        Assert.assertTrue(programas.size() > 0);
    }

    
    //@Test
    public void verifyFind() {
        Programa programa = programaDAO.get(4l);
        System.out.println(programa.getNombre());
        Assert.assertTrue(programa.getId() == 4l);
    }


  
    //@Test
    public void verifySave() {

        Programa programa = new Programa();
        programa.setCodigo("1025");
        programa.setNombre("Nuevo Programa Tecsup");
        programa.setDescripcion("Prueba");

        programaDAO.save(programa);
        Assert.assertTrue(programa.getId() != null);
    }

        
    //@Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Programa programa = new Programa();
        programa.setId(1l);
        programa.setCodigo("1025");
        programa.setNombre("Programa Modificado Tecsup");

        programaDAO.update(programa);
        Assert.assertTrue(programaDAO.get(69l).getCodigo().equals("1025"));
    }

    
    @Test
    public void verifyDelete() {

        Programa programa = new Programa();
        programa.setId(69l);
        programaDAO.delete(programa);

        Assert.assertTrue(programaDAO.get(69l) == null);
    }

}
