/*
 * AlumnoRepository
 */
package ar.com.eduit.curso.java.repositories.implementacion.sql;

import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.repositories.interfaces.I_AlumnoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlumnoR implements I_AlumnoRepository {
    
    private Connection conn;
    
    public AlumnoR(Connection conn) { this.conn = conn; }

    @Override
    public void save(Alumno alumno) {
        
        if(alumno == null) return;
        
        /*
        //Lo que no debemos hacer. Muy facil equivocarse y es inseguro. Permite una inyeccion sql.
        String sql = "insert into alumnos(nombre, apellido, edad, idCurso) values "
                + "('"+alumno.getNombre()+"','"+alumno.getApellido()+"',"+
                alumno.getEdad()+","+alumno.getIdCurso()+",)";
        //apellido = "x',20,1); delete from alumnos;-- " con una inyeccion sql borra las tablas.
        */
        
        //Se recomienda usar PreparedStatement a partir de Java 6
        //Delega el control de seguridad a Java.
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into alumnos (nombre,apellido,edad,idCurso) values (?,?,?,?)",//1 //1 significa que quiero que me devuelva el id generado
                PreparedStatement.RETURN_GENERATED_KEYS //Esto es lo mismo que el 1.
        )) {
        ps.setString(1, alumno.getNombre());
        ps.setString(2, alumno.getApellido());
        ps.setInt(3, alumno.getEdad());
        ps.setInt(4, alumno.getIdCurso());
        ps.execute(); //Ejecuta la query
        ResultSet rs = ps.getGeneratedKeys(); //Pido las claves generadas
        if(rs.next()) alumno.setId(rs.getInt(1)); //si se generó clave le pido el id.
        
        } catch (Exception e) { System.out.println(e);  }        
    }

    @Override
    public void remove(Alumno alumno) {
        
    }

    @Override
    public void update(Alumno alumno) {
        
    }

    @Override
    public Alumno getById(int id) {
        List<Alumno> lista = getByFiltro("id= "+id);
        return (lista.isEmpty()) ? null : lista.get(0);
    }

    @Override
    public List<Alumno> getAll() { return getByFiltro("1=1"); }

    @Override
    public List<Alumno> getByApellido(String apellido) { return getByFiltro("apellido='"+"'"); }

    @Override
    public List<Alumno> getLikeApellido(String apellido) { return getByFiltro("apellido like '%"+apellido+"%'"); }

    @Override
    public List<Alumno> getLikeApellidoNombre(String apellido, String nombre) {
        return getByFiltro("apellido like '%"+apellido+"%' and nombre like '%"+nombre+"%'");
    }

    @Override
    public List<Alumno> getByCurso(int idCurso) {
        return getByFiltro("idCurso="+idCurso);
    }

    @Override
    public List<Alumno> getByCurso(Curso curso) {
        return getByCurso(curso.getId());
    }
    
    private List<Alumno> getByFiltro(String filtro){ //Se va a poner toda la logica para poner la query.
        List<Alumno> lista = new ArrayList();
        
        String sql = "select * from alumnos where " + filtro;
        
        try (ResultSet rs = conn.createStatement().executeQuery(sql)) {
            while(rs.next()){
                lista.add(new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getInt("idCurso")
                ));
            }
        } catch (Exception e) { System.out.println(e); }        
        return lista;
    }
    
}
