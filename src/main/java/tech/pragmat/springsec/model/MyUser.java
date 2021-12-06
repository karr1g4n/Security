package tech.pragmat.springsec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String password;

    private String role;

    //    @ManyToMany(fetch = FetchType.EAGER)
    //    private List<MyRole> myRoleList;
    //
    //    public String getRol(){
    //        System.out.println(myRoleList.get(0).getName());
    //        return myRoleList.get(0).getName();
    //    }
}
