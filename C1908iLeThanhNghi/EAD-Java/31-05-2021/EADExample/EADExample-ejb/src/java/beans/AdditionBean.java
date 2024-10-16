/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class AdditionBean implements AdditionBeanRemote {
    @Override
    public int add2Numbers(int x, int y) {
        return x + y;
    }
    
}
