package pe.edu.tecsup.hibernate;

import java.util.List;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.tecsup.hibernate.dao.CursoDAO;
import pe.edu.tecsup.hibernate.model.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoDAOTests {

    @Autowired
    CursoDAO cursoDAO;

 
   public void verifyList() {

        List<Curso> cursos = cursoDAO.list();
        for (Curso curso:cursos) {
            System.out.println(curso.getNombre()+"-"+curso.getFechaInicio());
        }
        Assert.assertTrue(cursos.size() > 0);
    }

 //  @Test
    public void verifyFind() {
        Curso cursos = cursoDAO.get(4l);
        System.out.println(cursos.getNombre());
        Assert.assertTrue(cursos.getId() == 4l);
              
    }


   
  //  @Test
    public void verifySave() {

        Curso curso= new Curso();
        curso.setCodigo("1027");
        curso.setNombre("Nuevo Curso Tecsup");
        cursoDAO.save(curso);
        Assert.assertTrue(curso.getId() != null);
    }

        
  // @Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Curso curso = new Curso();
        curso.setId(41l);
        curso.setCodigo("1027");
        curso.setNombre("Curso Modificado Tecsup");

        cursoDAO.update(curso);
        Assert.assertTrue(cursoDAO.get(41l).getCodigo().equals("1027"));
    }

    
  // @Test
    public void verifyDelete() {

        Curso programa = new Curso();
        programa.setId(41l);
        cursoDAO.delete(programa);

        Assert.assertTrue(cursoDAO.get(41l) == null);
    }
    
}
