package interfaces;

import java.util.List;
 
public interface DAO {
 
    public boolean save(Object dao);
 
    public boolean delete(Integer id, Class clazz);
 
    public Object findById(Integer id, Class clazz);
     
    public List findAll(String query);
     
}