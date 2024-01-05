/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package maassystemoop;

import java.util.List;

/**
 *
 * @author user1
 */
public interface IEmploye {
    //programamızdan databese biblgileri ekliyour
    public void save(Eleman elemann);
    //bilgilerimiz databese eklediktan sonra  bu methot uzerinden güncelleme yapabeliriz
    public void update(Eleman elemann);
     //bilgilerimiz databese eklediktan sonra  bu methot uzerinden silme yapabeliriz
    public void delete(Eleman elemann);
    public Eleman get(int id);
    //
    public List<Eleman> list();
    
}
