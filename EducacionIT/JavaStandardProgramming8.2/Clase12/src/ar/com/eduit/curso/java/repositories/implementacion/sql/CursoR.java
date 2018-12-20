package ar.com.eduit.curso.java.repositories.implementacion.sql;

import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.enums.Semana;
import ar.com.eduit.curso.java.enums.Turnos;
import ar.com.eduit.curso.java.repositories.interfaces.I_CursoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoR implements I_CursoRepository{
    private Connection conn;

    public CursoR(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Curso curso) {
        if(curso == null) return;
        try(PreparedStatement ps = conn.prepareStatement(
                "insert into cursos (titulo,profesor,dia,turno) values (?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
        )){
            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getProfesor());
            ps.setString(3, curso.getDia().toString());
            ps.setString(4, curso.getTurno().toString());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys(); //Se hace despues de ejecutar porque antes no esta generada la clave.
            if(rs.next()) curso.setId(rs.getInt(1)); //Pido la primer clave generada en caso de haber mas de una.
        }catch(Exception e){ System.out.println(e); }
    }

    @Override
    public void remove(Curso curso) {
        if(curso==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from cursos where id=?")){
            ps.setInt(1, curso.getId());
            ps.execute();
        } catch (Exception e) {System.out.println(e); }
        
    }

    @Override
    public void update(Curso curso) {
        if(curso==null) return;
        try (PreparedStatement ps = conn.prepareStatement(
                "update cursos set titulo=?, profesor=?, dia=?, turno=? where id=?"
        )){
            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getProfesor());
            ps.setString(3, curso.getDia().toString());
            ps.setString(4, curso.getTurno().toString());
            ps.setInt(5, curso.getId());
            ps.execute();
        } catch (Exception e) { System.out.println(e); }
    }

    @Override
    public Curso getById(int id) {
        List<Curso> lista = getByFiltro("id="+id);
        return (lista.isEmpty()) ? null : lista.get(0);
    }

    @Override
    public Curso getByAlumno(int idAlumno) {
        return getById(new AlumnoR(conn).getById(idAlumno).getIdCurso());
    }

    @Override
    public Curso getByAlumno(Alumno alumno) {
        return getByAlumno(alumno.getIdCurso());
    }

    @Override
    public List<Curso> getAll() {
        return getByFiltro("1=1");
    }

    @Override
    public List<Curso> getByTitulo(String titulo) {
        return getByFiltro("titulo="+titulo+"'");
    }

    @Override
    public List<Curso> getLikeTitulo(String titulo) {
        return getByFiltro("titulo like '%"+titulo+"%'");
    }

    @Override
    public List<Curso> getByProfesor(String profesor) {
        return getByFiltro("profesor = '"+profesor+"'");
    }

    @Override
    public List<Curso> getLikeProfesor(String profesor) {
        return getByFiltro("profesor like '%"+profesor+"%'");
    }

    @Override
    public List<Curso> getLikeTituloProfesor(String titulo, String profesor) {
        return getByFiltro("titulo like '%"+titulo+"%' and profesor like '%"+profesor+"%'");
    }

    @Override
    public List<Curso> getLikeTituloProfesorDiaTurno(String titulo, String profesor, Semana dia, Turnos turno) {
        return getByFiltro("titulo like '%"+titulo+"%' and profesor like '%"+profesor+"%' and "
                + "dia = '"+dia.toString()+"' and turno = '"+turno.toString()+"'");
    }
    
    private List<Curso> getByFiltro(String filtro){
        List<Curso> lista = new ArrayList();
        String query = "select * from cursos where " + filtro;
        
        try (ResultSet rs = conn.createStatement().executeQuery(query)){
            while(rs.next()){
                lista.add(
                    new Curso(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("profesor"),
                            Semana.valueOf(rs.getString("dia").toUpperCase()),
                            Turnos.valueOf(rs.getString("turno").toUpperCase())
                    )
                );
            }
        } catch (Exception e) { System.out.println(e); }
        
        return lista;
    }
    
}
